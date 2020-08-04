package revampTestCase;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.BaseClass;
import pageObjects.Home_Page;
import pageObjects.Static_Page;
import appModules.HomePage_Action;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;
import utility.JyperionListener;

/**
 * 
 * <h2 style="text-align:center;">SS_Header_Public_Verify_SSLogo_Functionality</h2>
 * <p style="font-size:19px"><b>Description -</b>This Test Case verifies SSL logo functionality on main header.</p>
 * <TABLE width="100%" border="1">
 * <caption style="font-size:17px">Parameter List</caption>
 * <tr><th>Parameters</th><th>Description</th></tr>
 * <tr><td>browser</td><td>Browser name in which test execution starts</td></tr>
 * </table>
 * <br>
 * <br>
 * Auto suggestion is not working
 * 
 */
@Listeners(JyperionListener.class)
public class SS_HomePage_HeaderValidation {

	public WebDriver Driver;
	private String sTestCaseName;
	private int iTestCaseRow;
	
	@BeforeSuite
	public void setSnapShotFolder() throws Exception {
//		Utils.archive_Old_Report();
		Utils.setSnapshotFolder();		
	}

	@BeforeMethod
	public void BeforeMethod() throws Exception {
		DOMConfigurator.configure("log4j.xml");

		sTestCaseName = Utils.getTestCaseName(this.toString());
		Log.info(sTestCaseName + " Test case to be excuted");
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
			try {
				Home_Page.cookie_Popup().click();
			}
			catch(Exception e)
			{
				Log.error("Cookie Popup not found");
			}
			System.out.println("Starting Test Case :  --" + sTestCaseName);
			HomePage_Action.Header_Public_Verify_SearchBox_Field(iTestCaseRow);
			HomePage_Action.Header_Public_Verify_SearchBox_Field_functionality(iTestCaseRow);
			HomePage_Action.Header_Public_Verify_TrackOrder_Page_Functionality(iTestCaseRow);

			System.out.println("Validation of Track Order Page Completed");
			HomePage_Action.Header_Public_Verify_SSL_Logo_Functionality(iTestCaseRow);
			System.out.println("Validation of SS_Logo Completed");

			HomePage_Action.Header_Public_Verify_headerInfoBar_Functionality(iTestCaseRow);
			System.out.println("Validation of headerInfoBar Completed");
			HomePage_Action.Header_Public_Verify_StoreLocator_Page_Functionality(iTestCaseRow);
			System.out.println("Validation of Store Locator Page Completed");
			HomePage_Action.Header_Public_Verify_SearchBox_Field(iTestCaseRow);
			System.out.println("Validation of Search Box Completed");
			HomePage_Action.Header_Public_Verify_Wishlist_Functionality(iTestCaseRow);
			System.out.println("Validation of Wishlist Icon Completed");
			HomePage_Action.Header_Public_Verify_ContactUs_Functionality();
			System.out.println("Validation of Contact Us Completed");
			HomePage_Action.Header_Public_Verify_Minicart_Functionality(iTestCaseRow);
			System.out.println("Validation of Mini Cart Icon Completed");
			Thread.sleep(2000);
			Home_Page.headerSoppersStopLogocheckout().click();
			Utils.waitForPageLoad();
			Thread.sleep(5000);
			HomePage_Action.stickyHeader_Validation(iTestCaseRow);

			if (BaseClass.errorValidation.isEmpty()) {

				ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.result);
			} else {

				throw new Exception(BaseClass.errorValidation);
			}
			System.out.println("Ending Test Case :  --" + sTestCaseName);
			BaseClass.passedTC=BaseClass.passedTC+1;
		} catch (Exception e) {
			BaseClass.tcFailReasons=BaseClass.tcFailReasons.append(sTestCaseName + ":-" +e + "\n");
			BaseClass.failedTC=BaseClass.failedTC+1;
			Log.error(BaseClass.errorValidation);
			ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.result);
			Utils.captureScreenshot(sTestCaseName, "Fail", "Failed");
			Log.error(e.getMessage());
			throw (e);
		}
	}

	@AfterMethod
	public void afterMethod() {

		Log.endTestCase(sTestCaseName);
		Driver.quit();
	}

}
