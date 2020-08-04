package revampTestCase;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.BaseClass;
import pageObjects.Cart_Page;
import pageObjects.Home_Page;
import pageObjects.MiniCart_Page;
import pageObjects.ProductDetails_Page;
import pageObjects.ProductListing_Page;
import appModules.Cart_Action;
import appModules.HomePage_Action;
import appModules.Login_App;
import appModules.PDP_Action;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;
import utility.JyperionListener;

/**
 * 
 * <h2 style=
 * "text-align:center;">SS_CartPage_Private_Verify_CartPage_MoveToWishlist_Functionality</h2>
 * <p style="font-size:19px">
 * <b>Description -</b>This Test Case verifies Move to Wishlist functionality on
 * the Cart page for a registered user.
 * </p>
 * <TABLE width="100%" border="1">
 * <caption style="font-size:17px">List of columns used from excel
 * file</caption>
 * <tr>
 * <th>Parameters</th>
 * <th>Description</th>
 * </tr>
 * <tr>
 * <td>browser</td>
 * <td>Browser name in which test execution starts</td>
 * </tr>
 * <tr>
 * <td>emailId</td>
 * <td>User email Id</td>
 * </tr>
 * <tr>
 * 
 * <td>password</td>
 * <td>Use password</td>
 * </tr>
 * <tr>
 * <td>productCategory</td>
 * <td>Product category available on main menu</td>
 * </tr>
 * <tr>
 * <td>productSubCategory</td>
 * <td>Product sub category available under the main menu</td>
 * </tr>
 * </table>
 * <br>
 * <br>
 * 
 */
@Listeners(JyperionListener.class)
public class SS_CartPage_Private_Verify_CartPage_MoveToWishlist_Functionality {

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
		Log.info(sTestCaseName + " Test case to be executed");

		ExcelUtils.setExcelFile(Utils.ReadProperties(Constant.Path_ConfigProperties).getProperty("Path_TestData")
				+ Constant.File_TestData, "Sheet1");
		iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName, Constant.testCaseName);

		Log.info("New driver instantiated " + iTestCaseRow);
		Log.startTestCase(sTestCaseName);
		Driver = Utils.OpenBrowser(iTestCaseRow);
		new BaseClass(Driver);
	}

	@Test
	public void main() throws Exception {
		try {
			Home_Page.cookie_Popup().click();
			Login_App.execute(iTestCaseRow);
			Utils.waitForPageLoadLongTime();
			Thread.sleep(5000);
			Log.info("Log in successfull for Registered user");
			Utils.removeAllItemFromCart();
			Utils.waitForPageLoadLongTime();
			Thread.sleep(5000);
			Utils.removeAllItemFromWishList();
			Utils.waitForPageLoad();
			Thread.sleep(5000);
			HomePage_Action.selectProductCategoryfromMenu(iTestCaseRow);
			Log.info("Product selected from Main Menu on header");
			Utils.waitForPageLoadLongTime();
			Thread.sleep(5000);
			Utils.jsClick(ProductListing_Page.product());
			System.out.println("product clicked");
			Log.info("Product clicked on PLP");
			Utils.waitForPageLoadLongTime();  
			Thread.sleep(4000);
			PDP_Action.product_selectSize(ProductDetails_Page.Product.size_variant_buttonlist());
			System.out.println("size selected");
			Thread.sleep(2000);
			Utils.waitForElementTOclick(ProductDetails_Page.Product.Product_AddToCart());
			System.out.println("add to cart clicked");
			Log.info("Product added to cart on PDP");
			Utils.waitForPageLoadLongTime();
			Utils.waitForElementTOclick(Cart_Page.cartIcon());
			Utils.waitForPageLoadLongTime();
			System.out.println("cart clicked");
			Thread.sleep(2000);
			Cart_Action.Verify_Private_Cart_Page_MoveToWishlist(iTestCaseRow);
			ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.result);
			Log.info("Verification for moving product to wishlist on cart page successfull");
			Utils.captureScreenshot(sTestCaseName, "Pass", "Cart Page Move To Wishlist for Registered User");
			BaseClass.passedTC = BaseClass.passedTC + 1;
		} catch (Exception e) {
			BaseClass.tcFailReasons = BaseClass.tcFailReasons.append(sTestCaseName + ":-" + e + "\n");
			BaseClass.failedTC = BaseClass.failedTC + 1;
			Log.info("Verification for moving product to wishlist on cart page failed");
			ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.result);
			Utils.captureScreenshot(sTestCaseName, "Fail", "Failed");
			Log.error(e.getMessage());
			throw e;
		}
	}

	@AfterMethod
	public void afterMethod() {

		Log.endTestCase(sTestCaseName);
		Driver.quit();

	}

}
