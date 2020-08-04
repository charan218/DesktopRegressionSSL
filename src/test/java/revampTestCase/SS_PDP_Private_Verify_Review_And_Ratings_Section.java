package revampTestCase;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import appModules.HomePage_Action;
import appModules.Login_App;
import appModules.PDP_Action;
import pageObjects.BaseClass;
import pageObjects.Home_Page;
import pageObjects.ProductListing_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;

public class SS_PDP_Private_Verify_Review_And_Ratings_Section {
	
	public WebDriver Driver;
	private String sTestCaseName;
	private int iTestCaseRow;


	@BeforeMethod
	public void BeforeMethod() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		sTestCaseName = Utils.getTestCaseName(this.toString());
		Log.info("Test case to be executed: " + sTestCaseName);
		ExcelUtils.setExcelFile(Utils.ReadProperties(Constant.Path_ConfigProperties).getProperty("Path_TestData")
				+ Constant.File_TestData, "Sheet1");
		iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName, Constant.testCaseName);

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
			System.out.println("Starting Test Case:  " + sTestCaseName);
			Login_App.execute(iTestCaseRow);
			Thread.sleep(8000);
			HomePage_Action.selectProductCategoryfromMenu(iTestCaseRow);
			Utils.waitForPageLoad();
			Thread.sleep(8000);
			ProductListing_Page.product().click();
			Log.info("Product icon is clicked");
			Utils.waitForPageLoad();
			PDP_Action.verify_Reviews_And_Ratings();
			
			ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.result);
			Utils.captureScreenshot(sTestCaseName, "Pass", "Passed");
			BaseClass.passedTC=BaseClass.passedTC+1;

		} catch (Exception e) {
			BaseClass.tcFailReasons=BaseClass.tcFailReasons.append(sTestCaseName + ":-" +e + "\n");
			BaseClass.failedTC=BaseClass.failedTC+1;
			Log.error("Issue in verifying social share option on PDP");
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
