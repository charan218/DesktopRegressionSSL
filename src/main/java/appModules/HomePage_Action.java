package appModules;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import pageObjects.BaseClass;
import pageObjects.Cart_Page;
import pageObjects.Footer_Page;
import pageObjects.Home_Page;
import pageObjects.MiniCart_Page;
import pageObjects.ProductDetails_Page;
import pageObjects.ProductListing_Page;
import pageObjects.Static_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;

public class HomePage_Action extends BaseClass {

	public HomePage_Action(WebDriver Driver) {
		super(Driver);
		// TODO Auto-generated constructor stub
	}

	public static void HomePage_Verify_Menu_Category_Links(int iTestCaseRow) throws Exception {
		String title = null;

		for (int i = 0; i < Static_Page.MainMenuBarTitle().size(); i++) {
			title = Static_Page.MainMenuBarTitle().get(i).getAttribute("title").toString();
			if (!(Static_Page.SubMenuCategory(title).size() > 0)) {
				BaseClass.errorValidation += "No Sub Menu Categaries found for - " + title + " - Categary. \n";
			}
			if (!(Static_Page.SubMenuLinks(title).size() > 0)) {
				Log.info("No product link found under sub menu categaries");
			}
		}

		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class HomePage_Action | Method HomePage_Verify_Menu_Category_Links");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void Header_Public_Verify_SearchBox_Field_functionality(int iTestCaseRow) throws Exception {

		try {
			Log.info("Verification for Header Search box field functionality");
			Home_Page.Search_Box().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.searchField));
			Log.info("Product name entered in search box");
			Thread.sleep(3000);

			try {
				if (Home_Page.MaroonText().isEmpty()) {
					BaseClass.errorValidation += "Text not present in maroon color on page. \n";
				}
			} catch (Exception e) {
				Log.error("Exception in Class Cart_Action | Method Header_Public_Verify_SearchBox_Field_functionality");
				Log.error(e.getMessage());
				throw e;
			}

