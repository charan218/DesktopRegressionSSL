package revampTestCase;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import appModules.CheckOut_Action;
import pageObjects.BaseClass;
import pageObjects.Checkout_Page;
import pageObjects.Home_Page;
import pageObjects.Order_Confirmation_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.JyperionListener;
import utility.Log;
import utility.Utils;

@Listeners(JyperionListener.class)
public class SS_Order_Confirmation_Verify_Complete_Your_Profile_Popup {

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
			Home_Page.cookie_Popup().click();
			System.out.println("Starting Test Case : " + sTestCaseName);
			Utils.HappyPathFlowTillCheckOutPage(iTestCaseRow);
			System.out.println("navigated up to cart page");
			if (ExcelUtils.getCellData(iTestCaseRow, Constant.UserType).equals("Public")) {
				Utils.jsClick(Checkout_Page.LoginDetails.ContinueAsGuest());
				Thread.sleep(3000);
				System.out.println("continue as guest clicked");
				String userEmail = ExcelUtils.getCellData(iTestCaseRow, Constant.emailId);
				Checkout_Page.LoginDetails.LoginEmailGuest().sendKeys(userEmail);
				Log.info("User email id is entered successfully");
				String userPhone = ExcelUtils.getCellData(iTestCaseRow, Constant.mobileNumber);
				Checkout_Page.LoginDetails.GuestMobileNumber().sendKeys(userPhone);
				Checkout_Page.LoginDetails.ContinueBtnGuest().click();
				Log.info("Continue button is clicked");
				Thread.sleep(5000);
//				Utils.waitForElementPresence(Checkout_Page.GuestOTPPopup());
				Thread.sleep(5000);
				try {
					if (Checkout_Page.GuestOTPPopup().isDisplayed()) 
						System.out.println("Otp is required to continue");
				}
				catch(Exception e)
				{
					CheckOut_Action.ProceedwithNewAddress(iTestCaseRow);

					Thread.sleep(3000);
					Checkout_Page.Paymentinfo.COD_PaymentOption().click();
					Thread.sleep(3000);
					Checkout_Page.Paymentinfo.COD_PlaceOrder().click();
				} 
				Thread.sleep(5000);
				Utils.jsClick(Order_Confirmation_Page.feedBackCance_Button());
				Thread.sleep(2000);
				Utils.jsClick(Order_Confirmation_Page.CompleteProfile.completeYourProfile_Button());
				Thread.sleep(6000);
				Utils.waitForElementPresence2(Order_Confirmation_Page.CompleteProfile.completeYourProfile_Text());
				Utils.verifyElement(Order_Confirmation_Page.CompleteProfile.completeYourProfile_Text());
				Thread.sleep(2000);
				String pass= ExcelUtils.getCellData(iTestCaseRow, Constant.password);
				Order_Confirmation_Page.CompleteProfile.setPassword_TextBox().sendKeys(pass);
				Utils.jsClick(Order_Confirmation_Page.CompleteProfile.male_Radio_Button());
				Thread.sleep(1000);
				Utils.jsClick(Order_Confirmation_Page.CompleteProfile.continue_Button());
				Utils.waitForPageLoad();
				if (!BaseClass.errorValidation.isEmpty()) {
					Log.error("Exception in Class Cart_Action ");
					throw new Exception(BaseClass.errorValidation);
				}
				ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.result);
				Log.info("Verification for Checkout_Public_Verify_Happy_Path_CheckOut successfull");
				Utils.captureScreenshot(sTestCaseName, "Pass", "SS_Checkout_Public_Verify_Happy_Path_CheckOut");
				BaseClass.passedTC = BaseClass.passedTC + 1;
			}
		} catch (Exception e) {
			BaseClass.tcFailReasons = BaseClass.tcFailReasons.append(sTestCaseName + ":-" + e + "\n");
			BaseClass.failedTC = BaseClass.failedTC + 1;
			Log.info("Verification for product count in mini cart for guest user failed");
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
