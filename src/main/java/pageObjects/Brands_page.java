package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//import net.bytebuddy.jar.asm.commons.TryCatchBlockSorter;
import utility.Log;
import utility.Utils;

public class Brands_page extends BaseClass {
	public Brands_page(WebDriver Driver) {
		super(Driver);
		// TODO Auto-generated constructor stub
	}

	private static WebElement element = null;
	//public static WebElement Brands = Driver.findElement(By.xpath("//a[@title='BRANDS']"));
//	public static WebElement Brands = Driver.findElement(By.xpath("//a[@href='/brands']"));
	public static WebElement Brands=Driver.findElement(By.cssSelector("a[href*='/brands'][title='BRANDS']"));
	public static WebElement Brands_of_shopperstop = Driver.findElement(By.xpath("//a[contains(text(),'Brands of Shoppers Stop')]"));
	public static WebElement Luxury_Brands = Driver.findElement(By.xpath("//a[contains(text(),'Luxury Brands')]"));
	public static WebElement Trending_Brands = Driver.findElement(By.xpath("//a[contains(text(),'Trending Brands')]"));
	public static WebElement Featured_Brands = Driver.findElement(By.xpath("//a[contains(text(),'Featured Brands')]"));
	public static WebElement Celeb_Brands = Driver.findElement(By.xpath("//a[contains(text(),'Celeb Brands')]"));
	public static WebElement Just_Launched_Brands = Driver
			.findElement(By.xpath("//a[contains(text(),'Just Launched Brands')]"));
	public static WebElement All_Brands = Driver
			.findElement(By.xpath("//a[text()='BRANDS']/following-sibling::div/descendant::ul[1]/li[6]"));

	public static void verifyAllBrands() throws Throwable {
		List<WebElement> brandList = new ArrayList<WebElement>();
		brandList.add(Brands_of_shopperstop);
		brandList.add(Luxury_Brands);
		brandList.add(Trending_Brands);
		brandList.add(Featured_Brands);
		brandList.add(Celeb_Brands);
		brandList.add(Just_Launched_Brands);
		brandList.add(All_Brands);
//		Utils.mouseHover(Brands);
		for (WebElement e : brandList) {
			Utils.mouseHoverAction(Brands, e);
			if (e.getTagName().equals("a"))
				System.out.println(e.getText() + " >> is verified");

		}

	}

	public static void verifyBrandsOfStopperStop() throws Throwable {
		Utils.waitForElementPresence2(Brands);
		Utils.mouseHoverAction(BrandL1(), Brands_of_shopperstop);
		String brandElement = Brands_of_shopperstop.getAttribute("innerHTML");

		System.out.println(brandElement + " >>Brands module has been selected");

		try {
			List<WebElement> brandselem = Driver.findElements(
					By.xpath("//a[text()='Brands of Shoppers Stop']/following-sibling::div/descendant::a"));
			System.out.println(brandselem.size() + "   >> brands are available");
			for (WebElement subelement : brandselem) {
				if (subelement.getTagName().equals("a")) {
					System.out.println(subelement.getAttribute("innerHTML") + "  >> brand  is verified");
				} else if (subelement.getTagName().equals("img")) {
					System.out.println(subelement.getAttribute("innerHTML") + "   >> brand is verified");
				}

			}
			System.out.println("<<<<<<<" + brandElement + " Ended >>>>>>>>>>>>>>>>");
		} catch (Exception e) {
			Log.error(e.getMessage());
		}

	}

	public static void verifyBrandsOfLuxury_Brands() throws Throwable {
		Utils.waitForElementPresence2(Brands);
		Utils.mouseHoverAction(BrandL1(), Luxury_Brands);
		String brandElement = Luxury_Brands.getAttribute("innerHTML");

		System.out.println(brandElement + " >>Brands module has been selected");

		try {
			List<WebElement> brandselem = Driver
					.findElements(By.xpath("//a[text()='Luxury Brands']/following-sibling::div/descendant::a"));
			System.out.println(brandselem.size() + "  >> brands are available");
			for (WebElement subelement : brandselem) {
				if (subelement.getTagName().equals("a")) {
					System.out.println(subelement.getAttribute("innerHTML") + "  >> brand  is verified");
				} else if (subelement.getTagName().equals("img")) {
					System.out.println(subelement.getAttribute("innerHTML") + " >> brand is verified");
				}

			}
			System.out.println("<<<<<<<" + brandElement + " Ended  >>>>>>>>>>>>>>>>");
		} catch (Exception e) {
			Log.error(e.getMessage());
		}

	}

	public static void verifyBrandsOfTrending_Brands() throws Throwable {
		Utils.waitForElementPresence2(Brands);
		Utils.mouseHoverAction(BrandL1(), Trending_Brands);
		String brandElement = Trending_Brands.getAttribute("innerHTML");

		System.out.println(brandElement + " >>Brands module has been selected");

		try {
			List<WebElement> brandselem = Driver
					.findElements(By.xpath("//a[text()='Trending Brands']/following-sibling::div/descendant::a"));
			System.out.println(brandselem.size() + "  >> brands are available");
			for (WebElement subelement : brandselem) {
				if (subelement.getTagName().equals("a")) {
					System.out.println(subelement.getAttribute("innerHTML") + "  >> brand  is verified");
				} else if (subelement.getTagName().equals("img")) {
					System.out.println(subelement.getAttribute("innerHTML") + " >> brand is verified");
				}

			}
			System.out.println("<<<<<<<" + brandElement + "Ended >>>>>>>>>>>>>>>>");
		} catch (Exception e) {
			Log.error(e.getMessage());
		}

	}

