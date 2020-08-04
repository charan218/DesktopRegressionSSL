
package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utility.Log;
import utility.Utils;

public class Home_Page extends BaseClass {
	private static WebElement element = null;
	private static List<WebElement> webElements = null;
	private static List<WebElement> elements = null;

	public Home_Page(WebDriver Driver) {
		super(Driver);
	}

	public static WebElement LoginRegister() throws Exception {

		try {
			Log.info("Locating LoginRegister element");
			element = Driver.findElement(By.xpath("//div[contains(@class,'user-container user-icons')]/ul/li[3]/a"));
			Utils.highLight(element);
			Log.info("Log IN element is found on the Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method LoginRegister");
			Log.error("Log IN element is not found on the Home Page");
			throw e;
		}

		return element;

	}

	public static WebElement personalInformationText() throws Exception {

		try {
			Log.info("Locating cookies popup on home page");
			element = Driver.findElement(By.xpath("//*[@class='profile_personal']/ul/li[3]/span"));
			Utils.waitForElementLongVisible(element);
			Utils.highLight(element);
			Log.info("cookies popup found on home page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method cookie_Popup");
			Log.error("cookies popup not found on home page");
			throw (e);
		}
		return element;
	}

	public static WebElement pesonalshopper() throws Exception {

		try {
			Log.info("Locating pesonalshopper element");
			element = Driver.findElement(By.xpath(
					"//li/a[@title='DISCOVER']/following-sibling::div/descendant::a[text()='Personal Shopper Service']"));
			Utils.highLight(element);
			Log.info("Log IN element is found on the Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method pesonalshopper");
			Log.error("pesonalshopper element is not found on the Home Page");
			throw e;
		}

		return element;

	}

	public static WebElement knowpesonalshopper() throws Exception {

		try {
			Log.info("Locating knowpesonalshopper element");
			element = Driver.findElement(By.xpath("//a[text()='Know Personal Shopper Service']"));
			Utils.highLight(element);
			Log.info("Log IN element is found on the Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method knowpesonalshopper");
			Log.error("knowpesonalshopper element is not found on the Home Page");
			throw e;
		}

		return element;

	}

	public static List<WebElement> NewArrivals() throws Exception {
		try {
			Log.info("Locating NewArrivals element");
			elements = Driver.findElements(By.xpath("//section[@class='new-arrivals']//li//div//a"));
			// MobileWeb.HighlightElements(elements);
			Log.info("NewArrivals is found on Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method NewArrivals");
			Log.error("NewArrivals Subscription alert is not found on the Home Page");
			throw e;
		}

		return elements;
	}

	public static List<WebElement> collegeEdit() throws Exception {
		try {
			Log.info("Locating collegeEdit element");
			elements = Driver.findElements(By.xpath(".//section[@class='left-right-view'] //*[@class='hidden-xs']//a"));
			// MobileWeb.HighlightElements(elements);
			Log.info("collegeEdit is found on Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method collegeEdit");
			Log.error("collegeEdit is not found on the Home Page");
			throw e;
		}

		return elements;
	}

	public static List<WebElement> MaroonText() throws Exception {

		try {
			Log.info("Locating Maroon Text element");
			elements = Driver.findElements(By.xpath("//*[@class='results_list']//li//a"));
			Utils.HighlightAllElementOneByOne(elements);
			Log.info("Maroon is found on the Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method MaroonText");
			Log.error("Maroon is not found on the home page");
			throw e;
		}

		return elements;

	}

	public static List<WebElement> StyleInspiration() throws Exception {
		try {
			Log.info("Locating StyleInspiration element");
			elements = Driver.findElements(By.xpath(".//div[@class='pic-holder']//a"));
			// MobileWeb.HighlightElements(elements);
			Log.info("StyleInspiration elements is found on Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method StyleInspiration");
			Log.error("StyleInspiration is not found on the Home Page");
			throw e;
		}

		return elements;
	}

	public static List<WebElement> StyleHub() throws Exception {
		try {
			Log.info("Locating StyleHub element");
			elements = Driver.findElements(By.xpath(".//ul[@class='style-hub-slider']//a"));
			// MobileWeb.HighlightElements(elements);
			Log.info("StyleHub elements is found on Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method StyleHub");
			Log.error("StyleHub is not found on the Home Page");
			throw e;
		}

		return elements;
	}

	public static List<WebElement> OfferZone() throws Exception {
		try {
			Log.info("Locating OfferZone elements");
			elements = Driver
					.findElements(By.xpath(".//div[@class='container container-responsive responsive-padzero']//a"));
			// MobileWeb.HighlightElements(elements);
			Log.info("OfferZone elements is found on Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method OfferZone");
			Log.error("OfferZone is not found on the Home Page");
			throw e;
		}

		return elements;
	}

	public static List<WebElement> FavBanner() throws Exception {
		try {
			Log.info("Locating FavBanner elements");
			elements = Driver.findElements(By.xpath(".//*[@id='promo-images']//a"));
			// MobileWeb.HighlightElements(elements);
			Log.info("FavBanner elements is found on Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method FavBanner");
			Log.error("FavBanner is not found on the Home Page");
			throw e;
		}

		return elements;
	}

	public static List<WebElement> FavBrands() throws Exception {
		try {
			Log.info("Locating FavBrands elements");
			elements = Driver.findElements(By.xpath(".//*[@class='fav-brands']//a"));
			// MobileWeb.HighlightElements(elements);
			Log.info("FavBrands elements is found on Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method FavBrands");
			Log.error("FavBrands is not found on the Home Page");
			throw e;
		}

		return elements;
	}

	public static WebElement LogOut() throws Exception {

		try {
			Log.info("Locating LogOut element");
			element = Driver.findElement(By.xpath("//a[contains(text(),'Sign Out')][2]"));

			Log.info("Log out element is found on the Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method LogOut");
			Log.error("Log out element is not found on the Home Page");
			throw e;
		}

		return element;

	}

	public static WebElement signOut() throws Exception {

		try {
			Log.info("Locating signOut element");
			element = Driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]"));
			Utils.highLight(element);
			Log.info("Log out element is found on the Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method signOut");
			Log.error("signOut  element is not found on the Home Page");
			throw e;
		}

