package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//import com.thoughtworks.selenium.webdriven.commands.Highlight;
//import org.openqa.selenium.support.ui.Select;

import utility.Log;
import utility.Utils;
//import utility.Utils;

public class MiniCart_Page extends BaseClass {
	private static WebElement element = null;
	private static List<WebElement> elementList = null;
	// private static Select sel = null;

	public MiniCart_Page(WebDriver Driver) {
		super(Driver);
	}


	public static WebElement MiniCartWindow() throws Exception {

		try {
			Log.info("Locating Mini Cart window on the page");
			
			element = Driver.findElement(By.xpath("(.//a[contains(@class,'minicart bags bag bag-container')])"));
			Utils.highLight(element);
			Log.info("Mini Cart window is found on the page");

		} catch (Exception e) {
			Log.error("Exception in Class MiniCart_Page | Method MiniCartWindow");
			Log.error("Mini Cart window is not found on the page");
			throw e;
		}

		return element;

	}
	
	public static WebElement MiniCart() throws Exception {

		try {
			Log.info("Locating Mini Cart window on the page");
			element = Driver.findElement(
					By.xpath(".//*[@id='minicart_id']"));
			Utils.highLight(element);
			Log.info("Mini Cart window is found on the page");

		} catch (Exception e) {
			Log.error("Exception in Class MiniCart_Page | Method MiniCartWindow");
			Log.error("Mini Cart window is not found on the page");
			throw e;
		}

		return element;

	}

	public static WebElement MiniCartItemCount() throws Exception {

		try {
			Log.info("Locating Mini Cart Item count on the mini cart");
			element = Driver.findElement(By.xpath("//span[@class='qtyHeaderMinicart']"));
			Utils.highLight(element);
			Log.info("Mini Cart Item count is found on the mini cart");

		} catch (Exception e) {
			Log.error("Exception in Class MiniCart_Page | Method MiniCartItemCount");
			Log.error("Mini Cart Item count is not found on the mini cart");
			throw e;
		}

		return element;

	}

	public static List<WebElement> MiniCartProductCode() throws Exception {

		try {
			Log.info("Locating ProductCode element on the mini cart");

			elementList = Driver
					.findElements(By.xpath("//form[contains(@id, 'updateMiniCartForm')]/input[@name='productCode']"));

			Log.info("ProductCode element is found on the mini cart");

		} catch (Exception e) {
			Log.error("Exception in Class MiniCart_Page | Method MiniCartProductCode");
			Log.error("ProductCode element is not found on the mini cart");
			throw e;
		}

		return elementList;

	}

	public static WebElement MiniCartNoItemText() throws Exception {

		try {
			Log.info("Locating No item present in cart text element on the mini cart");
			element = Driver.findElement(By.xpath("//div[@class='shopping-wrap js-mini-cart-container']/p"));
			Utils.highLight(element);
			Log.info("No item present in cart text is found on the mini cart");

		} catch (Exception e) {
			Log.error("Exception in Class MiniCart_Page | Method MiniCartNoItemText");
			Log.error("No item present in cart text is not found on the mini cart");
			throw e;
		}

		return element;

	}

	public static WebElement removeBtn() throws Exception {

		try {
			Log.info("Locating Remove button on the mini cart");
			element = Driver.findElement(By.xpath(
					"(.//*[contains(@id,'removeEntry')])[1]"));
			Utils.highLight(element);
			Log.info("Remove button is found on the mini cart");

		} catch (Exception e) {
			Log.error("Exception in Class MiniCart_Page | Method removeBtn");
			Log.error("Remove button is not found on the mini cart");
			throw e;
		}

		return element;

	}

	public static WebElement MiniCartTotalPrice() throws Exception {

		try {
			Log.info("Locating Total Cart Price value on the mini cart");
			element = Driver.findElement(
					By.xpath("//div[@class='total']"));
			Utils.highLight(element);
			Log.info("Total Cart Price value is found on the mini cart");

		} catch (Exception e) {
			Log.error("Exception in Class MiniCart_Page | Method MiniCartTotalPrice");
			Log.error("Total Cart Price value is not found on the mini cart");
			throw e;
		}

		return element;

	}
	public static List<WebElement> MiniCartProductImages() throws Exception {

		try {
			Log.info("Locating Product Image on the mini cart");
			elementList = Driver
					.findElements(By.xpath(".//*[@id='updateMiniCartForm0']/div[1]/a[2]/img"));
			Utils.HighlightAllElementOneByOne(elementList);
			Log.info("Product Image is found on the mini cart");

		} catch (Exception e) {
			Log.error("Exception in Class MiniCart_Page | Method MiniCartProductImages");
			Log.error("Product Image is not found on the mini cart");
			throw e;
		}

		return elementList;

	}

	public static class MiniCartProductDetails {
		public static WebElement element = null;
		public static List<WebElement> elementList = null;

