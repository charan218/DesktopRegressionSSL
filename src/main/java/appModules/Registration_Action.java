package appModules;

import java.util.List;

import org.openqa.selenium.Keys;

import pageObjects.BaseClass;
import pageObjects.Home_Page;
import pageObjects.Registration_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;

public class Registration_Action {

	public static void execute(int iTestCaseRow) throws Exception {

		try {

			
			Log.info("Registration page will be opened");
			String fName = ExcelUtils.getCellData(iTestCaseRow, Constant.firstName);
			Registration_Page.First_name().sendKeys(fName);
			Log.info("First name is entered successfully");
			Thread.sleep(3000);
			/*
			 * String lName = ExcelUtils.getCellData(iTestCaseRow, Constant.lastName);
			 * Registration_Page.last_name().sendKeys(lName);
			 * Log.info("Last name is entered successfully");
			 */
			String emailAddress = ExcelUtils.getCellData(iTestCaseRow, Constant.emailId);			
			//String emailAddress = Utils.getCurrentTime(ExcelUtils.getRowContains(sTestCaseRow,1));
			Registration_Page.email().sendKeys(emailAddress);
			Log.info("Email address is entered successfully");
			String pNumber = ExcelUtils.getCellData(iTestCaseRow, Constant.mobileNumber);
			Registration_Page.mobileNumber().sendKeys(pNumber);
			Log.info("Mobile number is entered successfully");
			String password = ExcelUtils.getCellData(iTestCaseRow, Constant.password);
			Registration_Page.password().sendKeys(password);
			Log.info("Password is entered successfully");
			Thread.sleep(3000);
//			String cPassword = ExcelUtils.getCellData(iTestCaseRow, Constant.confirmPassword);
//			Registration_Page.Confirm_Password().sendKeys(cPassword);
//			Log.info("Confirm password is entered successfully");
			String gender = ExcelUtils.getCellData(iTestCaseRow, Constant.gender);
			if (gender.equals("Male")) {
				Registration_Page.genderMale().click();
			} else if (gender.equals("Female")) {
				Registration_Page.genderFemale().sendKeys(Keys.SPACE);
			}
			Log.info("Gender is selected successfully");
			Registration_Page.Register_Button().click();
			Log.info("Register button is clicked successfully");
			Utils.waitForPageLoad();
/*
 * 			try{
 *
				Thread.sleep(10000);
				Utils.mouseHover(Home_Page.LoginRegister());
				Thread.sleep(5000);
				Utils.jsClick(Home_Page.Logout());
				Thread.sleep(5000);
			}
			
			catch(Exception e){
				throw (e);
				
		*/	}

	 catch (Exception e) {
			Log.error("Exception in Class Registration_Action | Method execute");
			Log.error("Registration is not successful");
			throw e;
		}
	}

