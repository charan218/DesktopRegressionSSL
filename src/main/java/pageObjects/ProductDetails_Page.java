package pageObjects;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;
import utility.Utils;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;
import utility.Utils;

public class ProductDetails_Page extends BaseClass {

	private static WebElement element;
	private static List<WebElement> element2;
	private static List<WebElement> elements;
	static String element1;
	public static String ProductName;

	public ProductDetails_Page(WebDriver driver) {

		super(driver);

	}
	
	public static WebElement GlobalMsg() throws Exception {

		try {
			Log.info("Locating GlobalMsg element");
			element = Driver.findElement(By.xpath("//div[@class='alert alert-info alert-dismissable']"));
			Utils.highLight(element);
			Log.info(" Message field is found on the Page");

		} catch (Exception e) {
			Log.error("Exception in Class MyAccount_Page | Method GlobalMsg");
			Log.error("Message field is not found on the Page");
			throw e;
		}

		return element;

	}

	public static WebElement breadCrumb() throws Exception {

		try {
			Log.info("Locating breadCrumb element");
			element = Driver.findElement(By.xpath("//ol[@class='breadcrumb']"));
			Utils.highLight(element);
			Log.info("BreadCrumb is found on PDP");

		} catch (Exception e) {
			Log.error("Exception in Class ProductDetails_Page | Method breadCrumb");
			Log.error("BreadCrumb is not found on PDP");
			throw (e);

		}

		return element;

	}
	
	
	

	public static class PersistenceProduct {

		public static WebElement persistentHeader() throws Exception {

			try {
				Log.info("Locating persistentHeader element");
				element = Driver.findElement(By.xpath("//section[@class='pdp-sticky' and contains(@style, 'block')]"));
				Utils.highLight(element);
				Log.info("Persistent Product Header is found on PDP");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method persistentHeader");
				Log.error("Persistent Product Header is not found on PDP");

				throw (e);

			}

			return element;

		}

		public static WebElement productPicture() throws Exception {

			try {
				Log.info("Locating productPicture element");
				element = Driver.findElement(By.xpath("//section[@class='pdp-sticky']//div[@class='pic']"));
				Utils.highLight(element);
				Log.info("Product picture is found on Persistent header");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method productPicture");
				Log.error("Product picture is not found on Persistent header");

				throw (e);

			}

			return element;

		}

		public static WebElement productName() throws Exception {

			try {
				Log.info("Locating productName element");
				element = Driver.findElement(By.xpath("//section[@class='pdp-sticky']//h4"));

				Log.info("Product name is found on Persistent header");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method productName");
				Log.error("Product name is not found on Persistent header");

				throw (e);

			}

			return element;

		}

		public static WebElement productSize() throws Exception {

			try {
				Log.info("Locating productSize element");
				element = Driver.findElement(By.xpath("//section[@class='pdp-sticky']//div[@class='size-guide']"));

				Log.info("Product size is found on Persistent header");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method productSize");
				Log.error("Product size is not found on Persistent header");

				throw (e);

			}

			return element;

		}

		public static WebElement productAddToCart() throws Exception {

			try {
				Log.info("Locating productAddToCart element");
				element = Driver.findElement(By.xpath("//section[@class='pdp-sticky']//*[@id='addToCartButton']"));

				Log.info("Product add to cart button is found on Persistent header");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method productAddToCart");
				Log.error("Product add to cart button is not found on Persistent header");

				throw (e);

			}

			return element;

		}

		public static WebElement productQty() throws Exception {

			try {
				Log.info("Locating productQty element");
				//element = Driver.findElement(By.xpath("//section[@class='pdp-sticky']//*[@class='qty']"));
				element = Driver.findElement(By.xpath("//section[@class='pdp-sticky']//div[@class='qty clearfix']"));

				Log.info("Product quantity is found on Persistent header");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method productQty");
				Log.error("Product quantity is not found on Persistent header");

				throw (e);

			}

			return element;

		}
	}

	public static class Product {

		public static WebElement Product_Code() throws Exception {

			try {
				Log.info("Locating Product_Code element");
				element = Driver.findElement(
						By.xpath("//*[@class='product_details']//li[@class='product_inner_content']//p//span"));
				Utils.highLight(element);
				Log.info("Product code found on PDP");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method Product_Code");
				Log.error("Product code not found on PDP");

				throw (e);

			}

			return element;

		}

		public static WebElement txt_Price() throws Exception {
			try {
				Log.info("Locating txt_Price element");
				element = Driver.findElement(By.xpath("(//div[@class='pdp-price'])"));
				Utils.highLight(element);
				Log.info("Product price found on PDP");
			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method txt_Price");
				Log.error("Product price not found on PDP");

				throw (e);
			}
			return element;
		}
		
		public static List<WebElement> shopSimilar_product_Price() throws Exception {
			try {
				Log.info("Locating shopSimilar_product_Price element");
				element2 = Driver.findElements(By.xpath(
						"//div[@id='shopSimilarRecommendations']//div[@class='price_div']"));
				Utils.HighlightAllElementOneByOne(element2);
				Log.info("shopSimilar_product_Price found on PDP");
			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method shopSimilar_product_Price");
				Log.error(" shopSimilar_product_Price not found on PDP");

				throw (e);
			}
			return element2;
		}		
		
		
		public static List<WebElement> shopSimilar_product_Name() throws Exception {
			try {
				Log.info("Locating shopSimilar_product_Name element");
				element2 = Driver.findElements(By.xpath(
						"//div[@id='shopSimilarRecommendations']//div[@class='pro-name']"));
				Utils.HighlightAllElementOneByOne(element2);
				Log.info("shopSimilar_product_Name found on PDP");
			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method shopSimilar_product_Name");
				Log.error(" shopSimilar_product_Name not found on PDP");

				throw (e);
			}
			return element2;
		}		
		
		public static List<WebElement> shopSimilar_product_BrandName() throws Exception {
			try {
				Log.info("Locating shopSimilar_product_Name element");
				element2 = Driver.findElements(By.xpath(
						"//div[@id='shopSimilarRecommendations']//div[@class='Brand-name']"));
				Utils.HighlightAllElementOneByOne(element2);
				Log.info("shopSimilar_product_Name found on PDP");
			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method shopSimilar_product_Name");
				Log.error(" shopSimilar_product_Name not found on PDP");

				throw (e);
			}
			return element2;
		}	
		
		
		public static List<WebElement> shopSimilar_product_img() throws Exception {
			try {
				Log.info("Locating shopSimilar_product_Name element");
				element2 = Driver.findElements(By.xpath(
						"//div[@id='shopSimilarRecommendations']//div[@class='pro-img-pdp']"));
				Utils.HighlightAllElementOneByOne(element2);
				Log.info("shopSimilar_product_Name found on PDP");
			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method shopSimilar_product_Name");
				Log.error(" shopSimilar_product_Name not found on PDP");

				throw (e);
			}
			return element2;
		}