		public static List<WebElement> MiniCartProductBrandName() throws Exception {

			try {
				Log.info("Locating Product Brand name on the mini cart");
				elementList = Driver.findElements(
						By.xpath("//form[contains(@id, 'updateMiniCartForm')]//div[@class='details']/h4"));
				Utils.HighlightAllElementOneByOne(elementList);
				Log.info("Product Brand name is found on the mini cart");

			} catch (Exception e) {
				Log.error("Exception in Class MiniCart_Page | Method MiniCartProductBrandName");
				Log.error("Product Brand name is not found on the mini cart");
				throw e;
			}

			return elementList;

		}

		public static List<WebElement> MiniCartProductProductName() throws Exception {

			try {
				Log.info("Locating Product name for products on the mini cart");
				elementList = Driver.findElements(
						By.xpath("//form[contains(@id, 'updateMiniCartForm')]//div[@class='details']/h5/a"));
				Utils.HighlightAllElementOneByOne(elementList);
				Log.info("Product name for products is found on the mini cart");

			} catch (Exception e) {
				Log.error("Exception in Class MiniCart_Page | Method MiniCartProductProductName");
				Log.error("Product name for products is not found on the mini cart");
				throw e;
			}

			return elementList;

		}

		public static List<WebElement> MiniCartProductSpec() throws Exception {

			try {
				Log.info("Locating Product Specifications on the mini cart");
				elementList = Driver.findElements(By
						.xpath("//form[contains(@id, 'updateMiniCartForm')]//div[@class='details']/ul[@class='spec']"));
				Utils.HighlightAllElementOneByOne(elementList);
				Log.info("Product Specifications are found on the mini cart");

			} catch (Exception e) {
				Log.error("Exception in Class MiniCart_Page | Method MiniCartProductSpec");
				Log.error("Product Specifications are not found on the mini cart");
				throw e;
			}

			return elementList;

		}

		public static List<WebElement> MiniCartProductPrice() throws Exception {

			try {
				Log.info("Locating Product Price tag for products on the mini cart");
				elementList = Driver.findElements(
						By.xpath(".//*[@id='updateMiniCartForm0']/div[2]/div/p/span"));
				Utils.HighlightAllElementOneByOne(elementList);
				Log.info("Product Price tag is found for products on the mini cart");

			} catch (Exception e) {
				Log.error("Exception in Class MiniCart_Page | Method MiniCartProductPrice");
				Log.error("Product Price tag is not found for products on the mini cart");
				throw e;
			}

			return elementList;

		}

		public static WebElement MiniCartCheckOutButton() throws Exception {

			try {
				Log.info("Locating CheckOut Button on the mini cart");
				element = Driver.findElement(
						By.xpath("//a[contains(text(),'Checkout')]"));
				Utils.highLight(element);
				Log.info("CheckOut Button is found on the mini cart");

			} catch (Exception e) {
				Log.error("Exception in Class MiniCart_Page | Method MiniCartCheckOutButton");
				Log.error("CheckOut Button is not found on the mini cart");
				throw e;
			}

			return element;

		}

		public static WebElement MiniCartViewBag() throws Exception {

			try {
				Log.info("Locating View bag button on the mini cart");
				////
				//element = Driver.findElement(By.xpath("//a[@class='view-btn']"));
				element = Driver.findElement(By.xpath("//a[@href='/cart']"));
				////
				Utils.highLight(element);
				Log.info("View bag button is found on the mini cart");

			} catch (Exception e) {
				Log.error("Exception in Class MiniCart_Page | Method MiniCartViewBag");
				Log.error("View bag button is not found on the mini cart");
				throw e;
			}

			return element;

		}
	}

	public static List<WebElement> RemoveItemFromCart() throws Exception{
		// TODO Auto-generated method stub
		try {
			Log.info("Locating RemoveItemFromCart button on the mini cart");
			elementList = Driver.findElements(By.xpath(".//*[@id='removeFromCartID']"));
			Log.info("RemoveItemFromCart is found on the mini cart");
			Utils.HighlightAllElementOneByOne(elementList);

		} catch (Exception e) {
			Log.error("Exception in Class MiniCart_Page | Method RemoveItemFromCart");
			Log.error("RemoveItemFromCart button is not found on the mini cart");
			throw e;
		}

		return elementList;

	}
	public static List<WebElement> RemoveItemFromWishList() throws Exception{
		// TODO Auto-generated method stub
		try {
			Log.info("Locating RemoveItemFromWishList button on the mini cart");
			elementList = Driver.findElements(By.xpath("//a[contains(@href,'/wishlist//removeFromWishlist/')]"));
			Log.info("RemoveItemFromCart is found on the mini cart");
			Utils.HighlightAllElementOneByOne(elementList);

		} catch (Exception e) {
			Log.error("Exception in Class MiniCart_Page | Method RemoveItemFromWishList");
			Log.error("RemoveItemFromWishList button is not found on the mini cart");
			throw e;
		}

		return elementList;

	}
	public static WebElement QtyWishList() throws Exception{
		try{
			element=Driver.findElement(By.xpath("//div[contains(@class,'user-icons')]//li[3]/span"));
			Utils.highLight(element);
		}catch(Exception e){
			Log.error("Unable to Locate number of Qty in WishList in Header");
			throw e;
		}
		return element;
	}
	public static WebElement QtyMiniCart() {
		try {
			Log.info("Locating QtyMiniCart button on the mini cart");
			element = Driver.findElement(By.xpath("//a[@href='/cart']/following-sibling::input[@id='cart-count']"));
			Utils.highLight(element);
			Log.info("QtyMiniCart is found on the mini cart");

		} catch (Exception e) {
			Log.error("Exception in Class MiniCart_Page | Method QtyMiniCart");
			Log.error("QtyMiniCart button is not found on the mini cart");
			throw e;
		}

		return element;
	}
	
