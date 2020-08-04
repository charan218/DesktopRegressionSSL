package revampTestCase;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import appModules.HomePage_Action;
import appModules.PDP_Action;
import pageObjects.BaseClass;
import pageObjects.Home_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.JyperionListener;
import utility.Log;
import utility.Utils;


/*
 * Description->This Testcase verifies ExpressStorepickup,cod and Standard delivery 
 *               options in PDP page by selecting only pincode without size
 *               and selecting size without pincode. Validate by Selecting both Size
 *               and pincode with Valid and Invalid pincode(Pincode for which express
 *               StorePickup is not available).
 *               
 */


@Listeners(JyperionListener.class)
public class SS_PdpPage_Private_Verify_ExpressStorePickup_DeliveryOptions {

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
		System.out.println(iTestCaseRow);
		Log.info("New driver instantiated " + iTestCaseRow);
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
			System.out.println("Starting Test Case : " + sTestCaseName);
			HomePage_Action.selectProductCategoryfromSearch(iTestCaseRow);
			PDP_Action.verify_Del_And_pickupSec_selectingSize_And_without_Pincode(iTestCaseRow);
			PDP_Action.verify_Del_And_pickupSec_WithoutSelectingSize_And_with_Pincode(iTestCaseRow);
			PDP_Action.verify_Del_And_pickupSec_selectingSize_And_Pincode(iTestCaseRow);
			Thread.sleep(2000);
			PDP_Action.verify_Del_And_pickupSec_with_InValidPincode(iTestCaseRow);			
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