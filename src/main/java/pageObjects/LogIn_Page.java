package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.Log;
import utility.Utils;

public class LogIn_Page extends BaseClass {
	private static WebElement element = null;

	public LogIn_Page(WebDriver Driver) {
		super(Driver);
	}

	public static WebElement User_Id() throws Exception {
		try {
			Log.info("Locating User_Id element");
			element = Driver.findElement(By.id("j_username"));
			Utils.highLight(element);
			Log.info("User name field found on the page");
		} catch (Exception e) {
			Log.error("Exception in Class LogIn_Page | Method User_Id");
			Log.error("User name field not found on the page");
			throw (e);
		}

		return element;

	}

	public static WebElement login_page() throws Exception {
		try {
			Log.info("Locating User_Id element");
			element = Driver.findElement(By.xpath("//div[@class='member-login']"));
			Utils.highLight(element);
			Log.info("User name field found on the page");
		} catch (Exception e) {
			Log.error("Exception in Class LogIn_Page | Method User_Id");
			Log.error("User name field not found on the page");
			throw (e);
		}

		return element;

	}

	public static WebElement User_Pwd() throws Exception {
		try {
			Log.info("Locating User_Pwd element");
			element = Driver.findElement(By.id("j_password"));
			Utils.highLight(element);
			Log.info("User password field found on the page");
		} catch (Exception e) {
			Log.error("Exception in Class LogIn_Page | Method User_Pwd");
			Log.error("User password field not found on the page");
			throw (e);
		}
		return element;
	}

	public static WebElement Profile_update_User_Pwd() throws Exception {
		try {
			Log.info("Locating User_Pwd element");
			element = Driver.findElement(By.xpath(".//*[@id='member-login']//*[@id='j_password']"));
			Log.info("User password field found on the page");
		} catch (Exception e) {
			Log.error("Exception in Class LogIn_Page | Method User_Pwd");
			Log.error("User password field not found on the page");
			throw (e);
		}
		return element;
	}
	public static WebElement submit_bt() throws Exception {

		try {
			Log.info("Locating submit_bt element");
			element = Driver.findElement(By.id("loginajax"));
			Utils.highLight(element);
			Log.info("Submit button found on the page");
		} catch (Exception e) {
			Log.error("Exception in Class LogIn_Page | Method submit_bt");
			Log.error("Submit button not found on the page");
			throw (e);
		}
		return element;

	}

	
	public static WebElement Profile_upt_submit_bt() throws Exception {

		try {
			Log.info("Locating submit_bt element");
			element = Driver.findElement(By.xpath(".//*[@id='internalloginajax']"));
			Log.info("Submit button found on the page");
		} catch (Exception e) {
			Log.error("Exception in Class LogIn_Page | Method submit_bt");
			Log.error("Submit button not found on the page");
			throw (e);
		}
		return element;

	}
	public static WebElement InvalidLogIn_ErrorMessage() throws Exception {
		try {
			Log.info("Locating InvalidLogIn_ErrorMessage element");
			element = Driver.findElement(By.xpath("//*[@id='loginErrorMessage']/h6"));
			Log.info("InvalidLogIn_ErrorMessage  field found on the page");

		} catch (Exception e) {
			Log.error("Exception in Class LogIn_Page | Method InvalidLogIn_ErrorMessage");
			Log.error("InvalidLogIn_ErrorMessage field not found on the page");

		}
		return element;
	}

	public static WebElement ForgotPwd() throws Exception {
		try {
			Log.info("Locating ForgotPwd element");
			element = Driver.findElement(By.className("forgot-password"));
			Utils.highLight(element);
			Log.info(" FORGOT password field found on the page");
		} catch (Exception e) {
			Log.error("Exception in Class LogIn_Page | Method ForgotPwd");
			Log.error("FORGOT password field not found on the page");
			throw (e);
		}
		return element;
	}

	public static WebElement ForgotPwdText() throws Exception {
		try {
			Log.info("Locating ForgotPwdText element");
			element = Driver.findElement(By.xpath("//*[@id='forgotForm']/div[1]/h2"));
			Log.info("Forgot password text found on the form");

		} catch (Exception e) {
			Log.error("Exception in Class LogIn_Page | Method ForgotPwdText");
			Log.error("Forgot password text not found on the form");
			throw (e);
		}
		return element;
	}

