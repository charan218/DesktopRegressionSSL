
package appModules;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import pageObjects.BaseClass;
import pageObjects.Cart_Page;
import pageObjects.Checkout_Page;
import pageObjects.Checkout_Page.LoginDetails;
import pageObjects.MiniCart_Page;
import pageObjects.MyAccount_Page;
import pageObjects.ProductDetails_Page;
import pageObjects.ProductListing_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;

// This is called Modularization, when we club series of actions in to one Module

public class CheckOut_Action {
	static WebElement element;
	public WebDriver Driver;
	
	public static String strName=null;
	public static void LoginAsRegisteredUser(int iTestCaseRow) throws Exception {

		try {
			/*Checkout_Page.LoginDetails.Optionbtn_RegisteredUser().click();
			Log.info("Registered user option is selected successfully");*/

			String sUsername = ExcelUtils.getCellData(iTestCaseRow, Constant.emailId);
			Checkout_Page.LoginDetails.LoginEmailRegisteredUser().sendKeys(sUsername);
			Log.info("Email id is entered successfully");

			String sPassword = ExcelUtils.getCellData(iTestCaseRow, Constant.password);
			Checkout_Page.LoginDetails.LoginPwdRegisteredUser().sendKeys(sPassword);
			Log.info("Password is entered successfully");

			Checkout_Page.LoginDetails.ContinueBtn().click();
			Log.info("Continue button is clicked successfully");
			Utils.waitForPageLoadLongTime();
		} catch (Exception e) {
			Log.error("Exception in Class CheckOut_Action | Method LoginAsRegisteredUser");
			Log.error("Login not successful");
			throw (e);

		}

	}
	public static void validateNumberOfDefaultPaymentMode()throws Exception{
		try{
			Thread.sleep(5000);
			final int i=6;
			int numberOfDefaultModeOfPayment = 0;
			Utils.scrollingToPageElement(Checkout_Page.paymentModes());
			List<WebElement> list=Checkout_Page.Paymentinfo.ModeOfPayment();
			numberOfDefaultModeOfPayment=list.size();
			Thread.sleep(2000);
			System.out.println(numberOfDefaultModeOfPayment);
			if(numberOfDefaultModeOfPayment==i || numberOfDefaultModeOfPayment==4 || numberOfDefaultModeOfPayment==5 || numberOfDefaultModeOfPayment==7 || numberOfDefaultModeOfPayment==8){
				System.out.println("Number of Payment Mode is equals to 6 or 5 or more ie "+numberOfDefaultModeOfPayment);
				Log.info("Number of Payment Mode is equals to 6 or 5 or more ie "+numberOfDefaultModeOfPayment);
			}
			else{
				BaseClass.errorValidation+="Number of Payment mode is not equals to 6 or 5\n";
			}
		}
		catch(Exception ex){
			Log.error("Validation of number of Payment Mode Failed");
			BaseClass.errorValidation+="unable to locate Payment Modes\n";
		}
	}
	public static void Login_At_Checkout_Flow(int iTestCaseRow) throws Exception{
		try{
			HomePage_Action.selectProductCategoryfromMenu(iTestCaseRow);
			Log.info("Product selected from Main Menu on header");
			Utils.waitForPageLoadLongTime();
			Utils.jsClick(ProductListing_Page.secondproduct());
			Thread.sleep(5000);
			Log.info("Product clicked on PLP");
			Utils.waitForPageLoadLongTime();
			System.out.println("product clicked");
			PDP_Action.product_selectSize(ProductDetails_Page.Product.size_variant_buttonlist());
			System.out.println("size selected");
			Utils.waitForPageLoadLongTime();
			Thread.sleep(10000);
			Utils.jsClick(ProductDetails_Page.Product.Product_AddToCart());
			Utils.waitForPageLoadLongTime();
			System.out.println("Add to cart clicked");
			Thread.sleep(5000);
		//	Utils.verifyElement(MiniCart_Page.MiniCartProductDetails.MiniCartViewBag());
		//	MiniCart_Page.MiniCartProductDetails.MiniCartViewBag().click();
			//Minicart Functionality Removed
			Utils.jsClick(Cart_Page.cartIcon());
			Utils.waitForPageLoadLongTime();
			Thread.sleep(5000);
			System.out.println("cart icon clicked");
//			Utils.verifyElement(Cart_Page.CheckoutButton());
			Cart_Page.CheckoutButton().click();
			Utils.waitForPageLoadLongTime();
			Thread.sleep(5000);
			System.out.println("checkout button clicked");
//			MiniCart_Page.MiniCartProductDetails.MiniCartCheckOutButton().click();
			LoginAsRegisteredUser(iTestCaseRow);
			Utils.waitForPageLoadLongTime();
			Thread.sleep(30000);
			System.out.println("login completed");
			Checkout_Page.Paymentinfo.ProceedToPaymentButton().click();
			System.out.println("proceed to payment clicked");
			Utils.waitForPageLoadLongTime();
			Thread.sleep(5000);
		}catch(Exception e){
			Log.error("Login At Checkout Failed");
			throw e;
		}
	}
	public static void Verify_Private_ChecoutPage_ApplyCoupan(int iTestCaseRow) throws Exception {
		Log.info("Verification for Applying Coupon on cart page started");
		String totalCartPrice = "";
		String totalCartPrice1 = "";

		totalCartPrice = Checkout_Page.Paymentinfo.TotalPrice().getText().split("Rs")[1];
		System.out.println(totalCartPrice);
		Log.info("Total cart price obtained successfully");
		try {
			Cart_Page.ApplyCoupanButton().click();
			Thread.sleep(1000);
			Log.info("EApply Coupan link clicked successfully");
			if (!(Checkout_Page.Paymentinfo.InvalidCoupanAlert().getText().equals("This field is required."))) {
				//BaseClass.errorValidation += "Invalid Coupon alert not present on page. \n";
			}
		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
			Log.error(e.getMessage());
			throw e;
		}
		try {
			Cart_Page.CoupanCodeFieldcart().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.invalidPromoCode));
			Log.info("Coupon code entered successfully");
			Cart_Page.ApplyCoupanButton().click();
			Log.info("Apply Coupon code link clicked successfully");
			Thread.sleep(1000);
			if (!(Cart_Page.CartPageAlert().getText().equals("Please enter a valid coupon code"))) {
				BaseClass.errorValidation += "'Please enter the Valid Coupon Code!' - alert not present on page. \n";
			}
		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
			Log.error(e.getMessage());
			throw e;
		}
		if(Constant.URL!="https://www.shoppersstop.com/"){
			
		
		try {
			Cart_Page.CoupanCodeFieldcart().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.promoCode));
			Log.info("Coupon code entered successfully");
			Cart_Page.ApplyCoupanButton().click();
			Log.info("Apply Coupon code link clicked successfully");
			Thread.sleep(1000);
			System.out.println(totalCartPrice);
			//totalCartPrice1=Cart_Page.TotalCartPrice().getText();
			//There is no valid coupon available 
			if (!(Cart_Page.CartPageAlertsuccess().getText().equals("Coupon code applied"))) {
				BaseClass.errorValidation += "'Voucher applied successfully!' - alert not present on page. \n";
			}
			if (Checkout_Page.Paymentinfo.TotalPrice().getText().split("Rs")[1].equals(totalCartPrice)) {
				BaseClass.errorValidation += "Coupon coded discount not applied. \n";
			}
		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
			Log.error(e.getMessage());
			throw e;
		}
		try {

			Cart_Page.RemoveCouponCode().click();
			Thread.sleep(5000);
			Log.info("Remove Coupon code link clicked successfully");
			if (!(Checkout_Page.Paymentinfo.TotalPrice().getText().split("Rs")[1].equals(totalCartPrice))) {
				BaseClass.errorValidation += "Coupon coded discount not removed. \n";
			}
			if (!(Cart_Page.CouponAlert().getText().equals("Voucher removed successfully!"))) {
				BaseClass.errorValidation += "'Voucher removed successfully!'- alert present on cart page. \n";
			}
		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
			Log.error(e.getMessage());
			throw e;
		}
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
			throw new Exception(BaseClass.errorValidation);
		}
	}
	public static void DirectCheckoutFromMiniCart(int iTestCaseRow)throws Exception{
		try{
			HomePage_Action.selectProductCategoryfromMenu(iTestCaseRow);
			Log.info("Product selected from Main Menu on header");
			Utils.waitForPageLoad();
			Thread.sleep(2000);
			ProductListing_Page.secondproduct().click();
			Utils.waitForPageLoad();
			Thread.sleep(5000);
			Log.info("Product clicked on PLP");
			PDP_Action.product_selectSize(ProductDetails_Page.Product.size_variant_buttonlist());
			Thread.sleep(5000);
			Utils.waitForElementTOclick(ProductDetails_Page.Product.Product_AddToCart());
			System.out.println("Add to bag is clicked");
			Thread.sleep(2000);
			Utils.waitForElementTOclick(Cart_Page.cartIcon());
			Utils.waitForPageLoad();
			Thread.sleep(5000);
			Utils.waitForElementTOclick(Cart_Page.CheckoutButton());
//			Utils.verifyElement(MiniCart_Page.MiniCartProductDetails.MiniCartViewBag());
			System.out.println("mini cart view bas is present");
//			Utils.jsClick(MiniCart_Page.MiniCartProductDetails.MiniCartCheckOutButton());
			Thread.sleep(10000);
			System.out.println("checkout button is clicked");
			
			
		}
		catch(Exception e){
			throw(e);
		}
	}
	
	public static void HappyPathFlowTillCheckOutPage(int iTestCaseRow) throws Exception{
		HomePage_Action.selectProductCategoryfromMenu(iTestCaseRow);
		Log.info("Product category selected successfully");
		ProductListing_Page.secondproduct().click();
		Thread.sleep(3000);
		Log.info("Product selected successfully");
		PDP_Action.product_selectSize(ProductDetails_Page.Product.size_variant_buttonlist());
		ProductDetails_Page.Product.Product_AddToCart().click();
		Log.info("Add to cart button is clicked");
		Thread.sleep(3000);		
		Utils.verifyElement(MiniCart_Page.MiniCartWindow());
		Log.info("Product is added to the cart and mini cart is displayed");		
		Utils.verifyElement(Cart_Page.CheckOutButtonOnMiniCart());		
		Cart_Page.CheckOutButtonOnMiniCart().click();
		Log.info("Checkout button is clicked on cart page");
        Thread.sleep(5000);        
		if(ExcelUtils.getCellData(iTestCaseRow, Constant.UserType).equals("Public")){
			Utils.jsClick(Checkout_Page.LoginDetails.ContinueAsGuest());
			Thread.sleep(3000);
			String userEmail = ExcelUtils.getCellData(iTestCaseRow, Constant.emailId);
			Checkout_Page.LoginDetails.LoginEmailGuest().sendKeys(userEmail);
			Log.info("User email id is entered successfully");
			String userPhone = ExcelUtils.getCellData(iTestCaseRow, Constant.mobileNumber);
			Checkout_Page.LoginDetails.GuestMobileNumber().sendKeys(userPhone);
			Checkout_Page.LoginDetails.ContinueBtnGuest().click();
			Log.info("Continue button is clicked");
			CheckOut_Action.EnterPersonalInfoAtCheckOutPage(iTestCaseRow);
		}
		else{
			Checkout_Page.Paymentinfo.ProceedToPaymentButton().click();
		}
	
	}
	
	public static void HappyPathFlowFromCartPageToDeliveryAddressPage(int iTestCaseRow) throws Exception{
		Thread.sleep(5000);
		Utils.verifyElement(Cart_Page.CheckoutButtonOnMiniCartFCC());
		Utils.jsClick(Cart_Page.CheckoutButtonOnMiniCartFCC());
		System.out.println("Clicked on Check out Button on Mini Cart Page");
		
	}
	public static void HappyPathFlowTillCartPage(int iTestCaseRow) throws Exception{
		try{
			HomePage_Action.selectProductCategoryfromMenu(iTestCaseRow);
			Log.info("Product selected from Main Menu on header");
			Thread.sleep(1000);
			Utils.waitForPageLoadLongTime();
			ProductListing_Page.product().click();
			Log.info("Product clicked on PLP");
			Thread.sleep(5000);
			Utils.waitForPageLoadLongTime();
			PDP_Action.product_selectSize(ProductDetails_Page.Product.size_variant_buttonlist());
			Thread.sleep(5000);
			System.out.println("sizesselected");
			Utils.waitForPageLoadLongTime();
			Utils.waitForElementTOclick(ProductDetails_Page.Product.Product_AddToCart());
			Utils.waitForPageLoadLongTime();
			Thread.sleep(3000);
			System.out.println("add to cart clicked");
//			Utils.verifyElement(MiniCart_Page.MiniCartProductDetails.MiniCartViewBag());
	//		MiniCart_Page.MiniCartProductDetails.MiniCartViewBag().click();
			//Minicart Functionality Removed
			Utils.waitForElementTOclick(Cart_Page.cartIcon());
			System.out.println("cart icon clicked");
			Utils.waitForPageLoadLongTime();
			Thread.sleep(3000);
		}
		catch(Exception e){
			System.out.println("Navigation Till Cart Page failed");
			throw new Exception("Navigation till cart Page Failed || Method HappyPathFlowTillCartPage || Class Utils");
		}
	}
	public static void ProceedwithNewAddress(int iTestCaseRow) throws Exception {

		try {
			try{
				Thread.sleep(5000);
			Checkout_Page.DeliveryAddress.AddNewAddressBtn().click();
			}catch(Exception e)
			{
				Log.info("AddNewAddress button not available");
			}
			Thread.sleep(5000);
			Log.info("Add new address button is clicked successfully");
			String firstName = ExcelUtils.getCellData(iTestCaseRow, Constant.firstName);
			Checkout_Page.DeliveryAddress.firstName().clear();
			Checkout_Page.DeliveryAddress.firstName().sendKeys(firstName);
			
			Log.info("First name is entered successfully");

			String lastName = ExcelUtils.getCellData(iTestCaseRow, Constant.lastName);
			Checkout_Page.DeliveryAddress.lastName().clear();
			Checkout_Page.DeliveryAddress.lastName().sendKeys(lastName);
			
			Log.info("Last name is entered successfully");

			String phone = ExcelUtils.getCellData(iTestCaseRow, Constant.mobileNumber);
			Checkout_Page.DeliveryAddress.phone().sendKeys(phone);
			Log.info("Phone number is entered successfully");
			String address1 = Utils.GenerateRandomValues(ExcelUtils.getCellData(iTestCaseRow, Constant.address));
			//String address1 = ExcelUtils.getCellData(iTestCaseRow, Constant.address);
			Checkout_Page.DeliveryAddress.address1().sendKeys(address1);
			Log.info("Address 1 is entered successfully");

			String address2 = Utils.GenerateRandomValues(ExcelUtils.getCellData(iTestCaseRow, Constant.landmark));
			Checkout_Page.DeliveryAddress.address2().sendKeys(address2);
			Log.info("Address 2 is entered successfully");

			String postcode = ExcelUtils.getCellData(iTestCaseRow, Constant.postCode);
			Checkout_Page.DeliveryAddress.Postcode().sendKeys(postcode);
			Log.info("Postcode is entered successfully");

			Checkout_Page.DeliveryAddress.city().click();
			Checkout_Page.DeliveryAddress.Postcode().click();
			Checkout_Page.DeliveryAddress.city().click();
			Thread.sleep(2000);

			//Checkout_Page.DeliveryAddress.TermsandConditionsCheckBox().sendKeys(Keys.PAGE_DOWN);
			//Thread.sleep(1000);
			//Checkout_Page.DeliveryAddress.TermsandConditionsCheckBox().click();
			//Log.info("Terms and conditions option is selected successfully");

			Checkout_Page.DeliveryAddress.SaveandContinueBtn().click();
			Log.info("Save and continue button is clicked successfully");
			Log.info("Address is entered successfully");
			Thread.sleep(5000);

		} catch (Exception e) {
			Log.error("Exception in Class CheckOut_Action | Method ProceedwithNewAddress");
			Log.error("Address is not entered successfully");
			throw e;
		}
	}
	