	public static void verifyBrandsOfFeatured_Brands() throws Throwable {
		Utils.waitForElementPresence2(Brands);
		Utils.mouseHoverAction(BrandL1(), Featured_Brands);
		String brandElement = Featured_Brands.getAttribute("innerHTML");

		System.out.println(brandElement + " >>Brands module has been selected");

		try {
			List<WebElement> brandselem = Driver
					.findElements(By.xpath("//a[text()='Featured Brands']/following-sibling::div/descendant::a"));
			System.out.println(brandselem.size() + "  >> brands are available");
			for (WebElement subelement : brandselem) {
				if (subelement.getTagName().equals("a")) {
					System.out.println(subelement.getAttribute("innerHTML") + "  >> brand  is verified");
				} else if (subelement.getTagName().equals("img")) {
					System.out.println(subelement.getAttribute("innerHTML") + " >> brand is verified");
				}

			}
			System.out.println("<<<<<<<" + brandElement + " Ended >>>>>>>>>>>>>>>>");
		} catch (Exception e) {
			Log.error(e.getMessage());
		}

	}

	public static void verifyBrandsOfCeleb_Brands() throws Throwable {
		Utils.waitForElementPresence2(Brands);
		Utils.mouseHoverAction(BrandL1(), Celeb_Brands);
		String brandElement = Celeb_Brands.getAttribute("innerHTML");

		System.out.println(brandElement + " >>Brands module has been selected");

		try {
			List<WebElement> brandselem = Driver
					.findElements(By.xpath("//a[text()='Celeb Brands']/following-sibling::div/descendant::a"));
			System.out.println(brandselem.size() + "  >> brands are available");
			for (WebElement subelement : brandselem) {
				if (subelement.getTagName().equals("a")) {
					System.out.println(subelement.getAttribute("innerHTML") + "  >> brand  is verified");
				} else if (subelement.getTagName().equals("img")) {
					System.out.println(subelement.getAttribute("innerHTML") + " >> brand is verified");
				}

			}
			System.out.println("<<<<<<<" + brandElement + " Ended >>>>>>>>>>>>>>>>");
		} catch (Exception e) {
			Log.error(e.getMessage());
		}

	}

	public static void verifyBrandsOfJust_Launched_Brands() throws Throwable {
		Utils.waitForElementPresence2(Brands);
		Utils.mouseHoverAction(BrandL1(), Just_Launched_Brands);
		String brandElement = Just_Launched_Brands.getAttribute("innerHTML");

		System.out.println(brandElement + " >>Brands module has been selected");

		try {
			List<WebElement> brandselem = Driver
					.findElements(By.xpath("//a[text()='Just Launched Brands']/following-sibling::div/descendant::a"));
			System.out.println(brandselem.size() + "  >> brands are available");
			for (WebElement subelement : brandselem) {
				if (subelement.getTagName().equals("a")) {
					System.out.println(subelement.getAttribute("innerHTML") + "  >> brand  is verified");
				} else if (subelement.getTagName().equals("img")) {
					System.out.println(subelement.getAttribute("innerHTML") + " >> brand is verified");
				}

			}
			System.out.println("<<<<<<<" + brandElement + " Ended >>>>>>>>>>>>>>>>");
		} catch (Exception e) {
			Log.error(e.getMessage());
		}

	}

	public static void verifyBrandsOfAll_Brands() throws Throwable {
		Utils.waitForElementPresence2(Brands);
		Utils.mouseHoverAction(BrandL1(), All_Brands);
		String brandElement = All_Brands.getAttribute("innerHTML");

		System.out.println(brandElement + " >>Brands module has been selected");

		try {
			List<WebElement> brandselem = Driver
					.findElements(By.xpath("//a[text()='All Brands']/following-sibling::div/descendant::a"));
			System.out.println(brandselem.size() + "  >> brands are available");
			for (WebElement subelement : brandselem) {
				if (subelement.getTagName().equals("a")) {
					System.out.println(subelement.getAttribute("innerHTML") + " >> brand  is verified");
				} else if (subelement.getTagName().equals("img")) {
					System.out.println(subelement.getAttribute("innerHTML") + " >> brand is verified");
				}

			}
			System.out.println("<<<<<<<" + brandElement + " Ended >>>>>>>>>>>>>>>>");
		} catch (Exception e) {
			Log.error(e.getMessage());
		}

	}

	// Brand element l1 on home page
	public static WebElement BrandL1() throws Exception {

		try {
			Log.info("Locating LoginRegister element");
			element = Driver.findElement(By.xpath("//*[@href='/brands']"));
			Utils.highLight(element);
			Log.info("Log IN element is found on the Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method LoginRegister");
			Log.error("Log IN element is not found on the Home Page");
			throw e;
		}

		return element;

	}

	// Brand element l2 on home page
	public static WebElement BrandsofShoppersStopL2() throws Exception {

		try {
			Log.info("Locating LoginRegister element");
			element = Driver.findElement(By.xpath("//a[text()='Brands of Shoppers Stop']"));
			Utils.highLight(element);
			Log.info("Log IN element is found on the Home Page");

		} catch (Exception e) {
			Log.error("Exception in Class Home_Page | Method LoginRegister");
			Log.error("Log IN element is not found on the Home Page");
			throw e;
		}

		return element;

	}

}
