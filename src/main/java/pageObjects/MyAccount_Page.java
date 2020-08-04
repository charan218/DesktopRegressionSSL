package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.Log;
import utility.Utils;

public class MyAccount_Page extends BaseClass {
	private static WebElement element = null;
	private static List<WebElement> elementList = null;

	public MyAccount_Page(WebDriver Driver) {
		super(Driver);
	}

	
	public static WebElement DefaultAddressChangeMsg() throws Exception {

		try {
			Log.info("Locating GlobalMsg element");
			element = Driver.findElement(By.xpath("//div[@class='alert alert-info alert-dismissable']"));
			Utils.highLight(element);
			Log.info(" Message field is found on the Page");

		} catch (Exception e) {
			Log.error("Exception in Class MyAccount_Page | Method DefaultAddressChangeMsg");
			Log.error("Message field is not found on the Page");
			throw e;
		}

		return element;

	}	
	
	public static WebElement GlobalMsg() throws Exception {

		try {
			Log.info("Locating GlobalMsg element");
			element = Driver.findElement(By.xpath("//*[@class='global-alerts']/div"));
			Utils.highLight(element);
			Log.info(" Message field is found on the Page");

		} catch (Exception e) {
			Log.error("Exception in Class MyAccount_Page | Method GlobalMsg");
			Log.error("Message field is not found on the Page");
			throw e;
		}

		return element;

	}

