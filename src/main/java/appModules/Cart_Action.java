package appModules;

import pageObjects.MiniCart_Page;
import pageObjects.ProductDetails_Page;

import java.sql.Driver;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pageObjects.BaseClass;
import pageObjects.Cart_Page;
import pageObjects.Checkout_Page;
import pageObjects.Home_Page;
import pageObjects.ProductListing_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;

public class Cart_Action {
	static String ProductN;
	public static String ProductUnit;
	public static String ProductCase;
	public static String ShoppingListN;
	public static String strSel;
	public static WebElement element = null;
	private static List<WebElement> elements = null;

	public static void CheckMiniCartItemCount(int iTestCaseRow) throws Exception {
		String shoppingCartItemCount;

		Log.info("Verification for minicart product count for guest user");

		try {
			System.out.println("1");
			Thread.sleep(5000);

			String cartCount = MiniCart_Page.QtyMiniCart().getText().toString();
			System.out.println("2");
			int c_count = 0;
			try {
				c_count = Integer.parseInt(cartCount);
			} catch (NumberFormatException e) {
				System.out.println("Cart contains zero items");
			}

			if (c_count > 0) {
				BaseClass.errorValidation += "Product item is already added to cart. It should be blank\n";
			}

			PDP_Action.product_selectSize(ProductDetails_Page.Product.size_variant_buttonlist());
			Thread.sleep(5000);
			Utils.jsClick(ProductDetails_Page.Product.Product_AddToCart());
			System.out.println("clicked on add to cart");
			Utils.waitForPageLoadLongTime();
			Thread.sleep(5000);
			System.out.println(MiniCart_Page.QtyMiniCart().getText().toString());
		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method CheckMiniCartItemCount");
			Log.error(e.getMessage());
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void Verify_CartPage_Default_Content(int iTestCaseRow) throws Exception {
//	MiniCart_Page.MiniCartProductDetails.MiniCartViewBag().click();
		// Minicart Functionality Removed
		Thread.sleep(5000);
		Utils.jsClick(Cart_Page.cartIcon());
		Utils.waitForPageLoadLongTime();
		Thread.sleep(5000);
		System.out.println("View Bag button is cliccked in minicart pop up");
		Log.info("View Bag button is cliccked in minicart pop up");
		Log.info("Verification for order summary section on cart page for registered user started");

		try {
			Utils.verifyElement(Cart_Page.CoupanCodeFieldcart());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Coupan code field is not present on cart page\n";
		}
		try {
			Utils.verifyElement(Cart_Page.PinCodeField());
			System.out.println("Verified pincode field");
		} catch (Exception e) {
			Log.error(e.getMessage());
			BaseClass.errorValidation += "Pincode Textbox is not present\n";
		}
		try {
			Utils.verifyElement(Cart_Page.ApplyCoupanButtoncart());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Apply Coupan button is not present on cart page\n";
		}
		try {
			Utils.verifyElement(Cart_Page.SubTotalField());
			System.out.println("Verified subtotal field");
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Sub Totoal field is not present on cart page\n";
		}
		try {
			Utils.verifyElement(Cart_Page.DeliveryCahrgesField());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Delivery Cahrges Field is not present on cart page\n";
		}
		try {
			Utils.verifyElement(Cart_Page.GiftPackingField());
			System.out.println("verified gift packing field");
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Gift Packing Field is not present on cart page\n";
		}

		try {
			Utils.verifyElement(Cart_Page.CoupanDiscountField());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Coupon Discount Field is not present on cart page\n";
		}
		try {
			Utils.verifyElement(Cart_Page.PayableAmountContainer());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Payable Amount Container is not present on cart page\n";
		}
		try {
			Utils.verifyElement(Cart_Page.YouHaveSavedContainer());
			System.out.println("verified YouHaveSavedContainer");
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "You Have Saved Container is not present on cart page\n";
		}
		try {
			Utils.verifyElement(Cart_Page.CheckoutButton());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Checkout button is not present on cart page\n";
		}

		try {
			Utils.verifyElement(Cart_Page.UseGiftCard_Vouchar_Info());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "'Do you have a gift card or and electronic gift voucher? Use it at the payment page.'- section is not present on cart page\n";
		}

		Log.info("Verification for cart page details for registered user started ");
		try {
			Log.info("Locating First Citizen Image on Cart Page");
			Utils.verifyElement(Cart_Page.FirstCitizenImage());
			System.out.println("verified first citizen image");
		} catch (Exception e) {
			BaseClass.errorValidation += "Unable to Locate First Citizen Image on Cart Page";
		}
		try {
			Utils.verifyElement(Cart_Page.ShoppingBagItemCountDetails());
		} catch (Exception e) {
			Log.error(e.getMessage());
			BaseClass.errorValidation += "Shopping Bag Item Count Details does not exist on the cart page \n";
		}
		try {
			if (!(Cart_Page.ProductImage().size() > 0)) {
				BaseClass.errorValidation += "Product Image does not exist on the cart page \n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}
		try {
			if (!(Cart_Page.ProductBrandName().size() > 0)) {
				BaseClass.errorValidation += "Product Brand name does not exist on the cart page \n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}
		try {
			if (!(Cart_Page.ProductName().size() > 0)) {
				BaseClass.errorValidation += "Product name does not exist on the cart page \n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}

		try {
			if (!(Cart_Page.CartInfo().size() > 0)) {
				BaseClass.errorValidation += "Product Specific Information does not exist on the cart page \n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}
		try {
			if (!(Cart_Page.RemoveProductOnCartPage().size() > 0)) {
				BaseClass.errorValidation += "Remove product link does not exist on the cart page \n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}
		try {
			if (!(Cart_Page.ProductPriceInfo().size() > 0)) {
				System.out.println(Cart_Page.ProductPriceInfo().size());
				BaseClass.errorValidation += "Prodcut Price field does not exist on the cart page \n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}
		Log.info("Verification for Gift wrap and message drop down on cart page for registered user started");
		try {
			Utils.verifyElement(Cart_Page.GiftWrapIcon());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "gift Wrap icon is not present on cart page\n";
		}
		try {
			Utils.verifyElement(Cart_Page.AddMessageDropDown());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Add Gift Wrap message drop down is not present on cart page\n";
		}
		try {
			Utils.verifyElement(Cart_Page.AddMessageOnGiftWrapLink());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Add Gift Wrap message link is not present on cart page\n";
		}
		try {
			Utils.verifyElement(Cart_Page.ContinueShoppingButton());
			Utils.jsClick(Cart_Page.ContinueShoppingButton());

			Thread.sleep(5000);
			System.out.println(Utils.getPageTitle());

//			if(ProductListing_Page.HeadingProductCount().isDisplayed())
//			{
//				System.out.println("User redirected back to shopping page");
//			}
//			else
//			{
//				System.out.println("exception in clicking continue chopping button");
//			}
//			

		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Continue Shopping button is not present on cart page\n";
		}
	}

	public static void CheckMiniCartShippingCost(int iTestCaseRow) throws Exception {
		int ShippingCost;
		String TipText;

		Log.info("Verification for shipping cost for item");
		try {

			// ShippingCost = Integer.parseInt(Cart_Page.ShippingCostText().getText());
			// Cart_Page.ShippingCostText().getText();
			System.out.println(Cart_Page.ShippingCostText().getText());
			if (!(Cart_Page.ShippingCostText().getText().startsWith("Rs"))) {
				BaseClass.errorValidation += "ShippingCost not inculded for item\n";
			}
			Log.info("Verification for ShippingCost successful done");
		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method CheckMiniCartShippingCost");
			Log.error(e.getMessage());
			throw e;
		}

		try {

			System.out.println(Cart_Page.ShippingCostTip().getText());
			if (!(Cart_Page.ShippingCostTip().getText().startsWith("TIP:"))) {
				BaseClass.errorValidation += "ShippingCost Tip not inculded for item\n";
			}
			Log.info("Verification for ShippingCost successful done");
		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method CheckMiniCartShippingCost");
			Log.error(e.getMessage());
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void CheckMiniCartShippingCostFinal(int iTestCaseRow) throws Exception {

		Log.info("Verification for shipping cost for item");
		try {

			// ShippingCost = Integer.parseInt(Cart_Page.ShippingCostText().getText());
			// Cart_Page.ShippingCostText().getText();
			// System.out.println(Cart_Page.ShippingCostText().getText());
			if (!(Cart_Page.ShippingCostText().getText().startsWith("Rs"))) {
				BaseClass.errorValidation += "ShippingCost not inculded for item\n";
			}
			Log.info("Verification for ShippingCost successful done");
		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method CheckMiniCartShippingCostFinal");
			Log.error(e.getMessage());
			throw e;
		}

		if (!BaseClass.errorValidation.isEmpty()) {
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void CheckMiniCartItemCountRegisteredUser(int iTestCaseRow) throws Exception {
		Log.info("Verification for minicart product count for Registered user");
		int shoppingCartItemCountBefore;
		int shoppingCartItemCountAfter;

		// Utils.mouseHover(MiniCart_Page.MiniCart());
		// MiniCart_Page.MiniCart().sendKeys(Keys.ENTER);
		// Thread.sleep(10000);

		// Utils.verifyElement(MiniCart_Page.MiniCartWindow());
		shoppingCartItemCountBefore = Integer.parseInt(Home_Page.headerMiniCartItemCountIcon().getText());
		PDP_Action.product_selectSize(ProductDetails_Page.Product.size_variant_buttonlist());
		ProductDetails_Page.Product.Product_AddToCart().click();
		Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.browser));
		Log.info("Product added to cart on PDP");
		try {
			shoppingCartItemCountAfter = Integer.parseInt(Home_Page.headerMiniCartItemCountIcon().getText());
			if (shoppingCartItemCountBefore >= shoppingCartItemCountAfter) {
				BaseClass.errorValidation += "Product count does not change when item added to cart \n";
			}
			MiniCart_Page.removeBtn().click();
			Log.info("Remove product button is clicked on minicart");
		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method CheckMiniCartItemCountRegisteredUser");
			Log.error(e.getMessage());
			throw e;

		}
		if (!BaseClass.errorValidation.isEmpty()) {
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void CheckMiniCartRemoveFunctionality(int iTestCaseRow) throws Exception {
		Log.info("Verification for removing product in minicart for registered user");
		int shoppingCartItemCountAfter;
		try {
			Utils.verifyElement(MiniCart_Page.MiniCartWindow());
			int shoppingCartItemCountBefore = Integer.parseInt(Home_Page.headerMiniCartItemCountIcon().getText());
			System.out.println(shoppingCartItemCountBefore);
			MiniCart_Page.removeBtn().click();
			Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.browser));
			Log.info("Remove product buton clicked on minicart");
			shoppingCartItemCountAfter = Integer.parseInt(Home_Page.headerMiniCartItemCountIcon().getText());
			System.out.println(shoppingCartItemCountAfter);
			if (shoppingCartItemCountAfter >= shoppingCartItemCountBefore) {
				BaseClass.errorValidation += "Product count is not correct in mini cart should decrease when product removed from cart\n";
			}
		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method CheckMiniCartRemoveFunctionality");
			Log.error(e.getMessage());
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			throw new Exception(BaseClass.errorValidation);
		}
	}
//updated this method, if mini cart present on the screen then works else just skip
	public static void CheckMinicartDetails(int iTestCaseRow) throws Exception {
		Log.info("Verification for minicart details started");
		Utils.mouseHover(MiniCart_Page.MiniCartWindow());
		System.out.println("mouse hovered on minicart");
		try {
			if (MiniCart_Page.MiniCartProductImages().size() > 0) {
				System.out.println("Product Image is not present in mini cart");
				try {
					Thread.sleep(500);
					if (!(MiniCart_Page.MiniCartProductDetails.MiniCartProductBrandName().size() > 0)) {
						System.out.println("Product Brand name is not present in mini cart");
						BaseClass.errorValidation += "Product Brand name is not present in mini cart\n";
					}
				} catch (Exception e) {
					Log.error(e.getMessage());
					throw e;
				}

				try {
					Thread.sleep(500);
					if (!(MiniCart_Page.MiniCartProductDetails.MiniCartProductProductName().size() > 0)) {
						System.out.println("Product name is not present in mini cart");
						BaseClass.errorValidation += "Product name is not present in mini cart\n";
					}
				} catch (Exception e) {
					Log.error(e.getMessage());
					throw e;
				}

				try {
					Thread.sleep(500);
					if (!(MiniCart_Page.MiniCartProductDetails.MiniCartProductSpec().size() > 0)) {
						System.out.println("Product Specifications is not present in mini cart");
						BaseClass.errorValidation += "Product Specifications is not present in mini cart\n";
					}
				} catch (Exception e) {
					Log.error(e.getMessage());
					throw e;
				}
				Utils.mouseHover(MiniCart_Page.MiniCartWindow());
				try {
					Thread.sleep(500);
					Utils.CheckEnability(MiniCart_Page.MiniCartProductDetails.MiniCartViewBag());
					System.out.println("checking mini cart view");
				} catch (Exception e) {
					Log.error(e.getMessage());
					BaseClass.errorValidation += "Add to Bag button is not present in mini cart\n";
				}
				try {
					Thread.sleep(1000);
					Utils.CheckEnability(MiniCart_Page.MiniCartProductDetails.MiniCartCheckOutButton());
					System.out.println("checking checkout button");
				} catch (Exception e) {
					Log.error(e.getMessage());
					BaseClass.errorValidation += "Checkout button is not present in mini cart\n";
				}
				try {
					Thread.sleep(1000);
					Utils.CheckEnability(MiniCart_Page.MiniCartTotalPrice());
					System.out.println("checking minincart price");
				} catch (Exception e) {
					Log.error(e.getMessage());
					BaseClass.errorValidation += "Total Price is not present in mini cart\n";
				}	
			}
			else{
				System.out.println("Mini cart is disabled So no need to check all this");
				Log.error("Mini cart is disabled So no need to check all this");
			}
		} catch (Exception e) {
			System.out.println("Mini cart is disabled So no need to check all this");
			Log.error("Mini cart is disabled So no need to check all this");
		}
		System.out.println("minicart price completed");

	}

	public static void Check_NavigationTo_Checkout_GuestUser(int iTestCaseRow) throws Exception {
		Log.info("Verification for navigation to checkout page for guest user started");
		try {
			System.out.println("checout page");
			Utils.verifyElement(Cart_Page.CheckoutButton());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "CheckOut button is not present on cart page\n";
		}
		Utils.waitForElementPresence2(Cart_Page.CheckoutButton());
		Utils.jsClick(Cart_Page.CheckoutButton());
		Log.info("Checkout button is clicked on cart page");
		try {
			Utils.PageHeaderCheck("Proceed to Checkout | Shoppers Stop");
		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method Check_NavigationTo_Checkout_GuestUser");
			Log.error(e.getMessage());
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void Verify_Private_Cart_Page_ShoppingBag_Details(int iTestCaseRow) throws Exception {
		Log.info("Verification for cart page details for registered user started ");
		try {
			Utils.verifyElement(Cart_Page.ShoppingBagItemCountDetails());
		} catch (Exception e) {
			Log.error(e.getMessage());
			BaseClass.errorValidation += "Shopping Bag Item Count Details does not exist on the cart page \n";
		}
		try {
			if (!(Cart_Page.ProductImage().size() > 0)) {
				BaseClass.errorValidation += "Shopping Bag Item Count Details does not exist on the cart page \n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}
		try {
			if (!(Cart_Page.ProductImage().size() > 0)) {
				BaseClass.errorValidation += "Product Image does not exist on the cart page \n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}
		try {
			if (!(Cart_Page.ProductBrandName().size() > 0)) {
				BaseClass.errorValidation += "Product Brand name does not exist on the cart page \n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}
		try {
			if (!(Cart_Page.ProductName().size() > 0)) {
				BaseClass.errorValidation += "Product name does not exist on the cart page \n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}

		try {
			if (!(Cart_Page.CartInfo().size() > 0)) {
				BaseClass.errorValidation += "Product Specific Information does not exist on the cart page \n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}
		try {
			if (!(Cart_Page.EditCartLink().size() > 0)) {
				BaseClass.errorValidation += "Edit cart link does not exist on the cart page \n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}
		try {
			if (!(Cart_Page.MoveToWishlist().size() > 0)) {
				BaseClass.errorValidation += "Move To Wishlist icon does not exist on the cart page \n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}
		try {
			if (!(Cart_Page.RemoveProductOnCartPage().size() > 0)) {
				BaseClass.errorValidation += "Remove product link does not exist on the cart page \n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}
		try {
			if (!(Cart_Page.ProductPriceInfo().size() > 0)) {
				BaseClass.errorValidation += "Prodcut Price field does not exist on the cart page \n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}

		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ShoppingBag_Details");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void Verify_Private_Cart_Page_OrderSummary_Details(int iTestCaseRow) throws Exception {
		Log.info("Verification for order summary section on cart page for registered user started");
		try {
			Utils.verifyElement(Cart_Page.ContinueShoppingButton());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Continue Shopping button is not present on cart page\n";
		}
		try {
			Utils.verifyElement(Cart_Page.CoupanCodeFieldcart());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Coupan code field is not present on cart page\n";
		}
		try {
			Utils.verifyElement(Cart_Page.ApplyCoupanButtoncart());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Apply Coupan button is not present on cart page\n";
		}
		try {
			Utils.verifyElement(Cart_Page.SubTotalField());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Sub Totoal field is not present on cart page\n";
		}
		try {
			Utils.verifyElement(Cart_Page.DeliveryCahrgesField());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Delivery Cahrges Field is not present on cart page\n";
		}
		try {
			Utils.verifyElement(Cart_Page.GiftPackingField());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Gift Packing Field is not present on cart page\n";
		}

		try {
			Utils.verifyElement(Cart_Page.CoupanDiscountField());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Coupan Discount Field is not present on cart page\n";
		}
		try {
			Utils.verifyElement(Cart_Page.PayableAmountContainer());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Payable Amount Container is not present on cart page\n";
		}
		try {
			Utils.verifyElement(Cart_Page.YouHaveSavedContainer());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "You Have Saved Container is not present on cart page\n";
		}
		try {
			Utils.verifyElement(Cart_Page.CheckoutButton());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Checkout button is not present on cart page\n";
		}

		try {
			Utils.verifyElement(Cart_Page.UseGiftCard_Vouchar_Info());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "'Do you have a gift card or and electronic gift voucher? Use it at the payment page.'- section is not present on cart page\n";
		}

		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_OrderSummary_Details");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void Verify_Private_Cart_Page_GiftWrap_Details(int iTestCaseRow) throws Exception {
		Log.info("Verification for Gift wrap and message drop down on cart page for registered user started");
		try {
			Utils.verifyElement(Cart_Page.GiftWrapIcon());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "gift Wrap icon is not present on cart page\n";
		}
		try {
			Utils.verifyElement(Cart_Page.AddMessageDropDown());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Add Gift Wrap message drop down is not present on cart page\n";
		}
		try {
			Utils.verifyElement(Cart_Page.AddMessageOnGiftWrapLink());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Add Gift Wrap message link is not present on cart page\n";
		}

		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_GiftWrap_Details");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void Verify_Private_Cart_Page_Other_Details(int iTestCaseRow) throws Exception {
		Log.info("Verification for other links on cart page for registered user started");
		try {
			Utils.verifyElement(Cart_Page.FirstCitizenLoyalityProgramBanner());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "First Citizen Loyality Program Banner is not present on cart page\n";
		}
		try {
			Utils.verifyElement(Cart_Page.EnterFCCNumber());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Enter FCC Number field is not present on cart page\n";
		}
		try {
			Utils.verifyElement(Cart_Page.EarnPointsButton());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Earn Points Button is not present on cart page\n";
		}
		try {
			if (!(Cart_Page.FromYourWishlistImages().size() > 0)) {
				BaseClass.errorValidation += "From Your Wishlist Images does not exist on the cart page \n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}
		try {
			Utils.verifyElement(Cart_Page.PinCodeField());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Pin Code Field is not present on cart page\n";
		}
		try {
			Utils.verifyElement(Cart_Page.CheckPinCodeButton());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Check Pin Code Button is not present on cart page\n";
		}
		try {
			Utils.verifyElement(Cart_Page.FreeDeliveryIcon());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Free Delivery Icon is not present on cart page\n";
		}
		try {
			Utils.verifyElement(Cart_Page.InStoreReturnsLink());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "In Store Returns Link is not present on cart page\n";
		}
		try {
			Utils.verifyElement(Cart_Page.AnyQuestionsContainer());
		} catch (Exception e) {

			Log.error(e.getMessage());
			BaseClass.errorValidation += "Any Questions Container is not present on cart page\n";
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_Other_Details");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void Verify_Public_Edit_Cart_Page(int iTestCaseRow) throws Exception {
		Log.info("Verification for edit cart functionality on cart page for guest user started");
		String productQuantity = "";
		try {
			productQuantity = Cart_Page.PresentQuantity().getAttribute("value");
			Log.info("Edit cart link clicked successfully");
//			Utils.jsClick(Cart_Page.PresentQuantity());
			Log.info("Increase quantity link clicked successfully");
//			Cart_Page.PresentQuantity().click();
//			s.selectByIndex(0);
			Utils.waitForPageLoadLongTime();
			Thread.sleep(5000);
			//Cart_Page.SelectQuantity().click();
			Utils.jsClick(Cart_Page.SelectQuantity());
			Thread.sleep(5000);
			Cart_Page.SelectFirstQuantity().click();
			Thread.sleep(5000);
			Log.info("Update cart link clicked successfully");
			System.out.println(Cart_Page.PresentQuantity().getAttribute("value"));

			if (!(Cart_Page.DefaultCartPageAlert().getText().contains("Product has been updated."))) {
				BaseClass.errorValidation += "Product quantity updated success message is not displayed";
			}
		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method Verify_Public_Edit_Cart_Page");
			Log.error(e.getMessage());
			throw e;
		}
	}

	public static void Verify_Public_Edit_Cart_Page_sameproduct(int iTestCaseRow) throws Exception {
		Log.info("Verification for edit cart functionality on cart page for guest user started");
		String productQuantity = "";
		String productSize = "";
		try {
			productQuantity = Cart_Page.UpdateQuantity().get(0).getAttribute("value");
			Thread.sleep(1000);
			Cart_Page.EditCartLink().get(0).click();
			Log.info("Edit cart link clicked successfully");
			Thread.sleep(5000);
			Utils.SelectDropdownUpdated(Cart_Page.UpdateProductSize().get(0));
			Thread.sleep(1000);
			Cart_Page.UpdateCartItem().get(0).sendKeys(Keys.ENTER);
			Log.info("Update cart link clicked successfully");
			Thread.sleep(1000);
			if (Cart_Page.UpdateQuantity().get(0).getAttribute("value").equals(productQuantity)) {
				BaseClass.errorValidation += "Product quantity increase functionality not working\n";
			}
		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method Verify_Public_Edit_Cart_Page");
			Log.error(e.getMessage());
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class Cart_Action | Method Verify_Public_Edit_Cart_Page");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void Send_Personalized_Message(int iTestCaseRow) throws Exception {
		Cart_Page.AddMessageDropDown().click();
		Cart_Page.RecipientName().sendKeys("Dear Kattappa");
		Cart_Page.GiftMessage().sendKeys("Finally pata chalega tune Bahubali ko kyu mara :)");
		Cart_Page.SenderName().sendKeys("Amrish Puri");
		Utils.verifyElement(Cart_Page.CancelGiftMessage());
		Cart_Page.SaveGiftMessage().click();
		Thread.sleep(1000);
		Utils.verifyElement(Cart_Page.RemoveGiftMessage());
	}

	public static void Verify_Private_Cart_Page_RemoveProduct(int iTestCaseRow) throws Exception {
		Log.info("Verification for removing product from cart page started");
		int productCountBefore;
		int productCountAfter;
		try {
			productCountBefore = Cart_Page.ProductPriceInfo().size();
			Log.info("Product count before removing product obtained successfully");
			Cart_Page.RemoveProductOnCartPage().get(0).click();
			Log.info("Remove product link clicked successfully");
			Thread.sleep(3000);
			try {
				Utils.verifyElement(Cart_Page.DefaultCartPageAlert());
				if (!(Cart_Page.DefaultCartPageAlert().getText().trim()
						.contains("Product has been removed from your cart."))) {
					BaseClass.errorValidation += "Product remove alert not present on page. \n";
				}
			} catch (Exception e) {
				Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_RemoveProduct");
				Log.error(e.getMessage());
				throw e;
			}

			productCountAfter = Cart_Page.ProductPriceInfo().size();
			Log.info("Product count after removing product obtained successfully");
			if (productCountAfter == productCountBefore) {
				BaseClass.errorValidation += "Product remove functionality not working. \n";
			}

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_RemoveProduct");
			Log.error(e.getMessage());
			throw e;
		}

	}

	public static void Verify_Private_Cart_Page_ApplyCoupan(int iTestCaseRow) throws Exception {
		Log.info("Verification for Applying Coupon on cart page started");
		String totalCartPrice = "";
		String totalCartPrice1 = "";

		totalCartPrice = Cart_Page.TotalCartPrice().getText();
		Log.info("Total cart price obtained successfully");
		try {
			Cart_Page.ApplyCoupanButton().click();
			Thread.sleep(3000);
			Utils.waitForPageLoad();
			Log.info("EApply Coupan link clicked successfully");//Invalid Coupon
			System.out.println("value from web is "+Cart_Page.InvalidCoupanAlert().getText());
			if (!(Cart_Page.InvalidCoupanAlert().getText().equals("Invalid Coupon"))) {
				//BaseClass.errorValidation += "Invalid Coupon alert not present on page. \n";
			}
		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
			Log.error(e.getMessage());
			throw e;
		}
		//no coupon codes available on production to apply
		try {
			Thread.sleep(2000);
			//Cart_Page.CoupanCodeFieldcart().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.invalidPromoCode));
			Cart_Page.CoupanCodeFieldcart().sendKeys("123456");
			Log.info("Coupon code entered successfully");
			Thread.sleep(2000);
			Cart_Page.ApplyCoupanButton().click();
			Log.info("Apply Coupon code link clicked successfully");
			//updated invalid message : Coupon is invalid
			//
			Thread.sleep(3000);
			//
			if (!(Cart_Page.DefaultCartPageAlert().getText().equals("Please enter the Valid Coupon Code!"))) {
				BaseClass.errorValidation += "'Please enter the Valid Coupon Code!' - alert not present on page. \n";
			}
		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
			Log.error(e.getMessage());
			throw e;
		}
		/*if ((Constant.URL != "https://www.shoppersstop.com/")) {
			try {
				Cart_Page.CoupanCodeFieldcart().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.promoCode));
				Log.info("Coupon code entered successfully");
				Cart_Page.ApplyCoupanButton().click();
				Thread.sleep(5000);
				Log.info("Apply Coupon code link clicked successfully");
				System.out.println(totalCartPrice);
				// totalCartPrice1=Cart_Page.TotalCartPrice().getText();
				if (!(Cart_Page.DefaultCartPageAlert().getText().contains("Voucher applied successfully!"))) {
					BaseClass.errorValidation += "'Voucher applied successfully!' - alert not present on page. \n";
				}
				if (Cart_Page.TotalCartPrice().getText().equals(totalCartPrice)) {
					BaseClass.errorValidation += "Coupon coded discount not applied. \n";
				}
			} catch (Exception e) {
				Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
				Log.error(e.getMessage());
				throw e;
			}
			//no coupon codes available on production to apply
			/*try {
				Thread.sleep(2000);
				Utils.jsClick(Cart_Page.RemoveCouponCode());
				Thread.sleep(6000);
				Log.info("Remove Coupon code link clicked successfully");
				if (!(Cart_Page.TotalCartPrice().getText().equals(totalCartPrice))) {
					BaseClass.errorValidation += "Coupon coded discount not removed. \n";
				}
				if (!(Cart_Page.DefaultCartPageAlert().getText().contains("Voucher removed successfully!"))) {
					BaseClass.errorValidation += "'Voucher removed successfully!'- alert present on cart page. \n";
				}
			} catch (Exception e) {
				Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
				Log.error(e.getMessage());
				throw e;
			}
		}*/
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void Verify_Private_Cart_Page_ApplyCoupanOnCartPage(int iTestCaseRow) throws Exception {
		Log.info("Verification for Applying Coupon on cart page started");
		String totalCartPrice = "";
		String totalCartPrice1 = "";
		String totalCartPrice3 = "";
		String totalCartPrice4 = "";

		totalCartPrice = Cart_Page.TotalCartPriceViewPage().getAttribute("content");

		Log.info("Total cart price obtained successfully");
		try {
			Cart_Page.CoupanCodeFieldcart().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.invalidPromoCode));
			Log.info("Coupon code entered successfully");
			Cart_Page.ApplyCoupanButtoncart().click();
			Log.info("Apply Coupon code link clicked successfully");
			if (!(Cart_Page.InvalidCoupanAlertViewBag().getText().equals("Please enter the Valid Coupon Code!"))) {
				BaseClass.errorValidation += "'Please enter the Valid Coupon Code!' - alert not present on page. \n";
			}
		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
			Log.error(e.getMessage());
			throw e;
		}
		try {
			Cart_Page.CoupanCodeFieldcart().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.promoCode));
			Log.info("Coupon code entered successfully");
			Cart_Page.ApplyCoupanButtoncart().click();
			Log.info("Apply Coupon code link clicked successfully");
			// totalCartPrice3=Cart_Page.TotalCartPriceViewPagePrice().getAttribute("content");
			// System.out.println(totalCartPrice3);
			// totalCartPrice1=Cart_Page.TotalCartPriceViewPage().getText();

			if (Cart_Page.TotalCartPriceViewPage().getAttribute("content").equals(totalCartPrice)) {
				BaseClass.errorValidation += "Coupon coded discount not applied. \n";
			}
		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
			Log.error(e.getMessage());
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void Verify_Private_Cart_Page_CheckPriceFinal(int iTestCaseRow) throws Exception {

		try {
			Log.info("Verification for Applying Coupon on cart page started");

			String totalCartPrice4 = "";
			String totalCartPrice3 = "";

			totalCartPrice3 = Cart_Page.TotalCartPriceViewPagePrice().getAttribute("content");
			System.out.println(totalCartPrice3);
			totalCartPrice4 = Cart_Page.TotalCartPriceCheckout().getAttribute("content");
			System.out.println(totalCartPrice4);
			Log.info("Total cart price obtained successfully");

			// if (Cart_Page.TotalCartPriceViewPage().getText().equals(totalCartPrice)) {
			// BaseClass.errorValidation += "Coupon coded discount not applied. \n";
			// }
		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
			Log.error(e.getMessage());
			throw e;
		}

		// System.out.println(Cart_Page.TotalCartPriceViewPage().getText());
		// System.out.println(Cart_Page.TotalCartPriceViewPagePrice().getAttribute("content"));
		// try {

		// //Utils.mouseHover(Cart_Page.RemoveCouponCodeCartPage());
		// Cart_Page.RemoveCouponCodeCartPage().click();
		// Thread.sleep(5000);
		// Log.info("Remove Coupon code link clicked successfully");
		// if (!(Cart_Page.TotalCartPriceViewPage().getText().equals(totalCartPrice))) {
		// BaseClass.errorValidation += "Coupon coded discount not removed. \n";
		// }
		// if (!(Cart_Page.InvalidCoupanAlertViewBag().getText().equals("Voucher removed
		// successfully!"))) {
		// BaseClass.errorValidation += "'Voucher removed successfully!'- alert present
		// on cart page. \n";
		// }
		// } catch (Exception e) {
		// Log.error("Exception in Class Cart_Action | Method
		// Verify_Private_Cart_Page_ApplyCoupan");
		// Log.error(e.getMessage());
		// throw e;
		// }
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void Verify_Private_Cart_Page_RemoveCoupanOnCartPage(int iTestCaseRow) throws Exception {

		try {
			Utils.mouseHover(Cart_Page.RemoveCouponCodeCartPage());
			Cart_Page.RemoveCouponCodeCartPage().sendKeys(Keys.ENTER);

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
			Log.error(e.getMessage());
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void Verify_Private_Cart_Page_CheckoutButtonOnCart(int iTestCaseRow) throws Exception {

		try {
			Cart_Page.CheckoutButtonOnCart().click();

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
			Log.error(e.getMessage());
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void Verify_Private_Cart_Page_ApplyCoupan_noremove(int iTestCaseRow) throws Exception {
		Log.info("Verification for Applying Coupon on cart page started");
		String totalCartPrice = "";
		String totalCartPrice1 = "";
		String totalCartPrice2 = "";

		// totalCartPrice = Cart_Page.TotalCartPrice().getText();
		// totalCartPrice1 = Cart_Page.TotalCartPrice1().getText()
		Log.info("Total cart price obtained successfully");
		try {
			Cart_Page.ApplyCoupanButton().click();
			Log.info("EApply Coupan link clicked successfully");
			if (!(Cart_Page.InvalidCoupanAlert().getText().equals("This field is required."))) {
				BaseClass.errorValidation += "Invalid Coupon alert not present on page. \n";
			}
		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
			Log.error(e.getMessage());
			throw e;
		}
		try {
			Cart_Page.CoupanCodeField().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.invalidPromoCode));
			Log.info("Coupon code entered successfully");
			Cart_Page.ApplyCoupanButton().click();
			Log.info("Apply Coupon code link clicked successfully");
			if (!(Cart_Page.CartPageAlert().getText().equals("Please enter the Valid Coupon Code!"))) {
				BaseClass.errorValidation += "'Please enter the Valid Coupon Code!' - alert not present on page. \n";
			}
		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
			Log.error(e.getMessage());
			throw e;
		}
		try {
			Cart_Page.CoupanCodeField().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.promoCode));
			Log.info("Coupon code entered successfully");
			Cart_Page.ApplyCoupanButton().click();
			Log.info("Apply Coupon code link clicked successfully");
			totalCartPrice1 = Cart_Page.TotalCartPrice().getText();
			System.out.println(totalCartPrice1);
			if (Cart_Page.TotalCartPrice().getText().equals(totalCartPrice)) {
				BaseClass.errorValidation += "Coupon coded discount not applied. \n";
			}
		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
			Log.error(e.getMessage());
			throw e;
		}

		try {
			Cart_Page.BacktoCartPageButton().click();
			Thread.sleep(2000);
			Log.info("BacktoCart button clicked successfully");

			Utils.verifyElement(Home_Page.headerMiniCartIcon());
			// Utils.mouseHover(Home_Page.headerMiniCartIcon());
			// Home_Page.headerMiniCartIcon().click();
			Thread.sleep(5000);

			totalCartPrice2 = Cart_Page.TotalCartPriceMain().getText();
			System.out.println(totalCartPrice2);

			// if (Cart_Page.TotalCartPriceMain().getText().equals(BeforePrice)) {
			// BaseClass.errorValidation += "Coupon coded discount not applied. \n";

		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
			Log.error(e.getMessage());
			throw e;
		}

		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_ApplyCoupan");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void Verify_Private_Cart_Page_MoveToWishlist(int iTestCaseRow) throws Exception {
		Log.info("Verification for moving product to wishlist on cart page started");
		String totalCartPrice = "";
		// String productCode = "";
		int productCountAfter;

		totalCartPrice = Cart_Page.TotalCartPrice().getAttribute("content");
		Log.info("Total cart price obtained successfully");
		// productCode = Cart_Page.ProductCode().get(0).getAttribute("value");
		Log.info("Product code obtained successfully");
		try {
			Cart_Page.MoveToWishlist().get(0).click();
			Thread.sleep(1000);
			Log.info("Move to wishlist link clicked successfully");
			System.out.println(Cart_Page.DefaultCartPageAlert().getText());
			if (!((Cart_Page.DefaultCartPageAlert().getText())
					.contains("Product added to the wishlist successfully"))) {
				BaseClass.errorValidation += "'Product added to the wishlist successfully' - alert not present on page. \n";
			}
		} catch (Exception e) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_MoveToWishlist");
			Log.error(e.getMessage());
			throw e;
		}
		try {
			// Remove from Wishlist
			Cart_Page.RemovefromWishlist().get(0).click();
			Thread.sleep(1000);
			System.out.println(Cart_Page.DefaultCartPageAlert().getText());
		} catch (Exception ex) {
			BaseClass.errorValidation += "Unable to remove from Wishlist\n";
		}

		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class Cart_Action | Method Verify_Private_Cart_Page_MoveToWishlist");
			throw new Exception(BaseClass.errorValidation);
		}

	}

	public static void Cart_Page_GiftWrapMessageForm(int iTestCaseRow) throws Exception {
		Log.info("Gift message form opened");
		try {
			Utils.verifyElement(Cart_Page.AddMessageDropDown());
			Cart_Page.AddMessageDropDown().click();
		} catch (Exception e) {
			Log.error(e.getMessage());
			BaseClass.errorValidation += "Add Message Drop Down is not present on Cart Page \n";
		}
		// try {
		// Utils.verifyElement(Cart_Page.AddMessageForm.GiftPaperImages().get(2));
		// Cart_Page.AddMessageForm.GiftPaperImages().get(2).click();
		// } catch (Exception e) {
		// Log.error(e.getMessage());
		// BaseClass.errorValidation += "Gift Wrap product images are not present on Add
		// Message form \n";

		// }
		try {
			Utils.verifyElement(Cart_Page.AddMessageForm.GiftRecipientName());
			Cart_Page.AddMessageForm.GiftRecipientName()
					.sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.firstName));
		} catch (Exception e) {
			Log.error(e.getMessage());
			BaseClass.errorValidation += "Recipient name field is not present on Add Message form \n";

		}
		try {
			Utils.verifyElement(Cart_Page.AddMessageForm.GiftMessage());
			Cart_Page.AddMessageForm.GiftMessage().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.description));
		} catch (Exception e) {
			Log.error(e.getMessage());
			BaseClass.errorValidation += "Gift message field is not present on Add Message form \n";

		}
		try {
			Utils.verifyElement(Cart_Page.AddMessageForm.GiftSenderName());
			Cart_Page.AddMessageForm.GiftSenderName().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.receiver));
		} catch (Exception e) {
			Log.error(e.getMessage());
			BaseClass.errorValidation += "Sender name field is not present on Add Message form \n";
		}
		try {
			Utils.verifyElement(Cart_Page.AddMessageForm.GiftMessageApplyButton());
			Cart_Page.AddMessageForm.GiftMessageApplyButton().sendKeys(Keys.PAGE_DOWN);
			Cart_Page.AddMessageForm.GiftMessageApplyButton().click();
		} catch (Exception e) {
			Log.error(e.getMessage());
			BaseClass.errorValidation += "Gift Message apply button not present on Add Message form \n";

		}

	}

	public static void Cart_Page_EditGiftWrapMessageForm(int iTestCaseRow) throws Exception {
		try {
			Utils.verifyElement(Cart_Page.EditMessageLink());
			Cart_Page.EditMessageLink().click();
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}
	}

	public static void Cart_Page_CancelGiftWrapMessageForm(int iTestCaseRow) throws Exception {

		try {
			Utils.verifyElement(Cart_Page.AddMessageForm.GiftMessageCancelButton());
			Cart_Page.AddMessageForm.GiftMessageCancelButton().click();
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}
	}

	public static void Verify_Public_Cart_Page_GiftWrapMessage(int iTestCaseRow) throws Exception {
		Log.info("Verification for adding gift message started");
		try {
			Cart_Action.Cart_Page_GiftWrapMessageForm(iTestCaseRow);
			Log.info("Gift message form filled successfully");
			Cart_Action.Cart_Page_EditGiftWrapMessageForm(iTestCaseRow);
			Log.info("Edit gift message link clicked successfully");
			Cart_Action.Cart_Page_CancelGiftWrapMessageForm(iTestCaseRow);
			Log.info("Cancel button on gift message form clicked successfully");
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}
	}

	public static void Verify_Public_Cart_Page_RemoveGiftWrapMessage(int iTestCaseRow) throws Exception {
		Log.info("Verification for removing gift message started");
		try {
			Cart_Action.Cart_Page_GiftWrapMessageForm(iTestCaseRow);
			Log.info("Gift message form filled successfully");
			Cart_Action.Cart_Page_EditGiftWrapMessageForm(iTestCaseRow);
			Log.info("Edit gift message link clicked successfully");
			Cart_Page.AddMessageForm.GiftSenderName()
					.sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.alternativeFirstName));
			Cart_Page.AddMessageForm.GiftRecipientName()
					.sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.updatedReceiver));
			Cart_Page.AddMessageForm.GiftMessage()
					.sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.updatedMessage));
			Log.info("Gift form updated with new entries");
			Cart_Page.AddMessageForm.GiftMessageApplyButton().click();
			Log.info("Apply gift message link clicked successfully");
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}
		try {
			Utils.verifyElement(Cart_Page.RemoveMessageLink());
			Cart_Page.RemoveMessageLink().click();
			Log.info("Remove gift message link clicked successfully");
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}
		try {
			Cart_Page.AddMessageDropDown().click();
			Log.info("Gift message drop down clicked successfully");
			String sender = Cart_Page.AddMessageForm.GiftSenderName().getText();
			String recipient = Cart_Page.AddMessageForm.GiftRecipientName().getText();
			String Message = Cart_Page.AddMessageForm.GiftMessage().getText();
			if (!(sender.isEmpty() && recipient.isEmpty() && Message.isEmpty())) {
				BaseClass.errorValidation += "Remove gift message functionality not working. \n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void Verify_Private_Cart_Page_DeliveryOptions(int iTestCaseRow) throws Exception {
		Log.info("Verification for checking pin code for delivery options started");
		try {
			Utils.scrollingToPageElementByCordinate(1100, 550);
			Log.info("Mouse pointer moved to pin code field");
			Cart_Page.CheckPinCodeButton().click();
			Log.info("Check Pin Code link clicked successfully");
			if (!(Cart_Page.InvalidPinCodeAlert().getText().equals("Invalid Pincode"))) {
				BaseClass.errorValidation += "Invalid pin code alert does not exist. \n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}
		try {
			Cart_Page.PinCodeField().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.postCode));
			Log.info("Pin code entered successfully");
			Cart_Page.CheckPinCodeButton().click();
			Log.info("Check Pin Code link clicked successfully");
			if (!(Cart_Page.DeliveryDetails().size() > 0)) {
				BaseClass.errorValidation += "Delivery Details does not exist for product. \n";
			}
			System.out.println(Cart_Page.DeliveryDetails().get(0).getText());
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}
		try {
			Utils.scrollingToPageElementByCordinate(1100, 550);
			Log.info("Mouse pointer moved to pin code field");
			Cart_Page.ChangePinCode().click();
			Log.info("Change Pin Code link clicked successfully");
			Cart_Page.PinCodeField().clear();
			Cart_Page.PinCodeField().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.alternativePostCode));
			Log.info("Pin Code entered successfully");
			Cart_Page.CheckPinCodeButton().click();
			Log.info("Check Pin Code link clicked successfully");
			if (!(Cart_Page.DeliveryDetails().size() > 0)) {
				BaseClass.errorValidation += "Delivery Details does not exist for product. \n";
			}
			if (Cart_Page.DeliveryDetails().get(0).getText().isEmpty()) {
				BaseClass.errorValidation += "'Shipping related message not displayed under product for Pincode - '"
						+ Constant.alternativePostCode + "\n";
				Log.info("Pin Code entered successfully");
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}
		try {
			Utils.scrollingToPageElementByCordinate(1100, 550);
			Log.info("Mouse pointer moved to pin code field");
			Cart_Page.ChangePinCode().click();
			Log.info("Change Pin Code link clicked successfully");
			Cart_Page.PinCodeField().clear();
			Cart_Page.PinCodeField().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.invalidPostCode));
			Log.info("Pin Code entered successfully");
			Cart_Page.CheckPinCodeButton().click();
			Log.info("Check Pin Code link clicked successfully");
			if (!(Cart_Page.DeliveryDetails().size() > 0)) {
				BaseClass.errorValidation += "Delivery Details does not exist for product. \n";
			}
			if (!(Cart_Page.DeliveryDetails().get(0).getText()
					.equals("Product cannot be delivered in this location."))) {
				BaseClass.errorValidation += "'Product cannot be delivered in this location'- is not displayed. \n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			throw new Exception(BaseClass.errorValidation);
		}
	}
	public static void naviagte_Till_checkOut_page(int  iTestCaseRow) throws Exception {
		try {
		HomePage_Action.selectProductCategoryfromSearch(iTestCaseRow);
		Utils.waitForPageLoadLongTime();
		Thread.sleep(2000);
		PDP_Action.product_selectSize(ProductDetails_Page.Product.size_variant_buttonlist());
		System.out.println("size selected");
		Thread.sleep(10000);
		Utils.waitForPageLoadLongTime();
		Utils.jsClick(ProductDetails_Page.Product.Product_AddToCart());
		System.out.println("Add to bag clicked");
		Utils.waitForPageLoadLongTime();
		Thread.sleep(3000);
		Cart_Page.cartIcon().click();
		System.out.println("clicked on view bag");
		Utils.waitForPageLoadLongTime();
		Thread.sleep(5000);
		Utils.waitForElementPresence2(Cart_Page.CheckoutButton());
		Utils.waitForPageLoadLongTime();
		Utils.jsClick(Cart_Page.CheckoutButton());
		Thread.sleep(10000);
		Utils.waitForPageLoadLongTime();
			}
		 catch (Exception ex) {
			throw new Exception("naviagte_Till_checkOut_page failed ");
		}

	}


	public static void Verify_Private_Cart_Page_FromYourWishList(int iTestCaseRow) throws Exception {
		Log.info("Verification for checking From Your Wishlist section on cart page started");
		try {

			if (!(Cart_Page.FromYourWishlistImages().size() > 0)) {
				BaseClass.errorValidation += "From your wishlist section is empty \n";
			}

		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void verify_StorePickup_BeforeEnteringPincode(int iTestCaseRow) throws Exception {
		try {
			if ((Cart_Page.expressStorePickup_Available().isDisplayed())) {
				Log.info("StorePickup is available for this product before entering pincode");
			}

		} catch (Exception e) {
			Log.error("StorePickup is not available for this product before entering pincode");
			throw e;
		}

	}

	public static void verify_StorePickup_With_InValid_Pincode(int iTestCaseRow) throws Exception {
		try {
			if ((Cart_Page.expressStorePickup_NotAvailable().isDisplayed())) {
				Log.info("StorePickup is not available for this product with this pincode selected");
			}

		} catch (Exception e) {
			Log.error("Exception in validating store pickup with invalid pincode");
			throw e;
		}
	}

	public static void verify_StorePickup_With_Valid_Pincode(int iTestCaseRow) throws Exception {
		try {

			if ((Cart_Page.expressStorePickup_Available().isDisplayed())) {
				Log.info("StorePickup is  available for this product after entering pincode");
//				if
//				((Constant.URL!="https://www.shoppersstop.com/")&&(Constant.URL!="https://uat.shopper-stop.in/")){
				Utils.verifyElement(Cart_Page.selectStore_Link());
				Cart_Page.selectStore_Link().click();
				Log.info("Select store link is clicked");
				Thread.sleep(3000);
				if (Cart_Page.pickup_PopupImage().isDisplayed()) {
					Log.info("Pickup product image is displayed");
					System.out.println("Pickup product image is displayed");
				}
				String prodAvail = Cart_Page.productAvailability_IN_Popup().getText();
				Log.info("Product available qty displayed in popup=" + prodAvail);

				String strDetails = Cart_Page.store_Details_IN_Popup().getText();
				Log.info("Pickup store details displayed in popup=" + strDetails);

				Utils.verifyElement(Cart_Page.popupClose_Btn());
				System.out.println("1");
				Utils.verifyElement(Cart_Page.changeStore_BtnInPopup());
				System.out.println("2");
				Cart_Page.changeStore_BtnInPopup().click();
				System.out.println("store is selected in popup");
				Log.info("store is selected in popup");
				Thread.sleep(3000);
				// }
				String strSel = Cart_Page.storeName().getText();
				Log.info("store selected in popup =" + strSel);
				String shpInfo = Cart_Page.shoppingInfo().getText();
				Log.info("message displayed under Shopping info =" + shpInfo);
			}

		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}
	}

	public static void verify_StorePickup_AfterEntering_Invalid_AND_Valid_Pincode(int iTestCaseRow) throws Exception {
		try {
			Cart_Page.PinCodeField().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.invalidPostCode));
			Utils.jsClick(Cart_Page.CheckPinCodeButton());
			Utils.waitForPageLoadLongTime();
			Thread.sleep(2000);
			verify_StorePickup_With_InValid_Pincode(iTestCaseRow);
		} catch (Exception e) {
			Log.error("Exception in Express storePickup field for Invalid Pincode ");
		}
		try {
			Utils.jsClick(Cart_Page.ChangePinCode());
			Utils.waitForPageLoadLongTime();
			Cart_Page.PinCodeField().clear();
			Cart_Page.PinCodeField().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.postCode));
			Cart_Page.CheckPinCodeButton().click();
			Thread.sleep(2000);
			////
			//verify_StorePickup_With_Valid_Pincode(iTestCaseRow);
			////
			// if((Constant.URL!="https://www.shoppersstop.com/")
			// &&(Constant.URL!="https://uat.shopper-stop.in/")){
			/////
			//changePincode_InSelectStorePopup(iTestCaseRow);
			/////
			// }
		} catch (Exception e) {
			Log.error("Exception in Express storePickup field for Valid Pincode ");
			throw e;
		}

	}

	public static void changePincode_InSelectStorePopup(int iTestCaseRow) throws Exception {
		try {
			if ((Cart_Page.expressStorePickup_Available().isDisplayed())) {
				Utils.verifyElement(Cart_Page.selectStore_Link());
				Cart_Page.selectStore_Link().click();
				Log.info("Select store link is clicked");
				Thread.sleep(2000);
				Utils.jsClick(Cart_Page.ChangePinCode());
				Thread.sleep(2000);

				Cart_Page.popup_Pincode().clear();
				Cart_Page.popup_Pincode().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.invalidPostCode));
				Utils.jsClick(Cart_Page.popup_Pincode_Check());
				if (Cart_Page.noStores_In_Popup().isDisplayed()) {
					Log.info("Stores are not available for the entered pincode");
					Utils.jsClick(Cart_Page.ChangePinCode());
					Cart_Page.popup_Pincode().clear();
					Cart_Page.popup_Pincode()
							.sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.alternativePostCode));
					Thread.sleep(2000);
					Utils.jsClick(Cart_Page.popup_Pincode_Check());
					Utils.verifyElement(Cart_Page.changeStore_BtnInPopup());
					Log.info("Stores available with the entered pincode");
					Cart_Page.changeStore_BtnInPopup().click();
					System.out.println("store is selected");
					Thread.sleep(5000);
					String strSel = Cart_Page.storeName().getText();
					Log.info("store selected in popup =" + strSel);
					System.out.println("store selected in popup =" + strSel);
					String shpInfo = Cart_Page.shoppingInfo().getText();
					Log.info("message displayed under Shopping info =" + shpInfo);
				}

			}
		} catch (Exception e) {
			Log.error("Exception in change pincode in Select store popup");
			throw e;
		}

	}

	public static void verify_Deli_Sec_AfterEntering_Pincode_CartPage(int iTestCaseRow) throws Exception {
		Thread.sleep(3000);
		try {
			if (Cart_Page.standardDelivery().isDisplayed()) {
				Log.info("Product is eligible for Standard Delivery");
			}
		} catch (Exception e) {
			Log.error("There is no COD Delivey option for this product");
		}
		Thread.sleep(3000);
		try {
			if (Cart_Page.codDelivery().isDisplayed()) {
				Log.info("Product is eligible for COD");
			}
		} catch (Exception e) {
			Log.error("There is no COD Delivey option for this product");
		}

	}

	public static void verifying_PincodePopulated_From_PDP_TO_CheckoutPage(int iTestCaseRow) throws Exception {
		try {
			PDP_Action.happyPathFlowTillPDPPage_With_AND_Without_Entering_Pincode(iTestCaseRow);
			Utils.waitForPageLoadLongTime();
			Thread.sleep(2000);
			Utils.jsClick(ProductDetails_Page.Product.Product_AddToCart());
			Utils.waitForPageLoadLongTime();
			Thread.sleep(2000);
			System.out.println("Add to bag clicked");
			Thread.sleep(3000);
			// Utils.verifyElement(MiniCart_Page.MiniCartProductDetails.MiniCartViewBag());
			// Utils.jsClick(MiniCart_Page.MiniCartProductDetails.MiniCartViewBag());
			// Minicart Functionality Removed
			Utils.waitForElementTOclick(Cart_Page.cartIcon());
			System.out.println("clicked on view bag");
			Utils.waitForPageLoadLongTime();
			Thread.sleep(6000);
			String pdpPincode = Cart_Page.pincode_Display().getText();
			if (pdpPincode.equals(ExcelUtils.getCellData(iTestCaseRow, Constant.postCode))) {
				Log.info("Pincode correctly populated from the PDP page");
			} else {
				throw new Exception("Pincode not populated correctly");
			}

			Utils.jsClick(Cart_Page.CheckoutButton());
			Utils.waitForPageLoadLongTime();
			Thread.sleep(5000);
			System.out.println("clicked on checkout buttton");
			Utils.jsClick(Checkout_Page.LoginDetails.ContinueAsGuest());
			Utils.waitForPageLoadLongTime();
			Thread.sleep(3000);
			System.out.println("clicked on ContinueAsGuest buttton");
			//String userEmail = ExcelUtils.getCellData(iTestCaseRow, Constant.emailId)+"aba@gmail.com";
			String userEmail = "aba"+ExcelUtils.getCellData(iTestCaseRow, Constant.emailId);
			Checkout_Page.LoginDetails.LoginEmailGuest().sendKeys(userEmail);
			String mobile = ExcelUtils.getCellData(iTestCaseRow, Constant.mobileNumber);
			Checkout_Page.LoginDetails.GuestMobileNumber().sendKeys(mobile);
			Log.info("User email id is entered successfully");
			Checkout_Page.LoginDetails.ContinueBtnGuest().click();
			Log.info("Continue button is clicked");
			System.out.println("Continue button is clicked");
			Utils.waitForElementPresence(Checkout_Page.GuestOTPPopup());
			Thread.sleep(2000);
			
		} catch (Exception e) {
			Log.error("Navigation Till Cart Page failed");
//			throw e;
		}

	}

	public static void verifying_PincodePopulated_From_PDP_TO_CartPage(int iTestCaseRow) throws Exception {
		try {
			PDP_Action.happyPathFlowTillPDPPage_With_AND_Without_Entering_Pincode(iTestCaseRow);
			Utils.waitForElementTOclick(ProductDetails_Page.Product.Product_AddToCart());
			Utils.waitForPageLoadLongTime();
			Thread.sleep(3000);
			// Utils.verifyElement(MiniCart_Page.MiniCartProductDetails.MiniCartViewBag());
			// Utils.jsClick(MiniCart_Page.MiniCartProductDetails.MiniCartViewBag());
			// Minicart Functionality Removed
			Utils.waitForElementTOclick(Cart_Page.cartIcon());
			Utils.waitForPageLoadLongTime();
			Thread.sleep(3000);
		} catch (Exception e) {
			Log.error("Navigation from PDP to cart Page failed");
			throw e;
		}
		String pincode = Cart_Page.pincode_Display().getAttribute("innerText");
		if (pincode.equals(ExcelUtils.getCellData(iTestCaseRow, Constant.postCode))) {
			Log.info("Pincode correctly populated from the PDP page");
		} else {
			throw new Exception("Pincode not populated correctly");
		}

	}

	public static void Navigate_Back_To_PDP_FromCartPage_AND_Change_Pincode(int iTestCaseRow) throws Exception {
		try {
			Thread.sleep(2000);
			Cart_Page.product_ImageLink().click();
			Utils.waitForPageLoadLongTime();
			Log.info("Navigated back to PDP page");
			Thread.sleep(3000);
			Utils.scrollingToPageElementByCordinate(0, 150);
			Utils.jsClick(ProductDetails_Page.Product.ChangePinBtn());
			Utils.waitForPageLoadLongTime();
			ProductDetails_Page.Product.PinCode().clear();
			ProductDetails_Page.Product.PinCode()
					.sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.alternativePostCode));
			Log.info("Entered alternative pincode");
			ProductDetails_Page.Product.PinCodeCheckBtn().click();
//		       MiniCart_Page.QtyMiniCart().click();
//		       Utils.waitForElementTOclick(ProductDetails_Page.Product.Product_AddToCart());
//		       Utils.verifyElement(MiniCart_Page.MiniCartProductDetails.MiniCartViewBag());
//		       Utils.jsClick(MiniCart_Page.MiniCartProductDetails.MiniCartViewBag());
			// Minicart Functionality Removed
			Utils.waitForElementTOclick(Cart_Page.cartIcon());
			Log.info("Navigated to cart page");
			Thread.sleep(5000);
		} catch (Exception e) {
			Log.error("There is no Delivey option for this product");
			throw e;
		}
		String pincode = Cart_Page.pincode_Display().getText();
		if (pincode.equals(ExcelUtils.getCellData(iTestCaseRow, Constant.alternativePostCode))) {
			Log.info("Changed Pincode correctly populated from the PDP page");
		} else {
			throw new Exception("Changed Pincode not populated correctly");
		}

	}

	public static void verify_SelectedStore_INcartPage_Displayed_In_CheckoutPage(int iTestCaseRow) throws Exception {
		try {

			Cart_Action.selecting_Store_CartPage_IN_Popup(iTestCaseRow);
			Utils.jsClick(Cart_Page.CheckoutButton());
			Utils.waitForPageLoadLongTime();
			/*
			 * Utils.jsClick(Checkout_Page.LoginDetails.ContinueAsGuest());
			 * Thread.sleep(5000); String userEmail = ExcelUtils.getCellData(iTestCaseRow,
			 * Constant.emailId);
			 * Checkout_Page.LoginDetails.LoginEmailGuest().sendKeys(userEmail); String
			 * mobile = ExcelUtils.getCellData(iTestCaseRow, Constant.mobileNumber);
			 * Checkout_Page.LoginDetails.GuestMobileNumber().sendKeys(mobile);
			 * Log.info("User email id is entered successfully");
			 * Utils.jsClick(Checkout_Page.LoginDetails.ContinueBtnGuest());
			 * Log.info("Continue button is clicked");
			 * System.out.println("Continue button is clicked");
			 */ Thread.sleep(7000);
			Utils.jsClick(Checkout_Page.expressStorePickupTab());
			Utils.waitForPageLoadLongTime();
			System.out.println("expressStorePickupTab is clicked");
			Thread.sleep(8000);
			System.out.println("storeid=" + strSel);
//				Utils.CheckEnability(Checkout_Page.storeName());
//				System.out.println((Checkout_Page.storeName().getAttribute("innerText")));
			if ((Checkout_Page.storeName().getAttribute("innerText")).equals(strSel)) {
				System.out.println("Store selected in Cart page is populated in Address page");
				Log.info("Store selected in Cart page is populated in Address page");
			} else {
				throw new Exception("Store selected in Cart page is not populated correctly in Address page");
			}
		}

		catch (Exception e) {
			System.out.println(e);
			System.out.println("Navigation Till Cart Page failed");
			throw e;
		}

	}

	public static void selecting_Store_CartPage_IN_Popup(int iTestCaseRow) throws Exception {
		try {
			if ((Cart_Page.expressStorePickup_Available().isDisplayed())) {
				// if((Constant.URL!="https://www.shoppersstop.com/")&&(Constant.URL!="https://uat.shopper-stop.in/")){
				Utils.verifyElement(Cart_Page.selectStore_Link());
				Cart_Page.selectStore_Link().click();
				Log.info("Select store link is clicked");
				Thread.sleep(2000);
				Utils.verifyElement(Cart_Page.changeStore_BtnInPopup());
				Log.info("Stores available with the entered pincode");
				Cart_Page.changeStore_BtnInPopup().click();
				Log.info("store is selected");
				// }
				Thread.sleep(3000);
				strSel = Cart_Page.storeName().getText();
				Log.info("store selected in popup =" + strSel);
				System.out.println("store selected in popup =" + strSel);
			}

		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}

	}

	public static void HappyPathFlowTillCartPage(int iTestCaseRow) throws Exception {
		HomePage_Action.selectProductCategoryfromSearch(iTestCaseRow);
		Utils.jsClick(ProductDetails_Page.Product.Product_AddToCart());
		Thread.sleep(3000);
		Utils.verifyElement(MiniCart_Page.MiniCartProductDetails.MiniCartViewBag());
		Utils.jsClick(MiniCart_Page.MiniCartProductDetails.MiniCartViewBag());
		Thread.sleep(3000);
	}

	public static void Verify_CartPage_FromYourWishlist_Functionality(int iTestCaseRow) throws Exception {
		try {
			
			HomePage_Action.searchForTheProduct(iTestCaseRow);
			Home_Page.result_Product().click();
			Utils.waitForPageLoadLongTime();
			Thread.sleep(2000);
			PDP_Action.product_selectSize(ProductDetails_Page.Product.size_variant_buttonlist());
			Utils.waitForPageLoadLongTime();
			Thread.sleep(2000);
			//Utils.jsClick(ProductDetails_Page.Product.Product_AddToCart());
			Utils.waitForPageLoadLongTime();
			Thread.sleep(2000);
			Home_Page.wishListicon().click();
			Log.info("clciked on the wishlist icon on product");
			Utils.waitForPageLoadLongTime();
			Thread.sleep(2000);
			Utils.jsClick(Home_Page.headerWishlistIcon());
			Log.info("clicked on wish list link on home page");
			Utils.waitForPageLoadLongTime();
			Thread.sleep(4000);
//			Utils.waitForElementTOclick(Home_Page.MoveToBag());
//			Thread.sleep(1000);
//			Utils.jsClick(Home_Page.selectSize().get(0));
//			Thread.sleep(1000);
//			Home_Page.done().click();
//			Log.info("clicked on move to bag and product moved to cart ");
			
			Utils.waitForPageLoadLongTime();
		//	Thread.sleep(2000);
			
			Utils.jsClick(Cart_Page.cartIcon());
			Log.info("my bag icon has been clicked ");
			Utils.waitForPageLoadLongTime();
			Thread.sleep(3000);
			String tetx = Cart_Page.wishlistItems().getText();
			Log.info(tetx + " has been dispayed in my bag");
			System.out.println(tetx + " has been dispayed in my bag");
					

		} catch (Exception e) {
			Log.error("verification of wish failed | method Private_Verify_CartPage_FromYourWishlist_Functionality");
			Log.error(e.getMessage());
			throw e;
		}

	}
}