		public static WebElement color_variant() throws Exception {

			try {
				Log.info("Locating color_variant element");
				element = Driver.findElement(By.xpath(
						"//div[@class='variant-name']"));
				Utils.highLight(element);
				Log.info("Product color variant found on PDP");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method color_variant");
				Log.error("Product color variant not found on PDP");

				throw (e);

			}

			return element;

		}

		
		public static WebElement size_variant() throws Exception {

			try {
				Log.info("Locating size_variant element");
				element = Driver.findElement(By.xpath(
						"//div[@class='size_width size_button']"));
				Utils.highLight(element);
				Log.info("Product size variant found on PDP");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method size_variant");
				Log.error("Product size variant not found on PDP");

				throw (e);

			}

			return element;

		}
		
		public static List<WebElement> size_variant_buttonlist() throws Exception {

			try {
				Log.info("Locating size variant button list element");
				Thread.sleep(3000);
				element2 =Driver.findElements(By.xpath("//*[@class='variant_size_ulClass']/li/button[@type='button']"));
				//button[@type='button']
				Utils.waitForElementsLongTime(element2);
				Utils.HighlightAllElementOneByOne(element2);
				Log.info("Product size variant button list found on PDP "+element2.size());

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method size_variant_buttonlist");
				Log.error("Product size variant button list not found on PDP");

				throw (e);

			}

			return element2;

		}
		
		
		
		
		
		public static List<WebElement> color_variant_buttonlist() throws Exception {

			try {
				Log.info("Locating color_variant_buttonlist list element");
				element2 = Driver.findElements(By.xpath("//ul[@class='variant-list']//button"));
				Utils.HighlightAllElementOneByOne(element2);
				Log.info("Product color_variant_buttonlist  found on PDP");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method color_variant_buttonlist");
				Log.error("color_variant_buttonlist button list not found on PDP");
				throw (e);

			}

			return element2;

		}

		public static WebElement productPicture() throws Exception {

			try {
				Log.info("Locating productPicture element");
				element = Driver.findElement(
						By.xpath("(.//*[@id='imageZoom']/img)[1]"));
				Log.info("Product image found on PDP");
				Utils.highLight(element);
			} catch (Exception e) {

				Log.error("Product image not found on PDP");
				Log.error("Exception in Class ProductDetails_Page | Method productPicture");
				throw (e);

			}

			return element;

		}

		public static WebElement description_tabs() throws Exception {

			try {
				Log.info("Locating description_tabs element");
				element = Driver.findElement(By.xpath("//*[@class='Des_tabs']"));
				Utils.highLight(element);
				Log.info("Product description tabs found on PDP");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method description_tabs");
				Log.error("Product description tabs not found on PDP");

				throw (e);

			}

			return element;

		}

		public static WebElement description_content() throws Exception {

			try {
				Log.info("Locating description_content element");
				element = Driver.findElement(By.xpath("//*[@class='Des_wrap']"));
				Utils.highLight(element);
				Log.info("Product description content found on PDP");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method description_content");
				Log.error("Product description content not found on PDP");

				throw (e);

			}

			return element;

		}

		public static WebElement product_thumbnails() throws Exception {

			try {
				Log.info("Locating product_thumbnails element");
				element = Driver.findElement(By.xpath("//*[@id='carousel']"));

				Log.info("Product Thumbnails are found on PDP");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method product_thumbnails");
				Log.error("Product Thumbnails are not found on PDP");

				throw (e);

			}

			return element;

		}

		public static WebElement ZoomBtn() throws Exception {

			try {
				Log.info("Locating ZoomBtn element");
				element = Driver.findElement(By.xpath("//span[@class='zoom_icon zoom_product']"));

				Log.info("Product Zoom buton is found on PDP");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method ZoomBtn");
				Log.error("Product Zoom buton is not found on PDP");

				throw (e);

			}

			return element;

		}

		public static WebElement ZoomInWindowDiv() throws Exception {

			try {
				Log.info("Locating ZoomInWindowDiv element");
				element = Driver.findElement(By.xpath("//div[@class='product_zooming' and contains(@style, 'block')]"));

				Log.info("Product Zoom in window div is found on PDP");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method ZoomInWindowDiv");
				Log.error("Product Zoom in window div is not found on PDP");

				throw (e);

			}

			return element;

		}

		public static WebElement ZoomInWindowCloseBtn() throws Exception {

			try {
				Log.info("Locating ZoomInWindowCloseBtn element");
				element = Driver.findElement(By.xpath("//span[@class='zoom_close']"));
				Utils.highLight(element);
				Log.info("Zoom in window close button is found on PDP");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method ZoomInWindowCloseBtn");
				Log.error("Zoom in window close button is not found on PDP");

				throw (e);

			}

			return element;

		}

		public static WebElement AddToCartBtn_ZoomPopUp() throws Exception {

			try {
				Log.info("Locating AddToCartBtn_ZoomPopUp element");
				element = Driver.findElement(By.xpath("//div[@class='product_zooming']//*[@id='addToCartButton']"));

				Log.info("Add to cart button is found on PDP");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method AddToCartBtn_ZoomPopUp");
				Log.error("Add to cart button is not found on PDP");

				throw (e);

			}

			return element;

		}

		public static WebElement Product_Unit() throws Exception {

			try {
				Log.info("Locating Product_Unit element");
				element = Driver.findElement(By.xpath("//section[@class='product_details_main']//*[@id='qty']"));
				Utils.highLight(element);
				Log.info("Product Unit field found");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method Product_Unit");
				Log.error("Product Unit field not found");

				throw (e);

			}

			return element;

		}

		public static WebElement Product_Name() throws Exception {

			try {
				Log.info("Locating Product_Name element");
				element = Driver.findElement(By.xpath(
						"//div[@class='pdp-bname']"));
				Utils.highLight(element);
				Log.info("Product name field is found");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method Product_Name");
				Log.error("Product name field is not found");
				throw (e);
			}
			return element;
		}
		

		public static WebElement Average_Ratings() throws Exception {

			try {
				Log.info("Locating Average_Ratings element");
				element = Driver.findElement(By.xpath(
						"//div[@class='rating-like-count-container']/ul/li[1]"));
				Utils.highLight(element);
				Log.info("Average Ratings is found");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method Average_Ratings");
				Log.error("Average_Ratings is not found");
				throw (e);
			}
			return element;
		}	
		
		
		public static WebElement Recomendations_Count() throws Exception {

			try {
				Log.info("Locating Recomendations_Count element");
				element = Driver.findElement(By.xpath(
						"//div[@class='rating-like-count-container']/ul/li[2]"));
				Utils.highLight(element);
				Log.info("Recomendations_Count is found");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method Recomendations_Count");
				Log.error("Recomendations_Count is not found");
				throw (e);
			}
			return element;
		}
		
		
		public static WebElement Selecting_Colour() throws Exception {

			try {
				Log.info("Locating Selecting_Colour dropdown");
				element = Driver.findElement(By.xpath("//select[@onchange='changeColorVariant();']"));
				Utils.highLight(element);
				Log.info("Selecting_Colour dropdown is found");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method Selecting_Colour");
				Log.error("Selecting_Colour dropdown is not found");
				throw (e);
			}
			return element;
		}
		
