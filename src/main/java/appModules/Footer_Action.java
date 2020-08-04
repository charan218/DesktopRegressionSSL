package appModules;

import java.util.List;

import org.openqa.selenium.WebElement;

import pageObjects.Footer_Page;
import pageObjects.Home_Page;
import utility.Log;
import utility.Utils;

public class Footer_Action {
	public static String sTAGNAME;

	public static void FooterLinkVerification_Customer_Public(int iTestCaseRow) throws Exception {

		try {
			Home_Page.Footer_Section.Help_FAQ().click();
			Utils.PageHeaderCheck(" FAQ | Shoppers Stop");

			Home_Page.Footer_Section.Track_Order().click();
			Utils.PageHeaderCheck(" Shoppers Stop");

			Home_Page.Footer_Section.Size_Guide().click();
			;
			Utils.PageHeaderCheck(" Size Guide | Shoppers Stop");

			Home_Page.Footer_Section.Buying_Guide().click();
			;
			Utils.PageHeaderCheck(" BuyingGuide | Shoppers Stop");

			Home_Page.Footer_Section.How_To_Buy().click();
			;
			Utils.PageHeaderCheck(" Purchase | Shoppers Stop");

			Home_Page.Footer_Section.How_To_Pay().click();
			Utils.PageHeaderCheck(" How do I pay Template | Shoppers Stop");

			Home_Page.Footer_Section.Place_We_Deliever().click();
			Utils.PageHeaderCheck(" Shoppers Stop");

			// Home_Page.Footer_Section.Blog().click();
			// Utils.PageHeaderCheck("SHOPPERSSTOP | START SOMETHING NEW");

			Log.info("Verification check has been completed for FooterLinks- Public View");

		} catch (Exception e) {

			Log.info("Verification check Failed  for Footer Links- Public View");

			throw (e);

		}

	}

	public static void FooterLinkVerification_Private(int iTestCaseRow) throws Exception {

		try {

			Home_Page.Footer_Section.Help_FAQ().click();
			Utils.PageHeaderCheck(" FAQ | Shoppers Stop");

			Home_Page.Footer_Section.Track_Order().click();
			Utils.PageHeaderCheck(" Shoppers Stop");

			Home_Page.Footer_Section.Size_Guide().click();
			;
			Utils.PageHeaderCheck(" Size Guide | Shoppers Stop");

			Home_Page.Footer_Section.Buying_Guide().click();
			;
			Utils.PageHeaderCheck(" BuyingGuide | Shoppers Stop");

			Home_Page.Footer_Section.How_To_Buy().click();
			;
			Utils.PageHeaderCheck(" Purchase | Shoppers Stop");

			Home_Page.Footer_Section.How_To_Pay().click();
			Utils.PageHeaderCheck(" How do I pay Template | Shoppers Stop");

			Home_Page.Footer_Section.Place_We_Deliever().click();
			Utils.PageHeaderCheck(" Shoppers Stop");

			// Home_Page.Footer_Section.Blog().click();
			// Utils.PageHeaderCheck("SHOPPERSSTOP | START SOMETHING NEW");

			Log.info("Verification check has been completed for FooterLinks- Public View");

		} catch (Exception e) {

			Log.info("Verification check Failed  for Footer Links- Private View");

			throw (e);

		}

	}

	public static void verfiyExpressStore() throws Exception {
		try {
			Utils.scrollingToPageBottom(Footer_Page.expressStorepick());
			Utils.jsClick(Footer_Page.expressStorepick());
			Log.info("express store link is cliked");
			System.out.println("express stoer link is clicked");
			Log.info("Locating FAQ link");
			Utils.scrollingToPageBottom(Footer_Page.FAQ());
			Log.info("FAQ element  link is located");
			System.out.println("Getting all the FAQ ");
			Log.info("getting all FAQ ");
			List<WebElement> FAQ = Footer_Page.ListOfFAQ();
			Log.info("Got all the FAQ ");
			System.out.println("<<<<<<<<<<<<<<And The FAQ's Are>>>>>>>>>>>>>>>>>");
			System.out.println();
			int NUmber = 1;
			for (WebElement q : FAQ) {
				System.out.println(NUmber+") "+ q.getText() + "\n");
				NUmber++;
			}

		} catch (Exception e) {
			Log.error("express store element is not clicled");
			Log.error("error in in calss Footer_action | method verfiyExpressStore");
			throw e;

		}

	}
}
