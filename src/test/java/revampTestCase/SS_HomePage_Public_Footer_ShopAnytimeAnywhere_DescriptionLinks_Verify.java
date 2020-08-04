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
/**
 * The following class covers the scenarios like
 * Verify the all links working or not in the footer section of "Shoppersstop.com: Shop Anytime, Anywhere!"
 * @author samba
 *
 */

public class SS_HomePage_Public_Footer_ShopAnytimeAnywhere_DescriptionLinks_Verify {
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
			try {
				Home_Page.cookie_Popup().click();
			}
			catch(Exception e)
			{
				Log.error("Cookie Popup not found");
			}
			System.out.println("Starting Test Case :  --" + sTestCaseName);
			Log.info("wait for page load for footerShopAnytimeAnywhereTxt");
			Utils.waitForElementPresence(Home_Page.footerShopAnytimeAnywhereTxt());
			Log.info("Scroll down to footer section for footerShopAnytimeAnywhereTxt");
			Utils.scrollingToPageBottom(Home_Page.footerShopAnytimeAnywhereTxt());
			Log.info("highlight all footer links of footerShopAnytimeAnywhereTxt");
			Utils.HighlightAllElementOneByOneWithoutDisplay(Home_Page.footerDescriptionLinks());
			Log.info("Click one by one link and verify pagetitle of all");
			HomePage_Action.verifyLinksOnFooter(Home_Page.footerDescriptionLinks());
			ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.result);
			BaseClass.passedTC=BaseClass.passedTC+1;
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
