package revampTestCase;

import java.util.List;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import appModules.Login_App;
import pageObjects.BaseClass;
import pageObjects.Checkout_Page;
import pageObjects.Home_Page;
import pageObjects.LogIn_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;


public class Parallel_execution {
	public WebDriver Driver;
	private  String sTestCaseName;
	private  int iTestCaseRow;
	
	
	public void config() throws Exception{
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
	
	    public  void executSession(String Username) throws Exception{
		
	            //First session of WebDriver
		
	            //Goto guru99 site
	          //  Driver.get("https://test4.shopper-stop.in/");
	            Thread.sleep(5000);
	            Home_Page.Alert().click();
	            Utils.waitForPageLoadLongTime();
	            try {
	    				Thread.sleep(15000);
	    				Utils.mouseHover(Home_Page.LoginRegister());
	    				Utils.jsClick(Home_Page.SignIn());
	    				Utils.waitForPageLoadLongTime();
	    				Log.info("Sign in button is clicked");
	    				Thread.sleep(2000);
	    				Log.info("Row number containing the test case: " + iTestCaseRow);
	    				
	    				LogIn_Page.User_Id().sendKeys(Username);
	    				Log.info(Username + " is entered in user id field");

	    				String sPassword = ExcelUtils.getCellData(iTestCaseRow, Constant.password);
	    				LogIn_Page.User_Pwd().sendKeys(sPassword);
	    				Log.info(sPassword + " is entered in user password field");

	    				LogIn_Page.submit_bt().click();
	    				Log.info("Submit button is clicked");
	    				Thread.sleep(2000);
	    				Utils.waitForPageLoadLongTime();
	    				Utils.waitForInvisibityOfElement(LogIn_Page.login_page());
	    				System.out.println(" Login into application succefully ");
	    			
	    				Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.browser));
	    				Log.info("Login successfull");
	    				//Login_App.execute(iTestCaseRow,emailId);
	    				Utils.waitForPageLoadLongTime();
	    				Thread.sleep(5000);
	    				Utils.removeAllItemFromCart();
	    				Utils.waitForPageLoadLongTime();
	    				Utils.HappyPathFlowTillCheckOutPage(iTestCaseRow);
	    				Utils.waitForPageLoadLongTime();
	    				
	    				Utils.waitForElementTOclick(Checkout_Page.Paymentinfo
	    						.ProceedToPaymentButton());
	    				Utils.waitForPageLoadLongTime();
	    				Thread.sleep(15000);
	    				Utils.jsClick(Checkout_Page.codTab());				
	    				Utils.waitForPageLoadLongTime();
	    				Thread.sleep(5000);
	    				//need to uncomment after otp flag off/ text validation off
//	    				Checkout_Page.placeOrderBtn().click();
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
	    				
	    		}
	            
	        
	  catch (Exception e) {
			
			Log.error(e.getMessage());

			throw (e);
		}
	 }
}