	public static class MyAccount {
		public static WebElement FirstCitizenLink() throws Exception {

			try {
				Log.info("Locating First Citizen link element");
				element = Driver.findElement(By.xpath("//a[text()= 'Be a First Citizen']"));

				Log.info("First Citizen link is found on the My Account Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method FirstCitizenLink");
				Log.error("First Citizen link is not found on the My Account Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement RecentOrderbox() throws Exception {

			try {
				Log.info("Locating Recent Order box element");
				element = Driver.findElement(By.xpath("//section[@class='my-account-wpr']//div[@class='recent-order-box']"));

				Log.info("Recent Order box is found on the My Account Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method RecentOrderbox");
				Log.error("Recent Order box is not found on the My Account Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement RecentOrderText() throws Exception {

			try {
				Log.info("Locating RecentOrderText element");
				element = Driver.findElement(By.xpath("//section[@class='my-account-wpr']//div[@class='recent-order-box']/h2[contains(text(),'Recent Order')]"));

				Log.info("Recent Order text is found on the My Account Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method RecentOrderText");
				Log.error("Recent Order text is not found on the My Account Page");
				throw e;
			}

			return element;

		}
		
		public static List<WebElement> myAccount_OrderId() throws Exception {

			try {
				Log.info("Locating OrderId elements");
				elementList = Driver.findElements(By.xpath("//div[@class='recent-order-box']//label[text()='Order ID']"));

				Log.info("Order Id elements are found on the My Account Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method myAccount_OrderId");
				Log.error("Order Id elements are not found on the My Account Page");
				throw e;
			}

			return elementList;

		}
		
		public static List<WebElement> myAccount_OrderDate() throws Exception {

			try {
				Log.info("Locating Order Date elements");
				elementList = Driver.findElements(By.xpath("//div[@class='recent-order-box']//label[text()='Order Date']"));

				Log.info("Order Date elements are found on the My Account Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method myAccount_OrderDate");
				Log.error("Order Date elements are not found on the My Account Page");
				throw e;
			}

			return elementList;

		}
		
		
		public static List<WebElement> myAccount_AmountPaid() throws Exception {

			try {
				Log.info("Locating Amount paid elements");
				elementList = Driver.findElements(By.xpath("//div[@class='recent-order-box']//label[text()='Amount paid']"));

				Log.info("Amount paid elements are found on the My Account Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method myAccount_AmountPaid");
				Log.error("Amount paid elements are not found on the My Account Page");
				throw e;
			}

			return elementList;

		}
		
		public static List<WebElement> myAccount_Status() throws Exception {

			try {
				Log.info("Locating Status elements");
				elementList = Driver.findElements(By.xpath("//div[@class='recent-order-box']//label[text()='Status']"));

				Log.info("Status elements are found on the My Account Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method myAccount_Status");
				Log.error("Status elements are not found on the My Account Page");
				throw e;
			}

			return elementList;

		}
	}

	public static class FirstCitizen_Profile {
		public static WebElement FirstCitizenButton() throws Exception {

			try {
				Log.info("Locating First Citizen button element");
				element = Driver.findElement(By.xpath("//div[@id='my-acc-section']//button"));
				Utils.highLight(element);
				Log.info("First Citizen button is found on the First Citizen Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method FirstCitizenButton");
				Log.error("First Citizen button is not found on the First Citizen Page");
				throw e;
			}

			return element;

		}
	}

	public static class WishList {

		static WebElement mainElement;
		
		public static WebElement wishlist_Link()
		{
			try {
				Log.info("Locating WishList Link element");
				element = Driver.findElement(By.xpath("//span[.='Wishlist']"));
				Utils.highLight(element);
				Log.info("WishList Link is found on the Home Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method wishlist_Link");
				Log.error("WishList Link is not found on the Home Page");
				throw e;
			}

			return element;
		}
		
		public static WebElement WishListHeading() throws Exception {

			try {
				Log.info("Locating WishListHeading element");
				element = Driver.findElement(By.xpath("//div[@class='wishlist-heading']/div/h1"));

				Log.info("WishListHeading is found on the Home Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method WishListHeading");
				Log.error("WishListHeading is not found on the Home Page");
				throw e;
			}

			return element;

		}

		public static WebElement WishListItems() throws Exception {

			try {
				Log.info("Locating WishListItems element");
				element = Driver.findElement(By.xpath("//div[@class='wishlist-heading']/div/h1/span"));

				Log.info("WishList Item is found on the Home Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method WishListItems");
				Log.error("WishList Item is not found on the Home Page");
				throw e;
			}

			return element;

		}

		public static WebElement WishListItemCloseBtn() throws Exception {

			try {
				Log.info("Locating WishListItemCloseBtn element");
				element = Driver.findElement(By.xpath("//*[@id='qv-drop']/li[1]/a/div"));

				Log.info("WishList Item Close button is found on the Home Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method WishListItemCloseBtn");
				Log.error("WishList Item Close button is not found on the Home Page");
				throw e;
			}

			return element;

		}

		public static WebElement WishListItemImg() throws Exception {

			try {
				Log.info("Locating WishListItemImg element");
				element = Driver.findElement(By.xpath("//*[@id='qv-drop']/li[1]/div[@class='pro-img']"));

				Log.info("Item image is found on the Home Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method WishListItemImg");
				Log.error("Item image is not found on the Home Page");
				throw e;
			}

			return element;

		}

		public static WebElement WishListItemURL() throws Exception {

			try {
				Log.info("Locating WishListItemURL element");
				element = Driver.findElement(By.xpath("//*[@id='qv-drop']/li[1]/div[@class='pro-img']/a"));

				Log.info("Item URL is found on the Home Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method WishListItemURL");
				Log.error("Item URL is not found on the Home Page");
				throw e;
			}

			return element;

		}
		public static WebElement RemoveFromWishList() throws Exception{
			element = Driver.findElement(By.xpath("//*[contains(text(),'Remove from WishList')]"));
			return element; 
		}
		
		public static WebElement select_Size_Radio() {
			try {
				Log.info("Locating select_Size radiobutton element");
				element = Driver.findElement(By.xpath("(//ul[@class='mv-wishlist-sizes']/li//a)[1]"));
				Log.info("select_Size radiobutton is found on the Home Page");
				Utils.highLight(element);
			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method select_Size_Radio");
				Log.error("select_Size radiobutton is not found on the Home Page");
				throw e;
			}

			return element;
		}
		
		public static WebElement done_Button() {
			try {
				Log.info("Locating Done Button element");
				element = Driver.findElement(By.xpath("//input[@class='mvbtn done d-block']"));
				Log.info("Done Button is found on the Home Page");
				Utils.highLight(element);
			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method done_Button");
				Log.error("Done Button is not found on the Home Page");
				throw e;
			}

			return element;
		}
		
		public static List<WebElement> wishlist_Items() {
			try {
				Log.info("Locating Empty_Wishlist_Message element");
				elementList = Driver.findElements(By.xpath("//a[.='MOVE TO BAG']"));
				Log.info("Empty_Wishlist_Message is found on the Home Page");
			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method empty_Wishlist_Message");
				Log.error("Empty_Wishlist_Message is not found on the Home Page");
				throw e;
			}

			return elementList;
		}
	}

	public static class ProfilePage {

		static WebElement mainElement;
		static WebElement subElement;
		static String element1;

		public static WebElement PersonalInfoText() throws Exception {

			try {
				Log.info("Locating PersonalInfoText element");
				element = Driver.findElement(By.xpath("//div[@class='my-acc-heading']/div/h1"));
				Utils.highLight(element);
				Log.info("PersonalInfoText field is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method PersonalInfoText");
				Log.error("PersonalInfoText field is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static WebElement EditProfileBtn() throws Exception {

			try {
				Log.info("Locating EditProfileBtn element");
				element = Driver.findElement(By.xpath("//a[contains(text(), 'Edit Profile')]"));
				Utils.highLight(element);
				Log.info("EditProfileBtn is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method EditProfileBtn");
				Log.error("EditProfileBtn is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static WebElement FirstName() throws Exception {

			try {
				Log.info("Locating FirstName element");
				element = Driver.findElement(By.id("profile.firstName"));
				Utils.highLight(element);
				Log.info("FirstName field is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method FirstName");
				Log.error("FirstName field is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static WebElement LastName() throws Exception {

			try {
				Log.info("Locating LastName element");
				element = Driver.findElement(By.id("profile.lastName"));
				Utils.highLight(element);
				Log.info("LastName field is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method LastName");
				Log.error("LastName field is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static WebElement Email_Address() throws Exception {

			try {
				Log.info("Locating Email_Address element");
				element = Driver.findElement(By.xpath("profile.email"));
				Utils.highLight(element);
				Log.info("Email_Address field is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method Email_Address");
				Log.error("Email_Address field is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static WebElement MobileNumber() throws Exception {

			try {
				Log.info("Locating MobileNumber element");
				element = Driver.findElement(By.id("profile.moibile"));
				Utils.highLight(element);
				Log.info("MobileNumber field is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method MobileNumber");
				Log.error("MobileNumber field is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static WebElement HomeStore() throws Exception {

			try {
				Log.info("Locating HomeStore element");
				element = Driver.findElement(By.id("profile.homeStore.name"));
				Utils.highLight(element);
				Log.info("HomeStore field is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method HomeStore");
				Log.error("HomeStore field is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static WebElement DOBCalanderBtn() throws Exception {

			try {
				Log.info("Locating DOBCalanderBtn element");
				element = Driver.findElement(By.xpath("//*[@id='profile.dob']/following-sibling::button"));

				Log.info("DOB calender button is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method DOBCalanderBtn");
				Log.error("DOB calender button is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static class Calender {

			public static WebElement Year() throws Exception {

				try {
					Log.info("Locating Year element");
					element = Driver.findElement(
							By.xpath("//*[@id='ui-datepicker-div']/div/div/select[@class='ui-datepicker-year']"));

					Log.info("Year dropdown is found on the profile Page");

				} catch (Exception e) {
					Log.error("Exception in Class MyAccount_Page | Method Year");
					Log.error("Year dropdown is not found on the profile Page");
					throw e;
				}

				return element;

			}

			public static WebElement Month() throws Exception {

				try {
					Log.info("Locating Month element");
					element = Driver.findElement(
							By.xpath("//*[@id='ui-datepicker-div']/div/div/select[@class='ui-datepicker-month']"));

					Log.info("Month dropdown is found on the profile Page");

				} catch (Exception e) {
					Log.error("Exception in Class MyAccount_Page | Method Month");
					Log.error("Month dropdown is not found on the profile Page");
					throw e;
				}

				return element;

			}

			public static WebElement DateTable() throws Exception {

				try {
					Log.info("Locating DateTable element");
					element = Driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody"));

					Log.info("DateTable is found on the profile Page");

				} catch (Exception e) {
					Log.error("Exception in Class MyAccount_Page | Method DateTable");
					Log.error("DateTable is not found on the profile Page");
					throw e;
				}

				return element;

			}

		}

		public static WebElement ProfileUpdateDetails_Button() {

			try {
				Log.info("Locating ProfileUpdateDetails_Button element");
				element = Driver.findElement(By.xpath("//button[contains(text(), 'Save Updates')]"));

				Log.info("Profile UpdateDetails Button is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ProfileUpdateDetails_Button");
				Log.error("Profile UpdateDetails Button is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static WebElement Settings() throws Exception {

			try {
				Log.info("Locating Settings element");
				element = Driver.findElement(By.linkText("Settings"));
				Utils.highLight(element);
				Log.info("Settings Link is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method Settings");
				Log.error("Settings Link is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static WebElement Addresses() throws Exception {

			try {
				Log.info("Locating Addresses element");
				element = Driver.findElement(By.linkText("Addresses"));
				Utils.highLight(element);
				Log.info("Addresses Link is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method Addresses");
				Log.error("Addresses Link is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static WebElement AddNewAddress() throws Exception {

			try {
				Log.info("Locating AddNewAddress element");
				element = Driver.findElement(By.linkText("Add a new address"));
				Utils.highLight(element);
				Log.info("New Address Link is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method AddNewAddress");
				Log.error("New Address Link is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static List<WebElement> DefaultShippingAddresstext() throws Exception {

			try {
				Log.info("Locating DefaultShippingAddresstext elements");
				elementList = Driver.findElements(By.xpath("//p[starts-with(text(), 'Default Shipping')]"));
				Utils.HighlightAllElementOneByOne(elementList);
				Log.info("Default shipping list element is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method DefaultShippingAddresstext");
				Log.error("Default shipping list element is not found on the profile Page");
				throw e;
			}

			return elementList;

		}

		public static List<WebElement> AddressList() throws Exception {

			try {
				Log.info("Locating AddressList elements");
				elementList = Driver.findElements(By.xpath("//div[@class='list_address']/ul/li"));

				Log.info("Address list element is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method AddressList");
				Log.error("Address list element is not found on the profile Page");
				throw e;
			}

			return elementList;

		}

		public static List<WebElement> MakeItAsDefaultShippingAddresstext() throws Exception {

			try {
				Log.info("Locating MakeItAsDefaultShippingAddresstext elements");
				elementList = Driver
						.findElements(By.xpath("//a[starts-with(text(), 'Make this my default shipping')]"));

				Log.info("Make this my default shipping element is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method MakeItAsDefaultShippingAddresstext");
				Log.error("Make this my default shipping element is not found on the profile Page");
				throw e;
			}

			return elementList;

		}

		public static WebElement EditAddressBtn() throws Exception {

			try {
				Log.info("Locating EditAddressBtn element");
				//element = Driver.findElement(By.xpath("//div[@class='list_address']/ul/li[1]//a[@class='edit']"));
				Thread.sleep(3000);
				element = Driver.findElement(By.cssSelector("a[href*='/my-account/edit-address/9369895305239']"));

				Log.info("Edit Address button is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method EditAddressBtn");
				Log.error("Edit Address button is not found on the profile Page");
				throw e;
			}
			

			return element;

		}
		
		public static WebElement CheckoutEditAddressBtn() throws Exception {

			try {
				Log.info("Locating EditAddressBtn element");
				element = Driver.findElement(By.xpath("//div[@class='checkoutAddressID']decendent::a[@class='edit']"));
				//element = Driver.findElement(By.xpath("html/body/main/section/div/div/div[2]/div[2]/div/div/ul/li[1]/ul/li[3]/a[2]"));

				Log.info("Edit Address button is found on the checkout Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method EditAddressBtn");
				Log.error("Edit Address button is not found on the checkout Page");
				throw e;
			}

			return element;

		}

		public static WebElement DeleteAddressBtn() throws Exception {

			try {
				Log.info("Locating DeleteAddressBtn element");
				element = Driver.findElement(By.xpath("(//div[@class='list_address']//li[2]//li[3]/a)[1]"));
				Utils.highLight(element);
				Log.info("Delete address button is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method DeleteAddressBtn");
				Log.error("Delete address button is not found on the profile Page");
				throw e;
			}

			return element;

		}
	
		
		

						
				
		public static WebElement ChangeDefaultAddress_Link() throws Exception {

			try {
//			
				element = Driver.findElement(By.xpath("//div[@class='list_address']//li[2]//li[2]/div/p/a[contains(.,'Make this my default shipping address')]"));
				
				Log.info("Locating ChangeDefaultAddress element");
//				element = Driver.findElement(By.xpath("//div[@class='list_address']//li[2]//li[2]/div/p/a[contains(text(),'/my-account/set-default-address')]"));
				Utils.highLight(element);
				
				Log.info("ChangeDefaultAddress link is found on the address Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ChangeDefaultAddress");
				Log.error("ChangeDefaultAddress link is not found on the Address Page");
				throw e;
			}

			return element;

		}	

		public static WebElement DefaultAddressChangeMsg() throws Exception {

			try {
				Log.info("Locating GlobalMsg element");
				element = Driver.findElement(By.xpath("//div[@class='alert alert-info alert-dismissable']"));
				Utils.highLight(element);
				Log.info(" Message field is found on the Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method DefaultAddressChangeMsg");
				Log.error("Message field is not found on the Page");
				throw e;
			}

			return element;

		}	
		
		
		public static class Address {

			public static WebElement FirstName() throws Exception {

				try {
					Log.info("Locating FirstName element");
					element = Driver.findElement(By.id("address.firstName"));
					Utils.highLight(element);
					Log.info("FirstName field is found on the address Page");

				} catch (Exception e) {
					Log.error("Exception in Class MyAccount_Page | Method FirstName");
					Log.error("FirstName field is not found on the address Page");
					throw e;
				}

				return element;
			}
				
				public static WebElement LastName() throws Exception {

					try {
						Log.info("Locating LastName element");
						element = Driver.findElement(By.id("address.lastName"));
						Utils.highLight(element);
						Log.info("LastName field is found on the address Page");

					} catch (Exception e) {
						Log.error("Exception in Class MyAccount_Page | Method LastName");
						Log.error("FirstName field is not found on the address Page");
						throw e;
					}

					return element;

			}

			public static WebElement PostCode() throws Exception {

				try {
					Log.info("Locating PostCode element");
					element = Driver.findElement(By.id("address.postcode"));
					Utils.highLight(element);
					Log.info("PostCode field is found on the address Page");

				} catch (Exception e) {
					Log.error("Exception in Class MyAccount_Page | Method PostCode");
					Log.error("PostCode field is not found on the address Page");
					throw e;
				}

				return element;

			}

			public static WebElement Address1() throws Exception {

				try {
					Log.info("Locating Address1 element");
					element = Driver.findElement(By.id("address.line1"));
					Utils.highLight(element);
					Log.info("Address field is found on the address Page");

				} catch (Exception e) {
					Log.error("Exception in Class MyAccount_Page | Method Address1");
					Log.error("Address field is not found on the address Page");
					throw e;
				}

				return element;

			}
			public static WebElement Address2() throws Exception {

				try {
					Log.info("Locating Address2 element");
					element = Driver.findElement(By.xpath(".//*[@id='address.line2']"));
					Utils.highLight(element);
					Log.info("Address field is found on the address Page");

				} catch (Exception e) {
					Log.error("Exception in Class MyAccount_Page | Method Address2");
					Log.error("Address field is not found on the address Page");
					throw e;
				}

				return element;

			}
			public static WebElement City() throws Exception {

				try {
					Log.info("Locating City element");
					element = Driver.findElement(By.id("address.townCity"));
					Utils.highLight(element);
					Log.info("City field is found on the address Page");

				} catch (Exception e) {
					Log.error("Exception in Class MyAccount_Page | Method City");
					Log.error("City field is not found on the address Page");
					throw e;
				}

				return element;

			}

			public static WebElement Phone() throws Exception {

				try {
					Log.info("Locating Phone element");
					element = Driver.findElement(By.id("address.phone"));
					Utils.highLight(element);
					Log.info("Phone field is found on the address Page");

				} catch (Exception e) {
					Log.error("Exception in Class MyAccount_Page | Method Phone");
					Log.error("Phone field is not found on the address Page");
					throw e;
				}

				return element;

			}

			public static WebElement Landmark() throws Exception {

				try {
					Log.info("Locating Landmark element");
					element = Driver.findElement(By.id("address.line2"));
					Utils.highLight(element);
					Log.info("Landmark field is found on the address Page");

				} catch (Exception e) {
					Log.error("Exception in Class MyAccount_Page | Method Landmark");
					Log.error("Landmark field is not found on the address Page");
					throw e;
				}

				return element;

			}

			public static WebElement DefaultAddressCheckbox() throws Exception {

				try {
					Log.info("Locating DefaultAddressCheckbox element");
					element = Driver.findElement(By.id("myShippingAddress"));
					Utils.highLight(element);
					Log.info("DefaultAddress Checkbox is found on the address Page");

				} catch (Exception e) {
					Log.error("Exception in Class MyAccount_Page | Method DefaultAddressCheckbox");
					Log.error("DefaultAddress Checkbox is not found on the address Page");
					throw e;
				}

				return element;
			}

			public static WebElement AddressForm() throws Exception {

				try {
					Log.info("Locating Address form");
					element = Driver.findElement(By.xpath(".//*[@id='accountAddressForm']/ul"));
					Utils.highLight(element);
					Log.info("Locating Address form is found on the address Page");

				} catch (Exception e) {
					Log.error("Exception in Class MyAccount_Page | Method AddressForm");
					Log.error("Locating Address form is not found on the address Page");
					throw e;
				}

				return element;
			}	
			
			public static WebElement AddAddressBtn() throws Exception {

				try {
					Log.info("Locating AddAddressBtn element");
					element = Driver.findElement(By.id("accountAddAddress"));
					Utils.highLight(element);
					Log.info("AddAddress Button is found on the address Page");

				} catch (Exception e) {
					Log.error("Exception in Class MyAccount_Page | Method AddAddressBtn");
					Log.error("AddAddress Button is not found on the address Page");
					throw e;
				}

				return element;

			}

			public static WebElement CancelBtn() throws Exception {

				try {
					Log.info("Locating CancelBtn element");
					element = Driver.findElement(By.xpath("//button[contains(text(), 'Cancel')]"));
					Utils.highLight(element);
					Log.info("Cancel Button is found on the address Page");

				} catch (Exception e) {
					Log.error("Exception in Class MyAccount_Page | Method CancelBtn");
					Log.error("Cancel Button is not found on the address Page");
					throw e;
				}

				return element;

			}

		}

		public static WebElement NewsletterandSubscription() throws Exception {

			try {
				Log.info("Locating NewsletterandSubscription element");
				element = Driver.findElement(By.xpath("//a[.='Newsletter Subscription']"));
				Utils.highLight(element);
				Log.info(" NewsletterandSubscription Link is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method NewsletterandSubscription");
				Log.error("NewsletterandSubscription Link is not found on the profile Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement NewsletterServices(String category) throws Exception {

			try {
				Log.info("Locating NewsletterServices element");
				element = Driver.findElement(By.xpath("//*[@class='catergies']//*[@id='"+category+"']"));
				Utils.highLight(element);
				Log.info(" NewsletterServices "+category+ " option is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method NewsletterServices");
				Log.error("NewsletterServices "+category+ " option is not found on the profile Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement NewsletterFrequency(String freq) throws Exception {

			try {
				Log.info("Locating NewsletterFrequency element");
				element = Driver.findElement(By.xpath("//*[@class='weekly_main']//*[@id='"+freq+"']"));
				Utils.highLight(element);
				Log.info(" NewsletterFrequency "+freq+ " option is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method NewsletterFrequency");
				Log.error("NewsletterFrequency "+freq+ " option is not found on the profile Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement NewsletterUpdateBtn() throws Exception {

			try {
				Log.info("Locating NewsletterUpdate Button element");
				element = Driver.findElement(By.id("updateBtnId"));
				Utils.highLight(element);
				Log.info(" NewsletterUpdate button is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method NewsletterUpdateBtn");
				Log.error("NewsletterUpdate button is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static WebElement ChangePassword() throws Exception {

			try {
				Log.info("Locating ChangePassword element");
				element = Driver.findElement(By.id("chngbtn"));
				Utils.highLight(element);
				Log.info(" Change password Link is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ChangePassword");
				Log.error("Change password Link is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static WebElement ChangePassword_CurrentPassword() throws Exception {

			try {
				Log.info("Locating ChangePassword_CurrentPassword element");
				element = Driver.findElement(By.id("profile.currentPassword"));
				Utils.highLight(element);
				Log.info("Profile currentPassword field is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ChangePassword_CurrentPassword");
				Log.error("Profile currentPassword field  is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static WebElement ChangePassword_NewPassword() throws Exception {

			try {
				Log.info("Locating ChangePassword_NewPassword element");
				element = Driver.findElement(By.id("profile-newPassword"));
				Utils.highLight(element);
				Log.info("NewPassword field is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ChangePassword_NewPassword");
				Log.error("NewPassword field  is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static WebElement ChangePassword_NewPasswordConfirm() throws Exception {

			try {
				Log.info("Locating ChangePassword_NewPasswordConfirm element");
				element = Driver.findElement(By.id("profile.checkNewPassword"));
				Utils.highLight(element);
				Log.info(" ChangePassword Confirm NewPassword field is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ChangePassword_NewPasswordConfirm");
				Log.error(" ChangePassword Confirm NewPassword field  is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static WebElement UpdatePassword_Btn() throws Exception {

			try {
				Log.info("Locating UpdatePassword_Btn element");
				element = Driver.findElement(By.xpath("//button[@class='sbt-button']"));
				Utils.highLight(element);
				Log.info("Update button is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method UpdatePassword_Btn");
				Log.error("Update button  is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static WebElement Cancel_Btn() throws Exception {

			try {
				Log.info("Locating Cancel_Btn element");
				element = Driver.findElement(By.xpath("//button[@id='canclbtn']"));
				Utils.highLight(element);
				Log.info("Cancel button is found on the profile Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method Cancel_Btn");
				Log.error("Cancel button is not found on the profile Page");
				throw e;
			}

			return element;

		}

		public static WebElement ChangePasswordSection() {
			try {
				Log.info("Locating ChangePassword element");
				element = Driver.findElement(By.xpath("//a[@title='Change Password']"));
				Utils.highLight(element);
				Log.info(" Change password Link is found on the profile Page");
			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ChangePassword");
				Log.error("Change password Link is not found on the profile Page");
				throw e;
			}
			return element;
		}

	}

	public static class OrderHistory {

		public static WebElement NoOrderText() throws Exception {

			try {
				Log.info("Locating NoOrderText element");
				element = Driver.findElement(By.xpath("//div[@class='content-wpr']/h3"));
				Utils.highLight(element);
				Log.info("No Order message found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method NoOrderText");
				Log.error("No Order message not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement RecentOrdersTab() throws Exception {

			try {
				Log.info("Locating RecentOrdersTab element");
				element = Driver.findElement(By.xpath("//a[text()='Recent Orders']"));
				Utils.highLight(element);
				Log.info("Recent Orders tab is found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method RecentOrdersTab");
				Log.error("Recent Orders tab is not found on the Orders Page");
				throw e;
			}

			return element;

		}
		public static WebElement OrderHistoryTab() throws Exception {

			try {
				Log.info("Locating OrderHistoryTab element");
				element = Driver.findElement(By.xpath("//a[contains(text(),'Order History')]"));
				Utils.highLight(element);
				Log.info("OrderHistoryTab is found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method OrderHistoryTab");
				Log.error("OrderHistoryTab is not found on the Orders Page");
				throw e;
			}
		
			return element;
		}	
	  public static WebElement OrderViewDetailsTab() throws Exception {
			try{
				Log.info("Locating OrderViewDetailsTab element");
				Thread.sleep(1000);
				element=Driver.findElement(By.xpath("//a[contains(text(),'View details')]"));
				Utils.highLight(element);
				Log.info("OrderViewDetailsTab is found on the Orders Page");
			
	  } catch (Exception e) {
			Log.error("Exception in Class MyAccount_Page | Method OrderViewDetailsTab");
			Log.error("OrderViewDetailsTab is not found on the Orders Page");
			throw e;
		}
			return element;
		}
	  public static WebElement ManagerOrder() throws Exception {
		  try{
			  Log.info("Verifying  Manage order");
			  element=Driver.findElement(By.xpath("//h2[contains(.,'Manage Order')]"));
			  Utils.highLight(element);
				Log.info("manage order is available in order details page");
				try{
					Log.info("Verifying details available under Manage order");
					  element=Driver.findElement(By.xpath("//a[contains(.,'Print Order')]"));
					  Utils.highLight(element);
						Log.info("Print Order is available under Manage order");
				}
				catch (Exception e) {
					Log.error("Exception in Class MyAccount_Page | Method ManagerOrder");
					Log.error("Print Order is not available under Manage order");
					throw e;
				}
				try{
					Log.info("Verifying details available under Manage order");
					  element=Driver.findElement(By.xpath("//a[contains(.,'Email Invoice')]"));
					  Utils.highLight(element);
						Log.info("Email Invoice is available under Manage order");
				}
				catch (Exception e) {
					Log.error("Exception in Class MyAccount_Page | Method ManagerOrder");
					Log.error("Email Invoice is not available under Manage order");
					throw e;
				}
				try{
					Log.info("Verifying details available under Manage order");
					  element=Driver.findElement(By.xpath("//a[contains(.,'Contact us')]"));
					  Utils.highLight(element);
						Log.info("Contact us is available under Manage order");
				}
				catch (Exception e) {
					Log.error("Exception in Class MyAccount_Page | Method ManagerOrder");
					Log.error("Contact us is not available under Manage order");
					throw e;
				}
				try{
					Log.info("Verifying details available under Manage order");
					  element=Driver.findElement(By.xpath("//a[contains(.,'FAQs')]"));
					  Utils.highLight(element);
						Log.info("FAQs is available under Manage order");
				}
				catch (Exception e) {
					Log.error("Exception in Class MyAccount_Page | Method ManagerOrder");
					Log.error("FAQs is not available under Manage order");
					throw e;
				}
		  }
		  catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ManagerOrder");
				Log.error("manage order is not available in order details pagee");
				throw e;
			}
				return element;
	  }
	  
		public static WebElement ReturnAndExchangeTab() throws Exception {

			try {
				Log.info("Locating ReturnAndExchangeTab element");
				Thread.sleep(1000);
				element = Driver.findElement(By.xpath("//a[contains(text(),'Return/Exchange Orders')]"));
				Utils.highLight(element);
				Log.info("ReturnAndExchangeTab is found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ReturnAndExchangeTab");
				Log.error("ReturnAndExchangeTab is not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static WebElement OldOrdersTab() throws Exception {

			try {
				Log.info("Locating OldOrdersTab element");
				element = Driver.findElement(By.xpath("//a[text()='Old Orders']"));
				Utils.highLight(element);
				Log.info("Old Orders tab is found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method OldOrdersTab");
				Log.error("Old Orders tab is not found on the Orders Page");
				throw e;
			}

			return element;

		}
		
		public static List<WebElement> OrderId() throws Exception {

			try {
				Log.info("Locating OrderId elements");
				elementList = Driver.findElements(By.xpath("//div[@class='rec-order-list']//label[text()='Order ID']"));
				Utils.HighlightAllElementOneByOne(elementList);
				Log.info("Order Id elements are found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method OrderId");
				Log.error("Order Id elements are not found on the Orders Page");
				throw e;
			}

			return elementList;

		}
		
		public static List<WebElement> OrderDate() throws Exception {

			try {
				Log.info("Locating Order Date elements");
				elementList = Driver.findElements(By.xpath("//div[@class='rec-order-list']//label[text()='Order Date']"));
				Utils.HighlightAllElementOneByOne(elementList);
				Log.info("Order Date elements are found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method OrderDate");
				Log.error("Order Date elements are not found on the Orders Page");
				throw e;
			}

			return elementList;

		}
		
		public static List<WebElement> TotalQuantity() throws Exception {

			try {
				Log.info("Locating TotalQuantity elements");
				elementList = Driver.findElements(By.xpath("//div[@class='rec-order-list']//label[text()='Total Quantity']"));
				Utils.HighlightAllElementOneByOne(elementList);
				Log.info("Total Quantity elements are found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method TotalQuantity");
				Log.error("Total Quantity elements are not found on the Orders Page");
				throw e;
			}

			return elementList;

		}
		
		public static List<WebElement> AmountPaid() throws Exception {

			try {
				Log.info("Locating Amount paid elements");
				elementList = Driver.findElements(By.xpath("//div[@class='rec-order-list']//label[text()='Amount paid']"));
				Utils.HighlightAllElementOneByOne(elementList);
				Log.info("Amount paid elements are found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method AmountPaid");
				Log.error("Amount paid elements are not found on the Orders Page");
				throw e;
			}

			return elementList;

		}
		
		public static List<WebElement> Status() throws Exception {

			try {
				Log.info("Locating Status elements");
				elementList = Driver.findElements(By.xpath("//div[@class='rec-order-list']//label[text()='Status']"));
				Utils.HighlightAllElementOneByOne(elementList);
				Log.info("Status elements are found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method Status");
				Log.error("Status elements are not found on the Orders Page");
				throw e;
			}

			return elementList;

		}
		
		public static List<WebElement> Tracking() throws Exception {

			try {
				Log.info("Locating Tracking elements");
				elementList = Driver.findElements(By.xpath("//div[@class='rec-order-list']//label[contains(text(),'Tracking')]"));
				Utils.HighlightAllElementOneByOne(elementList);
				Log.info("Tracking elements are found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method Tracking");
				Log.error("Tracking elements are not found on the Orders Page");
				throw e;
			}

			return elementList;

		}
		
		
		public static List<WebElement> OrderAction() throws Exception {

			try {
				Log.info("Locating OrderAction elements");
				elementList = Driver.findElements(By.xpath("//div[@class='rec-order-list']//a[contains(@class, 'sbt-button')]"));
				Utils.HighlightAllElementOneByOne(elementList);
				Log.info("Order Action elements are found on the Orders Page");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method OrderAction");
				Log.error("Order Action elements are not found on the Orders Page");
				throw e;
			}

			return elementList;

		}
		
		public static class orderDetails{
			
			public static WebElement orderDetailsSection() throws Exception {

				try {
					Log.info("Locating orderDetailsSection element");
					element = Driver.findElement(By.xpath("//section[@class='my-account-wpr order-detail-page']"));
					Utils.highLight(element);
					Log.info("Order details section is found on Orders page");

				} catch (Exception e) {
					Log.error("Exception in Class MyAccount_Page | Method orderDetailsSection");
					Log.error("Order details section is not found on Orders page");

					throw (e);

				}

				return element;
			}
			
			public static List<WebElement> order_Details_List()
			{
				try {
					Log.info("Locating Order_Details List element");
					elementList = Driver.findElements(By.xpath("//div[@class='tab_content']/div/div/ul"));
					Log.info("Order_Details List is found on Orders page");

				} catch (Exception e) {
					Log.error("Exception in Class MyAccount_Page | Method order_Details_List");
					Log.error("Order_Details List is not found on Orders page");
					throw (e);
				}
				return elementList;
			}
			
			
			
			public static WebElement my_Orders_Link()
			{
				try {
					Log.info("Locating MyOrders link element");
					element = Driver.findElement(By.xpath("//a[@title='My Orders']"));
					Utils.highLight(element);
					Log.info("MyOrders link is found on Orders page");

				} catch (Exception e) {
					Log.error("Exception in Class MyAccount_Page | Method my_Orders_Link");
					Log.error("MyOrders link is not found on Orders page");
					throw (e);
				}
				return element;
			}
		}

	}

	public static class MyAccount_LeftMenu {

		static WebElement mainElement;

		public static WebElement MyShoppersStop() throws Exception {

			try {
				Log.info("Locating MyShoppersStop element");
				mainElement = Driver.findElement(By.xpath("//a[@title='My Shoppers Stop']"));
				Utils.highLight(mainElement);
				Log.info("My Shoppers Stop link is found on MyAccount left menu");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method MyShoppersStop");
				Log.error("My Shoppers Stop link is not found on MyAccount left menu");

				throw (e);

			}

			return mainElement;
		}

		public static WebElement Orders() throws Exception {

			try {
				Log.info("Locating Orders element");
				mainElement = Driver.findElement(By.xpath("//a[@title='Orders']"));
				Utils.highLight(mainElement);
				Log.info("Orders link is found on MyAccount left menu");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method Orders");
				Log.error("Orders link is not found on MyAccount left menu");

				throw (e);

			}

			return mainElement;
		}

		public static WebElement Payments() throws Exception {

			try {
				Log.info("Locating Alerts element");
				mainElement = Driver.findElement(By.xpath("//a[contains(.,'Payments')]"));
				Utils.highLight(mainElement);
				Log.info("Orders link is found on MyAccount left menu");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method Alerts");
				Log.error("Orders link is not found on MyAccount left menu");

				throw (e);

			}

			return mainElement;
		}

		public static WebElement Wishlist() throws Exception {

			try {
				Log.info("Locating Wishlist element");
				mainElement = Driver.findElement(By.xpath("//a[@title='Wishlist']"));
				Utils.highLight(mainElement);
				Log.info("Wishlist link is found on MyAccount left menu");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method Wishlist");
				Log.error("Wishlist link is not found on MyAccount left menu");

				throw (e);

			}

			return mainElement;
		}

		public static WebElement Profile() throws Exception {

			try {
				Log.info("Locating Profile element");
				mainElement = Driver.findElement(By.xpath("//a[@title='Profile']"));
				Utils.highLight(mainElement);
				Log.info("Profile link is found on MyAccount left menu");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method Profile");
				Log.error("Profile link is not found on MyAccount left menu");

				throw (e);

			}

			return mainElement;
		}

		public static WebElement Personalization() throws Exception {

			try {
				Log.info("Locating Personalization element");
				mainElement = Driver.findElement(By.xpath("//a[contains(text(),'Personalization')]"));
				Utils.highLight(mainElement);
				Log.info("Personal link is found on MyAccount left menu");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method Personalization");
				Log.error("Personal link is not found on MyAccount left menu");

				throw (e);

			}

			return mainElement;
		}

		public static WebElement FirstCitizenLink() throws Exception {

			try {
				Log.info("Locating FirstCitizen Link element");
				mainElement = Driver.findElement(By.xpath("//ul//li/a[@title='First Citizen']"));
				Utils.highLight(mainElement);
				Log.info("FirstCitizen link is found on MyAccount left menu");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method FirstCitizenLink");
				Log.error("First Citizen link is not found on MyAccount left menu");
				throw (e);

			}

			return mainElement;
		}
		
		public static WebElement Feedback() throws Exception {

			try {
				Log.info("Locating Feedback element");
				mainElement = Driver.findElement(By.xpath("//a[@title='Feedback']"));
				Utils.highLight(mainElement);
				Log.info("Feedback link is found on MyAccount left menu");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method Feedback");
				Log.error("Feedback link is not found on MyAccount left menu");

				throw (e);

			}

			return mainElement;
		}

		public static WebElement ReviewsRatings() throws Exception {

			try {
				Log.info("Locating ReviewsRatings element");
				mainElement = Driver.findElement(By.xpath("//a[@title='Reviews & Ratings']"));
				Utils.highLight(mainElement);
				Log.info("Reviews & Ratings link is found on MyAccount left menu");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ReviewsRatings");
				Log.error("Reviews & Ratings link is not found on MyAccount left menu");

				throw (e);

			}

			return mainElement;
		}

		public static WebElement ShoppingList() throws Exception {

			try {
				Log.info("Locating ShoppingList element");
				mainElement = Driver.findElement(By.linkText("Saved Shopping Lists"));
				Utils.highLight(mainElement);
				Log.info("ShoppingList link is found on MyAccount left menu");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ShoppingList");
				Log.error("ShoppingList link is not found on MyAccount left menu");

				throw (e);

			}
			return mainElement;
		}

		public static WebElement MyOrders() {
			try {
				Log.info("Locating MyOrders element");
				mainElement = Driver.findElement(By.xpath("//a[@title='My Orders']"));
				Utils.highLight(mainElement);
				Log.info("MyOrders link is found on MyAccount left menu");
			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method MyOrders");
				Log.error("MyOrders link is not found on MyAccount left menu");
				throw (e);
			}
			return mainElement;
		}

		public static WebElement PickupOrders() {
			try {
				Log.info("Locating Pickup Orders element");
				mainElement = Driver.findElement(By.xpath("//a[@title='Pick Up Orders']"));
				Utils.highLight(mainElement);
				Log.info("Pickup Orders link is found on MyAccount left menu");
			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method PickupOrders");
				Log.error("PickupOrders link is not found on MyAccount left menu");
				throw (e);
			}
			return mainElement;
		}

		public static WebElement ReturnOrders() {
			try {
				Log.info("Locating ReturnOrders Orders element");
				mainElement = Driver.findElement(By.xpath("//a[@title='Return/Exchanges']"));
				Utils.highLight(mainElement);
				Log.info("Return/ExchangeOrders link is found on MyAccount left menu");
			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ReturnOrders");
				Log.error("Return/ExchangeOrders link is not found on MyAccount left menu");
				throw (e);
			}
			return mainElement;
		}

		public static WebElement OrdersSection() {
			try {
				Log.info("Locating OrdersSection element");
				mainElement = Driver.findElement(By.xpath("//li[@class='active-parent drop-menu active'][1]/a[1]"));
				Utils.highLight(mainElement);
				Log.info("OrdersSection link is found on MyAccount left menu");
			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method OrdersSection");
				Log.error("OrdersSection link is not found on MyAccount left menu");
				throw (e);
			}
			return mainElement;
		}

		public static WebElement ShoppersStopWallet() {
			try {
				Log.info("Locating ShoppersStopWallet element");
				mainElement = Driver.findElement(By.xpath("//a[@title='Shoppers Stop Wallet']"));
				Utils.highLight(mainElement);
				Log.info("ShoppersStopWallet link is found on MyAccount left menu");
			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method ShoppersStopWallet");
				Log.error("ShoppersStopWallet link is not found on MyAccount left menu");
				throw (e);
			}
			return mainElement;
		}
		public static WebElement FirstCitizen() throws Exception {
			try {
				Log.info("Locating FirstCitizen element");
				mainElement = Driver.findElement(By.xpath("//a[@title='First Citizen']"));
				Utils.highLight(mainElement);
				Log.info("FirstCitizen link is found on MyAccount left menu");
			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method FirstCitizen");
				Log.error("FirstCitizen link is not found on MyAccount left menu");
				throw (e);
			}
			return mainElement;
		}
		public static WebElement GiftCardGiftVouchers() throws Exception {
			try {
				Log.info("Locating Gift Card/Gift Vouchers element");
				mainElement = Driver.findElement(By.xpath("//a[@title='Gift Card/Gift Vouchers']"));
				Utils.highLight(mainElement);
				Log.info("Gift Card/Gift Vouchers link is found on MyAccount left menu");
			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method Gift Card/Gift Vouchers");
				Log.error("Gift Card/Gift Vouchers link is not found on MyAccount left menu");
				throw (e);
			}
			return mainElement;
		}	
		public static WebElement SavedCards() throws Exception {
			try {
				Log.info("Locating Saved Cards element");
				mainElement = Driver.findElement(By.xpath("//a[@title='Saved Cards']"));
				Utils.highLight(mainElement);
				Log.info("Saved Cards link is found on MyAccount left menu");
			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method Saved Cards");
				Log.error("Saved Cards link is not found on MyAccount left menu");
				throw (e);
			}
			return mainElement;
		}
		public static WebElement Paymentsection() throws Exception {
			try {
				Log.info("Locating Paymentsection element");
				mainElement = Driver.findElement(By.xpath("//li[@class='active-parent drop-menu active'][2]/a[1]"));
				Utils.highLight(mainElement);
				Log.info("Paymentsection link is found on MyAccount left menu");
			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method Paymentsection");
				Log.error("Paymentsection link is not found on MyAccount left menu");
				throw (e);
			}
			return mainElement;
		}
		public static WebElement Addresses() throws Exception {

			try {
				Log.info("Locating Addresses element");
				mainElement = Driver.findElement(By.xpath("//a[@title='Addresses']"));
				Utils.highLight(mainElement);
				Log.info("Addresses link is found on MyAccount left menu");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method Addresses");
				Log.error("Addresses link is not found on MyAccount left menu");

				throw (e);

			}

			return mainElement;
		}
		public static WebElement NewsletterSubscription() throws Exception {

			try {
				Log.info("Locating Newsletter Subscription element");
				mainElement = Driver.findElement(By.xpath("//a[@title='Newsletter Subscription']"));
				Utils.highLight(mainElement);
				Log.info("Newsletter Subscription link is found on MyAccount left menu");

			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method Newsletter Subscription");
				Log.error("Newsletter Subscription link is not found on MyAccount left menu");

				throw (e);

			}

			return mainElement;
		}

		public static WebElement MyInfoSection() {
			try {
				Log.info("Locating MyInfoSection element");
				mainElement = Driver.findElement(By.xpath("//li[@class='active-parent drop-menu active'][3]/a[1]"));
				Utils.highLight(mainElement);
				Log.info("MyInfoSection link is found on MyAccount left menu");
			} catch (Exception e) {
				Log.error("Exception in Class MyAccount_Page | Method MyInfoSection");
				Log.error("MyInfoSection link is not found on MyAccount left menu");
				throw (e);
			}
			return mainElement;
		}
	}
	
	public static WebElement allSelect_CkeckBox()
	{
		try {
			Log.info("Locating AllSelect Ckeckbox element");
			element = Driver.findElement(By.xpath("//input[@id='All']"));
			Utils.highLight(element);
			Log.info("AllSelect Ckeckbox is found on Newsletter Subscription page");
		} catch (Exception e) {
			Log.error("Exception in Class MyAccount_Page | Method allSelect_CkeckBox");
			Log.error("AllSelect Ckeckbox is not found on MyAccount left menu");
			throw (e);
		}
		return element;
	
	}
	
	public static WebElement frequency_RadioButton()
	{
		try {
			Log.info("Locating Frequency_Radio Button element");
			element = Driver.findElement(By.xpath("//input[@id='Daily']"));
			Utils.highLight(element);
			Log.info("Frequency_Radio Button is found on MyAccount left menu");
		} catch (Exception e) {
			Log.error("Exception in Class MyAccount_Page | Method frequency_RadioButton");
			Log.error("Frequency_Radio Button is not found on MyAccount left menu");
			throw (e);
		}
		return element;
	
	}
	
	
	public static WebElement update_Newsletter_Button()
	{
		try {
			Log.info("Locating update Newsletter Button element");
			element = Driver.findElement(By.xpath("//button[@id='updateBtnId']"));
			Utils.highLight(element);
			Log.info("update Newsletter Button is found on Newsletter Subscription page");
		} catch (Exception e) {
			Log.error("Exception in Class MyAccount_Page | Method update_Newsletter_Button");
			Log.error("update Newsletter Button is not found on MyAccount left menu");
			throw (e);
		}
		return element;
	
	}
	
	public static WebElement unsubscribe_Me_From_All_Mails_Link()
	{
		try {
			Log.info("Locating unsubscribe_Me_From_All_Mails Link element");
			element = Driver.findElement(By.xpath("//a[@id='unsuscribeLinkId']"));
			Utils.highLight(element);
			Log.info("unsubscribe_Me_From_All_Mails Link is found on Newsletter Subscription page");
		} catch (Exception e) {
			Log.error("Exception in Class MyAccount_Page | Method unsubscribe_Me_From_All_Mails_Link");
			Log.error("unsubscribe_Me_From_All_Mails Link is not found on Newsletter Subscription page");
			throw (e);
		}
		return element;
	
	}
	
	public static WebElement recent_Orders_Text()
	{
		try {
			Log.info("Locating Recent_Orders Text element");
			element = Driver.findElement(By.xpath("//h2[.='Recent Orders']"));
			Utils.highLight(element);
			Log.info("Recent_Orders Text is found on My_Account page");
		} catch (Exception e) {
			Log.error("Exception in Class MyAccount_Page | Method recent_Orders_Text");
			Log.error("Recent_Orders Text is not found on My_Account page");
			throw (e);
		}
		return element;
	}
	
	public static List<WebElement> recent_Order_Details()
	{
		try {
			Log.info("Locating Recent_Orders details elements");
			elementList = Driver.findElements(By.xpath("//div[@class='recent-order-box']//ul/li"));
			Log.info("Recent_Orders details elements are found on My_Account page");
		} catch (Exception e) {
			Log.error("Exception in Class MyAccount_Page | Method recent_Order_Details");
			Log.error("Recent_Orders details elements are not found on My_Account page");
			throw (e);
		}
		return elementList;
	}
	
	public static WebElement view_Order_Details_Button()
	{
		try {
			Log.info("Locating view_Order_Details Button element");
			element = Driver.findElement(By.xpath("//button[.='View order details']"));
			Utils.highLight(element);
			Log.info("view_Order_Details Button is found on My_Account page");
		} catch (Exception e) {
			Log.error("Exception in Class MyAccount_Page | Method view_Order_Details_Button");
			Log.error("view_Order_Details Button is not found on My_Account page");
			throw (e);
		}
		return element;
	}
	
	public static WebElement order_Summary()
	{
		try {
			Log.info("Locating order_Summary element");
			element = Driver.findElement(By.xpath("//div[@class='order-info']"));
			Utils.highLight(element);
			Log.info("order_Summary is found on My_Account page");
		} catch (Exception e) {
			Log.error("Exception in Class MyAccount_Page | Method order_Summary");
			Log.error("order_Summary is not found on My_Account page");
			throw (e);
		}
		return element;
	}
}
