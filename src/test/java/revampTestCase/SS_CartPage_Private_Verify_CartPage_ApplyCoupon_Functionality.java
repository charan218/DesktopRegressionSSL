package revampTestCase;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
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
import utility.PDFReport;
import utility.Utils;
import utility.JyperionListener;

/**
 * 
 * <h2 style=
 * "text-align:center;">SS_CartPage_Private_Verify_CartPage_ApplyCoupon_Functionality</h2>
 * <p style="font-size:19px">
 * <b>Description -</b>This Test Case verifies Apply Coupan field on the Cart
 * page for a registered user.
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
 * <tr>
 * <td>promoCode</td>
 * <td>Promotional coupon code to be applied</td>
 * </tr>
 * <tr>
 * <td>invalidPromoCode</td>
 * <td>Invalid Promotional coupon code to be applied for validation purpose</td>
 * </tr>
 * </table>
 * <br>
 * <br>
 * 
 * 
 */
@Listeners(JyperionListener.class)
public class SS_CartPage_Private_Verify_CartPage_ApplyCoupon_Functionality {

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
			Utils.removeAllItemFromCart();
			Log.info("Log in successfull for Registered user");
			HomePage_Action.selectProductCategoryfromMenu(iTestCaseRow);
			Log.info("Product selected from Main Menu on header");
			Utils.waitForPageLoadLongTime();
			Utils.waitForElementTOclick(ProductListing_Page.secondproduct());
			System.out.println("product clicked");
			Utils.waitForPageLoadLongTime();
			Thread.sleep(2000);
			PDP_Action.product_selectSize(ProductDetails_Page.Product.size_variant_buttonlist());
			Utils.waitForPageLoadLongTime();
			Thread.sleep(10000);
			ProductDetails_Page.Product.Product_AddToCart().click();
			Log.info("Product added to cart on PDP");
			System.out.println("Added to cart");
			Utils.waitForPageLoadLongTime();
			Utils.waitForElementTOclick(Cart_Page.cartIcon());
			Cart_Action.Verify_Private_Cart_Page_ApplyCoupan(iTestCaseRow);
			ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.result);
			Log.info("Verification for Applying Coupon on cart page successfull");
			Utils.captureScreenshot(sTestCaseName, "Pass", "Apply Coupan Screenshot");
			BaseClass.passedTC = BaseClass.passedTC + 1;

		} catch (Exception e) {
			BaseClass.tcFailReasons = BaseClass.tcFailReasons.append(sTestCaseName + ":-" + e + "\n");
			Log.info("Verification for Applying Coupon on cart page failed");
			ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.result);
			Utils.captureScreenshot(sTestCaseName, "Fail", "Failed");
			Log.error(e.getMessage());
			BaseClass.failedTC = BaseClass.failedTC + 1;
			throw e;
		}
	}

	@AfterMethod
	public void afterMethod() {

		Log.endTestCase(sTestCaseName);
		Driver.quit();

	}

}
