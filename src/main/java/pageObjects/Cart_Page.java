 
package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;
import utility.Utils;


public class Cart_Page extends BaseClass {
	private static WebElement element = null;
	private static List<WebElement> elements = null;
	public Cart_Page(WebDriver Driver) {
		super(Driver);
	}

	/**
	 * =========================================================================
	 * =
	 **/
	public static WebElement verifywishlist() throws Exception {

		try {
			Log.info("Locating FROM YOUR WISHLIST element");
			element = Driver.findElement(By.xpath("//a[text()='FROM YOUR WISHLIST']"));
			Utils.highLight(element);
			Log.info("FROM YOUR WISHLIST  is found on wishlist ");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method verifywishlist");
			Log.error("FROM YOUR WISHLIST  is not found on the cart page");
			throw e;
		}

		return element;

}

	
	public static WebElement cartIcon() throws Exception {

		try {
			Log.info("Locating cartIcon element");
			Thread.sleep(3000);
			Driver.switchTo().defaultContent();
			element = Driver.findElement(By.xpath("//a[@href='/cart']"));
			Utils.waitForElementLongJenkinsIssue(element);
			Utils.highLight(element);
			Log.info("cartIcon exist on the Header");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method cartIcon");
			Log.error("cartIcon does not exist on the Header");
			throw e;
		}

		return element;

	}
	public static WebElement ContinueShoppingButton() throws Exception {

		try {
			Log.info("Locating ContinueShoppingButton element");
			//element = Driver.findElement(By.xpath("//a[contains(text(),'Continue Shopping')]"));
			element = Driver.findElement(By.xpath("//*[@class='continue-shopping-btn hidden-xs hidden-sm']//button[contains(text(),'Continue Shopping')]"));
			
			Utils.highLight(element);
			Log.info("Continue Shopping Button exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method ContinueShoppingButton");
			Log.error("Continue Shopping Button does not exist on the cart page");
			throw e;
		}

		return element;

	}
	public static WebElement RecipientName() throws Exception{
		element=Driver.findElement(By.xpath(".//*[@id='giftRecipientName']"));
		Utils.highLight(element);
		return element;
		
	}
	
