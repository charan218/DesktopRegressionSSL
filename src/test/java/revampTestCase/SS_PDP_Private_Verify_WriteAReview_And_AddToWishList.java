package revampTestCase;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.BaseClass;
import pageObjects.Home_Page;
import pageObjects.MyAccount_Page;
import pageObjects.ProductDetails_Page;
import pageObjects.ProductListing_Page;
import appModules.HomePage_Action;
import appModules.Login_App;
import appModules.PDP_Action;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;

/**
 * 
 * <h2 style="text-align:center;">SS_PDP_Verify_AddToWishList_RegisteredUser</h2>
 * <p style="font-size:19px"><b>Description -</b>This Test Case verifies Add to Wishlist functionality for registered user</p>
 * <TABLE width="100%" border="1">
 * <caption style="font-size:17px">List of columns used from excel file</caption>
 * <tr><th>Parameters</th><th>Description</th></tr>
 * <tr><td>browser</td><td>Browser name in which test execution starts</td></tr>
 * <tr><td>emailId</td><td>Email id of the registered user</td></tr>
 * <tr><td>password</td><td>Password for the registered user</td></tr> 
 * <tr><td>productCategory</td><td>Product Main Category(e.g. MEN, WOMEN etc)</td></tr>
 * <tr><td>productSubCategory</td><td>Product Sub Category(e.g. T-shirt, Watches etc)</td></tr> 
 * </table>
 * <br>
 * <br>
 * 
 */ 


public class SS_PDP_Private_Verify_WriteAReview_And_AddToWishList {

	public WebDriver Driver;
	private String sTestCaseName;
	private int iTestCaseRow;


	@BeforeMethod
	public void BeforeMethod() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		sTestCaseName = Utils.getTestCaseName(this.toString());
		Log.info("Test case to be executed: " + sTestCaseName);
		ExcelUtils.setExcelFile(Utils.ReadProperties(Constant.Path_ConfigProperties).getProperty("Path_TestData")
				+ Constant.File_TestData, "Sheet1");
		iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName, Constant.testCaseName);
		System.out.println(iTestCaseRow);
		Log.startTestCase(sTestCaseName);
		Driver = Utils.OpenBrowser(iTestCaseRow);
		new BaseClass(Driver);
	}

	@Test
	public void main() throws Exception {
		try {
			try {
				Home_Page.cookie_Popup().click();
			}
			catch(Exception e)
			{
				Log.error("Cookie Popup not found");
			}
			Login_App.execute(iTestCaseRow);
			Utils.removeAllItemFromWishList();
			Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.browser));
			HomePage_Action.selectProductCategoryfromMenu(iTestCaseRow);
			Log.info("Product icon is clicked");
			Utils.jsClick(ProductListing_Page.product());
			Log.info("Second Item clicked on PLP");
			System.out.println("Second Item clicked on PLP");
			Thread.sleep(3000);
//			if(Constant.URL!="https://www.shoppersstop.com/"){
				System.out.println("True");
				PDP_Action.Write_A_Review(iTestCaseRow);
//			}
			
			PDP_Action.Reg_User_AddToWishList_ValidateSocialShare_Icon();
			PDP_Action.Reg_User_Add_Remove_From_Wishlist(iTestCaseRow);
//			if(! BaseClass.errorValidation.isEmpty()){
//				throw new Exception(BaseClass.errorValidation);
//			}
			BaseClass.passedTC=BaseClass.passedTC+1;

		} catch (Exception e) {
			BaseClass.tcFailReasons=BaseClass.tcFailReasons.append(sTestCaseName + ":-" +e + "\n");
			BaseClass.failedTC=BaseClass.failedTC+1;
			Log.error("Issue in verifying Add to wishlist functionality on PDP for registered user");
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
