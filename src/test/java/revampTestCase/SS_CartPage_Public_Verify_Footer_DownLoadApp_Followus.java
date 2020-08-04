package revampTestCase;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import appModules.Cart_Action;
import appModules.HomePage_Action;
import appModules.Login_App;
import appModules.PDP_Action;
import pageObjects.BaseClass;
import pageObjects.Cart_Page;
import pageObjects.Home_Page;
import pageObjects.MiniCart_Page;
import pageObjects.ProductDetails_Page;
import pageObjects.ProductListing_Page;
import pageObjects.Registration_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.JyperionListener;
import utility.Log;
import utility.Utils;

/**
 * The following class cover the footer section verification like Follow us
 * links, Down Load App links working or not on cart page
 * 
 * @author samba
 *
 */
@Listeners(JyperionListener.class)
public class SS_CartPage_Public_Verify_Footer_DownLoadApp_Followus {

	public WebDriver Driver;
	private String sTestCaseName;
	private int iTestCaseRow;

	@BeforeSuite
	public void setSnapShotFolder() throws Exception {
		Utils.setSnapshotFolder();

	}
	

	@BeforeMethod
	public void BeforeMethod() throws Exception {
		DOMConfigurator.configure("log4j.xml");

		sTestCaseName = Utils.getTestCaseName(this.toString());
		Log.info("Test case to be executed: " + sTestCaseName);
		ExcelUtils.setExcelFile(Utils.ReadProperties(Constant.Path_ConfigProperties).getProperty("Path_TestData")
				+ Constant.File_TestData, "Sheet1");
		iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName, Constant.testCaseName);
		Log.startTestCase(sTestCaseName);
		Driver = Utils.OpenBrowser(iTestCaseRow);
		new BaseClass(Driver);
	}

	@Test
	public void main() throws Exception {
		try {
			Home_Page.cookie_Popup().click();
			System.out.println("Starting Test Case : " + sTestCaseName);
			HomePage_Action.selectProductCategoryfromMenu(iTestCaseRow);
			Log.info("Product selected from Main Menu on header");
			Utils.waitForPageLoadLongTime();
			Thread.sleep(5000);
			Utils.jsClick(ProductListing_Page.secondproduct());
			System.out.println("Product c");
			Log.info("Product selected successfully");
			Utils.waitForPageLoadLongTime();
			Thread.sleep(5000);
			PDP_Action.product_selectSize(ProductDetails_Page.Product.size_variant_buttonlist());
			System.out.println("size selected");
			Thread.sleep(8000);
			Utils.waitForElementTOclick(ProductDetails_Page.Product.Product_AddToCart());
			Log.info("Add to cart button is clicked");
			Utils.waitForPageLoadLongTime();
			Utils.waitForElementTOclick(Cart_Page.cartIcon());
			Utils.waitForPageLoadLongTime();
		} catch (Exception e) {
			BaseClass.errorValidation += "Unable to navigate to cart page \n";
		}
		try {
			Thread.sleep(5000);
			Log.info("Going to click on App Store Icon");
			MiniCart_Page.appStoreIcon().click();
			Log.info("Going to Verify App Store opening or not");
			Utils.NewWindowActionURLValidateWithURL("https://itunes.apple.com/");

			Log.info("Going to click on googlePay Icon");
			MiniCart_Page.googlePlayIcon().click();
			Log.info("Going to Verify googlePay page opening or not");
			Utils.NewWindowActionURLValidateWithURL("https://play.google.com/");

//			Log.info("Going to click on facebook Icon");
//			MiniCart_Page.facebookIcon().click();
//			Log.info("Going to Verify facebook page opening or not");
//			Utils.NewWindowActionURLValidateWithURL("https://www.facebook.com/");

			Log.info("Going to click on twitter Icon");
			MiniCart_Page.twitterIcon().click();
			Log.info("Going to Verify twitter page opening or not");
			Utils.NewWindowActionURLValidateWithURL("https://twitter.com/");

			/*Log.info("Going to click on pinterest Icon");
			MiniCart_Page.pinterestIcon().click();
			Log.info("Going to Verify pinterest page opening or not");
			Utils.NewWindowActionURLValidateWithURL("https://in.pinterest.com/");*/

			/*Log.info("Going to click on google Plus Icon");
			MiniCart_Page.googlePlusIcon().click();
			Log.info("Going to Verify googlePay page opening or not");
			Utils.NewWindowActionURLValidateWithURL("https://accounts.google.com/");
*/
			Log.info("Going to click on instagram Icon");
			MiniCart_Page.instagramIcon().click();
			Log.info("Going to Verify instagram page opening or not");
			Utils.NewWindowActionURLValidateWithURL("https://www.instagram.com/");
			
			Log.info("Going to click on facebook Icon");
			MiniCart_Page.facebookIcon().click();
			Log.info("Going to Verify facebook page opening or not");
			Utils.NewWindowActionURLValidateWithURL("https://www.facebook.com/");
			
			ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.result);
			BaseClass.passedTC = BaseClass.passedTC + 1;
		} catch (Exception e) {
			BaseClass.tcFailReasons = BaseClass.tcFailReasons.append(sTestCaseName + ":-" + "<b>e</b><br>" + "\n");
			BaseClass.failedTC = BaseClass.failedTC + 1;
			Log.error("Registration process not successful");
			ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.result);
			Utils.captureScreenshot(sTestCaseName, "Fail", "Failed");
			Log.error(e.getMessage());
			throw (e);
		}
	}

	@AfterMethod
	public void afterMethod() {

		Log.endTestCase(sTestCaseName);
		Driver.quit();
	}
}