		public static WebElement SelectSize_Label() throws Exception {

			try {
				Log.info("Locating SelectSize_Label");
				element = Driver.findElement(By.xpath("//span[contains(.,'Select Size')]"));
				Utils.highLight(element);
				Log.info("SelectSize_Label is found");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method SelectSize_Label");
				Log.error("SelectSize_Label is not found");
				throw (e);
			}
			return element;
		}
		public static WebElement Similarproduct_AddToCart() throws Exception {

			try {
				Log.info("Locating Similarproduct_AddToCart");
				element = Driver.findElement(By.xpath("(//button[contains(@class,'dy-addToBagButton')])[1]"));
				Utils.highLight(element);
				Log.info("Similarproduct_AddToCart is found");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method Similarproduct_AddToCart");
				Log.error("Similarproduct_AddToCart is not found");
				throw (e);
			}
			return element;
		}	
		
		public static WebElement Similarproduct_AddToCart_Popup() throws Exception {

			try {
				Log.info("Locating Similarproduct_AddToCart_Popup");
				element = Driver.findElement(By.xpath("//*[@id=\"dyId8fa411705c4bad5d\"]/div/div/div[2]/div[2]/div/div[1]/div/div/div/div[1]/ul"));
				Utils.highLight(element);
				Log.info("Similarproduct_AddToCart_Popup is found");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method Similarproduct_AddToCart_Popup");
				Log.error("Similarproduct_AddToCart_Popup is not found");
				throw (e);
			}
			return element;
		}	
		
		public static WebElement Similarproduct_Wishlist() throws Exception {

			try {
				Log.info("Locating Similarproduct_Wishlist");
				element = Driver.findElement(By.xpath("//button[contains(@class,'go_link wishlistSubmitBtn wishlist ')]"));
				Utils.highLight(element);
				Log.info("Similarproduct_Wishlist is found");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method Similarproduct_Wishlist");
				Log.error("Similarproduct_Wishlist is not found");
				throw (e);
			}
			return element;
		}	
		
		
		public static WebElement CalculateyourSize_Link() throws Exception {

			try {
				Log.info("Locating KnowyourSize_Link");
				element = Driver.findElement(By.xpath("(//span[contains(.,'Calculate Your Size')])[2]"));
				Utils.highLight(element);
				Log.info("KnowyourSize_Link is found");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method KnowyourSize_Link");
				Log.error("KnowyourSize_Link is not found");
				throw (e);
			}
			return element;
		}	
			
		
		public static WebElement KnowyourSize_Popup() throws Exception {

			try {
				Log.info("Locating KnowyourSize_Popup");
				element = Driver.findElement(By.xpath("(//h2[contains(.,'Calculate your Size')])[2]"));
				Utils.highLight(element);
				Log.info("KnowyourSize_Popup is found");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method KnowyourSize_Popup");
				Log.error("KnowyourSize_Popup is not found");
				throw (e);
			}
			return element;
		}		
		///////////
		public static WebElement SizePopupCross() throws Exception{
			element=Driver.findElement(By.xpath("(//a[contains(@id,'snf5342-widget-close')])[2]"));
			Utils.highLight(element);
			return element;
		}
		////////////////
		
		
		public static WebElement Next_Arrow() throws Exception{
			Driver.findElement(By.xpath("//div[@class='pdp-slider-container']//a[text()='Next']"));
			Utils.highLight(element);
			return element;
		}

		public static WebElement Product_Star_Rating() throws Exception {

			try {
				Log.info("Locating Product_Star_Rating element");
				element = Driver.findElement(By.xpath(
						".//*[@id='rating_review_main']//div[@class='sm_startrate']"));
				Utils.highLight(element);
				Log.info("Rating field is found");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method Product_Star_Rating");
				Log.error("Rating field is not found");

				throw (e);

			}

			return element;

		}

		public static WebElement Product_AddToCart() throws Exception {

			try {
				Log.info("Locating Product_AddToCart element");
				////
				//element = Driver.findElement(By.xpath("(.//*[@id='addToCartButton'])"));
				element = Driver.findElement(By.xpath("(//input[@value='Add to bag'])[1]"));
				////
				Utils.highLight(element);
				Log.info("Add to cart button is found on page");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method Product_AddToCart");
				Log.error("Add to cart button is not found on page");

				throw (e);

			}

			return element;

		}
		
		public static WebElement FCC_Product_AddToCart() throws Exception {

			try {
				Log.info("Locating Product_AddToCart element");
				element = Driver
						.findElement(By.xpath(".//*[@id='addToCartButton']"));
				Utils.highLight(element);
				Log.info("Add to cart button is found on page");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method Product_AddToCart");
				Log.error("Add to cart button is not found on page");

				throw (e);

			}

			return element;

		}
		
		
		
		public static WebElement WishList_AddToCart() throws Exception {

			try {
				Log.info("Locating WishList_AddToCart element");
				element = Driver
						.findElement(By.xpath(".//*[@id='addToCartButtonCart_id']"));
				Utils.highLight(element);
				Log.info("Add to cart button is found on page");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method Product_AddToCart");
				Log.error("Add to cart button is not found on page");

				throw (e);

			}

			return element;
		}

		public static List<WebElement> SoclialShare() throws Exception {

			try {
				Log.info("Locating SoclialShare element");
				elements = Driver
						.findElements(By.xpath("//*[@class='shareicon-wishlist']/li"));
				Utils.HighlightAllElementOneByOne(elements);
				Log.info("SoclialShare is found on page");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method SoclialShare");
				Log.error("SoclialShare button is not found on page");

				throw (e);

			}

			return elements;

	}

		public static List<WebElement> SoclialShareIcon() throws Exception {

			try {
				Log.info("Locating SoclialShare element");
				elements = Driver
						.findElements(By.xpath("//div[contains(@class,'soc-ico')]//a[@class='shareIcon']"));
				Utils.HighlightAllElementOneByOne(elements);
				Log.info("SoclialShare is found on page");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method SoclialShare");
				Log.error("SoclialShare button is not found on page");

				throw (e);

			}

			return elements;

	}		
		
		
		
		public static List<WebElement> ShareProductImageIcon() throws Exception {

			try {
				Log.info("Locating ShareProductImageIcon element");
				elements = Driver
						.findElements(By.xpath("//div[contains(@class,'social_icon')]/a"));
				Utils.HighlightAllElementOneByOne(elements);
				Log.info("ShareProductImageIcon is found on page");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method ShareProductImageIcon");
				Log.error("ShareProductImageIcon icon is not found on page");

				throw (e);

			}

			return elements;

	}
			public static WebElement WishlistQuickbtn() throws Exception {

				try {
					Log.info("Locating WishlistQuickbtn element");
					element = Driver
							.findElement(By.xpath(".//*[@id='HashPosition']/div[1]"));
					Utils.highLight(element);
					Log.info("WishlistQuickbtn is found on page");

				} catch (Exception e) {
					Log.error("Exception in Class ProductDetails_Page | Method Product_AddToCart");
					Log.error("Add to cart button is not found on page");

					throw (e);

				}

				return element;

		}

