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

import appModules.Login_App;
import appModules.PIP_Action;
import pageObjects.BaseClass;
import pageObjects.Home_Page;
import pageObjects.Personal_Info_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.JyperionListener;
import utility.Log;
import utility.Utils;

@Listeners(JyperionListener.class)
public class SS_ProfilePage_Change_Password_Verify_Fields_and_Buttons {

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
		try 
		{
			try {
				Home_Page.cookie_Popup().click();
			}
			catch(Exception e)
			{
				Log.error("Cookie Popup not found");
			}
			WebDriverWait wait= new WebDriverWait(Driver, 10);
			Utils.waitForElementPresence(Home_Page.LoginRegister());
			Login_App.execute(iTestCaseRow);
			Utils.waitForPageLoad();
			Thread.sleep(5000);
			Utils.mouseHover(Home_Page.LoginRegister());
			Home_Page.profileLink().click();
			wait.until(ExpectedConditions.titleContains("Personal Information | Shoppers Stop"));
			Utils.waitForElementPresence(Personal_Info_Page.change_Password_link());
			PIP_Action.verify_Change_Password_Fields_and_Buttons(iTestCaseRow);
			if(BaseClass.errorValidation.isEmpty())
			{
				ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.result);
				Utils.captureScreenshot(sTestCaseName, "Pass", "Passed");
			}
			
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
