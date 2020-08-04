package revampTestCase;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
//import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pageObjects.BaseClass;
import pageObjects.Cart_Page;
import pageObjects.Checkout_Page;
import pageObjects.Home_Page;
import pageObjects.MiniCart_Page;
import pageObjects.ProductDetails_Page;
import pageObjects.ProductListing_Page;
import appModules.CheckOut_Action;
import appModules.HomePage_Action;
//import pageObjects.Home_Page;
import appModules.Login_App;
import appModules.PDP_Action;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.PDFReport;
//import utility.PDFReport;
import utility.Utils;
/**
 * 
 * <h2 style="text-align:center;">SS_CheckOut_AlreadyLoginUser_OrderUsingNetBanking</h2>
 * <p style="font-size:19px"><b>Description -</b>This Test Case verifies checkout flow using Netbanking for already logged in user</p>
 * <TABLE width="100%" border="1">
 * <caption style="font-size:17px">List of columns used from excel file</caption>
 * <tr><th>Parameters</th><th>Description</th></tr>
 * <tr><td>browser</td><td>Browser name in which test execution starts</td></tr>
 * <tr><td>emailId</td><td>Email id of the registered user</td></tr>
 * <tr><td>password</td><td>Password for the registered user</td></tr> 
 * <tr><td>productCategory</td><td>Product Main Category(e.g. MEN, WOMEN etc)</td></tr>
 * <tr><td>productSubCategory</td><td>Product Sub Category(e.g. T-shirt, Watches etc)</td></tr> 
 * <tr><td>firstName</td><td>First Name for the delivery address</td></tr> 
 * <tr><td>lastName</td><td>Last Name for the delivery address</td></tr>
 * <tr><td>postCode</td><td>Postal code for the delivery address</td></tr> 
 * <tr><td>address</td><td>Address field for the delivery</td></tr> 
 * <tr><td>landmark</td><td>Address2 field for the delivery</td></tr> 
 * <tr><td>mobileNumber</td><td>Phone for the delivery address</td></tr>
 * <tr><td>paymentOption</td><td>NetBanking</td></tr>
 * <tr><td>netbankingBankSelection</td><td>Bank selection criteria('SelectBankFromDropdown' in case selected bank is from the drop down list, 'SelectBankFromOptionList' in case selected bank is from the visible list)</td></tr> 
 * <tr><td>bank</td><td>Bank through which payment is to be done</td></tr>
 * </table>
 * <br>
 * <br>
 * 
 */ 



public class SS_CheckOut_AlreadyLoginUser_OrderUsingNetBanking {

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
			Login_App.execute(iTestCaseRow);
			Utils.waitForPageLoadLongTime();
			Thread.sleep(5000);
			Utils.removeAllItemFromCart();
			Utils.waitForPageLoadLongTime();
            Utils.HappyPathFlowTillCheckOutPage(iTestCaseRow);
            Thread.sleep(2000);
            if(ExcelUtils.getCellData(iTestCaseRow, Constant.UserType).equals("Public")){
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
				Utils.waitForElementPresence(Checkout_Page.GuestOTPPopup());
				Thread.sleep(2000);
				if(Checkout_Page.GuestOTPPopup().isDisplayed()){
					System.out.println("Otp is required to continue");
				}
				else{
				System.out.println("after if");
				CheckOut_Action.EnterPersonalInfoAtCheckOutPage(iTestCaseRow);
				Thread.sleep(5000);
				CheckOut_Action.validateNumberOfDefaultPaymentMode();
				}
			}
			else{
				Checkout_Page.Paymentinfo.ProceedToPaymentButton().click();
				Utils.waitForPageLoadLongTime();
				Thread.sleep(5000);
				System.out.println("proceed to payment clicked");
				Utils.verifyElement(Checkout_Page.Paymentinfo.PaymentClass());
				Log.info("Payment information tab is visible");
				CheckOut_Action.PaymentOption(iTestCaseRow);
			}
			
			ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.result);
			Utils.captureScreenshot(sTestCaseName, "Pass", "Passed");
			Log.info("Payment successfull using Netbanking");
			 BaseClass.passedTC=BaseClass.passedTC+1;

		} catch (Exception e) {
			BaseClass.tcFailReasons=BaseClass.tcFailReasons.append(sTestCaseName + ":-" +e + "\n");
			BaseClass.failedTC=BaseClass.failedTC+1;
			Log.error("Issue in making payment using Netbanking");
			ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.result);

			Utils.captureScreenshot(sTestCaseName, "Fail", "Failure");

			Log.error(e.getMessage());

			throw (e);
		}
	}

	@AfterMethod
	public void afterMethod() {

		Log.endTestCase(sTestCaseName);
		Driver.quit();

	}
	/*@AfterSuite
	public static void sendEmail() throws AddressException, Exception{
		PDFReport.sendPDFReportByGMail(Utils.ReadProperties(Constant.Path_ConfigProperties).getProperty("from"),
			    Utils.ReadProperties(Constant.Path_ConfigProperties).getProperty("password"),
			    InternetAddress.parse(Utils.ReadProperties(Constant.Path_ConfigProperties).getProperty("to")),
			    Utils.ReadProperties(Constant.Path_ConfigProperties).getProperty("subject"), "");
	}*/
	
}