			public static WebElement WishlistProduct() throws Exception {

				try {
					Log.info("Locating WishlistProduct element");
					element = Driver
							.findElement(By.xpath(".//*[@id='HashPosition']"));
					Utils.highLight(element);
					Log.info("WishlistProduct");

				} catch (Exception e) {
					Log.error("Exception in Class ProductDetails_Page | Method Product_AddToCart");
					Log.error("Add to cart button is not found on page");

					throw (e);

				}

				return element;

		}
		public static List<WebElement> AddToWishlistElementList() throws Exception {

			try {
				Log.info("Locating AddToWishlistElementList elements");
				element2 = Driver.findElements(By.xpath("//*[@id='addwishlistId']"));
			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method AddToWishlistElementList");
			}
			return element2;

		}

		public static WebElement AddToWishlistBtn() throws Exception {

			try {
				Log.info("Locating AddToWishlistBtn element");

				element = Driver.findElement(By.xpath("//button[contains(@id,'addwishlistId')]"));
				
				//element = Driver.findElement(By.xpath("html/body/main/header/div/div/div/div[5]/ul/li[3]/a"));
				Utils.highLight(element);
				Log.info("Add to wishlist button is found on page");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method AddToWishlistBtn");
				Log.error("Add to wishlist button is not found on page");

				throw (e);

			}

			return element;

		}
		
		public static WebElement AddToWishlistBtnProduct() throws Exception {

			try {
				Log.info("Locating AddToWishlistBtn element");

				element = Driver.findElement(By.xpath("//*[@id='addwishlistId']"));
				Utils.highLight(element);

				Log.info("Add to wishlist button is found on page");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method AddToWishlistBtn");
				Log.error("Add to wishlist button is not found on page");

				throw (e);

			}

			return element;

		}

		public static WebElement RemoveFromWishlistLabel() throws Exception {

			try {
				Log.info("Locating RemoveFromWishlistLabel element");
				//element = Driver.findElement(By.xpath("//*[@id='addwishlistId']/label[text()='Remove from WishList']"));
				element = Driver.findElement(By.xpath("//*[contains(text(),'Remove from WishList')]"));
				
				Utils.highLight(element);
				Log.info("Remove from wishlist text is found on page");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method RemoveFromWishlistLabel");
				Log.error("Remove from wishlist text is not found on page");

				throw (e);

			}

			return element;

		}

		public static WebElement Product_CODBtn() throws Exception {

			try {
				Log.info("Locating Product_CODBtn element");
				element = Driver.findElement(By.xpath("//div[@class='product_description']//*[@id='cashon']"));
				Utils.highLight(element);
				Log.info("COD link is present on the page");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method Product_CODBtn");
				Log.error("COD link is not present on the page");

				throw (e);

			}

			return element;

		}

		public static WebElement WriteReview() throws Exception {

			try {
				Log.info("Locating WriteReview element");
				element = Driver.findElement(By.xpath("//div[@class='product_description']//a[@class='scroll']"));
				Utils.highLight(element);
				Log.info("Write review link is present on the page");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method WriteReview");
				Log.error("Write review link is not present on the page");

				throw (e);

			}

			return element;

		}

		public static WebElement PinCode() throws Exception {

			try {
				Log.info("Locating PinCode element");
				element = Driver.findElement(By.xpath("//*[@id='pincodetxt']"));
				Utils.highLight(element);
				Log.info("PinCode field is present on the page");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method PinCode");
				Log.error("PinCode field is not present on the page");

				throw (e);

			}

			return element;

		}

		public static WebElement PinCodeChange() throws Exception {

			try {
				Log.info("Locating PinCodeChange element");
				element = Driver.findElement(By.xpath("//div[@class='product_description']//*[@id='pincodetxt']"));
				Utils.highLight(element);
				Log.info("PinCode field is present on the page");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method PinCodeChange");
				Log.error("PinCode field is not present on the page");

				throw (e);

			}

			return element;

		}

		public static WebElement PinCodeCheckBtn() throws Exception {

			try {
				Log.info("Locating PinCodeCheckBtn element");
				element = Driver.findElement(By.xpath("//input[@class='codbtn']"));
				Utils.highLight(element);
				Log.info("PinCode check button is present on the page");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method PinCodeCheckBtn");
				Log.error("PinCode check button is not present on the page");

				throw (e);

			}

			return element;

		}

		public static WebElement PinCodeSuccessMsg() throws Exception {

			try {
				Log.info("Locating PinCodeSuccessMsg element");
				element = Driver.findElement(By.xpath("//div[@class='messagessection']"));
				
				Utils.highLight(element);
				Log.info("PinCode success message is present on the page");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method PinCodeSuccessMsg");
				Log.error("PinCode success message is not present on the page");

				throw (e);

			}

			return element;

		}

		public static WebElement InvalidPinCodeMsg() throws Exception {

			try {
				Log.info("Locating InvalidPinCodeMsg element");
				element = Driver.findElement(By.xpath("//div[@class='messagessection']//p[@class='updated-pincode delfail']/span"));		
				Utils.highLight(element);
				Log.info("Invalid pincode message is present on the page");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method InvalidPinCodeMsg");
				Log.error("Invalid pincode message is present on the page");

				throw (e);

			}

			return element;

		}

		public static WebElement InvalidDeliveryAddMsg() throws Exception {

			try {
				Log.info("Locating InvalidDeliveryAddMsg element");
				element = Driver.findElement(By.xpath("//div[@class='product_description']//p[@class='pinwrong']"));
				Utils.highLight(element);
				Log.info("Invalid delivery address message is present on the page");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method InvalidDeliveryAddMsg");
				Log.error("Invalid delivery address message is not present on the page");

				throw (e);

			}

			return element;

		}

		public static WebElement ChangePinBtn() throws Exception {

			try {
				Log.info("Locating ChangePinBtn element");
				element = Driver.findElement(By.xpath("//*[@id='chngbtn']"));
				Utils.highLight(element);
				Log.info("Change pincode button is present on the page");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method ChangePinBtn");
				Log.error("Change pincode button is not present on the page");

				throw (e);

			}

			return element;

		}

		public static WebElement Social_TwitterLink() throws Exception {

			try {
				Log.info("Locating Social_TwitterLink element");
				element = Driver.findElement(By.xpath("//*[@class='twitter-icon']"));
				Utils.highLight(element);
				Log.info("Twitter link is present on PDP for sharing product details");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method Social_TwitterLink");
				Log.error("Twitter link is not present on PDP for sharing product details");
				throw e;
			}

			return element;

		}

		public static WebElement Social_FacebookLink() throws Exception {

			try {
				Log.info("Locating Social_FacebookLink element");
				element = Driver.findElement(By.xpath("//*[@class='facebook-icon']"));
				Utils.highLight(element);
				Log.info("Facebook link is present on PDP for sharing product details");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method Social_FacebookLink");
				Log.error("Facebook link is not present on PDP for sharing product details");
				throw e;
			}

			return element;

		}