public static void ValidateErrorMessageForEmptyDeliveryAddress(int iTestCaseRow) throws Exception{
	
	Thread.sleep(10000);
			Checkout_Page.DeliveryAddress.SaveandContinueBtn().click();
			
			try{
				Checkout_Page.DeliveryAddress.firstName().click();
				Thread.sleep(1000);
				Utils.verifyElement(Checkout_Page.DeliveryAddress.ErrorMessageForEmptyFields());
				Checkout_Page.DeliveryAddress.firstName().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.firstName));
			}
			catch(Exception ex){
				BaseClass.errorValidation+="Please Enter your name message not displayed\n";
			}
			
			try{
				Checkout_Page.DeliveryAddress.SaveandContinueBtn().click();
				Thread.sleep(2000);
				Checkout_Page.DeliveryAddress.lastName().click();
				Thread.sleep(2000);
				Utils.verifyElement(Checkout_Page.DeliveryAddress.ErrorMessageForEmptyFields());
				Checkout_Page.DeliveryAddress.lastName().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.lastName));
			}
			catch(Exception ex){
				BaseClass.errorValidation+="Please Enter your last name message not displayed \n";
			}
			System.out.println(Checkout_Page.DeliveryAddress.firstName().getAttribute("value"));
			String fname=Checkout_Page.DeliveryAddress.firstName().getAttribute("value");
			//Utils.verifyElement(Checkout_Page.DeliveryAddress.ErrorMessageForEmptyFields());
			try{
				Checkout_Page.DeliveryAddress.phone().click();
				String phnNumber=Checkout_Page.DeliveryAddress.phone().getAttribute("value");
				System.out.println(phnNumber);
				if(! phnNumber.equals(ExcelUtils.getCellData(iTestCaseRow, Constant.mobileNumber))){
					BaseClass.errorValidation+=" Mobile number for guest user is not getting saved on Address info page \n";
				}
			}
			catch(Exception ex){
				BaseClass.errorValidation+=" Mobile number for guest user is not getting saved on Address info page\n";
			}
			
			try{
				Checkout_Page.DeliveryAddress.SaveandContinueBtn().click();
				Checkout_Page.DeliveryAddress.address1().click();
				Utils.verifyElement(Checkout_Page.DeliveryAddress.ErrorMessageForEmptyFields());
				Checkout_Page.DeliveryAddress.address1().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.address));
				
			}
			catch(Exception ex){
				BaseClass.errorValidation+=" Please enter your Address message not displayed. \n";
			}
			
			try{
				Checkout_Page.DeliveryAddress.SaveandContinueBtn().click();
				Checkout_Page.DeliveryAddress.Postcode().click();
				Thread.sleep(2000);
				Utils.verifyElement(Checkout_Page.DeliveryAddress.ErrorMessageForEmptyFields());
				Checkout_Page.DeliveryAddress.Postcode().sendKeys( ExcelUtils.getCellData(iTestCaseRow, Constant.postCode));
			}
			catch(Exception ex){
				BaseClass.errorValidation+="  Please enter postcode message not displayed. \n";
			}
			
			try{
				if(Checkout_Page.DeliveryAddress.city().getAttribute("value").isEmpty()){
				
				}
			}
			catch( Exception ex){
				BaseClass.errorValidation+="  City is not auto filled \n";
			}
			
			try{
				Utils.jsClick(Checkout_Page.DeliveryAddress.SS_Policy_Checkbox());
				Checkout_Page.DeliveryAddress.SaveandContinueBtn().click();
				Utils.verifyElement(Checkout_Page.DeliveryAddress.ErrorMessageForEmptyFields());
				Thread.sleep(3000);
				Utils.verifyElement(Checkout_Page.DeliveryAddress.SaveandContinueBtn());
				
			}
			catch(Exception ex){
				BaseClass.errorValidation+=" Navigation is there till Payment Page even if user in unchecking SS Policy checkbox \n";
			}
			/*Checkout_Page.DeliveryAddress.city().click();
			Checkout_Page.DeliveryAddress.city()
			Utils.verifyElement(Checkout_Page.DeliveryAddress.ErrorMessageForEmptyFields());*/
			
	}
	
	public static void EnterPersonalInfoAtCheckOutPage(int iTestCaseRow) throws Exception {

		try {
			
			String firstName = ExcelUtils.getCellData(iTestCaseRow, Constant.firstName);
			Checkout_Page.DeliveryAddress.firstName().sendKeys(firstName);
			Log.info("First name is entered successfully");

			String lastName = ExcelUtils.getCellData(iTestCaseRow, Constant.lastName);
			Checkout_Page.DeliveryAddress.lastName().sendKeys(lastName);
			Log.info("Last name is entered successfully");

			String phone = ExcelUtils.getCellData(iTestCaseRow, Constant.mobileNumber);
			Checkout_Page.DeliveryAddress.phone().sendKeys(phone);
			Log.info("Phone number is entered successfully");
			
			String postcode = ExcelUtils.getCellData(iTestCaseRow, Constant.postCode);
			Checkout_Page.DeliveryAddress.Postcode().sendKeys(postcode);
			Log.info("Postcode is entered successfully");
			
			String address1 = ExcelUtils.getCellData(iTestCaseRow, Constant.address);
			Checkout_Page.DeliveryAddress.address1().sendKeys(address1);
			Log.info("Address 1 is entered successfully");

			String address2 = ExcelUtils.getCellData(iTestCaseRow, Constant.landmark);
			Checkout_Page.DeliveryAddress.address2().sendKeys(address2);
			Log.info("Address 2 is entered successfully");
			Thread.sleep(2000);	

			Checkout_Page.DeliveryAddress.city().click();
			//Checkout_Page.DeliveryAddress.TermsandConditionsCheckBox().sendKeys(Keys.PAGE_DOWN);
			Thread.sleep(1000);
			//Checkout_Page.DeliveryAddress.TermsandConditionsCheckBox().click();
			//Log.info("Terms and conditions option is selected successfully");
			Checkout_Page.DeliveryAddress.SaveandContinueBtn().click();
			//Checkout_Page.DeliveryAddress.CancelButton().click();
			Log.info("Save and continue button is clicked successfully");
			Log.info("Address is entered successfully");

		} catch (Exception e) {
			Log.error("Exception in Class CheckOut_Action | Method ProceedwithNewAddress");
			Log.error("Address is not entered successfully");
			throw e;
		}
	}
	public static void ProceedwithNewAddressEmptyfield(int iTestCaseRow) throws Exception {

	      System.out.println(Checkout_Page.DeliveryAddress.firstName().getAttribute("Value"));
		
			
			try {

				if ((Checkout_Page.DeliveryAddress.firstName().getAttribute("Value").startsWith("A"))) {
					BaseClass.errorValidation += "first Name field is not empty \n";
				}

		         if ((Checkout_Page.DeliveryAddress.lastName().getAttribute("Value").startsWith("G"))) {
						BaseClass.errorValidation += "last Name field is not empty \n";
					}

				} catch (Exception e1) {
					Log.error(e1.getMessage());
					throw e1;
					
				}
			
			//Checkout_Page.DeliveryAddress.TermsandConditionsCheckBox().sendKeys(Keys.PAGE_DOWN);
			//Thread.sleep(1000);
			//Checkout_Page.DeliveryAddress.TermsandConditionsCheckBox().click();
			//Log.info("Terms and conditions option is selected successfully")

	}
	
	
	public static void ProceedwithNewAddressNoFName(int iTestCaseRow) throws Exception {

		try {
			if (Checkout_Page.DeliveryAddress.DeliveryAddressNew().getAttribute("style").contains("none")) {
				Checkout_Page.DeliveryAddress.AddNewAddressBtn().click();
				Log.info("Add new address button is clicked successfully");
			}
			Checkout_Page.DeliveryAddress.firstName().clear();
			Checkout_Page.DeliveryAddress.lastName().clear();
			//String firstName = ExcelUtils.getCellData(iTestCaseRow, Constant.firstName);
			//Checkout_Page.DeliveryAddress.firstName().sendKeys(firstName);
			//Log.info("First name is entered successfully");

			String lastName = ExcelUtils.getCellData(iTestCaseRow, Constant.lastName);
			Checkout_Page.DeliveryAddress.lastName().sendKeys(lastName);
			Log.info("Last name is entered successfully");

			String phone = ExcelUtils.getCellData(iTestCaseRow, Constant.mobileNumber);
			Checkout_Page.DeliveryAddress.phone().sendKeys(phone);
			Log.info("Phone number is entered successfully");

			String address1 = ExcelUtils.getCellData(iTestCaseRow, Constant.address);
			Checkout_Page.DeliveryAddress.address1().sendKeys(address1);
			Log.info("Address 1 is entered successfully");

			String address2 = ExcelUtils.getCellData(iTestCaseRow, Constant.landmark);
			Checkout_Page.DeliveryAddress.address2().sendKeys(address2);
			Log.info("Address 2 is entered successfully");

			String postcode = ExcelUtils.getCellData(iTestCaseRow, Constant.postCode);
			Checkout_Page.DeliveryAddress.Postcode().sendKeys(postcode);
			Log.info("Postcode is entered successfully");
			
			Checkout_Page.DeliveryAddress.city().click();
			Thread.sleep(3000);
			
			try {
				Checkout_Page.DeliveryAddress.SaveandContinueBtn().click();
				Log.info("Save and continue button clicked successfully");
				//System.out.println(Cart_Page.FirstNameFieldAlert().getText());
				if (!(Cart_Page.FirstNameFieldAlert().getText().equals("Please enter your firstname"))) {
					BaseClass.errorValidation += "First Name alert not present on page. \n";
				}
			} catch (Exception e) {
				Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
				Log.error(e.getMessage());
				throw e;
			}
			
			Thread.sleep(3000);
			try {
				
				String firstName = ExcelUtils.getCellData(iTestCaseRow, Constant.alternativeFirstName);
				Checkout_Page.DeliveryAddress.firstName().sendKeys(firstName);
				Log.info("First name is entered successfully");
				Checkout_Page.DeliveryAddress.SaveandContinueBtn().click();
				if (!(Cart_Page.FirstNameFieldAlert().getText().equals("Enter Valid Name"))) {
					BaseClass.errorValidation += "'Please enter the Valid First Name!' - First Name alert not present on page. \n";
				}
			} catch (Exception e) {
				Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
				Log.error(e.getMessage());
				throw e;
			}
			try {
				String firstName = ExcelUtils.getCellData(iTestCaseRow, Constant.firstName);
				Checkout_Page.DeliveryAddress.firstName().clear();
				Checkout_Page.DeliveryAddress.firstName().sendKeys(firstName);
				Log.info("First name is entered successfully");
				Checkout_Page.DeliveryAddress.SaveandContinueBtn().click();
			} catch (Exception e) {
				Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
				Log.error(e.getMessage());
				throw e;
			}
			//Checkout_Page.DeliveryAddress.city().click();

			//Checkout_Page.DeliveryAddress.TermsandConditionsCheckBox().sendKeys(Keys.PAGE_DOWN);
			//Thread.sleep(1000);
			//Checkout_Page.DeliveryAddress.TermsandConditionsCheckBox().click();
			//Log.info("Terms and conditions option is selected successfully");

			//Checkout_Page.DeliveryAddress.SaveandContinueBtn().click();
			//Log.info("Save and continue button is clicked successfully");
			//Log.info("Address is entered successfully");

		} catch (Exception e) {
			Log.error("Exception in Class CheckOut_Action | Method ProceedwithNewAddress");
			Log.error("Address is not entered successfully");
			throw e;
		}
	}
	
	public static void ProceedwithNewAddressNoLName(int iTestCaseRow) throws Exception {

		try {
			if (Checkout_Page.DeliveryAddress.DeliveryAddressNew().getAttribute("style").contains("none")) {
				Checkout_Page.DeliveryAddress.AddNewAddressBtn().click();
				Log.info("Add new address button is clicked successfully");
			}
			Checkout_Page.DeliveryAddress.firstName().clear();
			Checkout_Page.DeliveryAddress.lastName().clear();
			String firstName = ExcelUtils.getCellData(iTestCaseRow, Constant.firstName);
			Checkout_Page.DeliveryAddress.firstName().sendKeys(firstName);
			Log.info("First name is entered successfully");

			//String lastName = ExcelUtils.getCellData(iTestCaseRow, Constant.lastName);
			//Checkout_Page.DeliveryAddress.lastName().sendKeys(lastName);
			//Log.info("Last name is entered successfully");

			String phone = ExcelUtils.getCellData(iTestCaseRow, Constant.mobileNumber);
			Checkout_Page.DeliveryAddress.phone().sendKeys(phone);
			Log.info("Phone number is entered successfully");

			String address1 = ExcelUtils.getCellData(iTestCaseRow, Constant.address);
			Checkout_Page.DeliveryAddress.address1().sendKeys(address1);
			Log.info("Address 1 is entered successfully");

			String address2 = ExcelUtils.getCellData(iTestCaseRow, Constant.landmark);
			Checkout_Page.DeliveryAddress.address2().sendKeys(address2);
			Log.info("Address 2 is entered successfully");

			String postcode = ExcelUtils.getCellData(iTestCaseRow, Constant.postCode);
			Checkout_Page.DeliveryAddress.Postcode().sendKeys(postcode);
			Log.info("Postcode is entered successfully");
			
			Checkout_Page.DeliveryAddress.city().click();
			try {
				Checkout_Page.DeliveryAddress.SaveandContinueBtn().click();
				Log.info("Save and continue button clicked successfully");
				
				if (!(Cart_Page.FirstNameFieldAlert().getText().equals("Please enter your lastname"))) {
					BaseClass.errorValidation += "Last name not present on page. \n";
				}
			} catch (Exception e) {
				Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
				Log.error(e.getMessage());
				throw e;
			}
			try {
				
				String LastName = ExcelUtils.getCellData(iTestCaseRow, Constant.alternativeLastName);
				Checkout_Page.DeliveryAddress.lastName().sendKeys(LastName);
				Log.info("Last name is entered successfully");
				Checkout_Page.DeliveryAddress.SaveandContinueBtn().click();
				if (!Cart_Page.FirstNameFieldAlert().getText().equals("Enter Valid Name")) {
					BaseClass.errorValidation += "'Please enter the Valid Last Name!' - Last Name alert not present on page. \n";
				}
			} catch (Exception e) {
				Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
				Log.error(e.getMessage());
				throw e;
			}
          try {
				
				String LastName = ExcelUtils.getCellData(iTestCaseRow, Constant.lastName);
				Checkout_Page.DeliveryAddress.lastName().clear();
				Checkout_Page.DeliveryAddress.lastName().sendKeys(LastName);
				Log.info("First name is entered successfully");
				Checkout_Page.DeliveryAddress.SaveandContinueBtn().click();
				
			} catch (Exception e) {
				Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
				Log.error(e.getMessage());
				throw e;
			}

        

			//Checkout_Page.DeliveryAddress.city().click();

			//Checkout_Page.DeliveryAddress.TermsandConditionsCheckBox().sendKeys(Keys.PAGE_DOWN);
			//Thread.sleep(1000);
			//Checkout_Page.DeliveryAddress.TermsandConditionsCheckBox().click();
			//Log.info("Terms and conditions option is selected successfully");

			//Checkout_Page.DeliveryAddress.SaveandContinueBtn().click();
			//Log.info("Save and continue button is clicked successfully");
			//Log.info("Address is entered successfully");

		} catch (Exception e) {
			Log.error("Exception in Class CheckOut_Action | Method ProceedwithNewAddress");
			Log.error("Address is not entered successfully");
			throw e;
		}
	}

	public static void ProceedwithNewAddressAllFieldEmpty(int iTestCaseRow) throws Exception {

		try {
			if (Checkout_Page.DeliveryAddress.DeliveryAddressNew().getAttribute("style").contains("none")) {
				Checkout_Page.DeliveryAddress.AddNewAddressBtn().click();
				Log.info("Add new address button is clicked successfully");
			}
			Checkout_Page.DeliveryAddress.firstName().clear();
			Checkout_Page.DeliveryAddress.lastName().clear();
		
			try {
				Checkout_Page.DeliveryAddress.SaveandContinueBtn().click();
					Log.info("Save and continue button clicked successfully");
					Utils.mouseHover(Checkout_Page.DeliveryAddress.firstName());
					
					if (!(Checkout_Page.DeliveryAddress.firstName().getAttribute("title").equals("Please enter your firstname"))) {
						BaseClass.errorValidation += "First Name field not highlighted on page. \n";
					}
				} catch (Exception e) {
					Log.error("Exception in Class Cart_Action | Method ProceedwithNewAddressAllFieldEmpty");
					Log.error(e.getMessage());
					throw e;
				}
			
       
	    try {
			Checkout_Page.DeliveryAddress.SaveandContinueBtn().click();
				Log.info("Save and continue button clicked successfully");
				Utils.mouseHover(Checkout_Page.DeliveryAddress.lastName());
				
				if (!(Checkout_Page.DeliveryAddress.lastName().getAttribute("title").equals("Please enter your lastname"))) {
					BaseClass.errorValidation += "Last Name field not highlighted on page. \n";
				}
			} catch (Exception e) {
				Log.error("Exception in Class Cart_Action | Method ProceedwithNewAddressAllFieldEmpty");
				Log.error(e.getMessage());
				throw e;
			}
	    
	
		
		try {
			Checkout_Page.DeliveryAddress.SaveandContinueBtn().click();
				Log.info("Save and continue button clicked successfully");
				Utils.mouseHover(Checkout_Page.DeliveryAddress.phone());
				
				if (!(Checkout_Page.DeliveryAddress.phone().getAttribute("title").equals("Please provide a number"))) {
					BaseClass.errorValidation += "Phone No field not highlighted on page. \n";
				}
			} catch (Exception e) {
				Log.error("Exception in Class Cart_Action | Method ProceedwithNewAddressAllFieldEmpty");
				Log.error(e.getMessage());
				throw e;
			}
		
		try {
			Checkout_Page.DeliveryAddress.SaveandContinueBtn().click();
				Log.info("Save and continue button clicked successfully");
				Utils.mouseHover(Checkout_Page.DeliveryAddress.address1());
				
				if (!(Checkout_Page.DeliveryAddress.address1().getAttribute("title").equals("Please enter your Address"))) {
					BaseClass.errorValidation += "Address1 field not highlighted on page. \n";
				}
			} catch (Exception e) {
				Log.error("Exception in Class Cart_Action | Method ProceedwithNewAddressAllFieldEmpty");
				Log.error(e.getMessage());
				throw e;
			}
		
		try {
			Checkout_Page.DeliveryAddress.SaveandContinueBtn().click();
				Log.info("Save and continue button clicked successfully");
				Utils.mouseHover(Checkout_Page.DeliveryAddress.Postcode());
				
				if (!(Checkout_Page.DeliveryAddress.Postcode().getAttribute("title").equals("Please enter valid pincode"))) {
					BaseClass.errorValidation += "Pin Code field not highlighted on page. \n";
				}
			} catch (Exception e) {
				Log.error("Exception in Class Cart_Action | Method ProceedwithNewAddressAllFieldEmpty");
				Log.error(e.getMessage());
				throw e;
			}
		
		try {
			Checkout_Page.DeliveryAddress.SaveandContinueBtn().click();
				Log.info("Save and continue button clicked successfully");
				Utils.mouseHover(Checkout_Page.DeliveryAddress.city());
				
				if (!(Checkout_Page.DeliveryAddress.city().getAttribute("title").equals("Please enter your city"))) {
					BaseClass.errorValidation += "City field not highlighted on page. \n";
				}
			} catch (Exception e) {
				Log.error("Exception in Class Cart_Action | Method ProceedwithNewAddressAllFieldEmpty");
				Log.error(e.getMessage());
				throw e;
			}
		
		
		
		//try {
			//Checkout_Page.DeliveryAddress.SaveandContinueBtn().click();
				//Log.info("Save and continue button clicked successfully");
				
				//if ((Checkout_Page.DeliveryAddress.SaveandContinueBtn().isDisplayed())) {
					//BaseClass.errorValidation += "Navigate to next page without entering address\n";
				//}
			//} catch (Exception e) {
			//	Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
				//Log.error(e.getMessage());
				//throw e;
			//}
			//Thread.sleep(5000);
			
		
			
        

			//Checkout_Page.DeliveryAddress.city().click();

			//Checkout_Page.DeliveryAddress.TermsandConditionsCheckBox().sendKeys(Keys.PAGE_DOWN);
			//Thread.sleep(1000);
			//Checkout_Page.DeliveryAddress.TermsandConditionsCheckBox().click();
			//Log.info("Terms and conditions option is selected successfully");

			//Checkout_Page.DeliveryAddress.SaveandContinueBtn().click();
			//Log.info("Save and continue button is clicked successfully");
			//Log.info("Address is entered successfully");

		} catch (Exception e) {
			Log.error("Exception in Class CheckOut_Action | Method ProceedwithNewAddressAllFieldEmpty");
			Log.error("Address is not entered successfully");
			throw e;
		}
	}

	public static void ProceedwithNewAddressPhoneNo(int iTestCaseRow) throws Exception {

		try {
			if (Checkout_Page.DeliveryAddress.DeliveryAddressNew().getAttribute("style").contains("none")) {
				Checkout_Page.DeliveryAddress.AddNewAddressBtn().click();
				Log.info("Add new address button is clicked successfully");
			}
			Checkout_Page.DeliveryAddress.firstName().clear();
			Checkout_Page.DeliveryAddress.lastName().clear();
			String firstName = ExcelUtils.getCellData(iTestCaseRow, Constant.firstName);
			Checkout_Page.DeliveryAddress.firstName().sendKeys(firstName);
			Log.info("First name is entered successfully");

			String lastName = ExcelUtils.getCellData(iTestCaseRow, Constant.lastName);
			Checkout_Page.DeliveryAddress.lastName().sendKeys(lastName);
			Log.info("Last name is entered successfully");

			//String phone = ExcelUtils.getCellData(iTestCaseRow, Constant.mobileNumber);
			//Checkout_Page.DeliveryAddress.phone().sendKeys(phone);
			//Log.info("Phone number is entered successfully");

			String address1 = ExcelUtils.getCellData(iTestCaseRow, Constant.address);
			Checkout_Page.DeliveryAddress.address1().sendKeys(address1);
			Log.info("Address 1 is entered successfully");

			String address2 = ExcelUtils.getCellData(iTestCaseRow, Constant.landmark);
			Checkout_Page.DeliveryAddress.address2().sendKeys(address2);
			Log.info("Address 2 is entered successfully");

			String postcode = ExcelUtils.getCellData(iTestCaseRow, Constant.postCode);
			Checkout_Page.DeliveryAddress.Postcode().sendKeys(postcode);
			Log.info("Postcode is entered successfully");
			
			Checkout_Page.DeliveryAddress.city().click();
			Thread.sleep(3000);
			
			try {
				Checkout_Page.DeliveryAddress.SaveandContinueBtn().click();
				Log.info("Save and continue button clicked successfully");
				
				if (!(Cart_Page.FirstNameFieldAlert().getText().equals("Please provide a number"))) {
					BaseClass.errorValidation += "Phone no. not present on page. \n";
				}
			} catch (Exception e) {
				Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
				Log.error(e.getMessage());
				throw e;
			}
			Thread.sleep(2000);
			
		
			try {
				
				String phone = ExcelUtils.getCellData(iTestCaseRow, Constant.alternativeMobile);
				Checkout_Page.DeliveryAddress.phone().sendKeys(phone);
				Log.info("Last name is entered successfully");
				Checkout_Page.DeliveryAddress.SaveandContinueBtn().click();
				if (!Cart_Page.FirstNameFieldAlert().getText().equals("Please enter a valid number.")) {
					BaseClass.errorValidation += "'Please enter the Valid NUMBER!' - . \n";
				}
			} catch (Exception e) {
				Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
				Log.error(e.getMessage());
				throw e;
			}
			Thread.sleep(2000);
			
          try {
				
				String phone = ExcelUtils.getCellData(iTestCaseRow, Constant.mobileNumber);
				Checkout_Page.DeliveryAddress.phone().clear();
				Checkout_Page.DeliveryAddress.phone().sendKeys(phone);
				Log.info("Phone No is entered successfully");
				Checkout_Page.DeliveryAddress.SaveandContinueBtn().click();
				
			} catch (Exception e) {
				Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
				Log.error(e.getMessage());
				throw e;
			}

        

			//Checkout_Page.DeliveryAddress.city().click();

			//Checkout_Page.DeliveryAddress.TermsandConditionsCheckBox().sendKeys(Keys.PAGE_DOWN);
			//Thread.sleep(1000);
			//Checkout_Page.DeliveryAddress.TermsandConditionsCheckBox().click();
			//Log.info("Terms and conditions option is selected successfully");

			//Checkout_Page.DeliveryAddress.SaveandContinueBtn().click();
			//Log.info("Save and continue button is clicked successfully");
			//Log.info("Address is entered successfully");

		} catch (Exception e) {
			Log.error("Exception in Class CheckOut_Action | Method ProceedwithNewAddress");
			Log.error("Address is not entered successfully");
			throw e;
		}
	}

	public static void ProceedwithNewAddressNoAddress(int iTestCaseRow) throws Exception {

		try {
			if (Checkout_Page.DeliveryAddress.DeliveryAddressNew().getAttribute("style").contains("none")) {
				Checkout_Page.DeliveryAddress.AddNewAddressBtn().click();
				Log.info("Add new address button is clicked successfully");
			}
			Checkout_Page.DeliveryAddress.firstName().clear();
			Checkout_Page.DeliveryAddress.lastName().clear();
			String firstName = ExcelUtils.getCellData(iTestCaseRow, Constant.firstName);
			Checkout_Page.DeliveryAddress.firstName().sendKeys(firstName);
			Log.info("First name is entered successfully");

			String lastName = ExcelUtils.getCellData(iTestCaseRow, Constant.lastName);
			Checkout_Page.DeliveryAddress.lastName().sendKeys(lastName);
			Log.info("Last name is entered successfully");

			String phone = ExcelUtils.getCellData(iTestCaseRow, Constant.mobileNumber);
			Checkout_Page.DeliveryAddress.phone().sendKeys(phone);
			Log.info("Phone number is entered successfully");

			//String address1 = ExcelUtils.getCellData(iTestCaseRow, Constant.address);
			//Checkout_Page.DeliveryAddress.address1().sendKeys(address1);
			//Log.info("Address 1 is entered successfully");

			String address2 = ExcelUtils.getCellData(iTestCaseRow, Constant.landmark);
			Checkout_Page.DeliveryAddress.address2().sendKeys(address2);
			Log.info("Address 2 is entered successfully");

			String postcode = ExcelUtils.getCellData(iTestCaseRow, Constant.postCode);
			Checkout_Page.DeliveryAddress.Postcode().sendKeys(postcode);
			Log.info("Postcode is entered successfully");
			
			Checkout_Page.DeliveryAddress.city().click();
			Thread.sleep(3000);
			
			try {
				Checkout_Page.DeliveryAddress.SaveandContinueBtn().click();
				Log.info("Save and continue button clicked successfully");
				
				if (!(Cart_Page.FirstNameFieldAlert().getText().equals("Please enter your Address"))) {
					BaseClass.errorValidation += "Address not present on page. \n";
				}
			} catch (Exception e) {
				Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
				Log.error(e.getMessage());
				throw e;
			}
			Thread.sleep(2000);
			
		
			try {
				
				String Address1 = ExcelUtils.getCellData(iTestCaseRow, Constant.alternativeAddress);
				Checkout_Page.DeliveryAddress.address1().sendKeys(Address1);
				Log.info("Last name is entered successfully");
				Checkout_Page.DeliveryAddress.SaveandContinueBtn().click();
				if (!Cart_Page.FirstNameFieldAlert().getText().equals("Please enter a valid number.")) {
					BaseClass.errorValidation += "'Please enter the Valid Address!' - . \n";
				}
			} catch (Exception e) {
				Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
				Log.error(e.getMessage());
				throw e;
			}
			Thread.sleep(2000);
			
          try {
				
				String Address1 = ExcelUtils.getCellData(iTestCaseRow, Constant.address);
				Checkout_Page.DeliveryAddress.address1().clear();
				Checkout_Page.DeliveryAddress.address1().sendKeys(Address1);
				Log.info("Phone No is entered successfully");
				Checkout_Page.DeliveryAddress.SaveandContinueBtn().click();
				
			} catch (Exception e) {
				Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
				Log.error(e.getMessage());
				throw e;
			}

        

			//Checkout_Page.DeliveryAddress.city().click();

			//Checkout_Page.DeliveryAddress.TermsandConditionsCheckBox().sendKeys(Keys.PAGE_DOWN);
			//Thread.sleep(1000);
			//Checkout_Page.DeliveryAddress.TermsandConditionsCheckBox().click();
			//Log.info("Terms and conditions option is selected successfully");

			//Checkout_Page.DeliveryAddress.SaveandContinueBtn().click();
			//Log.info("Save and continue button is clicked successfully");
			//Log.info("Address is entered successfully");

		} catch (Exception e) {
			Log.error("Exception in Class CheckOut_Action | Method ProceedwithNewAddress");
			Log.error("Address is not entered successfully");
			throw e;
		}
	}

	public static void ProceedwithNewAddressNoPinCode(int iTestCaseRow) throws Exception {

		try {
			if (Checkout_Page.DeliveryAddress.DeliveryAddressNew().getAttribute("style").contains("none")) {
				Checkout_Page.DeliveryAddress.AddNewAddressBtn().click();
				Log.info("Add new address button is clicked successfully");
			}
			Checkout_Page.DeliveryAddress.firstName().clear();
			Checkout_Page.DeliveryAddress.lastName().clear();
			String firstName = ExcelUtils.getCellData(iTestCaseRow, Constant.firstName);
			Checkout_Page.DeliveryAddress.firstName().sendKeys(firstName);
			Log.info("First name is entered successfully");

			String lastName = ExcelUtils.getCellData(iTestCaseRow, Constant.lastName);
			Checkout_Page.DeliveryAddress.lastName().sendKeys(lastName);
			Log.info("Last name is entered successfully");

			String phone = ExcelUtils.getCellData(iTestCaseRow, Constant.mobileNumber);
			Checkout_Page.DeliveryAddress.phone().sendKeys(phone);
			Log.info("Phone number is entered successfully");

			String address1 = ExcelUtils.getCellData(iTestCaseRow, Constant.address);
			Checkout_Page.DeliveryAddress.address1().sendKeys(address1);
			Log.info("Address 1 is entered successfully");

			String address2 = ExcelUtils.getCellData(iTestCaseRow, Constant.landmark);
			Checkout_Page.DeliveryAddress.address2().sendKeys(address2);
			Log.info("Address 2 is entered successfully");

			//String postcode = ExcelUtils.getCellData(iTestCaseRow, Constant.postCode);
			//Checkout_Page.DeliveryAddress.Postcode().sendKeys(postcode);
			//Log.info("Postcode is entered successfully");
			
			//String city = ExcelUtils.getCellData(iTestCaseRow, Constant.city);
			//Checkout_Page.DeliveryAddress.address2().sendKeys(city);
			//Log.info("city is entered successfully");
			//Checkout_Page.DeliveryAddress.city().click();
			Thread.sleep(2000);
			
			try {
				Checkout_Page.DeliveryAddress.SaveandContinueBtn().click();
				Log.info("Save and continue button clicked successfully");
				
				if (!(Cart_Page.FirstNameFieldAlert().getText().equals("Please enter valid pincode"))) {
					BaseClass.errorValidation += "Address not present on page. \n";
				}
			} catch (Exception e) {
				Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
				Log.error(e.getMessage());
				throw e;
			}
          try {
				
				String postcode = ExcelUtils.getCellData(iTestCaseRow, Constant.postCode);
				//Checkout_Page.DeliveryAddress.Postcode().clear();
				Checkout_Page.DeliveryAddress.Postcode().sendKeys(postcode);
				Checkout_Page.DeliveryAddress.city().click();
				Log.info("Phone No is entered successfully");
				Checkout_Page.DeliveryAddress.SaveandContinueBtn().click();
				
			} catch (Exception e) {
				Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
				Log.error(e.getMessage());
				throw e;
			}

        

			//Checkout_Page.DeliveryAddress.city().click();

			//Checkout_Page.DeliveryAddress.TermsandConditionsCheckBox().sendKeys(Keys.PAGE_DOWN);
			//Thread.sleep(1000);
			//Checkout_Page.DeliveryAddress.TermsandConditionsCheckBox().click();
			//Log.info("Terms and conditions option is selected successfully");

			//Checkout_Page.DeliveryAddress.SaveandContinueBtn().click();
			//Log.info("Save and continue button is clicked successfully");
			//Log.info("Address is entered successfully");

		} catch (Exception e) {
			Log.error("Exception in Class CheckOut_Action | Method ProceedwithNewAddress");
			Log.error("Address is not entered successfully");
			throw e;
		}
	}
	
	public static void ProceedwithNewAddressNoCity(int iTestCaseRow) throws Exception {

		try {
			if (Checkout_Page.DeliveryAddress.DeliveryAddressNew().getAttribute("style").contains("none")) {
				Checkout_Page.DeliveryAddress.AddNewAddressBtn().click();
				Log.info("Add new address button is clicked successfully");
			}
			Checkout_Page.DeliveryAddress.firstName().clear();
			Checkout_Page.DeliveryAddress.lastName().clear();
			String firstName = ExcelUtils.getCellData(iTestCaseRow, Constant.firstName);
			Checkout_Page.DeliveryAddress.firstName().sendKeys(firstName);
			Log.info("First name is entered successfully");

			String lastName = ExcelUtils.getCellData(iTestCaseRow, Constant.lastName);
			Checkout_Page.DeliveryAddress.lastName().sendKeys(lastName);
			Log.info("Last name is entered successfully");

			String phone = ExcelUtils.getCellData(iTestCaseRow, Constant.mobileNumber);
			Checkout_Page.DeliveryAddress.phone().sendKeys(phone);
			Log.info("Phone number is entered successfully");

			String address1 = ExcelUtils.getCellData(iTestCaseRow, Constant.address);
			Checkout_Page.DeliveryAddress.address1().sendKeys(address1);
			Log.info("Address 1 is entered successfully");

			String address2 = ExcelUtils.getCellData(iTestCaseRow, Constant.landmark);
			Checkout_Page.DeliveryAddress.address2().sendKeys(address2);
			Log.info("Address 2 is entered successfully");

			String postcode = ExcelUtils.getCellData(iTestCaseRow, Constant.postCode);
			Checkout_Page.DeliveryAddress.Postcode().sendKeys(postcode);
			Log.info("Postcode is entered successfully");
			
			//String city = ExcelUtils.getCellData(iTestCaseRow, Constant.city);
			//Checkout_Page.DeliveryAddress.address2().sendKeys(city);
			//Log.info("city is entered successfully");
			Checkout_Page.DeliveryAddress.city().click();
			Thread.sleep(3000);
			
			try {
				Checkout_Page.DeliveryAddress.SaveandContinueBtn().click();
				
				Log.info("Save and continue button clicked successfully");
				
				if (!(Cart_Page.FirstNameFieldAlert().getText().equals("Please enter your city"))) {
					BaseClass.errorValidation += "City Name not present on page. \n";
				}
			} catch (Exception e) {
				Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
				Log.error(e.getMessage());
				throw e;
			}

			//Checkout_Page.DeliveryAddress.city().click();

			//Checkout_Page.DeliveryAddress.TermsandConditionsCheckBox().sendKeys(Keys.PAGE_DOWN);
			//Thread.sleep(1000);
			//Checkout_Page.DeliveryAddress.TermsandConditionsCheckBox().click();
			//Log.info("Terms and conditions option is selected successfully");

			//Checkout_Page.DeliveryAddress.SaveandContinueBtn().click();
			//Log.info("Save and continue button is clicked successfully");
			//Log.info("Address is entered successfully");

		} catch (Exception e) {
			Log.error("Exception in Class CheckOut_Action | Method ProceedwithNewAddress");
			Log.error("Address is not entered successfully");
			throw e;
		}
	}

	public static void CheckOut_Edit_Address(int iTestCaseRow) throws Exception {

		try {
			//MyAccount_Page.ProfilePage.EditAddressBtn().click();
			Checkout_Page.Paymentinfo.EditAddressBtn().click();

			String updateField = ExcelUtils.getCellData(iTestCaseRow, Constant.updatedField);
			String updateValue = "";

			if ("FirstName".equals(updateField)) {

				//MyAccount_Page.ProfilePage.Address.FirstName().clear();
				Checkout_Page.DeliveryAddress.firstName().clear();
				updateValue = ExcelUtils.getCellData(iTestCaseRow, Constant.updatedFirstName);
				Checkout_Page.DeliveryAddress.firstName().sendKeys(updateValue);

				Log.info("First Name is entered on Profile Page");

			}

			if ("PostCode".equals(updateField)) {

				//MyAccount_Page.ProfilePage.Address.PostCode().clear();
				Checkout_Page.DeliveryAddress.Postcode().clear();
				updateValue = ExcelUtils.getCellData(iTestCaseRow, Constant.updatedPostCode);
				Checkout_Page.DeliveryAddress.Postcode().sendKeys(updateValue);

				Log.info("PostCode is entered on Address Page");

			}

			if ("Address".equals(updateField)) {

				//MyAccount_Page.ProfilePage.Address.Address1().clear();
				Checkout_Page.DeliveryAddress.address1().clear();
				updateValue = ExcelUtils.getCellData(iTestCaseRow, Constant.updatedAddress);
				Checkout_Page.DeliveryAddress.address1().sendKeys(updateValue);

				Log.info("Address is entered on Address Page");

			}

			if ("City".equals(updateField)) {

				//MyAccount_Page.ProfilePage.Address.City().clear();
				Checkout_Page.DeliveryAddress.city().clear();
				updateValue = ExcelUtils.getCellData(iTestCaseRow, Constant.updatedCity);
				Checkout_Page.DeliveryAddress.city().sendKeys(updateValue);

				Log.info("City is entered on Address Page");

			}

			//if ("Landmark".equals(updateField)) {

				//MyAccount_Page.ProfilePage.Address.Landmark().clear();
				//Checkout_Page.DeliveryAddress.
				//updateValue = ExcelUtils.getCellData(iTestCaseRow, Constant.updatedLandmark);
				//MyAccount_Page.ProfilePage.Address.Landmark().sendKeys(updateValue);

				//Log.info("Landmark is entered on Address Page");

			//}

			if ("Phone".equals(updateField)) {

				//MyAccount_Page.ProfilePage.Address.Phone().clear();
				Checkout_Page.DeliveryAddress.phone().clear();
				updateValue = ExcelUtils.getCellData(iTestCaseRow, Constant.updatedMobile);
				Checkout_Page.DeliveryAddress.phone().sendKeys(updateValue);

				Log.info("Phone is entered on Address Page");

			}
			Checkout_Page.DeliveryAddress.SaveandContinueBtn().click();
			Log.info("Save and continue button is clicked successfully");
			Log.info("Address is entered successfully"); 
			

		} catch (Exception e) {
			Log.error("Exception in Class MyAccount_Action | Method Profile_Edit_Address");
			Log.error("Address is not updated successfully");
			throw (e);

		}

	}
	
	
	public static void orderUsingGiftCardFullAMount(int iTestCaseRow) throws Exception {
		try {
				String balance= Checkout_Page.Paymentinfo.payableamount().getText().substring(2);
				System.out.println(" sub total "+Checkout_Page.Paymentinfo.payableamount().getText());
				Checkout_Page.Paymentinfo.RedeemGiftCard().click();	
				Utils.jsClick(Checkout_Page.Paymentinfo.GiftCardRadio());
				String cardNumber = ExcelUtils.getCellData(iTestCaseRow, Constant.cardNumberEGVGiftFCC);
				String pin = ExcelUtils.getCellData(iTestCaseRow, Constant.pinEGVGiftFCC);
				String amtToBeRedeem = ExcelUtils.getCellData(iTestCaseRow, Constant.amountRedeem);
				Checkout_Page.Paymentinfo.RedeemCardNumber().sendKeys(cardNumber);
				Log.info("Card number is entered successfully");
				Log.info("Card number is entered successfully");
				Checkout_Page.Paymentinfo.RedeemCardPin().sendKeys(pin);
				Log.info("Pin number is entered successfully");
				Thread.sleep(1000);
				Log.info("clicked on the check balance link successfully");
				Checkout_Page.Paymentinfo.RedeemCard_AmtToRedeem().sendKeys(balance);
				Log.info("Amount to be redeeemed is entered successfully");
//				Utils.waitForElementTOclick(Checkout_Page.Paymentinfo.RedeemCardBtn());
				Utils.waitForPageLoad();
				Thread.sleep(5000);
				Log.info("Redeem button is clicked successfully");
				Log.info("EGV/Gift Card details entered successfully");
				
				if(Constant.URL!="https://www.shoppersstop.com/"){
					Utils.verifyElement(Checkout_Page.Paymentinfo.feedbackPopup());
					Utils.verifyElement(Checkout_Page.Paymentinfo.skip_Closebtn());
					Utils.waitForElementTOclick(Checkout_Page.Paymentinfo.feedbackPopup_Closebtn());
					
				}
		}catch (Exception e) {
				throw e;	
				
				}
				
			
	}

	public static void RedeemGiftCard_EGV_FCC(int iTestCaseRow) throws Exception {

		try {

			String paymentMode = ExcelUtils.getCellData(iTestCaseRow, Constant.giftCardEGVFCC);
//Utils.refresh();
		
			if (paymentMode.equals("GiftCard")) {
				String balance= Checkout_Page.Paymentinfo.payableamount().getText().substring(2);
				//double bala= Integer.parseInt(balance);
				double bala=Float.parseFloat(balance);
				System.out.println(bala);
				System.out.println(" sub total "+Checkout_Page.Paymentinfo.payableamount().getText());

				Checkout_Page.Paymentinfo.RedeemGiftCard().click();	
				
				Utils.jsClick(Checkout_Page.Paymentinfo.GiftCardRadio());
				String cardNumber = ExcelUtils.getCellData(iTestCaseRow, Constant.cardNumberEGVGiftFCC);
				String pin = ExcelUtils.getCellData(iTestCaseRow, Constant.pinEGVGiftFCC);
				String amtToBeRedeem = ExcelUtils.getCellData(iTestCaseRow, Constant.amountRedeem);
				Checkout_Page.Paymentinfo.RedeemCardNumber().sendKeys(cardNumber);
				Log.info("Card number is entered successfully");

				Log.info("Card number is entered successfully");

				Checkout_Page.Paymentinfo.RedeemCardPin().sendKeys(pin);
				Log.info("Pin number is entered successfully");
				
//				Checkout_Page.Paymentinfo.check_Balance_Link().click();
				Thread.sleep(1000);
				Log.info("clicked on the check balance link successfully");
				Checkout_Page.Paymentinfo.RedeemCard_AmtToRedeem().sendKeys(amtToBeRedeem);
				Log.info("Amount to be redeeemed is entered successfully");
//				Utils.waitForElementTOclick(Checkout_Page.Paymentinfo.RedeemCardBtn());
				Utils.waitForPageLoad();
				Thread.sleep(5000);
			  
				String PayableAmount=Checkout_Page.Paymentinfo.payableAmount().getText();
				System.out.println("payable amount After amount redem "+PayableAmount);

//				Checkout_Page.Paymentinfo.RedeemCardBtn().click();
				Log.info("Redeem button is clicked successfully");
				Log.info("EGV/Gift Card details entered successfully");
				
//				if(Constant.URL!="https://www.shoppersstop.com/"){
//					Utils.verifyElement(Checkout_Page.Paymentinfo.feedbackPopup());
//					Utils.verifyElement(Checkout_Page.Paymentinfo.skip_Closebtn());
//					Utils.verifyElement(Checkout_Page.Paymentinfo.feedbackPopup_Closebtn());
//					Checkout_Page.Paymentinfo.feedbackRating().click();
//				}
				
			}

			if (paymentMode.equals("EGV")) {
				Thread.sleep(5000);
				System.out.println(" sub total "+Checkout_Page.Paymentinfo.payableamount().getText());
				/*Checkout_Page.Paymentinfo.RedeemGiftCard().click();
				Log.info("GiftCard/EGV field is clicked successfully");

				Checkout_Page.Paymentinfo.RedeemCardTypeDiv().click();
				Thread.sleep(2000);
				Checkout_Page.Paymentinfo.RedeemCardType().selectByVisibleText("Electronic Gift Voucher");*/
				Checkout_Page.Paymentinfo.RedeemGiftCard().click();
				Thread.sleep(2000);
				Checkout_Page.Paymentinfo.EGiftCardRadio().click();
				Log.info("Electronic Gift Voucher option is selected from the dropdown");
				String cardNumber = ExcelUtils.getCellData(iTestCaseRow, Constant.cardNumberEGVGiftFCC);
				String pin = ExcelUtils.getCellData(iTestCaseRow, Constant.pinEGVGiftFCC);
				String amtToBeRedeem = ExcelUtils.getCellData(iTestCaseRow, Constant.amountRedeem);
				Checkout_Page.Paymentinfo.RedeemCardNumber().sendKeys(cardNumber);
				Log.info("Card number is entered successfully");

				Checkout_Page.Paymentinfo.RedeemCardPin().sendKeys(pin);
				Log.info("Pin number is entered successfully");
				
//				Checkout_Page.Paymentinfo.check_Balance_Link().click();
				Thread.sleep(1000);
				Log.info("clicked on the check balance link successfully");
				Checkout_Page.Paymentinfo.RedeemCard_AmtToRedeem().sendKeys(amtToBeRedeem);
				Log.info("Amount to be redeeemed is entered successfully");
//				Utils.waitForElementTOclick(Checkout_Page.Paymentinfo.RedeemCardBtn());
				Utils.waitForPageLoad();
				Thread.sleep(5000);
			  
				String PayableAmount=Checkout_Page.Paymentinfo.payableAmount().getText();
				System.out.println("payable amount After amount redem "+PayableAmount);

//				Checkout_Page.Paymentinfo.RedeemCardBtn().click();
				Log.info("Redeem button is clicked successfully");
				Log.info("EGV/Gift Card details entered successfully");
				Thread.sleep(5000);
				
//				if(Constant.URL!="https://www.shoppersstop.com/"){
//					Utils.verifyElement(Checkout_Page.Paymentinfo.feedbackPopup());
//					Utils.verifyElement(Checkout_Page.Paymentinfo.skip_Closebtn());
//					Utils.verifyElement(Checkout_Page.Paymentinfo.feedbackPopup_Closebtn());
//					Checkout_Page.Paymentinfo.feedbackRating().click();
//				}
				
			}

			if (paymentMode.equals("FCC")) {
				double fCCBalance;
				double pointsRedeemedBefore;
				double pointsRedeemedAfter;
				double fCCBalanceAfterRedemption;
				double pointsToBeRedeemed;

				Checkout_Page.Paymentinfo.RedeemFCC().click();

				pointsRedeemedBefore = 
						Utils.decimalReaderFromString(Checkout_Page.Paymentinfo.FCCRedeemdAmountText().getText());
				System.out.println(pointsRedeemedBefore);
				fCCBalance = 
						Utils.decimalReaderFromString(Checkout_Page.Paymentinfo.FCCAvailableAmountText().getText());
				System.out.println(fCCBalance);

				pointsToBeRedeemed = Double.parseDouble(ExcelUtils.getCellData(iTestCaseRow, Constant.amountRedeem));
				System.out.println(pointsToBeRedeemed);

				Log.info("First Citizen Points drop down field is clicked successfully");
				Checkout_Page.Paymentinfo.FCCRedeemAmount()
						.sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.amountRedeem));
				Log.info("FCC amount to be redemed is entered successfully");
				Checkout_Page.Paymentinfo.FCCRedeemPassword()
						.sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.pinEGVGiftFCC));
				Log.info("FCC password is entered successfully");
				Checkout_Page.Paymentinfo.FCCRedeemButton().click();
				Log.info("First Citizen Points Redeem button is clicked successfully");

				pointsRedeemedAfter = 
						Utils.decimalReaderFromString(Checkout_Page.Paymentinfo.FCCRedeemdAmountText().getText());
				System.out.println(pointsRedeemedAfter);

				if (!(pointsRedeemedAfter == (pointsRedeemedBefore + pointsToBeRedeemed))) {
					BaseClass.errorValidation += "Redemeed point count not increase by amount to be redeemed\n";
				}

				fCCBalanceAfterRedemption = 
						Utils.decimalReaderFromString(Checkout_Page.Paymentinfo.FCCAvailableAmountText().getText());
				System.out.println(fCCBalanceAfterRedemption);
				if (!(fCCBalanceAfterRedemption == (fCCBalance - pointsToBeRedeemed))) {
					BaseClass.errorValidation += "FCC balance not decreased by amount to be redeemed\n";
				}

				Checkout_Page.Paymentinfo.FCCRedeemAmount()
						.sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.amountRedeem));
				Log.info("FCC amount to be redemed is entered successfully");
				Checkout_Page.Paymentinfo.FCCRedeemPassword()
						.sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.pinEGVGiftFCC));
				Log.info("FCC password is entered successfully");
				Checkout_Page.Paymentinfo.FCCRedeemButton().click();
				Log.info("First Citizen Points Redeem button is clicked successfully");

				pointsRedeemedAfter = 
						Utils.decimalReaderFromString(Checkout_Page.Paymentinfo.FCCRedeemdAmountText().getText());
				System.out.println(pointsRedeemedAfter);
				if (!(pointsRedeemedAfter == (pointsRedeemedBefore + pointsToBeRedeemed + pointsToBeRedeemed))) {
					BaseClass.errorValidation += "Redemeed point count not increase by amount to be redeemed subsequently\n";
				}
				fCCBalanceAfterRedemption = 
						Utils.decimalReaderFromString(Checkout_Page.Paymentinfo.FCCAvailableAmountText().getText());
				System.out.println(fCCBalanceAfterRedemption);
				if (!(fCCBalanceAfterRedemption == (fCCBalance - (pointsToBeRedeemed + pointsToBeRedeemed)))) {
					BaseClass.errorValidation += "FCC Balance not decreased by amount to be redeemed subsequently\n";
				}

				Checkout_Page.Paymentinfo.RemoveFCC().click();
				Log.info("Remove FCC button clicked");

				pointsRedeemedAfter = 
						Utils.decimalReaderFromString(Checkout_Page.Paymentinfo.FCCRedeemdAmountText().getText());
				System.out.println(pointsRedeemedAfter);
				if (!(pointsRedeemedAfter == pointsRedeemedBefore)) {
					BaseClass.errorValidation += "Redeemed point not reset to zero after deleting FCC\n";
				}
				fCCBalanceAfterRedemption = 
						Utils.decimalReaderFromString(Checkout_Page.Paymentinfo.FCCAvailableAmountText().getText());
				System.out.println(fCCBalanceAfterRedemption);
				if (!(fCCBalanceAfterRedemption == fCCBalance)) {
					BaseClass.errorValidation += "FCC balance not reset to original amount after deleting FCC\n";
				}

				try {
					if (!(Checkout_Page.Paymentinfo.PaymentAlerts().get(0).getText()
							.equals("Loyalty points are released successfully")))
						;

				} catch (Exception e) {
					BaseClass.errorValidation += "Alert -' Loyalty points are released successfully' missing after deleting FCC \n";
				}
				Log.info("FCC details entered successfully");
			}

		} catch (Exception e) {
			Log.error("Exception in Class CheckOut_Action | Method RedeemGift_EGV");
			Log.error("Error in entering details for the redeem card");
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class CheckOut_Action | Method RedeemGift_EGV");
			Log.error("Error in entering details for the redeem card");
			throw new Exception(BaseClass.errorValidation);
		}

	}
	public static void NegativeScenarioForDebitCard() throws Exception{
		
		Utils.verifyElement(Checkout_Page.Paymentinfo.CC_Avenue_Error_Msg_Text());
		Checkout_Page.Paymentinfo.CC_Avenue_Error_Message();
	}
	
	
	
	public static void PaymentOption(int iTestCaseRow) throws Exception {

		try {
			String paymentMode = ExcelUtils.getCellData(iTestCaseRow, Constant.paymentOption);

			if (paymentMode.equals("CreditCard")) {
                Thread.sleep(1000);
				Utils.jsClick(Checkout_Page.Paymentinfo.CreditCardOption());
				Log.info("Credit card option is clicked successfully");
//				if(ExcelUtils.getCellData(iTestCaseRow, Constant.UserType).equals("Private")){
//					Utils.jsClick(Checkout_Page.Paymentinfo.NewCreditCardTab());
//				}
//				Checkout_Page.Paymentinfo.CreditCard_PayBtn().click();
//				String cardNumber = ExcelUtils.getCellData(iTestCaseRow, Constant.cardNumber);
//				String cvvNumber = ExcelUtils.getCellData(iTestCaseRow, Constant.CVV);
//				Checkout_Page.Paymentinfo.CreditCard_CardNumber().click();
//				Checkout_Page.Paymentinfo.CreditCard_CardNumber().sendKeys(cardNumber);
//				Log.info("Card number is entered successfully");
//				Checkout_Page.Paymentinfo.CreditCard_ExpiryMonth().selectByIndex(8);
//				Log.info("Month is selected successfully");
//				Checkout_Page.Paymentinfo.CreditCard_ExpiryYear().selectByIndex(2);
//				Log.info("Year is selected successfully");
//				Checkout_Page.Paymentinfo.CreditCard_CVV().sendKeys(cvvNumber);
//				Log.info("CVV number is entered successfully");
//				//Checkout_Page.Paymentinfo.CreditCard_Name();
//				Log.info("Card name is selected successfully");
//
//				Log.info("CreditCard details entered successfully");
//
//				Checkout_Page.Paymentinfo.CreditCard_PlaceOrderBtn().click();
//				Thread.sleep(2000);
//				if((Constant.URL!="https://www.shoppersstop.com/")){
//				Checkout_Page.Paymentinfo.EnterPassword().sendKeys("omnichannel2");
//				Checkout_Page.Paymentinfo.submitBtn().click();
//				Thread.sleep(15000);
//				}
//				Checkout_Page.Paymentinfo.ReturnToMerchantSite().click();
				

			}

			if (paymentMode.equals("Wallets")) {
				Thread.sleep(1000);
				Checkout_Page.Paymentinfo.OtherWallets().click();
				
				Log.info("Wallets option is clicked successfully");
				System.out.println("Wallets option is clicked successfully");
				Thread.sleep(1000);
			    String WalletName = ExcelUtils.getCellData(iTestCaseRow, Constant.bank);
			     List<String> walletOptions =Utils.csvDataReader(WalletName);
				List<WebElement> options = Checkout_Page.Paymentinfo.WalletDropDown().getOptions();
				ArrayList<String> Options=new ArrayList<String>();
				for(int i=0;i<options.size();i++)
				{
					Options.add(options.get(i).getText());
				}
				for(int i=0;i<walletOptions.size();i++)
				{
					for(int j=0;j<options.size();j++)
					{
						if(walletOptions.get(i).equalsIgnoreCase(Options.get(j)))
						{
							Checkout_Page.Paymentinfo.WalletDropDown().selectByValue(walletOptions.get(i));
							Checkout_Page.Paymentinfo.OtherWallets_Pay().click();
							Utils.waitForPageLoad();
							Thread.sleep(2000);
							Checkout_Page.Paymentinfo.select_Wallet().selectByValue(Options.get(j));
							Log.info("Wallet selected successfully");
							Thread.sleep(1000);
							Checkout_Page.Paymentinfo.make_Payment_Button();
							Thread.sleep(1000);
							Utils.driverNavigation("backward");
							Utils.waitForPageLoad();
							if(Utils.getPageTitle().equalsIgnoreCase("Checkout | Shoppers Stop"))
								Checkout_Page.Paymentinfo.OtherWallets().click();		
						}
					}
				}
		
				}

				
				
			if (paymentMode.equals("DebitCard")) {
				 Thread.sleep(1000);
				Utils.jsClick(Checkout_Page.Paymentinfo.DebitCardOption());
				Log.info("Debit card option is clicked successfully");
//				if(ExcelUtils.getCellData(iTestCaseRow, Constant.UserType).equals("Private")){
//					Utils.verifyElement(Checkout_Page.Paymentinfo.SavedCardTab());
//					Utils.jsClick(Checkout_Page.Paymentinfo.NewCardTab());
//					Thread.sleep(2000);
//				}
//				Checkout_Page.Paymentinfo.DebitCard_Pay().click();
				String cardNumber = ExcelUtils.getCellData(iTestCaseRow, Constant.cardNumber);
				String cvvNumber = ExcelUtils.getCellData(iTestCaseRow, Constant.CVV);
//				try{
//				Checkout_Page.anotherPayOption();
//				}catch(Exception e)
//				{
//					Log.info("Other payment option is not available");
//				}
//				Thread.sleep(2000);
//				Checkout_Page.Paymentinfo.DebitCard_Name().selectByIndex(1);
//				Log.info("Card name is selected successfully");
				Thread.sleep(2000);
				Checkout_Page.Paymentinfo.DebitCard_CardNumber().sendKeys(cardNumber);
				Log.info("Card number is entered successfully");
				Checkout_Page.Paymentinfo.DebitCard_ExpiryMonth().selectByValue("05");
				Log.info("Month is selected successfully");
				Checkout_Page.Paymentinfo.DebitCard_ExpiryYear().selectByValue("2020");;
				Log.info("Year is selected successfully");
				Checkout_Page.Paymentinfo.DebitCard_CVV().sendKeys(cvvNumber);
				Log.info("CVV number is entered successfully");
				Checkout_Page.Paymentinfo.name_On_Card().sendKeys("Saurabh");
				Log.info("Card Name entered successfully");
				Log.info("DebitCard details entered successfully");
				
				Checkout_Page.Paymentinfo.DebitCard_Pay_Button().click();
	//			Checkout_Page.Paymentinfo.ReturnToMerchantSite().click();
				

			}

			if (paymentMode.equals("NetBanking")) {
				 Thread.sleep(1000);
				Checkout_Page.Paymentinfo.NetBankingOption().click();
				Log.info("NetBanking option is clicked successfully");
				Thread.sleep(2000);
				String bankSelection = ExcelUtils.getCellData(iTestCaseRow, Constant.netbankingBankSelection);

				if (bankSelection.equals("SelectBankFromOptionList")) {
					String bankName = ExcelUtils.getCellData(iTestCaseRow, Constant.bank);
					Checkout_Page.Paymentinfo.NetBanking_SelectFromVisibleList(bankName).click();
					Log.info("Bank name selected from the options displayed");
				} else if (bankSelection.equals("SelectBankFromDropdown")) {
					String bankName = ExcelUtils.getCellData(iTestCaseRow, Constant.bank);
					List<String >bankOptions =Utils.csvDataReader(bankName);
					// Checkout_Page.Paymentinfo.NetBanking_SelectFromDropdownDiv().click();
					List<WebElement> options = Checkout_Page.Paymentinfo.NetBanking_SelectFromDropdown().getOptions();
					
					ArrayList<String> Options=new ArrayList<String>();
					for(int i=0;i<options.size();i++)
					{
						Options.add(options.get(i).getText());
					}
					for(int i=0;i<bankOptions.size();i++)
					{
						for(int j=0;j<options.size();j++)
						{
							if(bankOptions.get(i).equalsIgnoreCase(Options.get(j)))
							{
								Checkout_Page.Paymentinfo.NetBanking_SelectFromDropdown().selectByVisibleText(Options.get(j));
								Log.info("Bank selected successfully");
//								Checkout_Page.Paymentinfo.NetBanking_PlaceOrderBtn().click();
								Utils.waitForPageLoad();
								Thread.sleep(2000);
								Utils.driverNavigation("backward");
								Thread.sleep(1000);
								Utils.waitForPageLoad();
								Utils.driverNavigation("backward");
								Utils.waitForPageLoad();
								if(Utils.getPageTitle().equalsIgnoreCase("Checkout | Shoppers Stop"))
									Checkout_Page.Paymentinfo.NetBankingOption().click();		
							}
						}
					}
				} else {
					throw new Exception("Invalid Bank selection criteria");
				}

				Log.info("Bank selected successfully");
			}

		} catch (Exception e) {
			Log.error("Exception in Class CheckOut_Action | Method PaymentOption");
			Log.error("Issue with Payment process");
			throw e;
		}
	}

	public static void Verify_OnClicking_Payment_Mode_Expand_And_Collapse() throws Exception{
		try{
			List<WebElement> list=Checkout_Page.Paymentinfo.ModeOfPayment();
			int numberOfDefaultModeOfPayment=list.size();
			for(int i=0;i<numberOfDefaultModeOfPayment;i++){
				list.get(i).click();
				Thread.sleep(5000);
//				Checkout_Page.Paymentinfo.collapsePaymentMode().click();
			}
		}
		catch(Exception ex){
			throw new Exception("Expand and Collapse not working for Payment Method");
		}
		
	}	
	
