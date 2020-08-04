package revampTestCase;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import appModules.Footer_Action;
import appModules.HomePage_Action;
import pageObjects.BaseClass;
import pageObjects.Home_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.JyperionListener;
import utility.Log;
import utility.Utils;

@Listeners(JyperionListener.class)
public class SS_Footer_Firstcitizen_Verify_All_Links_Are_Clickable 
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
	public void FirstCitizen() throws Exception
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
			HomePage_Action.click_HomePage_FirstCitizen_Link(iTestCaseRow);
//			HomePage_Action.verifyFirstCitizenRelatedLinks();
			WebDriverWait wait=  new WebDriverWait(Driver, 10);
			wait.until(ExpectedConditions.titleContains("First Citizen Non Member | Shoppers Stop"));
//			Utils.driverNavigation("backward");
			System.out.println(Utils.getPageTitle());
//			wait.until(ExpectedConditions.titleContains("Online Shopping India"));
			Utils.waitForPageLoad();
			Thread.sleep(3000);
//			Utils.waitForElementPresence(Home_Page.get_TermsAndCondions_Link());
//			HomePage_Action.click_HomePage_TermsAndConditions_Link(iTestCaseRow);
//			Utils.NewWindowAction();
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
