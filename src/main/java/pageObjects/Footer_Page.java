package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import utility.Log;
import utility.Utils;

public class Footer_Page extends Utils {

	private static WebElement terms_use = Driver.findElement(By.xpath("//a[contains(@title, 'Terms of use')]"));

	private static WebElement cook_privacy = Driver
			.findElement(By.xpath("//a[contains(text(), 'Cookie & Privacy Policy')]"));
	private static WebElement ss_Allrights = Driver
			.findElement(By.xpath("//p[contains(text(),'SHOPPERS STOP LTD. ALL RIGHTS RESERVED.')]"));

	public static void verifyTerms_use() throws Exception {

		try {
			waitForPageLoad();
			scrollingToPageBottom(terms_use);
			waitForElementPresence2(terms_use);
			System.out.println(terms_use.getText() + " has verifing");
			Utils.jsClick(terms_use);
			WebElement terms = Driver.findElement(By.xpath("//h1[contains(text(),'TERMS')]"));
			System.out.println(terms.getText() + " has verified ");
			Log.info(terms.getText() + " has verified ");
		} catch (Exception e) {
			Log.warn(terms_use.getText() + "is not verified");
		}

	}

	public static void verifyPrivacy_cookies_policy() {
		try {
			waitForPageLoad();
			scrollingToPageBottom(cook_privacy);
			waitForElementPresence2(cook_privacy);
			Utils.jsClick(cook_privacy);
			Utils.waitForPageLoadLongTime();
			System.out.println(cook_privacy.getText() + " has verified");
			WebElement privacy = Driver.findElement(By.xpath("//h1[text()='PRIVACY']"));
			Log.info(privacy.getText() + " has verified ");
			WebElement cookies = Driver.findElement(By.xpath("//h4[text()='Cookies']"));
			Log.info(cookies.getText() + " has verified ");
		} catch (Exception e) {
			Log.warn(cook_privacy.getText() + "is not verified");
		}

	}
	public static WebElement expressStorepick() {
		try {
			Log.info("locating the expresstore link");
			WebElement element = Driver.findElement(By.xpath("//a[@title='EXPRESS STORE PICK UP']"));
			Utils.highLight(element);
			Log.info("located expressstore element");
			return element;
		} catch (Exception e) {
			Log.error("Unable to find expresstore element ");
			throw e;
		}

	}
	public static WebElement FAQ() {
		try {
			Log.info("locating to the FAQ ");
			WebElement element = Driver.findElement(By.xpath("//h2[text()='FREQUENTLY ASKED QUESTIONS']"));
			Utils.highLight(element);
			Log.info("located FAQ element");
			return element;
		} catch (Exception e) {
			Log.error("Unable to   find FAQ element ");
			throw e;
		}

	}
	public static List<WebElement> ListOfFAQ() {
		try {
			Log.info("locating to the FAQ ");
			List<WebElement> elementList = Driver.findElements(By.xpath("//h2[text()='FREQUENTLY ASKED QUESTIONS']/following-sibling::div/descendant::a"));
			Log.info("located FAQ element");
			return elementList;
		} catch (Exception e) {
			Log.error("Unable to   find FAQ element ");
			throw e;
		}

	}
	
	
	public static List<WebElement> FirstCitizenlinks() {
		try {
			Log.info("locating to the FirstCitizenlinks ");
			List<WebElement> elementList = Driver.findElements(By.xpath("//h3[text()='First Citizen']/following-sibling::ul/li/a"));
			Log.info("located FirstCitizenlinks element");
			return elementList;
		} catch (Exception e) {
			Log.error("Unable to   find FAQ element ");
			throw e;
		}

	}
	

}