		return element;

	}

	public static WebElement Register() throws Exception {

		try {
			Log.info("Locating Register element");
			element = Driver.findElement(By.linkText("REGISTER"));

			Log.info("REGISTER link is found on the Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method Register");
			Log.error("Register link is not found on the home page");
			throw e;
		}

		return element;

	}

	public static WebElement SignUp() throws Exception {

		try {
			Log.info("Locating SignUp element");
			element = Driver.findElement(By.xpath("//a[@class='register-tag' and text()='Sign up']"));
			Utils.highLight(element);
			Log.info("SignUp link is found on the Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method SignUp");
			Log.error("SignUp link is not found on the home page");
			throw e;
		}

		return element;

	}

	public static WebElement SignIn() throws Exception {

		try {
			Log.info("Locating SignIn element");
			element = Driver.findElement(By.xpath("//a[contains(text(),'Sign in')]"));
			Utils.highLight(element);
			Log.info("Sign In link is found on the Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method SignIn");
			Log.error("Sign In link is not found on the home page");
			throw e;
		}

		return element;

	}

	public static WebElement KnowMore_Btn() throws Exception {

		try {
			Log.info("Locating KnowMore_Btn element");
			element = Driver.findElement(By.xpath("//*[@id='content']/div[1]/div/div/div/div[1]/a"));

			Log.info("Know More link is found on the Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method KnowMore_Btn");
			Log.error("Know More link is not found on the home page");
			throw e;

		}

		return element;

	}

	public static WebElement Logout() {
		try {
			Log.info("Locating Logout element");
			element = Driver.findElement(By.xpath("//a[@class='logout-tag']"));
			Utils.highLight(element);
			Log.info("LOGOUT link is  found on the home page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method Logout");
			Log.error("LOGOUT link is not found on the home page");
			throw e;
		}
		return element;

	}

	public static WebElement OrderForm() throws Exception {
		try {
			Log.info("Locating OrderForm element");
			element = Driver.findElement(By.xpath("//a[contains(@href, '/orderForm')]"));
			Log.info("Order form link is found on the home page");
		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method OrderForm");
			Log.error("Order form link is not found on the home page");
			throw e;
		}

		return element;

	}

	public static WebElement MyAccount() throws Exception {

		try {
			Log.info("Locating MyAccount element");
			element = Driver.findElement(By.xpath("//div[@class='member-login-sign']//a[@class='account-tag']"));
			Utils.highLight(element);
			Log.info("MyAccount link is found on the Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method MyAccount");
			Log.error("MyAccount link is not found on the Home Page");
			throw e;
		}

		return element;

	}

	public static WebElement Catalogue() throws Exception {

		try {
			Log.info("Locating Catalogue element");
			element = Driver.findElement(By.linkText("Catalogue"));
			Utils.highLight(element);
			Log.info("catalogue link is found on the Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method Catalogue");
			Log.error("catalogue link is not found on the Home Page");
			throw e;
		}

		return element;

	}

	public static WebElement Products() throws Exception {

		try {
			Log.info("Locating Products element");
			element = Driver.findElement(By.xpath("//a[@href='#' and @title='Products']"));
			Utils.highLight(element);
			Log.info("Products link is found on the Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method Products");
			Log.error("Products link is not found on the Home Page");
			throw e;
		}

		return element;

	}

	public static WebElement Help() throws Exception {

		try {
			Log.info("Locating Help element");
			element = Driver.findElement(By.linkText("Help"));
			Utils.highLight(element);
			Log.info("Help Link found under top navigation Section");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method Help");
			Log.error("Help link is not found under top navigation  Section");

			throw (e);

		}
		return element;

	}

	public static class Footer_Section {

		static WebElement element;

		public static WebElement Help_FAQ() throws Exception {

			try {
				Log.info("Locating Help_FAQ element");

				element = Driver.findElement(By.xpath("//a[contains(@title, 'Help/FAQs')]"));
				Utils.highLight(element);

				Log.info("Help/FAQ Link found under Footer Section");

			} catch (Exception e) {
				Log.error("Exception in Class Home_Page | Method Help_FAQ");
				Log.error("Help/FAQ link is not found under  Footer Section");

				throw (e);

			}
			return element;

		}

		public static WebElement footer() throws Exception {

			try {
				Log.info("Locating footer element");
				element = Driver.findElement(By.xpath("//div[@class='foot-links']"));
				Utils.waitForElementLongVisible(element);
				Utils.highLight(element);
				Log.info("footer  Link found under Footer Section");

			} catch (Exception e) {
				Log.error("Exception in Class Home_Page | Method footer");
				Log.error("footer link is not found under  Footer Section");

				throw (e);

			}
			return element;

		}
		public static WebElement Track_Order() throws Exception {

			try {
				Log.info("Locating Track_Order element");
				element = Driver.findElement(By.cssSelector("a[href='/trackorders'][title='Track Order']"));
				Utils.highLight(element);
				Log.info("Track Order Link found under Footer Section");

			} catch (Exception e) {
				Log.error("Exception in Class Home_Page | Method Track_Order");
				Log.error("Track order link is not found under  Footer Section");

				throw (e);

			}
			return element;

		}

		public static WebElement Size_Guide() throws Exception {

			try {
				Log.info("Locating Size_Guide element");
				element = Driver.findElement(By.xpath("(//a[contains(@title, 'Size Guide')])[2]"));
				Utils.highLight(element);
				Log.info("Size Guide Link found under Footer Section");

			} catch (Exception e) {
				Log.error("Exception in Class Home_Page | Method Size_Guide");
				Log.error("Size Guide link is not found under  Footer Section");

				throw (e);

			}
			return element;

		}

		public static WebElement Buying_Guide() throws Exception {

			try {
				Log.info("Locating Buying_Guide element");
				element = Driver.findElement(By.xpath("(//a[contains(@title, 'Buying Guide')])[2]"));
				Utils.highLight(element);
				Log.info("Buying Guide Link found under Footer Section");

			} catch (Exception e) {
				Log.error("Exception in Class Home_Page | Method Buying_Guide");
				Log.error("Buying Guide link is not found under  Footer Section");

				throw (e);

			}
			return element;

		}

		public static WebElement How_To_Buy() throws Exception {

			try {
				Log.info("Locating How_To_Buy element");
				element = Driver.findElement(By.xpath("//a[contains(@title, 'How do i shop?')]"));
				Utils.highLight(element);
				Log.info("How Do I Buy? Link found under Footer Section");

			} catch (Exception e) {
				Log.error("Exception in Class Home_Page | Method How_To_Buy");
				Log.error("How Do I Buy? link is not found under  Footer Section");

				throw (e);

			}
			return element;

		}

		public static WebElement How_To_Pay() throws Exception {

			try {
				Log.info("Locating How_To_Pay element");
				element = Driver.findElement(By.xpath("//a[contains(@title, 'How do i pay?')]"));
				Utils.highLight(element);
				Log.info("How Do I Buy? Link found under Footer Section");

			} catch (Exception e) {
				Log.error("Exception in Class Home_Page | Method How_To_Pay");
				Log.error("How Do I Buy? link is not found under  Footer Section");
				Utils.highLight(element);
				throw (e);

			}
			return element;

		}

		public static WebElement Place_We_Deliever() throws Exception {

			try {
				Log.info("Locating Place_We_Deliever element");
				element = Driver.findElement(By.xpath("(//a[contains(@title, 'Find places we deliver')])[2]"));
				Utils.highLight(element);
				Log.info("Find places we deliver Link found under Footer Section");

			} catch (Exception e) {
				Log.error("Exception in Class Home_Page | Method Place_We_Deliever");
				Log.error("Find places we deliver link is not found under Footer Section");

				throw (e);

			}
			return element;

		}

		// public static WebElement Blog() throws Exception {

		// try {
		// Log.info("Locating Blog element");
		// element = Driver.findElement(By.xpath("//a[contains(@title, 'Blog')]"));

		// Log.info("Blog Link found under Footer Section");

		// } catch (Exception e) {
		// Log.error("Exception in Class Home_Page | Method Blog");
		// Log.error("Blog link is not found under Footer Section");

		// throw (e);

		// }
		// return element;

		// }

		public static WebElement TermsAndConditions() throws Exception {

			try {
				Log.info("Locating TermsAndConditions element");
				element = Driver.findElement(By.xpath("//a[contains(@title, 'Terms of use')]"));
				Utils.highLight(element);
				Log.info("Terms & Conditions  Link found under Footer Section");

			} catch (Exception e) {
				Log.error("Exception in Class Home_Page | Method TermsAndConditions");
				Log.error("Terms & Conditions  link is not found under  Footer Section");

				throw (e);

			}
			return element;

		}

		public static WebElement Privacy() throws Exception {

			try {
				Log.info("Locating Privacy element");
				element = Driver.findElement(By.xpath("//a[contains(@title, 'Privacy')]"));
				Utils.highLight(element);
				Log.info("Privacy Link found under Footer Section");

			} catch (Exception e) {
				Log.error("Exception in Class Home_Page | Method Privacy");
				Log.error("Privacy link is not found under  Footer Section");

				throw (e);

			}
			return element;

		}

		public static WebElement Shipping_Policy() throws Exception {

			try {
				Log.info("Locating Shipping_Policy element");
				element = Driver.findElement(By.xpath("//a[contains(@title, 'Delivery Policy')]"));
				Utils.highLight(element);
				Log.info("Shipping Policy Link found under Footer Section");

			} catch (Exception e) {
				Log.error("Exception in Class Home_Page | Method Shipping_Policy");
				Log.error("Shipping Policy link is not found under  Footer Section");

				throw (e);

			}
			return element;

		}

		public static WebElement Exchange_Returns() throws Exception {

			try {
				Log.info("Locating Exchange_Returns element");
				element = Driver.findElement(By.xpath("//a[contains(@title, 'Exchanges & Returns')]"));
				Utils.highLight(element);
				Log.info("Exchange Returns Link found under Footer Section");

			} catch (Exception e) {
				Log.error("Exception in Class Home_Page | Method Exchange_Returns");
				Log.error("Exchange Returns link is not found under  Footer Section");

				throw (e);

			}
			return element;
		}

		public static WebElement AboutUs() throws Exception {

			try {
				Log.info("Locating AboutUs element");
				element = Driver.findElement(By.xpath("//a[@title='About us']"));
				Utils.highLight(element);
				Log.info("AboutUs Link found under Footer Section");

			} catch (Exception e) {
				Log.error("Exception in Class Home_Page | Method AboutUs");
				Log.error("AboutUs link is not found under  Footer Section");

				throw (e);

			}
			return element;

		}
		
		////////////////
		public static WebElement Contact_Us() throws Exception {

			try {
				Log.info("Locating Contact Us element");
				element = Driver.findElement(By.xpath("//a[@title='Contact Us']"));
				Utils.highLight(element);
				Log.info("Contact Us Link found under Footer Section");

			} catch (Exception e) {
				Log.error("Exception in Class Home_Page | Method Contact Us");
				Log.error("Contact Us link is not found under  Footer Section");

				throw (e);

			}
			return element;

		}
		
		public static WebElement Careers() throws Exception {

			try {
				Log.info("Locating Careers element");
				element = Driver.findElement(By.xpath("//a[@title='Careers']"));
				Utils.highLight(element);
				Log.info("Careers Link found under Footer Section");

			} catch (Exception e) {
				Log.error("Exception in Class Home_Page | Method Careers");
				Log.error("Careers link is not found under  Footer Section");

				throw (e);

			}
			return element;

		}
		///////////////////////

		public static WebElement Corporate_Site() throws Exception {

			try {
				Log.info("Locating Corporate_Site element");
				element = Driver.findElement(By.xpath("//a[contains(@title, 'Corporate Site')]"));
				Utils.highLight(element);
				Log.info("Corporate Site Link found under Footer Section");

			} catch (Exception e) {
				Log.error("Exception in Class Home_Page | Method Corporate_Site");
				Log.error("Corporate Site link is not found under  Footer Section");

				throw (e);

			}
			return element;

		}

		public static WebElement Store_Locator() throws Exception {

			try {
				Log.info("Locating Store_Locator element");
				element = Driver.findElement(By.xpath("//a[contains(@title, 'Store locator')]"));
				Utils.highLight(element);
				Log.info("Store Locator Link found under Footer Section");

			} catch (Exception e) {
				Log.error("Exception in Class Home_Page | Method Store_Locator");
				Log.error("Store Locator link is not found under  Footer Section");

				throw (e);

			}
			return element;

		}

		public static WebElement First_Citizen() throws Exception {

			try {
				Log.info("Locating First_Citizen element");
				//
				element = Driver.findElement(By.cssSelector("li.yCmsComponent>a[href='/first-citizen/non-member']"));
				//
				Utils.highLight(element);
				Log.info("First Citizen Link found under Footer Section");

			} catch (Exception e) {
				Log.error("Exception in Class Home_Page | Method First_Citizen");
				Log.error("First Citizen link is not found under  Footer Section");

				throw (e);

			}
			return element;

		}

		public static WebElement Instant_Gifting() throws Exception {

			try {
				Log.info("Locating Instant_Gifting element");
				element = Driver.findElement(By.xpath("//a[@title='Instant Gifting']"));
				Utils.highLight(element);
				Log.info("Instant Gifting Link found under Footer Section");

			} catch (Exception e) {
				Log.error("Exception in Class Home_Page | Method Instant_Gifting");
				Log.error("Instant Gifting link is not found under  Footer Section");

				throw (e);

			}
			return element;

		}

		public static WebElement Toll_Free() throws Exception {

			try {
				Log.info("Locating Toll_Free element");
				element = Driver.findElement(By.xpath("//a[contains(@title, '#1-800-419-6648 (toll free)')]"));
				Utils.highLight(element);
				Log.info("Toll Free Contact Link found under Footer Section");

			} catch (Exception e) {
				Log.error("Exception in Class Home_Page | Method Toll_Free");
				Log.error("Toll Free Contact link is not found under  Footer Section");

				throw (e);

			}
			return element;

		}

		public static WebElement Phone_Number() throws Exception {

			try {
				Log.info("Locating Phone_Number element");
				element = Driver.findElement(By.xpath("//a[contains(@title, '+91-22-61290400')]"));
				Utils.highLight(element);
				Log.info("Contact Number Link found under Footer Section");

			} catch (Exception e) {
				Log.error("Exception in Class Home_Page | Method Phone_Number");
				Log.error("Contact Number link is not found under  Footer Section");

				throw (e);

			}
			return element;

		}

		public static WebElement Estore_Link() throws Exception {

			try {
				Log.info("Locating Estore_Link element");
				element = Driver.findElement(By.xpath("//a[contains(@title, 'customercare@shoppersstop.com')]"));
				Utils.highLight(element);
				Log.info("Store email id Link found under Footer Section");

			} catch (Exception e) {
				Log.error("Exception in Class Home_Page | Method Estore_Link");
				Log.error("Store email id link is not found under  Footer Section");

				throw (e);

			}
			return element;

		}

		public static WebElement Facebook_Link() throws Exception {
			try {
				Log.info("Locating Facebook_Link element");
				element = Driver.findElement(By.xpath("//*[@class='facebook-icon']/a"));
				Utils.highLight(element);
				Log.info("Facebook Link found under Footer Section");

			} catch (Exception e) {
				Log.error("Exception in Class Home_Page | Method Facebook_Link");
				Log.error("Facebook link is not found under  Footer Section");

				throw (e);

			}
			return element;
		}

		public static WebElement Instagram_Link() throws Exception {
			try {
				Log.info("locating Instagram Link");
				element = Driver.findElement(By.xpath("//*[@class='instagram-icon']/a"));
				Utils.highLight(element);
				Log.info("Located Instagram Link");
			} catch (Exception ex) {
				Log.info("Unable to locate Instagram Link on Home Page || Method Instagram_Link");
				throw new Exception("Unable to locate Instagram Link on Home Page || Method Instagram_Link");
			}
			return element;
		}

		public static WebElement Twitter_Link() throws Exception {
			try {
				Log.info("Locating Twitter_Link element");
				Thread.sleep(1000);
				element = Driver.findElement(By.xpath("//*[@class='twitter-icon']/a"));
				Utils.highLight(element);
				Log.info("Twitter Link found under Footer Section");

			} catch (Exception e) {
				Log.error("Exception in Class Home_Page | Method Twitter_Link");
				Log.error("Twitter link is not found under  Footer Section");

				throw (e);

			}
			return element;
		}

		public static WebElement Pinterest_Link() throws Exception {
			try {
				Log.info("Locating Pinterest_Link element");
				element = Driver.findElement(By.xpath("//*[@class='pinterest-icon']/a"));
				Utils.highLight(element);
				Log.info("Pinterest Link found under Footer Section");

			} catch (Exception e) {
				Log.error("Exception in Class Home_Page | Method Pinterest_Link");
				Log.error("Pinterest link is not found under  Footer Section");

				throw (e);

			}
			return element;
		}

		public static WebElement GooglePlus_Link() throws Exception {
			try {
				Log.info("Locating GooglePlus_Link element");
				element = Driver.findElement(By.xpath("//*[@class='google-plus-icon']/a"));
				Utils.highLight(element);
				Log.info("GooglePlus Link found under Footer Section");

			} catch (Exception e) {
				Log.error("Exception in Class Home_Page | Method GooglePlus_Link");
				Log.error("GooglePlus link is not found under  Footer Section");

				throw (e);

			}
			return element;
		}

	}

	public static WebElement Search_Box() throws Exception {

		try {
			Log.info("Locating Search_Box element");
			element = Driver.findElement(By.id("js-site-search-input"));
			Utils.highLight(element);
			Log.info("search box field is found on the Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method Search_Box");
			Log.error("search box field is not found on the home page");
			throw e;
		}

		return element;

	}

	public static WebElement Search_Btn() throws Exception {

		try {
			Log.info("Locating Search_Btn element");
			element = Driver.findElement(By.xpath("//*[@id='searchbox']/div/form/div/div/button"));
			Utils.highLight(element);
			Log.info("Search button is found on the Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method Search_Btn");
			Log.error("Search button is not found on the home page");
			throw e;
		}

		return element;

	}

	public static WebElement WelcomeNote() throws Exception {

		try {
			Log.info("Locating WelcomeNote element");
			element = Driver.findElement(By.xpath("//*[@id='loggedin']/ul/span[1]/li"));
			Utils.highLight(element);
			Log.info("Welcome note is found on the Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method WelcomeNote");
			Log.error("Welcome note is not found on the home page");
			throw e;
		}

		return element;

	}

	public static WebElement LogInUserName(String username) throws Exception {

		try {
			Log.info("Locating LogInUserName element");
			element = Driver.findElement(By.xpath("//a[contains(text(),'" + username + "')]"));
			Utils.highLight(element);
			Log.info("Log in username is found on the Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method LogInUserName");
			Log.error("Log in username is not found on the home page");
			throw e;
		}

		return element;

	}

	public static WebElement profileLink() throws Exception {

		try {
			Log.info("Locating profileLink element");
			element = Driver.findElement(By.xpath("//a[starts-with(text(), 'Profile')]"));
			Utils.highLight(element);
			Log.info("Profile link is found on the Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method profileLink");
			Log.error("Profile link is not found on the home page");
			throw e;
		}

		return element;

	}

	public static WebElement headerStoreLocatorIcon() throws Exception {

		try {
			Log.info("Locating headerStoreLocatorIcon element");
			element = Driver.findElement(By.xpath("//a[@href='/store-finder']"));
			Utils.highLight(element);
			Log.info("Store locator icon is found on the Header on Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method headerStoreLocatorIcon");
			Log.error("Store locator icon  is not found on the Header on home page");
			throw e;

		}

		return element;

	}

	public static WebElement headerTrackOrder() throws Exception {

		try {
			Log.info("Locating headerTrackOrder element");
			element = Driver.findElement(By.xpath("//a[@href='/trackorders']"));
			Utils.highLight(element);
			Log.info("Track Order icon is found on the Header on Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method headerTrackOrder");
			Log.error("Track Order icon  is not found on the Header on home page");
			throw e;
		}

		return element;

	}

	public static WebElement headerSoppersStopLogo() throws Exception {

		try {
			Log.info("Locating headerSoppersStopLogo element");
			element = Driver.findElement(By.cssSelector(".logo>a"));
			Utils.highLight(element);
			Log.info("Shoppers Stop logo is found on the Header on Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method headerSoppersStopLogo");
			Log.error("Shoppers Stop logo is not found on the Header on Home Page");
			throw e;
		}

		return element;

	}

	public static WebElement miniCartSSlogo() throws Exception {

		try {
			Log.info("Locating miniCartSSlogo element");
			element = Driver.findElement(By.xpath("//header[@class='cp-header']/a"));
			Utils.highLight(element);
			Log.info("Shoppers Stop logo is found on the Header on miniCart Page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method miniCartSSlogo");
			Log.error("Shoppers Stop logo is not found on the Header on miniCart Page");
			throw e;
		}

		return element;

	}

	public static WebElement headerInfoBar() throws Exception {

		try {
			Log.info("Locating header Info Bar element");
			element = Driver.findElement(By.xpath("//div[@id='header-info-bar']/div/div/div/p"));
			Utils.highLight(element);
			Log.info("headerInfoBar is found on the Header on Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method header Info Bar");
			Log.error("header Info Bar is not found on the Header on Home Page");
			throw e;
		}

		return element;

	}

	public static WebElement headerSoppersStopLogocheckout() throws Exception {

		try {
			Log.info("Locating headerSoppersStopLogo element");
			element = Driver.findElement(By.xpath("//a[@href='/']"));
			Utils.highLight(element);
			Log.info("Shoppers Stop logo is found on the Header on Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method headerSoppersStopLogo");
			Log.error("Shoppers Stop logo is not found on the Header on Home Page");
			throw e;
		}

		return element;

	}

	public static WebElement menuSubCategoryFilter(String categoryTitle, String subCategoryTitle) throws Exception {
		try {
			Log.info("Locating menuSubCategory element");
			element = Driver.findElement(By.xpath("//a[@title='" + categoryTitle
					+ "']/following-sibling::div//a[contains(@href, 'women-westernwear/c-A2060')]"));
			Utils.highLight(element);
			Log.info("Sub Menu Category is found on Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method menuSubCategory");
			Log.error("Sub Menu Category is not found on Home Page");
			throw e;
		}

		return element;
	}

	public static WebElement headerNotificationIcon() throws Exception {

		try {
			Log.info("Locating headerNotificationIcon element");
			element = Driver.findElement(By.xpath("*//div[contains(@class,'user-icons')]/ul/li/a[@class='alerts']"));
			Utils.highLight(element);
			Log.info("Notification icon is found on the Header on Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method headerNotificationIcon");
			Log.error("Notification icon is not found on the Header on Home Page");
			throw e;
		}

		return element;

	}

	public static WebElement headerWishlistIcon() throws Exception {

		try {
			Log.info("Locating headerWishlistIcon element");
			element = Driver.findElement(By.xpath("//a[@href='/wishlist']"));
			Utils.highLight(element);
			Log.info("Notification icon is found on the Header on Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method headerWishlistIcon");
			Log.error("Notification icon is not found on the Header on Home Page");
			throw e;
		}

		return element;
	}

	public static WebElement MoveToBag() throws Exception {

		try {
			Log.info("Locating MoveToBag element");
			Utils.waitForPageLoad();
			Thread.sleep(2000);
			element = Driver.findElement(By.xpath("//a[@class='mvbtn movetoBag d-block' and text()='MOVE TO BAG']"));
			Utils.highLight(element);
			Log.info("MoveToBag  is found on wishlist ");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method MoveToBag");
			Log.error("MoveToBag  is not found on the wish List");
			throw e;
		}

		return element;

	}

	public static WebElement done() throws Exception {

		try {
			Log.info("Locating done element");
			Utils.waitForPageLoad();
			Thread.sleep(2000);
			element = Driver.findElement(By.xpath("//input[@class='mvbtn done d-block']"));
			Utils.highLight(element);
			Log.info("done  is found on wishlist ");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method done");
			Log.error("done  is not found on the wish List");
			throw e;
		}

		return element;

	}

