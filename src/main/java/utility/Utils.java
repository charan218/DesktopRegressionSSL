package utility;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import appModules.Cart_Action;
import appModules.CheckOut_Action;
import appModules.HomePage_Action;
import appModules.PDP_Action;
import pageObjects.BaseClass;
import pageObjects.Cart_Page;
import pageObjects.Checkout_Page;
import pageObjects.Home_Page;
import pageObjects.MiniCart_Page;
import pageObjects.ProductDetails_Page;
import pageObjects.ProductListing_Page;

public class Utils {
	public static WebDriver Driver = null;
	public static WebElement elem = null;

	static String StaticPageName = null;
	public static boolean actualValue;

	public static WebDriver OpenBrowser(int iTestCaseRow) throws Exception {
		String sBrowserName;
		try {
			Log.info("Getting Browser Name");
			sBrowserName = ExcelUtils.getCellData(iTestCaseRow, Constant.browser);

			if (sBrowserName.equals("Mozilla")) {
				File file = new File("geckodriver.exe");
				System.setProperty("webdriver.gecko.driver", Utils.ReadProperties(Constant.Path_ConfigProperties).getProperty("Path_Source")
						+ "//geckodriver.exe");
				//System.setProperty("webdriver.firefox.marionette",file.getAbsolutePath());
				DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();
				FirefoxOptions options = new FirefoxOptions();
				desiredCapabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
				Driver = new FirefoxDriver();

			} else if (sBrowserName.equals("Chrome")) {
				System.setProperty("webdriver.chrome.driver",
						Utils.ReadProperties(Constant.Path_ConfigProperties).getProperty("Path_Source")
								+ "//chromedriver.exe");
				Driver = new ChromeDriver();

			} else if (sBrowserName.equals("IE")) {
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				System.setProperty("webdriver.ie.driver",
						Utils.ReadProperties(Constant.Path_ConfigProperties).getProperty("Path_Source")
								+ "//IEDriverServer.exe");
				Driver = new InternetExplorerDriver(capabilities);
			} else if (sBrowserName.equals("Phantom")) {
				File file = new File("C:\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
				System.setProperty("phantomjs.binary.path", file.getAbsolutePath());
				Driver = new PhantomJSDriver();

			}
			Log.info("New driver instantiated in " + sBrowserName);

			Driver.manage().window().maximize();

			Driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Log.info("Implicit wait applied on the driver for 20 seconds");

			Driver.get(Constant.URL);
			Thread.sleep(5000);
			Log.info("Web application launched successfully");

		} catch (Exception e) {
			Log.error("Exception in Class Utils | Method OpenBrowser");
			Log.error("Issue in opening browser");
			throw e;
		}
		return Driver;
	}

	/* To Disable the Firefox notification in the page */
	/////////////////
	public static void HandleNotificationOnFirefox() {
		FirefoxOptions options = new FirefoxOptions();
		options.setProfile(new FirefoxProfile());
		options.addPreference("dom.webnotifications.enabled", false);
	}
	/////////////////////////
	

	// @Author Rahul Tiwari--- Do Not change anything
	public static void NavigateToURL(String URL) {
		Driver.get(URL);
	}
	
	/* This method is only for COD class */
	public static void HappyPathFlowTillCheckOutPageForCOD(int iTestCaseRow) throws Exception {
		//HomePage_Action.selectProductCategoryfromMenu(iTestCaseRow);
		HomePage_Action.selectProductCategoryfromSearch(iTestCaseRow);
		Log.info("Product category selected successfully");
		Utils.waitForPageLoadLongTime();
		System.out.println("Product c");
		Utils.waitForPageLoadLongTime();
		Thread.sleep(6000);
		Utils.jsClick(ProductListing_Page.secondproduct());
		Log.info("Product selected successfully");
		Thread.sleep(5000);
		Utils.waitForPageLoadLongTime();
//		if(ProductListing_Page.DyPopup().isDisplayed()){
//			Utils.mouseHover(ProductListing_Page.DyPopup());
//			ProductListing_Page.DyPopupCloseBtn().click();
//		}
		PDP_Action.product_selectSize(ProductDetails_Page.Product.size_variant_buttonlist());
		System.out.println("size selected");
//		Utils.waitForPageLoadLongTime();
		Thread.sleep(8000);
		Utils.waitForPageLoadLongTime();
		Utils.waitForElementTOclick(ProductDetails_Page.Product.Product_AddToCart());
		Log.info("Add to cart button is clicked");
		Utils.waitForPageLoadLongTime();
		Thread.sleep(5000);
		// Utils.verifyElement(MiniCart_Page.MiniCartWindow());
		// Log.info("Product is added to the cart and mini cart is displayed");

//		MiniCart_Page.MiniCartProductDetails.MiniCartViewBag().click();
		// Minicart Functionality Removed
		
		Utils.waitForElementTOclick(Cart_Page.cartIcon());
		Utils.waitForPageLoadLongTime();
		Thread.sleep(8000);
		System.out.println("cart clicked");
		// Log.info("View bag button is clicked on Mini cart window");
//		Utils.verifyElement(Cart_Page.CheckoutButton());
	//	Utils.jsClick(Cart_Page.CheckoutButton());
		Utils.waitForElementTOclick(Cart_Page.CheckoutButton());
		System.out.println("checkout clicked");
		Utils.waitForPageLoadLongTime();
		Thread.sleep(10000);

	}
	
	///////////
	public static void HappyPathFlowTillCheckOutPage(int iTestCaseRow) throws Exception {
		HomePage_Action.selectProductCategoryfromMenu(iTestCaseRow);
		Log.info("Product category selected successfully");
		//Utils.waitForPageLoadLongTime();
		System.out.println("Product c");
		Utils.waitForPageLoadLongTime();
		Thread.sleep(6000);
		Utils.jsClick(ProductListing_Page.secondproduct());
		Log.info("Product selected successfully");
		Thread.sleep(5000);
		Utils.waitForPageLoadLongTime();
//		if(ProductListing_Page.DyPopup().isDisplayed()){
//			Utils.mouseHover(ProductListing_Page.DyPopup());
//			ProductListing_Page.DyPopupCloseBtn().click();
//		}
		PDP_Action.product_selectSize(ProductDetails_Page.Product.size_variant_buttonlist());
		System.out.println("size selected");
//		Utils.waitForPageLoadLongTime();
		Thread.sleep(8000);
		Utils.waitForPageLoadLongTime();
		Utils.waitForElementTOclick(ProductDetails_Page.Product.Product_AddToCart());
		Log.info("Add to cart button is clicked");
		Utils.waitForPageLoadLongTime();
		Thread.sleep(5000);
		// Utils.verifyElement(MiniCart_Page.MiniCartWindow());
		// Log.info("Product is added to the cart and mini cart is displayed");

//		MiniCart_Page.MiniCartProductDetails.MiniCartViewBag().click();
		// Minicart Functionality Removed
		
		Utils.waitForElementTOclick(Cart_Page.cartIcon());
		//Utils.waitForPageLoadLongTime();
		Thread.sleep(8000);
		System.out.println("cart clicked");
		// Log.info("View bag button is clicked on Mini cart window");
//		Utils.verifyElement(Cart_Page.CheckoutButton());
	//	Utils.jsClick(Cart_Page.CheckoutButton());
		Utils.waitForElementTOclick(Cart_Page.CheckoutButton());
		System.out.println("checkout clicked");
		Utils.waitForPageLoadLongTime();
		Thread.sleep(10000);

	}
	////////////////
	// Wait for page completely load for taking more time pages
			public static void waitForPageLoadLongTime() {
				Wait<WebDriver> wait = new WebDriverWait(Driver, 300);
				wait.until(new Function<WebDriver, Boolean>() {
					public Boolean apply(WebDriver driver) {
						System.out.println("Current Window State : "
								+ String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
						return String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
								.equals("complete");
					}
				});
			}
	public static void HappyPathFlowFromCartPageToDeliveryAddressPage(int iTestCaseRow) throws Exception {
		Utils.verifyElement(Cart_Page.CheckoutButton());
		Cart_Page.CheckoutButton().click();
		if (ExcelUtils.getCellData(iTestCaseRow, Constant.UserType).equals("Public")) {
			jsClick(Checkout_Page.LoginDetails.ContinueAsGuest());
			Thread.sleep(5000);
			String userEmail = ExcelUtils.getCellData(iTestCaseRow, Constant.emailId);
			Checkout_Page.LoginDetails.LoginEmailGuest().sendKeys(userEmail);
			Log.info("User email id is entered successfully");
			Checkout_Page.LoginDetails.ContinueBtn().click();
			Log.info("Continue button is clicked");
		} else if (ExcelUtils.getCellData(iTestCaseRow, Constant.UserType).equals("Add New Address")) {
			CheckOut_Action.ProceedwithNewAddress(iTestCaseRow);

		} else {
			Checkout_Page.Paymentinfo.ProceedToPaymentButton().click();
		}
	}

	public static void HappyPathFlowTillCartPage(int iTestCaseRow) throws Exception {
		try {
			HomePage_Action.selectProductCategoryfromMenu(iTestCaseRow);
			Log.info("Product selected from Main Menu on header");
			ProductListing_Page.product().click();
			Log.info("Product clicked on PLP");
			PDP_Action.product_selectSize(ProductDetails_Page.Product.size_variant_buttonlist());
			Thread.sleep(5000);
			Utils.waitForElementTOclick(ProductDetails_Page.Product.Product_AddToCart());
			Thread.sleep(3000);
//			Utils.verifyElement(MiniCart_Page.MiniCartProductDetails.MiniCartViewBag());
//			MiniCart_Page.MiniCartProductDetails.MiniCartViewBag().click();
			Utils.waitForPageLoad();
			Utils.waitForElementTOclick(Cart_Page.cartIcon());
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println("Navigation Till Cart Page failed");
			throw new Exception("Navigation till cart Page Failed || Method HappyPathFlowTillCartPage || Class Utils");
		}
	}

	public static void jsClick(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) Driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public static String getPageTitle() {
		String pageTitle;
		pageTitle = Driver.getTitle().trim();
		return pageTitle;
	}

	public static String getURL() {
		String CurrentURL;
		CurrentURL = Driver.getCurrentUrl().trim();
		return CurrentURL;
	}

	public static void HighlightAllElementOneByOne(List<WebElement> elements) throws Exception {
		List<WebElement> list = elements;
		for (WebElement element : list)
			if (Driver instanceof JavascriptExecutor) {
				if (element.isDisplayed()) {
					Thread.sleep(2000);
					Utils.scrollingToPageElement(element);
					Utils.mouseHover(element);
					((JavascriptExecutor) Driver).executeScript("arguments[0].style.border='3px solid red'", element);
				}

			}
	}

	public static int countNumberOfElementDisplayed(List<WebElement> list) {
		int count = list.size();
		int i = 0;
		int numberOfElementDisplayed = 0;
		for (i = 0; i < count; i++) {
			try {
				System.out.println(list.get(i));
				if (list.get(i).isDisplayed()) {
					numberOfElementDisplayed++;
					highLight(list.get(i));
				}
			} catch (Exception e) {
				System.out.println(numberOfElementDisplayed + "elements displayed");
			}
		}
		return numberOfElementDisplayed;
	}

	public static Boolean ClickElementIfDisplayed(WebElement element) throws Exception {
		Thread.sleep(3000);
		try {
			if (element.isDisplayed()) {
				Utils.mouseHover(element);
				highLight(element);
				element.click();
				Thread.sleep(5000);

//					Utils.verifyElement(ProductListing_Page.breadCrumb());
//					System.out.println("Page breadCrumb is : " + ProductListing_Page.breadCrumb().getText());
				System.out.println("Page Title is : " + Driver.getTitle());
				Utils.driverNavigation("backward");
				// MobileWeb.ExplicitWait(Home_Page.LazyBannerImage());
				Thread.sleep(5000);
				return true;
			}
		} catch (Exception e) {
			System.out.println("Element is not visible");
			System.out.println(element);
			// return false;
		}

		Utils.mouseHover(element);
		return false;

	}

	public static Boolean ClickElementIfDisplayed_DefaultAddress(WebElement element) throws Exception {
		Thread.sleep(3000);
		try {
			if (element.isDisplayed()) {
				Utils.mouseHover(element);
				highLight(element);
				element.click();
				Thread.sleep(5000);
				// MobileWeb.ExplicitWait(Home_Page.LazyBannerImage());
				Thread.sleep(5000);
				return true;
			}
		} catch (Exception e) {
			System.out.println("Element is not visible");
			System.out.println(element);
			// return false;

		}
		return false;
	}

	//updated: if no item on the cart getting issue some times
	public static void removeAllItemFromCart() throws Exception{
		
		int empty=0;
		try {
			//WebElement el=Driver.findElement(By.xpath("//span[@class='qtyHeaderMinicart count bag-count' and @style='display: inline;']"));
			WebDriverWait wait=new WebDriverWait(Driver, 180);
//			wait.until(ExpectedConditions.elementToBeClickable(el));
		 
//		catch (Exception e) {
//			System.out.println("Cart contains zero items So no need to continue for remove AllItems from cart");
//			Log.info("Cart contains zero items So no need to continue for remove AllItems from cart");
//			empty++;
//		}
		if(empty==0){
	    String cartCount=MiniCart_Page.QtyMiniCart().getAttribute("value");
	    int c_count = 0;
	    try{
	    	c_count=Integer.parseInt(cartCount);
	    	System.out.println("cart contain "+ c_count+" items");
	    }catch(NumberFormatException e){
	    	System.out.println("Cart contains zero items");
	    }
	    
	    if(c_count>0){
	    	Thread.sleep(3000);
	    	Utils.waitForElementTOclick(Cart_Page.cartIcon());
	    	
	    	//MiniCart_Page.MiniCartProductDetails.MiniCartViewBag().click();
	    	//Minicart Functionality Removed
			Thread.sleep(3000);
	          List<WebElement> list=MiniCart_Page.RemoveItemFromCart();
	          int size=list.size();
	          for(int i=1;i<=size;i++){
	                if(MiniCart_Page.RemoveItemFromCart().get(0).isDisplayed()) {
	                	MiniCart_Page.RemoveItemFromCart().get(0).click();
	                	Thread.sleep(3000);
	                	Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	                }
	          
	          }
	          Driver.get(Constant.URL);
	          Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    }
		}
		}
		catch (Exception e) {
			System.out.println("Cart contains zero items So no need to continue for remove AllItems from cart");
			Log.info("Cart contains zero items So no need to continue for remove AllItems from cart");
			empty++;
		}
	} 
	
	/*public static void removeAllItemFromCart() throws Exception {
	String cartCount = MiniCart_Page.QtyMiniCart().getText().toString();
	int c_count = 0;
	try {
		c_count = Integer.parseInt(cartCount);
	} catch (NumberFormatException e) {
		System.out.println("Cart contains zero items");
	}

	if (c_count > 0) {

		Utils.jsClick(MiniCart_Page.QtyMiniCart());
		Thread.sleep(1000);
		// MiniCart_Page.MiniCartProductDetails.MiniCartViewBag().click();
		// Minicart Functionality Removed
		Cart_Page.cartIcon().click();
		Thread.sleep(3000);
		List<WebElement> list = MiniCart_Page.RemoveItemFromCart();
		int size = list.size();
		for (int i = 1; i <= size; i++) {
			if (MiniCart_Page.RemoveItemFromCart().get(0).isDisplayed()) {
				MiniCart_Page.RemoveItemFromCart().get(0).click();
				Thread.sleep(3000);
			}

		}
		Driver.get(Constant.URL);
		Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}*/
	public static void removeAllItemFromWishList() throws Exception {
		int itemCount = 0;
		int count=0;
//		 if(itemCount.equals(MiniCart_Page.QtyWishList().getText())){
		Thread.sleep(3000);
		try {
		 count=Integer.parseInt(Home_Page.headerWishlistUserMenu().getAttribute("innerHTML"));
		}catch (Exception e) {
			Log.info("wish list contais zero items");
		}
		System.out.println(count+" products are present in wishlist");
		if (itemCount==count) {
			System.out.println(" wishlist contains zero items ");
		} else {
			waitForPageLoad();
			Thread.sleep(3000);
			waitForElementTOclick(Home_Page.headerWishlistIcon());
			Thread.sleep(5000);
			waitForPageLoad();
			List<WebElement> list = MiniCart_Page.RemoveItemFromWishList();
			int size = list.size();
			for (int i = 1; i <= size; i++) {
					waitForElementTOclick(MiniCart_Page.RemoveItemFromWishList().get(0));
					Thread.sleep(5000);
					waitForPageLoad();
			}
			System.out.println(" All the products removed form the wish list");
			Driver.get(Constant.URL);
			Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}

	}
	//Updated: old one not working properly. So updated the logic. Not remove this
	/*public static void removeAllItemFromWishList() throws Exception {
		int empty=0;
		WebElement el = null;
		try {
			//in production xpath 1st one
			//WebElement el=Driver.findElement(By.xpath("////span[@class='count wish-count' and @style='display: inline;']"));
			el=Driver.findElement(By.xpath("//span[@class='count wish-count' and @style='display: block;']"));
			WebDriverWait wait=new WebDriverWait(Driver, 180);
			wait.until(ExpectedConditions.elementToBeClickable(el));
			jsClick(el);
		} catch (Exception e) {
			System.out.println("Wish list contains zero items So no need to continue for remove AllItems from Wishlist");
			Log.info("Wish list contains zero items So no need to continue for remove AllItems from Wishlist");
			empty++;
		}
		
		if(empty==0){
		    String cartCount=el.getText().toString();
		    int c_count = 0;
		    try{
		    	c_count=Integer.parseInt(cartCount);
		    }catch(NumberFormatException e){
		    	System.out.println("Cart contains zero items");
		    }
		    
		    if(c_count>0){
		    	jsClick(Home_Page.headerWishlistIcon());
				Thread.sleep(5000);
				List<WebElement> list = MiniCart_Page.RemoveItemFromWishList();
				int size = list.size();
				for (int i = 1; i <= size; i++) {
					if (MiniCart_Page.RemoveItemFromWishList().get(0).isDisplayed()) {
						Utils.jsClick(MiniCart_Page.RemoveItemFromWishList().get(0));
						Thread.sleep(5000);
					}

				}
				System.out.println(" All the products removed form the wish list");
				Driver.get(Constant.URL);
				Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}
		
		}
		
	}*/

	public static String getTestCaseName(String sTestCase) throws Exception {
		String value = sTestCase;
		try {
			Log.info("Getting Test case name");
			int posi = value.indexOf("@");
			value = value.substring(0, posi);
			posi = value.lastIndexOf(".");
			value = value.substring(posi + 1);
			Log.info("Test case name is: " + value);
			return value;
		} catch (Exception e) {
			Log.error("Exception in Class Utils | Method getTestCaseName");
			Log.error("Issue in getting test case name");
			throw (e);
		}
	}

	public static String getApplicationName(String sTestCase) throws Exception {
		String value = sTestCase;
		try {
			Log.info("Getting Application name");
			int posi = value.indexOf("@");
			value = value.substring(0, posi);
			posi = value.lastIndexOf(".");
			value = value.substring(posi + 1);
			posi = value.lastIndexOf("_");
			value = value.substring(0, posi);
			Log.info("Application name is: " + value);

			return value;
		} catch (Exception e) {
			Log.error("Exception in Class Utils | Method getTestCaseName");
			Log.error("Issue in getting test application name");
			throw (e);
		}
	}

	public static Properties ReadProperties(String path) throws Exception {

		Properties config = new Properties();
		try {

			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\" + path);
			config.load(fis);

		} catch (IOException e) {
			Log.error("Exception in Class Utils | Method ReadProperties");
			Log.error("Issue in loading config file");
			throw e;
		}

		return config;

	}

	public static void mouseHover(WebElement mainElement) throws Exception {
		try {
			Log.info("Hovering mouse on the element");
			Actions builder = new Actions(Driver);
			waitForElementPresence2(mainElement);
			builder.moveToElement(mainElement).build().perform();
			Log.info("Mouse hovered successfully");
		} catch (Exception e) {
			Log.error("Exception in Class Utils | Method mouseHover");
			Log.error("Issue in hovering mouse on the element");
			throw e;
		}

	}

	public static void mouseHoverElement(WebElement mainElement) throws Exception {
		try {
			Log.info("Hovering mouse on the element");
			Actions builder = new Actions(Driver);
			builder.moveToElement(mainElement).perform();
			Log.info("Mouse hovered successfully");
		} catch (Exception e) {
			Log.error("Exception in Class Utils | Method mouseHover");
			Log.error("Issue in hovering mouse on the element");
			throw e;
		}

	}

	public static void moveLeft(WebElement element) throws Exception {
		try {
			Log.info("Hovering mouse on the element");
			Actions builder = new Actions(Driver);
			builder.sendKeys(Keys.ARROW_LEFT);
			builder.click(element).build().perform();
			Log.info("Mouse hovered successfully");
		} catch (Exception e) {
			Log.error("Exception in Class Utils | Method element");
			Log.error("Issue in hovering mouse on the element");
			throw e;
		}

	}

	public static void moveLeftClick(WebElement element) throws Exception {
		try {
			Log.info("Hovering mouse on the element");
			Actions builder = new Actions(Driver);
			builder.sendKeys(Keys.ARROW_LEFT, Keys.DOWN).build().perform();
			builder.sendKeys(Keys.CONTROL).sendKeys(Keys.END).build().perform();

			Log.info("Mouse hovered successfully");
		} catch (Exception e) {
			Log.error("Exception in Class Utils | Method element");
			Log.error("Issue in hovering mouse on the element");
			throw e;
		}
	}

	public static void SelectDropdown(WebElement mainElement) throws Exception {
		try {
			Log.info("Hovering mouse on the element");
			Robot rob = new Robot();
			rob.keyPress(KeyEvent.VK_ENTER);

		} catch (Exception e) {
			Log.error("Exception in Class Utils | Method mouseHover");
			Log.error("Issue in hovering mouse on the element");
			throw e;
		}

	}

	public static void SelectDropdownUpdated(WebElement mainElement) throws Exception {
		try {
			Log.info("Hovering mouse on the element");
			Select rob = new Select(mainElement);
			rob.selectByIndex(0);

		}

		catch (Exception e) {
			Log.error("Exception in Class Utils | Method mouseHover");
			Log.error("Issue in hovering mouse on the element");
			throw e;
		}

	}

	public static void SelectDropdownFromIndex(WebElement mainElement, int indexnum) throws Exception {
		try {
			Log.info("Hovering mouse on the element");

			Select rob = new Select(mainElement);
			rob.selectByIndex(indexnum);

		} catch (Exception e) {
			Log.error("Exception in Class Utils | Method mouseHover");
			Log.error("Issue in hovering mouse on the element");
			throw e;
		}

	}

	public static void mouseHoverAction(WebElement mainElement, WebElement subElement) throws Exception {
		try {
			Log.info("Hovering mouse on the main element");
			Actions action = new Actions(Driver);
			Thread.sleep(2000);
			action.moveToElement(mainElement).build().perform();
			Thread.sleep(5000);
			Log.info("Clicking on subelement");
			Utils.jsClick(subElement);

			Log.info("Mouse hover on main element and then Click action on subelement is performed on the entered objects");
		} catch (Exception e) {
			Log.error("Exception in Class Utils | Method mouseHoverAction");
			Log.error("Issue in performing mouse hover and click action");
			throw e;
		}

	}

	public static void SecurityCertificateHandle() throws Exception {
		try {
			Log.info("Handling security certificates");
			Driver.navigate().to("javascript:document.getElementById('overridelink').click()");
			Log.info("SecurityCertificateHandle : eelement got clicked");
		} catch (Exception e) {
			Log.error("Exception in Class Utils | Method SecurityCertificateHandle");
			throw e;
		}
	}

	public List<WebElement> stripOutElementsThatAreNotVisible(List<WebElement> elementList) {

		List<WebElement> visibleElements = new ArrayList<WebElement>();
		for (int i = 0; i < elementList.size(); i++) {
			WebElement foo = elementList.get(i);
			if (foo.isDisplayed()) {
				visibleElements.add(foo);
			}
		}
		return visibleElements;
	}

	public static WebElement find(By by) throws Exception {
		try {
			elem = null;
			java.util.List<WebElement> list = Driver.findElements(by);
			if (list.size() < 1) {
				throw new NoSuchElementException(null);
			}
			if (list.size() == 1) {
				elem = list.get(0);
				return elem;
			}
			if (list.size() > 1) {
				for (WebElement el : list) {
					try {

						if (el.isDisplayed()) {
							System.out.println(el.getTagName() + " element Visible");
							elem = el;
						} else {
							System.out.println(el.getTagName() + " element Hidden");
						}
					} catch (Exception e) {
						throw e;
					}
				}
				return elem;
			}
		} catch (Exception e) {
			Log.error("Exception in Class Utils | Method find");
			throw e;
		}
		return elem;
	}

	public static String GenerateRandomValues(String str) {
		Random r = new Random();
		double i = r.nextDouble();
		System.out.println(i);
		str = i + i + i + str;
		return str;
	}

	public static String getCurrentTime(String email) {
		String strDate = new SimpleDateFormat("ddMMyyyyssHHmmss").format(new Date());
		email = strDate + email;
		return email;
	}

	public static void waitForElementTOclick(WebElement element) throws Exception {
		try {
			Log.info("Waiting for the element to be clickable");
			WebDriverWait wait = new WebDriverWait(Driver, 40);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			jsClick(element);
			Log.info(" the elemnt has clicked succesfully");
		} catch (Exception e) {
			Log.error("Exception in Class Utils | Method waitForElement");
			Log.error("Issue in waiting for the element");
			throw e;
		}

	}

	public static void waitForInvisibityOfElement(WebElement element) throws Exception {
		try {
			Log.info("Waiting for InvisibityOfElement");
			WebDriverWait wait = new WebDriverWait(Driver, 40);
			wait.until(ExpectedConditions.invisibilityOf(element));
			Log.info(" the element disappeared");
		} catch (Exception e) {
			Log.error("Exception in Class Utils | Method waitForInvisibityOfElement");
			Log.error("Issue in waiting for the element to invisibilty");
			throw e;
		}

	}

	public static void waitForLoad(String browser) throws InterruptedException {
		Log.info("Waiting for the page to load");
		WebDriverWait wait = new WebDriverWait(Driver, 30);

		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver wdriver) {
				return ((JavascriptExecutor) Driver).executeScript("return document.readyState").equals("complete");
			}
		});

