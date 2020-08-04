package revampTestCase;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.BaseClass;
import pageObjects.ProductListing_Page;
import appModules.Cart_Action;
import appModules.HomePage_Action;
import appModules.Login_App;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;
import utility.JyperionListener;

/**
 * 
 * <h2 style="text-align:center;">SS_CartPage_Public_Verify_ShopingCart_ItemCount</h2>
 * <p style="font-size:19px"><b>Description -</b>This Test Case verifies Shopping bag item count for a guest user.</p>
 * <TABLE width="100%" border="1">
 * <caption style="font-size:17px">List of columns used from excel file</caption>
 * <tr><th>Parameters</th><th>Description</th></tr>
 * <tr><td>browser</td><td>Browser name in which test execution starts</td></tr>
 * <tr><td>productCategory</td><td>Product category available on main menu</td></tr>
 * <tr><td>productSubCategory</td><td>Product sub category available under the main menu</td></tr>
 * </table>
 * <br>
 * <br>
 * 
 */ 
@Listeners(JyperionListener.class)
public class SS_CartPage_Public_Verify_UpdateCart_GiftMessage_DeliveryPincode_RemoveCartItem_Functionality {

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
			System.out.println("Starting Test Case : " + sTestCaseName);
			//Login_App.execute(iTestCaseRow);
			Utils.removeAllItemFromCart();
			Utils.waitForPageLoadLongTime();
			Thread.sleep(5000);
			try{
				Utils.HappyPathFlowTillCartPage(iTestCaseRow);
			}catch(Exception e){
				BaseClass.errorValidation+="Navigation till Cart Page Failed";
			}
			try{
				Cart_Action.Verify_Public_Edit_Cart_Page(iTestCaseRow);
			}catch(Exception e){
				BaseClass.errorValidation+="Unable to Edit Cart Page Failed";
			}
			try{
				Cart_Action.Send_Personalized_Message(iTestCaseRow);
			}catch(Exception e){
				BaseClass.errorValidation+="Unable to send Paersonalized message";
			}
		   /* Cart_Action.Check_NavigationTo_Checkout_GuestUser(iTestCaseRow);
			Utils.driverNavigation("backward");*/
			try{
				Cart_Action.Verify_Private_Cart_Page_RemoveProduct(iTestCaseRow);
			}catch(Exception e){
				BaseClass.errorValidation+="Unable to remove product from Cart";
			}	
			if (!BaseClass.errorValidation.isEmpty()) {
				Log.error("Exception in Class Cart_Action ");
				throw new Exception(BaseClass.errorValidation);
			}
			ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.result);
			Log.info("Verification for product count in mini cart for guest user successfull");
			Utils.captureScreenshot(sTestCaseName, "Pass", "Verify item count for guest user Screenshot");
			 BaseClass.passedTC=BaseClass.passedTC+1;
		} catch (Exception e) {
			 BaseClass.failedTC=BaseClass.failedTC+1;
			Log.info("Verification for product count in mini cart for guest user failed");
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
