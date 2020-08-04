package revampTestCase;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import appModules.HomePage_Action;
import pageObjects.BaseClass;
import pageObjects.Home_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.JyperionListener;
import utility.Log;
import utility.Utils;

@Listeners(JyperionListener.class)
public class SS_Footer_CopyrightsAllRightsReserved_The_Text_Is_Present 
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
	public void copyRights() throws Exception 
	{
		try {
		try {
			Home_Page.cookie_Popup().click();
		}
		catch(Exception e)
		{
			Log.error("Cookie Popup not found");
		}
		Utils.scrollingToPageElement(Home_Page.Footer_AllRightsReserved());
		Thread.sleep(3000);
		Utils.highLight(Home_Page.Footer_AllRightsReserved());
		HomePage_Action.verify_AllRightsReserved_Text_Present(iTestCaseRow);
		Log.info("AllRightsReserved Text found on Home Page");
		System.out.println("AllRightsReserved Text found on Home Page");
		if(BaseClass.errorValidation.isEmpty())
		{
			ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.result);
			Utils.captureScreenshot(sTestCaseName, "Pass", "Passed");
		}
		}
		catch(Exception e)
		{
			System.out.println("Exception caught Here");
			Log.error(e.getMessage());
			System.out.println(e.getMessage());
			BaseClass.tcFailReasons=BaseClass.tcFailReasons.append(sTestCaseName + ":-" +"<b>e</b><br>" + "\n");
			BaseClass.failedTC=BaseClass.failedTC+1;
			ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.result);
			Utils.captureScreenshot(sTestCaseName, "Fail", "Failed");
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
