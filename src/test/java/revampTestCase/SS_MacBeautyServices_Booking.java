package revampTestCase;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pageObjects.BaseClass;
import pageObjects.Home_Page;
import pageObjects.Static_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;
import appModules.HomePage_Action;

public class SS_MacBeautyServices_Booking {

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
		Log.info(sTestCaseName + " Test case to be excuted");
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
			Home_Page.cookie_Popup().click();
			System.out.println("Starting Test Case :  --" + sTestCaseName);
			HomePage_Action.selectProductCategoryfromMenu(iTestCaseRow);
			String pagetittle=Utils.getPageTitle();
			String ActualPageTittle=ExcelUtils.getCellData(iTestCaseRow,Constant.title);
			System.out.println(pagetittle);
			System.out.println(ActualPageTittle);
			if(!pagetittle.equals(ActualPageTittle)){
				System.out.println("Page displayed is not correct");
			}
			Utils.jsClick(Static_Page.macServicesBookNowBtn());
			Static_Page.StoreLocator_SelectCity().selectByValue(ExcelUtils.getCellData(iTestCaseRow, Constant.city));
			Log.info("Store City name entered successfully");

			Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow,Constant.browser));
			Select storeName=Static_Page.StoreLocator_SelectStore();
			storeName.selectByIndex(1);
			if(storeName.getOptions().isEmpty()){
				BaseClass.errorValidation+="The store name list is empty for selcted city\n";
			}
			Log.info("Verification check done for store locator page functionality");
			System.out.println("Validating presence of Address on store locator page");
			Thread.sleep(1000);
			Utils.CheckEnability(Static_Page.StoreLocator_StoreAddress());
			Static_Page.personalShopperContinuewBtn().click();
			Utils.waitForElementPresence(Static_Page.personalShopperSubmitBtn());
			Utils.verifyElement(Static_Page.personalShopperSubmitBtn());
		} catch (Exception e) {
			BaseClass.tcFailReasons=BaseClass.tcFailReasons.append(sTestCaseName + ":-" +e + "\n");
			BaseClass.failedTC=BaseClass.failedTC+1;
			Log.error(BaseClass.errorValidation);
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
