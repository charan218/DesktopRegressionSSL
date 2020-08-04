package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utility.Log;
import utility.Utils;

public class ProductListing_Page extends BaseClass {
	private static WebElement element;
	private static List<WebElement> webElements;
	private static List<WebElement> elements;
	private static Select selectElement;

	public ProductListing_Page(WebDriver Driver) {
		super(Driver);

	}

	public static WebElement product() throws Exception {

		try {
			Log.info("Locating Product link on PLP");
			// element = Driver.findElement(By.xpath("(.//*[@id='primaryImage'])[1]"));
			//element = Driver.findElement(By.xpath("//*[@id='primaryImage']"));
			//element = Driver.findElement(By.xpath("//img[@class=' lazyloaded']"));
			element = Driver.findElement(By.xpath("(//*[@class='price_div'])[1]"));
			Utils.highLight(element);
			Log.info("Product link found on PLP");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method product");
			Log.error("Product link not found on PLP");
			throw (e);
		}

		return element;

	}

	public static WebElement product101() throws Exception {

		try {
			Log.info("Locating Product link on PLP");
			element = Driver.findElement(By.xpath("(.//*[@id='primaryImage'])[101]"));
			Utils.highLight(element);
			Log.info("Product link found on PLP");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method product101");
			Log.error("product101 link not found on PLP");
			throw (e);
		}

		return element;

	}

	public static WebElement secondproduct() throws Exception {

		try {
			Log.info("Locating Product link on PLP");
//			element = Driver.findElement(By.xpath("(.//*[@id='primaryImage'])[2]"));
			//element = Driver.findElement(By.xpath("(.//*[@id='primaryImage'])[2]/following::div"));
			//element = Driver.findElement(By.xpath("(//*[@class='pro-info'])[1]"));
			element = Driver.findElement(By.xpath("(//*[@class='price_div'])[1]"));
			Utils.waitForElementLongJenkinsIssue(element);
			Utils.highLight(element);
			Log.info("Product link found on PLP");
			System.out.println("Product link found on PLP");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method product");
			Log.error("Product link not found on PLP");
			throw (e);
		}

		return element;

	}
	
	public static WebElement productNew() throws Exception {

		try {
			Log.info("Locating Product link on PLP");
			//element = Driver.findElement(By.xpath("(//*[@class='pro-info'])[1]"));
			//element = Driver.findElement(By.xpath("(//*[@class='x'])[3]"));
			//element = Driver.findElement(By.xpath("(//*[@class='pro-box  newli'])[1]"));
			element = Driver.findElement(By.xpath("(//*[@class='price_div'])[1]"));
			Utils.waitForElementLongJenkinsIssue(element);
			Utils.highLight(element);
			Log.info("Product link found on PLP");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method product");
			Log.error("Product link not found on PLP");
			throw (e);
		}

		return element;

	}
	public static List<WebElement> FirstRowImagesPLP() throws Exception {
		elements = Driver.findElements(By.xpath("(//ul[@class='imageChangeForStyleVarient'])[1]/li/a"));
		return elements;
	}

	public static WebElement checkout_product() throws Exception {

		try {
			Log.info("Locating Product link on PLP");
			element = Driver.findElement(By.xpath(".//*[@id='1HashPosition']/a/picture/div/div/div/ul/li/a/img"));
			Log.info("Product link found on PLP");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method product");
			Log.error("Product link not found on PLP");
			throw (e);
		}

		return element;

	}

	public static WebElement FCC_checkout_product() throws Exception {

		try {
			Log.info("Locating Product link on PLP");
			element = Driver.findElement(By.xpath(".//*[@id='2HashPosition']/a/picture/div/div/div/ul/li[1]/a/img"));
			Log.info("Product link found on PLP");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method product");
			Log.error("Product link not found on PLP");
			throw (e);
		}

		return element;

	}

	public static WebElement sizeofproduct() throws Exception {

		try {
			Log.info("Locating Product link on PLP");
			element = Driver.findElement(By.xpath(
					"html/body/main/div[11]/section[2]/div/div/div/div[2]/div[3]/div[1]/div[4]/div[3]/ul/li[2]"));
			Log.info("Size of Product link found on PLP");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Size of product");
			Log.error("Product link not found on PLP");
			throw (e);
		}

		return element;

	}

	public static WebElement ProductCount() throws Exception {

		try {
			Log.info("Locating Product Item Count on PLP");
			// element = Driver.findElement(By.xpath(
			// "//div[@class='heading-filter-sec']/descendant::div[@class='pro-list-heading
			// margB20 col-md-12 text-center']/h4/span"));
			element = Driver.findElement(
					By.xpath("//div[@class='container']//*[@class='plpHeader hidden-sm hidden-xs']/div/span"));
			Utils.highLight(element);
			Log.info("Product Item Count found on PLP");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method ProductCount");
			Log.error("Product Item Count not found on PLP");
			throw (e);
		}

		return element;

	}

