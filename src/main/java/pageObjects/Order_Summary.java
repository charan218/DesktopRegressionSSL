package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;
import utility.Utils;

public class Order_Summary extends BaseClass {
	public Order_Summary(WebDriver Driver) {
		super(Driver);
		// TODO Auto-generated constructor stub
	}

	private static WebElement element = null;
	private static List<WebElement> elements = null;
	
	public static WebElement OrderConfirmation() throws Exception{
		try{
			Log.info("Locating Order Confirmation Link");
			element=Driver.findElement(By.xpath("//*[contains(text(),'Your order is confirmed.')]"));
			Utils.highLight(element);
		}catch(Exception e){
			Log.error("Unable to locate Order Confirmation Link");
			throw e;
		}
		return element;
		
	}
	public static WebElement OrderID() throws Exception{
		try{
			Log.info("Locating Order_ID");
			element=Driver.findElement(By.xpath("(//div[@class='odr-data'])[1]"));
			Utils.highLight(element);
		}catch(Exception e){
			Log.error("Unable to locate OrderID");
			throw e;
		}
		return element;
		
	}

	public static WebElement billingAddress() throws Exception{
		try{
			Log.info("Locating billingAddress");
			element =Driver.findElement(By.xpath("(//div[@class='odr-data'])[4]"));
			Utils.highLight(element);
		}catch(Exception e){
			Log.error("Unable to locate Billing Address");
			throw e;
		}
		return element;
		
	}	
	
	public static WebElement pickupAddress() throws Exception{
		try{
			Log.info("Locating pickupAddress");
			element =Driver.findElement(By.xpath("(//div[@class='odr-data'])[7]"));
			Utils.highLight(element);
		}catch(Exception e){
			Log.error("Unable to locate pickup Address");
			throw e;
		}
		return element;
		
	}		
	
}