	public static WebElement ContinueShoppingButtonEmptyPage() throws Exception{
		element=Driver.findElement(By.xpath("//*[contains(text(),'Continue Shopping')]"));
		Utils.highLight(element);
		return element;
		
	}
	public static WebElement SenderName() throws Exception{
		element=Driver.findElement(By.xpath(".//*[@id='giftSenderName']"));
		Utils.highLight(element);
		return element;
		
	}
	public static WebElement GiftMessage() throws Exception{
		element=Driver.findElement(By.xpath(".//*[@id='giftMessage']"));
		Utils.highLight(element);
		return element;
		
	}
	public static WebElement SaveGiftMessage() throws Exception{
		element=Driver.findElement(By.xpath("//button[contains(text(),'Save')]"));
		Utils.highLight(element);
		return element;
		
	}
	public static WebElement RemoveGiftMessage() throws Exception{
		element=Driver.findElement(By.xpath("//a[contains(text(),'Remove Message')]"));
		Utils.highLight(element);
		return element;
		
	}
	public static WebElement CancelGiftMessage() throws Exception{
		element=Driver.findElement(By.xpath("(//button[contains(text(),'Cancel')])[1]"));
		Utils.highLight(element);
		return element;
		
	}
	public static WebElement ShoppingBagItemCountDetails() throws Exception {

		try {
			Log.info("Locating ShoppingBagItemCountDetails element");
			element = Driver
					.findElement(By.xpath("//span[@class='totalItems']"));
			Utils.highLight(element);
			Log.info("Shopping Bag Item Count Details exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method ShoppingBagItemCountDetails");
			Log.error("Shopping Bag Item Count Details does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static WebElement CheckOutButtonOnMiniCart() throws Exception {

		try {
			Log.info("Locating checkout button on the minicart page");
			
			element = Driver.findElement(
					By.xpath("//a[@class='checkout-btn']"));
			Log.info("checkout button exist on the Checkout page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method CheckOutButtonOnMiniCart");
			Log.error("checkout button does not exist on the Checkout page");
			throw e;
		}

		return element;

	}
	public static WebElement TotalCartPrice() throws Exception {

		try {
			Thread.sleep(2000);
			Utils.waitForPageLoad();
			Log.info("Locating TotalCartPrice element");
			element = Driver.findElement(By.xpath("(//span[@class='grandSum']/strong)"));
			Utils.waitForElementLongVisible(element);
			Utils.highLight(element);
			Log.info("Total Cart Price field exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method TotalCartPrice");
			Log.error("Total Cart Price field does not exist on the cart page");
			throw e;
		}

		return element;

	}
	public static WebElement TotalCartPriceCheckout() throws Exception {

		try {
			Log.info("Locating TotalCartPrice element");
			
			element = Driver.findElement(By.xpath("//*[@class='order-total']//div[@class='order-summary']//div[@class='total']//strong"));
			Utils.highLight(element);
			Log.info("Total Cart Price field exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method TotalCartPrice");
			Log.error("Total Cart Price field does not exist on the cart page");
			throw e;
		}

		return element;

	}
	
	public static WebElement TotalCartPriceDropDown() throws Exception {

		try {
			Log.info("Locating TotalCartPrice element");
			
			element = Driver.findElement(By.xpath("//*[@class='summary']//*[@class='toggle-summary active']"));
			Utils.highLight(element);		
			Log.info("Total Cart Price field exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method TotalCartPrice");
			Log.error("Total Cart Price field does not exist on the cart page");
			throw e;
		}

		return element;

	}
	
	public static WebElement TotalCartPriceViewPage() throws Exception {

		try {
			Log.info("Locating TotalCartPrice element");
			element = Driver.findElement(By.xpath("//section[@class='shopping-bag-wpr']//div[@class='shopping-heading-top']//span[@itemprop='price']/following-sibling::meta[@itemprop='price']"));
			Utils.highLight(element);
			Log.info("Total Cart Price field exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method TotalCartPrice");
			Log.error("Total Cart Price field does not exist on the cart page");
			throw e;
		}

		return element;

	}
	
	public static WebElement TotalCartPriceViewPagePrice() throws Exception {

		try {
			Log.info("Locating TotalCartPrice element");
			element = Driver.findElement(By.xpath("//section[@class='shopping-bag-wpr']//div[@class='shopping-heading-top']//span[@itemprop='price']/following-sibling::meta[@itemprop='price']"));
			Utils.highLight(element);					
			Log.info("Total Cart Price field exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method TotalCartPrice");
			Log.error("Total Cart Price field does not exist on the cart page");
			throw e;
		}

		return element;

	}
	
	public static WebElement TotalCartPricecart() throws Exception {

		try {
			Log.info("Locating TotalCartPrice element");
			element = Driver.findElement(By.xpath(
					"//section[@class='shopping-bag-wpr']//div[@class='shopping-heading-top']//span[@itemprop='price']/following-sibling::meta[@itemprop='price']"));
			Utils.highLight(element);					
			Log.info("Total Cart Price field exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method TotalCartPrice");
			Log.error("Total Cart Price field does not exist on the cart page");
			throw e;
		}

		return element;

	}
	
	public static WebElement TotalMiniCartPrice() throws Exception {

		try {
			Log.info("Locating TotalCartPrice element");
			element = Driver.findElement(By.xpath("//*[@class='order-total']//div[@class='order-summary']//div[@class='total']"));
			Utils.highLight(element);					
			Log.info("Total Cart Price field exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method TotalCartPrice");
			Log.error("Total Cart Price field does not exist on the cart page");
			throw e;
		}

		return element;

	}
	
	
	
	public static WebElement TotalCartPriceMain() throws Exception {

		try {
			Log.info("Locating TotalCartPrice element");
			element = Driver.findElement(By.xpath("//*[@class='shopping-wrap js-mini-cart-container']//*[@class='total']"));
			Log.info("Total Cart Price field exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method TotalCartPrice");
			Log.error("Total Cart Price field does not exist on the cart page");
			throw e;
		}

		return element;

	}
	
	public static WebElement MiniCart() throws Exception {

		try {
			Log.info("Locating TotalCartPrice element");
			
			element = Driver.findElement(By.xpath("//*[@class='shopping-wrap js-mini-cart-container']"));
			Utils.highLight(element);
			Log.info("Total Cart Price field exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method TotalCartPrice");
			Log.error("Total Cart Price field does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static List<WebElement> ProductImage() throws Exception {

		try {
			Log.info("Locating ProductImage elements");
			elements = Driver.findElements(By.xpath(
					"//div[@class='pro-img']//a[2]"));
			Utils.HighlightAllElementOneByOne(elements);
			Log.info("Product Image elements exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method ProductImage");
			Log.error("Product Image elements does not exist on the cart page");
			throw e;
		}

		return elements;

	}
	
	public static WebElement FirstCitizenImage() throws Exception {

		try {
			Log.info("Locating FirstCitizenImage elements");
			element = Driver.findElement(By.xpath(
					"(//a[contains(@href,'first-citizen')])[1]"));
			Utils.highLight(element);
			Log.info("FirstCitizenImage elements exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method FirstCitizenImage");
			Log.error("FirstCitizenImage element does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static List<WebElement> ProductBrandName() throws Exception {

		try {
			Log.info("Locating ProductBrandName elements");
			elements = Driver.findElements(By.xpath("//div[@class='mat-name']/a"));
			Utils.HighlightAllElementOneByOne(elements);
			Log.info("Product Brand Name exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method ProductBrandName");
			Log.error("Product Brand Name does not exist on the cart page");
			throw e;
		}

		return elements;

	}

	public static List<WebElement> ProductName() throws Exception {

		try {
			Log.info("Locating ProductName elements");
			elements = Driver.findElements(By.xpath(
					"//div[@class='pro-name']/a"));
			Utils.HighlightAllElementOneByOne(elements);
			Log.info("Product Name exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method ProductName");
			Log.error("Product Name does not exist on the cart page");
			throw e;
		}

		return elements;

	}

	public static List<WebElement> CartInfo() throws Exception {

		try {
			Log.info("Locating Cart Product info elements on the cart page");
			elements = Driver.findElements(By.xpath(
					"//form[@id='updateCartForm0']//li"));
			//Utils.HighlightAllElementOneByOne(elements);
			Log.info("Cart Product info elements exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method CartInfo");
			Log.error("Cart Product info elements does not exist on the cart page");
			throw e;
		}

		return elements;

	}

	public static List<WebElement> ProductCode() throws Exception {

		try {

			Log.info("Locating product code info elements on the cart page");
			elements = Driver.findElements(By.xpath(
					"//section[@class='shopping-bag-wpr']/descendant::form[contains(@id,'updateCartForm')]/ul/li[4]/input[@name='productCode']"));
			Utils.HighlightAllElementOneByOne(elements);
			Log.info("Product code info elements exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method ProductCode");
			Log.error("Product code info elements does not exist on the cart page");
			throw e;
		}

		return elements;

	}

	public static List<WebElement> EditCartLink() throws Exception {

		try {
			Log.info("Locating Edit Cart Link elements on the cart page");
			elements = Driver.findElements(By.xpath(
					"//section[@class='shopping-bag-wpr']/descendant::form[contains(@id,'updateCartForm')]/ul/li[4]/a"));
			Utils.HighlightAllElementOneByOne(elements);
			Log.info("Edit Cart Link elements exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method EditCartLink");
			Log.error("Edit Cart Link does not exist on the cart page");
			throw e;
		}

		return elements;

	}

	public static List<WebElement> UpdateSizeDropDown() throws Exception {

		try {
			Log.info("Locating Update Size DropDown elements on the cart page");
			elements = Driver.findElements(By.xpath(
					"//section[@class='shopping-bag-wpr']/descendant::form[contains(@id,'updateCartForm')]/ul/li[2]//select[contains(@id,'sizeProductCode')]"));
			Utils.HighlightAllElementOneByOne(elements);
			Log.info("Update Size DropDown elements exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method UpdateSizeDropDown");
			Log.error("Update Size DropDown does not exist on the cart page");
			throw e;
		}

		return elements;

	}

	public static List<WebElement> UpdateQuantity() throws Exception {

		try {
			Log.info("Locating Update Quantity Field elements on the cart page");
			elements = Driver.findElements(By.xpath("//input[@class='qt']"));
			Utils.HighlightAllElementOneByOne(elements);
			Log.info("Update Quantity Field exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method UpdateQuantity");
			Log.error("Update Quantity Field does not exist on the cart page");
			throw e;
		}

		return elements;

	}
	
	
	public static WebElement PresentQuantity(){
		try{
		Log.info("Locating PresentQuantity on the cart page");
		element = Driver.findElement(By.xpath("//input[@class='select-qty-input']"));
		Utils.highLight(element);
		Log.info("PresentQuantity exist on the cart page");

	} catch(Exception e) {
		Log.error("Exception in Class Cart_Page | Method PresentQuantity");
		Log.error("PresentQuantity does not exist on the cart page");
		throw e;
	}
	return element;
}
	
	public static WebElement SelectQuantity(){
		try{
		Log.info("Locating Update Quantity Field elements on the cart page");
		//element = Driver.findElement(By.xpath("//div[@class='shop-qty']"));
		element = Driver.findElement(By.xpath("//div[@class='shop-qty']/span"));
		Utils.highLight(element);
		Log.info("Update Quantity Field exist on the cart page");

	} catch(Exception e) {
		Log.error("Exception in Class Cart_Page | Method UpdateQuantity");
		Log.error("Update Quantity Field does not exist on the cart page");
		throw e;
	}
	return element;
}
	
	public static WebElement SelectFirstQuantity(){
		try{
		Log.info("SelectFirstQuantity on the cart page");
		element = Driver.findElement(By.xpath(".//*[@id='dropdown-qty0_1']"));
		Utils.highLight(element);
		Log.info("SelectFirstQuantity completed on the cart page");

	} catch(Exception e) {
		Log.error("Exception in Class Cart_Page | Method SelectFirstQuantity");
		Log.error("SelectFirstQuantity failed on the cart page");
		throw e;
	}
	return element;
}	
	
	
	public static List<WebElement> UpdateProductSize() throws Exception {

		try {
			Log.info("Locating Update ProductSize Field elements on the cart page");
			elements = Driver.findElements(By.xpath(
					"//section[@class='shopping-bag-wpr']/descendant::form[contains(@id,'updateCartForm')]/ul/li[2]//*[contains(@id,'sizeProductCode')]"));
			Utils.HighlightAllElementOneByOne(elements);
			Log.info("Update Quantity Field exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method UpdateQuantity");
			Log.error("Update Quantity Field does not exist on the cart page");
			throw e;
		}

		return elements;

	}
	public static List<WebElement> IncreaseQuantity() throws Exception {

		try {
			Log.info("Locating Increase quantity Link eleemnts on the cart page");
			elements = Driver.findElements(By.xpath("//div[@class='qt-plus']"));
			Utils.HighlightAllElementOneByOne(elements);
			Log.info("Increase Quantity Link elements exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method IncreaseQuantity");
			Log.error("Increase Link elements does not exist on the cart page");
			throw e;
		}

		return elements;

	}

	public static List<WebElement> DecreaseQuantity() throws Exception {

		try {
			Log.info("Locating Decrease Quantity Link elements on the cart page");
			elements = Driver.findElements(By.xpath(
					"//section[@class='shopping-bag-wpr']/descendant::form[contains(@id,'updateCartForm')]/ul/li[3]//div[@class='qt-minus']"));
			Utils.HighlightAllElementOneByOne(elements);
			Log.info("Decrease Quantity Link exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method DecreaseQuantity");
			Log.error("Decrease Quantity Link elements does not exist on the cart page");
			throw e;
		}

		return elements;

	}

	public static List<WebElement> UpdateCartItem() throws Exception {

		try {
			Log.info("Locating Update cart link elements on the cart page");
			elements = Driver.findElements(By.xpath("//button[@class='update-optn']"));
			Utils.HighlightAllElementOneByOne(elements);
			Log.info("Update cart link exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method UpdateCartItem");
			Log.error("Update cart link elements does not exist on the cart page");
			throw e;
		}

		return elements;

	}

	public static WebElement CheckoutButton() throws Exception {

		try {
			Log.info("Locating Checkout button on the cart page");
			element = Driver
					.findElement(By.xpath("(//*[contains(text(),'CHECKOUT')])[2]"));
			Log.info("Checkout button exist on the cart page");
			Utils.highLight(element);

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method CheckoutButton");
			Log.error("Checkout button does not exist on the cart page");
			throw e;
		}

		return element;

	}
	
	public static WebElement CheckoutButtonOnCart() throws Exception {

		try {
			Log.info("Locating Checkout button on the cart page");
			element = Driver.findElement(By.xpath("//section[@class='shopping-bag-wpr']//button[@class='btn-place-order']"));
			Utils.highLight(element);
			Log.info("Checkout button exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method CheckoutButton");
			Log.error("Checkout button does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static List<WebElement> RemovefromWishlist() throws Exception {

		try {
			Log.info("Locating RemovefromWishlist button elements on the cart page");
			//xpath updated on 1808
			//elements = Driver.findElements(By.xpath("//div[@class='remove-pro']"));
			elements = Driver.findElements(By.xpath("//a[@class='remove-to-wishlist']"));
			Utils.waitForElementsLongTime(elements);
			Log.info("RemovefromWishlist button elements exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method RemovefromWishlist");
			Log.error("RemovefromWishlist button elements does not exist on the cart page");
			throw e;
		}

		return elements;

	}
	public static List<WebElement> MoveToWishlist() throws Exception {
		try {
			Log.info("Locating Move to wishlist button elements on the cart page");
			//xpath updated on 1808
			//elements = Driver.findElements(By.xpath("//a[@class='sign-tag go_link wishlistSubmitBtn wishlist']"));
			elements = Driver.findElements(By.xpath("//a[@class='add-to-wishlist']"));
			Utils.waitForElementsLongTime(elements);
			Utils.HighlightAllElementOneByOne(elements);
			Log.info("Move to wishlist button elements exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method MoveToWishlist");
			Log.error("Move to wishlist button elements does not exist on the cart page");
			throw e;
		}

		return elements;

	}

	public static List<WebElement> RemoveProductOnCartPage() throws Exception {

		try {
			Log.info("Locating Remove product icon elements on the cart page");
			elements = Driver.findElements(By.xpath("//a[@id='removeFromCartID']"));
			Utils.HighlightAllElementOneByOne(elements);
			Log.info("Remove product icon exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method RemoveProductOnCartPage");
			Log.error("Remove product icon elements does not exist on the cart page");
			throw e;
		}

		return elements;

	}

	public static WebElement CheckoutButtonOnMiniCartFCC() {
		try {
			Log.info("Locating Checkout button on the MiniCart");
			element = Driver.findElement(By.xpath("//button[@class='btn-place-order']"));
			Utils.highLight(element);
			Log.info("Checkout button exist on the MiniCart");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method CheckoutButtonOnMiniCart");
			Log.error("Checkout button does not exist on the minicart");
			throw e;
		}

		return element;
	}
	public static WebElement CartPageAlertsuccess() throws Exception {

		try {
			Log.info("Locating Cart Page alert on the cart page");			
			element = Driver.findElement(By.xpath("//p[@class='success desk']"));
			Log.info("Cart Page alert exist on the cart page");
			Utils.highLight(element);

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method CartPageAlert");
			Log.error("Cart Page alert does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static WebElement CartPageAlert() throws Exception {

		try {
			Log.info("Locating Cart Page alert on the cart page");
			element = Driver.findElement(By.xpath("//p[@class='error desk']"));
			Log.info("Cart Page alert exist on the cart page");
			Utils.highLight(element);

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method CartPageAlert");
			Log.error("Cart Page alert does not exist on the cart page");
			throw e;
		}

		return element;

	}
	public static WebElement DefaultCartPageAlert() throws Exception {

		try {
			Log.info("Locating Cart Page alert on the cart page");
			element = Driver.findElement(By.xpath("(//div[contains(@class,'alert-dismissable')])[1]"));
			Log.info("Cart Page alert exist on the cart page");
			Utils.highLight(element);

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method CartPageAlert");
			Log.error("Cart Page alert does not exist on the cart page");
			throw e;
		}

		return element;

	}
	
	public static WebElement CouponAlert() throws Exception {

		try {
			Log.info("Locating Cart Page alert on the cart page");
			element = Driver.findElement(By.xpath("//div[@class='alert alert-dismissable success-msg']"));
			Log.info("Cart Page alert exist on the cart page");
			Utils.highLight(element);

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method CartPageAlert");
			Log.error("Cart Page alert does not exist on the cart page");
			throw e;
		}

		return element;

	}
	public static List<WebElement> ProductPriceInfo() throws Exception {

		try {
			Log.info("Locating Product Price Info field elements on the cart page");
			//changed the x-path
			elements = Driver.findElements(By.xpath("(//div[contains(@class,'prod-price')])"));
			
			Utils.HighlightAllElementOneByOne(elements);
			Log.info("Product Price Info field elements exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method ProductPriceInfo");
			Log.error("Product Price Info field does not exist on the cart page");
			throw e;
		}
		return elements;
	}

	public static WebElement CoupanCodeField() throws Exception {

		try {
			Log.info("Locating Coupan Code field on the cart page");
			element = Driver.findElement(By.xpath("//*[@id='paymentpromocode']//*[@type='text']"));
			Utils.highLight(element);
			Log.info("Coupan Code field exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method CoupanCodeField");
			Log.error("Coupan Code field does not exist on the cart page");
			throw e;
		}

		return element;

	}
	
	public static WebElement CoupanCodeFieldcart() throws Exception {

		try {
			Log.info("Locating Coupan Code field on the cart page");
			//
			element = Driver.findElement(By.xpath("(//input[@name='voucherCode'])[1]"));
			//
			Utils.highLight(element);
			Log.info("Coupan Code field exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method CoupanCodeField");
			Log.error("Coupan Code field does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static WebElement ApplyCoupanButton() throws Exception {

		try {
			Log.info("Locating Apply Coupan Button on the cart page");
			//
			element = Driver.findElement(By.xpath("(//input[@value='apply Coupon' or @value='apply'])"));
			//
			Utils.highLight(element);
			Log.info("Apply Coupan Button exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method ApplyCoupanButton");
			Log.error("Apply Coupan Button does not exist on the cart page");
			throw e;
		}

		return element;

	}
	
	public static WebElement ApplyCoupanButtoncart() throws Exception {

		try {
			Log.info("Locating Apply Coupan Button on the cart page");
			element = Driver.findElement(By.xpath("//*[@value='apply']"));
			Utils.highLight(element);
			Log.info("Apply Coupan Button exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method ApplyCoupanButton");
			Log.error("Apply Coupan Button does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static WebElement InvalidCoupanAlert() throws Exception {

		try {
			Log.info("Locating Invalid Coupan Alert on the cart page");
			//element = Driver.findElement(By.xpath("//div[@class='user-coupons']//p"));
			element = Driver.findElement(By.xpath("//form[@class='cartApplyCoupon']//p"));
			Utils.highLight(element);
			Log.info("Invalid Coupan Alert exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method InvalidCoupanAlert");
			Log.error("Invalid Coupan Alert does not exist on the cart page");
			throw e;
		}

		return element;

	}
	
	public static WebElement InvalidCoupanAlertViewBag() throws Exception {

		try {
			Log.info("Locating Invalid Coupan Alert on the cart page");
			element = Driver.findElement(
					By.xpath("//*[@class='global-alerts']//*[@class='alert alert-danger alert-dismissable']"));
			Utils.highLight(element);
			Log.info("Invalid Coupan Alert exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method InvalidCoupanAlert");
			Log.error("Invalid Coupan Alert does not exist on the cart page");
			throw e;
		}

		return element;

	}
	public static WebElement FirstNameFieldAlert() throws Exception {

		try {
			Log.info("Locating Invalid Coupan Alert on the cart page");
			element = Driver.findElement(
					By.xpath(".//*[@class='ui-tooltip-content']"));
			Log.info("first name field exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method InvalidCoupanAlert");
			Log.error("Invalid Coupan Alert does not exist on the cart page");
			throw e;
		}

		return element;

	}
	

	

	public static WebElement BacktoCartPageButton() throws Exception {

		try {
			Log.info("Locating Cart page Back button on the Checkout page");
			
			element = Driver.findElement(
					By.xpath("//*[@class='cp-header']//*[@class='cp-back']"));
			Utils.highLight(element);
			Log.info("Cart page Back button exist on the Checkout page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method InvalidCoupanAlert");
			Log.error("Cart page Back button does not exist on the Checkout page");
			throw e;
		}

		return element;

	}

	public static WebElement RemoveCouponCode() throws Exception {

		try {
			Log.info("Locating Remove Coupan icon on the cart page");
			
			element = Driver.findElement(By.xpath("//a[contains(@href,'/voucherCode/release/')]"));
			Utils.highLight(element);
			Log.info("Remove Coupan icon exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method RemoveCouponCode");
			Log.error("Remove Coupan icon does not exist on the cart page");
			throw e;
		}

		return element;

	}
	
	public static WebElement RemoveCouponCodeCartPage() throws Exception {

		try {
			Log.info("Locating Remove Coupan icon on the cart page");
			element = Driver.findElement(By.xpath("//div[@id='submit-cpn-id']//div[@class='submit-cpn']//a"));
			Utils.highLight(element);
			Log.info("Remove Coupan icon exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method RemoveCouponCode");
			Log.error("Remove Coupan icon does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static WebElement SubTotalField() throws Exception {

		try {
			Log.info("Locating Sub Total Field on the cart page");
			element = Driver.findElement(By.xpath(
					"//div[@class='sub-total']//li[1]"));
			Utils.highLight(element);
			Log.info("Sub Total Field exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method SubTotalField");
			Log.error("Sub Total Field does not exist on the cart page");
			throw e;
		}

		return element;

	}
	


	public static WebElement DeliveryCahrgesField() throws Exception {

		try {
			Log.info("Locating Delivery Cahrges Field on the cart page");
			element = Driver.findElement(By.xpath("//div[@class='sub-total']//li[2]"));
			Utils.highLight(element);
			Log.info("Delivery Cahrges Field exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method DeliveryCahrgesField");
			Log.error("Delivery Cahrges Field does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static WebElement GiftPackingField() throws Exception {

		try {
			Log.info("Locating Gift Packing Field on the cart page");
			element = Driver.findElement(By.xpath("//div[@class='sub-total']//li[3]"));
			Utils.highLight(element);
			Log.info("Gift Packing Field exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method GiftPackingField");
			Log.error("Gift Packing Field does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static WebElement CoupanDiscountField() throws Exception {

		try {
			Log.info("Locating Coupan Discount Field on the cart page");
			element = Driver.findElement(By.xpath("//div[@class='sub-total']//li[4]"));
			Log.info("Coupan Discount Field exist on the cart page");
			Utils.highLight(element);
		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method CoupanDiscountField");
			Log.error("Coupan Discount Field does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static WebElement PayableAmountContainer() throws Exception {

		try {
			Log.info("Locating Payable Amount section on the cart page");
			element = Driver.findElement(By.xpath("//div[@class='shopping-grand-total']//li[1]"));
			Utils.highLight(element);
			Log.info("Payable Amount section exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method PayableAmountContainer");
			Log.error("Payable Amount section does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static WebElement YouHaveSavedContainer() throws Exception {

		try {
			Log.info("Locating You have saved section exist on the cart page");
			element = Driver.findElement(By.xpath("//div[@class='shopping-grand-total']//li[2]"));
			Utils.highLight(element);
			Log.info("You have saved section exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method YouHaveSavedContainer");
			Log.error("You have saved section does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static WebElement UseGiftCard_Vouchar_Info() throws Exception {

		try {
			Log.info("Locating 'Do you have a gift card or and electronic gift voucher? Use it at the payment page.'- section on the cart page");
			element = Driver.findElement(By.xpath("//div[@class='shop-info']"));
			Log.info("'Do you have a gift card or and electronic gift voucher? Use it at the payment page.'- section exist on the cart page");
			Utils.highLight(element);
		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method UseGiftCard_Vouchar_Info");
			Log.error(
					"'Do you have a gift card or and electronic gift voucher? Use it at the payment page.'- section does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static WebElement PinCodeField() throws Exception {

		try {
			Log.info("Locating Pin Code Field on the cart page");
			element = Driver.findElement(By.xpath("(//*[@name='pincode'])[1]"));
			Utils.highLight(element);
			Log.info("Pin Code Field exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method PinCodeField");
			Log.error("Pin Code Field does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static WebElement CheckPinCodeButton() throws Exception {

		try {
			Log.info("Locating Check Pin Code button on the cart page");
		//	element = Driver.findElement(By.xpath(
		//			"//section[@class='shopping-bag-wpr']//div[@class='col-md-3 col-lg-3 col-mobile pad-push order-summary']/descendant::form[@id='delivery_pincode_id']//input[@value='CHECK PINCODE']"));
			element = Driver.findElement(By.xpath("//input[@value='CHECK']"));

			Log.info("Check Pin Code button exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method CheckPinCodeButton");
			Log.error("Check Pin Code button does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static WebElement InvalidPinCodeAlert() throws Exception {

		try {
			Log.info("Locating Invalid Pin code alert on the cart page");
			//element = Driver.findElement(By.xpath(
			//		"//section[@class='shopping-bag-wpr']//div[@class='col-md-3 col-lg-3 col-mobile pad-push order-summary']//p[@id='invalidPinID']"));
			element = Driver.findElement(By.xpath(
					"//section[@class='shopping-bag-wpr']//div[@class='col-md-9 col-lg-9 col-mobile shopping-bag-left']//*[@class='delivery-optn hidden-xs hidden-sm']//p[@id='invalidPinID']"));

			Log.info("Invalid Pin code alert exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method InvalidPinCodeAlert");
			Log.error("Invalid Pin code alert does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static WebElement ChangePinCode() throws Exception {

		try {
			Log.info("Locating Change Pin code link on the cart page");
			//element = Driver.findElement(By.xpath(
			//		"//section[@class='shopping-bag-wpr']//div[@class='col-md-3 col-lg-3 col-mobile pad-push order-summary']/descendant::div[@class='pincode_display']/a"));
			element = Driver.findElement(By.xpath("//a[@class='btn-change']"));

			Log.info("Change Pin code link exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method ChangePinCode");
			Log.error("Change Pin code link does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static List<WebElement> DeliveryDetails() throws Exception {

		try {
			Log.info("Locating Delivery details for product on the cart page");
			//elements = Driver.findElements(By.xpath(
			//		"//section[@class='shopping-bag-wpr']//form[contains(@id,'updateCartForm')]/following-sibling::div[@class='delivary-time']"));
			elements = Driver.findElements(By.xpath(
					"//*[@class='shopping-bag-wpr']//*[@class='shop-listing']//*[@class='col-md-3 col-sm-12 delivery-options']//ul"));

			Log.info("Delivery details for product exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method DeliveryDetails");
			Log.error("Check Pin Code button does not exist on the cart page");
			throw e;
		}

		return elements;

	}

	public static WebElement FreeDeliveryIcon() throws Exception {

		try {
			Log.info("Locating Free Delivery Icon on the cart page");
		//	element = Driver.findElement(By.xpath(
		//			"//section[@class='shopping-bag-wpr']//div[@class='user-static-info hidden-xs hidden-sm']/ul/li[1]"));
			element = Driver.findElement(By.xpath(
					"//*[contains(@href,'delivery')]"));

			Log.info("Free Delivery Icon exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method FreeDeliveryIcon");
			Log.error("Free Delivery Icon does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static WebElement InStoreReturnsLink() throws Exception {

		try {
			Log.info("Locating Free In Store returns link on the cart page");
			//element = Driver.findElement(By.xpath(
			//		"//section[@class='shopping-bag-wpr']//div[@class='user-static-info hidden-xs hidden-sm']/ul/li[2]/span/a"));
			element = Driver.findElement(By.xpath(
					"//*[contains(@href,'returns')]"));

			Log.info("Free In Store returns link exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method InStoreReturnsLink");
			Log.error("Free In Store returns link does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static WebElement AnyQuestionsContainer() throws Exception {

		try {
			Log.info("Locating Any Questions? section exist on the cart page");
		//	element = Driver.findElement(By.xpath(
			//		"//section[@class='shopping-bag-wpr']//div[@class='user-static-info hidden-xs hidden-sm']/ul/li[3]"));
			element = Driver.findElement(By.xpath(
					"   //div[@class='cp-footer']//*[@class='container container-responsive checkout-container']//*[@class='questions-call']"));

			Log.info("Any Questions? section exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method AnyQuestionsContainer");
			Log.error("Any Questions? section does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static WebElement EnterFCCNumber() throws Exception {

		try {
			Log.info("Locating First Citizen Card Number Field on the cart page");
			element = Driver.findElement(By.xpath(
					"//section[@class='shopping-bag-wpr']/descendant::div[@class='eran-points']//input[@type='text' and @name='CardNumber']"));
			Log.info("First Citizen Card Number Field exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method EnterFCCNumber");
			Log.error("First Citizen Card Number Field does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static WebElement EarnPointsButton() throws Exception {

		try {
			Log.info("Locating Earn Points Button on the cart page");
			element = Driver.findElement(By.xpath(
					"//section[@class='shopping-bag-wpr']/descendant::div[@class='eran-points']//input[@class='earn-btn' and @type='submit']"));
			Log.info("Earn Points Button exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method EarnPointsButton");
			Log.error("Earn Points Button does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static WebElement FirstCitizenLoyalityProgramBanner() throws Exception {

		try {
			Log.info("Locating First Citizen Promotion Banner on the cart page");
			element = Driver.findElement(
					By.xpath("//section[@class='shopping-bag-wpr']/descendant::div[@class='promotion-ad-banner']/a"));
			Log.info("First Citizen Promotion Banner exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method FirstCitizenLoyalityProgramBanner");
			Log.error("First Citizen Promotion Banner does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static List<WebElement> FromYourWishlistImages() throws Exception {

		try {
			Log.info("Locating From Your Wishlist Images on the cart page");
			elements = Driver.findElements(By.xpath(
					"//section[@class='shopping-bag-wpr']/descendant::div[@class='recommends-wpr']/descendant::div[@class='product-wpr']//ul"));
			Log.info("From Your Wishlist Images exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method FromYourWishlistImages");
			Log.error("From Your Wishlist Images does not exist on the cart page");
			throw e;
		}

		return elements;

	}
	
	public static WebElement FromYourWishlistImage() throws Exception {

		try {
			Log.info("Locating From Your Wishlist Image on the cart page");
			element = Driver.findElement(By.xpath("//section[@class='shopping-bag-wpr']/descendant::div[@class='recommends-wpr']/descendant::div[@class='product-wpr']//ul"));
			Utils.highLight(element);
			Log.info("From Your Wishlist Images exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method FromYourWishlistImage");
			Log.error("FromYourWishlist Image does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static WebElement GiftWrapIcon() throws Exception {

		try {
			Log.info("Locating Gift Wrap Icon on the cart page");
			element = Driver.findElement(By.xpath(
					"(//div[@class='gift-tab']//span)[1]"));
			Utils.highLight(element);
			Log.info("Gift Wrap Icon exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method GiftWrapIcon");
			Log.error("Gift Wrap Icon does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static WebElement AddMessageOnGiftWrapLink() throws Exception {

		try {
			Log.info("Locating Add Message link on the cart page");
			element = Driver.findElement(By.xpath("//div[@class='gift-tab']/span/a"));
			Utils.highLight(element);
			Log.info("Add Message link exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method AddMessageOnGiftWrapLink");
			Log.error("Add Message link does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static WebElement AddMessageDropDown() throws Exception {

		try {
			Log.info("Locating Add Message Drop Down on the cart page");
			element = Driver.findElement(By.xpath("//div[@class='gift-tab']"));
			Utils.highLight(element);
			Log.info("Add Message Drop Down exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method AddMessageDropDown");
			Log.error("Add Message Drop Down does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static WebElement RemoveMessageLink() throws Exception {

		try {
			Log.info("Locating Remove Message Link on the cart page");
			element = Driver.findElement(By.xpath(
					"//section[@class='shopping-bag-wpr']//form[@id='giftWrapFormID']//div[@class='gift-tab']/span/a[@class='gift-wrap-remove']"));
			Log.info("Remove Message Link exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method RemoveMessageLink");
			Log.error("Remove Message Link does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static WebElement EditMessageLink() throws Exception {

		try {
			Log.info("Locating Edit Message Link on the cart page");
			element = Driver.findElement(By.xpath(
					"//section[@class='shopping-bag-wpr']//form[@id='giftWrapFormID']//div[@class='gift-tab']/span/a[@class='gift-wrap-edit']"));
			Log.info("Edit Message Link exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method EditMessageLink");
			Log.error("Edit Message Link does not exist on the cart page");
			throw e;
		}

		return element;

	}

	public static class AddMessageForm {
		public static WebElement element = null;

		public static List<WebElement> GiftPaperImages() throws Exception {

			try {
				Log.info("Locating Gift Paper Images elements on the Add message Form");
				elements = Driver.findElements(By.xpath(
						"//section[@class='shopping-bag-wpr']/descendant::div[@class='gift-wpr-slider']//ul[@class='gift-paper']/li"));
				Log.info("Gift Paper Images elements exist on the Add message Form");

			} catch (Exception e) {
				Log.error("Exception in Class Cart_Page | Method GiftPaperImages");
				Log.error("Gift Paper Images does not exist on the Add message Form");
				throw e;
			}

			return elements;

		}

		public static WebElement GiftRecipientName() throws Exception {

			try {
				Log.info("Locating Gift Recipient Name on the Add message Form");
				element = Driver.findElement(
						By.xpath("//section[@class='shopping-bag-wpr']/descendant::input[@id='giftRecipientName']"));
				Log.info("Gift Recipient Name exist on the Add message Form");

			} catch (Exception e) {
				Log.error("Exception in Class Cart_Page | Method GiftRecipientName");
				Log.error("Gift Recipient Name does not exist on the Add message Form");
				throw e;
			}

			return element;

		}

		public static WebElement GiftMessage() throws Exception {

			try {
				Log.info("Locating Gift Message on the Add message Form");
				element = Driver.findElement(
						By.xpath("//section[@class='shopping-bag-wpr']/descendant::textarea[@id='giftMessage']"));
				Log.info("Gift Message exist on the Add message Form");

			} catch (Exception e) {
				Log.error("Exception in Class Cart_Page | Method GiftMessage");
				Log.error("Gift Message does not exist on the Add message Form");
				throw e;
			}

			return element;

		}

		public static WebElement GiftSenderName() throws Exception {

			try {
				Log.info("Locating Gift Sender Name Field on the Add message Form");
				element = Driver.findElement(
						By.xpath("//section[@class='shopping-bag-wpr']/descendant::input[@id='giftSenderName']"));
				Log.info("Gift Sender Name Field exist on the Add message Form");

			} catch (Exception e) {
				Log.error("Exception in Class Cart_Page | Method GiftSenderName");
				Log.error("Gift Sender Name Field does not exist on the Add message Form");
				throw e;
			}

			return element;

		}

		public static WebElement GiftMessageApplyButton() throws Exception {

			try {
				Log.info("Locating Gift Message Apply Button on the Add message Form");
				element = Driver.findElement(By.xpath(
						"//section[@class='shopping-bag-wpr']/descendant::div[@class='action-btns']/button[@class='btn-apply' and @type='submit']"));
				Log.info("Gift Message Apply Button exist on the Add message Form");

			} catch (Exception e) {
				Log.error("Exception in Class Cart_Page | Method GiftMessageApplyButton");
				Log.error("Gift Message Apply Button does not exist on the Add message Form");
				throw e;
			}

			return element;

		}

		public static WebElement GiftMessageCancelButton() throws Exception {

			try {
				Log.info("Locating Gift Message Cancel Button on the Add message Form");
				element = Driver.findElement(By.xpath(
						"//section[@class='shopping-bag-wpr']/descendant::div[@class='action-btns']/button[contains(@class,'btn-cancel gift-wrap') and @type='submit']"));
				Log.info("Gift Message Cancel Button exist on the Add message Form");

			} catch (Exception e) {
				Log.error("Exception in Class Cart_Page | Method GiftMessageCancelButton");
				Log.error("Gift Message Cancel Button does not exist on the Add message Form");
				throw e;
			}

			return element;

		}

	}

	public static WebElement CheckoutButtonOnCart1() {
		try {
			Log.info("Locating Checkout button on the cart page");
			element = Driver.findElement(By.xpath("//section[@class='shopping-bag-wpr']//button[@class='btn-place-order']"));
			


			Log.info("Checkout button exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method CheckoutButton");
			Log.error("Checkout button does not exist on the cart page");
			throw e;
		}

		return element;
	}

	public static WebElement ShippingCostText() {
		try {
			Log.info("Locating ShippingCost on the cart page");
			//element = Driver.findElement(By.xpath(
					//"//div[@class='sub-total']/ul/li[2]//span[@itemprop='price']/following-sibling::meta[@itemprop='price']"));
			
			element = Driver.findElement(By.xpath(
					"//div[@class='sub-total']/ul/li[2]//span[@itemprop='price']"));
			Log.info("Shipping cost field exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method SubTotalField");
			Log.error("Sub Total Field does not exist on the cart page");
			throw e;
		}

		return element;
	}
	
	public static WebElement ShippingCostTip() {
		try {
			Log.info("Locating ShippingCostTip on the cart page");
			element = Driver.findElement(By.xpath(
					"//div[@class='shippingTip']"));
			Log.info("Shipping cost Tip exist on the cart page");

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method ShippingCostTip");
			Log.error("Shipping cost Tip does not exist on the cart page");
			throw e;
		}

		return element;
	}
	public static WebElement expressStorePickup_Available() throws Exception {
		//element=null;
		try {			
			element=Driver.findElement(By.xpath("//span[@class='avl-at-store avl']"));
			Utils.highLight(element);
			Log.info("Express storepickup available for this product");
			
		}catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method expressStorePickup_NotAvailable");
			Log.error("Express storepickup option not available for this product");
			throw e;
		}
		return element;
	}	
	
	public static WebElement selectStore_Link() throws Exception {
		element=null;
		try {			
			element=Driver.findElement(By.xpath("//div[@class='select-store']"));
			Utils.highLight(element);
			Log.info("Select store link is displayed");
			
		}catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method selectStore_Link");
			Log.error("Select store link is not displayed");
			throw e;
		}
		return element;
	}
	
	public static WebElement pickup_PopupImage() throws Exception {	
	try{
		element=Driver.findElement(By.xpath("//ul[@class='storepickup-product-carousel clearfix']"));
		Utils.highLight(element);		
		Log.info("Product image is displayed in popup");
	} catch (Exception e) {
		
		Log.error("Exception in Class Cart_Page | Method pickup_PopupImage");
		throw e;
		}		
	return element;		
}	

	public static WebElement productAvailability_IN_Popup() throws Exception {	
		try{
			element=Driver.findElement(By.xpath("//span[@class='available-count']"));
			Utils.highLight(element);
			Log.info("Product availability count is displayed in popup");
		} catch (Exception e) {
			
			Log.error("Exception in Class Cart_Page | Method productAvailability_IN_Popup");
			throw e;
			}		
		return element;		
	}	
	
	public static WebElement store_Details_IN_Popup() throws Exception {	
		try{
			element=Driver.findElement(By.xpath("//span[@class='details']"));
			Utils.highLight(element);
			Log.info("Store details displayed in popup");
		} catch (Exception e) {
			
			Log.error("Exception in Class Cart_Page |store_Details_IN_Popup");
			throw e;
			}		
		return element;		
	}	
	
	public static WebElement popupClose_Btn() throws Exception {	
		try{
			element=Driver.findElement(By.xpath("//button[@class='close']"));
			Utils.highLight(element);
			Log.info("popup cose button is displayed");
		} catch (Exception e) {
			
			Log.error("Exception in Class Cart_Page |popupClose_Btn");
			throw e;
			}		
		return element;		
	}	
	public static WebElement changeStore_BtnInPopup() throws Exception {
		element=null;
		try {			
			element=Driver.findElement(By.xpath("//input[@class='picKUpStore continue-btn']"));
			Utils.highLight(element);
			Log.info("selecting store button is displayed");
			
		}catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method changeStore_BtnInPopup");
			Log.error("selecting store button is not displayed");
			throw e;
		}
		return element;
	}	
	public static WebElement storeName() throws Exception {
		element=null;
		try {			
			element=Driver.findElement(By.xpath("//div[@class='storeName']"));
			Utils.highLight(element);
			Log.info("Express storepickup store name is displayed");
			
		}catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method storeName");
			Log.error("Express storepickup store name is not displayed");
			throw e;
		}
		return element;
	}		
	
	public static WebElement shoppingInfo() throws Exception {
		try{
			element=Driver.findElement(By.xpath("//div[@class='shop-info']"));
			Utils.highLight(element);
			Log.info("Shopping info is displayed");
		} catch (Exception e) {
			
			Log.error("Exception in Class Cart_Page | Method shoppingInfo");
			throw e;
			}		
		return element;		
	}	
	
	public static WebElement popup_Pincode() throws Exception {
		try{
			element=Driver.findElement(By.xpath("//input[@id='popupCheckPin']"));
			Utils.highLight(element);
			Log.info("popup pincode field is displayed");
		} catch (Exception e) {
			
			Log.error("Exception in Class Cart_Page | Method popup_Pincode");
			throw e;
			}		
		return element;		
	}	

	public static WebElement popup_Pincode_Check() throws Exception {
		try{
			element=Driver.findElement(By.xpath("//input[@class='storePickupCheckPin']"));
			Utils.highLight(element);
			Log.info("Popup pincode check button is displayed");
		} catch (Exception e) {
			
			Log.error("Exception in Class Cart_Page | Method popup_Pincode_Check");
			throw e;
			}		
		return element;		
	}
	
	public static WebElement pincode_Display() throws Exception {
		try{
			element=Driver.findElement(By.xpath("//div[@class='pincode_display']/span"));
			Utils.highLight(element);
			Log.info("Pinocde field is displayed");
		} catch (Exception e) {
			
			Log.error("Exception in Class Cart_Page | Method pincode_Display");
			throw e;
			}		
		return element;		
	}
	
	public static WebElement noStores_In_Popup() throws Exception {
		try{
			element=Driver.findElement(By.xpath("//p[@class='nostores']"));
			Utils.highLight(element);
			Log.info("no stores message is displayed in popup");
		} catch (Exception e) {
			
			Log.error("Exception in Class Cart_Page | Method noStores_In_Popup");
			throw e;
			}		
		return element;		
	}	
	
	public static WebElement expressStorePickup_NotAvailable() throws Exception {
		//element=null;
		try {			
			 element = Driver.findElement(By.xpath("//span[@class='avl-at-store not-avl']"));
			Utils.highLight(element);			
			Log.info("Express storepickup not available for this product");
		}catch (Exception e) {
			Log.error("Exception in Class Cart_Page | Method expressStorePickup_NotAvailable");
			Log.error("Express storepickup option not available for this product");	
			throw e;
		}
		return element;
	}	
	

	public static WebElement standardDelivery() throws Exception {
		try{
			
			element=Driver.findElement(By.xpath("//span[@class='standard-delivery avl']"));
			Utils.highLight(element);
			Log.info("Standard delivery is displayed");
		} catch (Exception e) {			
			Log.error("Exception in Class Cart_Page | Method standardDelivery");
			throw e;
			}		
		return element;		
	}	
	
	public static WebElement codDelivery() throws Exception {
		try{
			element=Driver.findElement(By.xpath("//span[@class='eligible-COD avl']"));
			Utils.highLight(element);
			Log.info("COD option is displayed");
		} catch (Exception e) {
			
			Log.error("Exception in Class Cart_Page | Method codDelivery");
			throw e;
			}		
		return element;		
	}	
	
	public static WebElement product_ImageLink() throws Exception {	
		try{
			element=Driver.findElement(By.xpath("//div[@class='pro-name']/a"));
			Utils.highLight(element);
			Log.info("Product image link is displayed");
		} catch (Exception e) {
			
			Log.error("Exception in Class Cart_Page |product_ImageLink");
			throw e;
			}		
		return element;		
	}		
	public static WebElement wishlistItems() throws Exception {	
		try{
			Log.info("locaing FROM YOUR WISHLIST in cart page ");
			element=Driver.findElement(By.xpath("//a[text()='FROM YOUR WISHLIST']"));
			Utils.highLight(element);
			Log.info("FROM YOUR WISHLIST  link is displayed");
		} catch (Exception e) {
			
			Log.error("Exception in Class Cart_Page |wishlistItems");
			throw e;
			}		
		return element;		
	}	
	public static WebElement verificationmessage() throws Exception {	
		try{
			Log.info("locaing  verificationmessage in wish list page");
			element=Driver.findElement(By.xpath("//div[@class='alert alert-info alert-dismissable']"));
			Utils.highLight(element);
			Log.info("FROM YOUR WISHLIST  link is displayed");
		} catch (Exception e) {
			
			Log.error("Exception in Class Cart_Page |verificationmessage");
			throw e;
			}		
		return element;		
	}	
	
}