	public static void checkErrors(int iTestCaseRow) throws Exception {

		try {
			if(Registration_Page.First_name().getAttribute("class").equals("ui-state-highlight"))
				BaseClass.errorValidation = BaseClass.errorValidation+"Invalid firstname \n";
			if(Registration_Page.last_name().getAttribute("class").equals("ui-state-highlight"))
				BaseClass.errorValidation = BaseClass.errorValidation+"Invalid lastname \n";
			if(Registration_Page.mobileNumber().getAttribute("class").equals("ui-state-highlight"))
				BaseClass.errorValidation = BaseClass.errorValidation+"Invalid mobile number \n";
			if(Registration_Page.email().getAttribute("class").equals("ui-state-highlight"))
				BaseClass.errorValidation = BaseClass.errorValidation+"Invalid email \n";
			if(Registration_Page.password().getAttribute("class").equals("ui-state-highlight"))
				BaseClass.errorValidation = BaseClass.errorValidation+"Invalid password \n";
			if(Registration_Page.Confirm_Password().getAttribute("class").equals("ui-state-highlight"))
				BaseClass.errorValidation = BaseClass.errorValidation+"Invalid confirm password \n";
			if(Registration_Page.genderMale().getAttribute("class").equals("ui-state-highlight"))
				BaseClass.errorValidation = BaseClass.errorValidation+"Invalid gender \n";
		} catch (Exception e) {
			Log.error("Exception in Class Registration_Action | Method checkErrors");
			throw e;
		}
	}
	
	
	public static void multipleRegistration(int iTestCaseRow) throws Exception {

		try {
			List<String> emailAddress = Utils.csvDataReader(ExcelUtils.getCellData(iTestCaseRow, Constant.emailId));
			List<String> pNumber = Utils.csvDataReader(ExcelUtils.getCellData(iTestCaseRow, Constant.mobileNumber));
			List<String> firstName = Utils.csvDataReader(ExcelUtils.getCellData(iTestCaseRow, Constant.firstName));
			String password = ExcelUtils.getCellData(iTestCaseRow, Constant.password);
            System.out.println(emailAddress.size());
            System.out.println(pNumber.size());
            System.out.println(firstName.size());
           // System.out.println(password.size());
			for(int i=0;i<emailAddress.size();i++){
			Log.info("Registration page will be opened");
			System.out.println("count="+i);
			Registration_Page.First_name().sendKeys(firstName.get(i));
			Log.info("First name is entered successfully");
		Registration_Page.email().sendKeys(emailAddress.get(i));
			Log.info("Email address is entered successfully");
			Registration_Page.mobileNumber().sendKeys(pNumber.get(i));
			Log.info("Mobile number is entered successfully");
			Registration_Page.password().sendKeys(password);
			Log.info("Password is entered successfully");
		Registration_Page.genderMale().click();
			Log.info("Gender is selected successfully");
			Registration_Page.Register_Button().click();
			Log.info("Register button is clicked successfully");
			Thread.sleep(3500);
			Registration_Page.Register_Close_Page().click();
			
//			HomePage_Action.HappyPathFlowTillCartPage_WithoutEnteringPincode(iTestCaseRow);
//			Thread.sleep(5000);
//			Utils.jsClick(Cart_Page.CheckoutButton());
//			Thread.sleep(20000);
//			Utils.waitForElementPresence(Checkout_Page.DeliveryAddress.Postcode());
//			Checkout_Page.DeliveryAddress.Postcode().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.postCode));
//
//			Checkout_Page.DeliveryAddress.phone().sendKeys(pNumber.get(i));
//			Checkout_Page.DeliveryAddress.address1().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.address));
//			Checkout_Page.DeliveryAddress.SaveandContinueBtn().click();

//			Utils.mouseHover(Home_Page.LoginRegister());
//			Utils.waitForElementPresence(Home_Page.profileLink());
//			Home_Page.profileLink().click();
//			Log.info("Profile link is clicked from the user's menu");
//			Utils.waitForElement(MyAccount_Page.ProfilePage.PersonalInfoText());
//			Utils.scrollingToPageElement(MyAccount_Page.MyAccount_LeftMenu.Paymentsection());
//			MyAccount_Page.MyAccount_LeftMenu.Addresses().click();
////			MyAccount_Page.ProfilePage.Addresses().click();
//			Log.info("Addresses Link is clicked");
//			Thread.sleep(3000);
//			MyAccount_Page.ProfilePage.AddNewAddress().click();
//			Thread.sleep(3000);
//			
//			MyAccount_Page.ProfilePage.Address.PostCode().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.postCode));
//			MyAccount_Page.ProfilePage.Address.Phone().sendKeys(pNumber.get(i));
//			MyAccount_Page.ProfilePage.Address.Address1().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.address));
//			MyAccount_Page.ProfilePage.Address.Address1().sendKeys(Keys.TAB);
//			Utils.scrollingToPageElement(MyAccount_Page.ProfilePage.Address.Phone());
//
//			MyAccount_Page.ProfilePage.Address.DefaultAddressCheckbox().click();
//			Thread.sleep(5000);
////			MyAccount_Page.ProfilePage.Address.AddAddressBtn().click();
////			MyAccount_Page.ProfilePage.Address.AddAddressBtn().click();
//			Utils.jsClick(MyAccount_Page.ProfilePage.Address.AddAddressBtn());
//			Thread.sleep(15000);	
//			Utils.NavigateToURL(Constant.URL);
//			Utils.mouseHover(Home_Page.LoginRegister());
//			Thread.sleep(5000);
//			Utils.waitForElementPresence(Home_Page.Logout());

//			Thread.sleep(5000);
//			Utils.jsClick(Home_Page.Logout());
//			Thread.sleep(3000);
//			Utils.mouseHover(Home_Page.LoginRegister());
//			Utils.jsClick(Home_Page.SignUp());
			}
		} catch (Exception e) {
			Log.error("Exception in Class Registration_Action | Method execute");
			Log.error("Registration is not successful");
			throw e;
		}

	}
	
	
	
	
}