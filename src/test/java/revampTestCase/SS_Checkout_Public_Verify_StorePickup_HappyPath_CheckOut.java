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
import pageObjects.BaseClass;
import pageObjects.Checkout_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.JyperionListener;
import utility.Log;
import utility.Utils;

/*  Description->This Testcase Verifies the store selection in Address page and adding 
 *               new address without selecting in Cart page. Navigate to Payment page   
 *               and verifying whether COD delivery option is displayed or not for express 
 *               storePickup orders.
 *               COD delivery option should not be displayed for express storePickup orders. 
 *  
 */

@Listeners(JyperionListener.class)
public class SS_Checkout_Public_Verify_StorePickup_HappyPath_CheckOut {
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
			Cart_Action.verifying_PincodePopulated_From_PDP_TO_CheckoutPage(iTestCaseRow);	
			if(Checkout_Page.GuestOTPPopup().isDisplayed()){
				System.out.println("Otp is required to continue");
			}
			else{
				System.out.println("coming");
			Utils.jsClick(Checkout_Page.expressStorePickupTab());
			System.out.println("expressStorePickupTab is clicked");
			Thread.sleep(5000);

			String checkoutPincode = Checkout_Page.pincodeDisplay().getAttribute("innerText");
			if (checkoutPincode.equals(ExcelUtils.getCellData(iTestCaseRow, Constant.postCode))) {
				Log.info("Pincode correctly populated from the cart page");
				System.out.println("Pincode correctly populated from the cart page");
			} else {
				throw new Exception("Pincode not populated correctly");
			}
			CheckOut_Action.storeSelection_IN_AddressPage(iTestCaseRow);
			BaseClass.passedTC=BaseClass.passedTC+1;
			}	
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