public static void PaymentOption_MasterValidation(int iTestCaseRow) throws Exception{
		
		try {	
				Utils.verifyElement(Checkout_Page.Paymentinfo.GiftCardRadio());
				Utils.verifyElement(Checkout_Page.Paymentinfo.RedeemGiftCard());
				Utils.verifyElement(Checkout_Page.Paymentinfo.RedeemCardPin());
				Utils.verifyElement(Checkout_Page.Paymentinfo.RedeemCard_AmtToRedeem());
				Utils.verifyElement(Checkout_Page.Paymentinfo.RedeemCardBtn());
				Utils.verifyElement(Checkout_Page.Paymentinfo.RedeemCardNumber());
				
		}
		catch(Exception ex){
					BaseClass.errorValidation+="Validation of EGV/GC failed \n";
			}
		try{
			Checkout_Page.Paymentinfo.CreditCardOption().click();
			Log.info("Credit card option is clicked successfully");
			Utils.verifyElement(Checkout_Page.Paymentinfo.CreditCard_PayBtn());			
			}
			catch(Exception ex){
			BaseClass.errorValidation+="Validation of credit card option failed \n";
			}
			try{
				Checkout_Page.Paymentinfo.OtherWallets().click();
				Log.info("Wallets option is clicked successfully");
				 
			
				Utils.verifyElement(Checkout_Page.Paymentinfo.OtherWallets_Pay());
			}

				catch(Exception ex){
					BaseClass.errorValidation+="Validation of Wallets option failed \n";
				}
			try{
				
				Checkout_Page.Paymentinfo.DebitCardOption().click();
				Utils.verifyElement(Checkout_Page.Paymentinfo.DebitCard_Pay());
				
			}
			catch(Exception ex){
				BaseClass.errorValidation+="Validation of DebitCard Options failed \n";
			}
			try{
					
				Checkout_Page.Paymentinfo.NetBankingOption().click();
				Log.info("NetBanking option is clicked successfully");
				//Checkout_Page.Paymentinfo.NetBanking_SelectFromVisibleList(bankName);
		
				Utils.verifyElement(Checkout_Page.Paymentinfo.NetBanking_PlaceOrderBtn());

				
		}
		catch(Exception ex){
			BaseClass.errorValidation+="Validation of netbanking option failed \n";
		}
			try{
				
				Checkout_Page.Paymentinfo.COD_PaymentOption().click();
				Utils.verifyElement(Checkout_Page.Paymentinfo.COD_captcha());
				Utils.verifyElement(Checkout_Page.Paymentinfo.COD_Captcha_TextBox());
				Utils.verifyElement(Checkout_Page.Paymentinfo.COD_PlaceOrder());
				Utils.verifyElement(Checkout_Page.Paymentinfo.COD_ClickToChangeCaptcha());
			}
			catch(Exception ex){
				BaseClass.errorValidation+=" Validation of COD Payment option failed\n";
				throw ex;
			}
			try{
				Utils.verifyElement(Checkout_Page.Paymentinfo.ViewAllCoupons());
				Utils.verifyElement(Checkout_Page.Paymentinfo.txtBoxCoupon());
				Utils.verifyElement(Checkout_Page.Paymentinfo.ApplyCouponButton());
			}catch(Exception ex){
				BaseClass.errorValidation+=" Validation of View All Coupon Failed\n";
			}
		
}