	public static WebElement clearFilter() throws Exception {
		try {
			element = Driver.findElement(By.xpath("(//div[@class='clear-filter']/a)[1]"));
			Utils.highLight(element);
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}

	public static WebElement HeadingProductCount() throws Exception {

		try {
			Log.info("Locating Product Item Count with Product heading PLP");
			// element = Driver.findElement(By.xpath(
			// "//div[@class='heading-filter-sec']/descendant::div[@class='pro-list-heading
			// margB20 col-md-12 text-center']/h4/span"));
			element = Driver.findElement(
					By.xpath("//div[@class='container']//*[@class='plpHeader hidden-sm hidden-xs']/div/span"));
			Log.info("Product Item Count with Product heading found on PLP");
			Utils.highLight(element);

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method HeadingProductCount");
			Log.error("Product Item Count with Product heading not found on PLP");
			throw (e);
		}

		return element;

	}

	public static Select SortOptions() throws Exception {

		try {
			Log.info("Locating Sort Option Drop Down found on PLP");
			selectElement = new Select(
					Driver.findElement(By.xpath("//form[@id='sortForm1']/descendant::select[@id='sortOptions1']")));

			Log.info("Sort Option Drop Down found on PLP");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method SortOptions");
			Log.error("Sort Option Drop Down not found on PLP");
			throw (e);
		}

		return selectElement;

	}

	public static WebElement GridViewIcon() throws Exception {

		try {
			Log.info("Locating Grid View Icon on PLP ");
			element = Driver.findElement(By.xpath("//li[@class='grid-view active']"));
			Utils.highLight(element);
			Log.info("Grid View Icon found on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method GridViewIcon");
			Log.error("Grid View Icon not found on PLP");
			throw (e);
		}

		return element;

	}

	public static WebElement FilterOnOff() throws Exception {

		try {
			Log.info("Locating Filter On Off Icon on PLP ");
			element = Driver.findElement(By.xpath("//span[@class='filters-txt']/span[@class='triangle-bottomright']"));
			Utils.highLight(element);
			Log.info("Filter On Off Icon found on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method FilterOnOff");
			Log.error("Filter On Off Icon not found on PLP");
			throw (e);
		}

		return element;

	}

	public static WebElement DefaultFilterContainer() throws Exception {

		try {
			Log.info("Locating Default Filter Container on PLP ");
			element = Driver.findElement(By.xpath(
					"//section[@class='product-listing-wrapper']/descendant::div[@class='yCmsComponent filter-inner']"));
			Utils.highLight(element);
			Log.info("Default Filter Container found on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method DefaultFilterContainer");
			Log.error("Default Filter Container not found on PLP");
			throw (e);
		}

		return element;

	}

	public static WebElement ShowMoreLink() throws Exception {

		try {
			Log.info("Locating Show More Link on PLP ");
			element = Driver
					.findElement(By.xpath("//*[@class='tab_content tabs_item-showing']/div[1]//*[@class='showMore']"));
			Utils.highLight(element);
			Log.info("Show More Link found on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method ShowMoreLink");
			Log.error("Show More Link not found on PLP");
			throw (e);
		}

		return element;

	}

	public static WebElement ShowMoreLinkContent() throws Exception {

		try {
			Log.info("Locating Show More Link on PLP ");
			element = Driver.findElement(By.xpath("//*[@class='tab_content tabs_item-showing']/div[1]"));
			Utils.highLight(element);
			Log.info("Show More Link found on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method ShowMoreLink");
			Log.error("Show More Link not found on PLP");
			throw (e);
		}

		return element;

	}

	public static WebElement ShowLessLink() throws Exception {

		try {
			Log.info("Locating Show Less Link on PLP ");
			element = Driver.findElement(By.xpath("//*[@class='tab_content']/div[1]//*[@class='showLess']"));
			Utils.highLight(element);
			Log.info("Show Less Link found on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method ShowMoreLink");
			Log.error("Show Less Link not found on PLP");
			throw (e);
		}

		return element;

	}

	public static List<WebElement> DefaultAttributeFilterCategoryContainer() throws Exception {

		try {
			Log.info("Locating Default Attribute Filter Container elements on PLP ");
			webElements = Driver.findElements(
					By.xpath("//div[@id='product-facet']/descendant::div[contains(@class,'filter-category-heading')]"));
			Log.info("Default Attribute Filter Container elements found on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method DefaultAttributeFilterCategoryContainer");
			Log.error("Default Attribute Filter Container not found on PLP");
			throw (e);
		}

		return webElements;

	}

	public static WebElement DefaultAttributeFilterCategory(String filterCategary) throws Exception {

		try {
			Log.info("Locating Default Attribute Filter Category - " + filterCategary + " on PLP ");
			element = Driver.findElement(By.xpath(
					"//div[@id='product-facet']/descendant::div[contains(@class,'filter-category-heading')]/span[contains(text(),'"
							+ filterCategary + "')]"));
			Log.info("Default Attribute Filter Category - " + filterCategary + " found on PLP ");
			Utils.highLight(element);

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method DefaultAttributeFilterCategory");
			Log.error("Default Attribute Filter Category- " + filterCategary + " not found on PLP");
			throw (e);
		}

		return element;

	}

	public static WebElement DefaultAttributeFilter(String filterValue) throws Exception {

		try {
			Log.info("Locating Default Attribute Filter Value - " + filterValue + "  on PLP ");
			element = Driver.findElement(By.xpath("//div[@class='ex-checkbox']//label[contains(text(),'" + filterValue
					+ "')]//preceding-sibling::input"));
			Log.info("Default Attribute Filter Value - " + filterValue + " found on PLP ");
			Utils.highLight(element);

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method DefaultAttributeFilter");
			Log.error("Default Attribute Filter Value - " + filterValue + " not found on PLP");
			throw (e);
		}

		return element;

	}

	public static WebElement DefaultAttributeFilterPageLoad(String filterValue) throws Exception {

		try {
			Log.info("Locating Default Attribute Filter Value - " + filterValue + " on PLP ");
			element = Driver.findElement(By.xpath(
					"//div[@id='product-facet']/descendant::div[@class='tabs_item']/ul/li/descendant::label[contains(text(),'"
							+ filterValue + "')]/preceding-sibling::input[@class='checkbox-sel']"));
			Log.info("Default Attribute Filter Value - " + filterValue + " found on PLP ");
			Utils.highLight(element);

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method DefaultAttributeFilterPageLoad");
			Log.error("Default Attribute Filter Value - " + filterValue + " not found on PLP");
			throw (e);
		}
		return element;

	}

	public static List<WebElement> DefaultAttributeFilterAppliedList() throws Exception {

		try {
			Log.info("Locating Default Attribute Filter Applied List on PLP ");
			webElements = Driver.findElements(
					By.xpath("//div[@class='refine-pins']//span[@class='refine-txt']/following-sibling::ul/li"));
			Log.info("Default Attribute Filter Applied List is present on PLP ");
			// Utils.highLight(element);
			Utils.HighlightAllElementOneByOne(webElements);

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method DefaultAttributeFilterAppliedList");
			Log.error("Default Attribute Filter Applied List is not found on PLP");
			throw (e);
		}

		return webElements;

	}

	public static WebElement DefaultAttributeFilterClose(int i) throws Exception {

		try {
			Log.info("Locating Default Attribute Filter Applied List close icons on PLP ");
			element = Driver.findElement(
					By.xpath("//div[@class='refine-pins']//span[@class='refine-txt']/following-sibling::ul/li[" + i
							+ "]//a/span[@class='glyphicon-glyphicon-remove']"));
			Log.info("Default Attribute Filter Applied List has close icons present on PLP ");
			Utils.highLight(element);

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method DefaultAttributeFilterClose");
			Log.error("Default Attribute Filter Applied List close icons not found on PLP");
			throw (e);
		}

		return element;

	}

	public static WebElement PrimaryFilterProductType() throws Exception {
//		element = Driver.findElement(
//				By.xpath("(//div[contains(@class,'filter-category-heading') and contains(text(),'Product Type')])[2]"));
		Thread.sleep(2000);
		element = Driver.findElement(By.xpath("//div[@class='filter-category-heading '][contains(.,'Offers')]"));
		Utils.highLight(element);
		return element;
	}

	public static WebElement DefaultAttributeFilterCloseAll() throws Exception {

		try {
			Log.info("Locating Default Attribute Filter Applied List close all icon on PLP ");
			element = Driver.findElement(By.xpath(
					"//div[@class='refine-pins']//label[contains(text(),'Clear')]/following-sibling::a/span[@class='glyphicon-glyphicon-remove']"));
			Log.info("Default Attribute Filter Applied List close all icon is present on PLP ");
			Utils.highLight(element);

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method DefaultAttributeFilterCloseAll");
			Log.error("Default Attribute Filter Applied List close all icon is not found on PLP");
			throw (e);
		}

		return element;

	}

	public static WebElement PrimaryFilterBrandDropDown() throws Exception {

		try {
			Log.info("Locating Brand related Primary Filter on PLP ");
			// element = Driver.findElement(By
			// .xpath("//div[@class='brands-list
			// js-facet-form']/preceding-sibling::div[contains(@class,'filter-category-heading')]"));
			element = Driver.findElement(
					By.xpath("(//div[contains(@class,'filter-category-heading') and contains(text(),'brands')])[2]"));
			Log.info("Brand related Primary Filter is present on PLP ");
			Utils.highLight(element);

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method PrimaryFilterBrandDropDown");
			Log.error("Brand related Primary Filter is not found on PLP");
			throw (e);
		}

		return element;

	}

	public static WebElement PrimaryFilterBrandDropDownContainer() throws Exception {

		try {
			Log.info("Locating Brand related Primary Filter Container on PLP ");
			element = Driver.findElement(
					By.xpath("(//div[contains(@class,'filter-category-heading') and contains(text(),'brands')])[2]"));
			Log.info("Brand related Primary Filter Container is present on PLP ");
			Utils.highLight(element);

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method PrimaryFilterBrandDropDownContainer");
			Log.error("Brand related Primary Filter Container is not found on PLP");
			throw (e);
		}

		return element;

	}

	public static WebElement PrimaryFilterProductTypeDropDownContainer() throws Exception {

		try {
			Log.info("Locating PrimaryFilterProductTypeDropDownContainer related Primary Filter Container on PLP ");
			element = Driver.findElement(By.xpath("(//div[@class='overview'])[2]"));
			Utils.highLight(element);
			Log.info("Product Type related Primary Filter Container is present on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method PrimaryFilterProductTypeDropDownContainer");
			Log.error("Product Type related Primary Filter Container is not found on PLP");
			throw (e);
		}

		return element;

	}

	public static WebElement cliniqueproduct() throws Exception {

		try {
			Log.info("Locating Product link on PLP");
			element = Driver.findElement(By.xpath(".//*[@id='1HashPosition']"));
			Log.info("Product link found on PLP");
			Utils.highLight(element);

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method product");
			Log.error("Product link not found on PLP");
			throw (e);
		}

		return element;

	}

	public static WebElement PrimaryFilterPriceDropDown() throws Exception {

		try {
			Log.info("Locating Price related Primary Filter on PLP ");
			element = Driver.findElement(
					By.xpath("(//div[contains(@class,'filter-category-heading') and contains(text(),'Price')])[2]"));
			// element = Driver.findElement(By
			// .xpath("//*[@id='tab13']/div[1]"));
			Utils.highLight(element);
			Log.info("Price related Primary Filter is present on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method PrimaryFilterPriceDropDown");
			Log.error("Price related Primary Filter is not found on PLP");
			throw (e);
		}

		return element;

	}

	public static WebElement DepartmentFilterContainer() throws Exception {

		try {
			Log.info("Locating Price related DepartmentFilter Container on PLP ");
			element = Driver.findElement(By.xpath(".//*[@id='tab1']"));
			Utils.highLight(element);
			Log.info("Price related DepartmentFilterContainer Container is present on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method DepartmentFilterContainer");
			Log.error("DepartmentFilterContainer is not found on PLP");
			throw (e);
		}

		return element;

	}

	public static WebElement DepartmentSecondFilter() throws Exception {

		try {
			Log.info("Locating Price related DepartmentSecondFilter on PLP ");
			element = Driver.findElement(By.xpath("(.//*[@id='tab1']//input[@type='checkbox'])[2]"));
			Utils.highLight(element);
			Log.info("Price related DepartmentSecondFilter is present on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method DepartmentSecondFilter");
			Log.error("DepartmentSecondFilter is not found on PLP");
			throw (e);
		}

		return element;

	}

	public static WebElement DepartmentThirdFilter() throws Exception {

		try {
			Log.info("Locating Price related DepartmentThirdFilter on PLP ");
			element = Driver.findElement(By.xpath("(.//*[@id='tab1']//input[@type='checkbox'])[3]"));
			Utils.highLight(element);
			Log.info("Price related DepartmentThirdFilter is present on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method DepartmentThirdFilter");
			Log.error("DepartmentThirdFilter is not found on PLP");
			throw (e);
		}

		return element;

	}

	public static WebElement PrimaryFilterPriceDropDownContainer() throws Exception {

		try {
			Log.info("Locating Price related Primary Filter Container on PLP ");
			element = Driver.findElement(
					By.xpath("(//div[contains(@class,'filter-category-heading') and contains(text(),'Price')])[2]"));
			Utils.highLight(element);
			Log.info("Price related Primary Filter Container is present on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method PrimaryFilterPriceDropDownContainer");
			Log.error("Price related Primary Filter Container is not found on PLP");
			throw (e);
		}

		return element;

	}

	public static WebElement PrimaryFilterSizeDropDown() throws Exception {

		try {
			Log.info("Locating Size related Primary Filter on PLP ");

			element = Driver.findElement(
					By.xpath("(//div[contains(@class,'filter-category-heading') and contains(text(),'Size')])[2]"));
			Utils.highLight(element);
			Log.info("Size related Primary Filter is present on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method PrimaryFilterSizeDropDown");
			Log.error("Size related Primary Filter is not found on PLP");
			throw (e);
		}

		return element;

	}

	public static WebElement PrimaryFilterSizeDropDownContainer() throws Exception {

		try {
			Log.info("Locating Size related Primary Filter Container on PLP ");
			element = Driver.findElement(
					By.xpath("(//div[contains(@class,'filter-category-heading') and contains(text(),'Size')])[2]"));
			Utils.highLight(element);
			Log.info("Size related Primary Filter Container is present on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method PrimaryFilterSizeDropDownContainer");
			Log.error("Size related Primary Filter Container is not found on PLP");
			throw (e);
		}

		return element;

	}

	public static WebElement PrimaryFilterColorDropDown() throws Exception {

		try {
			Log.info("Locating Color related Primary Filter on PLP ");
			element = Driver.findElement(
					By.xpath("(//div[contains(@class,'filter-category-heading') and contains(text(),'Colors')])[2]"));
			Utils.highLight(element);
			Log.info("Color related Primary Filter is present on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method PrimaryFilterColorDropDown");
			Log.error("Color related Primary Filter is not found on PLP");
			throw (e);
		}

		return element;

	}

	public static WebElement PrimaryFilterColorDropDownContainer() throws Exception {

		try {
			Log.info("Locating Color related Primary Filter Container on PLP ");
			element = Driver.findElement(
					By.xpath("(//div[contains(@class,'filter-category-heading') and contains(text(),'Colors')])[2]"));
			Utils.highLight(element);
			Log.info("Color related Primary Filter Container is present on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method PrimaryFilterColorDropDownContainer");
			Log.error("Color related Primary Filter Container is not found on PLP");
			throw (e);
		}

		return element;

	}

	public static WebElement PrimaryFilterOnSaleDropDown() throws Exception {

		try {
			Log.info("Locating On Sale related Primary Filter on PLP ");
			element = Driver.findElement(By.xpath(
					"//div[@class='filter-scroll promo-list js-facet-form']/preceding-sibling::div[contains(@class,'filter-category-heading')]"));
			Utils.highLight(element);
			Log.info("On Sale related Primary Filter is present on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method PrimaryFilterOnSaleDropDown");
			Log.error("On Sale related Primary Filter is not found on PLP");
			throw (e);
		}

		return element;

	}

	public static WebElement PrimaryFilterOnSaleDropDownContainer() throws Exception {

		try {
			Log.info("Locating On Sale related Primary Filter Container on PLP ");
			// element = Driver.findElement(By.xpath("//*[@class='filter-scroll l3-category
			// js-facet-form']"));
			element = Driver.findElement(By.xpath("//*[@class='filter-scroll promo-list js-facet-form']"));
			// element = Driver.findElement(By
			// .xpath("//div[@class='viewport']"));
			Utils.highLight(element);
			Log.info("On Sale related Primary Filter Container is present on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method PrimaryFilterOnSaleDropDownContainer");
			Log.error("On Sale related Primary Filter Container is not found on PLP");
			throw (e);
		}

		return element;

	}

	public static WebElement SelectBrandCheckbox(String Brand) throws Exception {

		try {
			Log.info("Locating Brand name checkbox on PLP ");
			element = Driver.findElement(By.xpath("//input[@id='" + Brand + "']"));
			Log.info("Brand name checkbox is present on PLP ");
			Utils.highLight(element);

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method SelectBrandCheckbox");
			Log.error("Brand name checkbox is not found on PLP");
			throw (e);
		}

		return element;
	}

	public static WebElement SelectDeliveryTypeCheckbox() throws Exception {

		try {
			Log.info("Locating DeliveryType checkbox on PLP ");
//			element = Driver.findElement(By.xpath("//label[@for='Store Pick Up']"));
			element = Driver.findElement(By.xpath("//label[@for='Express Store Pick up']/span"));
			Log.info("DeliveryType checkbox is present on PLP ");
			Utils.highLight(element);

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method SelectDeliveryTypeCheckbox");
			Log.error("DeliveryType checkbox is not found on PLP");
			throw (e);
		}

		return element;
	}

	public static WebElement SelectPriceCheckbox(String PriceRange) throws Exception {

		try {
			Log.info("Locating Price Range checkbox on PLP ");
			Thread.sleep(1000);
			element = Driver.findElement(By.xpath("//label[@for='" + PriceRange + "']"));
//			element = Driver.findElement(By.xpath("//label[contains(.,'"+PriceRange+"')]"));
			Log.info("Price Range checkbox is present on PLP ");
			Utils.highLight(element);

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method SelectPriceCheckbox");
			Log.error("Price Range checkbox not found on PLP");
			throw (e);
		}

		return element;

	}

	public static WebElement SelectSizeCheckbox(String sizeValue) throws Exception {

		try {
			Log.info("Locating Price Range checkbox on PLP ");
			System.out.println("//input[@id='" + sizeValue + "' and @type='checkbox']");
			element = Driver.findElement(By.xpath("//input[@id='" + sizeValue + "' and @type='checkbox']/following::span"));
			Log.info("Price Range checkbox is present on PLP ");
			Utils.highLight(element);

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method SelectPriceCheckbox");
			Log.error("Price Range checkbox not found on PLP");
			throw (e);
		}

		return element;

	}

	public static WebElement SelectColorCheckbox(String color) throws Exception {

		try {
			Log.info("Locating Color checkbox on PLP ");
			element = Driver.findElement(By.xpath("//input[@id='" + color + "' and @type='checkbox']/following::span"));
			Utils.highLight(element);
			Log.info("Color checkbox is present on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method SelectColorCheckbox");
			Log.error("Color checkbox not found on PLP");
			throw (e);
		}

		return element;

	}

	public static WebElement Enterpricerange() throws Exception {

		try {
			Log.info("Locating Color checkbox on PLP ");
			element = Driver.findElement(By.xpath("//p[contains(.,'Enter a price range ')]"));
			Utils.highLight(element);
			Log.info("Color checkbox is present on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method SelectColorCheckbox");
			Log.error("Color checkbox not found on PLP");
			throw (e);
		}

		return element;

	}

	public static WebElement SelectOnSaleCheckbox(String saleOffer) throws Exception {

		try {
			Log.info("Locating Sale offer on PLP ");
			System.out.println("//input[@id='" + saleOffer + "' and @type='checkbox']");
			element = Driver.findElement(
					By.xpath("//div[@class='ex-checkbox']/input[@id='" + saleOffer + "']/following-sibling::label"));
			Utils.highLight(element);
			Log.info("Sale offer is present on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method SelectOnSaleCheckbox");
			Log.error("Sale offer not found on PLP");
			throw (e);
		}

		return element;

	}

	public static WebElement LoadMoreLink() throws Exception {

		try {
			Log.info("Locating Load More Link on PLP ");
			element = Driver.findElement(By.xpath("//*[@id='loadmore']"));
			Utils.highLight(element);
			System.out.println(element.getText()+"  has been displayed");
			Log.info("Load More Link is present on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method LoadMoreLink");
			Log.error("Load More Link is not found on PLP");
			throw (e);
		}

		return element;

	}

	public static WebElement DisplayResultCountSpan() throws Exception {

		try {
			Log.info("Locating Display Result Count Span on PLP ");
			element = Driver.findElement(By.xpath(".//*[@id='loadmore']/following-sibling::span"));
			Utils.highLight(element);
			Log.info("Display Result Count Span is present on PLP ");
			

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method DisplayResultCountSpan");
			Log.error("Display Result Count Span is not found on PLP");
			throw (e);
		}
		return element;


	}

	public static List<WebElement> ProductImage() throws Exception {

		try {
			Log.info("Location Product Image on PLP ");
			webElements = Driver.findElements(By.xpath("//img[contains(@id,'primaryImage')]"));
			Log.info("Product Image is present on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method ProductImage");
			Log.error("Product Image is not found on PLP");
			throw (e);
		}

		return webElements;

	}

	public static WebElement FirstProductImage() throws Exception {

		try {
			Log.info("Locating Product Image on PLP ");
			// element = Driver.findElement(By
			// .xpath("//ul[@id='qv-drop']//li[1]/descendant::div[@class='pro-img']"));

			element = Driver.findElement(By.xpath(".//*[@id='1HashPosition']/a/picture/div/div/div/ul/li[1]/a/img"));
			Utils.highLight(element);
			Log.info("Product Image is present on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method FirstProductImage");
			Log.error("Product Image is not found on PLP");
			throw (e);
		}

		return element;
	}

	public static WebElement ThirdProductImage() throws Exception {

		try {
			Log.info("Locating Product Image on PLP ");
			// element = Driver.findElement(By
			// .xpath("//ul[@id='qv-drop']//li[1]/descendant::div[@class='pro-img']"));

			element = Driver.findElement(By.xpath("(.//*[@id='primaryImage'])[3]"));
			Utils.highLight(element);
			Log.info("Product Image is present on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method FirstProductImage");
			Log.error("Product Image is not found on PLP");
			throw (e);
		}

		return element;

	}

	public static WebElement QuickViewContainer() throws Exception {

		try {
			Log.info("Locating Quick View Container on PLP ");
			element = Driver.findElement(By.xpath("//li[@class='quickbox-li']//div[@id='quick-view-box']"));
			Utils.highLight(element);
			Log.info("Quick View Container is present on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method QuickViewContainer");
			Log.error("Quick View Container is not found on PLP");
			throw (e);
		}

		return element;

	}

	public static List<WebElement> ProductNameInfo() throws Exception {

		try {
			Log.info("Locating Product name information on PLP ");
			webElements = Driver.findElements(By.xpath(
					"//ul[@id='qv-drop']/descendant::div[@class='pro-info']/descendant::div[@class='pro-name']"));
			Log.info("Product name information is present on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method ProductNameInfo");
			Log.error("Product name information is not found on PLP");
			throw (e);
		}

		return webElements;

	}

	public static List<WebElement> ProductPriceInfo() throws Exception {

		try {
			Log.info("Locating Product price information on PLP ");
			webElements = Driver.findElements(
					By.xpath("//ul[@id='qv-drop']/descendant::div[@class='pro-info']/descendant::div[@class='price']"));
			Log.info("Product price information is present on PLP ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method ProductPriceInfo");
			Log.error("Product price information is not found on PLP");
			throw (e);
		}

		return webElements;

	}

	public static List<WebElement> ProductColorOption() throws Exception {

		try {
			Log.info("Locating Product color option information on product image ");
			webElements = Driver.findElements(By.xpath(
					"//ul[@id='qv-drop']/descendant::div[@class='pro-img']/descendant::div[@class='color-type']/ul"));
			Log.info("Product color option information is present on product image ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method ProductColorOption");
			Log.error("Product color option information is not present on product image ");
			throw (e);
		}

		return webElements;

	}

	public static WebElement ProductQuickViewTag() throws Exception {

		try {
			Log.info("Locating Product Quick View Tag on product image ");
			element = Driver.findElement(By.xpath("(//div[@class='quick-view-lbl'])[2]"));
			Utils.highLight(element);
			Log.info("Product Quick View Tag is present on product image ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method ProductQuickViewTag");
			Log.error("Product Quick View Tag is not present on product image ");
			throw (e);
		}
		return element;

	}

	public static WebElement WishListProductQuickViewTag() throws Exception {

		try {
			Log.info("Locating Product Quick View Tag on product image ");
			// element =
			// Driver.findElement(By.xpath("//ul[@id='qv-drop']/li[1]/descendant::div[@class='pro-img
			// restore']/descendant::div[@class='quick-view-lbl']"));
			// element =
			// Driver.findElement(By.xpath("//ul[@id='qv-drop']descendant::div[@class='quick-view-lbl']"));
			element = Driver.findElement(By.xpath(".//*[@id='1HashPosition']/div[2]"));
			Log.info("Product Quick View Tag is present on product image ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method ProductQuickViewTag");
			Log.error("Product Quick View Tag is not present on product image ");
			throw (e);
		}
		return element;

	}

	public static class QuickViewDetails {
		public static WebElement element;
		public static List<WebElement> webElements;

		public static List<WebElement> QuickViewImageThumbnails() throws Exception {

			try {
				Log.info("Locating Quick View Image Thumbnails for Product Quick View Tag on product image ");
				webElements = Driver.findElements(
						By.xpath("//div[@id='quick-view-box']/descendant::div[@class='thumbnails']/descendant::ul/li"));
				Log.info("Quick View Image Thumbnails for Product Quick View Tag is present on product image ");

			} catch (Exception e) {
				Log.error("Exception in Class ProductListing_Page | Method QuickViewImageThumbnails");
				Log.error("Quick View Image Thumbnails for Product Quick View Tag is not present on product image ");
				throw (e);
			}
			return webElements;

		}

		public static List<WebElement> QuickViewImageSlider() throws Exception {

			try {
				Log.info("Locating Quick View Image Slider for Product Quick View Tag on product image ");
				webElements = Driver.findElements(By.xpath(
						"//div[@id='quick-view-box']/descendant::div[@class='slider']/descendant::ul/li/picture"));
				Log.info("Quick View Image Slider for Product Quick View Tag is present on product image ");

			} catch (Exception e) {
				Log.error("Exception in Class ProductListing_Page | Method QuickViewImageSlider");
				Log.error("Quick View Image Slider for Product Quick View Tag is not present on product image ");
				throw (e);
			}
			return webElements;

		}

		public static WebElement QuickViewBrandName() throws Exception {

			try {
				Log.info("Locating Brand Name under Quick View on PLP Page ");
				element = Driver.findElement(By.xpath(
						"//div[@id='quick-view-box']/descendant::div[@class='product_rightside wishListQuickView']/descendant::h2"));
				Utils.highLight(element);
				Log.info("Brand Name is present under Quick View on PLP Page ");

			} catch (Exception e) {
				Log.error("Exception in Class ProductListing_Page | Method QuickViewBrandName");
				Log.error("Brand Name is not present under Quick View on PLP Page ");
				throw (e);
			}
			return element;

		}

		public static WebElement QuickViewProductName() throws Exception {

			try {
				Log.info("Locating Product Name under Quick View on PLP Page ");
				element = Driver.findElement(By.xpath(
						"//div[@id='quick-view-box']/descendant::div[@class='product_rightside wishListQuickView']/descendant::h1"));
				Utils.highLight(element);
				Log.info("Product Name is present under Quick View on PLP Page ");

			} catch (Exception e) {
				Log.error("Exception in Class ProductListing_Page | Method QuickViewProductName");
				Log.error("Product Name is not present under Quick View on PLP Page ");
				throw (e);
			}
			return element;

		}

		public static WebElement QuickViewPrice() throws Exception {

			try {
				Log.info("Locating Product Price under Quick View on PLP Page ");
				element = Driver.findElement(By.xpath(
						"//div[@id='quick-view-box']/descendant::div[@class='product_rightside wishListQuickView']/descendant::div[@class='price_div']"));
				Utils.highLight(element);
				Log.info("Product Price is present under Quick View on PLP Page ");

			} catch (Exception e) {
				Log.error("Exception in Class ProductListing_Page | Method QuickViewPrice");
				Log.error("Product Price is not present under Quick View on PLP Page ");
				throw (e);
			}
			return element;

		}

		public static List<WebElement> QuickViewColorVariant() throws Exception {

			try {
				Log.info("Locating Product Color Variant option under Quick View on PLP Page ");

				webElements = Driver.findElements(By.xpath(
						"//div[@id='quick-view-box']/descendant::div[@class='product_details_main wishListQuickView']/descendant::div[@class='color_div']/ul/li"));
				Log.info("Product Color Variant option is present under Quick View on PLP Page ");

			} catch (Exception e) {
				Log.error("Exception in Class ProductListing_Page | Method QuickViewColorVariant");
				Log.error("Product Color Variant option is not present under Quick View on PLP Page ");
				throw (e);
			}
			return webElements;

		}

		public static List<WebElement> QuickViewSizeVariant() throws Exception {

			try {
				Log.info("Locating Product Size Variant option under Quick View on PLP Page ");
				// webElements =
				// Driver.findElements(By.xpath("//div[@id='quick-view-box']/descendant::div[@class='product_details_main
				// wishListQuickView']/descendant::div[@class='size_width']/ul/li"));

				webElements = Driver.findElements(By.xpath(
						"//div[@class='product_rightside wishListQuickView']/descendant::div[@class='size_width']/ul/li"));
				Log.info("Product Size Variant option is present under Quick View on PLP Page ");

			} catch (Exception e) {
				Log.error("Exception in Class ProductListing_Page | Method QuickViewSizeVariant");
				Log.error("Product Size Variant option is not present under Quick View on PLP Page ");
				throw (e);
			}
			return webElements;

		}

		public static WebElement QuickViewAddToBagButton() throws Exception {

			try {
				Log.info("Locating Add to bag button under Quick View on PLP Page ");
				element = Driver.findElement(By.xpath(".//button[contains(@id,'addToCart')]"));
				Log.info("Add to bag button is present under Quick View on PLP Page ");

			} catch (Exception e) {
				Log.error("Exception in Class ProductListing_Page | Method QuickViewAddToBagButton");
				Log.error("Add to bag button is not present under Quick View on PLP Page ");
				throw (e);
			}
			return element;

		}

		public static WebElement QuickViewPRoductDetailsLink() throws Exception {

			try {
				Log.info("Locating View Product details link under Quick View on PLP Page ");
				element = Driver.findElement(By.xpath(
						"//div[@id='quick-view-box']/descendant::div[@class='product_details_main wishListQuickView']/descendant::p[@class='viewProduct']"));
				Utils.highLight(element);
				Log.info("View Product details link is present under Quick View on PLP Page ");

			} catch (Exception e) {
				Log.error("Exception in Class ProductListing_Page | Method QuickViewPRoductDetailsLink");
				Log.error("View Product details link is not present under Quick View on PLP Page ");
				throw (e);
			}
			return element;

		}

		public static WebElement QuickViewRemoveFromWishlist() throws Exception {

			try {
				Log.info("Locating Remove from wishlist link under Quick View on PLP Page ");
				element = Driver.findElement(By.xpath(
						"//div[@id='quick-view-box']/descendant::div[@class='product_details_main wishListQuickView']/descendant::button[@id='removewishlistId' and @type='submit']"));
				Log.info("Remove from wishlist link is present under Quick View on PLP Page ");

			} catch (Exception e) {
				Log.error("Exception in Class ProductListing_Page | Method QuickViewRemoveFromWishlist");
				Log.error("Remove from wishlist link is not present under Quick View on PLP Page ");
				throw (e);
			}
			return element;

		}

		public static WebElement QuickViewAddToWishlist() throws Exception {

			try {
				Log.info("Locating Add to wishlist link under Quick View on PLP Page ");
				element = Driver.findElement(By.xpath(
						"//div[@id='quick-view-box']/descendant::div[@class='product_details_main wishListQuickView']/descendant::button[@id='addwishlistId' and @type='submit']"));
				Log.info("Add to wishlist link is present under Quick View on PLP Page ");

			} catch (Exception e) {
				Log.error("Exception in Class ProductListing_Page | Method QuickViewAddToWishlist");
				Log.error("Add to wishlist link is not present under Quick View on PLP Page ");
				throw (e);
			}
			return element;

		}

	}

	public static List<WebElement> PromotionImageLink() throws Exception {

		try {
			Log.info("Locating Promotion image link on product image ");
			elements = Driver.findElements(By.xpath("//input[@class='nApPostion']/.."));
			Log.info("Promotion image link is present on product image ");
			return elements;
		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method PromotionImageLink");
			Log.error("Promotion image link is not present on product image ");
			throw (e);
		}

	}

	public static WebElement AddToWishList() throws Exception {

		try {
			Log.info("Locating Add to wishlist on product image ");
			element = Driver.findElement(By.xpath("(.//*[@class='sign-tag go_link wishlistSubmitBtn wishlist'])[2]"));
			Log.info("Add to wishlist is present on product image ");
			Utils.highLight(element);

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method AddToWishList");
			Log.error("Add to wishlist is not present on product image ");
			throw (e);
		}

		return element;

	}

	public static WebElement AddToWishListinpdp() throws Exception {

		try {
			Log.info("Locating Add to wishlist on product AddToWishListinpdp ");
			//element = Driver.findElement(By.xpath("//ul[@class='shareicon-wishlist']/descendant::button"));
			element = Driver.findElement(By.cssSelector("button#addwishlistId"));
			Log.info("Add to wishlist is present on product image ");
			Utils.highLight(element);

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method AddToWishListinpdp");
			Log.error("Add to wishlist is not present on product AddToWishListinpdp ");
			throw (e);
		}

		return element;

	}
	public static boolean AlreadyInWishList() throws Exception {
		boolean whishList = true;
		try {
			Log.info("Locating Add to wishlist on product image ");
			//element = Driver.findElement(By.xpath("//button[@class='go_link wishlistSubmitBtn wishlist active']"));
			element = Driver.findElement(By.cssSelector("div.prd-fav.wishList-login-sign"));
			
			Log.info("Alreday added to wishlist colour is displayed ");

		} catch (Exception e) {

			Log.info("Alreday added to wishlist colour is not displayed ");
			whishList = false;
		}

		return whishList;

	}

	public static WebElement RemoveFromWishList() throws Exception {

		try {
			Log.info("Locating RemoveFromWishListQuickView on product image ");
			element = Driver.findElement(By.xpath(".//*[@id='removewishlistId']"));
			Log.info("RemoveFromWishListQuickView is present on product image ");
			Utils.highLight(element);

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method AddToWishList");
			Log.error("Add to wishlist is not present on product image ");
			throw (e);
		}

		return element;

	}

	public static WebElement QuickViewClose() throws Exception {

		try {
			Log.info("Locating Close Link on Qick View ");
			element = Driver.findElement(By
					.xpath("//section[@class='product-listing-wrapper']/descendant::div[@class='close-box qv-close']"));
			Log.info("Close Link is present on Qick View ");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method QuickViewClose");
			Log.error("Close Link is not present on Qick View");
			throw (e);
		}
		return element;
	}

	public static WebElement breadCrumb() throws Exception {

		try {
			Log.info("Locating breadcrumb in PLP page");
			element = Driver.findElement(By.xpath("//*[@class='breadcrumb']"));
			Log.info("breadcrumb is preset in PLP page");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method breadCrumb");
			Log.error("breadcrumb is not preset in PLP page");
			throw (e);
		}
		return element;
	}

	public static WebElement PriceStartRange() throws Exception {

		try {
			Log.info("Locating PriceStartRange in PLP page");

			element = Driver.findElement(By.xpath("(//input[@id='startRange'])[2]"));
			Utils.highLight(element);
			Log.info("PriceStartRange is preset in PLP page");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method PriceStartRange");
			Log.error("PriceStartRange is not preset in PLP page");
			throw (e);
		}
		return element;
	}

	public static WebElement PriceEndRange() throws Exception {

		try {
			Log.info("Locating PriceEndRange in PLP page");
			element = Driver.findElement(By.xpath("(.//*[@id='endRange'])[2]"));
			Log.info("PriceEndRange is preset in PLP page");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method PriceEndRange");
			Log.error("PriceEndRange is not preset in PLP page");
			throw (e);
		}
		return element;
	}

	public static WebElement RefineSearchBtn() throws Exception {

		try {
			Log.info("Locating RefineSearchBtn in PLP page");
			element = Driver.findElement(By.xpath("//button[contains(.,'REFINE SEARCH')]"));
			Log.info("RefineSearchBtn is preset in PLP page");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method RefineSearchBtn");
			Log.error("RefineSearchBtn is not preset in PLP page");
			throw (e);
		}
		return element;
	}

	public static WebElement DyPopup() throws Exception {

		try {
			Log.info("Locating RefineSearchBtn in PLP page");
			element = Driver.findElement(By.xpath("//div[@class='dytmpl-circle-hide_inner']"));
			Log.info("RefineSearchBtn is preset in PLP page");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method RefineSearchBtn");
			Log.error("RefineSearchBtn is not preset in PLP page");
			throw (e);
		}
		return element;
	}

	public static WebElement DyPopupCloseBtn() throws Exception {

		try {
			Log.info("Locating RefineSearchBtn in PLP page");
			element = Driver.findElement(By.xpath("//div[@class='dy-lb-close']"));
			Log.info("RefineSearchBtn is preset in PLP page");

		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method RefineSearchBtn");
			Log.error("RefineSearchBtn is not preset in PLP page");
			throw (e);
		}
		return element;
	}

	public static List<WebElement> breadcrumb() {
		try {
			Log.info("Locating breadcrumb in PLP page");
			List<WebElement> elements = Driver.findElements(By.xpath("//ol[@class='breadcrumb']/li"));
			Log.info("breadcrumb is preset in PLP page");
			return elements;
		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method breadcrumb");
			Log.error("breadcrumb is not preset in PLP page");
			throw (e);
		}

	}
	public static WebElement promotionImageHeader() {
		try {
			Log.info("Locating Header  in PLP page");
			 element = Driver.findElement(By.xpath("//div[@class='plpH2TagCategoryNameDiv']/h1"));
			Log.info("Header is preset in PLP page");
			return element;
		} catch (Exception e) {
			Log.error("Exception in Class ProductListing_Page | Method promotionImageHeader");
			Log.error("promotionImageHeader is not preset in PLP page");
			throw (e);
		}
		
	}
}

