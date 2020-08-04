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
import appModules.PDP_Action;
import pageObjects.BaseClass;
import pageObjects.Cart_Page;
import pageObjects.Home_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.JyperionListener;
import utility.Log;
import utility.Utils;


/*
 * Description->This TestCase verifies ExpressStorepickup,cod and Standard delivery 
 *              options in Cart page before and after Entering PinCode with Valid 
 *              and Invalid Pin codes PinCode for which expressStorePickup is not available)
 *   
 */


@Listeners(JyperionListener.class)
public class SS_CartPage_Public_verify_Default_StorePickup_Functionality {

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
			Home_Page.cookie_Popup().click();
			Utils.removeAllItemFromCart();
			Utils.waitForPageLoadLongTime();
			Thread.sleep(5000);
			HomePage_Action.HappyPathFlowTillCartPage_WithoutEnteringPincode(iTestCaseRow);
			Cart_Action.verify_StorePickup_BeforeEnteringPincode(iTestCaseRow);
			Cart_Action.verify_StorePickup_AfterEntering_Invalid_AND_Valid_Pincode(iTestCaseRow);
			Cart_Action.verify_Deli_Sec_AfterEntering_Pincode_CartPage(iTestCaseRow);
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
		Driver.close();
}	
	
}