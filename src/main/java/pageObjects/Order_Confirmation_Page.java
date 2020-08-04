package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utility.Log;
import utility.Utils;

public class Order_Confirmation_Page extends Utils
{
	private static WebElement element = null;
	
	public static WebElement feedBackCance_Button() throws Exception {

		try {
			Log.info("Locating FeedBack Cance Button element");
			element = Driver.findElement(By.xpath("//span[.='x']/following-sibling::div[.='FEEDBACK']/../span"));
			Utils.highLight(element);
			Log.info("FeedBack Cance Button is found on the checkout Page");

		} catch (Exception e) {
			Log.error("Exception in Class Checkout_Page | Method feedBackCance_Button");
			Log.error("FeedBack Cance Button is not found on the checkout Page");
			throw e;
		}

		return element;
	}
	
	public static class  CompleteProfile
	{
		
		public static WebElement completeYourProfile_Button() throws Exception {

			try {
				Log.info("Locating Complete Your Profile Button element");
				element = Driver.findElement(By.xpath("//a[.='Complete Your Profile']"));
				Utils.highLight(element);
				Log.info("Complete Your Profile Button is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method completeYourProfile_Button");
				Log.error("Complete Your Profile Button is not found on the checkout Page");
				throw e;
			}

			return element;
		}
		
		
		public static WebElement completeYourProfile_Text() throws Exception {

			try {
				Log.info("Locating Complete Your Profile Text element");
				element = Driver.findElement(By.xpath("//h4[.='Complete Your Profile']"));
				Utils.highLight(element);
				Log.info("Complete Your Profile Text is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method completeYourProfile_Text");
				Log.error("Complete Your Profile Text is not found on the checkout Page");
				throw e;
			}

			return element;
		}
		
		public static WebElement setPassword_TextBox() throws Exception {
			try {
				Log.info("Locating Profile mail TextBox element");
				element = Driver.findElement(By.xpath("//input[@id='profilePassword']"));
				Utils.highLight(element);
				Log.info("Profile mail TextBox is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method setPassword_TextBox");
				Log.error("Profile mail TextBox is not found on the checkout Page");
				throw e;
			}
			return element;
		}
		
		public static WebElement male_Radio_Button() throws Exception {
			try {
				Log.info("Locating Male_Radio_Button element");
				element = Driver.findElement(By.xpath("(//input[@value='MALE'])[1]"));
				Utils.highLight(element);
				Log.info("Male_Radio_Button is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method male_Radio_Button");
				Log.error("Male_Radio_Button is not found on the checkout Page");
				throw e;
			}
			return element;
		}
		
		public static WebElement continue_Button() throws Exception {
			try {
				Log.info("Locating Continue_Button element");
				element = Driver.findElement(By.xpath("(//button[contains(.,'Continue')])[1]"));
				Utils.highLight(element);
				Log.info("Continue_Button is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method continue_Button");
				Log.error("Continue_Button is not found on the checkout Page");
				throw e;
			}
			return element;
		}
	}
}