	// In the card page footer AppStoreIcon
	public static WebElement appStoreIcon() throws Exception {

		try {
			Log.info("Locating No item present in cart text element on the mini cart");
			//
			//element = Driver.findElement(By.xpath("//*[@title='App Store Icon']"));
			element = Driver.findElement(By.xpath("/html/body/main/footer/div[3]/div[1]/div/div/div/div[1]/ul/li[1]/a"));
			//
			Utils.highLight(element);
			Log.info("No item present in cart text is found on the mini cart");

		} catch (Exception e) {
			Log.error("Exception in Class MiniCart_Page | Method MiniCartNoItemText");
			Log.error("No item present in cart text is not found on the mini cart");
			throw e;
		}

		return element;

	}
	
	// In the card page footer googlePlayIcon
	public static WebElement googlePlayIcon() throws Exception {

		try {
			Log.info("Locating No item present in cart text element on the mini cart");
			/////
			//element = Driver.findElement(By.xpath("//*[@title='Google Play Icon']"));
			element = Driver.findElement(By.xpath("/html/body/main/footer/div[3]/div[1]/div/div/div/div[1]/ul/li[2]/a"));
			////
			Utils.highLight(element);
			Log.info("No item present in cart text is found on the mini cart");

		} catch (Exception e) {
			Log.error("Exception in Class MiniCart_Page | Method MiniCartNoItemText");
			Log.error("No item present in cart text is not found on the mini cart");
			throw e;
		}

		return element;

	}
	// In the card page footer facebookIcon
	public static WebElement facebookIcon() throws Exception {

		try {
			Log.info("Locating No item present in cart text element on the mini cart");
			element = Driver.findElement(By.xpath("//*[@class='facebook-icon']"));
			Utils.highLight(element);
			Log.info("No item present in cart text is found on the mini cart");

		} catch (Exception e) {
			Log.error("Exception in Class MiniCart_Page | Method MiniCartNoItemText");
			Log.error("No item present in cart text is not found on the mini cart");
			throw e;
		}

		return element;

	}
	// In the card page footer twitterIcon
	public static WebElement twitterIcon() throws Exception {

		try {
			Log.info("Locating No item present in cart text element on the mini cart");
			element = Driver.findElement(By.xpath("//*[@class='twitter-icon']"));
			Utils.highLight(element);
			Log.info("No item present in cart text is found on the mini cart");

		} catch (Exception e) {
			Log.error("Exception in Class MiniCart_Page | Method MiniCartNoItemText");
			Log.error("No item present in cart text is not found on the mini cart");
			throw e;
		}

		return element;

	}
	// In the card page footer pinterestIcon
	public static WebElement pinterestIcon() throws Exception {

		try {
			Log.info("Locating No item present in cart text element on the mini cart");
			element = Driver.findElement(By.xpath("//*[@class='pinterest-icon']"));
			Utils.highLight(element);
			Log.info("No item present in cart text is found on the mini cart");

		} catch (Exception e) {
			Log.error("Exception in Class MiniCart_Page | Method MiniCartNoItemText");
			Log.error("No item present in cart text is not found on the mini cart");
			throw e;
		}

		return element;

	}
	// In the card page footer googlePlusIcon
	public static WebElement googlePlusIcon() throws Exception {

		try {
			Log.info("Locating No item present in cart text element on the mini cart");
			element = Driver.findElement(By.xpath("//*[@class='google-plus-icon']"));
			Utils.highLight(element);
			Log.info("No item present in cart text is found on the mini cart");

		} catch (Exception e) {
			Log.error("Exception in Class MiniCart_Page | Method MiniCartNoItemText");
			Log.error("No item present in cart text is not found on the mini cart");
			throw e;
		}

		return element;

	}
	// In the card page footer instagramIcon
	public static WebElement instagramIcon() throws Exception {

		try {
			Log.info("Locating No item present in cart text element on the mini cart");
			element = Driver.findElement(By.xpath("//*[@class='instagram-icon']"));
			Utils.highLight(element);
			Log.info("No item present in cart text is found on the mini cart");

		} catch (Exception e) {
			Log.error("Exception in Class MiniCart_Page | Method MiniCartNoItemText");
			Log.error("No item present in cart text is not found on the mini cart");
			throw e;
		}

		return element;

	}
	}