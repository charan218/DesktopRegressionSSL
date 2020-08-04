package revampTestCase;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import appModules.HomePage_Action;
import appModules.PLP_Action;
import pageObjects.BaseClass;
import utility.Constant;
import utility.ExcelUtils;
import utility.JyperionListener;
import utility.Log;
import utility.Utils;

/**
 * 
 * <h2 style="text-align:center;">SS_PLP_Verify_LoadMore_Link_Functionality</h2>
 * <p style="font-size:19px"><b>Description -</b>This Test case verifies the load more link functionality in product listing page </p>
 * <TABLE width="100%" border="1">
 * <caption style="font-size:17px">List of columns used from excel file</caption>
 * <tr><th>Parameters</th><th>Description</th></tr>
 * <tr><td>browser</td><td>Browser name in which test execution starts</td></tr>
 * </table>
 * <br>
 * <br>
 * 
 */@Listeners(JyperionListener.class)
public class SS_PLP_Verify_LoadMore_Link_Functionality {

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
				System.out.println("strated verifiy the Load more link on plp page");
				HomePage_Action.searchForTheProduct(iTestCaseRow);
				PLP_Action.PLP_Verify_LoadMore_Link_Functionality(iTestCaseRow);
				System.out.println("LoadMore_Link link is verified  and it is working ");
				Utils.captureScreenshot(sTestCaseName, "Pass", "Passed");
				ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.result);
				BaseClass.passedTC = BaseClass.passedTC + 1;

			} catch (Exception e) {
				BaseClass.tcFailReasons=BaseClass.tcFailReasons.append(sTestCaseName + ":-" +e + "\n");
				BaseClass.failedTC=BaseClass.failedTC+1;
				Log.info(
						"Verification LoadMore_Link  - Public View failed");
				ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.result);
				Utils.captureScreenshot(sTestCaseName, "Fail", "Failed");
				Log.error(e.getMessage());
				throw e;
			}
		}

		@AfterMethod
		public void afterMethod() {

			Log.endTestCase(sTestCaseName);
			Driver.quit();
		}
	
	

}
