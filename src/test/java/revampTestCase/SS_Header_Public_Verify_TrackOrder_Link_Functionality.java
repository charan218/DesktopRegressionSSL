package revampTestCase;	/**
 * 
 * <h2 style="text-align:center;">SS_Header_Public_Verify_TrackOrder_Link_Functionality</h2>
 * <p style="font-size:19px"><b>Description -</b>This Test Case verifies order status of the order number on track order page.</p>
 * <TABLE width="100%" border="1">
 * <caption style="font-size:17px">List of columns used from excel file</caption>
 * <tr><th>Parameters</th><th>Description</th></tr>
 * <tr><td>browser</td><td>Browser name in which test execution starts</td></tr>
 * <tr><td>productCategory</td><td>Product category available on main menu</td></tr>
 * <tr><td>productSubCategory</td><td>Product sub category available under the main menu</td></tr>
 * </table>
 * <br>
 * <br>
 * 
 */ 

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import appModules.Cart_Action;
import appModules.HomePage_Action;
import appModules.Login_App;
import pageObjects.BaseClass;
import pageObjects.Home_Page;
import pageObjects.ProductListing_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.JyperionListener;
import utility.Log;
import utility.Utils;
@Listeners(JyperionListener.class)
public class SS_Header_Public_Verify_TrackOrder_Link_Functionality {
	
	public WebDriver Driver;
	private String sTestCaseName;
	private int iTestCaseRow;
	@BeforeSuite
	public void setSnapShotFolder() throws Exception {
		Utils.setSnapshotFolder();

	}

	@BeforeMethod
	public void BeforeMethod() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		sTestCaseName = Utils.getTestCaseName(this.toString());
		Log.info(sTestCaseName + " Test case to be executed");
		ExcelUtils.setExcelFile(Utils.ReadProperties(Constant.Path_ConfigProperties).getProperty("Path_TestData")
				+ Constant.File_TestData, "Sheet1");
		iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName, Constant.testCaseName);
		Log.info("New driver instantiated " + iTestCaseRow);
		Log.startTestCase(sTestCaseName);
		Driver = Utils.OpenBrowser(iTestCaseRow);
		new BaseClass(Driver);
	}

	@Test
	public void main() throws Exception {
		try {
			String orderno=	ExcelUtils.getCellData(iTestCaseRow, Constant.orderNo);
			String emailid=	ExcelUtils.getCellData(iTestCaseRow, Constant.emailId);
			HomePage_Action.verify_TrackOrder_page_functionality(emailid, orderno);
			ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.result);
			Log.info("Verification for order details for guest user successfull");
			Utils.captureScreenshot(sTestCaseName, "Pass", "Verify item count for guest user Screenshot");
			BaseClass.passedTC=BaseClass.passedTC+1;
		} catch (Exception e) {
			BaseClass.tcFailReasons=BaseClass.tcFailReasons.append(sTestCaseName + ":-" +e + "\n");
			 BaseClass.failedTC=BaseClass.failedTC+1;
			Log.info("Verification ordr deatils for  guest user failed");
			ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.result);
			Utils.captureScreenshot(sTestCaseName, "Fail", "Failed");
			Log.error(e.getMessage());
			throw e;
		}
	}

	@AfterMethod
	public void afterMethod() {

		Log.endTestCase(sTestCaseName);
		Driver.quit();
	
	
	}
	
}
