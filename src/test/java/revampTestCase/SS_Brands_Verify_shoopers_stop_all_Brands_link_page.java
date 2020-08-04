package revampTestCase;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//import appModules.Login_App;
import pageObjects.BaseClass;
import pageObjects.Brands_page;
//import pageObjects.Home_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.JyperionListener;
import utility.Log;
import utility.Utils;

@Listeners(JyperionListener.class)
public class SS_Brands_Verify_shoopers_stop_all_Brands_link_page {

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
	public void verifyShopperStopBrands() throws Throwable {
		System.out.println("Starting Test Case:  " + sTestCaseName);
		try {
			Brands_page.verifyAllBrands();
			Log.info("All brands are verified");

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		try {
			Brands_page.verifyBrandsOfCeleb_Brands();
			Log.info("All brands are verified");

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		try {
			Brands_page.verifyBrandsOfFeatured_Brands();
			Log.info("All brands are verified");

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		try {
			Brands_page.verifyBrandsOfJust_Launched_Brands();
			Log.info("All brands are verified");

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		try {
			Brands_page.verifyBrandsOfStopperStop();
			Log.info("All brands are verified");

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		try {
			Brands_page.verifyBrandsOfTrending_Brands();
			Log.info("All brands are verified");

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		try {
			Brands_page.verifyBrandsOfLuxury_Brands();
			Log.info("All brands are verified");

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	
	}

	@AfterMethod
	public void afterMethod() {

		Log.endTestCase(sTestCaseName);
		Driver.quit();
	}
}
