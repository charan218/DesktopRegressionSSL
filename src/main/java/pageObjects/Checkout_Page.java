
package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utility.Log;
import utility.Utils;

public class Checkout_Page extends BaseClass {
	private static WebElement element = null;
	private static List<WebElement> element2 = null;
	private static Select option = null;
	public static String DeliveryOption;
	public static Select sel;

	public Checkout_Page(WebDriver Driver) {
		super(Driver);
	}
	public static WebElement paymentModes() throws Exception {

		try {
			Log.info("Locating paymentModes element");
			element = Driver.findElement(By.xpath("(//*[contains(@class,'pmtOptions')])[2]"));

			Log.info("paymentModes found on the checkout page");

		} catch (Exception e) {
			Log.error("Exception in Class Checkout_Page | Method paymentModes");
			Log.error("paymentModes link is not found on top navigation on the checkout page");
			throw e;
		}

		return element;

	}
	public static WebElement DropDownBtn() throws Exception {

		try {
			Log.info("Locating DropDownButton element");
			element = Driver.findElement(By.xpath("//*[@class='order-summary']//*[@class='summary']//*[@class='toggle-summary']"));
			Utils.highLight(element);
			Log.info("Shoppers Stop link is found on top navigation on the checkout page");

			
		} catch (Exception e) {
			Log.error("Exception in Class Checkout_Page | Method shoppersStopLogo");
			Log.error("DropDownButton is not found on top navigation on the checkout page");
			throw e;
		}

		return element;

	}
	
	
	public static WebElement anotherPayOption() throws Exception {

		try {
			Log.info("Locating DropDownButton element");
			 element = Driver.findElement(By.xpath(".//*[@id='anotherPayOption']/span[1]"));
			Utils.highLight(element);
			Log.info("Pay using another payment option. link is available");
			if(element.isDisplayed())
			{
				element.click();
			}


		} catch (Exception e) {
			Log.error("Exception in Class Checkout_Page | Method shoppersStopLogo");
			Log.error("Pay using another payment option. link is not available");
			throw e;
		}

		return element;

	}	
	