	public static WebElement User_ForgotCustomerIDEmail() throws Exception {
		try {
			Log.info("Locating User_ForgotCustomerIDEmail element");
			element = Driver.findElement(By.xpath("//input[@id='femail']"));
			Utils.highLight(element);
			Log.info("User_ForgotCustomerIDEmail  field found on the page");
		} catch (Exception e) {
			Log.error("Exception in Class LogIn_Page | Method User_ForgotCustomerIDEmail");
			Log.error("User ForgotCustomerIDEmail field not found on the page");
			throw (e);
		}
		return element;
	}

	public static WebElement User_ForgotPWDSendEmailBtn() throws Exception {
		try {
			Log.info("Locating User_ForgotPWDSendEmailBtn element");
			element = Driver.findElement(By.xpath("//button[contains(.,'send email')]"));
			Utils.highLight(element);
			Log.info("User_ForgotCustomerIDSendBtn  field found on the page");
		} catch (Exception e) {
			Log.error("Exception in Class LogIn_Page | Method User_ForgotPWDSendEmailBtn");
			Log.error("User ForgotCustomerID send button field not found on the page");
			throw (e);
		}
		return element;
	}

	public static WebElement User_ForgotPasswordEmail() throws Exception {
		try {
			Log.info("Locating User_ForgotPasswordEmail element");
			element = Driver.findElement(By.xpath("//*[@id='forgotPwdEmail']"));
			Utils.highLight(element);
			Log.info("User_ForgotPasswordEmail  field found on the page");
		} catch (Exception e) {
			Log.error("Exception in Class LogIn_Page | Method User_ForgotPasswordEmail");
			Log.error("User ForgotCustomerIDEmail field not found on the page");
			throw (e);
		}
		return element;
	}

	public static WebElement User_ForgotPasswordSendBtn() throws Exception {
		try {
			Log.info("Locating User_ForgotPasswordSendBtn element");
			element = Driver.findElement(By.xpath("//*[@id='forgottenPwdButton']"));
			Utils.highLight(element);
			Log.info("User_ForgotPasswordEmail  field found on the page");
		} catch (Exception e) {
			Log.error("Exception in Class LogIn_Page | Method User_ForgotPasswordSendBtn");
			Log.error("User ForgotCustomerID send button field not found on the page");
			throw (e);
		}
		return element;
	}

	public static WebElement User_ForgotPasswordMessage() throws Exception {
		try {
			Log.info("Locating User_ForgotPasswordMessage element");
			element = Driver.findElement(By.xpath("//span[@class='login-account-not-found']"));
			Utils.highLight(element);
			Log.info("Forgot password message field found on the page");
		} catch (Exception e) {
			Log.error("Exception in Class LogIn_Page | Method User_ForgotPasswordMessage");
			Log.error("Forgot password message field not found on the page");
			throw (e);
		}
		return element;
	}

	public static WebElement User_ForgotPasswordCloseBtn() throws Exception {
		try {
			Log.info("Locating User_ForgotPasswordCloseBtn element");
			element = Driver.findElement(By.xpath("//*[@id='cboxClose']"));
			Log.info("User_ForgotPasswordCloseBtn  field found on the page");
			Utils.highLight(element);

		} catch (Exception e) {
			Log.error("Exception in Class LogIn_Page | Method User_ForgotPasswordCloseBtn");
			Log.error("User_ForgotPasswordClose button field not found on the page");
			throw (e);
		}
		return element;
	}

	public static WebElement ErrorElement() throws Exception {
		try {
			Log.info("Locating lastName element");
			element = Driver.findElement(By.xpath("//div[@class='ui-tooltip-content']"));
			Utils.highLight(element);
			Log.info("Tool tip error field found on the page");

		} catch (Exception e) {
			Log.error("Exception in Class LogIn_Page | Method CheckOutText");
			Log.error("Tool tip error field found on the page");
			throw (e);
		}
		return element;
	}

	public static WebElement invalidLoginError() throws Exception {
		try {
			Log.info("Locating invalidLoginError element");
			element = Driver.findElement(By.xpath(".//*[@id='member-scroller']/div/div[1]/span"));
			Utils.highLight(element);
			Log.info("Invalid login error message is found on the page");

		} catch (Exception e) {
			Log.error("Exception in Class LogIn_Page | Method invalidLoginError");
			Log.error("Invalid login error message is found on the page");
			throw (e);
		}
		return element;
	}

}
