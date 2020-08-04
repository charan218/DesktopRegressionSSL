package revampTestCase;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.BaseClass;
import pageObjects.Home_Page;
import pageObjects.ProductDetails_Page;
import pageObjects.ProductListing_Page;
import pageObjects.Static_Page;
import appModules.HomePage_Action;
import appModules.Login_App;
import appModules.PDP_Action;
import appModules.PLP_Action;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;
import utility.JyperionListener;


/**
 * 
 * <h2 style="text-align:center;">SS_PLP_Verify_AddtoWishList_RegisteredUser</h2>
 * <p style="font-size:19px"><b>Description -</b>This Test Case verifies adding product to wishlist from PLP for a registered user.</p>
 * <TABLE width="100%" border="1">
 * <caption style="font-size:17px">List of columns used from excel file</caption>
 * <tr><th>Parameters</th><th>Description</th></tr>
 * <tr><td>browser</td><td>Browser name in which test execution starts</td></tr>
 * <tr><td>emailId</td><td>User email Id</td></tr>
 *<tr><td>password</td><td>Use password</td></tr> 
 *<tr><td>productCategory</td><td>Product category available on main menu</td></tr>
 *<tr><td>productSubCategory</td><td>Product sub category available under the main menu</td></tr>
 * </table>
 * <br>
 * <br>
 * 
 */ 
@Listeners(JyperionListener.class)
public class SS_PLP_Verify_Reg_User_Add_Remove_Wishlist {

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
			Utils.removeAllItemFromWishList();
			HomePage_Action.selectProductCategoryfromMenu(iTestCaseRow);
			Thread.sleep(5000);
			Log.info("Login for registered user successfull");
			Utils.jsClick(ProductListing_Page.secondproduct());
			Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.browser));
			/*There is a requirement change and Quick View Functionality has been removed.
			 * Changed by s55144 (Rahul Tiwari)
			 * Utils.mouseHover(ProductListing_Page.product());
			ProductListing_Page.ProductQuickViewTag().click();*/
			Log.info("Mouse hovered to first product image");
			PLP_Action.PLP_Verify_AddToWishlist_RemoveFromWishList_WuickView_RegUser(iTestCaseRow);		
			PLP_Action.Add_To_Cart_From_Wishlist();		
		    
			Log.info("Verification for Add to Wishlist link on Product Image on PLP page successfull");
			ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.result);
			BaseClass.passedTC=BaseClass.passedTC+1;

		} catch (Exception e) {
			BaseClass.tcFailReasons=BaseClass.tcFailReasons.append(sTestCaseName + ":-" +e + "\n");
			BaseClass.failedTC=BaseClass.failedTC+1;
			Log.info("Verification for Add to Wishlist link on Product Image on PLP page failed");
			ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.result);
			Utils.captureScreenshot(sTestCaseName, "Fail ", "Failed");
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
