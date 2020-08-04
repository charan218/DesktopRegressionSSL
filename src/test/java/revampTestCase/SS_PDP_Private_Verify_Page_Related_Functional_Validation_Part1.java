package revampTestCase;

import org.testng.annotations.Test;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pageObjects.BaseClass;
import pageObjects.Home_Page;
import pageObjects.ProductListing_Page;
import appModules.HomePage_Action;
import appModules.Login_App;
import appModules.PDP_Action;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;


/**
 * 
 * <h2 style="text-align:center;">SS_PDP_Public_Verify_Page_Related_Functional_Validation_Part1</h2>
 * <p style="font-size:19px"><b>Description -</b>This Test Case verifies product details on PDP</p>
 * <TABLE width="100%" border="1">
 * <caption style="font-size:17px">List of columns used from excel file</caption>
 * <tr><th>Parameters</th><th>Description</th></tr>
 * <tr><td>browser</td><td>Browser name in which test execution starts</td></tr>
 * <tr><td>productCategory</td><td>Product Main Category(e.g. MEN, WOMEN etc)</td></tr>
 * <tr><td>productSubCategory</td><td>Product Sub Category(e.g. T-shirt, Watches etc)</td></tr> 
 * </table>
 * <br>
 * <br>
 * 
 */
public class SS_PDP_Private_Verify_Page_Related_Functional_Validation_Part1 {
		public WebDriver Driver;
		private String sTestCaseName;
		private int iTestCaseRow;


		@BeforeMethod
		public void BeforeMethod() throws Exception {
			DOMConfigurator.configure("log4j.xml");
			sTestCaseName = Utils.getTestCaseName(this.toString());
			Log.info("Test case to be executed: " + sTestCaseName);
			ExcelUtils.setExcelFile(Utils.ReadProperties(Constant.Path_ConfigProperties).getProperty("Path_TestData")
					+ Constant.File_TestData, "Sheet1");
			iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName, Constant.testCaseName);

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
				System.out.println("Starting Test Case:  " + sTestCaseName);
				Login_App.execute(iTestCaseRow);
				Thread.sleep(5000);
				Log.info("Login for registered user successfull");
				Utils.removeAllItemFromCart();
				Thread.sleep(5000);
				HomePage_Action.selectProductCategoryfromSearch(iTestCaseRow);
				Thread.sleep(6000);
				Log.info("Product icon is clicked");
				PDP_Action.Product_VerifyDetails();
				Log.info("Product details verified successfully");
				ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.result);
				Utils.captureScreenshot(sTestCaseName, "Pass", "Passed");
				BaseClass.passedTC=BaseClass.passedTC+1;

			} catch (Exception e) {
				BaseClass.tcFailReasons=BaseClass.tcFailReasons.append(sTestCaseName + ":-" +e + "\n");
				BaseClass.failedTC=BaseClass.failedTC+1;
				Log.error("Issue in verifying product details on PDP");
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