		public static WebElement Social_GooglePlusLink() throws Exception {

			try {
				Log.info("Locating Social_GooglePlusLink element");
				element = Driver.findElement(By.xpath("//*[@class='google-plus-icon']"));
				Utils.highLight(element);
				Log.info("Google Plus link is present on PDP for sharing product details");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method Social_GooglePlusLink");
				Log.error("Google Plus link is not present on PDP for sharing product details");
				throw e;
			}

			return element;

		}
		public static WebElement Social_InstagramLink() throws Exception {

			try {
				Log.info("Locating Social_InstagramLink element");
				element = Driver.findElement(By.xpath("//*[@class='instagram-icon']"));
				Utils.highLight(element);
				Log.info("Social_InstagramLink is present on PDP for sharing product details");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method Social_InstagramLink");
				Log.error("Social_InstagramLink is not present on PDP for sharing product details");
				throw e;
			}

			return element;

		}

		public static WebElement Social_PinterestLink() throws Exception {
			try {
				Log.info("Locating Social_PinterestLink element");
				element = Driver.findElement(By.xpath("//*[@class='pinterest-icon']"));
				Utils.highLight(element);
				Log.info("Pinterest link is present on PDP for sharing product details");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method Social_PinterestLink");
				Log.error("Pinterest link is not present on PDP for sharing product details");
				throw e;
			}
			return element;
		}
		
		
		public static WebElement alterationTag() throws Exception {
			try {
				Log.info("Locating alterationTag element");
				element = Driver.findElement(By.xpath("//span[@class='alteration']"));
				Utils.highLight(element);
				Log.info("alterationTag is present on PDP ");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method alterationTag");
				Log.error("alterationTag is not present on PDP ");
				
			}
			return element;
		}
		
		//span[@class='alteration']
		public static WebElement WriteReviewBtn() throws Exception {

			try {
				Log.info("Locating WriteReviewBtn element");
				element = Driver.findElement(
						By.xpath("//div[@class='overall_rating_main']//a[@class='sbt-button zoom_write']"));
				Utils.highLight(element);
				Log.info("Write a Review button is present on PDP");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method WriteReviewBtn");
				Log.error("Write a Review button is not present on PDP");
				throw e;
			}

			return element;

		}

	}

	public static class ReviewWindow {
		public static WebElement ReviewPopUp() throws Exception {

			try {
				Log.info("Locating ReviewPopUp element");
				element = Driver.findElement(By.xpath("//*[@id='write_review' and contains(@style, 'visible')]"));
				Utils.highLight(element);
				Log.info("Review pop up window is found");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method ReviewPopUp");
				Log.error("Review pop up window is not found");
				throw e;
			}

			return element;

		}

		public static WebElement ReviewTitle() throws Exception {

			try {
				Log.info("Locating ReviewTitle element");
				element = Driver.findElement(By.xpath("//*[@id='reviewHeadline_id']"));
				Utils.highLight(element);
				Log.info("Review title textbox is found on write review pop up");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method ReviewTitle");
				Log.error("Review title textbox is not found on write review pop up");
				throw e;
			}

			return element;

		}

		public static WebElement ReviewDescription() throws Exception {

			try {
				Log.info("Locating ReviewDescription element");
				element = Driver.findElement(By.xpath("//*[@id='reviewComment_id']"));
				Utils.highLight(element);
				Log.info("Review comments textbox is found on write review pop up");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method ReviewDescription");
				Log.error("Review comments textbox is not found on write review pop up");
				throw e;
			}

			return element;

		}

		public static WebElement ReviewSubmitBtn() throws Exception {

			try {
				Log.info("Locating ReviewSubmitBtn element");
				element = Driver.findElement(By.xpath("//*[@id='button']"));
				Utils.highLight(element);
				Log.info("Review submit button is found on write review pop up");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method ReviewSubmitBtn");
				Log.error("Review submit button is not found on write review pop up");
				throw e;
			}

			return element;

		}

		public static WebElement ReviewQuality_VeryGood() throws Exception {

			try {
				Log.info("Locating ReviewQuality_VeryGood element");
				element = Driver.findElement(By.xpath("//*[@class='write_range']//a[text()='4']"));
				Utils.highLight(element);
				Log.info("Review star rating Very Good is found on write review pop up");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method ReviewQuality_VeryGood");
				Log.error("Review star rating Very Good is not found on write review pop up");
				throw e;
			}

			return element;

		}

		public static WebElement ReviewStar_4() throws Exception {

			try {
				Log.info("Locating ReviewStar_4 element");
				element = Driver.findElement(By.xpath("//*[@class='star-rating']/label[@class='star rb3l']"));
				Utils.highLight(element);
				Log.info("Review star rating 4 is found on write review pop up");

			} catch (Exception e) {
				Log.error("Exception in Class ProductDetails_Page | Method ReviewStar_4");
				Log.error("Review star rating 4 is not found on write review pop up");
				throw e;
			}

			return element;

		}
	}
	
	public static WebElement pincode_info() throws Exception {
		try{
			Log.info("Locating pincode field");
			element=Driver.findElement(By.xpath("//span[@class='enter-pin-info']"));
			Utils.highLight(element);
			Log.info("pincode field is displayed");
		} catch (Exception e) {
			Log.error("pincode field is not displayed");
			throw (e);
			}		
		return element;		
	}	
	
