package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;
import utility.Utils;

public class Registration_Page extends BaseClass {
	private static WebElement element = null;

	// public static String thankYouMail;

	public Registration_Page(WebDriver Driver) {
		super(Driver);
	}

	public static WebElement First_name() throws Exception {

		try {
			Log.info("Locating First_name element");
			element = Driver.findElement(By.id("signupFullName"));
			Utils.highLight(element);
			Log.info("First Name field is found on the Registration Page");

		} catch (Exception e) {
			Log.error("Exception in Class Registration_Page | Method First_name");
			Log.error("First Name link is not found on the Registration Page");
			throw e;
		}

		return element;

	}

	public static WebElement last_name() throws Exception {

		try {
			Log.info("Locating lastName element");
			element = Driver.findElement(By.id("signupFullName"));
			Utils.highLight(element);
			Log.info("Last Name field is found on the Registration Page");

		} catch (Exception e) {
			Log.error("Exception in Class Registration_Page | Method last_name");
			Log.error("Last Name link is not found on the Registration Page");
			throw e;
		}

		return element;

	}

	public static WebElement email() throws Exception {

		try {
			Log.info("Locating email element");
			element = Driver.findElement(By.id("signupEmail"));
			Utils.highLight(element);
			Log.info("Email field is found on the Registration Page");

		} catch (Exception e) {
			Log.error("Exception in Class Registration_Page | Method email");
			Log.error("Email field is not found on the Registration Page");
			throw e;
		}

		return element;

	}

	public static WebElement password() throws Exception {

		try {
			Log.info("Locating password element");
			element = Driver.findElement(By.id("signupPassword"));
			Utils.highLight(element);
			Log.info("password field is found on the Registration Page");

		} catch (Exception e) {
			Log.error("Exception in Class Registration_Page | Method password");
			Log.error("password field is not found on the Registration Page");
			throw e;
		}

		return element;

	}

	public static WebElement Confirm_Password() throws Exception {

		try {
			Log.info("Locating Confirm_Password element");
			element = Driver.findElement(By.id("checkPwd"));
			Utils.highLight(element);
			Log.info("Confirm_Password field is found on the Registration Page");

		} catch (Exception e) {
			Log.error("Exception in Class Registration_Page | Method Confirm_Password");
			Log.error("Confirm_Password field is not found on the Registration Page");
			throw e;
		}

		return element;

	}

	public static WebElement mobileNumber() throws Exception {

		try {
			Log.info("Locating mobileNumber element");
			element = Driver.findElement(By.id("signupMobileNumber"));
			Utils.highLight(element);
			Log.info("PhoneNumber field is found on the Registration Page");

		} catch (Exception e) {
			Log.error("Exception in Class Registration_Page | Method mobileNumber");
			Log.error("PhoneNumber field is not found on the Registration Page");
			throw e;
		}

		return element;

	}

	public static WebElement genderMale() throws Exception {

		try {
			Log.info("Locating genderMale element");
			element = Driver.findElement(By.xpath(".//*[@id='men']"));
			Utils.highLight(element);
			Log.info("Male option is found on the Registration Page");

		} catch (Exception e) {
			Log.error("Exception in Class Registration_Page | Method genderMale");
			Log.error("Male option is not found on the Registration Page");
			throw e;
		}

		return element;

	}

	public static WebElement genderFemale() throws Exception {

		try {
			Log.info("Locating genderFemale element");
			element = Driver.findElement(By.xpath(".//*[@id='women']"));
	//		element = Driver.findElement(By.id("women"));
			Utils.highLight(element);
			Log.info("Female option is found on the Registration Page");

		} catch (Exception e) {
			Log.error("Exception in Class Registration_Page | Method genderFemale");
			Log.error("Female option is not found on the Registration Page");
			throw e;
		}

		return element;

	}

	public static WebElement Register_Button() throws Exception {

		try {
			Log.info("Locating Register_Button element");
			element = Driver.findElement(By.xpath(".//*[@id='registerForm']/div[1]/div[1]/button"));
			Utils.highLight(element);
			Log.info("Register button is found on the Registration page");
		} catch (Exception e) {
			Log.error("Exception in Class Registration_Page | Method Register_Button");
			Log.error("Register button is not found on the Registration page");
			throw e;
		}
		return element;

	}
	
	public static WebElement Register_Page() throws Exception {

		try {
			Log.info("Locating Register_Button element");
			element = Driver.findElement(By.xpath("//form[@id='registerForm']"));
			Utils.highLight(element);
			Log.info("Register button is found on the Registration page");
		} catch (Exception e) {
			Log.error("Exception in Class Registration_Page | Method Register_Button");
			Log.error("Register button is not found on the Registration page");
			throw e;
		}
		return element;

	}
	//facebook Icon on Registration page
	public static WebElement faceBookIcon() throws Exception {

		try {
			Log.info("Locating Register_Button element");
			element = Driver.findElement(By.xpath("//*[@class='login-common']/*[@class='login-with-social']/ul/li[1]"));
			Utils.waitForElementPresence(element);
			Utils.highLight(element);
			Log.info("Register button is found on the Registration page");
		} catch (Exception e) {
			Log.error("Exception in Class Registration_Page | Method Register_Button");
			Log.error("Register button is not found on the Registration page");
			throw e;
		}
		return element;

	}
	
	//google Icon on Registration page
		public static WebElement googleIcon() throws Exception {

			try {
				Log.info("Locating Register_Button element");
				element = Driver.findElement(By.xpath("//*[@class='login-common']/*[@class='login-with-social']/ul/li[2]"));
				Utils.waitForElementPresence(element);
				Utils.highLight(element);
				Log.info("Register button is found on the Registration page");
			} catch (Exception e) {
				Log.error("Exception in Class Registration_Page | Method Register_Button");
				Log.error("Register button is not found on the Registration page");
				throw e;
			}
			return element;

		}
		public static WebElement faceBook_loginTxt() throws Exception {

			try {
				Log.info("Locating Register_Button element");
				element = Driver.findElement(By.id("email"));
				Utils.waitForElementPresence(element);
				Utils.highLight(element);
				Log.info("Register button is found on the Registration page");
			} catch (Exception e) {
				Log.error("Exception in Class Registration_Page | Method Register_Button");
				Log.error("Register button is not found on the Registration page");
				throw e;
			}
			return element;

		}
		public static WebElement Register_Close_Page() throws Exception {

			try {
				Log.info("Locating Register_Button element");
				element = Driver.findElement(By.xpath("//div[@class='new-sign-up']/span[@class='sign-close']"));
				Utils.highLight(element);
				Log.info("Register button is found on the Registration page");
			} catch (Exception e) {
				Log.error("Exception in Class Registration_Page | Method Register_Button");
				Log.error("Register button is not found on the Registration page");
				throw e;
			}
			return element;
		}

}
