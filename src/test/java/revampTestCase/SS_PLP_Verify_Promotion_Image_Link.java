package revampTestCase;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import appModules.HomePage_Action;
import appModules.PLP_Action;
import pageObjects.BaseClass;
import utility.Constant;
import utility.ExcelUtils;
import utility.JyperionListener;
import utility.Log;
import utility.Utils;

/**
 * 
 * <h2 style=
 * "text-align:center;">SS_PLP_Verify_Promotion_Image_Link</h2>
 * <p style="font-size:19px">
 * <b>Description -</b>This Test case verify promotion image  link functionality
 * and validate whether image link is navigated to the respected page
 * </p>
 * <TABLE width="100%" border="1">
 * <caption style="font-size:17px">Parameter List</caption>
 * <tr>
 * <th>Parameters</th>
 * <th>Description</th>
 * </tr>
 * <tr>
 * <td>browser</td>
 * <td>Browser name in which test execution starts</td>
 * </tr>
 * <tr>
 * <td>emailId</td>
 * <td>Email id of the user</td>
 * </tr>
 * 
 * <tr>
 * <td>password</td>
 * <td>password of the user</td>
 * </tr>
 * </table>
 * <br>
 * <br>
 * 
 */
@Listeners(JyperionListener.class)
public class SS_PLP_Verify_Promotion_Image_Link {


	public WebDriver Driver;
	private String sTestCaseName;
	private int iTestCaseRow;

	@BeforeSuite
	public void setSnapShotFolder() throws Exception {
		Utils.setSnapshotFolder();

	}

	@org.testng.annotations.BeforeMethod
	public void BeforeMethod() throws Exception {
		DOMConfigurator.configure("log4j.xml");

		sTestCaseName = Utils.getTestCaseName(this.toString());
		Log.info(sTestCaseName + " Test case to be excuted");
		ExcelUtils.setExcelFile(Utils.ReadProperties(Constant.Path_ConfigProperties).getProperty("Path_TestData")
				+ Constant.File_TestData, "Sheet1");
		iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName, Constant.testCaseName);
		System.out.println( ExcelUtils.getCellData(iTestCaseRow, Constant.searchField));
		System.out.println(ExcelUtils.getCellData(iTestCaseRow, Constant.reviewTitle));
		Log.info("New driver instantiated " + iTestCaseRow);
		Log.startTestCase(sTestCaseName);
		Driver = Utils.OpenBrowser(iTestCaseRow);
		new BaseClass(Driver);
	}

	@Test
	public void main() throws Exception {

		try {
			Log.info("verifiaction of promtion imgae link is stared");
			HomePage_Action.selectProductCategoryfromMenu(iTestCaseRow);
			Log.info("Product Listing Page opened");
			PLP_Action.PLP_Verify_Promotion_Image_Link(iTestCaseRow);
			ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.result);
			Log.info("Verification Promotion_Image_Link link in home  page  successfull");
			Utils.captureScreenshot(sTestCaseName, "Pass", "Verify item count for guest user Screenshot");
			BaseClass.passedTC=BaseClass.passedTC+1;
		} catch (Exception e) {
			BaseClass.tcFailReasons=BaseClass.tcFailReasons.append(sTestCaseName + ":-" +e + "\n");
			 BaseClass.failedTC=BaseClass.failedTC+1;
			Log.info("Verification  Promotion_Image_Link link in home  page  failed");
			ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.result);
			Utils.captureScreenshot(sTestCaseName, "Fail", "Failed");
			Log.error(e.getMessage());
			throw e;
			
		}
	}

	@AfterMethod
	public void afterMethod() {

		Log.endTestCase(sTestCaseName);

		Driver.close();

	}
	
	
}
