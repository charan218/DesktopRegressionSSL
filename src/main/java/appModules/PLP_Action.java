package appModules;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import pageObjects.BaseClass;
import pageObjects.Home_Page;
import pageObjects.ProductDetails_Page;
import pageObjects.ProductListing_Page;
import pageObjects.Static_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;

public class PLP_Action {
	public static WebDriver Driver = null;
	public static WebElement elem = null;

	public static void PLP_Verify_Default_Content(int iTestCaseRow) throws Exception {
		Log.info("Verification for Default content on PLP page");

		String title1 = null;
		List<String> testData = Utils.csvDataReader(ExcelUtils.getCellData(iTestCaseRow, Constant.title));
		System.out.println(Static_Page.SortByInfo().size());
		System.out.println(testData.size());
		Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.browser));
		try {
			Utils.verifyElement(ProductListing_Page.ProductCount());
			Log.info("Product Item Count found on PLP page");
		} catch (Exception e) {
			Log.error("Product Item Count not found on PLP page");
			BaseClass.errorValidation += "Product Item Count not found on PLP page \n";
		}

		try {
			Utils.verifyElement(ProductListing_Page.HeadingProductCount());
			Log.info("Product Item Count with Product heading found on PLP page");
		} catch (Exception e) {
			Log.error("Product Item Count with Product heading not found on PLP page");
			BaseClass.errorValidation += "Product Item Count not found on PLP page \n";
		}
		// try {
		// Select dropDown=ProductListing_Page.SortOptions();
		// String defaultSort=dropDown.getFirstSelectedOption().getText();
		// Utils.verifyElement(ProductListing_Page.SortOptions());
		// if(!(defaultSort.equals("Relevance"))){
		// BaseClass.errorValidation += "Sort option not selected by default on PLP page
		// \n";
		// }
		// Log.info("Sort option found on PLP page");
		// } catch (Exception e) {
		// System.out.println(e.getMessage());
		// Log.error("Sort option not found on PLP page");
		// BaseClass.errorValidation += "Sort option not found on PLP page \n";
		// }
		try {
			for (int i = 0; i < Static_Page.SortByInfo().size(); i++) {
				title1 = Static_Page.SortByInfoText(i + 1).getText();
				System.out.println(testData.get(i));
				System.out.println(Static_Page.SortByInfoText(i+1).getText());

				if (!(title1.equals(testData.get(i)))) {
					BaseClass.errorValidation += "Tool Tip for - " + title1
							+ " - does not match with expected values. \n";
				} else {

					Log.info("Tool Tip for - " + title1 + " - match with expected values.");
				}
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw e;
		}
		try {
			Utils.verifyElement(ProductListing_Page.GridViewIcon());
			Log.info("Grid View Icon found on PLP page");
		} catch (Exception e) {
			Log.error("Grid View Icon not found on PLP page");
			BaseClass.errorValidation += "Grid View Icon not found on PLP page \n";
		}
		if (ProductDetails_Page.breadCrumb().isDisplayed()) {
			System.out.println("Breadcrumb is displayed");
		}
	}

	public static void PLP_Verify_Filter_On_Off_Functionality(int iTestCaseRow) throws Exception {
		boolean check;
		Log.info("Verification for Filter On Off Functionality on PLP page");
		try {
			ProductListing_Page.FilterOnOff().click();
			Log.info("Filter on link is clicked");
			check = Utils.CheckEnability(ProductListing_Page.DefaultFilterContainer());
			if (check) {
				BaseClass.errorValidation += "Default Filter Container should not be present on PLP when Filter is set to on\n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Filter_On_Off_Functionality");
			throw e;
		}
		try {
			ProductListing_Page.FilterOnOff().click();
			Log.info("Filter off link is clicked");
			check = Utils.CheckEnability(ProductListing_Page.DefaultFilterContainer());
			if (!check) {
				BaseClass.errorValidation += "Default Filter Container should be present on PLP when Filter is set to off\n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Filter_On_Off_Functionality");
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Filter_On_Off_Functionality");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void PLP_Verify_Default_Filter_Attributes_Functionality(int iTestCaseRow) throws Exception {
		String productCount = "";
		Log.info("Verification for Default Filter Attributes Functionality on PLP page");

		productCount = ProductListing_Page.ProductCount().getText();
		try {
			if (!(ProductListing_Page.DefaultAttributeFilterCategoryContainer().size() > 0)) {
				BaseClass.errorValidation += "Default Filter Attributes container not present on PLP \n";
			}
			ProductListing_Page
					.DefaultAttributeFilterCategory(ExcelUtils.getCellData(iTestCaseRow, Constant.defaultFilter1))
					.click();
			Log.info("Default Filter attribute category applied on PLP page");
			ProductListing_Page
					.DefaultAttributeFilterPageLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.defaultFilterValue1))
					.click();
			Log.info("Default Filter attribute sub category applied on PLP page");
			// Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.browser));

			ProductListing_Page
					.DefaultAttributeFilterCategory(ExcelUtils.getCellData(iTestCaseRow, Constant.defaultFilter2))
					.click();
			Log.info("Default Filter attribute category applied on PLP page");
			ProductListing_Page
					.DefaultAttributeFilter(ExcelUtils.getCellData(iTestCaseRow, Constant.defaultFilterValue2)).click();
			Log.info("Default Filter attribute sub category applied on PLP page");
			// Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.browser));

			ProductListing_Page
					.DefaultAttributeFilterCategory(ExcelUtils.getCellData(iTestCaseRow, Constant.defaultFilter3))
					.click();
			Log.info("Default Filter attribute category applied on PLP page");
			ProductListing_Page
					.DefaultAttributeFilter(ExcelUtils.getCellData(iTestCaseRow, Constant.defaultFilterValue3)).click();
			Log.info("Default Filter attribute sub category applied on PLP page");
			// Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.browser));
			Log.info("Filters selected successfully on PLP page");
			if (ProductListing_Page.ProductCount().getText().equals(productCount)) {
				BaseClass.errorValidation += "Product Count not changing on applying Default Attribute Filters on PLP \n";
			}
			if (!(ProductListing_Page.DefaultAttributeFilterAppliedList().size() > 0)) {
				BaseClass.errorValidation += "Default Attribute Filters applied on PLP are not displayed \n";
			}
			ProductListing_Page
					.DefaultAttributeFilterCategory(ExcelUtils.getCellData(iTestCaseRow, Constant.defaultFilter1))
					.click();
			Log.info("Default Filter attribute category removed on PLP page");
			ProductListing_Page
					.DefaultAttributeFilterPageLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.defaultFilterValue1))
					.click();
			Log.info("Default Filter attribute sub category removed on PLP page");
			// Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.browser));

			ProductListing_Page
					.DefaultAttributeFilterCategory(ExcelUtils.getCellData(iTestCaseRow, Constant.defaultFilter2))
					.click();
			Log.info("Default Filter attribute category removed on PLP page");
			ProductListing_Page
					.DefaultAttributeFilter(ExcelUtils.getCellData(iTestCaseRow, Constant.defaultFilterValue2)).click();
			Log.info("Default Filter attribute sub category removed on PLP page");
			// Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.browser));

			ProductListing_Page
					.DefaultAttributeFilterCategory(ExcelUtils.getCellData(iTestCaseRow, Constant.defaultFilter3))
					.click();
			Log.info("Default Filter attribute category removed applied on PLP page");
			ProductListing_Page
					.DefaultAttributeFilter(ExcelUtils.getCellData(iTestCaseRow, Constant.defaultFilterValue3)).click();
			Log.info("Default Filter attribute sub category removed on PLP page");
			// Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.browser));
			Log.info("Filters removed successfully on PLP page");
			if (!(ProductListing_Page.ProductCount().getText().equals(productCount))) {
				BaseClass.errorValidation += "Product Count not changing to default count on deselecting Default Attribute Filters on PLP \n";
			}
			if (ProductListing_Page.DefaultAttributeFilterAppliedList().size() > 0) {
				BaseClass.errorValidation += "Default Attribute Filters applied on PLP are not cleared on deselecting Default Attribute Filters on PLP\n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Default_Filter_Attributes_Functionality");
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Default_Filter_Attributes_Functionality");
			throw new Exception(BaseClass.errorValidation);
		}

	}

	public static void PLP_Verify_Brand_FilterDropDown(int iTestCaseRow) throws Exception {
		boolean check;
		try {
			// Utils.scrollingToPageElementAdvanced(ProductListing_Page.PrimaryFilterPriceDropDown());
			// Utils.scrollingToPageElementByCordinate(140, 700);
			System.out.println("Clicked first time on Brand");
			check = Utils.CheckEnability(ProductListing_Page.PrimaryFilterBrandDropDownContainer());
			if (!check) {
				BaseClass.errorValidation += "Primary Filter Container for Brand is not present on PLP while it should be present \n";
			}

			Utils.mouseHover(ProductListing_Page.PrimaryFilterBrandDropDown());
			System.out.println("Mouse hovered");
			// ProductListing_Page.PrimaryFilterBrandDropDown().sendKeys(Keys.ENTER);
			ProductListing_Page.PrimaryFilterBrandDropDown().click();
			Log.info("Primary filter Brand drop down clicked on PLP page");
			System.out.println("Primary filter Brand drop down clicked on PLP page");
			// Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.browser));
			Log.info("Verification for Primary Filter Brand Drop Down Compression on PLP page");
			System.out.println("Clicked second time on Brand");
			Thread.sleep(1000);
			check = Utils.CheckEnability(ProductListing_Page.PrimaryFilterBrandDropDownContainer());
			if (!check) {
				BaseClass.errorValidation += "Primary Filter Container for Brand is present on PLP while it should be compressed \n";
			}
			// Utils.mouseHover(ProductListing_Page.PrimaryFilterBrandDropDown());
			// ProductListing_Page.PrimaryFilterBrandDropDown().sendKeys(Keys.ENTER);
			// ProductListing_Page.PrimaryFilterBrandDropDown().click();
			// System.out.println("Clicked 3rd time on Brand");
			// Log.info("Primary filter Brand drop down clicked on PLP page");
			// Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.browser));
			/* Written Two times */
//			check = Utils.CheckEnability(ProductListing_Page.PrimaryFilterBrandDropDownContainer());
//			if (!check) {
//				BaseClass.errorValidation += "Primary Filter Container for Brand  is not present on PLP while it should be present  \n";
//			}
			Log.info("Verification for Primary Filter Brand Drop Down Functionality completed on PLP page");

		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Brand_FilterDropDown");
			throw e;
		}

	}

	public static void PLP_Verify_ProductType_FilterDropDown(int iTestCaseRow) throws Exception {
		boolean check;
		try {
			check = Utils.CheckEnability(ProductListing_Page.PrimaryFilterProductTypeDropDownContainer());
			if (!check) {
				BaseClass.errorValidation += "Primary Filter Container for ProductType is not present on PLP while it should be present \n";
			}
			ProductListing_Page.PrimaryFilterProductType().click();
			Thread.sleep(3000);
			Log.info("Primary filter ProductType drop down clicked on PLP page");
			Log.info("Verification for Primary Filter ProductType Drop Down Compression on PLP page");
			Thread.sleep(1000);
			check = Utils.CheckEnability(ProductListing_Page.PrimaryFilterProductTypeDropDownContainer());
			if (check) {
				BaseClass.errorValidation += "Primary Filter Container for ProductType is present on PLP while it should be compressed \n";
			}
			// Thread.sleep(3000);
			//ProductListing_Page.PrimaryFilterProductType().click();
			Log.info("Primary filter ProductType drop down clicked on PLP page");
			check = Utils.CheckEnability(ProductListing_Page.PrimaryFilterProductTypeDropDownContainer());
			if (!check) {
				BaseClass.errorValidation += "Primary Filter Container for ProductType  is not present on PLP while it should be present  \n";
			}
			Log.info("Verification for Primary Filter ProductType Drop Down Functionality completed on PLP page");

		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_ProductType_FilterDropDown");
			throw e;
		}

	}

	public static void PLP_Verify_Price_FilterDropDown(int iTestCaseRow) throws Exception {
		boolean check;
		try {
			// Utils.scrollingToPageElementByelement(ProductListing_Page.PrimaryFilterColorDropDown());
			// Thread.sleep(5000);
			// Utils.scrollingToPageElementByCordinate(140, 50);
			check = Utils.CheckEnability(ProductListing_Page.PrimaryFilterPriceDropDownContainer());
			if (!check) {
				BaseClass.errorValidation += "Primary Filter Container for Price is present on PLP while it should not be present \n";
			}
			// Utils.mouseHover(ProductListing_Page.PrimaryFilterPriceDropDown());
//			ProductListing_Page.PrimaryFilterPriceDropDown().click();
			Utils.jsClick(ProductListing_Page.PrimaryFilterPriceDropDown());

			// Thread.sleep(5000);
			// ProductListing_Page.PrimaryFilterPriceDropDown().sendKeys(Keys.ENTER);
			// ProductListing_Page.PrimaryFilterPriceDropDown().sendKeys(Keys.ENTER);
			Log.info("Primary filter Price drop down clicked on PLP page");
			// Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.browser));
			Log.info("Verification for Primary Filter Price Drop Down Compression on PLP page");
			Thread.sleep(2000);
			check = Utils.CheckEnability(ProductListing_Page.PrimaryFilterPriceDropDownContainer());
			if (!check) {
				BaseClass.errorValidation += "Primary Filter Container for Price is not present on PLP while it should be present \n";
			}

//			Utils.mouseHover(ProductListing_Page.PrimaryFilterPriceDropDown());
			// ProductListing_Page.PrimaryFilterPriceDropDown().sendKeys(Keys.ENTER);
			// Utils.mouseHover(ProductListing_Page.PrimaryFilterPriceDropDown());
			// Robot rob1 = new Robot();
			// rob1
			// .keyPress(KeyEvent.VK_ENTER);
			// Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.browser));
			Thread.sleep(2000);
			Utils.jsClick(ProductListing_Page.PrimaryFilterPriceDropDown());
//			ProductListing_Page.PrimaryFilterPriceDropDown().click();
			Log.info("Primary filter Size drop down clicked on PLP page");
			// Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.browser));
			check = Utils.CheckEnability(ProductListing_Page.PrimaryFilterPriceDropDownContainer());
			if (!check) {
				BaseClass.errorValidation += "Primary Filter Container for Price is present on PLP while it should not be present  \n";
			}
			Log.info("Verification for Primary Filter Price Drop Down Functionality completed on PLP page");

		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Price_FilterDropDown");
			throw e;
		}

	}

	public static void PLP_Verify_Size_FilterDropDown(int iTestCaseRow) throws Exception {
		boolean check;
		try {

			Log.info("Scrolled to Size Primary filter drop down on PLP page");
			check = Utils.CheckEnability(ProductListing_Page.PrimaryFilterSizeDropDownContainer());
			if (!check) {
				BaseClass.errorValidation += "Primary Filter Container for Size is  present on PLP while it should not be present \n";
			}
			Utils.mouseHover(ProductListing_Page.PrimaryFilterSizeDropDown());
			System.out.println("mouse hovered on size");
			Utils.jsClick(ProductListing_Page.PrimaryFilterSizeDropDown());
			System.out.println("Clicked first time on Size");
			Log.info("Primary filter Size drop down clicked on PLP page");
			// Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.browser));
			Log.info("Verification for Primary Filter Size Drop Down Compression on PLP page");
			Thread.sleep(2000);
			check = Utils.CheckEnability(ProductListing_Page.PrimaryFilterSizeDropDownContainer());
			if (!check) {
				BaseClass.errorValidation += "Primary Filter Container for Size is not present on PLP while it should be present \n";
			}

			Utils.mouseHover(ProductListing_Page.PrimaryFilterSizeDropDown());
			// ProductListing_Page.PrimaryFilterSizeDropDown().sendKeys(Keys.ENTER);
			System.out.println("Clicked 2nd time on Size");
			Utils.jsClick(ProductListing_Page.PrimaryFilterSizeDropDown());
			Log.info("Primary filter Size drop down clicked on PLP page");
			// Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.browser));
			check = Utils.CheckEnability(ProductListing_Page.PrimaryFilterSizeDropDownContainer());
			if (!check) {
				BaseClass.errorValidation += "Primary Filter Container for Size is  present on PLP while it should not be present \n";
			}
			Log.info("Verification for Primary Filter Size Drop Down Functionality completed on PLP page");

		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Size_FilterDropDown");
			throw e;

		}

	}

	public static void PLP_Verify_Color_FilterDropDown(int iTestCaseRow) throws Exception {
		boolean check;
		try {

			// Utils.scrollingToPageElementByelement(ProductListing_Page.PrimaryFilterColorDropDownContainer());
			System.out.println("Scrolling till Color Tab Successful");
			Log.info("Scrolled to Color filter drop down on PLP page");
			Thread.sleep(2000);
			check = Utils.CheckEnability(ProductListing_Page.PrimaryFilterColorDropDownContainer());
			if (!check) {
				BaseClass.errorValidation += "Primary Filter Container for Color is present on PLP while it should not be present \n";
			}
			// Utils.mouseHover(ProductListing_Page.PrimaryFilterColorDropDown());
			// ProductListing_Page.PrimaryFilterColorDropDown().sendKeys(Keys.ENTER);
			Utils.jsClick(ProductListing_Page.PrimaryFilterColorDropDown());
			System.out.println("Clicked first time on Color");
			Log.info("Primary filter Color drop down clicked on PLP page");
			// Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.browser));
			Log.info("Verification for Primary Filter Color Drop Down Compression on PLP page");
			Thread.sleep(2000);
			check = Utils.CheckEnability(ProductListing_Page.PrimaryFilterColorDropDownContainer());
			if (!check) {
				BaseClass.errorValidation += "Primary Filter Container for Color is not present on PLP while it should be present \n";
			}

			// Utils.mouseHover(ProductListing_Page.PrimaryFilterColorDropDown());
			// ProductListing_Page.PrimaryFilterColorDropDown().sendKeys(Keys.ENTER);
			Utils.jsClick(ProductListing_Page.PrimaryFilterColorDropDown());
			System.out.println("Clicked 2nd time on Color");
			Log.info("Primary filter Color drop down clicked on PLP page");
			// Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.browser));
			check = Utils.CheckEnability(ProductListing_Page.PrimaryFilterColorDropDownContainer());
			if (!check) {
				BaseClass.errorValidation += "Primary Filter Container for Color is present on PLP while it should not be present  \n";
			}
			Log.info("Verification for Primary Filter Color Drop Down Functionality completed on PLP page");
		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Color_FilterDropDown");
			throw e;
		}

	}

	public static void PLP_Verify_OnSale_FilterDropDown(int iTestCaseRow) throws Exception {
		boolean check;
		try {

			Utils.scrollingToPageElementByelement(ProductListing_Page.PrimaryFilterPriceDropDownContainer());
			// Utils.scrollingToPageElementByCordinate(144, 1100);
			Log.info("Scrolled to On Sale filter drop down on PLP page");
			check = Utils.CheckEnability(ProductListing_Page.PrimaryFilterOnSaleDropDownContainer());
			if (!check) {
				BaseClass.errorValidation += "Primary Filter Container for On Sale is not present on PLP while it should be present \n";
			}
			// Utils.mouseHover(ProductListing_Page.PrimaryFilterOnSaleDropDown());
			// ProductListing_Page.PrimaryFilterOnSaleDropDown().sendKeys(Keys.ENTER);
			ProductListing_Page.PrimaryFilterOnSaleDropDown().click();
			// ProductListing_Page.PrimaryFilterOnSaleDropDown().click();
			Log.info("Primary filter On Sale drop down clicked on PLP page");
			// Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.browser));
			Log.info("Verification for Primary Filter On Sale Drop Down Compression on PLP page");
			check = Utils.CheckEnability(ProductListing_Page.PrimaryFilterOnSaleDropDownContainer());
			if (check) {
				BaseClass.errorValidation += "Primary Filter Container for On Sale is present on PLP while it should be compressed \n";
			}

			// Utils.mouseHover(ProductListing_Page.PrimaryFilterOnSaleDropDown());
			// ProductListing_Page.PrimaryFilterOnSaleDropDown().sendKeys(Keys.ENTER);
			ProductListing_Page.PrimaryFilterOnSaleDropDown().click();
			// Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.browser));
			check = Utils.CheckEnability(ProductListing_Page.PrimaryFilterOnSaleDropDownContainer());
			if (!check) {
				BaseClass.errorValidation += "Primary Filter Container for On Sale is not present on PLP while it should be present  \n";
			}
			Log.info("Verification for Primary Filter On Sale Drop Down Functionality completed on PLP page");
		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_OnSale_FilterDropDown");
			throw e;
		}
	}

	public static void PLP_Verify_Primary_Filter_DropDown_Functionality(int iTestCaseRow) throws Exception {

		Log.info("Verification for Primary Filter Drop Down Functionality on PLP page");
		try {
			System.out.println("Brand filter dropdown");
			PLP_Verify_Brand_FilterDropDown(iTestCaseRow);
			 PLP_Verify_ProductType_FilterDropDown(iTestCaseRow);
			PLP_Verify_Size_FilterDropDown(iTestCaseRow);
			PLP_Verify_Color_FilterDropDown(iTestCaseRow);
			PLP_Verify_Price_FilterDropDown(iTestCaseRow);
//			 PLP_Verify_OnSale_FilterDropDown(iTestCaseRow);

		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Primary_Filter_DropDown_Functionality");
			throw e;
		}
	}

	public static void PLP_Verify_Select_Brand_Functionality(int iTestCaseRow) throws Exception {
		String productCount = "";
		Log.info("Verification for selecting Brand checkbox from Primary Filter Functionality on PLP page");
		try {
			Thread.sleep(1000);
			productCount = ProductListing_Page.ProductCount().getText();
			Utils.scrollingToPageElement(ProductListing_Page.PrimaryFilterBrandDropDown());
			Thread.sleep(2000);
			Utils.jsClick(ProductListing_Page.SelectBrandCheckbox(ExcelUtils.getCellData(iTestCaseRow, Constant.brandName)));

			Log.info("Brand specific filter applied on PLP page");
			Thread.sleep(3000);
			if (ProductListing_Page.ProductCount().getText().equals(productCount)) {
				BaseClass.errorValidation += "Product count not changing on slecting specific Brand checkbox\n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Select_Brand_Functionality");
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Select_Brand_Functionality");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void PLP_Verify_Select_DeliveryType_Functionality(int iTestCaseRow) throws Exception {
		String productCount = "";
		Log.info("Verification for selecting Brand DeliveryType from Primary Filter Functionality on PLP page");
		try {
			Utils.waitForPageLoad();
			Thread.sleep(1000);
			productCount = ProductListing_Page.ProductCount().getText();
//			Utils.scrollingToPageElementByelement(ProductListing_Page.PrimaryFilterPriceDropDown());
			Utils.scrollingToPageElementByelement(ProductListing_Page.SelectDeliveryTypeCheckbox());
			Thread.sleep(2000);
			Utils.waitForElementTOclick(ProductListing_Page.SelectDeliveryTypeCheckbox());
			Thread.sleep(3000);
			Log.info("DeliveryType specific filter applied on PLP page");
			Thread.sleep(5000);
			if (ProductListing_Page.ProductCount().getText().equals(productCount)) {
				BaseClass.errorValidation += "Product count not changing on slecting specific DeliveryType checkbox\n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Select_DeliveryType_Functionality");
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Select_DeliveryType_Functionality");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void PLP_Verify_Select_Price_Functionality(int iTestCaseRow) throws Exception {
		String productCount = "";
		Log.info("Verification for selecting Price checkbox from Primary Filter Functionality on PLP page");
		try {

			productCount = ProductListing_Page.ProductCount().getText();
			System.out.println(productCount);
			Thread.sleep(3000);
//			Utils.mouseHover(ProductListing_Page.PrimaryFilterColorDropDown());
//			Utils.scrollingToPageElementAdvanced(ProductListing_Page.PrimaryFilterColorDropDown());
			// ProductListing_Page.PrimaryFilterPriceDropDown().click();
			Utils.jsClick(ProductListing_Page
					.SelectPriceCheckbox(ExcelUtils.getCellData(iTestCaseRow, Constant.productPrice)));
			Log.info("Price specific filter applied on PLP page");
			Thread.sleep(3000);
			System.out.println(ProductListing_Page.ProductCount().getText());

			if (ProductListing_Page.ProductCount().getText().equals(productCount)) {
				BaseClass.errorValidation += "Product count not changing on slecting specific price checkbox\n";
			}
			Thread.sleep(5000);
			Utils.refresh();
			Thread.sleep(3000);
			ProductListing_Page.DefaultAttributeFilterClose(1).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Select_Price_Functionality");
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Select_Price_Functionality");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void PLP_Verify_Enter_Price_Functionality(int iTestCaseRow) throws Exception {
		String productCount = "";
		Log.info("Verification for selecting Price checkbox from Primary Filter Functionality on PLP page");
		try {
//			Utils.scrollingToPageElement(ProductListing_Page.PrimaryFilterColorDropDown());
			List<String> priceData = Utils.PriceDataReader(ExcelUtils.getCellData(iTestCaseRow, Constant.productPrice));
			Thread.sleep(3000);
			productCount = ProductListing_Page.ProductCount().getText();
			System.out.println(productCount);
			Utils.scrollingToPageElement(ProductListing_Page.Enterpricerange());
			System.out.println("Price-" + priceData.get(0));
			System.out.println(priceData.get(1));
			Utils.scrollingToPageElement(ProductListing_Page.PriceStartRange());
			Utils.waitForPageLoad();
			Thread.sleep(3000);
//			Utils.moveLeftClick(ProductListing_Page.PriceStartRange());
			System.out.println("moved to left");
			Utils.waitForPageLoad();
			Utils.waitForElementTOclick(ProductListing_Page.PriceStartRange());
			ProductListing_Page.PriceStartRange().sendKeys(priceData.get(0));
			System.out.println("entered amount "+priceData.get(0));
			Utils.waitForPageLoad();
			Utils.jsClick(ProductListing_Page.PriceEndRange());
			ProductListing_Page.PriceEndRange().sendKeys(priceData.get(1));
			System.out.println("entered amount "+priceData.get(1));
			Thread.sleep(2000);
			Utils.jsClick(ProductListing_Page.RefineSearchBtn());
			Thread.sleep(5000);
			System.out.println(ProductListing_Page.ProductCount().getText());

			Log.info("Price specific filter applied on PLP page");
			if (ProductListing_Page.ProductCount().getText().equals(productCount)) {
				BaseClass.errorValidation += "Product count not changing on slecting specific price checkbox\n";
			}
			Utils.refresh();

		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Select_Price_Functionality");
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Select_Price_Functionality");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void PLP_Verify_Select_Size_Functionality(int iTestCaseRow) throws Exception {
		String productCount = "";
		Log.info("Verification for selecting Size checkbox from Primary Filter Functionality on PLP page");
		try {

			productCount = ProductListing_Page.ProductCount().getText();
			System.out.println(productCount+" products are displayed");
			Thread.sleep(2000);
			 Utils.scrollingToPageElementByelement(ProductListing_Page.SelectSizeCheckbox(ExcelUtils.getCellData(iTestCaseRow,
			 Constant.productSize)));
			// ProductListing_Page.PrimaryFilterSizeDropDown().click();
//			ProductListing_Page.SelectSizeCheckbox(ExcelUtils.getCellData(iTestCaseRow, Constant.productSize))
//					.sendKeys(Keys.SPACE);
			 Thread.sleep(2000);
			Utils.jsClick(ProductListing_Page.SelectSizeCheckbox(ExcelUtils.getCellData(iTestCaseRow, Constant.productSize)));
			Utils.waitForPageLoadLongTime();
			Thread.sleep(3000);
			Utils.waitForElementPresence2(ProductListing_Page.ProductCount());
			System.out.println(ProductListing_Page.ProductCount() +" products are displayed");

			Log.info("Size specific filter applied on PLP page");
			if (ProductListing_Page.ProductCount().getText().equals(productCount)) {
				BaseClass.errorValidation += "Product count not changing on slecting specific Size checkbox\n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Select_Size_Functionality");
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Select_Size_Functionality");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void PLP_Verify_Select_Color_Functionality(int iTestCaseRow) throws Exception {
		String productCount = "";
		Log.info("Verification for selecting Color chckbox from Primary Filter Functionality on PLP page");
		try {

			productCount = ProductListing_Page.ProductCount().getText();
			Utils.scrollingToPageElementByelement(ProductListing_Page.PrimaryFilterColorDropDown());
			// ProductListing_Page.PrimaryFilterColorDropDown().click();
//			ProductListing_Page.SelectColorCheckbox(ExcelUtils.getCellData(iTestCaseRow, Constant.productColor))
//					.sendKeys(Keys.SPACE);
			Thread.sleep(2000);
			Utils.jsClick(ProductListing_Page.SelectColorCheckbox(ExcelUtils.getCellData(iTestCaseRow, Constant.productColor)));
			Utils.waitForPageLoadLongTime();
			Thread.sleep(3000);
			Log.info("Color specific filter applied on PLP page");
			if (ProductListing_Page.ProductCount().getText().equals(productCount)) {
				BaseClass.errorValidation += "Product count not changing on slecting specific color checkbox\n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Select_Color_Functionality");
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Select_Color_Functionality");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void PLP_Verify_Select_On_Sale_Functionality(int iTestCaseRow) throws Exception {
		String productCount = "";
		Log.info("Verification for selecting On Sale Checkbox from Primary Filter Functionality on PLP page");
		try {

			productCount = ProductListing_Page.ProductCount().getText();
			ProductListing_Page.SelectOnSaleCheckbox(ExcelUtils.getCellData(iTestCaseRow, Constant.onSaleValue))
					.click();
			Utils.waitForPageLoadLongTime();
			Thread.sleep(2000);
			Log.info("On Sale specific filter applied on PLP page");
			if (ProductListing_Page.ProductCount().getText().equals(productCount)) {
				BaseClass.errorValidation += "Product count not changing on slecting specific On Sale checkbox\n";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Select_On_Sale_Functionality");
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Select_On_Sale_Functionality");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void checkNumbnerOfImageInARowInPLP_Page() throws Exception {
		int i = 3;
		int count = Utils.countNumberOfElementDisplayed(ProductListing_Page.FirstRowImagesPLP());
		if (i == count) {
			System.out.println("PLP page contains 3 product in each row and this is expected behavior");

		} else {
			BaseClass.bResult = false;
			BaseClass.errorValidation += "PLP page contains 3 product in each row and this is expected behavior";
		}
	}

	public static void PLP_Verify_LoadMore_Link_Functionality(int iTestCaseRow) throws Exception {
		String showing = "";

		try {
			Utils.waitForPageLoad();
			Utils.scrollingToPageBottom(ProductListing_Page.DisplayResultCountSpan());
			Utils.scrollingToPageBottom(ProductListing_Page.DisplayResultCountSpan());
			Utils.scrollingToPageBottom(ProductListing_Page.DisplayResultCountSpan());
			Utils.scrollingToPageBottom(ProductListing_Page.DisplayResultCountSpan());
			showing = ProductListing_Page.DisplayResultCountSpan().getText();
			System.out.println(showing+" is displayed ");
			Thread.sleep(4000);
			Utils.jsClick(ProductListing_Page.LoadMoreLink());

			Log.info("Load More link is clicked on PLP page");
			if (ProductListing_Page.DisplayResultCountSpan().getText().equals(showing)) {
				BaseClass.errorValidation += "Showing result count does not change after clicking Load More link\n";
			}

		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_LoadMore_Link_Functionality");
			throw e;
		}
		try {
			Utils.verifyElement(ProductListing_Page.product101());
			Thread.sleep(3000);
		} catch (Exception e) {
			BaseClass.errorValidation += "101 product image not visible after clicking Load More";
		}
	}

	public static void PLP_Verify_Promotion_Image_Link(int iTestCaseRow) throws Exception {

		Log.info("Verification for Promotion image link on PLP page");
		try {
			
			List<WebElement> opt = ProductListing_Page.PromotionImageLink();
			WebElement img = opt.get(0);
			String[] arr = img.getAttribute("title").split(" ");
			Utils.waitForElementTOclick(img);
			System.out.println(arr[0] + " promotion image has been selected");
			System.out.println("Navigating to " + arr[0] + " brannd page ");
			Utils.waitForPageLoad();
			String excepected = ProductListing_Page.promotionImageHeader().getText();
			String[] arr1 = excepected.split(" ");
			if (arr[0].equals(arr1[0])) {
				System.out.println(arr[0] + " promotion product image has been verified");
				System.out.println("<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>");
				System.out.println(excepected+" products are found in PLP page ");
				Log.info(" promotion image has been verified");
			} else {
				Log.error("promotion image has not verified");
			}

			Log.info("Promotional image link clicked on PLP page");
			Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.browser));

		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Promotion_Image_Link");
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Promotion_Image_Link");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void PLP_Verify_Clear_Refinements_Functionality(int iTestCaseRow) throws Exception {
		String productCount = "";
		int filterListSize;
		Log.info("Verification for Clear refinements functionality on PLP page");
		try {

			productCount = ProductListing_Page.ProductCount().getText();

			ProductListing_Page
					.DefaultAttributeFilterCategory(ExcelUtils.getCellData(iTestCaseRow, Constant.defaultFilter1))
					.click();
			Log.info("Default Filter attribute category applied on PLP page");
			System.out.println("Default Filter attribute category applied on PLP page");
			ProductListing_Page
					.DefaultAttributeFilterPageLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.defaultFilterValue1))
					.click();
			Log.info("Default Filter attribute sub category applied on PLP page");
			System.out.println("Default Filter attribute sub category applied on PLP page");
			Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.browser));

			ProductListing_Page
					.DefaultAttributeFilterCategory(ExcelUtils.getCellData(iTestCaseRow, Constant.defaultFilter2))
					.click();
			Log.info("Default Filter attribute category applied on PLP page");
			System.out.println("Default Filter attribute category applied on PLP page 1");
			ProductListing_Page
					.DefaultAttributeFilter(ExcelUtils.getCellData(iTestCaseRow, Constant.defaultFilterValue2)).click();
			Log.info("Default Filter attribute sub category applied on PLP page");
			System.out.println("Default Filter attribute sub category applied on PLP page1");

			Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.browser));

			ProductListing_Page
					.DefaultAttributeFilterCategory(ExcelUtils.getCellData(iTestCaseRow, Constant.defaultFilter3))
					.click();
			Log.info("Default Filter attribute category applied on PLP page");
			ProductListing_Page
					.DefaultAttributeFilter(ExcelUtils.getCellData(iTestCaseRow, Constant.defaultFilterValue3)).click();
			Log.info("Default Filter attribute sub category applied on PLP page");
			Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.browser));
			Log.info("Default Attribute Filters selected successfully on PLP page");

			if (!(ProductListing_Page.DefaultAttributeFilterAppliedList().size() > 0)) {
				BaseClass.errorValidation += "Filters applied container not present on PLP page\n";
			} else {
				filterListSize = ProductListing_Page.DefaultAttributeFilterAppliedList().size();
				for (int i = 1; i <= filterListSize; i++) {
					Utils.jsClick(ProductListing_Page.DefaultAttributeFilterClose(1));
					Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.browser));
					Thread.sleep(2000);
				}
				if (!(ProductListing_Page.ProductCount().getText().equals(productCount))) {
					System.out.println("Product count not reset to default product count after clearing all filters");
					Log.info("Product count not reset to default product count after clearing all filters");
					//BaseClass.errorValidation += "Product count not reset to default product count after clearing all filters \n";
				}
			}

		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Clear_Refinements_Functionality");
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Clear_Refinements_Functionality");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void PLP_Verify_ClearAll_Refinements_Functionality(int iTestCaseRow) throws Exception {
		String productCount = "";

		Log.info("Verification for Clear refinements functionality on PLP page");
		try {

			productCount = ProductListing_Page.ProductCount().getText();
			System.out.println(productCount);
			Thread.sleep(2000);
			ProductListing_Page.SelectBrandCheckbox(ExcelUtils.getCellData(iTestCaseRow, Constant.brandName))
					.sendKeys(Keys.SPACE);
			Utils.scrollingToPageElement(ProductListing_Page.PrimaryFilterBrandDropDown());
			Utils.scrollingToPageElement(ProductListing_Page.SelectBrandCheckbox(ExcelUtils.getCellData(iTestCaseRow, Constant.brandName)));
//			ProductListing_Page.SelectBrandCheckbox(ExcelUtils.getCellData(iTestCaseRow, Constant.brandName))
//			.click();
			Thread.sleep(2000);
			Log.info("Brand specific check box applied on PLP page");
			Utils.scrollingToPageElementByelement(ProductListing_Page.PrimaryFilterPriceDropDown());
//			ProductListing_Page.PrimaryFilterPriceDropDown().click();
//			 ProductListing_Page.SelectPriceCheckbox(ExcelUtils.getCellData(iTestCaseRow,
//			 Constant.productPrice)).sendKeys(Keys.SPACE);
			Thread.sleep(2000);
			Utils.jsClick(ProductListing_Page.SelectPriceCheckbox(ExcelUtils.getCellData(iTestCaseRow,
					 Constant.productPrice)));
			Log.info("Price specific check box applied on PLP page");
			// ProductListing_Page.PrimaryFilterColorDropDown().click();
//			ProductListing_Page.SelectColorCheckbox(ExcelUtils.getCellData(iTestCaseRow, Constant.productColor))
//					.sendKeys(Keys.SPACE);
			Thread.sleep(2000);
			Utils.scrollingToPageElementByelement(ProductListing_Page.SelectColorCheckbox(ExcelUtils.getCellData(iTestCaseRow, Constant.productColor)));
			Thread.sleep(2000);
			Utils.jsClick(ProductListing_Page.SelectColorCheckbox(ExcelUtils.getCellData(iTestCaseRow, Constant.productColor)));
			Log.info("Color specific check box applied on PLP page");

			Log.info("Primary Filters selected successfully on PLP page");

			if (!(ProductListing_Page.DefaultAttributeFilterAppliedList().size() > 0)) {
				BaseClass.errorValidation += "Filters applied container not present on PLP page\n";
			} else {
				Thread.sleep(2000);
				Utils.scrollingToPageElementByCordinate(100, 0);
				Thread.sleep(2000);
				Utils.jsClick(ProductListing_Page.DefaultAttributeFilterCloseAll());
				Utils.waitForPageLoad();
				Thread.sleep(3000);
				Log.info("Close all link clicked to remove applied filters on PLP page");
				if (!(ProductListing_Page.ProductCount().getText().equals(productCount))) {
					System.out.println(ProductListing_Page.ProductCount().getText());
					//BaseClass.errorValidation += "Product count not reset to default product count after clearing all filters \n";
				}
			}

		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_ClearAll_Refinements_Functionality");
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_ClearAll_Refinements_Functionality");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void PLP_Verify_Multi_select_Department_Filter_Functionality(int iTestCaseRow) throws Exception {
		String productCount = "";
		String AfterfirstFilterCount = "";

		Log.info("Verification for Clear refinements functionality on PLP page");
		try {

			productCount = ProductListing_Page.ProductCount().getText();
			System.out.println(productCount+" products has been dispaled for all department");
			Thread.sleep(5000);
			Utils.scrollingToPageElement(ProductListing_Page.DepartmentFilterContainer());
			Utils.verifyElement(ProductListing_Page.DepartmentFilterContainer());
			ProductListing_Page.DepartmentSecondFilter().sendKeys(Keys.SPACE);
			Thread.sleep(5000);
			if (ProductListing_Page.ProductCount().getText().equals(productCount)) {
				System.out.println(ProductListing_Page.ProductCount().getText());
				//BaseClass.errorValidation += "Filter not applied after applying first filter \n";
			}
			AfterfirstFilterCount = ProductListing_Page.ProductCount().getText();
			System.out.println(AfterfirstFilterCount+" products has displayed for sub department");
			ProductListing_Page.DepartmentThirdFilter().sendKeys(Keys.SPACE);
			Thread.sleep(5000);
			if (ProductListing_Page.ProductCount().getText().equals(AfterfirstFilterCount)) {
				System.out.println(ProductListing_Page.ProductCount().getText());
				//BaseClass.errorValidation += "Filter not applied after applying both filter together\n";
			}
			Utils.jsClick(ProductListing_Page.clearFilter());
			Thread.sleep(5000);
			if (!(ProductListing_Page.ProductCount().getText().equals(productCount))) {
				System.out.println(ProductListing_Page.ProductCount().getText());
				//BaseClass.errorValidation += "Product count not reset to default product count after clearing all filters \n";
			}

		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_ClearAll_Refinements_Functionality");
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class PLP_Action | PLP_Verify_Multi_select_Department_Filter_Functionality");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void PLP_Verify_Product_Details(int iTestCaseRow) throws Exception {

		Log.info("Verification for Product Information Details on PLP page");
		try {

			if (!(ProductListing_Page.ProductImage().size() > 0)) {
				BaseClass.errorValidation += "Product Images are not shown for Products on PLP\n";
			}
			if (!(ProductListing_Page.ProductNameInfo().size() > 0)) {
				BaseClass.errorValidation += "Product Name and Brand details are not shown for Products on PLP\n";
			}
			if (!(ProductListing_Page.ProductPriceInfo().size() > 0)) {
				BaseClass.errorValidation += "Product Price Details are not shown for Products on PLP\n";
			}
			System.out.println("Number of price tag in PLP = " + ProductListing_Page.ProductPriceInfo().size());
			System.out.println("Number of price tag in PLP = " + ProductListing_Page.ProductNameInfo().size());
			System.out.println("Number of price tag in PLP = " + ProductListing_Page.ProductImage().size());
			// if (!(ProductListing_Page.ProductColorOption().size() > 0)) {
			// BaseClass.errorValidation += "Product Color options are not shown for
			// Products on PLP\n";
			// }

		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Product_Details");
			throw e;
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_Product_Details");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void PLP_Verify_QuickView_Link(int iTestCaseRow) throws Exception {
		Log.info("Verification for Quick View Link on Product Image on PLP page");

		try {
			Utils.verifyElement(ProductListing_Page.QuickViewContainer());
		} catch (Exception e) {
			Log.error(e.getMessage());
			BaseClass.errorValidation += "Quick View Container not present\n";
		}

		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_QuickView_Link");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void PLP_Verify_QuickView_Details(int iTestCaseRow) throws Exception {
		Log.info("Verification for Quick View Details For product on PLP page");
		try {
			Utils.verifyElement(ProductListing_Page.QuickViewContainer());
		} catch (Exception e) {
			Log.error(e.getMessage());
			BaseClass.errorValidation += "Quick View Container not present on PLP\n";
		}
		if (!(ProductListing_Page.QuickViewDetails.QuickViewImageThumbnails().size() > 0)) {
			BaseClass.errorValidation += "Product Thumbnails are not shown on QickView for Products on PLP\n";
		}
		if (!(ProductListing_Page.QuickViewDetails.QuickViewImageSlider().size() > 0)) {
			BaseClass.errorValidation += "Product Image Slideris  not shown on QickView for Products on PLP\n";
		}
		try {
			Utils.verifyElement(ProductListing_Page.QuickViewDetails.QuickViewBrandName());
		} catch (Exception e) {
			Log.error(e.getMessage());
			BaseClass.errorValidation += "Brand name not found in Quick View for Products on PLP\n";
		}
		try {
			Utils.verifyElement(ProductListing_Page.QuickViewDetails.QuickViewProductName());
		} catch (Exception e) {
			Log.error(e.getMessage());
			BaseClass.errorValidation += "Product name not found in Quick View for Products on PLP\n";
		}
		try {
			Utils.verifyElement(ProductListing_Page.QuickViewDetails.QuickViewPrice());
		} catch (Exception e) {
			Log.error(e.getMessage());
			BaseClass.errorValidation += "Price Tag not found in Quick View for Products on PLP\n";
		}
		if (!(ProductListing_Page.QuickViewDetails.QuickViewColorVariant().size() > 0)) {
			BaseClass.errorValidation += "Color Variants are not shown on QickView for Products on PLP\n";
		}
		if (!(ProductListing_Page.QuickViewDetails.QuickViewSizeVariant().size() > 0)) {
			BaseClass.errorValidation += "Size Variants are not shown on QickView for Products on PLP\n";
		}
		try {
			Utils.verifyElement(ProductListing_Page.QuickViewDetails.QuickViewAddToBagButton());
		} catch (Exception e) {
			Log.error(e.getMessage());
			BaseClass.errorValidation += "Add to cart button not found in Quick View for Products on PLP\n";
		}
		try {
			Utils.verifyElement(ProductListing_Page.QuickViewDetails.QuickViewPRoductDetailsLink());
		} catch (Exception e) {
			Log.error(e.getMessage());
			BaseClass.errorValidation += "View product details link not found in Quick View for Products on PLP\n";
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_QuickView_Details");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void PLP_Verify_AddToWishlist_RegisteredUser(int iTestCaseRow) throws Exception {
		Log.info("Verification for Add to Wishlist link on Product Image on PLP page");

		try {
			Utils.verifyElement(ProductListing_Page.AddToWishList());
			ProductListing_Page.AddToWishList().click();
			Thread.sleep(3000);
			ProductListing_Page.RemoveFromWishList().click();
			Log.info("Clciked on Add to wishlist link on Product image on PLP page");
			/*
			 * Utils.verifyElement(ProductListing_Page.FirstProductImage());
			 * ProductListing_Page.AddToWishList().click();
			 */

		} catch (Exception e) {
			Log.error(e.getMessage());
			BaseClass.errorValidation += "Add to Wishlist link not present on Product image on PLP\n";
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_AddToWishlist_RegisteredUser");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void PLP_Verify_AddToWishlist_RemoveFromWishList_WuickView_RegUser(int iTestCaseRow)
			throws Exception {
		Log.info("Verification for Add to Wishlist link on Product Image on PLP page");

		try {
			String itemCount = "0";

			Thread.sleep(1000);
			//if (!ProductListing_Page.AlreadyInWishList()) {
				System.out.println("scsc");
				Utils.verifyElement(ProductListing_Page.AddToWishListinpdp());
				Utils.jsClick(ProductListing_Page.AddToWishListinpdp());
				Thread.sleep(4000);
				Utils.refresh();

				if (itemCount.equals(Home_Page.headerWishlistUserMenu().getText())) {
					BaseClass.errorValidation += "WishList count doesnot increase on adding item to wishList";
				}

				/*
				 * Utils.mouseHover(ProductListing_Page.product());
				 * ProductListing_Page.ProductQuickViewTag().click();
				 */
				Thread.sleep(3000);
				Utils.jsClick(ProductListing_Page.RemoveFromWishList());
				Thread.sleep(1000);
				Utils.refresh();
				Thread.sleep(3000);
				if (!((Home_Page.headerWishlistUserMenu().getText().equals(itemCount)
						|| Home_Page.headerWishlistUserMenu().getText().isEmpty()))) {
					BaseClass.errorValidation += "WishList count doesnot decrease on removing item from wishList";
				}
				Log.info("Clicked on Add to wishlist link on Product image on PLP page");

				// ProductListing_Page.RemoveFromWishListQuickView().click();
				/*
				 * Utils.verifyElement(ProductListing_Page.FirstProductImage());
				 * ProductListing_Page.AddToWishList().click();
				 */
//			} else {
//				Log.info("Product is already added to wishlist");
//				System.out.println("Product is already added to wishlist");
//				Utils.jsClick(ProductListing_Page.RemoveFromWishList());
//				Thread.sleep(1000);
//				Utils.refresh();
//				Thread.sleep(3000);
//				if (!itemCount.equals(Home_Page.headerWishlistUserMenu().getText())) {
//					BaseClass.errorValidation += "WishList count doesnot decrease on removing item from wishList";
//				}
//			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			//BaseClass.errorValidation += "Add to Wishlist link not present on Product image on PLP\n";
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_AddToWishlist_RegisteredUser");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void Add_To_Cart_From_Wishlist() {
		try {
			if (!ProductListing_Page.AlreadyInWishList()) {
				Utils.verifyElement(ProductListing_Page.AddToWishList());
				Thread.sleep(1000);
				ProductListing_Page.AddToWishList().click();
				Thread.sleep(4000);
				Utils.refresh();
				Home_Page.headerWishlistIcon().click();
				Thread.sleep(1000);
				Utils.jsClick(Static_Page.MoveToBag());
				Thread.sleep(2000);
				PDP_Action.product_selectSize(Static_Page.size_variant_buttonlist_WishlistPage());
				Utils.jsClick(Static_Page.DoneBtn());
				Thread.sleep(4000);
			} else {
				Log.info("Product is already added to wishlist");
				System.out.println("Product is already added to wishlist");
				Home_Page.headerWishlistIcon().click();
				Thread.sleep(1000);
				Utils.jsClick(Static_Page.MoveToBag());
				Thread.sleep(2000);
				PDP_Action.product_selectSize(Static_Page.size_variant_buttonlist_WishlistPage());
				Utils.jsClick(Static_Page.DoneBtn());
				Thread.sleep(4000);
			}
			if (!ProductDetails_Page.GlobalMsg().getText().contains("Product added to bag successfully")) {
				BaseClass.errorValidation += "Success message is not displayed after adding a product to bag from wishlist";
			}
		} catch (Exception e) {
			Log.error("Exception in adding product from wishlist to Cart | Method Add_To_Cart_From_Wishlist ");
		}
	}

	public static void PLP_Verify_ShowMoreShowLess_Links(int iTestCaseRow) throws Exception {
		Log.info("Verification for ShowMoreShowLess links For product on PLP page");

		try {
			ProductListing_Page.SelectBrandCheckbox(ExcelUtils.getCellData(iTestCaseRow, Constant.brandName))
					.sendKeys(Keys.SPACE);
			Utils.verifyElement(ProductListing_Page.ShowMoreLink());
			ProductListing_Page.ShowMoreLink().click();
			Thread.sleep(5000);
			Log.info("Clciked on ShowMore link on Product image on PLP page");
			Utils.verifyElement(ProductListing_Page.ShowLessLink());
			ProductListing_Page.ShowLessLink().click();
			Log.info("Clciked on ShowLess link on Product image on PLP page");
			Thread.sleep(2000);

		} catch (Exception e) {
			Log.error(e.getMessage());
			BaseClass.errorValidation += "ShowMoreShowLess links not present on PLP\n";
		}

		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_ShowMoreShowLess_Links");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void PLP_Verify_ShowMoreShowLess_Functionlaity(int iTestCaseRow) throws Exception {
		boolean check;
		try {
			ProductListing_Page.SelectBrandCheckbox(ExcelUtils.getCellData(iTestCaseRow, Constant.brandName))
					.sendKeys(Keys.SPACE);
			check = Utils.CheckEnability(ProductListing_Page.ShowMoreLinkContent());
			if (!check) {
				BaseClass.errorValidation += "Show More link not present on PLP while it should be present \n";
			}

			ProductListing_Page.SelectBrandCheckbox(ExcelUtils.getCellData(iTestCaseRow, Constant.productPrice))
					.sendKeys(Keys.SPACE);
			Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.browser));
			// check = Utils.CheckEnability(ProductListing_Page.ShowMoreLinkContent());
			if (check) {
				BaseClass.errorValidation += "Show More link present on PLP while it should not be present \n";
			}

			System.out.println("Show More Show Less link not present when double L3 category selected");
			Log.info("Verification for Show More Show Less Functionality completed on PLP page");

		} catch (Exception e) {
			Log.error(e.getMessage());
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_ShowMoreShowLess_Functionlaity");
			throw e;
		}

	}

	public static void PLP_Verify_RemoveFromWishlist_RegisteredUser(int iTestCaseRow) throws Exception {
		Log.info("Verification for Registered user links in QuickView on PLP page");

		try {
			Utils.scrollingToPageElementByCordinate(1205, 600);
			Log.info("Scrolled to Add to wishlist link in Quick View on PLP page");
			ProductListing_Page.QuickViewDetails.QuickViewAddToWishlist().click();
			Log.info("Clciked on Add to wishlist link in Quick View on PLP page");
			Utils.verifyElement(ProductListing_Page.QuickViewClose());
			ProductListing_Page.QuickViewClose().click();
			Log.info("Clciked on Close link in Quick View on PLP page");

			Utils.scrollingToPageElementByCordinate(462, 380);
			Log.info("Scrolled to first Product image on PLP page");
			Utils.mouseHover(ProductListing_Page.FirstProductImage());
			Log.info("Hovering on first Product image on PLP page");
			ProductListing_Page.ProductQuickViewTag().click();
			Log.info("Clciked on Quick View tag on product image on PLP page");

			Utils.scrollingToPageElementByCordinate(1205, 600);
			Log.info("Scrolled to Add to wishlist link in Quick View on PLP page");
			Utils.verifyElement(ProductListing_Page.QuickViewDetails.QuickViewRemoveFromWishlist());
			ProductListing_Page.QuickViewDetails.QuickViewRemoveFromWishlist().click();
			Log.info("Clciked on Remove to wishlist link in Quick View on PLP page");

		} catch (Exception e) {
			Log.error(e.getMessage());
			BaseClass.errorValidation += "Remove From Wishlist link present in Quick View for Products on PLP\n";
		}
		try {
			Utils.verifyElement(ProductListing_Page.QuickViewClose());
			ProductListing_Page.QuickViewClose().click();
		} catch (Exception e) {
			Log.error(e.getMessage());
			BaseClass.errorValidation += "Close Quick View link present in Quick View for Products on PLP\n";
		}
		if (!BaseClass.errorValidation.isEmpty()) {
			Log.error("Exception in Class PLP_Action | Method PLP_Verify_AddToWishlist_RegisteredUser");
			throw new Exception(BaseClass.errorValidation);
		}
	}

	public static void verifyBreadCrumb() throws Exception {
		try {
			Log.info("verifiying breadcrumb element on plp page");
			Thread.sleep(3000);
			List<WebElement> opt = ProductListing_Page.breadcrumb();
			System.out.println("<<<<<<<<<<<<<<<<<<<Links Present in Breadcrumb are >>>>>>>>>>>>>>>" + "\n");
			for (WebElement e : opt) {
				System.out.println(e.getText());

			}
			Log.info("verification of breadcrumb is completed on the plp page");
			System.out.println("\n"
					+ " <<<<<<<<<<<<<<<<<<<<<<<<<<<<verification of breadcrumb links are  complted on PLP  page>>>>>>>>>>>>>>>>>");

		} catch (Exception e) {
			Log.error("Exception in Class PLP_Action | Method verifyBreadCrumb");
			throw e;
		}

	}
}

