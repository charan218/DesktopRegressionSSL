package revampTestCase;

import javax.mail.internet.InternetAddress;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.BaseClass;
import utility.Constant;
import utility.ExcelUtils;
import utility.JyperionListener;
import utility.Log;
import utility.PDFReport;
import utility.Utils;

@Listeners(JyperionListener.class)
public class EmailTrigger {
		@Test
		public void emailTrigger() throws Exception {
			try {
				Log.info("Email Trigger is going to excute");
				System.out.println("Email Trigger is going to excute");
				} catch (Exception e) {
				Log.error(e.getMessage());
				Log.error("Email Trigger Failed");
				System.out.println("Email Trigger Failed");
				throw e;
			}
		}
		@AfterSuite
		public void tearDown() throws Exception {
			PDFReport.sendPDFReportByGMail(Utils.ReadProperties(Constant.Path_ConfigProperties).getProperty("from"),
					Utils.ReadProperties(Constant.Path_ConfigProperties).getProperty("password"),
					InternetAddress.parse(Utils.ReadProperties(Constant.Path_ConfigProperties).getProperty("to")),
					Utils.ReadProperties(Constant.Path_ConfigProperties).getProperty("subject"), "");
		}
	}

