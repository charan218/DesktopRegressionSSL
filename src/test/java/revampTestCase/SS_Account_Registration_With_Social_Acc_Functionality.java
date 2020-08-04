package revampTestCase;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import appModules.Registration_Action;
import pageObjects.BaseClass;
import pageObjects.Home_Page;
import pageObjects.Registration_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;

/**
 * the following class cover the scenarios like 1.Register with Facebook (upto
 * navigation of Facebook login page) 2.Register with Google (upto navigation of
 * Google login page)
 * 
 * @author samba
 *
 */
public class SS_Account_Registration_With_Social_Acc_Functionality {

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
			Home_Page.cookie_Popup().click();
			Utils.waitForElementPresence(Home_Page.LoginRegister());
			Utils.mouseHover(Home_Page.LoginRegister());
			Utils.jsClick(Home_Page.SignUp());
			System.out.println("Clicked on SignUp Button");
		} catch (Exception e) {
			BaseClass.errorValidation += "Unable to clicked on Sign Up Link \n";
		}
		try {
			Log.info("Going to click on Google Icon");
			Registration_Page.googleIcon().click();
			Log.info("Going to Verify google page opening or not");
			Thread.sleep(2000);
			Utils.NewWindowActionURLValidateWithURL("//accounts.google.com/");
			Log.info("Going to click on Facebook Icon");
			Registration_Page.faceBookIcon().click();
			Thread.sleep(2000);
			Log.info("Going to Verify Facebook page opening or not");
			Utils.NewWindowActionURLValidateWithURL("https://www.facebook.com/");
			ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.result);
			BaseClass.passedTC = BaseClass.passedTC + 1;
		} catch (Exception e) {
			BaseClass.tcFailReasons = BaseClass.tcFailReasons.append(sTestCaseName + ":-" + "<b>e</b><br>" + "\n");
			BaseClass.failedTC = BaseClass.failedTC + 1;
			Log.error("Registration process not successful");
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
