package appModules;

import java.util.List;

import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.BaseClass;
import pageObjects.Home_Page;
import pageObjects.LogIn_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;

public class Login_App {
	static boolean presence;

	public static void execute(int iTestCaseRow) throws Exception {

		try {

//			if (ExcelUtils.getCellData(iTestCaseRow, Constant.browser).equals("IE")) {
//				Utils.SecurityCertificateHandle();
//			}
			Thread.sleep(5000);
			Utils.mouseHover(Home_Page.LoginRegister());
			Utils.jsClick(Home_Page.SignIn());
			Log.info("Sign in button is clicked");

			Log.info("Row number containing the test case: " + iTestCaseRow);
			String sUsername = ExcelUtils.getCellData(iTestCaseRow, Constant.emailId);
			LogIn_Page.User_Id().sendKeys(sUsername);
			Log.info(sUsername + " is entered in user id field");

			String sPassword = ExcelUtils.getCellData(iTestCaseRow, Constant.password);
			LogIn_Page.User_Pwd().sendKeys(sPassword);
			Log.info(sPassword + " is entered in user password field");

			LogIn_Page.submit_bt().click();
			Log.info("Submit button is clicked");
			Thread.sleep(5000);
			Utils.waitForInvisibityOfElement(LogIn_Page.login_page());
			System.out.println(" Login into application succefully ");
		
			Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.browser));
			Log.info("Login successfull");
			Thread.sleep(5000);

		} catch (Exception e) {
			Log.error("Exception in Class Login_App | Method execute");
			Log.error("Login not successful");
			throw (e);

		}

	}
	//updated login method functionality with validation also
			public static void executeWithValidation(int iTestCaseRow) throws Exception {

				try {

					if (ExcelUtils.getCellData(iTestCaseRow, Constant.browser).equals("IE")) {
						Utils.SecurityCertificateHandle();
					}
					
					Utils.mouseHover(Home_Page.LoginRegister());
					Thread.sleep(1000);
					Utils.jsClick(Home_Page.SignIn());
					Thread.sleep(1000);
					Log.info("Sign in button is clicked");

					Log.info("Row number containing the test case: " + iTestCaseRow);
					String sUsername = ExcelUtils.getCellData(iTestCaseRow, Constant.emailId);
					LogIn_Page.User_Id().sendKeys(sUsername);
					Log.info(sUsername + " is entered in user id field");

					String sPassword = ExcelUtils.getCellData(iTestCaseRow, Constant.password);
					LogIn_Page.User_Pwd().sendKeys(sPassword);
					Log.info(sPassword + " is entered in user password field");

					LogIn_Page.submit_bt().click();
					Log.info("Submit button is clicked");

					Utils.waitForPageLoad();
					Log.info("Login successfull");
					//need to implement this
					try {
					Thread.sleep(5000);	
					Utils.waitForInvisibityOfElement(LogIn_Page.login_page());
					Utils.waitForPageLoadLongTime();
					System.out.println("after login page loaded. but going to check validation");
					Home_Page.LoginRegister().click();
					Utils.waitForPageLoadLongTime();
					Home_Page.personalInformationText().isDisplayed();
					} catch (Exception e) {
						Log.error("Failed to login to the site");
						System.out.println("Failed to login to the site");
						throw new Exception("Failed to login to the site");
					}
					
					
				} catch (Exception e) {
					Log.error("Exception in Class Login_App | Method execute");
					Log.error("Login not successful");
					throw new Exception("Failed to login to the site");

				}

			}

			
			
			

			
			
	public static void InvalidLoginErrorVerification(int iTestCaseRow) throws Exception {

		try {
			Utils.mouseHover(Home_Page.LoginRegister());

			Home_Page.SignIn().click();
			Log.info("Sign in button is clicked");

			Log.info("Row number containing the test case: " + iTestCaseRow);
			String sUsername = ExcelUtils.getCellData(iTestCaseRow, Constant.emailId);
			LogIn_Page.User_Id().sendKeys(sUsername);
			Log.info(sUsername + " is entered in user id field");

			String sPassword = ExcelUtils.getCellData(iTestCaseRow, Constant.password);
			LogIn_Page.User_Pwd().sendKeys(sPassword);
			Log.info(sPassword + " is entered in user password field");

			LogIn_Page.submit_bt().click();
			Log.info("Submit button is clicked");

			Log.info("Error message found on Login Popup - " + LogIn_Page.invalidLoginError().getText());

			if ("Your username or password was incorrect".equals(LogIn_Page.invalidLoginError().getText())) {
				Log.info("Entered Username or Password is incorrect , Please Enter the correct Details");

			}

			Log.info("Verification check has been completed - Invalid Login");

		} catch (Exception e) {
			Log.error("Exception in Class Login_App | Method InvalidLoginErrorVerification");
			Log.error("Verification check Failed to InValid Login");
			throw (e);

		}

	}

	public static void Login_Blank_parameter(int iTestCaseRow) throws Exception {
		try {
			Utils.mouseHover(Home_Page.LoginRegister());

			Home_Page.SignIn().click();
			Log.info("Sign in button is clicked");

			Log.info("Row number containing the test case: " + iTestCaseRow);
			String sUsername = ExcelUtils.getCellData(iTestCaseRow, Constant.emailId);
			LogIn_Page.User_Id().sendKeys(sUsername);
			Log.info(sUsername + " is entered in user id field");

			String sPassword = ExcelUtils.getCellData(iTestCaseRow, Constant.password);
			LogIn_Page.User_Pwd().sendKeys(sPassword);
			Log.info(sPassword + " is entered in user password field");

			LogIn_Page.submit_bt().click();
			Log.info("Submit button is clicked");

			Thread.sleep(2000);
			String errorMessage = LogIn_Page.ErrorElement().getText();

			if (ExcelUtils.getCellData(iTestCaseRow, Constant.message1).equals(errorMessage)) {
				Log.info("Verification Pass - error message is displayed correctly.");
			} else {
				throw new Exception("Issue with retreiving error message");
			}

		} catch (Exception e) {
			Log.error("Exception in Class Login_App | Method Login_Blank_parameter");
			Log.error("Issue with retreiving error message");
			throw (e);
		}
	}

	public static void Login_ForgotPassword(int iTestCaseRow) throws Exception {

		try {
			Utils.mouseHover(Home_Page.LoginRegister());
			Utils.jsClick(Home_Page.SignIn());
			Log.info("Sign in button is clicked");
			Thread.sleep(1000);
			Utils.waitForElementTOclick(LogIn_Page.User_Id());
			LogIn_Page.ForgotPwd().click();
			Log.info("Forgot password button is clicked");
			//Utils.waitForElement(LogIn_Page.ForgotPwdText());
			String UserEmailID = ExcelUtils.getCellData(iTestCaseRow, Constant.emailId);
			Utils.waitForElementTOclick(LogIn_Page.User_ForgotCustomerIDEmail());
			LogIn_Page.User_ForgotCustomerIDEmail().sendKeys(UserEmailID);
			Log.info(UserEmailID + " is entered in user email id field");
			Thread.sleep(2000);
			Log.info("Forgot Password functionality working fine");

		} catch (Exception e) {
			Log.error("Exception in Class Login_App | Method Login_ForgotPassword");
			Log.error("Verification check Failed for Forgot Password ");

			throw (e);

		}

	}

}