public static void PaymentOption_cod(int iTestCaseRow) throws Exception {

	try {

		Utils.waitForElementPresence2(Checkout_Page.LoginDetails.ContinueAsGuest());
		Utils.jsClick(Checkout_Page.LoginDetails.ContinueAsGuest());
		Thread.sleep(5000);
		System.out.println("continue as guest clicked");
		String userEmail = "ABC"+ExcelUtils.getCellData(iTestCaseRow, Constant.emailId);
		Checkout_Page.LoginDetails.LoginEmailGuest().sendKeys(userEmail);
		Log.info("User email id is entered successfully");
		String userPhone = ExcelUtils.getCellData(iTestCaseRow, Constant.mobileNumber);
		Checkout_Page.LoginDetails.GuestMobileNumber().sendKeys(userPhone);
		Checkout_Page.LoginDetails.ContinueBtnGuest().click();
		Log.info("Continue button is clicked");
		Thread.sleep(15000);
		Utils.waitForPageLoad();
		if (Checkout_Page.GuestOTPPopup().isDisplayed()) {
			System.out.println("Otp is required to continue");
		} else {
			System.out.println("after if");
		CheckOut_Action.EnterPersonalInfoAtCheckOutPage(iTestCaseRow);
		Thread.sleep(5000);
		Checkout_Page.Paymentinfo.ProceedToPaymentButton().click();
		Thread.sleep(5000);
		System.out.println("proceed to payment clicked");
		Utils.waitForElementTOclick(Checkout_Page.Paymentinfo.COD_PaymentOption());
		System.out.println("COD payment option selected ");
		Utils.waitForElementPresence2(Checkout_Page.Paymentinfo.PlaceCodOrder());
		Utils.jsClick(Checkout_Page.Paymentinfo.PlaceCodOrder());
		Log.info(" place orer button clicked suceeful");
		System.out.println(" place orer button clicked suceeful");
		Utils.waitForElementPresence2(Checkout_Page.Paymentinfo.closeFeedback());
		Utils.waitForPageLoad();
		Utils.jsClick(Checkout_Page.Paymentinfo.closeFeedback());
		System.out.println(" feedback button  closed");
		System.out.println(">>>>>>>>>>>>>>>>>>>"+"\n"+Checkout_Page.Paymentinfo.thankYouMessage().getText());
		System.out.println(">>>>>>>>>>>>>>>>>>>"+"\n"+Checkout_Page.Paymentinfo.orderMessage().getText());
		}

	} catch (Exception e) {
		Log.error("Exception in Class PaymentOption_cod | Method PaymentOption_cod");
		Log.error("Issue with cod selection process");
		throw e;
	}
}

