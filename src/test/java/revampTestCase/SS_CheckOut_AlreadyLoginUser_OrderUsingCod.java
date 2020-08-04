package revampTestCase;

import java.util.List;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pageObjects.BaseClass;
import pageObjects.Checkout_Page;
import pageObjects.Home_Page;
import pageObjects.LogIn_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;
import appModules.CheckOut_Action;
import appModules.Login_App;

import org.testng.annotations.Test;

public class SS_CheckOut_AlreadyLoginUser_OrderUsingCod {

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
			List<String> emailAddress = Utils.csvDataReader(ExcelUtils
					.getCellData(iTestCaseRow, Constant.emailId));
			try {
				Utils.waitForPageLoadLongTime();
				Home_Page.cookie_Popup().click();
			} catch (Exception e) {
			}
			for (int i = 0; i < emailAddress.size(); i++) {
				System.out.println("count=" + i);
				Thread.sleep(5000);
				Login_App.execute(iTestCaseRow);
				Utils.waitForPageLoadLongTime();
				Thread.sleep(5000);
				Utils.removeAllItemFromCart();
				Utils.waitForPageLoadLongTime();
				Utils.HappyPathFlowTillCheckOutPageForCOD(iTestCaseRow);
				Utils.waitForPageLoadLongTime();
				Thread.sleep(5000);
				Utils.waitForElementTOclick(Checkout_Page.Paymentinfo
						.ProceedToPaymentButton());
				Utils.waitForPageLoadLongTime();
				Thread.sleep(6000);
				Utils.jsClick(Checkout_Page.codTab());				
				Utils.waitForPageLoadLongTime();
				Thread.sleep(5000);
				//need to uncomment after otp flag off/ text validation off
//				Checkout_Page.placeOrderBtn().click();
				System.out.println("order placed");
				Utils.waitForPageLoadLongTime();
				Thread.sleep(5000);
				try {
					Driver.findElement(By.xpath("//a[contains(.,'Skip & Close')]"))
					.click();
				} catch (Exception e) {
					Log.info("No feedback came");
					System.out.println("No feedback came");
				}	
				/*
				 * Utils.waitForPageLoadLongTime();
				
				Utils.mouseHover(Home_Page.LoginRegister());
				Thread.sleep(5000);
				Utils.jsClick(Home_Page.Logout());
				Thread.sleep(1000);
				Utils.NavigateToURL(Constant.URL); */
		}
			ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.result);
			Utils.captureScreenshot(sTestCaseName, "Pass", "Passed");
			Log.info("Payment successfull using Netbanking");
			BaseClass.passedTC = BaseClass.passedTC + 1;

		} catch (Exception e) {
			BaseClass.tcFailReasons = BaseClass.tcFailReasons
					.append(sTestCaseName + ":-" + e + "\n");
			BaseClass.failedTC = BaseClass.failedTC + 1;
			Log.error("Issue in making payment using Netbanking");
			ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.result);

			Utils.captureScreenshot(sTestCaseName, "Fail", "Failure");

			Log.error(e.getMessage());

			throw (e);
		}
	}

	@AfterMethod
	public void afterMethod() {

		Log.endTestCase(sTestCaseName);
		//Driver.close();
		Driver.quit();

	}

}
