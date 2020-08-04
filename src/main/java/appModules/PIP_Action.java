package appModules;

import pageObjects.Address_Book_Page;
import pageObjects.Personal_Info_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;

public class PIP_Action 
{
	
	public static void execute_EditProfile_Button(int iTestCaseRow) throws Exception
	{
		String password = ExcelUtils.getCellData(iTestCaseRow, Constant.password);
		Personal_Info_Page.Login_Password_TextField().sendKeys(password);
		Personal_Info_Page.signIn_Button().click();
		Thread.sleep(2000);
		Utils.scrollingToPageElementByCordinate(450, 500);
		Utils.waitForElementPresence(Personal_Info_Page.saveUpdates_Button());
		Utils.highLight(Personal_Info_Page.saveUpdates_Button());
		Personal_Info_Page.saveUpdates_Button().click();
	}
	
	public static void edit_Address() throws Exception 
	{
		try
		{
			Utils.jsClick(Personal_Info_Page.addresses_Link());
			Utils.waitForPageLoad();
			Utils.verifyElement(Address_Book_Page.addressText());
			Thread.sleep(1000);
			Utils.jsClick(Address_Book_Page.defaultAddressEditLink());
			Utils.waitForElementPresence2(Address_Book_Page.lastname());
			Address_Book_Page.lastname().clear();
			Address_Book_Page.lastname().sendKeys("S");
			Utils.waitForElementPresence2(Address_Book_Page.address_Line_2());
			Address_Book_Page.address_Line_2().clear();
			Address_Book_Page.address_Line_2().sendKeys("Gandhi Nagar");
			Thread.sleep(1000);
			Utils.jsClick(Address_Book_Page.update_Address_Button());
		}
		catch(Exception e)
		{
			Log.error("Exception in Class PIP_Action | Method edit_Address");
			Log.error("Unable to edit_Address");
			Log.error("Error due to -"+e.getMessage());
			throw e;
		}
	}
	
	public static void change_Default_Address() throws Exception {
		try
		{
			Utils.waitForPageLoad();
			Utils.mouseHover(Address_Book_Page.non_Default_Address());
			Thread.sleep(1000);
			Utils.jsClick(Address_Book_Page.make_This_My_Default_Address_Link());
			Log.info("Defalt Address changed");
			
		}
		catch(Exception e)
		{
			Log.error("Exception in Class PIP_Action | Method change_Default_Address");
			Log.error("Unable to Change the default Address");
			Log.error("Error due to -"+e.getMessage());
			throw e;
		}
	}
	
	public static boolean checkNumberOfAddresses_and_singleDefaultAddress() throws Exception {
		boolean flag;
		try
		{
			Utils.waitForPageLoad();
			Utils.jsClick(Personal_Info_Page.addresses_Link());
			Utils.waitForPageLoad();
			Utils.verifyElement(Address_Book_Page.addressText());
			Thread.sleep(1000);
			if(Address_Book_Page.list_Of_Addresses().size()>=1 && Address_Book_Page.list_Of_defaultAddresses().size()==1)
			flag=true;
			else 
				flag=false;
			Log.info("Defalt Address changed");
			
		}
		catch(Exception e)
		{
			Log.error("Exception in Class PIP_Action | Method checkNumberOfAddresses_and_singleDefaultAddress");
			Log.error("Unable to Change the default Address");
			Log.error("Error due to -"+e.getMessage());
			throw e;
		}
		return flag;
	}
	
	public static void verify_Change_Password_Fields_and_Buttons(int iTestCaseRow) throws Exception
	{
		try {
			Utils.waitForPageLoad();
			Utils.jsClick(Personal_Info_Page.change_Password_link());
			Utils.verifyElement(Personal_Info_Page.change_Password_Text());
			Utils.jsClick(Personal_Info_Page.ChangePasswordPage.change_Password_Button());
			Utils.waitForPageLoad();
			Personal_Info_Page.ChangePasswordPage.current_Password_Field().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.password));
			Personal_Info_Page.ChangePasswordPage.new_Password_Field().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.password));
			Personal_Info_Page.ChangePasswordPage.confirm_New_Password_Field().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.password));
			Utils.jsClick(Personal_Info_Page.ChangePasswordPage.updatePassword_Button());
			Utils.waitForPageLoad();
			Utils.verifyElement(Personal_Info_Page.ChangePasswordPage.confirmation_Message());
			} 
		catch (Exception e) 
		{
			Log.error("Exception in Class PIP_Action | Method verify_Change_Password_Fields_and_Buttons");
			Log.error("unable to verify the fields amd buttons of change password page");
			Log.error("fail reason -"+e.getMessage());
			throw e;

		}
	
	}	
}
