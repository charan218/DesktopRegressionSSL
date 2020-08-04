package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.*;

public class Personal_Info_Page extends BaseClass
{
	
	private static WebElement element ;
	
	public Personal_Info_Page(WebDriver Driver) 
	{
		super(Driver);
	}

	public static WebElement Edit_Profile_Button() throws Exception
	{
		try
		{
			Log.info("Finding the EDIT Profile Button");
			Thread.sleep(3000);
			element=Driver.findElement(By.xpath("//a[.='Edit Profile']"));
			Utils.highLight(element);
			Log.info("EDIT profile Button found");
		}
		catch(Exception e)
		{
			Log.error("Exception in Class Personal_Info_Page | Method Edit_Profile_Button");
			Log.error("Error finding The EDIT Profile Button");
			throw e;
		}
		return element;
	}
	
	public static WebElement Login_Password_TextField() throws Exception
	{
		try
		{
			Log.info("Finding the Password textBox");
			element=Driver.findElement(By.xpath("(//input[@id='j_password'])[2]"));
			Utils.highLight(element);
			Log.info("Password textBox found");
		}
		catch(Exception e)
		{
			Log.error("Exception in Class Personal_Info_Page | Method Login_Password_TextField");
			Log.error("Error finding The Password textBox");
			throw e;
		}
		return element;
	}
	
	public static WebElement signIn_Button() throws Exception
	{
		try
		{
			Log.info("Finding the signIn Button");
			element=Driver.findElement(By.id("internalloginajax"));
			Utils.highLight(element);
			Log.info("signIn Button found");
		}
		catch(Exception e)
		{
			Log.error("Exception in Class Personal_Info_Page | Method signIn_Button");
			Log.error("Error finding The signIn Button");
			throw e;
		}
		return element;
	}
	
	
	public static WebElement saveUpdates_Button() throws Exception
	{
		try
		{
			Log.info("Finding the saveUpdates Button");
			element=Driver.findElement(By.xpath("//button[.='Save Updates']"));
			Utils.highLight(element);
			Log.info("saveUpdates Button found");
		}
		catch(Exception e)
		{
			Log.error("Exception in Class Personal_Info_Page | Method saveUpdates_Button");
			Log.error("Error finding The saveUpdates Button");
			throw e;
		}
		return element;
	}
	
	public static WebElement addresses_Link() throws Exception
	{
		try
		{
			Log.info("Finding the Addresses Link");
			element=Driver.findElement(By.xpath("//ul[@style='display: block;']//a[.='Addresses']"));
			Utils.highLight(element);
			Log.info("Addresses Link found");
		}
		catch(Exception e)
		{
			Log.error("Exception in Class Personal_Info_Page | Method addresses_Link");
			Log.error("Error finding The Addresses Link");
			throw e;
		}
		return element;
	}
	
	public static WebElement change_Password_link() throws Exception
	{
		try
		{
			Log.info("Finding the Change Password Link");
			element=Driver.findElement(By.xpath("//a[.='Change Password']"));
			Utils.highLight(element);
			Log.info("Change Password Link found");
		}
		catch(Exception e)
		{
			Log.error("Exception in Class Personal_Info_Page | Method change_Password_link");
			Log.error("Error finding The Change Password Link");
			throw e;
		}
		return element;
	}
	
	public static WebElement change_Password_Text() throws Exception
	{
		try
		{
			Log.info("Finding the Change Password Text");
			element=Driver.findElement(By.xpath("//h1[.='Change Password']"));
			Utils.highLight(element);
			Log.info("Change Password Text found");
		}
		catch(Exception e)
		{
			Log.error("Exception in Class Personal_Info_Page | Method change_Password_Text");
			Log.error("Error finding The Change Password Text");
			throw e;
		}
		return element;
	}
	
	
	
	public static class ChangePasswordPage
	{
		public static WebElement change_Password_Button() throws Exception
		{
			try
			{
				Log.info("Finding the change_Password Button");
				element=Driver.findElement(By.xpath("//a[@id='chngbtn']"));
				Utils.highLight(element);
				Log.info("change_Password Button found");
			}
			catch(Exception e)
			{
				Log.error("Exception in Class Personal_Info_Page | Method change_Password_Button");
				Log.error("Error finding The change_Password Button");
				throw e;
			}
			return element;
		}
		
		public static WebElement current_Password_Field()
		{
			try
			{
				Log.info("Finding the current Password textBox");
				element=Driver.findElement(By.xpath("//input[@id='profile.currentPassword']"));
				Utils.highLight(element);
				Log.info("Current Password textBox found");
			}
			catch(Exception e)
			{
				Log.error("Exception in Class Personal_Info_Page | Method current_Password_Field");
				Log.error("Error finding The Current Password textBox");
				throw e;
			}
			return element;
		}
		
		public static WebElement new_Password_Field()
		{
			try
			{
				Log.info("Finding the new Password textBox");
				element=Driver.findElement(By.xpath("//input[@id='profile-newPassword']"));
				Utils.highLight(element);
				Log.info("New Password textBox found");
			}
			catch(Exception e)
			{
				Log.error("Exception in Class Personal_Info_Page | Method new_Password_Field");
				Log.error("Error finding The New Password textBox");
				throw e;
			}
			return element;
		}
		
		public static WebElement confirm_New_Password_Field()
		{
			try
			{
				Log.info("Finding the Confirm new Password textBox");
				element=Driver.findElement(By.xpath("//input[@id='profile.checkNewPassword']"));
				Utils.highLight(element);
				Log.info("Confirm new Password textBox found");
			}
			catch(Exception e)
			{
				Log.error("Exception in Class Personal_Info_Page | Method confirm_New_Password_Field");
				Log.error("Error finding The Confirm new Password textBox");
				throw e;
			}
			return element;
		}
		
		public static WebElement updatePassword_Button() throws Exception
		{
			try
			{
				Log.info("Finding the Update Password Button");
				element=Driver.findElement(By.xpath("//button[.='Update	Password']"));
				Utils.highLight(element);
				Log.info("Update Password Button found");
			}
			catch(Exception e)
			{
				Log.error("Exception in Class Personal_Info_Page | Method updatePassword_Button");
				Log.error("Error finding The Update Password Button");
				throw e;
			}
			return element;
		}
		
		public static WebElement confirmation_Message()
		{
			try
			{
				Log.info("Finding the Update confirmation Message");
				element=Driver.findElement(By.xpath("//button[contains(.,'×')]"));
				Utils.highLight(element);
				Log.info("Update confirmation Message found");
			}
			catch(Exception e)
			{
				Log.error("Exception in Class Personal_Info_Page | Method confirmation_Message");
				Log.error("Error finding The Update confirmation Message");
				throw e;
			}
			return element;
		}
	}

}
