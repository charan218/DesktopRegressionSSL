package revampTestCase;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.BaseClass;
import pageObjects.Cart_Page;
import pageObjects.Checkout_Page;
import pageObjects.Home_Page;
import pageObjects.MiniCart_Page;
import pageObjects.MyAccount_Page;
import pageObjects.ProductDetails_Page;
import pageObjects.ProductListing_Page;
import pageObjects.Checkout_Page.LoginDetails;
import appModules.CheckOut_Action;
import appModules.HomePage_Action;
import appModules.PDP_Action;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.PDFReport;
import utility.Utils;


/**
 * 
 * <h2 style="text-align:center;">SS_CheckOut_RegisterAtCheckout_VerifyDefaultAddressAddition</h2>
 * <p style="font-size:19px"><b>Description -</b>This Test Case verifies if the customer has created the account from the checkout flow, then the delivery address entered during the
 * checkout flow is added to the Address book as default address
 * </p>
 * <TABLE width="100%" border="1">
 * <caption style="font-size:17px">List of columns used from excel
 * file</caption>
 * <tr>
 * <th>Parameters</th>
 * <th>Description</th>
 * </tr>
 * <tr>
 * <td>browser</td>
 * <td>Browser name in which test execution starts</td>
 * </tr>
 * <tr>
 * <td>emailId</td>
 * <td>Email id of the new user</td>
 * </tr>
 * <tr>
 * <td>password</td>
 * <td>Password for the new user</td>
 * </tr>
 * <tr>
 * <td>alternativeFirstName</td>
 * <td>First Name of the new user</td>
 * </tr>
 * <tr>
 * <td>alternativeLastName</td>
 * <td>Last Name of the new user</td>
 * </tr>
 * <tr>
 * <td>confirmPassword</td>
 * <td>Confirm password</td>
 * </tr>
 * <tr>
 * <td>alternativeMobile</td>
 * <td>Mobile number</td>
 * </tr>
 * <tr>
 * <td>gender</td>
 * <td>Gender of the new user</td>
 * </tr>
 * <tr>
 * <td>productCategory</td>
 * <td>Product Main Category(e.g. MEN, WOMEN etc)</td>
 * </tr>
 * <tr>
 * <td>productSubCategory</td>
 * <td>Product Sub Category(e.g. T-shirt, Watches etc)</td>
 * </tr>
 * <tr>
 * <td>firstName</td>
 * <td>First Name for the delivery address</td>
 * </tr>
 * <tr>
 * <td>lastName</td>
 * <td>Last Name for the delivery address</td>
 * </tr>
 * <tr>
 * <td>postCode</td>
 * <td>Postal code for the delivery address</td>
 * </tr>
 * <tr>
 * <td>address</td>
 * <td>Address field for the delivery</td>
 * </tr>
 * <tr>
 * <td>landmark</td>
 * <td>Address2 field for the delivery</td>
 * </tr>
 * <tr>
 * <td>mobileNumber</td>
 * <td>Phone for the delivery address</td>
 * </tr>
 * </table>
 * <br>
 * <br>
 * 
 * 
 */

public class SS_CheckOut_RegisterAtCheckout_And_Validate_Default_Address_Addition {

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
		System.out.println(sTestCaseName);
		Log.startTestCase(sTestCaseName);
		Driver = Utils.OpenBrowser(iTestCaseRow);
		new BaseClass(Driver);
	}

	@Test
	public void main() throws Exception {
		try {
			Home_Page.cookie_Popup().click();
			CheckOut_Action.HappyPathFlowTillCartPage(iTestCaseRow);
			Thread.sleep(3000);
			Cart_Page.CheckoutButton().click();
			Thread.sleep(3000);
			Utils.waitForPageLoadLongTime();
			CheckOut_Action.RegisterAtCheckout(iTestCaseRow);
			Utils.waitForElementPresence2(LoginDetails.singuoOtp());
			if (LoginDetails.singuoOtp().isDisplayed()) {
				
				if(Checkout_Page.contiuesignup().isDisplayed()) {
					Utils.waitForPageLoadLongTime();
					CheckOut_Action.ProceedwithNewAddress(iTestCaseRow);
					Utils.NavigateToURL(Constant.URL);
					Log.info("Shoppers stop logo is clicked from the checkout page");

					Utils.mouseHover(Home_Page.LoginRegister());
					Home_Page.profileLink().click();
					Utils.waitForElementTOclick(MyAccount_Page.ProfilePage.PersonalInfoText());
					MyAccount_Page.ProfilePage.Addresses().click();

					if (MyAccount_Page.ProfilePage.DefaultShippingAddresstext().size() == 1) {

						ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.result);
						Utils.captureScreenshot(sTestCaseName, "Pass", "Passed");
						Log.info("Address added at checkout is set as default shipping addre" + "ss");

					} else {

						throw new Exception("No address is set as default shipping address");
					}
					BaseClass.passedTC = BaseClass.passedTC + 1;
				}
			}else {
				System.out.println(" otp is required to sign in");
			}
			
		} catch (Exception e) {
			BaseClass.tcFailReasons = BaseClass.tcFailReasons.append(sTestCaseName + ":-" + e + "\n");
			BaseClass.failedTC = BaseClass.failedTC + 1;
			Log.error("Issue in setting default shipping address");
			ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.result);

			Utils.captureScreenshot(sTestCaseName, "Fail", "Failure");

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