	public static WebElement directions_Link() throws Exception {
		try{
			Log.info("Locating directions Link");
			element=Driver.findElement(By.xpath("//a[contains(.,'Directions')]"));
			Utils.highLight(element);
			Log.info("Directions Link is displayed");
		} catch (Exception e) {
			Log.error("Directions Link is not displayed");
			throw (e);
			}		
		return element;		
	}
	public static WebElement pickup_Message() throws Exception {
		try{
			Log.info("Locating pickup Free message");
			element=Driver.findElement(By.xpath("//p[contains(.,'Free pickup available at below stores.')]"));
			//element=Driver.findElement(By.xpath("//p[contains(.,'The selected product size is not available at your entered location')]"));
			Utils.highLight(element);
			Log.info("pickup Free message is displayed");
		} catch (Exception e) {
			Log.error("pickup Free message is not displayed");
			throw (e);
		}		
		return element;		
	}
	
	
	public static WebElement pincodePlaceholder() throws Exception {
		try{
			Log.info("Locating pincodePlaceholder");
			element=Driver.findElement(By.xpath("//input[@placeholder='Enter Pincode']"));
			Utils.highLight(element);
			Log.info("pincodePlaceholder is displayed");
		} catch (Exception e) {
			Log.error("pincodePlaceholder is not displayed");
			throw (e);
		}		
		return element;		
	}
		
	
	public static WebElement ExpressStorePickup_DefaultMessage() throws Exception {
		try{
			Log.info("Locating Express StorePickup DefaultMessage");
			element=Driver.findElement(By.xpath("//div[@class='pickup-msg-chk']"));
			Utils.highLight(element);
			Log.info("Express StorePickup DefaultMessage is found on PDP page");
		} catch (Exception e) {
			Log.error("Exception in Class ProductDetails_Page | Method ExpressStorePickup_DefaultMessage");
			Log.error("Express StorePickup DefaultMessage is not found on PDP page");
			throw (e);
		}		
		return element;		
	}
	public static WebElement show_StoreDetailsBtn() throws Exception{
		
		try {
			Log.info("Locating store details button");
			element = Driver.findElement(By.xpath("//a[contains(@class,'showDetails')]"));
			Utils.highLight(element);
			Log.info("show Store details button displayed");

		} catch (Exception e) {
			Log.error("Exception in Class ProductDetails_Page | Method show_StoreDetailsBtn");
			Log.error("show Store details not displayed");
			throw (e);
			}		
		return element;
		
	}
	
public static WebElement hide_StoreDetailsBtn() throws Exception{
		
		try {
			Log.info("Locating hide store details button");
			element = Driver.findElement(By.xpath("//a[contains(.,'Hide Details')]"));
			Utils.highLight(element);
			Log.info("hide Store details button displayed");
		} catch (Exception e) {
			Log.error("Exception in Class ProductDetails_Page | Method hide_StoreDetailsBtn");
			Log.error("hide Store details not displayed");

			throw (e);
		}			
		return element;
		
	}	
	
	
public static WebElement ExpressStorePickup_Label() throws Exception {
	try{
		Log.info("Locating Express StorePickup Label");
		element=Driver.findElement(By.xpath("//span[@class='pickup-title']"));
		Utils.highLight(element);
		Log.info("Express StorePickup Label is found on PDP page");
	} catch (Exception e) {		
		Log.error("Exception in Class ProductDetails_Page | Method ExpressStorePickup_Label");
		Log.error("Express StorePickup Label is not found on PDP page");
		throw (e);
	}
	
	return element;		
}	


public static WebElement Delivery_Tittle() throws Exception {
	try{
		Log.info("Locating Delivery_Tittle");
		element=Driver.findElement(By.xpath("//span[@class='delivery-title']"));
		Utils.highLight(element);
		Log.info("Delivery_Tittle is displayed");
	} catch (Exception e) {
		Log.error("Exception in Class ProductDetails_Page | Method Delivery_Tittle");
		Log.error("Delivery_Tittle is not displayed");
		throw (e);
	}		
	return element;		
}		

public static WebElement delivery_Section_BeforeEntering_Pincode() throws Exception {
	try{
		Log.info("Locating delivery_Section_BeforeEntering_Pincode");
		element=Driver.findElement(By.xpath("//div[@class='pincodemessages']"));
		Utils.highLight(element);
		Log.info("delivery_Section_BeforeEntering_Pincode is displayed");
	} catch (Exception e) {
		Log.error("Exception in Class ProductDetails_Page | Method Delivery_Tittle");
		Log.error("delivery_Section_BeforeEntering_Pincode is not displayed");
		throw (e);
		}		
	return element;		
}

public static WebElement standardDelivery_AfterEntering_Pincode() throws Exception {
	try{
		Log.info("Locating standardDelivery_AfterEntering_Pincode");
		element=Driver.findElement(By.xpath("//div/p[@class='updated-pincode success-del']"));
		Utils.highLight(element);
		Log.info("standardDelivery_AfterEntering_Pincode is displayed");
	} catch (Exception e) {
		Log.error("Exception in Class ProductDetails_Page | Method standardDelivery_AfterEntering_Pincode");
		Log.error("standardDelivery_AfterEntering_Pincode is not displayed");
		throw (e);
		}		
	return element;		
}	


public static WebElement codDelivery_AfterEntering_Pincode() throws Exception {
	try{
		Log.info("Locating codDelivery_AfterEntering_Pincode");
		element=Driver.findElement(By.xpath("//div/p[@class='updated-pincode success-cod']"));
		Utils.highLight(element);
		Log.info("codDelivery_AfterEntering_Pincode is displayed");
	} catch (Exception e) {
		Log.error("Exception in Class ProductDetails_Page | Method codDelivery_AfterEntering_Pincode");
		Log.error("codDelivery_AfterEntering_Pincode is not displayed");
		throw (e);
		}		
	return element;		
}	

public static WebElement store_Info_Container() throws Exception {
	try{
		Log.info("Locating store_Info_Container");
		element=Driver.findElement(By.xpath(("//div[@class='store-infobox-container']")));
		Utils.highLight(element);
		Log.info("store_Info_Container is displayed");
	} catch (Exception e) {
		Log.error("Exception in Class ProductDetails_Page | Method store_Info_Container");
		Log.error("store_Info_Container is not displayed");
		throw (e);
		}		
	return element;		
}	

public static WebElement viewMore_Link() {
	try{
		Log.info("Locating viewMore Link");
		element=Driver.findElement(By.xpath("//a[@class='viewmore']"));
		Utils.highLight(element);
		Log.info("viewMore link is displayed");
	} catch (Exception e) {			
		System.out.println(e.getMessage());
	
		}		
	return element;		
}	

public static WebElement stores_Popup() throws Exception {
	try{
		Log.info("Locating stores Popup ");
		element=Driver.findElement(By.xpath("//h4[contains(.,'Available at below stores')]"));
		Utils.highLight(element);
		Log.info("Stores Popup is displayed");
	} catch (Exception e) {
		Log.error("Stores Popup is not displayed");
		throw (e);			
		}		
	return element;		
}

public static WebElement closeStores_Popup() throws Exception {
	try{
		Log.info("Locating close button in stores Popup ");
		element=Driver.findElement(By.xpath("//div[@class='popup-close-viewmorestores']"));
		Utils.highLight(element);
		Log.info("close button is displayed in popup opened");
	} catch (Exception e) {
		Log.error("close button is not displayed in popup opened");
		throw (e);
		}		
	return element;		
}

public static WebElement store_Details() throws Exception {
	try{
		Log.info("Locating store_Details link");
		element=Driver.findElement(By.xpath("//div[@class='storedetails']"));
		Utils.highLight(element);
		Log.info(" store_Details link is displayed");
	} catch (Exception e) {
		Log.error("Exception in Class ProductDetails_Page | Method store_Details");
		Log.error("store_Details link is not displayed");
		throw (e);
		}		
	return element;		
}


public static WebElement shopSimilar() throws Exception {
	try{
		
		Log.info("Locating shopSimilar details");
		element=Driver.findElement(By.xpath("//b[contains(.,'Recommended For you')]"));
		Utils.highLight(element);
		Log.info(" shopSimilar  is displayed");
	} catch (Exception e) {
		Log.error("Exception in Class ProductDetails_Page | Method shopSimilar");
		Log.error("shopSimilar is not displayed");
		throw (e);
		}		
	return element;		
}

public static WebElement recentlyViewed() throws Exception {
	try{
		Log.info("Locating recentlyViewed details");
		element=Driver.findElement(By.xpath("//h2[contains(.,'Recently Viewed')]"));
		Utils.highLight(element);
		Log.info(" recentlyViewed  is displayed");
	} catch (Exception e) {
		Log.error("Exception in Class ProductDetails_Page | Method recentlyViewed");
		Log.error("recentlyViewed is not displayed");
		throw (e);
		}		
	return element;		
}

public static List<WebElement> recentlyViewed_img() throws Exception {
	try{
		Log.info("Locating recentlyViewed image details");
		element2=Driver.findElements(By.xpath("//div[@class='product_silder mob_slider']//div[@class='pro-img']"));
		Utils.HighlightAllElementOneByOne(element2);
		Log.info(" recentlyViewed image is displayed");
	} catch (Exception e) {
		Log.error("Exception in Class ProductDetails_Page | Method recentlyViewed_img");
		Log.error("recentlyViewed image is not displayed");
		throw (e);
		}		
	return element2;		
}

public static List<WebElement> recentlyViewed_productName() throws Exception {
	try{
		Log.info("Locating recentlyViewed product name details");
		element2=Driver.findElements(By.xpath("//div[@class='product_silder mob_slider']//div[@class='pro-name']"));
		Utils.HighlightAllElementOneByOne(element2);
		Log.info(" recentlyViewed product name is displayed");
	} catch (Exception e) {
		Log.error("Exception in Class ProductDetails_Page | Method recentlyViewed_productName");
		Log.error("recentlyViewed product name is not displayed");
		throw (e);
		}		
	return element2;		
}

public static List<WebElement> recentlyViewed_brandName() throws Exception {
	try{
		Log.info("Locating recentlyViewed product Brandname details");
		element2=Driver.findElements(By.xpath("//div[@class='product_silder mob_slider']//div[@class='Brand-name']"));
		Utils.HighlightAllElementOneByOne(element2);
		Log.info(" recentlyViewed product Brandname is displayed");
	} catch (Exception e) {
		Log.error("Exception in Class ProductDetails_Page | Method recentlyViewed_brandName");
		Log.error("recentlyViewed product Brandname is not displayed");
		throw (e);
		}		
	return element2;		
}


public static List<WebElement> recentlyViewed_ProductPrice() throws Exception {
	try{
		Log.info("Locating recentlyViewed product price details");
		element2=Driver.findElements(By.xpath("//div[@class='product_silder mob_slider']//div[@class='Brand-name']"));
		Utils.HighlightAllElementOneByOne(element2);
		Log.info(" recentlyViewed product price is displayed");
	} catch (Exception e) {
		Log.error("Exception in Class ProductDetails_Page | Method recentlyViewed_ProductPrice");
		Log.error("recentlyViewed product price is not displayed");
		throw (e);
		}		
	return element2;		
}

public static WebElement vishWishlistButton() throws Exception
{
	try{
		Log.info("Locating recentlyViewed product price details");
		element=Driver.findElement(By.xpath("(//button[@id='addwishlistId'])[1]"));
		Utils.highLight(element);
		Log.info(" recentlyViewed product price is displayed");
	} catch (Exception e) {
		Log.error("Exception in Class ProductDetails_Page | Method recentlyViewed_ProductPrice");
		Log.error("recentlyViewed product price is not displayed");
		throw (e);
		}		
	return element;
}



public static WebElement firstCitizenOnPDP() {
	try {
		Log.info("Locating first citizen Link");
		element = Driver.findElement(By.xpath("//a[@title='First Citizens']"));
		Utils.highLight(element);
		Log.info("first citizen link is displayed");
	} catch (Exception e) {
		Log.error("unable to locate first citizen link");
		System.out.println(e.getMessage());

	}
	return element;
}


public static WebElement verifyFirstCitizenLink() {
	try {
		Log.info("Locating Become a Member Link");
		element = Driver.findElement(By.xpath("//a[text()='Become a Member']"));
		Utils.highLight(element);
		Log.info("first Become a Member is displayed");
	} catch (Exception e) {
		Log.error("unable to locate Become a Member link");
		System.out.println(e.getMessage());

	}
	return element;
}
public static WebElement FirstCitizenLink() {
	try {
		Log.info("Locating FirstCitizenLink ");
		element = Driver.findElement(By.xpath("//a[@href='https://www.shoppersstop.com/linkFccCard/newLinkFcc']"));
		Utils.highLight(element);
		Log.info("FirstCitizenLink is displayed");
	} catch (Exception e) {
		Log.error("unable to locate FirstCitizenLink link");
		System.out.println(e.getMessage());

	}
	return element;
}
public static WebElement sizeGuidepage() {
	try {
		Log.info("Locating sizeGuide page");
		element = Driver.findElement(By.xpath("//h2[@class='mob_hide' and text()='how to measure']"));
		Utils.highLight(element);
		Log.info("sizeGuide page is displayed");
	} catch (Exception e) {
		Log.error("unable to locate sizeGuide page");
		System.out.println(e.getMessage());

	}
	return element;
}
public static WebElement calculatesize() {
	try {
		Log.info("Locating sizeGuide link ");
		element = Driver.findElement(By.xpath("//span[text()='Calculate Your Size']"));
		Utils.highLight(element);
		Log.info("sizeGuide is displayed");
	} catch (Exception e) {
		Log.error("unable to locate sizeGuide link");
		System.out.println(e.getMessage());

	}
	return element;
}
public static WebElement closepopup() {
	try {
		Log.info("Locating closepopup link ");
		element = Driver.findElement(By.xpath("//div[@class='popup-close-box']"));
		Utils.highLight(element);
		Log.info("closepopup is displayed");
	} catch (Exception e) {
		Log.error("unable to locate closepopup link");
		System.out.println(e.getMessage());

	}
	return element;
}

public static WebElement sizeGuide() {
	try {
		Log.info("Locating sizeGuide link ");
		element = Driver.findElement(By.xpath("//span/a[text()='Size Guide']"));
		Utils.highLight(element);
		Log.info("sizeGuide is displayed");
	} catch (Exception e) {
		Log.error("unable to locate sizeGuide link");
		System.out.println(e.getMessage());

	}
	return element;
}
public static WebElement calculateSizepage() {
	try {
		Log.info("Locating calculateSize page ");
		element = Driver.findElement(By.xpath("//div[@id='snf5342-widget-wrap-2B']/descendant::h2"));
		Utils.highLight(element);
		Log.info("calculateSize page is displayed");
	} catch (Exception e) {
		Log.error("unable to locate calculateSize page ");
		System.out.println(e.getMessage());

	}
	return element;
}

public static WebElement brand_Info() throws Exception
{
	try{
		Log.info("Locating Brand Info Text");
		element=Driver.findElement(By.xpath("(//div[contains(.,'BRAND INFO')])[7]"));
		Utils.highLight(element);
		Log.info("Brand Info Text is displayed");
	} catch (Exception e) {
		Log.error("Exception in Class ProductDetails_Page | Method brand_Info");
		Log.error("Brand Info Text is not displayed");
		throw (e);
	}		
	return element;
}

public static WebElement brand_Info_Description() throws Exception
{
	try{
		Log.info("Locating Brand Info Description Text");
		element=Driver.findElement(By.xpath("//div[@id='brand-info']"));
		Utils.highLight(element);
		Log.info("Brand Info Description Text is displayed");
	} catch (Exception e) {
		Log.error("Exception in Class ProductDetails_Page | Method brand_Info_Description");
		Log.error("Brand Info Description Text is not displayed");
		throw (e);
	}		
	return element;
}

public static WebElement return_And_Exchange() throws Exception
{
	try{
		Log.info("Locating Return And Exchange Text");
		element=Driver.findElement(By.xpath("(//div[contains(.,'RETURN AND EXCHANGE')])[7]"));
		Utils.highLight(element);
		Log.info("Return And Exchange Text is displayed");
	} catch (Exception e) {
		Log.error("Exception in Class ProductDetails_Page | Method return_And_Exchange");
		Log.error("Return And Exchange Text is not displayed");
		throw (e);
	}		
	return element;
}

public static WebElement easy_Returns() throws Exception
{
	try{
		Log.info("Locating Easy Return Text");
		element=Driver.findElement(By.xpath("(//h3[contains(.,'Easy Returns')])"));
		Utils.highLight(element);
		Log.info("Easy Return Text is displayed");
	} catch (Exception e) {
		Log.error("Exception in Class ProductDetails_Page | Method easy_Returns");
		Log.error("Easy Return Text is not displayed");
		throw (e);
	}		
	return element;
}

public static WebElement easy_Exchange() throws Exception
{
	try{
		Log.info("Locating Easy Exchange Text");
		element=Driver.findElement(By.xpath("//h3[contains(.,'Easy Exchange ')]"));
		Utils.highLight(element);
		Log.info("Easy Exchange Text is displayed");
	} catch (Exception e) {
		Log.error("Exception in Class ProductDetails_Page | Method easy_Exchange");
		Log.error("Easy Exchange Text is not displayed");
		throw (e);
	}		
	return element;
}

public static WebElement delivery() throws Exception
{
	try{
		Log.info("Locating Delivery Text");
		element=Driver.findElement(By.xpath("//h3[contains(.,'Delivery')]"));
		Utils.highLight(element);
		Log.info("Delivery Text is displayed");
	} catch (Exception e) {
		Log.error("Exception in Class ProductDetails_Page | Method delivery");
		Log.error("Delivery Text is not displayed");
		throw (e);
	}		
	return element;
}

public static WebElement reviewsAndRatings() throws Exception
{
	try{
		Log.info("Locating Reviews And Ratings Text");
		element=Driver.findElement(By.xpath("//h3[contains(.,'REVIEWS & RATINGS')]"));
		Utils.highLight(element);
		Log.info("Reviews And Ratings Text is displayed");
	} catch (Exception e) {
		Log.error("Exception in Class ProductDetails_Page | Method reviewsAndRatings");
		Log.error("Reviews And Ratings Text is not displayed");
		throw (e);
	}		
	return element;
}

public static WebElement yes_Button() throws Exception
{
	try{
		Log.info("Locating Yes Button");
		element=Driver.findElement(By.xpath("//a[contains(.,'yes') and @class='yes']"));
		Utils.highLight(element);
		Log.info("Yes Button is displayed");
	} catch (Exception e) {
		Log.error("Exception in Class ProductDetails_Page | Method yes_Button");
		Log.error("Yes Button is not displayed");
		throw (e);
	}		
	return element;
}

public static WebElement no_Button() throws Exception
{
	try{
		Log.info("Locating No Button");
		element=Driver.findElement(By.xpath("//a[contains(.,'no') and @class='no']"));
		Utils.highLight(element);
		Log.info("No Button is displayed");
	} catch (Exception e) {
		Log.error("Exception in Class ProductDetails_Page | Method no_Button");
		Log.error("No Button is not displayed");
		throw (e);
	}		
	return element;
}

public static WebElement rate_This_Product_Button() throws Exception
{
	try{
		Log.info("Locating Rate This Product Button");
		element=Driver.findElement(By.xpath("//a[contains(.,'THIS PRODUCT')]"));
		Utils.highLight(element);
		Log.info("Rate This Product Button is displayed");
	} catch (Exception e) {
		Log.error("Exception in Class ProductDetails_Page | Method rate_This_Product_Button");
		Log.error("Rate This Product Button is not displayed");
		throw (e);
	}		
	return element;
}

public static WebElement write_A_Review() throws Exception
{
	try{
		Log.info("Locating Write A Review Text");
		element=Driver.findElement(By.xpath("//h2[contains(.,'Write a Review')]"));
		Utils.highLight(element);
		Log.info("Write A Review Text is displayed");
	} catch (Exception e) {
		Log.error("Exception in Class ProductDetails_Page | Method write_A_Review");
		Log.error("Write A Review Text is not displayed");
		throw (e);
	}		
	return element;
}

public static WebElement cancel_Button() throws Exception
{
	try{
		Log.info("Locating Cancel Button");
		element=Driver.findElement(By.xpath("//input[@id='reset']"));
		Utils.highLight(element);
		Log.info("Cancel Button is displayed");
	} catch (Exception e) {
		Log.error("Exception in Class ProductDetails_Page | Method cancel_Button");
		Log.error("Cancel Button is not displayed");
		throw (e);
	}		
	return element;
}

public static WebElement product_DetailsAndCare() throws Exception
{
	try{
		Log.info("Locating ProductDetailsAndCare Text");
		element=Driver.findElement(By.xpath("(//div[contains(.,'PRODUCT DETAILS & CARE')])[7]"));
		Utils.highLight(element);
		Log.info("ProductDetailsAndCare Text is displayed");
	} catch (Exception e) {
		Log.error("Exception in Class ProductDetails_Page | Method product_DetailsAndCare");
		Log.error("ProductDetailsAndCare Text is not displayed");
		throw (e);
	}		
	return element;
}

public static WebElement product_Code() throws Exception
{
	try{
		Log.info("Locating Product Code Text");
		element=Driver.findElement(By.xpath("//span[@id='selectedStyleCodeInPdp']"));
		Utils.highLight(element);
		Log.info("Product Code Text is displayed");
	} catch (Exception e) {
		Log.error("Exception in Class ProductDetails_Page | Method product_Code");
		Log.error("Product Code Text is not displayed");
		throw (e);
	}		
	return element;
}

public static WebElement style_Notes() throws Exception
{
	try{
		Log.info("Locating Style Notes Text");
		element=Driver.findElement(By.xpath("(//div[contains(.,'STYLE NOTES')])[7]"));
		Utils.highLight(element);
		Log.info("Style Notes Text is displayed");
	} catch (Exception e) {
		Log.error("Exception in Class ProductDetails_Page | Method style_Notes");
		Log.error("Style Notes Text is not displayed");
		throw (e);
	}		
	return element;
}

public static WebElement style_Notes_Description() throws Exception
{
	try{
		Log.info("Locating Style Notes Description Text");
		element=Driver.findElement(By.xpath("//div[@id='style-notes']"));
		Utils.highLight(element);
		Log.info("Style Notes Description Text is displayed");
	} catch (Exception e) {
		Log.error("Exception in Class ProductDetails_Page | Method style_Notes_Description");
		Log.error("Style Notes Description Text is not displayed");
		throw (e);
	}		
	return element;
}


}