			Home_Page.Search_Box().clear();
			Thread.sleep(1000);
			Home_Page.Search_Box().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.description));
			Log.info("Product name entered in search box");
			Thread.sleep(1000);
		} catch (Exception e) {
			Log.error(
					"Exception in Class Home_Page_Action | Method Header_Public_Verify_SearchBox_Field_functionality");
			Log.error("Verification check Failed for Header Search box field functionality");
			throw (e);

		}

	}

	public static void HomePage_Click_On_All_Bannerlinks(List<WebElement> list, int OR) throws Exception {
		try {
			int size = list.size();
			System.out.println(size);
			for (int i = 0; i < list.size(); i++) {
				if (OR == 1) {
					Utils.ClickElementIfDisplayed(Home_Page.collegeEdit().get(i));
				} else if (OR == 2) {
					Utils.ClickElementIfDisplayed(Home_Page.NewArrivals().get(i));
				} else if (OR == 3) {
					Utils.ClickElementIfDisplayed(Home_Page.FavBanner().get(i));
				} else if (OR == 4) {
					Utils.ClickElementIfDisplayed(Home_Page.StyleHub().get(i));

				} else if (OR == 5) {
					Utils.ClickElementIfDisplayed(Home_Page.OfferZone().get(i));
				} else {
					System.out.println("No Banners Available on HomePage. Please check selenium locators");
					BaseClass.bResult = false;
				}
			}
		} catch (Exception e) {
		}
	}

	public static void HomePage_Verify_MainMenu_ToolTip1(int iTestCaseRow) throws Exception {
		try {
			String title = null;
			boolean menuFound;
			boolean elementFound;
			List<String> maimMenutestData = Utils
					.csvDataReader(ExcelUtils.getCellData(iTestCaseRow, Constant.productCategory));
			List<String> pageTitle = Utils.csvDataReader(ExcelUtils.getCellData(iTestCaseRow, Constant.title));

			for (int i = 0; i < maimMenutestData.size(); i++) {
				menuFound = false;
				for (int j = 0; j < Static_Page.MainMenuBarTitle().size(); j++) {
					title = Static_Page.MainMenuBarText(j + 1).getAttribute("title").toString();
					if (maimMenutestData.get(i).equalsIgnoreCase(title)) {
						System.out.println(maimMenutestData.get(i) + " category is present");
						menuFound = true;
						Utils.jsClick(Static_Page.MainMenuBarText(j + 1));
						elementFound = false;
						for (int k = 0; k < pageTitle.size(); k++) {
							if (Utils.getPageTitle().equalsIgnoreCase(pageTitle.get(k))) {
								elementFound = true;
								System.out.println(
										"Page title is same as expected and expected is : " + Utils.getPageTitle());
								break;
							}
						}
						if (!elementFound) {
							System.out.println("Actual Page Title is : " + pageTitle.get(i));
							System.out.println("Page title is not same as expected and actual Page Title is : "
									+ Utils.getPageTitle());
						}
						Utils.driverNavigation("backward");
						Thread.sleep(5000);
					}
				}
				if (!menuFound) {
					System.out.println(maimMenutestData.get(i) + " category is not present");
					BaseClass.errorValidation += "Tool Tip for - " + title
							+ " - does not match with expected values. \n";
				}
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}
	}

	public static void HomePage_Verify_MainMenu_ToolTip(int iTestCaseRow) throws Exception {
		String title = null;
		List<String> maimMenutestData = Utils
				.csvDataReader(ExcelUtils.getCellData(iTestCaseRow, Constant.productCategory));
		System.out.println(Static_Page.MainMenuBarTitle().size());
		System.out.println(maimMenutestData.size());
		try {
			for (int i = 0; i < Static_Page.MainMenuBarTitle().size(); i++) {
				title = Static_Page.MainMenuBarText(i + 1).getAttribute("title").toString();
				System.out.println(Static_Page.MainMenuBarText(i + 1).getAttribute("title").toString());
				if (!(title.equalsIgnoreCase(maimMenutestData.get(i)))) {
					BaseClass.errorValidation += "Tool Tip for - " + title
							+ " - does not match with expected values. \n";
				} else {
					Log.info("Tool Tip for - " + title + " - match with expected values.");
				}
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}
		try {
			List<String> pageTitle = Utils.csvDataReader(ExcelUtils.getCellData(iTestCaseRow, Constant.title));
			for (int i = 0; i < Static_Page.MainMenuBarTitle().size(); i++) {
				Utils.jsClick(Static_Page.MainMenuBarText(i + 1));
				Thread.sleep(4000);
				// System.out.println(Utils.getPageTitle());
				if (!Utils.getPageTitle().startsWith(pageTitle.get(i))) {
					BaseClass.bResult = false;
					System.out.println("Actual Page Title is : " + pageTitle.get(i));
					System.out.println(
							"Page title is not same as expected and actual Page Title is : " + Utils.getPageTitle());
				} else {
					System.out.println("Page title is same as expected and expected is : " + Utils.getPageTitle());
					Log.info("Page title is same as expected and expected is : " + Utils.getPageTitle());
				}
				Utils.driverNavigation("backward");
				Thread.sleep(2000);

			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}

		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class HomePage_Action | Method HomePage_Verify_MainMenu_ToolTip");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void HomePage_Verify_L2Menu_ToolTip(int iTestCaseRow) throws Exception {
		String title = null;
		List<String> testData = Utils.csvDataReader(ExcelUtils.getCellData(iTestCaseRow, Constant.L2categories));
		System.out.println(Static_Page.subMenuBarTittle().size());
		System.out.println(testData.size());

		try {

			List<String> pageTitle = Utils
					.csvDataReader(ExcelUtils.getCellData(iTestCaseRow, Constant.L2categorypages));

			for (int i = 0; i < Static_Page.subMenuBarTittle().size(); i++) {
				Utils.mouseHover(Static_Page.MainMenuBarText(1));
				Static_Page.subMenuBarText(i + 1).click();
				Thread.sleep(1000);
				// System.out.println(Utils.getPageTitle());
				if (!Utils.getPageTitle().startsWith(pageTitle.get(i))) {
					BaseClass.bResult = false;
					System.out.println("Actual Page Title is : " + pageTitle.get(i));
					System.out.println(
							"Page title is not same as expected and actual Page Title is : " + Utils.getPageTitle());
				} else {
					System.out.println("Page title is same as expected and expected is : " + Utils.getPageTitle());
					Log.info("Page title is same as expected and expected is : " + Utils.getPageTitle());
				}
				Utils.driverNavigation("backward");
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}
	}

	public static void HomePage_Verify_Header_Banner_Footer_Containers(int iTestCaseRow) throws Exception {

		try {
			Log.info("Verification for Header Container");
			Utils.verifyElement(Static_Page.HeaderContainer());
			Log.info("Verification check has been completed for Header Container");

		} catch (Exception e) {

			Log.error("Verification check Failed for Header Container");
			BaseClass.errorValidation = BaseClass.errorValidation
					+ "The Header container is not present on Home Page \n";

		}
		try {
			Log.info("Verification for Main Slider Container");
			Utils.verifyElement(Static_Page.MainSlider());
			Log.info("Verification check has been completed for Main Slider Container");

		} catch (Exception e) {

			Log.error("Verification check Failed for Main Slider Container");
			BaseClass.errorValidation = BaseClass.errorValidation
					+ "The Main Slider container is not present on Home Page \n";

		}
		/*
		 * try { Log.info("Verification for Shipping Container");
		 * Utils.verifyElement(Static_Page.ShippingContainer());
		 * Log.info("Verification check has been completed for Shipping Container");
		 * 
		 * } catch (Exception e) {
		 * 
		 * Log.error("Verification check Failed for Shipping Container");
		 * BaseClass.errorValidation = BaseClass.errorValidation +
		 * "The Shipping container is not present on Home Page \n";
		 * 
		 * }
		 */
		try {
			Log.info("Verification for Style Inspiration Container");
			Utils.verifyElement(Static_Page.StyleInspirationContainer());
			Log.info("Verification check has been completed for Style Inspiration Container");

		} catch (Exception e) {

			Log.error("Verification check Failed for Style Inspiration Container");
			BaseClass.errorValidation = BaseClass.errorValidation
					+ "The Style Inspiration container is not present on Home Page \n";

		}
		/*
		 * try { Log.info("Verification for latest from Shoppers Stop Container");
		 * Utils.verifyElement(Static_Page.latestContainer()); Log.
		 * info("Verification check has been completed for latest from Shoppers Stop Container"
		 * );
		 * 
		 * } catch (Exception e) {
		 * 
		 * Log.error("Verification check Failed for Latest from Shoppers Stop Container"
		 * ); BaseClass.errorValidation = BaseClass.errorValidation +
		 * "The Latest from Shoppers Stop container is not present on Home Page \n";
		 * 
		 * }
		 */
		try {
			Log.info("Verification for New Arrival Container");
			Utils.verifyElement(Static_Page.NewArrivalsContainer());
			Log.info("Verification check has been completed for New-Arrival Container");

		} catch (Exception e) {

			Log.error("Verification check Failed for New Arrival Container");
			BaseClass.errorValidation = BaseClass.errorValidation
					+ "The New Arrival container is not present on Home Page \n";

		}
		try {
			Log.info("Verification for Offer Zone Container");
			Utils.verifyElement(Static_Page.OfferZoneContainer());
			Log.info("Verification check has been completed for Offer Zone Container");

		} catch (Exception e) {

			Log.error("Verification check Failed for Offer Zone Container");
			BaseClass.errorValidation = BaseClass.errorValidation
					+ "The Offer Zone container is not present on Home Page \n";

		}
		try {
			Log.info("Verification for Brands Container");
			Utils.verifyElement(Static_Page.BrandsContainer());
			Log.info("Verification check has been completed for Brands Container");

		} catch (Exception e) {

			Log.error("Verification check Failed for Brands Container");
			BaseClass.errorValidation = BaseClass.errorValidation
					+ "The Brands container is not present on Home Page \n";

		}
		try {
			Log.info("Verification for Favourites Container");
			Utils.verifyElement(Static_Page.FavouritesContainer());
			Log.info("Verification check has been completed for Favourites Container");

		} catch (Exception e) {

			Log.error("Verification check Failed for Favourites Container");
			BaseClass.errorValidation = BaseClass.errorValidation
					+ "The Favourites container is not present on Home Page \n";

		}
		try {
			Log.info("Verification for Social Hub Container");
			Utils.verifyElement(Static_Page.SocialHubContainer());
			Log.info("Verification check has been completed for Social Hub Container");

		} catch (Exception e) {

			Log.error("Verification check Failed for Social Hub Container");
			BaseClass.errorValidation = BaseClass.errorValidation
					+ "The Social Hub container is not present on Home Page \n";

		}
		try {
			Log.info("Verification for Footer Container");
			Utils.verifyElement(Static_Page.FooterContainer());
			Log.info("Verification check has been completed for Footer Container");

		} catch (Exception e) {

			Log.error("Verification check Failed for Footer Container");
			BaseClass.errorValidation = BaseClass.errorValidation
					+ "The Footer container is not present on Home Page \n";

		}

		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class HomePage_Action | Method HomePage_Verify_Header_Banner_Footer_Containers");
			throw new Exception(BaseClass.errorValidation);
		}

	}

	public static void HomePage_Verify_NewsLetterSubscribe_Field(int iTestCaseRowiTestCaseRow) throws Exception {
		try {
			Log.info("Verification for NewsLetter Subscribe Email Field");
			Utils.verifyElement(Static_Page.NewsletterEmail());
		} catch (Exception e) {

			Log.error("Verification check Failed for NewsLetter Subscribe Email Field");
			BaseClass.errorValidation += "NewsLetter Subscribe Email Field not present in Home Page \n";

		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class HomePage_Action | Method HomePage_Verify_NewsLetterSubscribe_Field");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void HomePage_Verify_NewsLetterSubscribe_Functionality(int iTestCaseRow) throws Exception {
		// Utils.scrollingToPageElementByCordinate(0, 6364);
		// Home_Page.NewsletterEmail().click();
		try {

			Log.info("Verification for NewsLetter Subscribe Email Functionality for Empty field");
			Utils.scrollingToPageBottom(Home_Page.NewsLetterButton());
			Utils.waitForElementTOclick(Home_Page.NewsLetterButton());
			Home_Page.NewsLetterButton().sendKeys(Keys.ENTER);
			Utils.waitForElementPresence2(Home_Page.NewsLetterAlert());
			Utils.performAssertEquals(Home_Page.NewsLetterAlert(),
					ExcelUtils.getCellData(iTestCaseRow, Constant.message1));
		} catch (Exception e) {
			Log.error("Verification check Failed for NewsLetter Subscribe Email Field for Empty field");
			BaseClass.errorValidation += "Verification for NewsLetter Subscribe Email Functionality for Empty field failed\n";
		}
		try {
			Log.info("Verification for NewsLetter Subscribe Email Functionality for invalid mail address");
			Home_Page.NewsletterEmail().clear();
			Home_Page.NewsletterEmail().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.invalidEmailId));
			// Thread.sleep(10000);
			// Utils.scrollingToPageElementByCordinate(1275, 5500);
			Utils.mouseHover(Home_Page.NewsLetterButton());
			Home_Page.NewsLetterButton().sendKeys(Keys.ENTER);
			Utils.waitForElementPresence2(Home_Page.NewsLetterAlert());
			Utils.performAssertEquals(Home_Page.NewsLetterAlert(),
					ExcelUtils.getCellData(iTestCaseRow, Constant.message2));
		} catch (Exception e) {

			Log.error("Verification check Failed for NewsLetter Subscribe Email Field for invalid email address");
			BaseClass.errorValidation += "Verification for NewsLetter Subscribe Email Functionality for invalid mail address failed\n";

		}
		try {
			Log.info("Verification for NewsLetter Subscribe Email Functionality for Valid email address");
			Home_Page.NewsletterEmail().clear();
			Home_Page.NewsletterEmail().sendKeys(Utils.generateRandomEmail(ExcelUtils.getCellData(iTestCaseRow, Constant.emailId)));
			Utils.mouseHover(Home_Page.NewsLetterButton());
			Home_Page.NewsLetterButton().sendKeys(Keys.ENTER);
			Utils.waitForElementPresence2(Home_Page.NewsLetterAlert());
			Utils.performAssertEquals(Home_Page.NewsLetterAlert(),
					ExcelUtils.getCellData(iTestCaseRow, Constant.message3));
		} catch (Exception e) {

			Log.error("Verification check Failed for NewsLetter Subscribe Email Field for Valid email address");
			BaseClass.errorValidation += "Verification for NewsLetter Subscribe Email Functionality for Valid email address failed\n";

		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class HomePage_Action | Method HomePage_Verify_NewsLetterSubscribe_Functionality");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void Header_Public_Verify_StoreLocator_Link_Functionality(int iTestCaseRow) throws Exception {
		try {
			Log.info("Verification for Header store locator icon");
			Utils.verifyElement(Home_Page.headerStoreLocatorIcon());
		} catch (Exception e) {

			Log.error("Verification check Failed for store locator icon in Header");
			BaseClass.errorValidation += "Store locator icon not present in Header \n";

		}

		try {
			Log.info("Verification for store locator icon functionality in Header");
			Home_Page.headerStoreLocatorIcon().click();
			Log.info("Store locator icon clicked successfully");
			Utils.NewWindowPageHeaderValidation("StoreFinder | Shoppers Stop");
			Log.info("Verification check done for store locator icon functionality");
		} catch (Exception e) {

			Log.error("Verification check Failed for store locator icon functionality");

		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error(
					"Exception in Class HomePage_Action | Method Header_Public_Verify_StoreLocator_Link_Functionality");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void Header_Public_Verify_StoreLocator_Page_Functionality(int iTestCaseRow) throws Exception {
		try {
			Log.info("Verification for store locator icon page functionality in Header");
			Home_Page.headerStoreLocatorIcon().click();
			Log.info("Store locator icon clicked successfully");

			Static_Page.StoreLocator_SelectCity().selectByValue(ExcelUtils.getCellData(iTestCaseRow, Constant.city));
			Log.info("Store City name entered successfully");
			Thread.sleep(2000);
			//Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.browser));
			Select storeName = Static_Page.StoreLocator_SelectStore();
			if (storeName.getOptions().isEmpty()) {
				BaseClass.errorValidation += "The store name list is empty for selcted city\n";
			}
			storeName.selectByIndex(1);
			Log.info("Verification check done for store locator page functionality");
			System.out.println("Validating presence of Address on store locator page");
			Thread.sleep(1000);
			Utils.CheckEnability(Static_Page.StoreLocator_StoreAddress());
			Utils.verifyElement(Static_Page.StoreLocator_StoreAddress());
			System.out.println("1");
			Home_Page.headerSoppersStopLogo().click();
			System.out.println("logo clicked");
		} catch (Exception e) {
			BaseClass.errorValidation += "Error in Store Locator Page Functionality in HomePage";
			Log.error(
					"Exception in Class HomePage_Action | Method Header_Public_Verify_StoreLocator_Page_Functionality");
			Log.error("Verification check Failed for store locator icon functionality");
			throw e;
		}

	}

	public static void stickyHeader_Validation(int iTestCaseRow) throws Exception {
		try {
			Utils.scrollingToPageBottom(Footer_Page.expressStorepick());
			//Utils.scrollingToPageBottom(Static_Page.FooterContainer());
			Utils.verifyElement(Static_Page.shopByCat());
			Log.info("Shop by category is displayed on header when page scrolled");
			Utils.mouseHoverElement(Static_Page.shopByCat());
			Utils.verifyElement(Static_Page.shopByCatDEtails());
			Log.info("Shop by category details displayed on mouse overing ShopByCategory");
		} catch (Exception e) {
			Log.error("Exception in Class HomePage_Action | Method stickyHeader_Validation");
			Log.error("Verification check Failed for stickyHeader_Validation");
			throw e;
		}
	}

	public static void Header_Public_Verify_TrackOrder_Page_Functionality(int iTestCaseRow) throws Exception {
		try {
			Log.info("Verification for Track Order icon page functionality in Header");
			Home_Page.headerTrackOrder().click();
			Log.info("Track Order icon clicked successfully");
			Utils.verifyElement(Static_Page.TrackOrder.TrackOrder_Email_Id());
			Utils.verifyElement(Static_Page.TrackOrder.Order_Number());
			Utils.verifyElement(Static_Page.TrackOrder.Submit_Button());
			Log.info("Verification check done for Track Order icon page functionality");

		} catch (Exception e) {
			BaseClass.errorValidation = "Error in Track Order Page Functionality \n";
			Log.error("Exception in Class HomePage_Action | Method Header_Public_Verify_TrackOrder_Page_Functionality");
			Log.error("Verification check Failed for Track Order icon page functionality");
			throw e;
		}
	}

	public static void SS_Header_Public_Verify_TrackOrder_Link_Functionality(int iTestCaseRow) throws Exception {
		try {
			Log.info("Verification for Header track order icon");
			Utils.verifyElement(Home_Page.headerTrackOrder());
			Log.info("Verification check has been completed for header track order icon");

		} catch (Exception e) {

			Log.error("Verification check Failed for header track order icon");
			BaseClass.errorValidation = BaseClass.errorValidation + "The header track order icon is not present";
			// throw (e);

		}
		try {
			Log.info("Verification for Track Order icon functionality in Header");
			Home_Page.headerTrackOrder().click();
			Log.info("Track Order icon clicked successfully");
			Utils.NewWindowPageHeaderValidation("Shoppers Stop");
			Log.info("Verification check done for Track Order icon functionality");

		} catch (Exception e) {

			Log.error("Verification check Failed for Track Order icon functionality");
			// throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error(
					"Exception in Class HomePage_Action | Method SS_Header_Public_Verify_TrackOrder_Link_Functionality");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void Header_Public_Verify_headerInfoBar_Functionality(int iTestCaseRow) throws Exception {
		try {
			Log.info("Verification for Header Shoppers Stop logo");
			Utils.verifyElement(Home_Page.headerInfoBar());
			Log.info("Verification check has been completed for Header Shoppers Stop logo");

		} catch (Exception e) {

			Log.error("Verification check Failed for Header Shoppers Stop logo");
			BaseClass.errorValidation = BaseClass.errorValidation + "The Header Shoppers Stop logo is not present";
			// throw (e);
		}
	}

	public static void Header_Public_Verify_SSL_Logo_Functionality(int iTestCaseRow) throws Exception {
		try {
			Log.info("Verification for Header Shoppers Stop logo");
			Utils.verifyElement(Home_Page.headerSoppersStopLogo());
			Log.info("Verification check has been completed for Header Shoppers Stop logo");

		} catch (Exception e) {

			Log.error("Verification check Failed for Header Shoppers Stop logo");
			BaseClass.errorValidation = BaseClass.errorValidation + "The Header Shoppers Stop logo is not present";
			// throw (e);

		}
		try {
			Log.info("Navigation store locator icon page in Header");
			Home_Page.headerStoreLocatorIcon().click();
			Log.info("Store locator icon clicked successfully");
		} catch (Exception e) {
			Log.error("Verification check Failed for SSL functionality");
			BaseClass.errorValidation = BaseClass.errorValidation + "Clicking Store Locator failed";
		}
		try {
			Log.info("Verification for SSL icon functionality in Header");
			Home_Page.headerSoppersStopLogo().click();
			Log.info("SSL clicked successfully");
			Utils.waitForLoad("Firefox");
			Utils.PageHeaderCheck("Online Shopping India - Shop for clothes, shoes, Bags, watches @ Shoppersstop.com");
			Log.info("Verification check done for SSL functionality");

		} catch (Exception e) {

			Log.error("Verification check Failed for SSL functionality");
			BaseClass.errorValidation = BaseClass.errorValidation + "The Header Shoppers Stop logo is not present";
			// throw e;
		}

	}

	public static void Header_Public_Verify_Wishlist_Functionality(int iTestCaseRow) throws Exception {
		try {
			Log.info("Verification for Wishlist icon functionality in Header");
			Utils.mouseHover(Home_Page.headerWishlistIcon());
			Log.info("Wishlist icon hovered successfully");
			Thread.sleep(1000);
			System.out.println(Home_Page.headerWishlistMenuHeading().getText());
			if (Home_Page.headerWishlistMenuHeading().getText().equalsIgnoreCase("Your Saved Items Are Empty")) {
				Log.info("Expected value match with Actual value");
			} else {
				Log.info("Expected value Not matched with Actual value");
			}
//			Utils.performAssertEquals(Home_Page.headerWishlistMenuHeading(), "Your Saved Items Are Empty");
			Thread.sleep(1000);
			System.out.println(Home_Page.headerWishlistMenuText().getText());
			if (Home_Page.headerWishlistMenuText().getText()
					.equalsIgnoreCase("Please LOGIN or REGISTER to add products")) {
				Log.info("Expected value match with Actual value");
			} else {
				Log.info("Expected value Not matched with Actual value");
			}
			// Utils.performAssertEquals(Home_Page.headerWishlistMenuText(), "Please LOGIN
			// or REGISTER to add products");

			Log.info("Verification check done for Wishlist Alert functionality");

		} catch (Exception e) {

			Log.error("Verification check Failed for Wishlist Alert functionality");
			// throw e;
		}

	}

	public static void Header_Private_Verify_Wishlist_Functionality(int iTestCaseRow) throws Exception {
		try {
			Log.info("Verification for Wishlist icon functionality in Header");
			Utils.mouseHover(Home_Page.headerWishlistIcon());
			Log.info("Wishlist icon hovered successfully");
			if (!Home_Page.headerWishlistUserMenu().getSize().equals(0)) {
				// This Test Case verify if a registered user has added any item in wishlist
				// previously ,He should be able to see those items and images
				System.out.println(
						"Total items in wishlist already added : " + Home_Page.headerWishlistUserMenu().getSize());
				Log.info("Verification check done for User specific Wishlist ");
			} else {
				BaseClass.errorValidation += "Wishlist image does not exist \n";
			}
			Log.info("Verification check done for Wishlist functionality for logged in User");

		} catch (Exception e) {

			Log.error("Verification check Failed for Wishlist Alert functionality");
			Log.error("Exception in Class HomePage_Action | Method Header_Private_Verify_Wishlist_Functionality");
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class HomePage_Action | Method Header_Private_Verify_Wishlist_Functionality");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void Header_Public_Verify_Wishlist_Link(int iTestCaseRow) throws Exception {
		try {
			Log.info("Verification for Header Wishlist Icon");
			Utils.verifyElement(Home_Page.headerWishlistIcon());
			Log.info("Verification check has been completed for Header Wishlist Icon");

		} catch (Exception e) {
			Log.error("Exception in Class HomePage_Action | Method Header_Public_Verify_Wishlist_Link");
			Log.error("Verification check Failed for Header Wishlist Icon");
			throw (e);

		}

	}

	public static void Header_Public_Verify_Notification_Alert_Functionality(int iTestCaseRow) throws Exception {
		try {
			Log.info("Verification for Notification icon functionality in Header");
			Utils.mouseHover(Home_Page.headerNotificationIcon());
			Log.info("Notification icon hovered successfully");
			System.out.println(Home_Page.headerNotificationAlert().getText());
			Utils.performAssertEquals(Home_Page.headerNotificationAlert(), "No Alerts Available");
			Home_Page.headerSoppersStopLogo().click();
			Log.info("Verification check done for Notification Alert functionality");

		} catch (Exception e) {
			Log.error(
					"Exception in Class HomePage_Action | Method Header_Public_Verify_Notification_Alert_Functionality");
			Log.error("Verification check Failed for Notification Alert functionality");
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error(
					"Exception in Class HomePage_Action | Method Header_Public_Verify_Notification_Alert_Functionality");
			Log.error("Verification check Failed for Notification Alert functionality");
			throw new Exception(BaseClass.errorValidation);
		}

	}

	public static void Header_Public_Verify_Notification_Alert_Link(int iTestCaseRow) throws Exception {
		try {
			Log.info("Verification for Header Notification Icon");
			Utils.verifyElement(Home_Page.headerNotificationIcon());
			Log.info("Verification check has been completed for Header Notification Icon");

		} catch (Exception e) {
			Log.error("Exception in Class HomePage_Action | Method Header_Public_Verify_Notification_Alert_Link");
			Log.info("Verification check Failed for Header Notification Icon");
			throw (e);

		}

	}

	public static void Header_Public_Verify_Minicart_Functionality(int iTestCaseRow) throws Exception {
		try {

			Log.info("Verification for Header Minicart Icon");

			Utils.verifyElement(Home_Page.headerMiniCartIcon());
			Log.info("Verification check has been completed for Header Minicart Icon");

			Log.info("Verification for Mini Cart icon functionality in Header");
			Home_Page.headerMiniCartIcon().click();
			Thread.sleep(3000);
			System.out.println(Utils.getPageTitle());
			Log.info("Mini Cart icon clicked successfully");
			Utils.waitForPageLoad();
			Utils.PageHeaderCheck("Your Shopping Bag | Shoppers Stop");
			Log.info("Verification check done for Mini Cart icon functionality");
			Thread.sleep(3000);
			Utils.waitForElementTOclick(Home_Page.miniCartSSlogo());
			Thread.sleep(3000);

		} catch (Exception e) {
			Log.error("Exception in Class HomePage_Action | Method Header_Public_Verify_Minicart_Functionality");
			Log.error("Verification check Failed for Mini Cart icon functionality");
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class HomePage_Action | Method Header_Public_Verify_Minicart_Functionality");
			Log.error("Verification check Failed for ini Cart icon functionality ");
			throw new Exception(BaseClass.errorValidation);
		}

	}

	public static void Header_Public_Verify_ContactUs_Functionality() throws Exception {
		try {
			Log.info("Verification of contactUs Icon");
			Utils.verifyElement(Home_Page.contactUs());
			Home_Page.contactUs().click();
			Thread.sleep(3000);
			Assert.assertEquals("Contact Us | Shoppers Stop", Utils.getPageTitle());
		} catch (Exception e) {
			Log.error("Verification check Failed for Contact Us icon functionality");
			throw e;
		}

	}

	public static void Header_Public_Verify_SearchBox_Field(int iTestCaseRow) throws Exception {
		try {
			Log.info("Verification for Header Search box field");
			Thread.sleep(1000);
			Utils.verifyElement(Home_Page.Search_Box());
			Log.info("Verification check has been completed for Header Search box field");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page_Action | Method Header_Public_Verify_SearchBox_Field");
			Log.error("Verification check Failed for Header Search box field");
			throw (e);

		}

	}

	public static void Header_Public_Verify_SearchBox_Functionality(int iTestCaseRow) throws Exception {
		try {
			Log.info("Verification for Header Search box field functionality");
			Home_Page.Search_Box().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.searchField));
			Log.info("Product name entered in search box");
			Home_Page.seeAllSearchResultButton().click();
			Log.info("Search button clicked successfully");
			Utils.waitForLoad("firefox");
			Utils.verifyElement(Home_Page.productListHeading());
			Log.info("Verification check has been completed for Header Search box field functionality");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page_Action | Method Header_Public_Verify_SearchBox_Functionality");
			Log.error("Verification check Failed for Header Search box field functionality");
			throw (e);

		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class HomePage_Action | Method Header_Public_Verify_SearchBox_Functionality");
			Log.error("Verification check Failed for Header Search box field functionality");
			throw new Exception(BaseClass.errorValidation);
		}

	}

	public static void FooterLinkVerification_Customer_Public(int iTestCaseRow) throws Exception {

		try {
			Utils.waitForPageLoad();
			Thread.sleep(5000);
//			Utils.scrollingToPageBottom(Home_Page.Footer_Section.footer());
//			Thread.sleep(2000);
//			Home_Page.Footer_Section.Help_FAQ().click();
//			Thread.sleep(5000);
//			Utils.PageHeaderCheck("FAQ | Shoppers Stop");
//			Home_Page.headerSoppersStopLogo().click();
//			Thread.sleep(5000);
			//Utils.scrollingToPageBottom(Home_Page.Footer_Section.footer());
			Utils.scrollingToPageElement(Home_Page.Footer_Section.Track_Order());
			Thread.sleep(3000);
			Utils.jsClick(Home_Page.Footer_Section.Track_Order());
			//Home_Page.Footer_Section.Track_Order().click();
			Thread.sleep(5000);
			Utils.PageHeaderCheck("Shoppers Stop");
//			Home_Page.headerSoppersStopLogo().click();
//			Thread.sleep(5000);
//			Utils.scrollingToPageBottom(Home_Page.Footer_Section.footer());
			Home_Page.Footer_Section.Size_Guide().click();
			Thread.sleep(5000);
			Utils.PageHeaderCheck("Size Guide | Shoppers Stop");
//			Utils.scrollingToPageBottom(Home_Page.headerSoppersStopLogo());
//			Home_Page.headerSoppersStopLogo().click();
//			Thread.sleep(5000);
//			Utils.scrollingToPageBottom(Home_Page.Footer_Section.footer());
			Home_Page.Footer_Section.Buying_Guide().click();
			Thread.sleep(5000);
			Utils.PageHeaderCheck("BuyingGuide | Shoppers Stop");
			Home_Page.headerSoppersStopLogo().click();
			Utils.waitForPageLoad();
			Thread.sleep(5000);
			Utils.scrollingToPageElement(Home_Page.Footer_Section.How_To_Buy());
			Thread.sleep(3000);
			Utils.jsClick(Home_Page.Footer_Section.How_To_Buy());
			//Home_Page.Footer_Section.How_To_Buy().click();
			Thread.sleep(5000);
			Utils.PageHeaderCheck("Purchase | Shoppers Stop");
//			Home_Page.headerSoppersStopLogo().click();
//			Thread.sleep(5000);
//			Utils.scrollingToPageBottom(Home_Page.Footer_Section.footer());
			Home_Page.Footer_Section.How_To_Pay().click();
			Thread.sleep(5000);
			Utils.PageHeaderCheck("How do I pay | Shoppers Stop");
//			Home_Page.headerSoppersStopLogo().click();
//			Thread.sleep(5000);
//			Utils.scrollingToPageBottom(Home_Page.Footer_Section.footer());
			Home_Page.Footer_Section.Place_We_Deliever().click();
			Thread.sleep(5000);
			Utils.PageHeaderCheck("Shoppers Stop");

			Log.info("Verification check has been completed for FooterLinks related to Customer- Public View");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page_Action | Method FooterLinkVerification_Customer_Public");
			Log.error("Verification check Failed  for Footer Links related to customer- Public View");
			throw e;
		}

		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class Home_Page_Action | Method FooterLinkVerification_Customer_Public");
			Log.error("Verification check Failed  for Footer Links related to customer- Public View");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void FooterLinkVerification_Policy_Public(int iTestCaseRow) throws Exception {
		try {
			Home_Page.Footer_Section.TermsAndConditions().click();
			Utils.PageHeaderCheck("Term and Condition | Shoppers Stop");

			Home_Page.Footer_Section.Privacy().click();
			Utils.PageHeaderCheck("Privacy | Shoppers Stop");
			Utils.waitForPageLoad();
			Home_Page.Footer_Section.Shipping_Policy().click();
			Utils.PageHeaderCheck("Delivery | Shoppers Stop");
			Utils.waitForPageLoad();
			Thread.sleep(2000);
			Home_Page.Footer_Section.Exchange_Returns().click();
			Utils.PageHeaderCheck("Returns | Shoppers Stop");

			Log.info("Verification check has been completed for FooterLinks related to Policy - Public View");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page_Action | Method FooterLinkVerification_Policy_Public");
			Log.error("Verification check Failed  for Footer Links related to policy - Public View");

			throw (e);

		}

		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class Home_Page_Action | Method FooterLinkVerification_Policy_Public");
			Log.error("Verification check Failed  for Footer Links related to policy - Public View");
			throw new Exception(BaseClass.errorValidation);
		}

	}

	public static void selectProductCategoryfromMenuClinique(int iTestCaseRow) throws Exception {
		try {

			String menu = ExcelUtils.getCellData(iTestCaseRow, Constant.productCategory);
			String submenu = ExcelUtils.getCellData(iTestCaseRow, Constant.productSubCategory);

			Utils.mouseHoverAction(Home_Page.menuCategory(menu), Home_Page.menuSubCategoryClinique(menu, submenu));
			Log.info("Product Category selected");
			Thread.sleep(3000);
			// Utils.scrollingToPageElementAdvanced(Home_Page.Clinique());
			Home_Page.Clinique().click();
			Log.info("Clinique Category selected");

		} catch (Exception e) {
			Log.error("Exception in Class HomePage_Action | Method selectProductCategoryfromMenu");
			Log.error("Product category not selected");

			throw (e);

		}
	}

	public static void FooterLinkVerification_StoreandSite_Public(int iTestCaseRow) throws Exception {
		try {
//			Utils.scrollingToPageElement(Home_Page.Footer_Section.AboutUs());
			Utils.waitForElementLongVisible(Home_Page.Footer_Section.AboutUs());
			Utils.jsClick(Home_Page.Footer_Section.AboutUs());
			Thread.sleep(3000);
			Utils.PageHeaderCheck("About Us | Online Retailer | Shoppers Stop | Shoppers Stop");
			/////////
			Home_Page.Footer_Section.Contact_Us().click();
			Utils.waitForPageLoad();
			Thread.sleep(3000);
			Utils.PageHeaderCheck("Contact Us | Shoppers Stop");
			//////////////
			Home_Page.Footer_Section.Corporate_Site().click();
			Utils.waitForPageLoad();
			Thread.sleep(3000);
			Utils.NewWindowPageHeaderValidation("Shoppers Stop | Home");

			Home_Page.Footer_Section.Store_Locator().click();
			Utils.waitForPageLoad();
			Thread.sleep(3000);
			Utils.PageHeaderCheck("Shoppers Stop Store Locator - Visit the nearest Shoppers Stop Store Today");
			
			////////////////
			Home_Page.Footer_Section.Careers().click();
			Utils.waitForPageLoad();
			Thread.sleep(3000);
			Utils.PageHeaderCheck("Shoppers Stop - Careers");
			Utils.driverNavigation("backward");
			//////////////////////
			
			Log.info("Verification check has been completed for Footer Links related to Store and Site - Public View");
		} catch (Exception e) {
			Log.error("Exception in Class Home_Page_Action | Method FooterLinkVerification_StoreandSite_Public");
			Log.error("Verification check Failed  for Footer Links related to Store and Site - Public View");
			throw (e);

		}

		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class Home_Page_Action | Method FooterLinkVerification_StoreandSite_Public");
			Log.error("Verification check Failed  for Footer Links related to Store and Site - Public View");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void FooterLinkVerification_FirstCitizen_Public(int iTestCaseRow) throws Exception {
		try {
			Home_Page.Footer_Section.First_Citizen().click();
			Thread.sleep(1000);
			Utils.PageHeaderCheck("First Citizen Non Member | Shoppers Stop");
			Utils.driverNavigation("backward");
			Utils.waitForPageLoadLongTime();
			Thread.sleep(5000);
		    Home_Page.Footer_Section.Instant_Gifting().click();
			Thread.sleep(3000);
			Utils.PageHeaderCheck("Shoppers Stop");
			Utils.driverNavigation("backward");
			Utils.waitForPageLoadLongTime();
			Thread.sleep(5000);
			Log.info("Verification check has been completed for Footer Links related to First Citizen - Public View");
		} catch (Exception e) {
			Log.error("Exception in Class Home_Page_Action | Method FooterLinkVerification_FirstCitizen_Public");
			Log.error("Verification check Failed for Footer Links related to First Citizen - Public View");

			throw (e);

		}

		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class Home_Page_Action | Method FooterLinkVerification_FirstCitizen_Public");
			Log.error("Verification check Failed for Footer Links related to First Citizen - Public View");

			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void selectProductCategoryfromMenuFilter(int iTestCaseRow) throws Exception {
		try {

			String menu = ExcelUtils.getCellData(iTestCaseRow, Constant.productCategory);
			String submenu = ExcelUtils.getCellData(iTestCaseRow, Constant.productSubCategory);
			Utils.mouseHoverAction(Home_Page.menuCategory(menu), Home_Page.menuSubCategoryFilter(menu, submenu));
			Log.info("Product Category selected");
		} catch (Exception e) {
			Log.error("Exception in Class HomePage_Action | Method selectProductCategoryfromMenu");
			Log.error("Product category not selected");

			throw (e);

		}
	}

	public static void FooterLinkVerification_FollowUs_Public(int iTestCaseRow) throws Exception {
		try {
			String url = null;
			url = "https://twitter.com/shoppersstop";
			Utils.mouseHover(Home_Page.Footer_Section.Twitter_Link());
			Utils.jsClick(Home_Page.Footer_Section.Twitter_Link());
			Thread.sleep(1000);
			Utils.NewWindowActionURLValidate(url);

			Utils.mouseHover(Home_Page.Footer_Section.Facebook_Link());
			Utils.jsClick(Home_Page.Footer_Section.Facebook_Link());
			Thread.sleep(1000);
			url = "https://www.facebook.com/shoppersstopindia";
			Utils.NewWindowActionURLValidate(url);
			
			Utils.mouseHover(Home_Page.Footer_Section.Instagram_Link());
			Utils.jsClick(Home_Page.Footer_Section.Instagram_Link());
			Thread.sleep(1000);
			url = "https://www.instagram.com/shoppers_stop/";
			Utils.NewWindowActionURLValidate(url);

//			Utils.mouseHover(Home_Page.Footer_Section.Pinterest_Link());
//			Utils.jsClick(Home_Page.Footer_Section.Pinterest_Link());
//			Thread.sleep(1000);
//			url = "https://in.pinterest.com/shoppersstopin/";
//			Utils.NewWindowActionURLValidate(url);
//
//			Utils.mouseHover(Home_Page.Footer_Section.GooglePlus_Link());
//			Utils.jsClick(Home_Page.Footer_Section.GooglePlus_Link());
//			Thread.sleep(1000);
//			url = "https://accounts.google.com/signin/v2/identifier?passive=1209600&osid=1&continue=https%3A%2F%2Fplus.google.com%2Fexplore%2Fshoppersstop&followup=https%3A%2F%2Fplus.google.com%2Fexplore%2Fshoppersstop&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
//			Utils.NewWindowActionURLValidate(url);
			
			Log.info("Verification check has been completed for Footer Links related to Follow Us - Public View");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page_Action | Method FooterLinkVerification_FollowUs_Public");
			Log.error("Verification check Failed for Footer Links related to Follow Us - Public View");
			BaseClass.bResult = false;
			throw (e);

		}

	}

	public static void FooterLinkVerification_ReachUs_Public(int iTestCaseRow) throws Exception {
		try {
			WebElement webElement = Home_Page.Footer_Section.Estore_Link();
			Thread.sleep(1000);
			Utils.performAssertEquals(webElement, "customercare@shoppersstop.com");

			Log.info("Verification check successfull for Footer text related to Reach Us - Public View");
		} catch (Exception e) {
			Log.error("Exception in Class Home_Page_Action | Method FooterLinkVerification_ReachUs_Public");
			Log.error("Verification check Failed for Footer text related to Reach Us - Public View");

			throw (e);

		}

		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class Home_Page_Action | Method FooterLinkVerification_ReachUs_Public");
			Log.error("Verification check Failed for Footer text related to Reach Us - Public View");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void selectProductCategoryfromMenu(int iTestCaseRow) throws Exception {
		try {

			String menu = ExcelUtils.getCellData(iTestCaseRow, Constant.productCategory);
			String submenu = ExcelUtils.getCellData(iTestCaseRow, Constant.productSubCategory);
			Utils.mouseHoverAction(Home_Page.menuCategory(menu), Home_Page.menuSubCategory(menu, submenu));
			Log.info("Product Category selected");
			System.out.println("Product Category selected");
			Thread.sleep(5000);
		} catch (Exception e) {
			Log.error("Exception in Class HomePage_Action | Method selectProductCategoryfromMenu");
			Log.error("Product category not selected");

			throw (e);

		}
	}

	public static void selectProductCategoryMainfromMenu(int iTestCaseRow) throws Exception {
		try {

			String menu = ExcelUtils.getCellData(iTestCaseRow, Constant.productCategory);
			String submenuMain = ExcelUtils.getCellData(iTestCaseRow, Constant.productSubCategory);
//			///
//			Driver.findElement(By.linkText("MEN"));
//			Thread.sleep(2000);
//			////
			Utils.mouseHoverAction(Home_Page.menuCategory(menu), Home_Page.menuSubCategoryMain(menu, submenuMain));
			Log.info("Product Category Main span selected");
		} catch (Exception e) {
			Log.error("Exception in Class HomePage_Action | Method selectProductCategoryfromMenu");
			Log.error("Product category Main span not selected");

			throw (e);

		}

	}

	public static void selectProductCategoryfromSearch(int iTestCaseRow) throws Exception {
		try {

			String Searchfield = ExcelUtils.getCellData(iTestCaseRow, Constant.searchField);
			System.out.println(Searchfield);
			Home_Page.Search_Box().sendKeys(Searchfield, Keys.ENTER);
			Thread.sleep(2000);
			Utils.jsClick(Home_Page.result_Product());
			Log.info("Product Category selected");
		} catch (Exception e) {
			Log.error("Exception in Class HomePage_Action | Method selectProductCategoryfromMenu");
			Log.error("Product category not selected");
			throw (e);

		}
	}

	public static void selectProductsfromSearch(int iTestCaseRow) throws Exception {
		try {

			String Searchfield = ExcelUtils.getCellData(iTestCaseRow, Constant.searchField);
			
				Home_Page.Search_Box().sendKeys(Searchfield, Keys.ENTER);
				Thread.sleep(2000);
				Home_Page.result_Product().click();
				PDP_Action.product_selectSize(ProductDetails_Page.Product.size_variant_buttonlist());
				Thread.sleep(4000);
				Utils.jsClick(ProductDetails_Page.Product.Product_AddToCart());
				Thread.sleep(5000);
				Home_Page.headerSoppersStopLogo().click();
				Log.info("Product Category selected");
			
		} catch (Exception e) {
			Log.error("Exception in Class HomePage_Action | Method selectProductCategoryfromMenu");
			Log.error("Product category not selected");
			throw (e);

		}
	}

	public static void selectProductCategoryfromSearch1(int iTestCaseRow) throws Exception {
		try {

			String Searchfield = ExcelUtils.getCellData(iTestCaseRow, Constant.searchField1);
			Home_Page.Search_Box().sendKeys(Searchfield, Keys.ENTER);
			Thread.sleep(2000);
			Home_Page.result_Product().click();
			Log.info("Product Category selected");
		} catch (Exception e) {
			Log.error("Exception in Class HomePage_Action | Method selectProductCategoryfromMenu");
			Log.error("Product category not selected");
			throw (e);

		}
	}

	public static void HappyPathFlowTillCartPage_WithoutEnteringPincode(int iTestCaseRow) throws Exception {
		try {
			selectProductCategoryMainfromMenu(iTestCaseRow);
			Utils.waitForPageLoadLongTime();
			Thread.sleep(5000);
			ProductListing_Page.productNew().click();
			Utils.waitForPageLoadLongTime();
			Thread.sleep(5000);
			PDP_Action.product_selectSize(ProductDetails_Page.Product.size_variant_buttonlist());
			Thread.sleep(5000);
			System.out.println("selected size");
			Utils.jsClick(ProductDetails_Page.Product.Product_AddToCart());
			System.out.println("add to cart is clicked");
			Utils.waitForPageLoadLongTime();
			Thread.sleep(5000);
			// Utils.verifyElement(MiniCart_Page.MiniCartProductDetails.MiniCartViewBag());
			// Utils.jsClick(MiniCart_Page.MiniCartProductDetails.MiniCartViewBag());
			// Minicart Functionality Removed
			Utils.jsClick(Cart_Page.cartIcon());
			Utils.waitForPageLoadLongTime();
			Thread.sleep(3000);
			Log.info("Navigated to cart page without entering pincode successfully");
		} catch (Exception e) {
			Log.error("Exception in Class HomePage_Action | Method HappyPathFlowTillCartPage_WithoutEnteringPincode");
			Log.error("Navigation Till Cart Page failed");
			throw e;
		}
	}

	// Verify all the links working or not on footer description section
	public static void verifyLinksOnFooter(List<WebElement> elements) throws Exception {
		try {
			System.out.println("total links are " + elements.size());
			for (WebElement element : elements) {
				String linktext = element.getText();
				System.out.println(linktext);
				Log.info("click on link of " + linktext);
				element.click();
				Thread.sleep(3000);
				Log.info("Go to new window and Verify page title and come back and continue" + linktext);
				Utils.NewWindowActionURLValidateWithPageTitle(linktext);
				Utils.waitForPageLoad();
				Thread.sleep(3000);
			}
			Log.info("All links verified successfully with page titles");
		} catch (Exception e) {
			Log.error("Exception in Class HomePage_Action | Method HappyPathFlowTillCartPage_WithoutEnteringPincode");
			Log.error("Navigation Till Cart Page failed");
			throw e;
		}
	}

	public static void verify_AllRightsReserved_Text_Present(int iTestCaseRow) {
		try {
			Log.info("Finding the AllRightsReserved Text on Home Page");
			Utils.highLight(Home_Page.Footer_AllRightsReserved());
			String text = Home_Page.Footer_AllRightsReserved().getText();
			if (text.contains("SHOPPERS STOP LTD. ALL RIGHTS RESERVED."))
				;
			Log.info("AllRightsReserved Text on Home Page Found");
		} catch (Exception e) {
			Log.error(" Error finding the AllRightsReserved Text on Home Page");
			Log.info(e.getMessage());
			System.out.println(e.getMessage());
			throw (e);
		}
	}
	public static void verifyFirstCitizenRelatedLinks() throws InterruptedException {
		Thread.sleep(3000);
		List<WebElement> links= Footer_Page.FirstCitizenlinks();
		for (WebElement e:links) {
		Utils.jsClick(e);
		System.out.println(e.getAttribute("innerHTML")+" link is cliked ");
		Utils.waitForPageLoad();
		}
		
	}


	public static void click_HomePage_FirstCitizen_Link(int iTestCaseRow) throws Exception {
		try {
			Log.info(" Finding the FirstCitizen link on Home Page");
			Utils.waitForElementLongVisible(Home_Page.get_FirstCitizen_Link());
			Utils.jsClick(Home_Page.get_FirstCitizen_Link());
			Log.info("FirstCitizen link found and clicked on Home Page");
			Thread.sleep(2000);

			String title = Utils.getPageTitle();
			System.out.println(title);
		} catch (Exception e) {
			Log.error(" Error finding the FirstCitizen link on Home Page");
			Log.info(e.getMessage());
			System.out.println(e.getMessage());
			throw (e);
		}
	}

	public static void click_HomePage_TermsAndConditions_Link(int iTestCaseRow) throws Exception {
		try {
			Log.info(" Finding the TermsAndConditions link on Home Page");
			Utils.highLight(Home_Page.get_TermsAndCondions_Link());
			Utils.jsClick(Home_Page.get_TermsAndCondions_Link());
			Log.info("TermsAndConditions link found and clicked on Home Page");
			Thread.sleep(2000);
			String title = Utils.getPageTitle();
			System.out.println(title);
		} catch (Exception e) {
			Log.error(" Error finding the TermsAndConditions link on Home Page");
			Log.info(e.getMessage());
			System.out.println(e.getMessage());
			throw (e);
		}
	}

	public static void verify_Header_Store_Locator_link_functionality(String city, String store) throws Exception {

		try {
			Log.info("Finding the store locating link on the header");
			Utils.waitForElementPresence2(Home_Page.StoreLocator());
			Utils.jsClick(Home_Page.StoreLocator());
			Log.info("All store  link found and clicked on Home Page");
			Log.info("Finding the city  link on the store finder page");
			Utils.waitForPageLoad();
			Utils.SelectDropdownByValue(((Home_Page.selectCity())), city);
			Log.info("Finded the city  link on the store finder page");
			Log.info("Finding the store  link on the store finder page");
			Utils.SelectDropdownByValue((Home_Page.selectStore()), store);
			String url = Driver.getCurrentUrl();
			System.out.println("selected the store " + url.replace("_", "").substring(43));
			String mUrl = url.replace("_", "").substring(43);
			if (mUrl.equals(store.replace(" ", ""))) {
				System.out.println("The map is   navigated to the selected store and the city");
			}
			Log.info("Finded the store  link on the store finder page");

		} catch (Exception e) {
			Log.error("couldn't complete the store loactor functionality ");
			Log.info(e.getMessage());
			throw (e);
		}

	}

	public static void verify_TrackOrder_page_functionality(String email, String orderCode) {
		try {
			Utils.jsClick(Home_Page.trackOrders());
			Log.info("Track orders link has been clicked on the home page");
			Home_Page.emailId().sendKeys(email);
			Log.info("email id is entered");
			System.out.println(email + " has been entered succefully ");
			Home_Page.orderCode().sendKeys(orderCode, Keys.ENTER);
			Log.info("ordercode  is entered");
			System.out.println(orderCode + " has been entered succefully ");
			if (Home_Page.errorMessageOnTrackOrder().isDisplayed()) {
				Log.info("the entered email id or ordercode is was incorrect");
				System.out.println(Home_Page.errorMessageOnTrackOrder().getAttribute("innerHTML"));
			}
			Utils.waitForPageLoad();
			List<WebElement> opt = Home_Page.OrderDeatils();
			System.out.println("\n" + "order details are >>>>>>>>>>>");
			for (WebElement e : opt) {
				System.out.println(e.getText() + "\n");

			}

		} catch (Exception e) {
			Log.error("couldn't complete the track order  functionality ");
			Log.info(e.getMessage());
			throw (e);

		}

	}

	public static void searchForTheProduct(int iTestCaseRow) throws Exception {
		try {

			String Searchfield = ExcelUtils.getCellData(iTestCaseRow, Constant.searchField);
			System.out.println(Searchfield);
			Home_Page.Search_Box().sendKeys(Searchfield, Keys.ENTER);
			Thread.sleep(10000);
			Log.info("search has been completed for the  product");
		} catch (Exception e) {
			Log.error("Exception in Class HomePage_Action | Method searchForTheProduct");
			Log.error("search for the product is not completed ");
			throw (e);

		}
	}
}
