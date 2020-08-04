package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;
import utility.Utils;

public class Address_Book_Page extends BaseClass
{
	private static WebElement element = null;
	private static List<WebElement> listelement=null;

	public Address_Book_Page(WebDriver Driver) {
		super(Driver);
	}
	
	public static WebElement addressText() throws Exception {

		try {
			Log.info("Locating Address Text on Address_Book_Page");
			element = Driver.findElement(By.xpath("//div[@id='my-acc-section']//h1[.='Addresses']"));
			Log.info("Address Text found on Address_Book_Page");
			Utils.highLight(element);

		} catch (Exception e) {
			Log.error("Exception in Class Address_Book_Page | Method addressText");
			Log.error("Address Tex does not exist on Address_Book_Page");
			throw e;
		}

		return element;

	}
	
	public static WebElement defaultAddressEditLink()
	{
		try {
			Log.info("Locating Edit Link on Address_Book_Page");
			String path="(//li[@class='selected']/descendant::p[contains(.,'Default Shipping Address')]/following::li//a[contains(.,'Edit')])[1]";
			element = Driver.findElement(By.xpath(path));
			Log.info("Edit Link found on Address_Book_Page");
			Utils.highLight(element);

		} catch (Exception e) {
			Log.error("Exception in Class Address_Book_Page | Method defaultAddressEditLink");
			Log.error("Edit Link does not exist on Address_Book_Page");
			throw e;
		}

		return element;

	}
	
	public static WebElement address_Line_2()
	{
		try {
			Log.info("Locating Address_Line_2 textbox on Address_Book_Page");
			String path="//input[@id='address.line2']";
			element = Driver.findElement(By.xpath(path));
			Log.info("Address_Line_2 textbox found on Address_Book_Page");
			Utils.highLight(element);

		} catch (Exception e) {
			Log.error("Exception in Class Address_Book_Page | Method address_Line_2");
			Log.error("Address_Line_2 textbox does not exist on Address_Book_Page");
			throw e;
		}

		return element;
	}

	public static WebElement lastname()
	{
		try {
			Log.info("Locating lastname textbox on Address_Book_Page");
			element = Driver.findElement(By.xpath("//input[@id='address.lastName']"));
			Log.info("Address_Line_2 textbox found on Address_Book_Page");
			Utils.highLight(element);

		} catch (Exception e) {
			Log.error("Exception in Class Address_Book_Page | Method lastname");
			Log.error("lastname textbox does not exist on lastname");
			throw e;
		}

		return element;
	}
	
	//input[@id='address.lastName']
	public static WebElement update_Address_Button()
	{
		try {
			Log.info("Locating update_Address_Button on Address_Book_Page");
			String path="//button[@id='accountAddAddress']";
			element = Driver.findElement(By.xpath(path));
			Log.info("update_Address_Button found on Address_Book_Page");
			Utils.highLight(element);

		} catch (Exception e) {
			Log.error("Exception in Class Address_Book_Page | Method update_Address_Button");
			Log.error("update_Address_Button does not exist on Address_Book_Page");
			throw e;
		}

		return element;
	}
	
	public static WebElement non_Default_Address()
	{
		try {
			Log.info("Locating non Default Adresss on Address_Book_Page");
			String path="(//div[@class='list_address']//li//span)[2]";
			element = Driver.findElement(By.xpath(path));
			Log.info("non Default Adresss found on Address_Book_Page");
			Utils.highLight(element);

		} catch (Exception e) {
			Log.error("Exception in Class Address_Book_Page | Method non_Default_Address");
			Log.error("non Default Adresss does not exist on Address_Book_Page");
			throw e;
		}

		return element;
	}
	
	public static WebElement make_This_My_Default_Address_Link() throws Exception {

		try {
			Log.info("make_This_My_Default_Address Link on Address_Book_Page");
			element = Driver.findElement(By.xpath("(//div[@class='shipping_address']/p/a)[1]"));
			Log.info("make_This_My_Default_Address Link found on Address_Book_Page");
			Utils.highLight(element);

		} catch (Exception e) {
			Log.error("Exception in Class Address_Book_Page | Method make_This_My_Default_Address_Link");
			Log.error("make_This_My_Default_Address Link does not exist on Address_Book_Page");
			throw e;
		}

		return element;

	}
	
	public static List<WebElement> list_Of_Addresses()
	{
		try {
			Log.info("Finding list of addresses on Address_Book_Page");
			listelement = Driver.findElements(By.xpath("//div[@class='list_address']//li/span"));
			Log.info("list of addresses found on Address_Book_Page");
			Utils.highLight(element);

		} catch (Exception e) {
			Log.error("Exception in Class Address_Book_Page | Method list_Of_Addresses");
			Log.error("list of addresses does not exist on Address_Book_Page");
			throw e;
		}

		return listelement;
	}
	
	public static List<WebElement> list_Of_defaultAddresses()
	{
		try {
			Log.info("Finding list of default Addresses on Address_Book_Page");
			listelement = Driver.findElements(By.xpath("//div[@class='shipping_address']/p[@class='shipping']"));
			Log.info("list of default Addresses found on Address_Book_Page");
			Utils.highLight(element);

		} catch (Exception e) {
			Log.error("Exception in Class Address_Book_Page | Method list_Of_defaultAddresses");
			Log.error("list of default Addresses does not exist on Address_Book_Page");
			throw e;
		}

		return listelement;
	}
	
	
	
	
}
