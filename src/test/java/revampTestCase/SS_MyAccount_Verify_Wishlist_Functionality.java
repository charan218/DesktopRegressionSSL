package revampTestCase;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import appModules.HomePage_Action;
import appModules.Login_App;
import appModules.MyAccount_Action;
import pageObjects.BaseClass;
import pageObjects.Home_Page;
import pageObjects.MyAccount_Page;
import pageObjects.ProductDetails_Page;
import pageObjects.ProductListing_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.JyperionListener;
import utility.Log;
import utility.Utils;

@Listeners(JyperionListener.class)
public class SS_MyAccount_Verify_Wishlist_Functionality {

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
	public void Profile() throws Exception
	{
		try {
			try {
				Home_Page.cookie_Popup().click();
			}
			catch(Exception e)
			{
				Log.error("Cookie Popup not found");
			}
			Utils.waitForElementPresence(Home_Page.LoginRegister());
			Login_App.execute(iTestCaseRow);
			Utils.removeAllItemFromWishList();
			HomePage_Action.selectProductCategoryfromMenu(iTestCaseRow);
			Utils.waitForPageLoad();
			Thread.sleep(2000);
			ProductListing_Page.product().click();
			Log.info("Product selected from Main Menu on header");
			System.out.println("product clicked");
			Log.info("Product clicked on PLP");
			Utils.waitForPageLoad();
			Thread.sleep(2000);
			Home_Page.wishListicon().click();
			Thread.sleep(3000);
			Utils.mouseHover(Home_Page.LoginRegister());
			Thread.sleep(1000);
			Home_Page.MyAccount().click();
			Thread.sleep(2000);
			Utils.waitForElementPresence2(MyAccount_Page.WishList.wishlist_Link());
			MyAccount_Action.verify_MyAccount_Wishlist_Funtionality();
			
			
		}
		catch(Exception e)
		{
			Log.error("Error occured in profile funtionality");
			System.out.println("Exception captured -> "+e);
			BaseClass.tcFailReasons=BaseClass.tcFailReasons.append(sTestCaseName + ":-" +"<b>e</b><br>" + "\n");
			BaseClass.failedTC=BaseClass.failedTC+1;
			Log.error("Profile verifiation process not successful");
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
