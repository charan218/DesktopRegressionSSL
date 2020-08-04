package appModules;

import pageObjects.Order_Summary;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;

public class OrderSummary_Action {
	private static String orderID;
	public static void Verify_And_Get_Order_Details(int iTestCaseRow) throws Exception{
		Utils.verifyElement(Order_Summary.OrderConfirmation());
		Utils.verifyElement(Order_Summary.OrderID());
		System.out.println(Order_Summary.OrderID().getText());
		orderID=Order_Summary.OrderID().getText();
		ExcelUtils.setCellData(orderID, iTestCaseRow, Constant.orderID);
	}
	
	public static void Verify_billingAddress(int iTestCaseRow) throws Exception{
	try{	
		String billingAddress=Order_Summary.billingAddress().getText();
		if(billingAddress.contains(ExcelUtils.getCellData(iTestCaseRow, Constant.postCode)))
		{
			Log.info("Billing address saved is correct");
		}
		else
		{
			throw new Exception("Billing address displayed is not correct");
		}
	
	}catch(Exception e){
		Log.error("Billing address not displayed");
		throw e;
	}
	}	
	
	
}