		if (browser.equalsIgnoreCase("chrome")) {
			Thread.sleep(4000);

		} else {
			Log.info("Waiting in Firefox.");
			Thread.sleep(10000);
		}

	}

	public static void verifyElement(WebElement element) throws Exception {
		try {
			Log.info("Verifying element");
			WebDriverWait wait = new WebDriverWait(Driver, 30);
//			wait.until(ExpectedConditions.elementToBeClickable(element));
			highLight(element);
			//
			Assert.assertTrue(element.isDisplayed());
			//
			Log.info("Element Present on the page, Verification Passed");

		} catch (Exception e) {
			Log.error("Exception in Class Utils | Method verifyElement");
			Log.error("Element Not Present on the page, Verification Failed");
			throw (e);
		}
	}

	public static void performAssertEquals(WebElement element, String expectedValue) {
		try {
			Log.info("Performing assert operation");
			Assert.assertEquals(element.getText(), expectedValue);
			Log.info("Expected value - '" + expectedValue + "match with Actual value - " + element.getText() + "\n");
		} catch (Throwable e) {
			Log.info(expectedValue + " - text validation failed");
			Log.error("Exception in Class Utils | Method performAssertEquals");
			BaseClass.errorValidation += "Expected value - '" + expectedValue + "does not match with Actual value - "
					+ element.getText() + "\n";
		}
	}

	public static void driverNavigation(String action) {
		Log.info("Performing navigation operations");
		switch (action) {
		case "forward":
			Driver.navigate().forward();
			break;
		case "backward":
			Driver.navigate().back();
			break;
		default:
			break;
		}
	}

	public static void waitForElementPresence(WebElement element) throws Exception {
		try {
			Log.info("Waiting for element visibility");
			WebDriverWait wait = new WebDriverWait(Driver, 10);
			wait.until(ExpectedConditions.visibilityOf(element));

			Log.info("Element Present on the page, Verification Passed");

		} catch (Exception e) {
			Log.error("Exception in Class Utils | Method waitForElementPresence");
			Log.error("Element Not Present on the page, Verification Failed");
			throw (e);
		}
	}

	/**
	 * The following method is used for wait to load page or element when navigate
	 * one page to other etc.,
	 * 
	 * @param element
	 * @throws Exception
	 */
	public static void waitForElementPresence2(WebElement element) throws Exception {
		try {
			Log.info("Waiting for element visibility");
			WebDriverWait wait = new WebDriverWait(Driver, 30);
			wait.until(ExpectedConditions.visibilityOf(element));

			Log.info("Element Present on the page, Verification Passed");

		} catch (Exception e) {
			Log.error("Exception in Class Utils | Method waitForElementPresence");
			Log.error("Element Not Present on the page, Verification Failed");
			throw (e);
		}
	}

	

	public static void captureScreenshot(String sTestCaseName, String snapshotType, String snapshotMessage)
			throws Exception {

		try {
			Log.info("Performing snapshot capture operation");
			if (snapshotType.equals("Pass")) {
				File scrFile = ((TakesScreenshot) Driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File(
						BaseClass.snapshotFolderPath + "\\Pass\\" + sTestCaseName + "_" + snapshotMessage + ".jpg"));
			} else if (snapshotType.equals("Fail")) {
				BaseClass.failedSnapshotFolderPath = BaseClass.snapshotFolderPath + "\\Fail\\" + sTestCaseName + "_"
						+ snapshotMessage + ".jpg";
				File scrFile = ((TakesScreenshot) Driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File(BaseClass.failedSnapshotFolderPath));
			}

		} catch (Exception e) {
			Log.error("Exception in Class Utils | Method captureScreenshot");
			Log.error("Issue in capturing the screenshot");
			throw e;
		}
	}

	public static void setSnapshotFolder() throws Exception {
		Log.info("Setting path for snapshot folder");
		try {
			String path = Utils.ReadProperties(Constant.Path_ConfigProperties).getProperty("Path_ScreenShot")
					+ "Test Results\\Run_" + Utils.getTimeStamp();
			BaseClass.snapshotFolderPath = path;
		} catch (Exception e) {
			Log.error("Exception in Class Utils | Method setSnapshotFolder");
			Log.error("Issue in setting snapshot folder");
			throw e;
		}

	}

	public static void archive_Old_Report() throws Exception {
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmm");
		String sdt = df.format(new Date(System.currentTimeMillis()));
		System.out.println(sdt.trim());
		String filename = "RevampSuiteReport" + sdt + ".pdf";
		System.out.println(filename);
		try {
			String source = Utils.ReadProperties(Constant.Path_ConfigProperties).getProperty("Report_Source");
			String destination = Utils.ReadProperties(Constant.Path_ConfigProperties).getProperty("Report_Destination");
			File input = new File(source);
			File output = new File(destination + filename);
			FileInputStream fis = new FileInputStream(input);
			BufferedInputStream bis = new BufferedInputStream(fis);
			OutputStream os = new BufferedOutputStream(new FileOutputStream(output));
			BufferedOutputStream bos = new BufferedOutputStream(os);
			byte[] buffer = new byte[128000];
			int bytesRead;
			// Simple read/write loop
			while (-1 != (bytesRead = bis.read(buffer, 0, buffer.length))) {
				bos.write(buffer, 0, bytesRead);
			}
		} catch (FileNotFoundException e) {
			System.err.println("File not found. Please scan in new file.");
			System.out.println(e);
			// throw e;
		}
	}

	public static String getTimeStamp() {
		Date d = Calendar.getInstance().getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String currentDate = sdf.format(d);
		return currentDate;
	}

	public static WebElement SendKeysJavaScript(WebElement element, String attributeN, String value) {

		JavascriptExecutor js = (JavascriptExecutor) Driver;
		js.executeScript("element.setAttribute(attributeN,value)");
		Log.info(" Present on the page");

		return element;
	}

	public static void PageHeaderCheck(String StaticPageName) throws Exception {
		String actualPageHeader = "";
		try {
			Log.info("Performing page header check operation");
			Utils.waitForPageLoadLongTime();
			Thread.sleep(5000);
			actualPageHeader = Driver.getTitle().toString();
			System.out.println(actualPageHeader);
			if (StaticPageName.equals(actualPageHeader)) {
				Log.info(StaticPageName + " Page Header found on the page");

			} else {
				BaseClass.errorValidation = BaseClass.errorValidation + "Expected Page Header -' " + StaticPageName
						+ "' does not match with Actual Page Header -'" + actualPageHeader + "'\n";
			}

		} catch (Exception e) {
			Log.error("Exception in Class Utils | Method PageHeaderCheck");
			Log.error(" Page Header not found on the page");
			throw e;
		}

	}

	public static void PageVerification_OnLinkClick(WebElement LinkElem, WebElement PageElem, String PageName)
			throws Exception {

		try {
			LinkElem.click();
			WebDriverWait wait = new WebDriverWait(Driver, 30);
			wait.until(ExpectedConditions.visibilityOf(PageElem));

		} catch (Exception e) {
			Log.error("Exception in Class Utils | Method PageVerification_OnLinkClick");
			Log.error("Element Not found on the page on clicking the Link");
			throw (e);

		}

	}

	public static void NewWindowAction() throws Exception {
		try {

			String handle = Driver.getWindowHandle();

			System.out.println(handle);

			java.util.Set<String> handles = Driver.getWindowHandles();

			System.out.println(handles);

			// Pass a window handle to the other window

			for (String handle1 : Driver.getWindowHandles()) {

				System.out.println(handle1);

				Driver.switchTo().window(handle1);
				System.out.println(Driver.getCurrentUrl());
			}
			Driver.close();
			Driver.switchTo().window(handle);
		} catch (Exception e) {
			Log.error("Exception in Class Utils | Method NewWindowAction");
			Log.error("Page Header not found on the page");
			throw (e);
		}

	}

	public static void NewWindowActionURLValidate(String url) throws Exception {
		System.out.println(url);
		try {
			String newWindowURL = null;
			String handle = Driver.getWindowHandle();

			System.out.println(handle);

			java.util.Set<String> handles = Driver.getWindowHandles();

			System.out.println(handles);

			// Pass a window handle to the other window

			for (String handle1 : Driver.getWindowHandles()) {
				Driver.switchTo().window(handle1);
				newWindowURL = Driver.getCurrentUrl();
			}
			if (!(newWindowURL.contains(url) || url.contains(newWindowURL))) {
				System.out.println("Url mismatched. Current URL is : " + newWindowURL);
				BaseClass.errorValidation += "Url mismatched. Current URL is : " + newWindowURL + "\n";
			}
			Driver.close();
			Driver.switchTo().window(handle);
		} catch (Exception e) {
			Log.error("Exception in Class Utils | Method NewWindowAction");
			Log.error("Page Header not found on the page");
			throw (e);
		}

	}

	/**
	 * The following method: Navigate to new window and Verify particular element
	 * present or not
	 * 
	 * @param url
	 * @throws Exception
	 */
	public static void NewWindowActionURLValidateWithURL(String url) throws Exception {
		// WebDriver Driver
		try {
			System.out.println("Expected " + url);
			String newWindowURL = null;
			String handle = Driver.getWindowHandle();
			System.out.println(handle);
			Set<String> handles = Driver.getWindowHandles();
			// System.out.println(handles);
			// Pass a window handle to the other window
			for (String handle1 : handles) {
				System.out.println("handleing " + handle1);
				Driver.switchTo().window(handle1);
			}
			waitForPageLoad();
			newWindowURL = Driver.getCurrentUrl();
			System.out.println("Actual url " + newWindowURL);
			if (!(newWindowURL.contains(url) || url.contains(newWindowURL))) {
				System.out.println("Url mismatched. Current URL is : " + newWindowURL);
				BaseClass.errorValidation += "Url mismatched. Current URL is : " + newWindowURL + "\n";
			}
			Driver.close();
			Thread.sleep(2000);
			Driver.switchTo().window(handle);
			waitForPageLoad();
		} catch (Exception e) {
			Log.error("Exception in Class Utils | Method NewWindowAction");
			Log.error("Page Header not found on the page");
			throw (e);
		}

	}

	/**
	 * The following method: Navigate to new window and Verify particular page title
	 * and switch to the parent window also
	 * 
	 * @param title text
	 * @throws Exception
	 */
	public static void NewWindowActionURLValidateWithPageTitle(String expectedTitle) throws Exception {
		// WebDriver Driver
		try {
			System.out.println("Expected " + expectedTitle);
			String expectedTitleLower = expectedTitle.toLowerCase();
			String[] oneWord = expectedTitleLower.split(" ");
			System.out.println(" First word " + oneWord[0]);
			String title = null;
			Log.info("Getting the current(parent window) value");
			String handle = Driver.getWindowHandle();
			System.out.println(handle);
			Log.info("Getting the get all windows handles");
			Set<String> handles = Driver.getWindowHandles();
			// Pass a window handle to the other window, switch to child window
			for (String handle1 : handles) {
				System.out.println("handleing " + handle1);
				Driver.switchTo().window(handle1);
			}
			Log.info("Wait for page load of new window");
			waitForPageLoad();
			Log.info("Get the page title of the new window and verify. If more than one word on"
					+ " the link text then split bases on space and change case to lower for both title and word also");
			title = Driver.getTitle();
			String titleLower = title.toLowerCase();
			System.out.println("Actual title " + title);
			System.out.println("Actual title with lower " + titleLower);
			if (!(title.contains(expectedTitle) || expectedTitle.contains(title) || titleLower.contains(oneWord[0])
					|| oneWord[0].contains(titleLower))) {
				System.out.println("Url mismatched. Current URL is : " + title);
				BaseClass.errorValidation += "Url mismatched. Current URL is : " + title + "\n";
			}
			Log.info("Close the new window");
			Driver.close();
			Thread.sleep(2000);
			Log.info("switch to parent window");
			Driver.switchTo().window(handle);
			waitForPageLoad();
		} catch (Exception e) {
			Log.error("Exception in Class Utils | Method NewWindowAction");
			Log.error("Page Header not found on the page");
			throw (e);
		}

	}

	// Wait for page completely load
	public static void waitForPageLoad() {
		Wait<WebDriver> wait = new WebDriverWait(Driver, 50);
		wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				System.out.println("Current Window State : "
						+ String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
				return String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
						.equals("complete");
			}
		});
	}
	//wait for load list of elements
		public static void waitForElements(List <WebElement> elements) throws Exception {
			try {
				Log.info("Waiting for the element to be clickable");
				WebDriverWait wait = new WebDriverWait(Driver, 40);
				wait.until(ExpectedConditions.elementToBeClickable(elements.get(0)));
			} catch (Exception e) {
				Log.error("Exception in Class Utils | Method waitForElement");
				Log.error("Issue in waiting for the element");
				throw e;
			}

		}
		
		//wait for load list of elements for long time
			public static void waitForElementsLongTime(List <WebElement> elements) throws Exception {
				try {
					Log.info("Waiting for the element to be clickable");
					WebDriverWait wait = new WebDriverWait(Driver, 300);
					//wait.until(ExpectedConditions.elementToBeClickable(elements.get(0)));
					wait.until(ExpectedConditions.visibilityOf(elements.get(0)));
					Log.info("elements is identified");
				} catch (Exception e) {
					Log.error("Exception in Class Utils | Method waitForElement");
					Log.error("Issue in waiting for the element");
					throw e;
				}

			}
		//  jenkins execution is not much faster like from eclipse so need to wait much time to load
		public static void waitForElementLongJenkinsIssue(WebElement element) throws Exception {
			try {
				Log.info("Waiting for the element to be clickable");
				WebDriverWait wait = new WebDriverWait(Driver, 300);
				wait.until(ExpectedConditions.elementToBeClickable(element));
				} catch (Exception e) {
				Log.error("Exception in Class Utils | Method waitForElement");
				Log.error("Issue in waiting for the element "+element);
				throw e;
			}

		}
		//element should not display
				public static void waitForElementLongNotVisible(WebElement element) throws Exception {
					try {
						Log.info("Waiting for the element to be clickable");
						WebDriverWait wait = new WebDriverWait(Driver, 180);
						wait.until(ExpectedConditions.invisibilityOf(element));
					} catch (Exception e) {
						Log.error("Exception in Class Utils | Method waitForElement");
						Log.error("Issue in waiting for the element "+element);
						throw e;
					}

				}
				
				//element should not display
				public static void waitForElementLongVisible(WebElement element) throws Exception {
					try {
						Log.info("Waiting for the element to be clickable");
						WebDriverWait wait = new WebDriverWait(Driver, 90);
						wait.until(ExpectedConditions.visibilityOf(element));
					} catch (Exception e) {
						Log.error("Exception in Class Utils | Method waitForElement");
						Log.error("Issue in waiting for the element "+element);
						throw e;
					}

				}
	public static void NewWindowPageHeaderValidation(String StaticPageName) throws Exception {
		try {

			String handle = Driver.getWindowHandle();

			System.out.println(handle);

			java.util.Set<String> handles = Driver.getWindowHandles();

			System.out.println(handles);

			// Pass a window handle to the other window

			for (String handle1 : Driver.getWindowHandles()) {

				System.out.println(handle1);

				Driver.switchTo().window(handle1);

			}
			Utils.PageHeaderCheck(StaticPageName);
			Driver.close();
			Driver.switchTo().window(handle);

		} catch (Exception e) {
			Log.error("Exception in Class Utils | Method NewWindowPageHeaderValidation");
			Log.error("Page Header not found on the page");
			throw (e);
		}
	}

	public static void CheckEnable(WebElement element) throws Exception {
		try {

			boolean actualValue = element.isEnabled();

			if (actualValue)
				System.out.println("Button is enabled");
			else
				System.out.println("Button is disabled");

		}

		catch (Exception e) {
			Log.error("Exception in Class Utils | Method CheckEnable");
			throw (e);
		}

	}

	public static boolean CheckEnability(WebElement element) throws Exception {
		try {
			Thread.sleep(1000);
			actualValue = element.isDisplayed();

			/*
			 * if (actualValue) System.out.println("element is enabled"); else
			 * System.out.println("element is disabled");
			 */

		}

		catch (Exception e) {
			Log.error("Exception in Class Utils | Method CheckEnability");
			throw (e);
		}

		return actualValue;

	}

	public static void takeScreenshot(WebDriver webdriver, String fileWithPath) throws Exception {
		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		// Move image file to new destination
		File DestFile = new File(fileWithPath);
		// Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);

	}

	public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {
		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		// Move image file to new destination
		File DestFile = new File(BaseClass.snapshotFolderPath + "\\Fail");
		// Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);

	}

	public static void scrollingToPageElement(WebElement element) {
		((JavascriptExecutor) Driver).executeScript("arguments[0].scrollIntoView();", element);

	}

	public static void scrollingToPageBottom(WebElement element) throws InterruptedException {
		((JavascriptExecutor) Driver).executeScript(
				"window.scrollTo(0, document.body.scrollHeight || document.documentElement.scrollHeight)", element);
		Thread.sleep(5000);
	}

	public static void scrollingToPageElementAdvanced(WebElement element) {
		Locatable element1 = (Locatable) element;
		Point p = element1.getCoordinates().onPage();
		System.out.println(p.getX());
		System.err.println(p.getY());
		JavascriptExecutor js = (JavascriptExecutor) Driver;
		js.executeScript("window.scrollTo(" + p.getX() + "," + p.getY() + ");");

	}

	public static void scrollingToPageElementByCordinate(int x, int y) {

		((JavascriptExecutor) Driver).executeScript("window.scrollTo(" + x + "," + y + ")");

	}

	public static void scrollingToPageElementByelement(WebElement element) {

		((JavascriptExecutor) Driver).executeScript("arguments[0].scrollIntoView();", element);

	}

	public static void scrollingByAction(WebElement element) {

		Actions builder = new Actions(Driver);
		builder.moveToElement(element).build().perform();

	}

	public static List<String> csvDataReader(String data) {
		System.out.println(data);
		List<String> testData = Arrays.asList(data.split("\\s*,\\s*"));
		return testData;

	}

	public static List<String> PriceDataReader(String data) {
		System.out.println(data);
		List<String> testData = Arrays.asList(data.split("\\s*-\\s*"));
		return testData;

	}

	public static Double decimalReaderFromString(String data) {
		Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
		Matcher matcher = regex.matcher(data);
		matcher.find();
		return Double.parseDouble(matcher.group());
	}

	public static String covertMillis(Long millis) {
		long hours = TimeUnit.MILLISECONDS.toHours(millis);
		millis -= TimeUnit.HOURS.toMillis(hours);
		long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
		millis -= TimeUnit.MINUTES.toMillis(minutes);
		long seconds = TimeUnit.MILLISECONDS.toSeconds(millis);
		return String.format("%02d:%02d:%02d", hours, minutes, seconds);
	}

	public static void highLight(WebElement element) {
		if (Driver instanceof JavascriptExecutor) {
			//((JavascriptExecutor) Driver).executeScript("arguments[0].style.border='3px solid blue'", element);
			((JavascriptExecutor) Driver).executeScript("arguments[0].setAttribute('style', 'border: 4px solid blue;');", element);
			}
	}

	public static void refresh() {
		// TODO Auto-generated method stub
		Driver.navigate().refresh();
	}

	// Highlight all elements no condition for element should display
	public static void HighlightAllElementOneByOneWithoutDisplay(List<WebElement> elements) throws Exception {
		for (WebElement element : elements) {
			if (Driver instanceof JavascriptExecutor) {
				((JavascriptExecutor) Driver).executeScript("arguments[0].style.border='3px solid blue'", element);
			}
		}
	}

	public static void rightClickOnElement(WebElement element) {

		Actions action = new Actions(Driver);
		action.contextClick(element);

	}

	public static void SelectDropdownByValue(WebElement mainElement, String value) throws Exception {
		try {
			Log.info("Hovering mouse on the element");
			Select rob = new Select(mainElement);
			List<WebElement> opt = rob.getOptions();
			try {
				for (WebElement e : opt) {
					System.out.println(e.getText());
					if (e.getText().equals(value)) {
						if (e.getAttribute("value").equals(value)) {
							rob.selectByVisibleText(value);
							System.out.println(e.getText() + " has been selected");
							break;
							
						} else {
							String value1 = e.getAttribute("value");
							rob.selectByValue(value1);
				           Thread.sleep(3000);
							break;
						}
					}
				}
				
			} catch (Exception e) {
				Log.error("unable to locate the city| store");
				throw e;
			}

		} catch (Exception e) {
			Log.error("Exception in Class Utils | Method SelectDropdownByValue");
			Log.error("Issue in hovering mouse on the element");
			throw e;
		}

	}
	//get one email and which append with some random number EX samba@gmail.com ouput samba135@gmail.com
	public static String generateRandomEmail(String email){
		String parts[]=email.split("@");
		parts[0]=parts[0]+new Random().nextInt(100000);
		email=parts[0]+"@"+parts[1];
		return email;
	}
	}