public static List<WebElement> selectSize() throws Exception {

		try {
			Log.info("Locating size element");
			Utils.waitForPageLoad();
			Thread.sleep(2000);
			elements = Driver.findElements(By.xpath("//ul[@class='mv-wishlist-sizes']/li"));
			Log.info("size  is found on wishlist ");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method selectSize");
			Log.error("selectSize  is not found on the wish List");
			throw e;
		}

		return elements;

	}
	public static WebElement headerWishlistItemCountIcon() throws Exception {

		try {
			Log.info("Locating headerWishlistItemCountIcon element");
			element = Driver
					.findElement(By.xpath("//a[@class='wishlist' and @href='/wishlist']/following-sibling::span"));
			Utils.highLight(element);
			Log.info("Notification icon is found on the Header on Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method headerWishlistItemCountIcon");
			Log.error("Notification icon is not found on the Header on Home Page");
			throw e;
		}

		return element;

	}

	public static WebElement headerMiniCartIcon() throws Exception {

		try {
			Log.info("Locating headerMiniCartIcon element");
			element = Driver.findElement(By.xpath("//*[contains(@class,'minicart') or @id='minicart_id']"));
			Utils.highLight(element);
			Log.info("Notification icon is found on the Header on Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method headerMiniCartIcon");
			Log.error("Notification icon is not found on the Header on Home Page");
			throw e;
		}

		return element;

	}

	public static WebElement contactUs() throws Exception {

		try {
			Log.info("Locating contactUs element");
			element = Driver.findElement(By.xpath("//a[@href='/contactUs']"));
			Utils.highLight(element);
			Log.info("contactUs icon is found on the Header on Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method contactUs");
			Log.error("contactUs icon is not found on the Header on Home Page");
			throw e;
		}

		return element;

	}

	public static WebElement headerMiniCartIconclose() throws Exception {

		try {
			Log.info("Locating headerMiniCartIcon element");
			element = Driver.findElement(By.xpath("//*[@id='removeEntry_0']"));
			Utils.highLight(element);
			Log.info("close button found on the Header on Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method headerMiniCartIcon");
			Log.error("Notification icon is not found on the Header on Home Page");
			throw e;
		}

		return element;

	}

	public static WebElement headerMiniCartItemCountIcon() throws Exception {

		try {
			Log.info("Locating headerMiniCartItemCountIcon element");
			element = Driver.findElement(By.xpath("//span[@class='qtyHeaderMinicart']"));
			Utils.highLight(element);
			Log.info("Item Count icon is found on the mini cart Header on Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method headerMiniCartItemCountIcon");
			Log.error("Item Count icon is not found on the mini cart Header on Home Page");
			throw (e);
		}

		return element;

	}

	public static WebElement headerWishlistMenuHeading() throws Exception {
		try {
			Log.info("Locating headerWishlistMenuHeading element");
			element = Driver.findElement(By.xpath(".//*[@id='wish-scroller']/h3"));
			Utils.highLight(element);
			Log.info("Wishlist alert heading is found on Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method headerWishlistMenuHeading");
			Log.error("Wishlist alert heading is not found on the Home Page");
			throw e;
		}

		return element;
	}

	public static WebElement headerWishlistMenuText() throws Exception {
		try {
			Log.info("Locating headerWishlistMenuText element");
			element = Driver.findElement(By.xpath(".//*[@id='wish-scroller']/div/p"));
			Utils.highLight(element);
			Log.info("Wishlist alert text is found on Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method headerWishlistMenuText");
			Log.error("Wishlist alert text is not found on the Home Page");
			throw e;
		}

		return element;

	}

	public static WebElement headerWishlistUserMenu() throws Exception {
		try {
			Log.info("Locating headerWishlistUserMenu elements");
			element = Driver.findElement(By.xpath("//span[@class='count wish-count']"));
			Utils.highLight(element);
			Log.info("Wishlist user menu is found on Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method headerWishlistUserMenu");
			Log.error("Wishlist user menu is not found on the Home Page");
			throw e;
		}

		return element;
	}

	public static WebElement productListHeading() throws Exception {
		try {
			Log.info("Locating productListHeading element");
			element = Driver.findElement(By.xpath("//div[@class='pro-list-heading col-md-4 search-result']/h1"));

			Log.info("Product List Heading is found on Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method productListHeading");
			Log.error("Product List Heading is not found on the Home Page");
			throw e;

		}
		return element;
	}

	public static WebElement seeAllSearchResultButton() throws Exception {
		try {
			Log.info("Locating seeAllSearchResultButton element");
			element = Driver.findElement(By.id("searchAll"));
			Log.info("See All Search Result button is found on Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method seeAllSearchResultButton");
			Log.error("See All Search Result button is not found on the Home Page");
			throw e;
		}
		return element;
	}

	public static WebElement menuSubCategoryClinique(String categoryTitle, String subCategoryTitle) throws Exception {
		try {
			Log.info("Locating menuSubCategory element");
			element = Driver.findElement(By.xpath(
					"//a[@title='" + categoryTitle + "']/following-sibling::div//a[contains(@href, 'brand/all')]"));
			Utils.highLight(element);
			Log.info("Sub Menu Category is found on Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method menuSubCategory");
			Log.error("Sub Menu Category is not found on Home Page");
			throw e;
		}

		return element;
	}

	public static WebElement Clinique() throws Exception {

		try {
			Log.info("Locating Clinique Brand element");
			// element = Driver.findElement(By.xpath("//a[contains(@href,'clinique')]"));
			element = Driver.findElement(By.xpath("//a[contains(@href,'clinique?categoryCode=')]"));
			Utils.highLight(element);
			Log.info("Clinique Brand element is found on the Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method Clinique");
			Log.error("Clinique Brand element is not found on the Home Page");
			throw e;
		}

		return element;

	}

	public static WebElement headerNotificationAlert() throws Exception {
		try {
			Log.info("Locating headerNotificationAlert element");
			element = Driver.findElement(By.xpath("//div[@class='alert-wrap']/h3"));
			Utils.highLight(element);
			Actions action = new Actions(Driver);
			action.moveToElement(element).perform();
			Log.info("Wishlist alert is found on Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method headerNotificationAlert");
			Log.error("Wishlist alert is not found on the Home Page");
			throw e;
		}

		return element;
	}

	public static WebElement menuCategory(String categoryTitle) throws Exception {
		try {
			Log.info("Locating menuCategory element");
			element = Driver.findElement(By.xpath("//a[@title='" + categoryTitle + "']"));
			Utils.highLight(element);
			Actions action = new Actions(Driver);
			action.moveToElement(element).perform();
			Log.info("Menu Category is found on Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method menuCategory");
			Log.error("Menu Category is not found on Home Page");
			throw e;
		}

		return element;
	}

	public static WebElement menuSubCategory(String categoryTitle, String subCategoryTitle) throws Exception {
		try {
			Log.info("Locating menuSubCategory element");
			System.out.println(
					"//a[@title='" + categoryTitle + "']/following-sibling::div//a[@title='" + subCategoryTitle + "']");
			element = Driver.findElement(By.xpath("//a[@title='" + categoryTitle
					+ "']/following-sibling::div//a[contains(text(), '" + subCategoryTitle + "')]"));
//			element = Driver.findElement(By.xpath("//a[@title='" + categoryTitle + "']/following-sibling::div//a[@title='" + subCategoryTitle + "']"));
			Utils.highLight(element);
			Log.info("Sub Menu Category is found on Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method menuSubCategory");
			Log.error("Sub Menu Category is not found on Home Page");
			throw e;
		}

		return element;
	}

	public static WebElement menuSubCategoryMain(String categoryTitle, String subCategoryMainTitle) throws Exception {
		try {
			Log.info("Locating menuSubCategory element");
			element = Driver.findElement(By.xpath("//a[@title='" + categoryTitle
					+ "']/following-sibling::div//span/a[text()='" + subCategoryMainTitle + "']"));
			Log.info("Sub Menu Category main span is found on Home Page");
			Utils.highLight(element);
		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method menuSubCategoryMain");
			Log.error("Sub Menu Category main span is not found on Home Page");
			throw e;
		}

		return element;
	}

	public static WebElement NewsletterEmail() throws Exception {
		try {
			Log.info("Locating NewsletterEmail element");
			element = Driver.findElement(By.xpath(".//*[@id='newsletterEmail']"));
			Utils.highLight(element);
			Log.info("Newsletter Email subscribe field is found on Grid Box Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Static_Page | Method NewsletterEmail");
			Log.error("Newsletter Email subscribe is not found on Grid Box Home Page");
			throw (e);
		}
		return element;

	}

	public static WebElement NewsLetterButton() throws Exception {
		try {
			Log.info("Locating NewsLetterButton element");

			// System.out.println(Driver.findElement(By.xpath("html/body/main/footer/div[2]/div/div/div[2]")).getLocation());

			element = Driver.findElement(By.id("newLetterButton"));
			Utils.highLight(element);
			Log.info("Newsletter Subscribe Button is found on Grid Box Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Static_Page | Method NewsLetterButton");
			Log.error("Newsletter Subscribe Button is not found on Grid Box Home Page");
			throw (e);
		}
		return element;

	}

	public static WebElement NewsLetterAlert() throws Exception {
		try {
			Log.info("Locating NewsLetterAlert element");
			element = Driver.findElement(By.xpath(".//*[@id='newsletterSubmitForm']//span"));
			Utils.highLight(element);
			Log.info("NewsLetter Subscription alert is found on Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Static_Page | Method NewsLetterAlert");
			Log.error("NewsLetter Subscription alert is not found on the Home Page");
			throw e;
		}

		return element;
	}

	public static WebElement result_Product() throws Exception {

		try {
			Log.info("Locating Product link on PLP");

//			element = Driver.findElement(By.xpath("(.//*[@id='primaryImage'])"));
//			element = Driver.findElement(By.xpath("//img[@class=' lazyloaded']"));
			// element = Driver.findElement(By.xpath(".//*[@id='primaryImage']"));
			//element = Driver.findElement(By.xpath("(//*[@class='price_div'])[1]"));
			element = Driver.findElement(By.xpath("(//*[@class='price_div'])[1]"));
			Utils.highLight(element);
			Log.info("Product link found on PLP");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method product101");
			Log.error("product101 link not found on PLP");
			throw (e);
		}
		return element;
	}

	public static WebElement cookie_Popup() throws Exception {

		try {
			Log.info("Locating cookies popup on home page");
			element = Driver.findElement(By.xpath("//div[contains(@class,'close cookieExitButton')]"));
			Utils.highLight(element);
			Log.info("cookies popup found on home page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method cookie_Popup");
			Log.error("cookies popup not found on home page");
			throw (e);
		}
		return element;
	}

	// Shoppersstop.com: Shop Anytime, Anywhere! all Paragraph links
	public static List<WebElement> footerDescriptionLinks() {
		try {
			Log.info("Locating Shoppersstop.com: Shop Anytime, Anywhere! all Paragraph links");
			elements = Driver.findElements(
					By.xpath("//h4[contains(.,'Shoppersstop.com: Shop Anytime, Anywhere!')]/./following-sibling::p/a"));
			Log.info("NewArrivals is found on Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method footerDescriptionLinks");
			Log.error("footerDescriptionLinks is not found on the Home Page");
			throw e;
		}

		return elements;
	}

	// Shoppersstop.com: Shop Anytime, Anywhere! text
	public static WebElement footerShopAnytimeAnywhereTxt() {
		try {
			Log.info("Shoppersstop.com: Shop Anytime, Anywhere! text");
			element = Driver.findElement(By.xpath("//h4[contains(.,'Shoppersstop.com: Shop Anytime, Anywhere!')]"));
			// MobileWeb.HighlightElements(elements);
			Log.info("NewArrivals is found on Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method footerDescriptionLinks");
			Log.error("footerDescriptionLinks is not found on the Home Page");
			throw e;
		}

		return element;
	}

	public static WebElement Footer_AllRightsReserved() {
		try {
			Log.info("Locating AllRightsReserved Text on home page");
			element = Driver.findElement(
					By.xpath("//div[@class='copyrights']/descendant::div[@class='col-md-12 col-lg-12 col-mobile']/p"));
			Utils.highLight(element);
			Log.info("AllRightsReserved text found on home page");
		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method  Footer_AllRightsReserved");
			Log.error("AllRightsReserved Text not found on home page");
			throw (e);
		}
		return element;
	}

	public static WebElement get_FirstCitizen_Link() {
		try {
			Log.info("Locating First Citizen link on home page");
			element = Driver.findElement(By.xpath("//a[@title='FIRST CITIZEN']"));
			System.out.println(" First Citizen link is found");
			Utils.highLight(element);

			Log.info("First Citizen link found on home page");
		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method  get_FirstCitizen_Link");
			Log.error("First Citizen link not found on home page");
			throw (e);
		}
		return element;
	}

	public static WebElement get_TermsAndCondions_Link() {
		try {
			Log.info("Locating TermsAndCondions link on home page");
			element = Driver.findElement(By.xpath("//a[@title='TERMS & CONDITIONS']"));
			System.out.println(" TermsAndCondions link is found");
			Utils.highLight(element);
			Log.info("TermsAndCondions link found on home page");
		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method  get_TermsAndCondions_Link");
			Log.error("TermsAndCondions link not found on home page");
			throw (e);
		}
		return element;
	}

	public static WebElement StoreLocator() {
		try {
			Log.info("locating storelocatore link on home page");
			element = Driver.findElement(By.xpath("//div[@id='header-info-bar']/descendant::a[@href='/store-finder']"));
			Log.info("located store locator link on the home page");
			Utils.highLight(element);
			Log.info("store locating link is highlated on home page");
		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method  StoreLocator");
			Log.error("StoreLocator link not found on home page");
			throw (e);
		}
		return element;
	}

	public static WebElement selectCity() {
		try {
			Log.info("locating selectcity link on store locator page");
			element = Driver.findElement(By.xpath("//select[@name='cityName']"));
			Log.info(" located selectcity   link on the home page");
			Utils.highLight(element);
			Log.info("store locating link is highlated on home page");
		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method  selectCity");
			Log.error("selectCity link not found on home page");
			throw (e);
		}
		return element;

	}

	public static WebElement selectStore() throws Exception {
		try {
			Log.info("locating selectStore link on store locator page");
			element = Driver.findElement(By.xpath("//select[@name='pointOfServices']"));
			Log.info(" located selectStore   link on the home page");
			Utils.highLight(element);
			Log.info("selectStore locating link is highlated on home page");
		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method  selectStore");
			Log.error("selectStore link not found on home page");
			throw (e);
		}
		return element;

	}

	public static WebElement StroeDisplayed() {
		try {
			Log.info("locating displayed store  on store locator page");
			element = Driver.findElement(By.xpath("//div[@class='store_address']"));
			Log.info(" located displayed store   link on the home page");
			Log.info("displayed store locating link is highlated on home page");
			return element;
		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method  StroeDisplayed");
			Log.error("StroeDisplayed link not found on home page");
			throw (e);
		}

	}

	public static WebElement trackOrders() {
		try {
			Log.info("locating trackOrders link on home page");
			element = Driver.findElement(By.xpath("//div[@id='header-info-bar']/descendant::a[@href='/trackorders']"));
			Log.info("located trackOrders  link on the home page");
			Utils.highLight(element);
			Log.info("store trackOrders link is highlated on home page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method  trackOrders");
			Log.error("trackOrders link not found on home page");
			throw (e);
		}
		return element;

	}

	public static WebElement emailId() {
		try {
			Log.info("locating emailid placeholder on trackOrders");
			element = Driver.findElement(By.xpath("//input[@id='emailAddress']"));
			Log.info("located emailid placeholder   link on the trackOrders");
			Utils.highLight(element);
			Log.info("store emailid placeholder link is highlated on home page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method  emailId");
			Log.error("emailid placeholder link not found on trackOrders");
			throw (e);
		}
		return element;
	}

	public static WebElement orderCode() {
		try {
			Log.info("locating orderCode placeholder on trackOrders");
			element = Driver.findElement(By.xpath("//input[@id='orderCode']"));
			Log.info("located orderCode placeholder   link on the trackOrders page");
			Utils.highLight(element);
			Log.info("store orderCode placeholder link is highlated on trackOrders page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method  orderCode");
			Log.error("orderCode placeholder link not found on trackOrders page");
			throw (e);
		}

		return element;

	}

	public static WebElement errorMessageOnTrackOrder() {
		try {
			Log.info("locatingerrorMessageOnTrackOrder on trackOrders page");
			element = Driver.findElement(By.xpath("//input[@id='orderCode']"));
			Log.info("locatederrorMessageOnTrackOrder on the trackOrders page");
			Utils.highLight(element);
			Log.info("errorMessageOnTrackOrder is highlated on trackOrders page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method  errorMessageOnTrackOrder");
			Log.error("errorMessageOnTrackOrder not found on trackOrders page");
			throw (e);

		}
		return element;
	}

	public static WebElement Discover() {
		try {
			Log.info("Locating Discover link on home page");
			element = Driver.findElement(By.xpath("//li/a[@title='DISCOVER']"));
			System.out.println("Discover link is found");
			Utils.highLight(element);
			Log.info("Discover link found on home page");
		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method  Discover");
			Log.error("Discover link not found on home page");
			throw (e);
		}
		return element;
	}

	public static WebElement becomeAMember() {
		try {
			Log.info("Locating BecomeAMember link on home page");
			element = Driver.findElement(By.xpath("//div[@class='lvl3']//a[.='Become A Member ']"));
			System.out.println("BecomeAMember link is found");
			Utils.highLight(element);
			Log.info("BecomeAMember link found on home page");
		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method  becomeAMember");
			Log.error("BecomeAMember link not found on home page");
			throw (e);
		}
		return element;
	}

	public static List<WebElement> OrderDeatils() {
		try {
			Log.info("order deatils on trackOrders page");
			List<WebElement> elements = Driver.findElements(By.xpath("//div[@class='cart-product']/ul/li/div/ul/li"));
			Log.info("order deatils located  on the trackOrders page");
			Log.info("errorMessageOnTrackOrder is highlated on trackOrders page");
			return elements;
		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method  OrderDeatils");
			Log.error("errorMessageOnTrackOrder not found on trackOrders page");
			throw (e);
		}

	}

	public static WebElement wishListicon() {
		try {
			Log.info("wishList icons found  on home page");
			element = Driver.findElement(By.xpath("//ul[@class='shareicon-wishlist pdp-ajax-wishlist']/li"));
			Utils.highLight(element);
			Log.info("collected all the wish icons");
			return element;
		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method  wishList");
			Log.error("wish list icon not found on wishList ");
			throw (e);
		}

	}

	public static WebElement Alert() {
		element = Driver.findElement(By.xpath(".//div[@class='dy-lb-close']"));
		return element;
	}

}