public static void PaymentOption_Wallets(int iTestCaseRow) throws Exception{
		
		Checkout_Page.Paymentinfo.WalletsOption().click();
		Log.info("Wallets option is clicked successfully");
		 
		try{
			  String WalletName = "FreeCharge";
			   Utils.verifyElement(Checkout_Page.Paymentinfo.Wallets_SelectFromVisibleList(WalletName));
			    //Checkout_Page.Paymentinfo.Wallets_SelectFromVisibleList(WalletName).sendKeys(Keys.ENTER);
				Checkout_Page.Paymentinfo.Wallets_SelectFromVisibleList(WalletName).click();
				Log.info("Freechanre Wallet selected from the options displayed");
				
		}catch (Exception e) {
			Log.error("Exception in Class PaymentOption_Wallets | Method PaymentOption_Wallets");
			Log.error("Issue with FreeCharge selection process");
			throw e;
		}
			
		try{
			  String WalletName = "jioMoney";
			   Utils.verifyElement(Checkout_Page.Paymentinfo.Wallets_SelectFromVisibleList(WalletName));
			    //Checkout_Page.Paymentinfo.Wallets_SelectFromVisibleList(WalletName).sendKeys(Keys.ENTER);
				Checkout_Page.Paymentinfo.Wallets_SelectFromVisibleList(WalletName).click();
				Log.info("Freechanre Wallet selected from the options displayed");
				
		}catch (Exception e) {
			Log.error("Exception in Class PaymentOption_Wallets | Method PaymentOption_Wallets");
			Log.error("Issue with FreeCharge selection process");
			throw e;
		}
		try{
			  String WalletName = "Mobikwik";
			   Utils.verifyElement(Checkout_Page.Paymentinfo.Wallets_SelectFromVisibleList(WalletName));
			    //Checkout_Page.Paymentinfo.Wallets_SelectFromVisibleList(WalletName).sendKeys(Keys.ENTER);
				Checkout_Page.Paymentinfo.Wallets_SelectFromVisibleList(WalletName).click();
				Log.info("Freechanre Wallet selected from the options displayed");
				
		}catch (Exception e) {
			Log.error("Exception in Class PaymentOption_Wallets | Method PaymentOption_Wallets");
			Log.error("Issue with FreeCharge selection process");
			throw e;
		}

		try{
			  String WalletName = "oxigen";
			   Utils.verifyElement(Checkout_Page.Paymentinfo.Wallets_SelectFromVisibleList(WalletName));
			    //Checkout_Page.Paymentinfo.Wallets_SelectFromVisibleList(WalletName).sendKeys(Keys.ENTER);
				Checkout_Page.Paymentinfo.Wallets_SelectFromVisibleList(WalletName).click();
				Log.info("Freechanre Wallet selected from the options displayed");
				
		}catch (Exception e) {
			Log.error("Exception in Class PaymentOption_Wallets | Method PaymentOption_Wallets");
			Log.error("Issue with FreeCharge selection process");
			throw e;
		}

		try{
			  String WalletName = "Paytm";
			   Utils.verifyElement(Checkout_Page.Paymentinfo.Wallets_SelectFromVisibleList(WalletName));
			    //Checkout_Page.Paymentinfo.Wallets_SelectFromVisibleList(WalletName).sendKeys(Keys.ENTER);
				Checkout_Page.Paymentinfo.Wallets_SelectFromVisibleList(WalletName).click();
				Log.info("Freechanre Wallet selected from the options displayed");
				
		}catch (Exception e) {
			Log.error("Exception in Class PaymentOption_Wallets | Method PaymentOption_Wallets");
			Log.error("Issue with FreeCharge selection process");
			throw e;
		}

		try{
			  String WalletName = "SBI Buddy";
			   Utils.verifyElement(Checkout_Page.Paymentinfo.Wallets_SelectFromVisibleList(WalletName));
			    //Checkout_Page.Paymentinfo.Wallets_SelectFromVisibleList(WalletName).sendKeys(Keys.ENTER);
				Checkout_Page.Paymentinfo.Wallets_SelectFromVisibleList(WalletName).click();
				Log.info("Freechanre Wallet selected from the options displayed");
				
		}catch (Exception e) {
			Log.error("Exception in Class PaymentOption_Wallets | Method PaymentOption_Wallets");
			Log.error("Issue with FreeCharge selection process");
			throw e;
		}
	
		}


	public static void RegisterAtCheckout(int iTestCaseRow) throws Exception {

		try {

			Checkout_Page.LoginDetails.DoNotHaveAccountBtn().click();
			Utils.waitForPageLoadLongTime();
			Log.info("Sign up button is clicked for registration");

			String fName = ExcelUtils.getCellData(iTestCaseRow, Constant.firstName);
			Checkout_Page.LoginDetails.First_name().sendKeys(fName);
			Log.info("First Name entered successfully");

//			String lName = ExcelUtils.getCellData(iTestCaseRow, Constant.lastName);
//			Checkout_Page.LoginDetails.last_name().sendKeys(lName);
			Log.info("Last Name entered successfully");

			String emailAddress = Utils.getCurrentTime(ExcelUtils.getCellData(iTestCaseRow, Constant.emailId));			
			Checkout_Page.LoginDetails.email().sendKeys(emailAddress);
			Log.info("Email id entered successfully");
			System.out.println(emailAddress);

			String pNumber = ExcelUtils.getCellData(iTestCaseRow, Constant.mobileNumber);
			Checkout_Page.LoginDetails.mobileNumber().sendKeys(pNumber);
			Log.info("Mobile number entered successfully");

			String password = ExcelUtils.getCellData(iTestCaseRow, Constant.password);
			Checkout_Page.LoginDetails.password().sendKeys(password);
			Log.info("Password entered successfully");

//			String cPassword = ExcelUtils.getCellData(iTestCaseRow, Constant.confirmPassword);
//			Checkout_Page.LoginDetails.Confirm_Password().sendKeys(cPassword);
//			Log.info("Confirm Password entered successfully");



			String gender = ExcelUtils.getCellData(iTestCaseRow, Constant.gender);

			if (gender.equals("Male")) {
				Checkout_Page.LoginDetails.genderMale().click();
				Log.info("Gender Male selected successfully");
			} else if (gender.equals("Female")) {
				Checkout_Page.LoginDetails.genderFemale().click();
				Log.info("Gender Female selected successfully");
			}

			Checkout_Page.LoginDetails.SignUpBtn().click();
			Log.info("Sign up button is clicked successfully");
			Reporter.log("Registration action is successfully performed");

		} catch (Exception e) {
			Log.error("Exception in Class CheckOut_Action | Method RegisterAtCheckout");
			Log.error("Registration action is not successful");
			throw e;
		}

	}
	
	public static void MultipleRedeemGift_EGV(int iTestCaseRow) throws Exception {

		try {

			String paymentMode = ExcelUtils.getCellData(iTestCaseRow, Constant.alternativeGiftCardEGVFCC);

			if (paymentMode.equals("GiftCard")) {
//				Checkout_Page.Paymentinfo.RedeemGiftCard().click();
				Log.info("GiftCard/EGV field is clicked succesfully");
				Checkout_Page.Paymentinfo.RedeemCardTypeDiv().click();
				
				System.out.println(Checkout_Page.Paymentinfo.RedeemCardType().getOptions().get(0).getText());
				System.out.println(Checkout_Page.Paymentinfo.RedeemCardType().getOptions().get(1).getText());
//				Checkout_Page.Paymentinfo.RedeemCardType().selectByIndex(1);
				Checkout_Page.Paymentinfo.RedeemCardType().selectByVisibleText("Gift Card");
				Checkout_Page.Paymentinfo.RedeemCardType().selectByVisibleText("Gift Card");
				Log.info("Gift card option is selected from the dropdown");

				String cardNumber = ExcelUtils.getCellData(iTestCaseRow, Constant.alternativeCardNumberEGVGiftFCC);
				String pin = ExcelUtils.getCellData(iTestCaseRow, Constant.alternativePinEGVGiftFCC);
				String amtToBeRedeem = ExcelUtils.getCellData(iTestCaseRow, Constant.alternativeAmountRedeem);
				Checkout_Page.Paymentinfo.RedeemCardNumber().sendKeys(cardNumber);
				Log.info("Card number is entered successfully");

				Checkout_Page.Paymentinfo.RedeemCardPin().sendKeys(pin);
				Log.info("Pin number is entered successfully");

				Checkout_Page.Paymentinfo.RedeemCard_AmtToRedeem().sendKeys(amtToBeRedeem);
				Log.info("Amount to be redeeemed is entered successfully");

				Checkout_Page.Paymentinfo.RedeemCardBtn().click();
				Log.info("Redeem button is clicked successfully");
			}

			if (paymentMode.equals("EGV")) {
				Checkout_Page.Paymentinfo.RedeemGiftCard().click();
				Log.info("GiftCard/EGV field is clicked successfully");

				Checkout_Page.Paymentinfo.RedeemCardTypeDiv().click();
				Checkout_Page.Paymentinfo.RedeemCardType().selectByVisibleText("Electronic Gift Voucher");
				Log.info("Electronic Gift Voucher option is selected from the dropdown");

				String cardNumber = ExcelUtils.getCellData(iTestCaseRow, Constant.alternativeCardNumberEGVGiftFCC);
				String pin = ExcelUtils.getCellData(iTestCaseRow, Constant.alternativePinEGVGiftFCC);
				String amtToBeRedeem = ExcelUtils.getCellData(iTestCaseRow, Constant.alternativeAmountRedeem);
				Checkout_Page.Paymentinfo.RedeemCardNumber().sendKeys(cardNumber);
				Log.info("Card number is entered successfully");

				Checkout_Page.Paymentinfo.RedeemCardPin().sendKeys(pin);
				Log.info("Pin number is entered successfully");

				Checkout_Page.Paymentinfo.RedeemCard_AmtToRedeem().sendKeys(amtToBeRedeem);
				Log.info("Amount to be redeeemed is entered successfully");

				Checkout_Page.Paymentinfo.RedeemCardBtn().click();
				Log.info("Redeem button is clicked successfully");
				Log.info("EGV/Gift Card details entered successfully");
			}

			if (paymentMode.equals("FCC")) {
				double fCCBalance;
				double pointsRedeemedBefore;
				double pointsRedeemedAfter;
				double fCCBalanceAfterRedemption;
				double pointsToBeRedeemed;

				Checkout_Page.Paymentinfo.RedeemFCC().click();

				pointsRedeemedBefore = 
						Utils.decimalReaderFromString(Checkout_Page.Paymentinfo.FCCRedeemdAmountText().getText());
				System.out.println(pointsRedeemedBefore);
				fCCBalance = 
						Utils.decimalReaderFromString(Checkout_Page.Paymentinfo.FCCAvailableAmountText().getText());
				System.out.println(fCCBalance);

				pointsToBeRedeemed = Double.parseDouble(ExcelUtils.getCellData(iTestCaseRow, Constant.amountRedeem));
				System.out.println(pointsToBeRedeemed);

				Log.info("First Citizen Points drop down field is clicked successfully");
				Checkout_Page.Paymentinfo.FCCRedeemAmount()
						.sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.amountRedeem));
				Log.info("FCC amount to be redemed is entered successfully");
				Checkout_Page.Paymentinfo.FCCRedeemPassword()
						.sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.pinEGVGiftFCC));
				Log.info("FCC password is entered successfully");
				Checkout_Page.Paymentinfo.FCCRedeemButton().click();
				Log.info("First Citizen Points Redeem button is clicked successfully");

				pointsRedeemedAfter = 
						Utils.decimalReaderFromString(Checkout_Page.Paymentinfo.FCCRedeemdAmountText().getText());
				System.out.println(pointsRedeemedAfter);

				if (!(pointsRedeemedAfter == (pointsRedeemedBefore + pointsToBeRedeemed))) {
					BaseClass.errorValidation += "Redemeed point count not increase by amount to be redeemed\n";
				}

				fCCBalanceAfterRedemption = 
						Utils.decimalReaderFromString(Checkout_Page.Paymentinfo.FCCAvailableAmountText().getText());
				System.out.println(fCCBalanceAfterRedemption);
				if (!(fCCBalanceAfterRedemption == (fCCBalance - pointsToBeRedeemed))) {
					BaseClass.errorValidation += "FCC balance not decreased by amount to be redeemed\n";
				}

				Checkout_Page.Paymentinfo.FCCRedeemAmount()
						.sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.amountRedeem));
				Log.info("FCC amount to be redemed is entered successfully");
				Checkout_Page.Paymentinfo.FCCRedeemPassword()
						.sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.pinEGVGiftFCC));
				Log.info("FCC password is entered successfully");
				Checkout_Page.Paymentinfo.FCCRedeemButton().click();
				Log.info("First Citizen Points Redeem button is clicked successfully");

				pointsRedeemedAfter = 
						Utils.decimalReaderFromString(Checkout_Page.Paymentinfo.FCCRedeemdAmountText().getText());
				System.out.println(pointsRedeemedAfter);
				if (!(pointsRedeemedAfter == (pointsRedeemedBefore + pointsToBeRedeemed + pointsToBeRedeemed))) {
					BaseClass.errorValidation += "Redemeed point count not increase by amount to be redeemed subsequently\n";
				}
				fCCBalanceAfterRedemption = 
						Utils.decimalReaderFromString(Checkout_Page.Paymentinfo.FCCAvailableAmountText().getText());
				System.out.println(fCCBalanceAfterRedemption);
				if (!(fCCBalanceAfterRedemption == (fCCBalance - (pointsToBeRedeemed + pointsToBeRedeemed)))) {
					BaseClass.errorValidation += "FCC Balance not decreased by amount to be redeemed subsequently\n";
				}

				Checkout_Page.Paymentinfo.RemoveFCC().click();
				Log.info("Remove FCC button clicked");

				pointsRedeemedAfter = 
						Utils.decimalReaderFromString(Checkout_Page.Paymentinfo.FCCRedeemdAmountText().getText());
				System.out.println(pointsRedeemedAfter);
				if (!(pointsRedeemedAfter == pointsRedeemedBefore)) {
					BaseClass.errorValidation += "Redeemed point not reset to zero after deleting FCC\n";
				}
				fCCBalanceAfterRedemption = 
						Utils.decimalReaderFromString(Checkout_Page.Paymentinfo.FCCAvailableAmountText().getText());
				System.out.println(fCCBalanceAfterRedemption);
				if (!(fCCBalanceAfterRedemption == fCCBalance)) {
					BaseClass.errorValidation += "FCC balance not reset to original amount after deleting FCC\n";
				}

				try {
					if (!(Checkout_Page.Paymentinfo.PaymentAlerts().get(0).getText()
							.equals("Loyalty points are released successfully")))
						;

				} catch (Exception e) {
					BaseClass.errorValidation += "Alert -' Loyalty points are released successfully' missing after deleting FCC \n";
				}
				Log.info("FCC details entered successfully");
			}

		} catch (Exception e) {
			Log.error("Exception in Class CheckOut_Action | Method RedeemGift_EGV");
			Log.error("Error in entering details for the redeem card");
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class CheckOut_Action | Method RedeemGift_EGV");
			Log.error("Error in entering details for the redeem card");
			throw new Exception(BaseClass.errorValidation);
		}

	}
	
	public static void verify_StaticElementsDisplayed_IN_AddressPage(int iTestCaseRow) throws Exception{
		try{
			System.out.println("checking delivery method text");
			Utils.waitForPageLoadLongTime();
			if(!Checkout_Page.selectAddress_Header().getAttribute("innerText").contains("DELIVERY METHOD"))
			{
				BaseClass.errorValidation += "'DELIVERY METHOD' Header is not displayed";
			}
			
			Utils.CheckEnability(Checkout_Page.deliveryAddressTab());
			System.out.println("checked delivery address tab");
			Utils.CheckEnability(Checkout_Page.expressStorePickupTab());
			System.out.println("checked expressStorePickupTab");
			Utils.jsClick(Checkout_Page.expressStorePickupTab());
			System.out.println("clciked on expressStorePickupTab");
			Utils.CheckEnability(Checkout_Page.selfPickup_Label());
			Utils.CheckEnability(Checkout_Page.someOnePickup_Label());
//			Utils.scrollingToPageBottom(Checkout_Page.changeStoreLink());
			//if((Constant.URL!="https://www.shoppersstop.com/")&&(Constant.URL!="https://uat.shopper-stop.in/")){
			Utils.CheckEnability(Checkout_Page.changeStoreLink());
			System.out.println("checked changeStoreLink ");
			//}
			Thread.sleep(3000);
			
//			if(!(Checkout_Page.billingAddress_Form().isDisplayed()))
//			{
//				System.out.println("not displayed");
//				BaseClass.errorValidation += " Billing address form is not displayed";
//			}
		} catch (Exception e) {
			Log.error("Exception in Class CheckOut_Action | Method verify_StaticElementsDisplayed_IN_AddressPage");
			throw e;
			
		}
		
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class CheckOut_Action | Method verify_StaticElementsDisplayed_IN_AddressPage");
			Log.error("Error in displaying billing address form");
			throw new Exception(BaseClass.errorValidation);
		}	
	}	
	
	public static void HappyPathFlow_StorePickup_FromCartPageToPaymentPage(int iTestCaseRow) throws Exception{
		try{
			Utils.jsClick(Cart_Page.CheckoutButton());
			Utils.waitForPageLoadLongTime();
			Thread.sleep(5000);
			//Checkout_Page.expressStorePickupTab().click();
			Utils.jsClick(Checkout_Page.expressStorePickupTab());
			Utils.waitForPageLoadLongTime();
			Checkout_Page.pincode_Field().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.postCode));
			Utils.waitForPageLoadLongTime();
			Checkout_Page.pincode_CheckBtn().click();
			Utils.waitForPageLoadLongTime();
			Thread.sleep(1000);
			//if((Constant.URL!="https://www.shoppersstop.com/")&&(Constant.URL!="https://uat.shopper-stop.in/")){
			Checkout_Page.selectStoreLink().click();
			Checkout_Page.pickupStoreBtn_IN_Popup().click();
			//}
			Thread.sleep(2000);
			strName=Checkout_Page.storeName().getText();
			Utils.CheckEnability(Checkout_Page.defaultBillingAddressCheckBox());
			Utils.jsClick(Checkout_Page.defaultBillingAddressCheckBox());
			Thread.sleep(1000);
			CheckOut_Action.publicUser_EnterBillingInfoAtCheckOutPage(iTestCaseRow);
			Thread.sleep(2000);
			Checkout_Page.DeliveryAddress.SaveandContinueBtn().click();
			//Checkout_Page.DeliveryAddress.CancelButton().click();
			Log.info("Save and continue button is clicked successfully");
			Log.info("Navigated to payment successfully");
		} catch (Exception e) {
			Log.error("Exception in Class CheckOut_Action | Method HappyPathFlow_StorePickup_FromCartPageToPaymentPage");
			Log.error("Navigation to payment page is not successfull");
			throw e;
		}
	}	
	
	
	public static void publicUser_EnterBillingInfoAtCheckOutPage(int iTestCaseRow) throws Exception {

		try {		
			
			Checkout_Page.pickup_BillingAddress.firstName().clear();
			Checkout_Page.pickup_BillingAddress.lastName().clear();
			String firstName = ExcelUtils.getCellData(iTestCaseRow, Constant.firstName);
			Checkout_Page.pickup_BillingAddress.firstName().sendKeys(firstName);
			Log.info("First name is entered successfully");

			String lastName = ExcelUtils.getCellData(iTestCaseRow, Constant.lastName);
			Checkout_Page.pickup_BillingAddress.lastName().sendKeys(lastName);
			Log.info("Last name is entered successfully");

//			String phone = ExcelUtils.getCellData(iTestCaseRow, Constant.mobileNumber);
//			Checkout_Page.pickup_BillingAddress.phone().sendKeys(phone);
//			Log.info("Phone number is entered successfully");
			
			String postcode = ExcelUtils.getCellData(iTestCaseRow, Constant.postCode);
			Checkout_Page.pickup_BillingAddress.postCode().sendKeys(postcode);
			Log.info("Postcode is entered successfully");
			
			String address1 = ExcelUtils.getCellData(iTestCaseRow, Constant.address);
			Checkout_Page.pickup_BillingAddress.address1().sendKeys(address1);
			Log.info("Address 1 is entered successfully");

			String address2 = ExcelUtils.getCellData(iTestCaseRow, Constant.landmark);
			Checkout_Page.pickup_BillingAddress.address2().sendKeys(address2);
			Log.info("Address 2 is entered successfully");			

			Checkout_Page.pickup_BillingAddress.city().click();	
	
		} catch (Exception e) {
			Log.error("Exception in Class CheckOut_Action | Method publicUser_EnterBillingInfoAtCheckOutPage");
			Log.error("Exception in entering billing address");
			throw e;
		}
	}	
	
	
	public static void storeSelection_IN_AddressPage(int iTestCaseRow) throws Exception{
		
	try{
	//	if((Constant.URL!="https://www.shoppersstop.com/")&&(Constant.URL!="https://uat.shopper-stop.in/")){
		Thread.sleep(2000);
		System.out.println("clicking on select store link");
		Utils.jsClick(Checkout_Page.selectStoreLink());
		System.out.println("clicked on select store link");
		Thread.sleep(1000);
		Utils.jsClick(Checkout_Page.pickupStoreBtn_IN_Popup());
		System.out.println("clicked on pickupStoreBtn_IN_Popup");
		Thread.sleep(3000);
		Utils.verifyElement(Checkout_Page.changeStoreLink());
		//}
		Thread.sleep(2000);
		Utils.scrollingToPageElementByCordinate(0,100);
		//Adding Billing address
		CheckOut_Action.EnterBillingInfoAtCheckOutPage(iTestCaseRow);
		System.out.println("billing info entered");
		String paymentOptions=Checkout_Page.Paymentinfo.PaymentClass().getAttribute("innerText");
		Log.info(paymentOptions);
		System.err.println(paymentOptions);
		if(paymentOptions.contains("COD"))
		{
			throw new Exception("COD is available for storePickup order");
		}
	} catch (Exception e) {
		Log.error("Exception in Class CheckOut_Action | Method storeSelection_IN_AddressPage");
		throw e;
		
	}
		
	}	
	
	public static void EnterBillingInfoAtCheckOutPage(int iTestCaseRow) throws Exception {

		try {		
			
			
			String firstName = ExcelUtils.getCellData(iTestCaseRow, Constant.firstName);
			Checkout_Page.pickup_BillingAddress.firstName().sendKeys(firstName);
			Log.info("First name is entered successfully");

			String lastName = ExcelUtils.getCellData(iTestCaseRow, Constant.lastName);
			Checkout_Page.pickup_BillingAddress.lastName().sendKeys(lastName);
			Log.info("Last name is entered successfully");

//			String phone = ExcelUtils.getCellData(iTestCaseRow, Constant.mobileNumber);
//			Checkout_Page.pickup_BillingAddress.phone().sendKeys(phone);
//			Log.info("Phone number is entered successfully");
			
			String postcode = ExcelUtils.getCellData(iTestCaseRow, Constant.postCode);
			Checkout_Page.pickup_BillingAddress.postCode().sendKeys(postcode);
			Log.info("Postcode is entered successfully");
			
			String address1 = ExcelUtils.getCellData(iTestCaseRow, Constant.address);
			Checkout_Page.pickup_BillingAddress.address1().sendKeys(address1);
			Log.info("Address 1 is entered successfully");

			String address2 = ExcelUtils.getCellData(iTestCaseRow, Constant.landmark);
			Checkout_Page.pickup_BillingAddress.address2().sendKeys(address2);
			Log.info("Address 2 is entered successfully");
			Checkout_Page.pickup_BillingAddress.city().click();
			Thread.sleep(2000);
			//Checkout_Page.DeliveryAddress.TermsandConditionsCheckBox().sendKeys(Keys.PAGE_DOWN);
			//Thread.sleep(1000);
			//Checkout_Page.DeliveryAddress.TermsandConditionsCheckBox().click();
			//Log.info("Terms and conditions option is selected successfully");
			Checkout_Page.DeliveryAddress.SaveandContinueBtn().click();
			//Checkout_Page.DeliveryAddress.CancelButton().click();
			Log.info("Save and continue button is clicked successfully");
			Log.info("Address is entered successfully");

		} catch (Exception e) {
			Log.error("Exception in Class CheckOut_Action | Method EnterBillingInfoAtCheckOutPage");
			Log.error("Exception in entering billing address");
			throw e;
		}
	}	
	
	public static void Verify_SignOut_At_Checkout_Flow(int iTestCaseRow) throws Exception {
		try{
			HomePage_Action.selectProductCategoryfromMenu(iTestCaseRow);
			Log.info("Product category selected successfully");
			Utils.waitForPageLoadLongTime();
			Thread.sleep(5000);
			Utils.jsClick(ProductListing_Page.secondproduct());
			Log.info("Product selected successfully");
			Utils.waitForPageLoadLongTime();
			Thread.sleep(5000);
			PDP_Action.product_selectSize(ProductDetails_Page.Product.size_variant_buttonlist());
			Thread.sleep(5000);
			Utils.waitForElementTOclick(ProductDetails_Page.Product.Product_AddToCart());
			Log.info("Add to cart button is clicked");
			Utils.waitForPageLoadLongTime();
			Thread.sleep(2000);
			//mini cart is removed
			//Utils.verifyElement(MiniCart_Page.MiniCartWindow());
			//Log.info("Product is added to the cart and mini cart is displayed");
			Utils.waitForElementTOclick(Cart_Page.cartIcon());
			Utils.waitForPageLoadLongTime();
			Thread.sleep(5000);
			//Utils.verifyElement(Cart_Page.CheckOutButtonOnMiniCart());
			//Cart_Page.CheckOutButtonOnMiniCart().click();
			Utils.waitForElementPresence2(Cart_Page.CheckoutButton());
			Utils.waitForElementTOclick(Cart_Page.CheckoutButton());
			Log.info("Checkout button is clicked on cart page");
			Utils.waitForPageLoad();
	        Thread.sleep(2000);
	        Utils.waitForElementLongVisible(Checkout_Page.TopNavigation.shoppersStopLogo());
	        Thread.sleep(2000);
			verify_ShoppersstopLogo_At_Checkout_BeforeLogin();
			Utils.waitForPageLoadLongTime();
			Thread.sleep(2000);
			String userEmail = ExcelUtils.getCellData(iTestCaseRow, Constant.emailId);
			String userMobile = ExcelUtils.getCellData(iTestCaseRow, Constant.password);

			Checkout_Page.LoginDetails.LoginEmailRegisteredUser().sendKeys(userEmail);
			Log.info("User email id is entered successfully");
			Checkout_Page.LoginDetails.LoginPwdRegisteredUser().sendKeys(userMobile);
			Log.info("User Mobile number entered successfully");
			Utils.waitForPageLoadLongTime();
			Checkout_Page.LoginDetails.ContinueBtn().click();
			Utils.waitForPageLoadLongTime();
			Thread.sleep(20000);
			Log.info("continue button is clicked");
			//Utils.waitForElement(Checkout_Page.changeBtn());
			
			Utils.waitForElementLongNotVisible(Checkout_Page.LoginDetails.ContinueBtn());
			Thread.sleep(5000);
			verify_ShoppersstopLogo_At_Checkout_AfterLogin();
			Utils.waitForPageLoadLongTime();
			Thread.sleep(5000);
			Utils.waitForElementPresence2(Checkout_Page.changeBtn());
			verify_signout_At_Checkout(iTestCaseRow);
			Utils.waitForPageLoadLongTime();
			Thread.sleep(2000);
		}catch(Exception e){
			Log.error("Login At Checkout Failed");
			throw e;
		}
		
	}
	private static void verify_ShoppersstopLogo_At_Checkout_AfterLogin() throws Exception {
		try{
			String Checkouturl=Constant.URL+"checkout/multi/delivery-address/add?isCheckoutPage=true";			
			String currenturl=Utils.getURL();
			Utils.waitForElementPresence2( Checkout_Page.TopNavigation.shoppersStopLogo());
			if(!currenturl.equals(Checkouturl))
			{
				BaseClass.errorValidation += "Shoppers Stop Logo is clickable on checkout page";
			}
		}catch(Exception e){
			Log.error("Vefiry ShoppersstopLogo At Checkout Failed");
			throw e;
		}
		
	}
	private static void verify_ShoppersstopLogo_At_Checkout_BeforeLogin() throws Exception {
		try{
			String Checkouturl=Constant.URL+"login/checkout";			
			String currenturl=Utils.getURL();
			
	        Utils.waitForElementPresence2(Checkout_Page.TopNavigation.shoppersStopLogo());		
			if(!currenturl.equals(Checkouturl))
			{
				BaseClass.errorValidation += "Shoppers Stop Logo is clickable on checkout page";
			}
		}catch(Exception e){
			Log.error("Vefiry ShoppersstopLogo At Checkout Failed");
			throw e;
		}
		
	}
	public static void verify_signout_At_Checkout(int iTestCaseRow) throws Exception
	{
		try{
			Utils.waitForElementTOclick(Checkout_Page.changeBtn());
			Thread.sleep(3000);
			Utils.waitForElementTOclick(Checkout_Page.signout());
			Thread.sleep(2000);
			if (!(Checkout_Page.signoutAlert().getText().equals("You have signed out of your account."))) {
				BaseClass.errorValidation += "SignOut alert not present on page. \n";
			}
			String Checkouturl=Constant.URL+"login/checkout";			
			String currenturl=Utils.getURL();           			
			if(!currenturl.equals(Checkouturl))
			{
				BaseClass.errorValidation += "user remains in same page";
			}
		/*
		 * 	String userEmail = ExcelUtils.getCellData(iTestCaseRow, Constant.emailId);
		 *
			String userMobile = ExcelUtils.getCellData(iTestCaseRow, Constant.mobileNumber);
	        Utils.jsClick(Checkout_Page.LoginDetails.ContinueAsGuest());
			Checkout_Page.LoginDetails.LoginEmailGuest().sendKeys(userEmail);
			Log.info("User email id is entered successfully");
			Checkout_Page.LoginDetails.GuestMobileNumber().sendKeys(userMobile);
			Log.info("User Mobile number entered successfully");
			  Utils.jsClick(Checkout_Page.LoginDetails.ContinueBtnGuest());
			  Thread.sleep(2000);
		* Utils.verifyElement(Checkout_Page.continueShoppingBtn());
		*/	  
		}catch(Exception e){
			Log.error("Vefiry signout At Checkout Failed");
			throw e;
		}
	}			
}