	public static class TopNavigation {
		public static WebElement CheckOutText() throws Exception {

			try {
				Log.info("Locating CheckOutText element");
				element = Driver
						.findElement(By.xpath("//div/h1[contains(text(), 'CHECKOUT')]"));

				Log.info(" Checkout text is found on the checkout page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method CheckOutText");
				Log.error("Checkout text is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement shoppersStopLogo() throws Exception {

			try {
				Log.info("Locating shoppersStopLogo element");
				element = Driver.findElement(By.xpath("//div[@class='cp-logo']"));

				Log.info("Shoppers Stop link is found on top navigation on the checkout page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method shoppersStopLogo");
				Log.error("Shoppers Stop link is not found on top navigation on the checkout page");
				throw e;
			}

			return element;

		}

	
		
		/*public static WebElement backToCartBtn() throws Exception {

			try {
				Log.info("Locating shoppersStopLogo element");
				element = Driver.findElement(By.xpath("//header[@class='cp-header']/div/a"));

				Log.info("Shoppers Stop link is found on top navigation on the checkout page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method shoppersStopLogo");
				Log.error("Shoppers Stop link is not found on top navigation on the checkout page");
				throw e;
			}

			return element;

		}*/
	}
	
	

	public static class DeliveryAddress {
		public static WebElement DeliveryAddressNew() throws Exception {

			try {
				Log.info("Locating DeliveryAddressNew element");
				element = Driver.findElement(By.xpath("//div[@class='delivery-address']/div[@class='delivery-form']"));

				Log.info(" New Address form is found");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method DeliveryAddressNew");
				Log.error("New Address form is not found");
				throw e;
			}

			return element;

		}

		public static WebElement AddNewAddressBtn() throws Exception {

			try {
				Log.info("Locating AddNewAddressBtn element");
				element = Driver.findElement(By.xpath("//*[@value='Add new address']"));
				Utils.highLight(element);
				Log.info("Add new address button is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method AddNewAddressBtn");
				Log.error("Add new address button is not found on the checkout Page");
				throw e;

			}

			return element;

		}

		public static WebElement ProceedToPayment() throws Exception {

			try {
				Log.info("Locating ProceedToPayment element");
				element = Driver.findElement(By.xpath("//button[text()='Proceed to payment']"));

				Log.info("Proceed to Payment button is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method ProceedToPayment");
				Log.error("Proceed to Payment button is not found on the checkout Page");
				throw e;

			}

			return element;

		}

		public static List<WebElement> DeliveryAddressExistingList() throws Exception {

			try {
				Log.info("Locating DeliveryAddressExistingList elements");
				element2 = Driver
						.findElements(By.xpath("//div[@class='delivery-addresses']//div[@class='viewport']//li"));

				Log.info("Existing address list is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method DeliveryAddressExistingList");
				Log.error("Existing address list is not found on the checkout Page");
				throw e;

			}

			return element2;

		}

		public static WebElement firstName() throws Exception {

			try {
				Log.info("Locating firstName element");
				element = Driver.findElement(By.id("firstName"));
				Utils.highLight(element);
				Log.info("First name field is found under delivery address on checkout page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method firstName");
				Log.error("First name field is not found under delivery address on checkout page");
				throw e;

			}

			return element;

		}
	

		public static WebElement lastName() throws Exception {

			try {
				Log.info("Locating lastName element");
				element = Driver.findElement(By.id("lastName"));
				Utils.highLight(element);
				Log.info("Last name field is found under delivery address on checkout page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method lastName");
				Log.error("Last name field is not found under delivery address on checkout page");
				throw e;

			}

			return element;

		}

		public static WebElement phone() throws Exception {

			try {
				Log.info("Locating phone element");
				element = Driver.findElement(By.id("phone"));
				Utils.highLight(element);
				Log.info("Phone field is found under delivery address on checkout page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method phone");
				Log.error("Phone field is not found under delivery address on checkout page");
				throw e;

			}

			return element;

		}

		public static WebElement address1() throws Exception {

			try {
				Log.info("Locating address1 element");
				element = Driver.findElement(By.id("address1"));
				Utils.highLight(element);
				Log.info("Address 1 field is found under delivery address on checkout page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method address1");
				Log.error("Address 1 field is not found under delivery address on checkout page");
				throw e;

			}

			return element;

		}

		public static WebElement address2() throws Exception {

			try {
				Log.info("Locating address2 element");
				element = Driver.findElement(By.id("address2"));
				Utils.highLight(element);
				Log.info("Address 2 field is found under delivery address on checkout page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method address2");
				Log.error("Address 2 field is not found under delivery address on checkout page");
				throw e;

			}

			return element;

		}

		public static WebElement Postcode() throws Exception {

			try {
				Log.info("Locating Postcode element");
				element = Driver.findElement(By.id("postcode"));
				Utils.highLight(element);
				Log.info("Postcode field is found under delivery address on checkout page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method Postcode");
				Log.error("Postcode field is not found under delivery address on checkout page");
				throw e;

			}

			return element;

		}

		public static WebElement city() throws Exception {

			try {
				Log.info("Locating city element");
				element = Driver.findElement(By.id("townCity"));
				Utils.highLight(element);
				Log.info("City field is found under delivery address on checkout page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method city");
				Log.error("City field is not found under delivery address on checkout page");
				throw e;

			}

			return element;

		}

		public static WebElement TermsandConditionsCheckBox() throws Exception {

			try {
				Log.info("Locating TermsandConditionsCheckBox element");
				element = Driver.findElement(By.xpath("//*[@id='addressForm']//label[@for='saveInAddressBook']"));
				Utils.highLight(element);
				Log.info("Terms and condition checkbox is found under delivery address on checkout page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method TermsandConditionsCheckBox");
				Log.error("Terms and condition checkbox is not found under delivery address on checkout page");
				throw e;

			}

			return element;

		}
		public static WebElement ErrorMessageForEmptyFields() throws Exception {

			try {
				Log.info("Locating ErrorMessageForEmptyFields element");
				element = Driver.findElement(By.xpath("(//div[@class='ui-tooltip-content'])[1]"));
				Utils.highLight(element);
				Log.info("ErrorMessageForEmptyFields is found under delivery address on checkout page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method ErrorMessageForEmptyFields");
				Log.error("ErrorMessageForEmptyFields is not found under delivery address on checkout page");
				throw e;

			}

			return element;

		}
		public static WebElement SS_Policy_Checkbox() throws Exception{
			try{Log.info("Locating Terms and Agreement Checkbox");
			element=Driver.findElement(By.xpath("//*[@id='saveInAddressBook']"));
			Utils.highLight(element);
			}
			catch(Exception ex){
				Log.error("Unable to locate Policy Checkbox || Method SS_Policy_Checkbox");
			}
			return element;
		}
		public static WebElement SaveandContinueBtn() throws Exception {

			try {
				Log.info("Locating SaveandContinueBtn element");
				element = Driver.findElement(By.xpath("//button[@type='submit']"));
				Utils.highLight(element);
				Log.info("Save and continue button is found under delivery address on checkout page");
				

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method SaveandContinueBtn");
				Log.error("Save and continue button is not found under delivery address on checkout page");
				throw e;

			}

			return element;

		}
		

		public static WebElement CancelButton() throws Exception {

			try {
				Log.info("Locating CancelButton element");
				element = Driver.findElement(By.xpath("//input[@class='white-btn']"));
				Utils.highLight(element);
				Log.info("CancelButton is found under delivery address on checkout page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method CancelButton");
				Log.error("CancelButton is not found under delivery address on checkout page");
				throw e;

			}

			return element;

		}

	}

	public static class Paymentinfo {
		public static WebElement PaymentClass() throws Exception {
			try {
				Log.info("Locating PaymentClass element");
				element = Driver.findElement(By.xpath("(//*[contains(@class,'pmtOptions')])[2]"));
				Utils.highLight(element);
				Log.info("Payment class is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method PaymentClass");
				Log.error("Payment class is not found on the checkout Page");
				throw e;
			}
			return element;
		}
		
		public static Select select_Wallet()
		{
			try {
				Log.info("Locating WalletDropDown element");
				option=new Select(Driver
						.findElement(By.xpath("//select[@id='walletPaymentBank']")));
				
				//Utils.highLight(element);
				Log.info("WalletDropDow payment option is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method select_Wallet");
				Log.error("WalletDropDow payment option is not found on the checkout Page");
				throw e;
			}

			return option;

		}
		
		public static WebElement make_Payment_Button() {
			try {
				Log.info("Locating Make Payment Button element");
				element = Driver
						.findElement(By.xpath("//span[.='Make Payment']"));
				Utils.highLight(element);
				Log.info("Make Payment Button is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method make_Payment_Button");
				Log.error("Make Payment Buttony is not found on the checkout Page");
				throw e;
			}

			return element;
		}
		
		public static WebElement payableAmount() throws Exception {
			try {
				Log.info("Locating payableAmount element in payment page");
				element = Driver.findElement(By.xpath("//div[@class='amount-txt payamt']"));
				Utils.highLight(element);
				Log.info("payableAmount element is found on the payment Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method payableAmount");
				Log.error("payableAmount element is not found on the payment Page");
				throw e;
			}
			return element;
		}
		
		
		public static WebElement EnterPassword() throws Exception {
			try {
				Log.info("Locating password in payment page");
				element = Driver.findElement(By.id("txtPassword"));
				Utils.highLight(element);
				Log.info("password element is found on the payment Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method EnterPassword");
				Log.error("password element is not found on the payment Page");
				throw e;
			}
			return element;
		}
		public static WebElement submitBtn() throws Exception {
			try {
				Log.info("Locating submitBtn element in payment page");
				element = Driver.findElement(By.xpath("//div[@class='next-cancelBtn']"));
				Utils.highLight(element);
				Log.info("submitBtn element is found on the payment Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method submitBtn");
				Log.error("submitBtn element is not found on the payment Page");
				throw e;
			}
			return element;
		}
		public static WebElement feedbackPopup() throws Exception {
			try {
				Log.info("Locating feedback Popup after order placing");
				element = Driver.findElement(By.xpath("//div[@class='cnfbox']"));
				Utils.highLight(element);
				Log.info("feedback Popup is found after order placing");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method feedbackPopup");
				Log.error("feedback Popup is not found after order placing");
				throw e;
			}
			return element;
		}	
		
		public static WebElement feedbackEnter() throws Exception {
			try {
				Log.info("Locating feedbackEntering text box in feedback Popup");
				element = Driver.findElement(By.xpath("//textarea[@id='comments']"));
				Utils.highLight(element);
				Log.info("feedbackEntering text box is found feedback Popup");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method feedbackEnter");
				Log.error("feedbackEntering text box is not found feedback Popup");
				throw e;
			}
			return element;
		}
		
		public static WebElement feedbackPopup_Closebtn() throws Exception {
			try {
				Log.info("Locating feedback Popup Closebtn after order placing");
				element = Driver.findElement(By.xpath("//div[@class='cnfbox']/span[@class='close']"));
				Utils.highLight(element);
				Log.info("feedback Popup Closebtn is found after order placing");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method feedbackPopup_Closebtn");
				Log.error("feedback Popup Closebtn is not found after order placing");
				throw e;
			}
			return element;
		}	
		
		public static WebElement skip_Closebtn() throws Exception {
			try {
				Log.info("Locating skip_Closebtn after order placing in feedback popup");
				element = Driver.findElement(By.xpath("//a[contains(.,'Skip & Close')]"));
				Utils.highLight(element);
				Log.info("skip_Closebtn is found in feedback popup");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method skip_Closebtn");
				Log.error("fskip_Closebtn is not found in feedback popup");
				throw e;
			}
			return element;
		}
		
		public static WebElement submit_Closebtn() throws Exception {
			try {
				Log.info("Locating submit_Closebtn  in feedback Popup");
				element = Driver.findElement(By.xpath("//a[@class='btn-yes d-block']"));
				Utils.highLight(element);
				Log.info("submit_Closebtn is found in feedback popup");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method submit_Closebtn");
				Log.error("submit_Closebtn is not found in feedback popup");
				throw e;
			}
			return element;
		}	
		public static WebElement feedbackRating() throws Exception {
			try {
				Log.info("Locating feedbackRating element in feedback popup");
				element = Driver.findElement(By.xpath("//div[@class='csat-star-rating star-rating']/label[@class='star rb5l']"));
				Utils.highLight(element);
				Log.info("feedbackRating element is found in feedback popup");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method feedbackRating");
				Log.error("feedbackRating element is not found in feedback popup");
				throw e;
			}
			return element;
		}
		
		public static WebElement orderConfirmationPage() throws Exception {
			try {
				Log.info("Locating orderConfirmationPage ");
				element = Driver.findElement(By.xpath("//li[contains(.,'Order Confirmation')]"));
				Utils.highLight(element);
				Log.info("orderConfirmationPage is displayed");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method orderConfirmationPage");
				Log.error("orderConfirmationPage is not displayed");
				throw e;
			}
			return element;
		}
		
		public static WebElement InvalidCoupanAlert() throws Exception {

			try {
				Log.info("Locating PaymentClass element");
				//element = Driver.findElement(By.xpath("//label[@style='display: inline-block;']"));
				////
				//element = Driver.findElement(By.xpath("//p[@class='error desk'][contains(.,'Please enter a valid coupon code')]"));
				element = Driver.findElement(By.xpath("(//label[@class='error'][contains(.,'This field is required.')])[1]"));
				
				////
				Utils.highLight(element);
				Log.info("Payment class is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method PaymentClass");
				Log.error("Payment class is not found on the checkout Page");
				throw e;

			}

			return element;

		}
		public static List<WebElement> ModeOfPayment() throws Exception{		
			try{
				Log.info("Locating 5 Mode of Payment");
				element2=Driver.findElements(By.xpath("(//*[contains(@class,'pmtOptions')])[2]//li"));
				Log.info("Located all 5 Mode of Payment");
				Utils.HighlightAllElementOneByOne(element2);
				
			}
			catch(Exception ex){
				Log.error("Unable to locate Payment Modes");
				throw new Exception(ex);
			}
			return element2;
		}
		
		public static WebElement collapsePaymentMode() throws Exception{
			try{
				Log.info("Locating Payment mode Shrink Link");
				element=Driver.findElement(By.xpath(".//*[contains(@id,'sbSelector')]"));
				Utils.highLight(element);
			}
			catch(Exception ex){
				Log.error("Unable to locate Collapse Payment Link");
			}
			return element;
			
		}
		public static WebElement captcha() throws Exception{
			Log.info("Locating captcha");
			element=Driver.findElement(By.xpath("//div[contains(@class,'realperson-text')]"));
			Utils.highLight(element);
			return element;
		}
		public static WebElement catchaTextBox() throws Exception{
			try{
				element=Driver.findElement(By.xpath("//*[@id='defaultReal']"));
			}
			catch(Exception ex){
				Log.error("Unable to locate Catcha Text Box");
			}
			return element;
		}
		public static WebElement PromoCodeTextBox() throws Exception {

			try {
				Log.info("Locating PromoCodeTextBox element");
				element = Driver.findElement(By.xpath("//*[@id='paymentpromocode']/input[@name='voucherCode']"));

				Log.info("Promo code text field is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method PromoCodeTextBox");
				Log.error("Promo code text field is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement PromoCodeApplyBtn() throws Exception {

			try {
				Log.info("Locating PromoCodeApplyBtn element");
				element = Driver.findElement(By.xpath("(//*[@id='paymentpromocode']/input[@type='submit'])[1]"));

				Log.info("Promo code Apply button is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method PromoCodeApplyBtn");
				Log.error("Promo code Apply button is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement RedeemGiftCard() throws Exception {
			try {
				Log.info("Locating RedeemGiftCard element");
				element = Driver.findElement(By.xpath("//div[@class='tabbable tabs-left'] // li[contains(@class,'gv')]"));;
				//			element = Driver.findElement(By.linkText("Gift card / E-Gift voucher"));
				Utils.highLight(element);
				Log.info("Redeem Gift Card/EGift voucher dropdown is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method RedeemGiftCard");
				Log.error("Redeem Gift Card/EGift voucher dropdown is not found on the checkout Page");
				throw e;
			}

			return element;

		}
		public static WebElement GiftCardRadio() throws Exception {

			try {
				Log.info("Locating RedeemGiftCard element");
				element = Driver.findElement(
						By.id("giftcard"));
				Utils.highLight(element);
				Log.info("Redeem Gift Card/EGift voucher dropdown is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method RedeemGiftCard");
				Log.error("Redeem Gift Card/EGift voucher dropdown is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		
		public static WebElement EGiftCardRadio() throws Exception {

			try {
				Log.info("Locating RedeemGiftCard element");
				element = Driver.findElement(
						By.id("egiftvoucher"));
				Utils.highLight(element);
				Log.info("Redeem Gift Card/EGift voucher dropdown is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method RedeemGiftCard");
				Log.error("Redeem Gift Card/EGift voucher dropdown is not found on the checkout Page");
				throw e;
			}

			return element;

		}		
		
		public static WebElement RedeemedGiftCardEGVAmount() throws Exception {

			try {
				Log.info("Locating RedeemedGiftCardEGVAmount element");
				element = Driver
						.findElement(By.xpath("//div[@class='reedem-wrap']//h5[contains(text(),'Gift Card')]/span"));

				Log.info("Redeemed Gift Card/EGift voucher amount container is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method RedeemedGiftCardEGVAmount");
				Log.error("Redeemed Gift Card/EGift voucher amount container is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement RedeemFCC() throws Exception {

			try {
				Log.info("Locating First Citizen Points element");
				element = Driver.findElement(
						By.xpath("//div[@class='reedem-wrap']//h5[contains(text(),'First Citizen')]/ancestor::li"));

				Log.info("First Citizen Points dropdown is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method RedeemFCC");
				Log.error("First Citizen Points dropdown is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement RedeemCardTypeDiv() throws Exception {

			try {
				Log.info("Locating RedeemCardTypeDiv element");
				element = Driver.findElement(By.xpath("//*[@id='checkoutNewGiftCardForm']//select"));
				Utils.highLight(element);
				Log.info("Redeem card type division field is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method RedeemCardTypeDiv");
				Log.error("Redeem card type division field is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static Select RedeemCardType() throws Exception {

			try {
				Log.info("Locating RedeemCardType element");
				option = new Select(Driver.findElement(By.xpath("//*[@id='checkoutNewGiftCardForm']//select")));
				element=Driver.findElement(By.xpath("//*[@id='checkoutNewGiftCardForm']//select"));
				Utils.highLight(element);
				Log.info("Redeem card type field is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method RedeemCardType");
				Log.error("Redeem card type field is not found on the checkout Page");
				throw e;
			}

			return option;

		}

		public static WebElement RedeemCardNumber() throws Exception {

			try {
				Log.info("Locating RedeemCardNumber element");
				element = Driver.findElement(By.id("giftCardNumber"));
				Utils.highLight(element);
				Log.info("Redeem Gift Card/EGift number is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method RedeemCardNumber");
				Log.error("Redeem Gift Card/EGift number is not found on the checkout Page");
				throw e;
			}

			return element;

		}
		public static WebElement Redeem_Message() throws Exception {

			try {
				Log.info("Locating Redeem_Message element");
				element = Driver.findElement(By.xpath("//div[contains(@class,'success-msg')]"));
				Utils.highLight(element);
				Log.info("Redeem_Message is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method Redeem_Message");
				Log.error("Redeem_Message is not found on the checkout Page");
				throw e;
			}

			return element;

		}
		

		public static WebElement RedeemCardPin() throws Exception {

			try {
				Log.info("Locating RedeemCardPin element");
				element = Driver.findElement(By.id("giftCardPin"));
				Utils.highLight(element);
				Log.info("Redeem Gift Card/EGift pin is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method RedeemCardPin");
				Log.error("Redeem Gift Card/EGift pin is not found on the checkout Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement check_Balance_Link() throws Exception {

			try {
				Log.info("Locating Check Balance Link element");
				element = Driver.findElement(By.xpath("//a[@class='check-balance']"));
				Utils.highLight(element);
				Log.info("Check Balance Link is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method check_Balance_Link");
				Log.error("Check Balance Link is not found on the checkout Page");
				throw e;
			}

			return element;
		}
		
		public static WebElement availabale_Balance() throws Exception {

			try {
				Log.info("Locating Availabale-Balance amount element");
				element = Driver.findElement(By.xpath("//input[@id='giftCardAvailableAmount']"));
				Utils.highLight(element);
				Log.info("Availabale-Balance amount is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method availabale_Balance");
				Log.error("Availabale-Balance amount is not found on the checkout Page");
				throw e;
			}

			return element;
		}
		
		public static WebElement exp_Date_Month() throws Exception {

			try {
				Log.info("Locating expiry Date&Month element");
				element = Driver.findElement(By.xpath("//input[@id='giftCardExpiryDate']"));
				Utils.highLight(element);
				Log.info("expiry Date&Month is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method exp_Date_Month");
				Log.error("expiry Date&Month is not found on the checkout Page");
				throw e;
			}

			return element;
		}
		
		public static WebElement RedeemCard_AmtToRedeem() throws Exception {

			try {
				Log.info("Locating RedeemCard_AmtToRedeem element");
				element = Driver.findElement(By.id("giftCardAmount"));
				Utils.highLight(element);
				Log.info("Gift Card/EGift amount to redeem is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method RedeemCard_AmtToRedeem");
				Log.error("Gift Card/EGift amount to redeem is not found on the checkout Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement payableamount() throws Exception {

			try {
				Log.info("Locating payableamount element");
				element = Driver.findElement(By.xpath("//div[@class='amount-txt amt']/span"));
				Utils.highLight(element);
				Log.info("payableamount amount to redeem is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method payableamount");
				Log.error("payableamount amount to redeem is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement RedeemCardBtn() throws Exception {

			try {
				Log.info("Locating RedeemCardBtn element");
				element = Driver.findElement(
						By.id("gcEgvRedeemBtn"));
				Utils.highLight(element);
				Log.info("Redeem button is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method RedeemCardBtn");
				Log.error("Redeem button is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement AddCard() throws Exception {

			try {
				Log.info("Locating AddCard element");
				element = Driver.findElement(By.xpath("//div[@class='add-card']"));
				Utils.highLight(element);
				Log.info("Add card button is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method AddCard");
				Log.error("Add card button is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement FCCRedeemAmount() {

			try {
				Log.info("Locating Redeem Amount field for FCC");
				element = Driver.findElement(
						By.xpath("//div[@id='firstcitizen']//form[@id='checkoutFCCForm']//input[@name='amount']"));
				Utils.highLight(element);
				Log.info("Redeem amount field for FCC is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method RedeemCardBtn");
				Log.error("Redeem amount field for FCC is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement FCCRedeemPassword() {
			try {
				Log.info("Locating Redeem Password field for FCC");
				element = Driver.findElement(
						By.xpath("//div[@id='firstcitizen']//form[@id='checkoutFCCForm']//input[@type='password']"));
				Utils.highLight(element);
				Log.info("Redeem password field for FCC is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method FCCRedeemPassword");
				Log.error("Redeem password field for FCC is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement FCCRedeemButton() {
			try {
				Log.info("Locating Redeem Button field for FCC");
				element = Driver.findElement(By.xpath(
						"//div[@id='firstcitizen']//form[@id='checkoutFCCForm']//button[@class='continue-btn']"));
				Utils.highLight(element);
				Log.info("Redeem Button field for FCC is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method FCCRedeemButton");
				Log.error("Redeem Button field for FCC is not found on the checkout Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement ProceedToPaymentButton() {
			try {
				Log.info("Locating ProceedToPayment Button on checkout page ");
				element = Driver.findElement(By.xpath(
						"//button[@id='checkout_proceed_to_pay_submit']"));
				Utils.highLight(element);
				Log.info("ProceedToPayment Button found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method FCCRedeemButton");
				Log.error("Redeem Button field for FCC is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement FCCRedeemdAmountText() {
			try {
				Log.info("Locating Redeemd amount text for FCC");
				element = Driver.findElement(By.xpath(".//*[@id='firstcitizen']//div[@class='redeemed-done']"));
				Utils.highLight(element);
				Log.info("Redeem Amount text field for FCC is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method FCCRedeemdAmountText");
				Log.error("Redeemd amount text for FCC is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement FCCAvailableAmountText() {
			try {
				Log.info("Locating Redeemd amount text for FCC");
				element = Driver.findElement(By.xpath(".//*[@id='firstcitizen']//div[@class='summary']/p[3]"));
				Utils.highLight(element);
				Log.info("FCC Available amount text is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method FCCAvailableAmountText");
				Log.error("FCC Available amount text is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement RemoveFCC() {
			try {
				Log.info("Locating Delete Icon for removing FCC");
				element = Driver.findElement(By.xpath(".//*[@id='firstcitizen']//div[@class='redeemed-done']/a/span"));
				Utils.highLight(element);
				Log.info("Delete Icon for removing FCC is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method RemoveFCC");
				Log.error("Delete Icon for removing FCC is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement TotalAmount() {
			try {
				Log.info("Locating Total amount price element");
				element = Driver.findElement(By.xpath(
						"//div[@class='reedem-summary']//label[text()='Total Amount']//following-sibling::span"));
				Utils.highLight(element);
				Log.info("Total amount element is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method TotalAmount");
				Log.error("Total amount element is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement RedeemedAmount() {
			try {
				Log.info("Locating Redeemed Amount element");
				element = Driver.findElement(By.xpath(
						"//div[@class='reedem-summary']//label[text()='Redeemed Amount']//following-sibling::span"));
				Utils.highLight(element);
				Log.info("Redeemed Amount is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method RedeemedAmount");
				Log.error("Redeemed Amount is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement BalancePayableAmount() {
			try {
				Log.info("Locating Balance payable Amount element");
				element = Driver.findElement(By.xpath(
						"//div[@class='reedem-summary']//label[text()='Balance payable Amount']//following-sibling::span"));
				Utils.highLight(element);
				Log.info("Balance payable Amount is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method BalancePayableAmount");
				Log.error("Balance payable Amount is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement CreditCardOption() throws Exception {

			try {
				Log.info("Locating CreditCardOption element");
				element =Driver.findElement(By.xpath("//li[@class='cc ']"));
				Utils.highLight(element);
				Log.info("Credit Card payment option is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method CreditCardOption");
				Log.error("Credit Card payment option is not found on the checkout Page");
				throw e;
			}

			return element;

		}
		public static WebElement NewCreditCardTab() throws Exception{
			try{
				element=Driver.findElement(By.xpath(".//*[@id='newCreditCardTab']/a"));
			}catch(Exception e){
				throw e;
			}
			return element;
		}
		public static WebElement SaveCardCheckBox() throws Exception{
			try{
				Log.info("Locating Save Card Checkbox");
				element=Driver.findElement(By.id("saveCardCredit11"));
				
			}catch(Exception e){
				Log.error("Unable to locate Save Card Checkbox");
				throw e;
			}
			return element;
		}

		public static WebElement EditAddressBtn() throws Exception {

			try {
				Log.info("Locating EditAddressBtn element");
				element = Driver.findElement(By.xpath("//*[@class='delivery-address']//li[1]//*[@class='edit']"));
				Log.info("Edit Address button is found on the profile Page");
				Utils.highLight(element);

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method EditAddressBtn");
				Log.error("Edit Address button is not found on the profile Page");
				throw e;
			}

			return element;

		}
		public static WebElement DebitCardOption() throws Exception {

			try {
				//p[contains(.,'Pay using your debit card')]
				Log.info("Locating DebitCardOption element");
				element = Driver
						.findElement(By.xpath("//a[contains(.,'Debit Card')]"));
				Utils.highLight(element);
				Log.info("Debit Card payment option is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method DebitCardOption");
				Log.error("Debit Card payment option is not found on the checkout Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement OtherWallets() throws Exception {

			try {
				Log.info("Locating OtherWallets element");
				element = Driver
						.findElement(By.xpath("//li[contains(@class,'ow payOption bank-wallets')]"));
				Utils.highLight(element);
				Log.info("OtherWallets payment option is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method OtherWallets");
				Log.error("OtherWallets payment option is not found on the checkout Page");
				throw e;
			}

			return element;

		}
		public static Select WalletDropDown() throws Exception {

			try {
				Log.info("Locating WalletDropDown element");
				option=new Select(Driver
						.findElement(By.xpath("//select[@id='walletID']")));
				
				//Utils.highLight(element);
				Log.info("OtherWallets payment option is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method OtherWallets");
				Log.error("OtherWallets payment option is not found on the checkout Page");
				throw e;
			}

			return option;

		}
		public static WebElement OtherWallets_Pay() throws Exception {

			try {
				Log.info("Locating OtherWallets_Pay element");
				element = Driver
						.findElement(By.id("orderSubmitBankWallets"));
				Utils.highLight(element);
				Log.info("OtherWallets_Pay is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method OtherWallets_Pay");
				Log.error("OtherWallets_Pay is not found on the checkout Page");
				throw e;
			}

			return element;

		}
		public static WebElement SavedCardTab() throws Exception {

			try {
				Log.info("Locating SavedCardTab element");
				element = Driver
						.findElement(By.xpath(".//*[@id='saveDebitCardTab']/a"));
				Utils.highLight(element);
				Log.info("SavedCardTab option is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method SavedCardTab");
				Log.error("SavedCardTab is not found on the checkout Page");
				throw e;
			}

			return element;

		}
		public static WebElement NewCardTab() throws Exception {

			try {
				Log.info("Locating NewCardTab element");
				element = Driver
						.findElement(By.xpath(".//*[@id='newDebitCardTab']/a"));
				Utils.highLight(element);
				Log.info("NewCardTab option is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method NewCardTab");
				Log.error("NewCardTab is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement NetBankingOption() throws Exception {

			try {
				Log.info("Locating NetBankingOption element");
				element = Driver.findElement(By.xpath("//a[contains(.,'Net BankingUse your preferred bank')]"));
						
				Utils.highLight(element);
				Log.info("NetBanking payment option is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method NetBankingOption");
				Log.error("NetBanking payment option is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement WalletsOption() throws Exception {

			try {
				Log.info("Locating Wallets elements");
				element = Driver
						.findElement(By.xpath("//div[@class='payment-options']//li[contains(@class,'bank-wallets')]"));
				Utils.highLight(element);
				Log.info("Wallets payment option is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method WalletsOption");
				Log.error("Wallets payment option is not found on the checkout Page");
				throw e;
			}

			return element;

		}
		public static WebElement CODOption() throws Exception {

			try {
				Log.info("Locating CODOption element");
				element = Driver
						.findElement(By.xpath("//div[@class='payment-options']//li[contains(@class,'codelivery')]"));
				Utils.highLight(element);
				Log.info("COD payment option is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method CODOption");
				Log.error("COD payment option is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement CreditCard_CardNumber() throws Exception {

			try {
				Log.info("Locating CreditCard_CardNumber element");
				element = Driver.findElement(By.xpath("//div[@id='cc']/descendant::input[@name='ccnum']"));
				Utils.highLight(element);
				Log.info("Credit Card number field is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method CreditCard_CardNumber");
				Log.error("Credit Card number field is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement CreditCard_CVV() throws Exception {

			try {
				Log.info("Locating CreditCard_CVV element");
				element = Driver.findElement(By.xpath(".//*[@id='ccvv']"));
				Utils.highLight(element);
				Log.info("Credit Card CVV field is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method CreditCard_CVV");
				Log.error("Credit Card CVV field is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement nameOnCC() throws Exception {

			try {
				Log.info("Locating CreditCard_name element");
				element = Driver.findElement(By.xpath("//form[@id='creditCardForm']/descendant::input[@name='ccname']"));
				Utils.highLight(element);
				Log.info("Credit Card name field is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method nameOnCC");
				Log.error("Credit Card CVV name is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static Select CreditCard_ExpiryMonth() throws Exception {

			try {
				Log.info("Locating CreditCard_ExpiryMonth element");
				option = new Select(
						Driver.findElement(By.xpath(".//*[@id='ccexpmon']")));
				element=Driver.findElement(By.xpath(".//*[@id='ccexpmon']"));
				Utils.highLight(element);
				Log.info("Credit Card expiry month field is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method CreditCard_ExpiryMonth");
				Log.error("Credit Card expiry month field is not found on the checkout Page");
				throw e;
			}

			return option;

		}

		public static Select CreditCard_ExpiryYear() throws Exception {

			try {
				Log.info("Locating CreditCard_ExpiryYear element");
				option = new Select(
						Driver.findElement(By.xpath(".//*[@id='ccexpyr']")));
				element=Driver.findElement(By.xpath(".//*[@id='ccexpyr']"));
				Utils.highLight(element);
				Log.info("Credit Card expiry year field is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method CreditCard_ExpiryYear");
				Log.error("Credit Card expiry year field is not found on the checkout Page");
				throw e;
			}

			return option;

		}

		public static Select CreditCard_Name() throws Exception {

			try {
				Log.info("Locating CreditCard_Name element");
				option = new Select(
						Driver.findElement(By.xpath("//*[@id='creditCardForm']//select[@name='card_name']")));
				element=Driver.findElement(By.xpath("//*[@id='creditCardForm']//select[@name='card_name']"));
				Utils.highLight(element);
				Log.info("Credit Card name field is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method CreditCard_Name");
				Log.error("Credit Card name field is not found on the checkout Page");
				throw e;
			}

			return option;

		}

		public static WebElement CreditCard_PlaceOrderBtn() throws Exception {

			try {
				Log.info("Locating CreditCard_PlaceOrderBtn element");
				element = Driver.findElement(By.xpath(".//*[@id='creditCardButton']"));
				Utils.highLight(element);
				Log.info("Credit Card place order button is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method CreditCard_PlaceOrderBtn");
				Log.error("Credit Card place order button is not found on the checkout Page");
				throw e;
			}

			return element;

		}
		public static WebElement CreditCard_PayBtn() throws Exception {

			try {
				Log.info("Locating CreditCard_PayBtn element");
				element = Driver.findElement(By.xpath("//li[@class='ccdc ']//a[@href='#cc']"));
				Utils.highLight(element);
				Log.info("CreditCard_PayBtn is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method CreditCard_PayBtn");
				Log.error("CreditCard_PayBtn is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement DebitCard_CardNumber() throws Exception {

			try {
				Log.info("Locating DebitCard_CardNumber element");
				element = Driver.findElement(By.xpath("(//input[@id='ccnum'])[2]"));
				Utils.highLight(element);
				Log.info("Debit Card number field is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method DebitCard_CardNumber");
				Log.error("Debit Card number field is not found on the checkout Page");
				throw e;
			}

			return element;

		}
		public static WebElement DebitCard_Pay() throws Exception {

			try {
				Log.info("Locating DebitCard_Pay element");
				element = Driver.findElement(By.id("debitCardButton"));
				Utils.highLight(element);
				Log.info("DebitCard_Pay is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method DebitCard_Pay");
				Log.error("DebitCard_Pay is not found on the checkout Page");
				throw e;
			}

			return element;

		}
		public static WebElement ReturnToMerchantSite() throws Exception {

			try {
				Log.info("Locating DebitCard_Pay element");
				element = Driver.findElement(By.xpath("//*[contains(@value,'Return')]"));
				Utils.highLight(element);
				Log.info("DebitCard_Pay is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method DebitCard_Pay");
				Log.error("DebitCard_Pay is not found on the checkout Page");
				throw e;
			}

			return element;

		}
		public static WebElement TotalPrice(){
			try{
				element=Driver.findElement(By.xpath("//span[@class='amt-payable right']"));
				Utils.highLight(element);
			}catch(Exception e){
				Log.error("Unable to find Total Price at checkout Page.");
				throw e;
			}
			return element;
		}
		public static List<WebElement> CC_Avenue_Error_Message() throws Exception{
			try{
				Log.info("Locating Error messages which CC Avenue returns to Storefrom");
				element2=Driver.findElements(By.xpath(".//*[@id='globalMessages']//div"));
				Utils.HighlightAllElementOneByOne(element2);
			}catch(Exception ex){
				Log.error("Unable to locate Error Messages");
				throw ex;
			}
			return element2;
		}
		public static WebElement CC_Avenue_Error_Msg_Text() throws Exception{
			try{
				Log.info("Locating Error message which CC Avenue returns to Storefrom");
				element=Driver.findElement(By.xpath(".//*[@id='globalMessages']/div/div[1]"));
				Utils.highLight(element);
			}catch(Exception ex){
				Log.error("Unable to locate Error Messages");
				throw ex;
			}
			return element;
		}

		public static WebElement DebitCard_CVV() throws Exception {

			try {
				Log.info("Locating DebitCard_CVV element");
				element = Driver.findElement(By.xpath("(//input[@id='ccvv'])[2]"));
				Utils.highLight(element);
				Log.info("Debit Card CVV field is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method DebitCard_CVV");
				Log.error("Debit Card CVV field is not found on the checkout Page");
				throw e;
			}

			return element;
		}
		
		public static WebElement name_On_Card() throws Exception {

			try {
				Log.info("Locating NameOnCard element");
				element = Driver.findElement(By.xpath("(//input[@placeholder='Name on Card*'])[2]"));
				Utils.highLight(element);
				Log.info("NameOnCard field is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method name_On_Card");
				Log.error("NameOnCard field is not found on the checkout Page");
				throw e;
			}

			return element;
		}
		
		
		public static Select DebitCard_ExpiryMonth() throws Exception {

			try {
				Log.info("Locating DebitCard_ExpiryMonth element");
				option = new Select(
						Driver.findElement(By.xpath("(//select[@id='ccexpmon'])[2]")));
				element=Driver.findElement(By.xpath("(//select[@id='ccexpmon'])[2]"));
				Utils.highLight(element);
				Log.info("Debit Card expiry month field is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method DebitCard_ExpiryMonth");
				Log.error("Debit Card expiry month field is not found on the checkout Page");
				throw e;
			}

			return option;

		}

		public static Select DebitCard_ExpiryYear() throws Exception {

			try {
				Log.info("Locating DebitCard_ExpiryYear element");
				option = new Select(
						Driver.findElement(By.xpath("(//select[@id='ccexpyr'])[2]")));
				element=Driver.findElement(By.xpath("(//select[@id='ccexpyr'])[2]"));
				Utils.highLight(element);
				Log.info("Debit Card expiry year field is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method DebitCard_ExpiryYear");
				Log.error("Debit Card expiry year field is not found on the checkout Page");
				throw e;
			}

			return option;

		}

		public static Select DebitCard_Name() throws Exception {

			try {
				Log.info("Locating DebitCard_Name element");
				option = new Select(
						Driver.findElement(By.xpath("//select[@id='debitCard']")));
				element=Driver.findElement(By.xpath("//select[@id='debitCard']"));
				Utils.highLight(element);
				Log.info("Debit Card name field is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method DebitCard_Name");
				Log.error("Debit Card name field is not found on the checkout Page");
				throw e;
			}

			return option;

		}

		public static WebElement DebitCard_Pay_Button() throws Exception {

			try {
				Log.info("Locating DebitCard_PlaceOrderBtn element");
				element = Driver.findElement(By.xpath("//button[@id='debitCardButton']"));
				Utils.highLight(element);
				Log.info("Debit Card place order button is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method DebitCard_PlaceOrderBtn");
				Log.error("Debit Card place order button is not found on the checkout Page");
				throw e;
			}

			return element;

		}
		public static WebElement NetBankingMakePayment() throws Exception {

			try {
				Log.info("Locating NetBankingMakePayment element");
				element = Driver.findElement(By.xpath(".//*[@id='SubmitBillShip']"));
				Utils.highLight(element);
				Log.info("NetBankingMakePayment button is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method NetBankingMakePayment");
				Log.error("NetBankingMakePayment button is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement NetBanking_SelectFromVisibleList(String bankName) throws Exception {

			try {
				
				Log.info("Locating NetBanking_SelectFromVisibleList element");
				element = Driver.findElement(By.xpath("//label[contains(.,'" + bankName + "')]"));
				Utils.highLight(element);
				Log.info("Entered bank option is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method NetBanking_SelectFromVisibleList");
				Log.error("Entered bank option is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement NetBanking_SelectFromDropdownDiv() throws Exception {

			try {
				Log.info("Locating NetBanking_SelectFromDropdownDiv element");
				element = Driver.findElement(By.xpath("//*[@id='netBankingForm']//select"));
				Utils.highLight(element);
				Log.info("All banks dropdown division element is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method NetBanking_SelectFromDropdownDiv");
				Log.error("All banks dropdown division element is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement Wallets_SelectFromVisibleList(String bankName) throws Exception {

			try {
				Log.info("Locating Wallets_SelectFromVisibleList element");
				element = Driver.findElement(By.xpath("//input[@value='" + bankName + "']"));
				Utils.highLight(element);
				
				Log.info("Entered Wallet option is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method Wallets_SelectFromVisibleList");
				Log.error("Entered Wallet option is not found on the checkout Page");
				throw e;
			}

			return element;

		}
		
		
		//// COD related Page objects 

		public static WebElement COD_PaymentOption() throws Exception {

			try {
				Log.info("Locating COD_PaymentOption element");
				element = Driver.findElement(By.xpath("//a[contains(text(),'COD')]"));
				Utils.highLight(element);
				Log.info("COD_PaymentOption is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method COD_PaymentOption");
				Log.error("COD_PaymentOption is not found on the checkout Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement COD_captcha() throws Exception {

			try {
				Log.info("Locating COD_captcha element");
				element = Driver.findElement(By.xpath("//div[contains(@class,'realperson-text')]"));
				Utils.highLight(element);
				Log.info("COD_captcha is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method COD_captcha");
				Log.error("COD_captcha is not found on the checkout Page");
				throw e;
			}

			return element;

		}
		public static WebElement COD_Captcha_TextBox() throws Exception{
			try{
				Log.info("Locating Text box for entering captcha");
				element=Driver.findElement(By.id("defaultReal"));
				Utils.highLight(element);
				Log.info("Located Text box for entering captcha");
			}
			catch(Exception ex){
				Log.error("Unable to Locate Textbox for captcha");
			}
			return element;
		}
		
		public static WebElement COD_PlaceOrder() throws Exception {

			try {
				Log.info("Locating COD_PlaceOrder element");
				element = Driver.findElement(By.id("codSubmitBtn"));
				Utils.highLight(element);
				Log.info("COD_PlaceOrder is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method COD_PlaceOrder");
				Log.error("COD_PlaceOrder is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement orderMessage() {
			try {
				Log.info("Locating orderMessage  on checkout page ");
				element = Driver.findElement(By.xpath(
						"//div[@class='order-content']/h3"));
				Utils.highLight(element);
				Log.info("orderMessage  found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method orderMessage");
				Log.error("orderMessage  field for cod is not found on the checkout Page");
				throw e;
			}

			return element;
		}

		public static WebElement thankYouMessage() {
			try {
				Log.info("Locating thankYouMessage  on checkout page ");
				element = Driver.findElement(By.xpath(
						"//div[@class='order-content']/h2"));
				Utils.highLight(element);
				Log.info("thankYouMessage  found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method thankYouMessage");
				Log.error("thankYouMessage  field for cod is not found on the checkout Page");
				throw e;
			}

			return element;
		}

		public static WebElement closeFeedback() {
			try {
				Log.info("Locating closeFeedback Button on checkout page ");
				element = Driver.findElement(By.xpath(
						"//div[@class='cnfbox']/span"));
				Utils.highLight(element);
				Log.info("closeFeedback Button found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method closeFeedback");
				Log.error("closeFeedback Button field for cod is not found on the checkout Page");
				throw e;
			}

			return element;

		}


		public static WebElement PlaceCodOrder() {
			try {
				Log.info("Locating PlaceCodOrder Button on checkout page ");
				element = Driver.findElement(By.xpath(
						"//button[@id='codSubmitBtn']"));
				Utils.highLight(element);
				Log.info("PlaceCodOrder Button found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method PlaceCodOrder");
				Log.error("PlaceCodOrder Button field for cod is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement COD_ClickToChangeCaptcha() throws Exception {

			try {
				Log.info("Locating COD_ClickToChangeCaptcha element");
				element = Driver.findElement(By.xpath("//div[@class='realperson-regen']"));
				Utils.highLight(element);
				Log.info("COD_ClickToChangeCaptcha is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method COD_ClickToChangeCaptcha");
				Log.error("COD_ClickToChangeCaptcha is not found on the checkout Page");
				throw e;
			}

			return element;

		}
		
		/// COD related Page Objects finished
		
		/*
		Coupon Related Objects
		*
		*/
		public static WebElement ViewAllCoupons() throws Exception{
			try{
				element=Driver.findElement(By.xpath("//a[@class='applyCoupon']"));
			}catch(Exception e){
				Log.error("Link View All Coupons not clickable");
				throw e;
			}
			return element;
		}
		public static WebElement txtBoxCoupon() throws Exception{
			try{
				element=Driver.findElement(By.id("cpnid"));
			}catch(Exception e){
				Log.error(" Textbox Coupons is not visible");
				throw e;
			}
			return element;
		}
		public static WebElement ApplyCouponButton() throws Exception {

			try {
				Log.info("Locating Apply Coupan Button on the cart page");
				element = Driver.findElement(By.xpath("(//input[@value='apply Coupon' or @value='apply'])[1]"));
				Utils.highLight(element);
				Log.info("Apply Coupan Button exist on the cart page");

			} catch (Exception e) {
				Log.error("Exception in Class Cart_Page | Method ApplyCoupanButton");
				Log.error("Apply Coupan Button does not exist on the cart page");
				throw e;
			}

			return element;

		}
		public static Select NetBanking_SelectFromDropdown() throws Exception {

			try {
				Log.info("Locating NetBanking_SelectFromDropdown element");
				option = new Select(Driver.findElement(By.xpath("//*[@id='netBankingForm']//select")));
				
				Log.info("All banks dropdown is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method NetBanking_SelectFromDropdown");
				Log.error("All banks dropdown is not found on the checkout Page");
				throw e;
			}

			return option;

		}

		public static WebElement NetBanking_PlaceOrderBtn() throws Exception {

			try {
				Log.info("Locating NetBanking_PlaceOrderBtn element");
				element = Driver.findElement(By.xpath("//*[@id='orderSubmitNetbanking']"));
				Utils.highLight(element);
				Log.info("NetBanking place order button is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method NetBanking_PlaceOrderBtn");
				Log.error("NetBanking place order button is not found on the checkout Page");
				throw e;
			}

			return element;

		}
	

		public static WebElement Wallet_PlaceOrderBtn() throws Exception {

			try {
				Log.info("Locating NetBanking_PlaceOrderBtn element");
				element = Driver.findElement(By.xpath("//*[@id='orderSubmitBankWallets']"));
				Utils.highLight(element);
				Log.info("Wallet place order button is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method Wallet_PlaceOrderBtn");
				Log.error("Wallet place order button is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static List<WebElement> PaymentAlerts() throws Exception {

			try {
				Log.info("Locating Payment related alert element");
				element2 = Driver.findElements(By.xpath(".//*[@id='globalMessages']/div[@class='global-alerts']"));

				Log.info("Payment related alert is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method PaymentAlerts");
				Log.error("Payment related alert is not found on the checkout Page");
				throw e;
			}

			return element2;

		}

	}

	public static class LoginDetails {

		public static WebElement LoginEmailGuest() throws Exception {

			try {
				Log.info("Locating LoginEmailGuest element");
				element = Driver.findElement(By.id("guestEmail"));
				Utils.highLight(element);
				Log.info("LoginEmail field is found on the checkout page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method LoginEmailGuest");
				Log.error("LoginEmail field is not found on the checkout Page");
				throw e;
			}

			return element;

		}
		public static WebElement GuestMobileNumber() throws Exception {

			try {
				Log.info("Locating GuestMobileNumber element");
				element = Driver.findElement(By.id("guestMobileNumber"));
				Utils.highLight(element);
				Log.info("GuestMobileNumber field is found on the checkout page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method GuestMobileNumber");
				Log.error("GuestMobileNumber field is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement LoginEmailRegisteredUser() throws Exception {

			try {
				Log.info("Locating LoginEmailRegisteredUser element");
				element = Driver.findElement(By.id("checkout_username"));
				Utils.highLight(element);
				Log.info("LoginEmail field is found on the checkout page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method LoginEmailRegisteredUser");
				Log.error("LoginEmail field is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement LoginPwdRegisteredUser() throws Exception {

			try {
				Log.info("Locating LoginPwdRegisteredUser element");
				element = Driver.findElement(By.id("checkout_password"));
				Utils.highLight(element);
				Log.info("Login Password field is found on the checkout page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method LoginPwdRegisteredUser");
				Log.error("Login Password field is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement Optionbtn_RegisteredUser() throws Exception {

			try {
				Log.info("Locating Optionbtn_RegisteredUser element");
				element = Driver.findElement(By.xpath("//label[@for='signin-radio']"));
				Utils.highLight(element);
				Log.info("Option button for registered user having password is found on the checkout page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method Optionbtn_RegisteredUser");
				Log.error("Option button for registered user having password is not found on the checkout Page");
				throw e;
			}

			return element;

		}
		public static WebElement ContinueAsGuest() throws Exception{
			element=Driver.findElement(By.xpath("//a[@class='continue-guest']"));
			System.out.println("element displayed");
			Utils.highLight(element);
			return element;
		}
		public static WebElement ContinueBtn() throws Exception {

			try {
				Log.info("Locating ContinueBtn element");
				element = Driver.findElement(By.id("checkout-login-existuser"));
				Utils.highLight(element);
				Log.info("Continue button is found on the checkout page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method ContinueBtn");
				Log.error("Continue button is not found on the checkout Page");
				throw e;
			}

			return element;

		}
		public static WebElement ContinueBtnGuest() throws Exception {

			try {
				Log.info("Locating ContinueBtnGuest element");
				element = Driver.findElement(By.id("checkout-login-guestuser"));
				Utils.highLight(element);
				Log.info("ContinueBtnGuest is found on the checkout page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method ContinueBtnGuest");
				Log.error("ContinueBtnGuest is not found on the checkout Page");
				throw e;
			}

			return element;

		}
		public static WebElement ForgotPwdBtn() throws Exception {

			try {
				Log.info("Locating ForgotPwdBtn element");
				element = Driver.findElement(By.id("j_forgotpassword"));
				Utils.highLight(element);
				Log.info("ForgotPwdBtn is found on the checkout page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method ForgotPwdBtn");
				Log.error("ForgotPwdBtn is not found on the checkout Page");
				throw e;
			}

			return element;

		}
		public static WebElement ForgotPwdEmail() throws Exception {

			try {
				Log.info("Locating ForgotPwdEmail element");
				element = Driver.findElement(By.id("femail"));
				Utils.highLight(element);
				Log.info("ForgotPwdEmail is found on the checkout page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method ForgotPwdEmail");
				Log.error("ForgotPwdEmail is not found on the checkout Page");
				throw e;
			}

			return element;

		}
		public static WebElement ForgotPwdClosePopUp() throws Exception {

			try {
				Log.info("Locating ForgotPwdClosePopUp element");
				element = Driver.findElement(By.xpath(".//*[@id='member-scroller']/span"));
				Utils.highLight(element);
				Log.info("ForgotPwdClosePopUp is found on the checkout page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method ForgotPwdClosePopUp");
				Log.error("ForgotPwdClosePopUp is not found on the checkout Page");
				throw e;
			}

			return element;

		}
		public static WebElement FacebookLogIn() throws Exception {

			try {
				Log.info("Locating FacebookLogIn element");
				element = Driver.findElement(By.xpath("(//*[@class='loginFacebook']//a[@class='fb-login'])[2]"));
				Utils.highLight(element);
				Log.info("FacebookLogIn is found on the checkout page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method FacebookLogIn");
				Log.error("FacebookLogIn is not found on the checkout Page");
				throw e;
			}

			return element;

		}
		public static WebElement GoogleLogIn() throws Exception {

			try {
				Log.info("Locating GoogleLogIn element");
				element = Driver.findElement(By.xpath(".//*[@id='googleLoginGuestBtn-desk']"));
				Utils.highLight(element);
				Log.info("GoogleLogIn is found on the checkout page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method GoogleLogIn");
				Log.error("GoogleLogIn is not found on the checkout Page");
				throw e;
			}

			return element;

		}
		public static WebElement SignUpButton() throws Exception {

			try {
				Log.info("Locating SignUpButton element");
				element = Driver.findElement(By.xpath("//*[@class='signUp-btn']"));

				Log.info("SignUpButton is found on the checkout page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method SignUpButton");
				Log.error("SignUpButton is not found on the checkout Page");
				throw e;
			}

			return element;

		}
		public static WebElement DoNotHaveAccountBtn() throws Exception {

			try {
				Log.info("Locating DoNotHaveAccountBtn element");
				element = Driver.findElement(By.xpath("//button[contains(text(),'SIGN UP')]"));

				Log.info("DoNotHaveAccountBtn is found on the checkout page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method DoNotHaveAccountBtn");
				Log.error("DoNotHaveAccountBtn is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement First_name() throws Exception {

			try {
				Log.info("Locating First_name element");
				element = Driver.findElement(By.xpath("//div[@class='fname']/input[@placeholder='First Name & Last Name*']"));
				Utils.highLight(element);
				Log.info("First Name field is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method First_name");
				Log.error("First Name link is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement last_name() throws Exception {

			try {
				Log.info("Locating last_name element");
				element = Driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
				Utils.highLight(element);
				Log.info("Last Name field is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method last_name");
				Log.error("Last Name link is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement email() throws Exception {

			try {
				Log.info("Locating email element");
				element = Driver.findElement(By.xpath("//div[contains(@class,'signUp')]//*[@id='email']"));
				Utils.highLight(element);
				Log.info("Email field is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method email");
				Log.error("Email field is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement password() throws Exception {

			try {
				Log.info("Locating password element");
				element = Driver.findElement(By.xpath("//input[@name='pwd']"));
				Utils.highLight(element);
				Log.info("password field is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method password");
				Log.error("password field is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement Confirm_Password() throws Exception {

			try {
				Log.info("Locating Confirm_Password element");
				element = Driver.findElement(By.xpath("//div[contains(@class,'signUp')]//*[@id='checkPwd']"));
				Utils.highLight(element);
				Log.info("Confirm_Password field is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method Confirm_Password");
				Log.error("Confirm_Password field is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement mobileNumber() throws Exception {

			try {
				Log.info("Locating mobileNumber element");
				element = Driver.findElement(By.xpath("//div[contains(@class,'signUp')]//*[@id='mobileNumber']"));
				Utils.highLight(element);
				Log.info("MobileNumber field is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method mobileNumber");
				Log.error("MobileNumber field is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement genderMale() throws Exception {

			try {
				Log.info("Locating genderMale element");
				element = Driver.findElement(By.xpath("//input[@id='gender_male']"));
				Utils.highLight(element);
				Log.info("Male gender option is found on the checkbox Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method genderMale");
				Log.error("Male gender option is not found on the checkbox Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement singuoOtp() throws Exception {

			try {
				Log.info("Locating otp element");
				element = Driver.findElement(By.xpath("//input[@name='registerOtp']"));
				Utils.highLight(element);
				Log.info("otp option is found on the checkbox Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method singuoOtp");
				Log.error("singuoOtp option is not found on the checkbox Page");
				throw e;
			}

			return element;

		}


		public static WebElement genderFemale() throws Exception {

			try {
				Log.info("Locating genderFemale element");
				element = Driver.findElement(By.xpath("//input[@id='gender_female']"));
				Utils.highLight(element);
				Log.info("Female gender option is found on the checkbox Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method genderFemale");
				Log.error("Female gender option is not found on the checkbox Page");
				throw e;
			}

			return element;

		}

		public static WebElement SignUpBtn() throws Exception {

			try {
				Log.info("Locating SignUpBtn element");
				element = Driver.findElement(By.xpath("//*[@class='login-common']/descendant::button[@value='continue']"));
				Utils.highLight(element);
				Log.info("Sign up button is found on the checkbox Page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method SignUpBtn");
				Log.error("Sign up button is not found on the checkbox Page");
				throw e;
			}

			return element;

		}
	}
	public static WebElement contiuesignup() throws Exception {

		try {
			Log.info("Locating contiuesignup element");
			element = Driver.findElement(By.xpath("//div[@class='check-val']/following-sibling::button"));
			Utils.highLight(element);
			Log.info("contiuesignup button is found on the checkbox Page");

		} catch (Exception e) {
			Log.error("Exception in Class Checkout_Page | Method contiuesignup");
			Log.error("contiuesignup button is not found on the checkbox Page");
			throw e;
		}

		return element;

	}


	public static WebElement expressStorePickupTab() throws Exception {

		try {
			Log.info("Express Store Pick Up");
			element =Driver.findElement(By.xpath("//a[contains(.,'Express Store Pick Up')]"));
			Utils.highLight(element);
			
		} catch (Exception e) {
			Log.error("Exception in Class Checkout_Page | Method SignUpBtn");
			Log.error("Sign up button is not found on the checkbox Page");
			throw e;
		}

		return element;

	}

	public static WebElement selectStoreLink() throws Exception {

		try {
			Log.info("Locating SignUpBtn element");
			element =Driver.findElement(By.xpath(".//*[@class='select-store']/a"));
			Utils.highLight(element);
			
		} catch (Exception e) {
			Log.error("Exception in Class Checkout_Page | Method SignUpBtn");
			Log.error("Sign up button is not found on the checkbox Page");
			throw e;
		}

		return element;

	}
	
	public static WebElement changeStoreLink() throws Exception {

		try {
			Log.info("Locating SignUpBtn element");
			element =Driver.findElement(By.xpath(".//*[@class='select-store']/a"));
			Utils.highLight(element);
			
		} catch (Exception e) {
			Log.error("Exception in Class Checkout_Page | Method SignUpBtn");
			Log.error("Sign up button is not found on the checkbox Page");
			throw e;
		}

		return element;

	}	
		
	public static WebElement pincodeDisplay() throws Exception {

		try {
			element=Driver.findElement(By.xpath("//div[@class='pincode_display']/span"));
			Utils.highLight(element);

		} catch (Exception e) {
			Log.error("Exception in Class Checkout_Page | Method SignUpBtn");
			Log.error("Sign up button is not found on the checkbox Page");
			throw e;
		}

		return element;

	}		
	
	
	public static WebElement storeName() throws Exception {

		try {
			element=Driver.findElement(By.xpath("//div[@class='storeName']/h4"));
			Utils.highLight(element);
			System.out.println("storename is highlighted");

		} catch (Exception e) {
			Log.error("Exception in Class Checkout_Page | Method SignUpBtn");
			Log.error("Sign up button is not found on the checkbox Page");
			throw e;
		}

		return element;

	}		
	
	
	public static WebElement selectAddress_Header() throws Exception {

		try {
			element=Driver.findElement(By.xpath("//div[@class='select-address-header header']"));
			Utils.highLight(element);

		} catch (Exception e) {
			Log.error("Exception in Class Checkout_Page | Method SignUpBtn");
			Log.error("Sign up button is not found on the checkbox Page");
			throw e;
		}
		
		return element;

	}	

	public static WebElement billingAddress_Form() throws Exception {

		try {
			element=Driver.findElement(By.xpath("//h4[contains(.,'Billing Address')]"));
			Utils.highLight(element);

		} catch (Exception e) {
			Log.error("Exception in Class Checkout_Page | Method SignUpBtn");
			Log.error("Sign up button is not found on the checkbox Page");
			throw e;
		}
		
		return element;

	}
		
	public static WebElement deliveryAddressTab() throws Exception {

		try {
			Log.info("Locating SignUpBtn element");
			element =Driver.findElement(By.xpath("//a[contains(.,'Delivery Address')]"));
			Utils.highLight(element);
			
		} catch (Exception e) {
			Log.error("Exception in Class Checkout_Page | Method SignUpBtn");
			Log.error("Sign up button is not found on the checkbox Page");
			throw e;
		}

		return element;

	}		

	public static WebElement selfPickup_Label() throws Exception {

		try {
			Log.info("Locating SignUpBtn element");
			element =Driver.findElement(By.xpath("//label[contains(.,'Self')]"));
			Utils.highLight(element);
			
		} catch (Exception e) {
			Log.error("Exception in Class Checkout_Page | Method SignUpBtn");
			Log.error("Sign up button is not found on the checkbox Page");
			throw e;
		}

		return element;

	}	
	
	public static WebElement someOnePickup_Label() throws Exception {

		try {
			Log.info("Locating SignUpBtn element");
			element =Driver.findElement(By.xpath("//label[contains(.,'Someone else')]"));
			Utils.highLight(element);
			
		} catch (Exception e) {
			Log.error("Exception in Class Checkout_Page | Method SignUpBtn");
			Log.error("Sign up button is not found on the checkbox Page");
			throw e;
		}

		return element;

	}		
	
	public static WebElement pincode_Field() throws Exception {

		try {
			Log.info("Locating pincode_Field");
			element = Driver.findElement(By.xpath("//input[@name='pincode']"));
			Utils.highLight(element);
			Log.info("pincode_Field is found in express StorePickup tab on checkout page");

		} catch (Exception e) {
			Log.error("Exception in Class Checkout_Page | Method pincode_Field");
			Log.error("pincode_Field is not found in express StorePickup tab on checkout page");
			throw e;
		}
		return element;
	}
	
	public static WebElement pincode_CheckBtn() throws Exception {

		try {
			Log.info("Locating pincode_CheckBtn ");
			element = Driver.findElement(By.xpath("//input[@value='CHECK']"));
			Utils.highLight(element);
			Log.info("pincode_CheckBtn is found in express StorePickup tab on checkout page");

		} catch (Exception e) {
			Log.error("Exception in Class Checkout_Page | Method pincode_CheckBtn");
			Log.error("pincode_CheckBtn is not found in express StorePickup tab on checkout page");
			throw e;
		}
		return element;
	}
	
	
	public static WebElement defaultBillingAddressCheckBox() throws Exception {

		try {
			Log.info("Locating defaultBillingAddressCheckBox");
			element = Driver.findElement(By.xpath(".//input[@id='useDefaultAddress']"));
			Utils.highLight(element);
			Log.info("defaultBillingAddressCheckBox field is found under Express storepickup on checkout page");

		} catch (Exception e) {
			Log.error("Exception in Class Checkout_Page | Method defaultBillingAddressCheckBox");
			Log.error("defaultBillingAddressCheckBox is not found under Express storepickup on checkout page");
			throw e;
		}
		return element;
	}	
		
	public static WebElement pickupStoreBtn_IN_Popup() throws Exception {

		try {
			element=Driver.findElement(By.xpath("//input[@value='Select Store for Pickup']"));
			Utils.highLight(element);

		} catch (Exception e) {
			Log.error("Exception in Class Checkout_Page | Method SignUpBtn");
			Log.error("Sign up button is not found on the checkbox Page");
			throw e;
		}
		
		return element;

	}	
	
	public static class pickup_BillingAddress {
		
		public static WebElement firstName() throws Exception {


			try {
				element=Driver.findElement(By.xpath("(//*[@id='firstName'])[2]"));
				Utils.highLight(element);

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method SignUpBtn");
				Log.error("Sign up button is not found on the checkbox Page");
				throw e;
			}
			
			return element;		
	}
	
	
		public static WebElement lastName() throws Exception {


			try {
				element=Driver.findElement(By.xpath("(//*[@id='lastName'])[2]"));
				Utils.highLight(element);

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method SignUpBtn");
				Log.error("Sign up button is not found on the checkbox Page");
				throw e;
			}
			
			return element;		
	}	
	
		public static WebElement postCode() throws Exception {

			try {
				Log.info("Locating Postcode element");
				element = Driver.findElement(By.xpath("(.//*[@id='postcode'])[2]"));
				Utils.highLight(element);
				Log.info("Postcode field is found under billing address on checkout page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method Postcode");
				Log.error("Postcode field is not found under billing address on checkout page");
				throw e;

			}

			return element;

		}
	
		public static WebElement address1() throws Exception {

			try {
				Log.info("Locating address1 element");
				element = Driver.findElement(By.xpath("(.//*[@id='address1'])[2]"));
				Utils.highLight(element);
				Log.info("Address 1 field is found under delivery address on checkout page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method address1");
				Log.error("Address 1 field is not found under delivery address on checkout page");
				throw e;

			}

			return element;

		}

		public static WebElement address2() throws Exception {
			
			try {
				Log.info("Locating address2 element");
				element = Driver.findElement(By.xpath("(.//*[@id='address2'])[2]"));
				Utils.highLight(element);
				Log.info("Address 2 field is found under delivery address on checkout page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method address2");
				Log.error("Address 2 field is not found under delivery address on checkout page");
				throw e;

			}

			return element;

		}
		public static WebElement city() throws Exception {

			try {
				Log.info("Locating city element");
				element = Driver.findElement(By.xpath("(.//*[@id='townCity'])[2]"));
				Utils.highLight(element);
				Log.info("City field is found under delivery address on checkout page");

			} catch (Exception e) {
				Log.error("Exception in Class Checkout_Page | Method city");
				Log.error("City field is not found under delivery address on checkout page");
				throw e;
			}
			return element;
		}	
	}
	
	public static WebElement changeBtn() {
		try {
			Log.info("Locating change button");
			element = Driver.findElement(By.xpath("//button[contains(.,'change')]"));
			Utils.highLight(element);
			Log.info("change button is found  on checkout page");

		} catch (Exception e) {
			Log.error("Exception in Class Checkout_Page | Method city");
			Log.error("change button is not found  on checkout page");
			throw e;
		}
		return element;
	}
	public static WebElement signout() {
		try {
			Log.info("Locating signout button");
			element = Driver.findElement(By.xpath("//a[@class='sign-out']"));
			Utils.highLight(element);
			Log.info("signout button is found  on checkout page");

		} catch (Exception e) {
			Log.error("Exception in Class Checkout_Page | Method signout");
			Log.error("signout button is not found  on checkout page");
			throw e;
		}
		return element;
	}	
	public static WebElement signoutAlert() {
		try {
			Log.info("Locating signout element");
			element = Driver.findElement(By.xpath("//div[@class='alert alert-warning alert-dismissable alert-logout']"));	
			Log.info("signoutAlert  is found under delivery address on checkout page");

		} catch (Exception e) {
			Log.error("Exception in Class Checkout_Page | Method signoutAlert");
			Log.error("signoutAlert  is not found under delivery address on checkout page");
			throw e;
		}
		return element;
	}	
	
	

	
	public static WebElement continueShoppingBtn() {
		try {
			Log.info("Locating continueShoppingBtn element");
			element = Driver.findElement(By.xpath("//a[contains(.,'Continue Shopping')]"));	
			Log.info("continueShopping button  is found under empty cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Checkout_Page | Method continueShoppingBtn");
			Log.error("continueShopping button  is not found under empty cart page");
			throw e;
		}
		return element;
	}		
	
	public static WebElement GuestOTPPopup() {
		try {
			Log.info("Locating GuestOTPPopup");
			element = Driver.findElement(By.xpath("//div[@id='guestMissingMobile']"));	
			Log.info("GuestOTPPopup  is found in checkout page");

		} catch (Exception e) {
			Log.error("Exception in Class Checkout_Page | Method GuestOTPPopup");
			Log.error("GuestOTPPopup  is not found in checkout page");
			throw e;
		}
		return element;
	}
	
	////
	public static WebElement SignUpOTPPopup() {
		try {
			Log.info("Locating SignUpOTPPopup");
			element = Driver.findElement(By.cssSelector("input#singupRegisterOtp"));	
			Log.info("SignUpOTPPopup  is found in checkout page");

		} catch (Exception e) {
			Log.error("Exception in Class Checkout_Page | Method SignUpOTPPopup");
			Log.error("SignUpOTPPopup  is not found in checkout page");
			throw e;
		}
		return element;
	}
	/////
	
	public static WebElement codTab() {
		try {
			Log.info("Locating codTab");
			element = Driver.findElement(By.xpath("//div[@class='tabbable tabs-left']//a[@href='#cod']"));	
			Log.info("codTab  is found in payment page");

		} catch (Exception e) {
			Log.error("Exception in Class Checkout_Page | Method codTab");
			Log.error("codTab  is not found in payment page");
			throw e;
		}
		return element;
	}	
	
	
	public static WebElement placeOrderBtn() {
		try {
			Log.info("Locating placeOrderBtn");
			element = Driver.findElement(By.xpath("//button[contains(.,'place order')]"));
			Log.info("placeOrderBtn  is found in payment page");

		} catch (Exception e) {
			Log.error("Exception in Class Checkout_Page | Method placeOrderBtn");
			Log.error("placeOrderBtn  is not found in payment page");
			throw e;
		}
		return element;
	}	
}
