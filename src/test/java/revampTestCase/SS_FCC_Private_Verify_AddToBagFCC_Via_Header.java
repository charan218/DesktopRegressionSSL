package revampTestCase;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import appModules.CheckOut_Action;
import appModules.FCC_Action;
import appModules.Login_App;
import pageObjects.BaseClass;
import pageObjects.Cart_Page;
import pageObjects.Checkout_Page;
import pageObjects.Home_Page;
import pageObjects.MiniCart_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.JyperionListener;
import utility.Log;
import utility.Utils;

@Listeners(JyperionListener.class)
public class SS_FCC_Private_Verify_AddToBagFCC_Via_Header 
{
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
		System.out.println(iTestCaseRow);
		Log.startTestCase(sTestCaseName);
		Driver = Utils.OpenBrowser(iTestCaseRow);
		new BaseClass(Driver);
	}
	
	@Test
	public void discover() throws Exception
	{
		
		try 
		{
			try {
				Home_Page.cookie_Popup().click();
			}
			catch(Exception e)
			{
				Log.error("Cookie Popup not found");
			}
			Log.info("Verification for Buying FCC for registered user via Header started.");
			Thread.sleep(2000);
			Login_App.execute(iTestCaseRow);
			Log.info("Log in successfull for Registered User");
			Thread.sleep(5000);
			Utils.removeAllItemFromCart();
			Thread.sleep(10000);
			Utils.waitForPageLoad();
			FCC_Action.verify_AddToBagFCC_via_Header(iTestCaseRow);
			Log.info("FCC added to cart successfully");
			Thread.sleep(3000);
			Utils.jsClick(MiniCart_Page.MiniCartProductDetails.MiniCartViewBag());
			Log.info("View Bag link clicked successfully");
			Thread.sleep(5000);
			Utils.jsClick(Cart_Page.CheckoutButtonOnCart());
			Log.info("Checkout button on Cart Page clicked successfully");

			Utils.verifyElement(Checkout_Page.TopNavigation.CheckOutText());
			Log.info("User successfully reached to Checkout page");

			CheckOut_Action.ProceedwithNewAddress(iTestCaseRow);
			Utils.verifyElement(Checkout_Page.Paymentinfo.PaymentClass());
			Log.info("Payment information tab is visible");
			
			if(BaseClass.errorValidation.isEmpty())
			{
				ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.result);
				Utils.captureScreenshot(sTestCaseName, "Pass", "Passed");
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception caught Here");
			System.out.println(e.getMessage());
			BaseClass.tcFailReasons=BaseClass.tcFailReasons.append(sTestCaseName + ":-" +"<b>e</b><br>" + "\n");
			BaseClass.failedTC=BaseClass.failedTC+1;
			ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.result);
			Utils.captureScreenshot(sTestCaseName, "Fail", "Failed");
			Log.error(e.getMessage());
			throw (e);
		}
	}
	
	@AfterMethod
	public void afterMethod() 
	{
		Log.endTestCase(sTestCaseName);
		Driver.quit();
	}
}
