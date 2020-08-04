package revampTestCase;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import appModules.Cart_Action;
import appModules.CheckOut_Action;
import appModules.Login_App;
import pageObjects.BaseClass;
import pageObjects.Cart_Page;
import pageObjects.Checkout_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.JyperionListener;
import utility.Log;
import utility.Utils;

/*
 *  Description->This Testcase Verifies whether the Store selected in Cart page  
 *               is populated correctly in Address page and verifying all the 
 *               Static elements [selfPickup_Label,someOnePickup_Label,changeStoreLink--etc]
 *               are displayed in Address page.
 *               
 */


@Listeners(JyperionListener.class)
public class SS_CartPage_Public_Verify_StoreSelected_From_PDP_To_CheckoutPage {
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
			Login_App.executeWithValidation(iTestCaseRow);			
			Utils.waitForPageLoadLongTime();
			Thread.sleep(5000);
			Utils.removeAllItemFromCart();
			Utils.waitForPageLoadLongTime();
			Thread.sleep(5000);
			Cart_Action.verifying_PincodePopulated_From_PDP_TO_CartPage(iTestCaseRow);
			Cart_Action.verify_SelectedStore_INcartPage_Displayed_In_CheckoutPage(iTestCaseRow);
			CheckOut_Action.verify_StaticElementsDisplayed_IN_AddressPage(iTestCaseRow);			
			BaseClass.passedTC=BaseClass.passedTC+1;
		}		
	 catch (Exception e) {
		    BaseClass.tcFailReasons=BaseClass.tcFailReasons.append(sTestCaseName + ":-" +e + "\n");
	    	BaseClass.failedTC=BaseClass.failedTC+1;
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