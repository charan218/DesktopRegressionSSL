
package appModules;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjects.BaseClass;
import pageObjects.Home_Page;
//import pageObjects.It;
import pageObjects.MyAccount_Page;
import pageObjects.ProductDetails_Page;
//import pageObjects.all;
//import pageObjects.as;
//import pageObjects.be;
//import pageObjects.it;
//import pageObjects.not;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;

// This is called Modularization, when we club series of actions in to one Module

public class PDP_Action extends BaseClass{

	public PDP_Action(WebDriver Driver) {
		super(Driver);
		// TODO Auto-generated constructor stub
	}
	// iTestcaseRow is the row number of our Testcase name in the Test Data
	// sheet

	public static void Product_VerifyDetails() throws Exception {

		try {
			Utils.verifyElement(ProductDetails_Page.Product.Product_Name());
			Log.info("Verification Pass: Product Name found");

		} catch (Exception e) {
			Log.error("Product name is not present");
			BaseClass.errorValidation = BaseClass.errorValidation + "Verification Fail: Product name is not present \n";
		}
		
		/* This functionality has been removed */
//		try{
//			Utils.verifyElement(ProductDetails_Page.Product.Next_Arrow());
//		}
//		catch(Exception ex){
//			BaseClass.errorValidation+="Next Arrow for next Image is not visible on PDP page \n" ;
//		}
		
		try{
			Utils.verifyElement(ProductDetails_Page.Product.Average_Ratings());
		}
		catch(Exception ex){
			BaseClass.errorValidation+="Average_Ratings is not visible on PDP page \n" ;
		}
		
		try{
			Utils.verifyElement(ProductDetails_Page.Product.Recomendations_Count());
		}
		catch(Exception ex){
			BaseClass.errorValidation+="Recomendations_Count is not visible on PDP page \n" ;
		}
		
		try{
			Utils.verifyElement(ProductDetails_Page.Product.SelectSize_Label());
		}
		catch(Exception ex){
			BaseClass.errorValidation+="SelectSize_Label is not visible on PDP page \n" ;
		}
		
		
		/* This functionality has been removed */
//		try{
//			Utils.verifyElement(ProductDetails_Page.Product.Similarproduct_Wishlist());
//			ProductDetails_Page.Product.Similarproduct_Wishlist().click();
//			if (! Home_Page.headerWishlistUserMenu().getSize().equals(0)) {
//				Log.info("Product added to wishlist successfully");
//			}
//			else{
//				Log.error("Product not added to wishlist");
//			}
//		}
//		catch(Exception ex){
//			BaseClass.errorValidation+="Similarproduct_Wishlist is not visible on PDP page \n" ;
//		}
		
		try{
			Utils.verifyElement(ProductDetails_Page.Product.CalculateyourSize_Link());
			ProductDetails_Page.Product.CalculateyourSize_Link().click();
		if(ProductDetails_Page.Product.KnowyourSize_Popup().isDisplayed())
		{
			Log.info("Know your size popup displayed");
			Thread.sleep(1000);
		}
		else{
			Log.error("Know your size popup is not displayed");
			}
		}
		catch(Exception ex){
			BaseClass.errorValidation+="KnowyourSize_Link is not visible on PDP page \n" ;
		}
		
		try {
			Utils.verifyElement(ProductDetails_Page.Product.txt_Price());
			Log.info("Verification Pass: Product Text found");

		} catch (Exception e) {
			Log.error("Product price is not present");
			BaseClass.errorValidation = BaseClass.errorValidation + "Verification Fail: Product price is not present \n";
		}
		
		/*
		 * It is not available for all product it should be configurable as per product
		 */
//		try {
//			Utils.verifyElement(ProductDetails_Page.Product.alterationTag());
//			Log.info("Verification Pass: alterationTag link is found");
//
//		} catch (Exception e) {
//			Log.error("alterationTag  is not present");
//			BaseClass.errorValidation = BaseClass.errorValidation + "Verification Fail: alterationTag  is not present \n";
//		}
		
		/*
		 * Not Required for selected product because for the selected product there is only one color
		 *  Product for more than one color this details is present
		 */
//		try {
//			Utils.verifyElement(ProductDetails_Page.Product.Selecting_Colour());
//			Log.info("Verification Pass: Selecting_Colour dropdown is found");
//			Utils.SelectDropdownUpdated(ProductDetails_Page.Product.Selecting_Colour());
//
//		} catch (Exception e) {
//			Log.error("Selecting_Colour dropdown  is not present");
//			BaseClass.errorValidation = BaseClass.errorValidation + "Verification Fail: Selecting_Colour dropdown  is not present \n";
//		}
		
		try{
			//String productCode = ProductDetails_Page.Product.Product_Code().getText();
			PDP_Action.product_selectColor(ProductDetails_Page.Product.color_variant_buttonlist());
			PDP_Action.product_selectSize(ProductDetails_Page.Product.size_variant_buttonlist());
			ProductDetails_Page.Product.Product_AddToCart().click();
			Log.info("Add to cart button is clicked");
			
//			Utils.verifyElement(MiniCart_Page.MiniCartWindow());
//			Log.info("Mini cart window is displayed");
			
//			MiniCart_Page.removeBtn().click();
//			Log.info("Remove button is clicked on the mini cart");
//			Thread.sleep(1000);
//			if(!PDP_Action.productcode_MatchinMiniCart(MiniCart_Page.MiniCartProductCode(), productCode)){
//				Log.info("Product is removed from the mini cart window");
//			}else{
//				BaseClass.errorValidation+="Product is not removed from Mini Cart Window";
//			}
		}
		catch(Exception ex){
			BaseClass.errorValidation+="Product is not removed from Mini Cart Window";
		}
		
		

		try {
			Utils.verifyElement(ProductDetails_Page.Product.color_variant());
			Log.info("Verification Pass: Product Color Variant found");

		} catch (Exception e) {
			Log.error("Product color is not present");
			BaseClass.errorValidation = BaseClass.errorValidation + "Verification Fail: Product color is not present \n";
		}

		try {
			Utils.verifyElement(ProductDetails_Page.Product.size_variant());
			Log.info("Verification Pass: Product Size Variant found");

		} catch (Exception e) {
			Log.error("Product size variant is not present");
			BaseClass.errorValidation = BaseClass.errorValidation + "Verification Fail: Product size variant is not present \n";
		}

		try {
			Utils.verifyElement(ProductDetails_Page.Product.description_tabs());
			Log.info("Verification Pass: Product Description tabs found");

		} catch (Exception e) {
			Log.error("Product description tabs are not present");
			BaseClass.errorValidation = BaseClass.errorValidation + "Verification Fail: Product description tabs are not present \n";
		}

		try {
			Utils.verifyElement(ProductDetails_Page.Product.description_content());
			Log.info("Verification Pass: Product Description content found");

		} catch (Exception e) {
			Log.error("Product description content are not present");
			BaseClass.errorValidation = BaseClass.errorValidation + "Verification Fail: Product description content are not present \n";
		}
		try{
			if (ProductDetails_Page.breadCrumb().isDisplayed()) {
				Log.info("Breadcrumb is visible");
			}
		}
		catch(Exception e){
			Log.info("BreadCrumb is not visible");
			BaseClass.errorValidation = BaseClass.errorValidation + "Verification Fail: PDP Bread Crumb is not visible \n";
			BaseClass.bResult=false;
		}
		Thread.sleep(2000);
	//Utils.scrollingToPageElement(ProductDetails_Page.shopSimilar());
		try{
			if(ProductDetails_Page.shopSimilar().isDisplayed()){
				Log.info("Shop Similar is visible");
				System.out.println("Shop Similar is visible");
				try{
					Utils.verifyElement(ProductDetails_Page.Product.Similarproduct_AddToCart());
					ProductDetails_Page.Product.Similarproduct_AddToCart().click();
					Utils.verifyElement(ProductDetails_Page.Product.Similarproduct_AddToCart_Popup());
				}
				catch(Exception ex){
					BaseClass.errorValidation+="Similarproduct_AddToCart is not visible on PDP page \n" ;
				}
			}
		}
		catch(Exception e){
			Log.info("Shop Similar is not visible");
			BaseClass.errorValidation = BaseClass.errorValidation + "Verification Fail: Shop Similar is not visible \n";
			BaseClass.bResult=false;
		}
		try{
			if(!(ProductDetails_Page.Product.shopSimilar_product_Price().size()>0))
			{
				BaseClass.errorValidation = BaseClass.errorValidation + "Verification Fail: Shop Similar product price is not visible \n";

			}
			System.out.println("Verification Pass: shopSimilar Product price found");
		}
		catch(Exception e){
			Log.info("Shop Similar product_Priceis not visible");
			BaseClass.errorValidation = BaseClass.errorValidation + "Verification Fail: Shop Similar product_Price is not visible \n";
			BaseClass.bResult=false;
		}
		try{
			if(!(ProductDetails_Page.Product.shopSimilar_product_BrandName().size()>0))
			{
				BaseClass.errorValidation = BaseClass.errorValidation + "Verification Fail: Shop Similar product Brand name is not visible \n";

			}
			System.out.println("Shop Similar product BrandName is visible");
		}
		catch(Exception e){
			Log.info("Shop Similar product BrandName not visible");
			BaseClass.errorValidation = BaseClass.errorValidation + "Verification Fail: Shop Similar product BrandName is not visible \n";
			BaseClass.bResult=false;
		}
		
		try{
			if(!(ProductDetails_Page.Product.shopSimilar_product_img().size()>0))
			{
				BaseClass.errorValidation = BaseClass.errorValidation + "Verification Fail: Shop Similar product image is not visible \n";
	
			}
			System.out.println("Shop Similar product Image is visible");
		}
		catch(Exception e){
			Log.info("Shop Similar product Image not visible");
			BaseClass.errorValidation = BaseClass.errorValidation + "Verification Fail: Shop Similar product image is not visible \n";
			BaseClass.bResult=false;
		}
		
		try{
			if(!(ProductDetails_Page.Product.shopSimilar_product_Name().size()>0))
			{
				BaseClass.errorValidation = BaseClass.errorValidation + "Verification Fail: Shop Similar product name is not visible \n";
			
			}
			System.out.println("Shop Similar product Name is visible");
		}
		catch(Exception e){
			Log.info("Shop Similar product Name not visible");
			BaseClass.errorValidation = BaseClass.errorValidation + "Verification Fail: Shop Similar product Name is not visible \n";
			BaseClass.bResult=false;
		}

		try{
			
			if(ProductDetails_Page.recentlyViewed().isDisplayed());
			{
			System.out.println("recentlyViewed is visible");
			try{
				if(!(ProductDetails_Page.recentlyViewed_img().size()>0));
				{
					BaseClass.errorValidation = BaseClass.errorValidation + "Verification Fail: recentlyViewed product image is not visible \n";

				}
				System.out.println("recentlyViewed image is visible");
			}
			catch(Exception e){
				Log.info("recentlyViewed image is not visible");
				BaseClass.errorValidation = BaseClass.errorValidation + "Verification Fail: recentlyViewed image is not visible \n";
				BaseClass.bResult=false;
			}		
			
			try{
				if(!(ProductDetails_Page.recentlyViewed_productName().size()>0));
				{
					BaseClass.errorValidation = BaseClass.errorValidation + "Verification Fail: recentlyViewed product name is not visible \n";

				}
				System.out.println("recentlyViewed product name is visible");
			}
			catch(Exception e){
				Log.info("recentlyViewed product name is not visible");
				BaseClass.errorValidation = BaseClass.errorValidation + "Verification Fail: recentlyViewed product name is not visible \n";
				BaseClass.bResult=false;
			}
			
			try{
				if(!(ProductDetails_Page.recentlyViewed_brandName().size()>0));
				{
					BaseClass.errorValidation = BaseClass.errorValidation + "Verification Fail: recentlyViewed brand name is not visible \n";

				}
				System.out.println("recentlyViewed brand name is visible");
			}
			catch(Exception e){
				Log.info("recentlyViewed brand name is not visible");
				BaseClass.errorValidation = BaseClass.errorValidation + "Verification Fail: recentlyViewed brand name is not visible \n";
				BaseClass.bResult=false;
			}	

			try{
				if(!(ProductDetails_Page.recentlyViewed_ProductPrice().size()>0));
				{
					BaseClass.errorValidation = BaseClass.errorValidation + "Verification Fail: Recently viewed product price is not visible \n";

				}
				System.out.println("recentlyViewed product price is visible");
			}
			catch(Exception e){
				Log.info("recentlyViewed product price is not visible");
				BaseClass.errorValidation = BaseClass.errorValidation + "Verification Fail: recentlyViewed product price is not visible \n";
				BaseClass.bResult=false;
			}
			
			}
		}
		catch(Exception e){
			Log.info("recentlyViewed is not visible");

		}		
		
		
		
		try{
			Utils.verifyElement(ProductDetails_Page.Product.productPicture());
			Utils.mouseHover(ProductDetails_Page.Product.productPicture());
			Utils.jsClick(ProductDetails_Page.Product.productPicture());
			ProductDetails_Page.Product.ZoomInWindowCloseBtn().click();
			Utils.mouseHover(Home_Page.Footer_Section.Help_FAQ());
			

// Sticky PDP Functionality removed				
//			if (ProductDetails_Page.PersistenceProduct.persistentHeader().isDisplayed()) {
//				Log.info("Persistent Header is displayed");
//
//			} else {
//				Log.error("Persistent Header is not displayed");
//				throw new Exception("Persistent Header is not displayed");
//			}
		}
		catch(Exception ex){
			BaseClass.errorValidation+="Persistent Product feature and product image validation failed";
		}
		
//		if (!BaseClass.errorValidation.equals("")) {
//			Log.error("Exception in Class PDP_Action | Method Product_VerifyDetails");
//			throw (new Exception(BaseClass.errorValidation));
//		}

	}
	public static void PDP_Verify_FirstCitizen_And_Enroll_Link(int iTestCaseRow) throws Exception {
		try {
			Log.info("clicking on firstcitizen link");
			ProductDetails_Page.firstCitizenOnPDP();
			Log.info("clicked on firstcitizen link");
			Utils.waitForPageLoad();
//			System.out.println(ProductDetails_Page.verifyFirstCitizenLink().getAttribute("innerHTML")+" link is displayed");
			System.out.println(" First Citizen link on PDP page is validated");
//			Utils.Driver.close();
			Utils.jsClick(ProductDetails_Page.FirstCitizenLink());
			System.out.println(" first citizen link is naviagting to enroll page");
		} catch (Exception e) {
			Log.error("verification of first citizen link on  PDP Page failed");
			throw new Exception(
					"first citizen  Page Failed || Method PDP_Verify_FirstCitizen_And_Enroll_Link || Class PDP");
		}
	}

	public static void PDP_Verify_size_Guide_And_calculate_Link(int iTestCaseRow) throws Exception {
		try {
			Utils.jsClick(ProductDetails_Page.sizeGuide());
			Log.info("clicked on sizeGuide link");
			System.out.println("size Guide link is clicked and veridied");
			Utils.waitForElementPresence2(ProductDetails_Page.sizeGuidepage());
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+"\n"+ProductDetails_Page.sizeGuidepage().getAttribute("innerHTML")+" is verified");
			Utils.jsClick(ProductDetails_Page.closepopup());
			Utils.waitForPageLoad();
			Thread.sleep(2000);
			Utils.jsClick(ProductDetails_Page.calculatesize());
			System.out.println("calculate  your size is clicked ");
			Log.info("clicked on calculate  link");
			Utils.waitForElementPresence2(ProductDetails_Page.calculatesize());
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+"\n"+ProductDetails_Page.calculatesize().getAttribute("innerHTML")+" is verified");
			
		} catch (Exception e) {
			Log.error("verification of first citizen link on  PDP Page failed");
			throw new Exception(
					"Size and calucalate size  Page Failed || Method PDP_Verify_size_Guide_And_calculate_Link || Class PDP");
		}
	}
	public static void Write_A_Review(int iTestCaseRow) throws Exception{
		ProductDetails_Page.Product.WriteReviewBtn().click();
		Log.info("Write a review button is clicked");
System.out.println("Write a review button is clicked");
Thread.sleep(3000);
//Utils.waitForElementPresence2(ProductDetails_Page.ReviewWindow.ReviewPopUp());
//		if (Utils.CheckEnability(ProductDetails_Page.ReviewWindow.ReviewPopUp())) {
//			Log.info("Review pop up window is displayed");
//		} else {
//			Log.error("Review pop up window is not displayed");
//			throw new Exception("Review pop up window is not displayed");	
//		}

		ProductDetails_Page.ReviewWindow.ReviewStar_4().click();
//		ProductDetails_Page.ReviewWindow.ReviewQuality_VeryGood().click();
		ProductDetails_Page.ReviewWindow.ReviewTitle()
				.sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.reviewTitle));
		ProductDetails_Page.ReviewWindow.ReviewDescription()
				.sendKeys("scription");
		ProductDetails_Page.ReviewWindow.ReviewSubmitBtn().click();
		
		if (!(ProductDetails_Page.GlobalMsg().getText().contains("Thank you for your review."))) {
			BaseClass.errorValidation += "Thank you for your review alert not present on page. \n";
		}
		

	}
	
	public static void Reg_User_Add_Remove_From_Wishlist(int iTestCaseRow)throws Exception{
		try{
			Utils.waitForLoad(ExcelUtils.getCellData(iTestCaseRow, Constant.browser));
			Utils.mouseHover(ProductDetails_Page.Product.AddToWishlistBtn());
			ProductDetails_Page.Product.AddToWishlistBtn().click();
			Log.info("Product added to the wishlist successfully");
			Thread.sleep(2000);
			Utils.verifyElement(Home_Page.headerWishlistIcon());
			Utils.jsClick(Home_Page.headerWishlistIcon());
			Thread.sleep(5000);
			MyAccount_Page.WishList.WishListItemCloseBtn().click();
		}catch(Exception e){
			BaseClass.errorValidation+="Adding a product to wishlist and removing it from wishlist is not working\n";
		}

	}
	public static void PersistentProduct_VerifyDetails() throws Exception {

		try {
			Utils.verifyElement(ProductDetails_Page.PersistenceProduct.productName());
			Log.info("Verification Pass: Product Name found");

		} catch (Exception e) {
			Log.error("Product name is not present");
			BaseClass.errorValidation = BaseClass.errorValidation + "Verification Fail: Product name is not present \n";
		}

		try {
			Utils.verifyElement(ProductDetails_Page.PersistenceProduct.productSize());
			Log.info("Verification Pass: Product Size Variant found");

		} catch (Exception e) {
			Log.error("Product size variant is not present");
			BaseClass.errorValidation = BaseClass.errorValidation + "Verification Fail: Product size variant is not present \n";
		}

		try {
			Utils.verifyElement(ProductDetails_Page.PersistenceProduct.productPicture());
			Log.info("Verification Pass: Product Picture found");

		} catch (Exception e) {
			Log.error("Product Picture is not present");
			BaseClass.errorValidation = BaseClass.errorValidation + "Verification Fail: Product Picture is not present \n";
		}

		try {
			Utils.verifyElement(ProductDetails_Page.PersistenceProduct.productAddToCart());
			Log.info("Verification Pass: Add to cart button is found");

		} catch (Exception e) {
			Log.error("Add to cart button is not present");
			BaseClass.errorValidation = BaseClass.errorValidation + "Verification Fail: Add to cart button is not present \n";
		}

		try {
			Utils.verifyElement(ProductDetails_Page.PersistenceProduct.productQty());
			Log.info("Verification Pass: Product quantity content found");

		} catch (Exception e) {
			Log.error("Product quantity content is not present");
			BaseClass.errorValidation = BaseClass.errorValidation + "Verification Fail: Product quantity content is not present \n";
		}

		if (!BaseClass.errorValidation.equals("")) {
			Log.error("Exception in Class PDP_Action | Method PersistentProduct_VerifyDetails");
			throw (new Exception(BaseClass.errorValidation));
		}

	}

	public static boolean productcode_MatchinMiniCart(List<WebElement> productcodeObjectMiniCart, String productCode)
			throws Exception {
		boolean match = false;
		try {
			if (productcodeObjectMiniCart.size() == 1) {
				if (productcodeObjectMiniCart.get(0).getAttribute("value").equals(productCode)) {
					match = true;
					Log.info("Product code is found in mini cart window");
				}

			} else if (productcodeObjectMiniCart.size() > 1) {
				for (int i = 0; i < productcodeObjectMiniCart.size(); i++) {
					if (productcodeObjectMiniCart.get(i).getAttribute("value").equals(productCode)) {
						match = true;
						Log.info("Product code is found in mini cart window");
					}
				}
			}else{
				Log.info("Product code is not found in mini cart window");
			}

		} catch (Exception e) {
			Log.error("Exception in Class PDP_Action | Method productcode_MatchinMiniCart");
			Log.error("Issue in matching product code in mini cart window");
			throw (e);

		}
		return match;
	}
	public static void checkValid_Invalid_Delivery_Options(int iTestCaseRow)throws Exception{
		Utils.waitForPageLoad();
		ProductDetails_Page.Product.PinCode().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.postCode));
		Log.info("Pin is entered into the text field");
		ProductDetails_Page.Product.PinCodeCheckBtn().click();
		Log.info("Check button is clicked");
		Thread.sleep(2000);
		if (ProductDetails_Page.Product.PinCodeSuccessMsg().isDisplayed()) {
			Log.info("Product can be deliver to this pincode");
		} else {
			Log.error("Product cannot be deliver to this Pincode");
			throw (new Exception("Product cannot be deliver to this Pincode"));
		}
		Thread.sleep(2000);
		ProductDetails_Page.Product.ChangePinBtn().click();
		Log.info("Change pin button is clicked");
		ProductDetails_Page.Product.PinCode().clear();
		Log.info("Previous pin is cleared from the field");
		ProductDetails_Page.Product.PinCode()
				.sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.alternativePostCode));
		Log.info("Pin is entered into the text field");
		ProductDetails_Page.Product.PinCodeCheckBtn().click();
		Log.info("Check button is clicked");
		Thread.sleep(2000);
		//Utils.verifyElement(ProductDetails_Page.Product.InvalidPinCodeMsg());
	}

	public static void Product_Verify_SocialShare() throws Exception {

		
		try {
			Thread.sleep(1500);
			Utils.verifyElement(ProductDetails_Page.Product.Social_TwitterLink());
			Log.info("Verification Pass: Twitter link found");

		} catch (Exception e) {
			Log.error("Twitter link is not present");
			BaseClass.errorValidation = BaseClass.errorValidation + "Verification Fail: Twitter link is not present \n";
		}
		try {
			Thread.sleep(1500);
			Utils.verifyElement(ProductDetails_Page.Product.Social_InstagramLink());
			Log.info("Verification Pass: Social_Instagram Link found");

		} catch (Exception e) {
			Log.error("Social_Instagram Link is not present");
			BaseClass.errorValidation = BaseClass.errorValidation + "Verification Fail: Instagram link is not present \n";
		}

		try {
			Thread.sleep(1500);
			Utils.verifyElement(ProductDetails_Page.Product.Social_FacebookLink());
			Log.info("Verification Pass: Facebook link found");

		} catch (Exception e) {
			Log.error("Facebook link is not present");
			BaseClass.errorValidation = BaseClass.errorValidation + "Verification Fail: Facebook link is not present \n";
		}

//		try {
//			Thread.sleep(1500);
//			Utils.verifyElement(ProductDetails_Page.Product.Social_GooglePlusLink());
//			Log.info("Verification Pass: Google Plus link found");
//
//		} catch (Exception e) {
//			Log.error("Google plus link is not present");
//			BaseClass.errorValidation = BaseClass.errorValidation + "Verification Fail: Google Plus link is not present \n";
//		}

//		try {
//			Thread.sleep(1500);
//			Utils.verifyElement(ProductDetails_Page.Product.Social_PinterestLink());
//			Log.info("Verification Pass: Pinterest link is found");
//
//		} catch (Exception e) {
//			Log.error("Pinterest link is not present");
//			BaseClass.errorValidation = BaseClass.errorValidation + "Verification Fail: Pinterest link is not present \n";
//		}
		
		if (!BaseClass.errorValidation.equals("")) {
			Log.error("Exception in Class PDP_Action | Method Product_Verify_SocialShare");
			throw (new Exception(BaseClass.errorValidation));
		}

	}
	
	public static void product_selectDifferentSize(List<WebElement> productSizeButtonList)
			throws Exception {
		
		try {
			if (productSizeButtonList.size()>0){
				for (int i=0; i<=productSizeButtonList.size()-1;i++){
					
					if (!(productSizeButtonList.get(i).getAttribute("class").contains("grey-background"))){
						productSizeButtonList.get(i+1).click();
						return;
					}
				}
			}

		} catch (Exception e) {
			Log.error("Exception in Class PDP_Action | Method productcode_MatchinMiniCart");
			Log.error("Issue in matching product code in mini cart window");
			throw (e);
		}

		}
	public static void product_selectSize(List<WebElement> productSizeButtonList)
			throws Exception {
		
		try {
			if (productSizeButtonList.size()>0){
				for (int i=0; i<=productSizeButtonList.size()-1;i++){
					
					if (!(productSizeButtonList.get(i).getAttribute("class").contains("grey-background"))){
						
						////////////
						//Utils.highLight(productSizeButtonList.get(i));
						/////////////
						Thread.sleep(4000);
						Utils.jsClick(productSizeButtonList.get(i));
						Log.info("Size selected "+i);
						System.out.println("Size selected "+i);
						break;
					}
				}
			}
			else{
				Log.error("Unable to select size from becuse size is "+productSizeButtonList.size());
				}

		} catch (Exception e) {
			Log.error("Exception in Class PDP_Action | Method productcode_MatchinMiniCart");
			Log.error("Issue in matching product code in mini cart window");
			throw (e);

		}
		
	}
	public static void product_selectColor(List<WebElement> productColorButtonList)
			throws Exception {
		
		try {
			if (productColorButtonList.size()>0){
				for (int i=0; i<=productColorButtonList.size()-1;i++){
					
					if (!(productColorButtonList.get(i).getAttribute("class").contains("grey-background"))){
						productColorButtonList.get(i).click();
						Utils.highLight(productColorButtonList.get(i));
						Thread.sleep(2000);
						return;
					}
				}
			}

		} catch (Exception e) {
			Log.error("Exception in Class PDP_Action | Method productcode_MatchinMiniCart");
			Log.error("Issue in matching product code in mini cart window");
			throw (e);

		}
		
	}
	public static void Reg_User_AddToWishList_ValidateSocialShare_Icon() {
		 String itemCount="0";
		 int count=0;
		try{		
			ProductDetails_Page.Product.SoclialShare().get(0).click();
			Thread.sleep(1000);
		    if(itemCount.equals(Home_Page.headerWishlistUserMenu().getText())){
		    	BaseClass.errorValidation+="WishList Count remain Same on clicking wishlist icon on PDP page";
		    }
		}catch(Exception e){
			Log.error("WishList Count remain Same on clicking wishlist icon on PDP page");
		}
		try{		
			ProductDetails_Page.Product.SoclialShare().get(0).click();
			Thread.sleep(1000);
		    if(!((Home_Page.headerWishlistUserMenu().getText().equals(itemCount))||(Home_Page.headerWishlistUserMenu().getText().isEmpty()) )){
		    	BaseClass.errorValidation+="WishList Count remain Same on clicking wishlist icon on PDP page";
		    }
			
		}catch(Exception e){
			Log.error("");
			BaseClass.errorValidation+="WishList Count remain Same on clicking wishlist icon on PDP page";
		}
		try{
			Utils.jsClick(ProductDetails_Page.Product.SoclialShareIcon().get(0));
			Thread.sleep(1000);
			List<WebElement> list=ProductDetails_Page.Product.ShareProductImageIcon();
			count=list.size();
			if(count==3 || count==9){
				System.out.println("Four Social Sites are present as expected");
			}
			else{
				BaseClass.errorValidation+="number of Social Share Site is neither 4 nor 8 but it is + " + count;
			}
		}catch(Exception e){
			Log.error("number of Social Share Site is not 4 but it is + " +count + "\n");
			
		}
	}

	public static void happyPathFlowTillPDPPage_With_AND_Without_Entering_Pincode(int iTestCaseRow) throws Exception{
		try{
			HomePage_Action.selectProductCategoryfromSearch(iTestCaseRow);
			Log.info("Product selected from Main Menu on header");
			Log.info("Product clicked on PLP");			
			Utils.waitForPageLoadLongTime();
			Thread.sleep(2000);
			Utils.scrollingToPageElementByCordinate(0, 250);
			Utils.waitForPageLoadLongTime();
			if(ProductDetails_Page.pincode_info().isDisplayed())
			{
			  String pincodeInfo=ProductDetails_Page.pincode_info().getAttribute("innerText");
			  Log.info("Default pincode info displayed ="+pincodeInfo);
			}
			PDP_Action.verifying_StorePickup_Section(iTestCaseRow);
			PDP_Action.verifying_Delivery_Section_BeforeEntering_Pincode(iTestCaseRow);
			verify_Del_And_pickupSec_selectingSize_And_Pincode(iTestCaseRow);
					
		}
		catch(Exception e){
			Log.error("Navigation Till PDP Page failed");
			throw e;
		}
	}	
	

	public static void verifying_StorePickup_Section(int iTestCaseRow) throws Exception {
		try{
			Thread.sleep(1000);
			Utils.scrollingToPageElementByCordinate(0, 300);
		String pickupDeliveryMode=ProductDetails_Page.ExpressStorePickup_Label().getAttribute("innerText");
		Thread.sleep(2000);
		System.out.println("delivery mode displayed ="+pickupDeliveryMode);
//		if(!pickupDeliveryMode.contains("Express Store Pick Up"))
//		{
//			 System.out.println("Express store pickup delivery mode section is not available for this product");
//			 throw new Exception("Express store pickup delivery mode section is not available for this product");			
//		}
		
	  String Pickup_default_Message=ProductDetails_Page.ExpressStorePickup_DefaultMessage().getText();	
	  //	String Pickup_default_Message=ProductDetails_Page.store_Info_Container().getText();
	  Log.info("pickup delivery message displayed ="+ Pickup_default_Message);
	  
	  if(Pickup_default_Message.contains(ExcelUtils.getCellData(iTestCaseRow, Constant.message1)))
	  {
		  Log.info("his product availability for store pickup depends on pincode and Size selected");
	  }
	  	  
	}catch(Exception e){
		Log.error("There is no Express pickup delivery option for this product");
		throw e;
	}
	}

	
	public static void verifying_Delivery_Section_BeforeEntering_Pincode(int iTestCaseRow) throws Exception {
		try{
			Utils.waitForPageLoadLongTime();
			String DefaultDeliveryMOde=ProductDetails_Page.Delivery_Tittle().getAttribute("innerText");
				
			Log.info("delivery mode displayed ="+ DefaultDeliveryMOde);
		
	if(DefaultDeliveryMOde.equalsIgnoreCase("Delivery"))
	{
	  String DeliveryMOde_Section=ProductDetails_Page.delivery_Section_BeforeEntering_Pincode().getAttribute("innerText"); 
	  Log.info("Delivery modes displayed in delivery section =" + DeliveryMOde_Section);
	}
	
	}catch(Exception e){
		Log.error("There is no Delivey option for this product");
		throw e;
	}
	}
	
	public static void verifying_Delivery_Section_AfterEntering_Pincode(int iTestCaseRow) throws Exception {	
		
		Thread.sleep(1000);
		try{
			String DefaultDeliveryMOde=ProductDetails_Page.Delivery_Tittle().getText();
				
			Log.info("delivery mode displayed ="+ DefaultDeliveryMOde);
		
	if(DefaultDeliveryMOde.equalsIgnoreCase("Delivery"))
	{
	 if( ProductDetails_Page.standardDelivery_AfterEntering_Pincode().isDisplayed())
	 {
		 Log.info("Tick mark is present for standard delivery mode");
	 }
	 else{	
		 Log.error("Tick mark is not present for standard delivery mode"); 
	 }
	 
	 if( ProductDetails_Page.codDelivery_AfterEntering_Pincode().isDisplayed())
	 {
		 Log.info("Tick mark is present for cod delivery mode");
	 } 
	 else{	
		 Log.error("Tick mark is not present for cod delivery mode"); 
	 }
	}
	else{
		Log.error("Delivery modes is not available for this product");
		}
	
	}catch(Exception e){
		Log.error("There is no Delivey option for this product");
		throw e;
	}
	
	}		
	
	
	

public static void verify_Del_And_pickupSec_with_InValidPincode(int iTestCaseRow) throws Exception{
	Thread.sleep(2000);
	ProductDetails_Page.Product.ChangePinBtn().click();
	Log.info("Change pin button is clicked");
	ProductDetails_Page.Product.PinCode().clear();
	Log.info("Previous pin is cleared from the field");
	try{
		// Entering invalid pincode which doesnt have stores
				ProductDetails_Page.Product.PinCode()
						.sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.invalidPostCode));
				Log.info("Pin is entered into the text field");
				ProductDetails_Page.Product.PinCodeCheckBtn().click();
				Log.info("Check button is clicked");
				PDP_Action.verifying_Delivery_Section_AfterEntering_Pincode(iTestCaseRow);
			Thread.sleep(2000);
			if(ProductDetails_Page.store_Info_Container().getText().equalsIgnoreCase(ExcelUtils.getCellData(iTestCaseRow, Constant.message3)))
			{
				Log.info("Expected value match with Actual value");
				Log.info("Product is not available for storepickup for this entered invalid pincode");
			}
			
	}
	catch(Exception e){
		Log.error("Navigation Till PDP Page failed with Invalid Pincode");
		throw e;
		
	}
}
public static void verify_Del_And_pickupSec_selectingSize_And_without_Pincode(int iTestCaseRow) throws Exception{
	try{
		
		PDP_Action.product_selectSize(ProductDetails_Page.Product.size_variant_buttonlist());
		PDP_Action.verifying_StorePickup_Section(iTestCaseRow);
		PDP_Action.verifying_Delivery_Section_BeforeEntering_Pincode(iTestCaseRow);
		Thread.sleep(2000);
		Utils.refresh();
	}
	catch(Exception e){
		Log.error("Navigation till PDP Page Failed || Method HappyPathFlowTillPDPPage || Class Utils");
	
		throw e;
	}
}
public static void verify_Del_And_pickupSec_WithoutSelectingSize_And_with_Pincode(int iTestCaseRow) throws Exception{
	try{
		ProductDetails_Page.Product.PinCode().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.postCode));
		Log.info("Pin is entered into the text field");
		ProductDetails_Page.Product.PinCodeCheckBtn().click();
		Log.info("Check button is clicked");
		PDP_Action.verifying_StorePickup_Section(iTestCaseRow);
		PDP_Action.verifying_Delivery_Section_AfterEntering_Pincode(iTestCaseRow);
		Thread.sleep(2000);
		ProductDetails_Page.Product.ChangePinBtn().click();
		Log.info("Change pin button is clicked");
		ProductDetails_Page.Product.PinCode().clear();
		Log.info("Previous pin is cleared from the field");
	}
	catch(Exception e){
		Log.error("Navigation Till PDP Page failed");
		throw new Exception("Navigation till PDP Page Failed || Method HappyPathFlowTillPDPPage || Class Utils");
	}
}
public static void verify_Del_And_pickupSec_selectingSize_And_Pincode(int iTestCaseRow) throws Exception{
	try{
		Utils.scrollingToPageElementByCordinate(5, 0);
		PDP_Action.product_selectSize(ProductDetails_Page.Product.size_variant_buttonlist());
		Thread.sleep(5000);
		ProductDetails_Page.Product.PinCode().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.postCode));
		Log.info("Pin is entered into the text field");
		ProductDetails_Page.Product.PinCodeCheckBtn().click();
		Log.info("Check button is clicked");
		
		verifying_Delivery_Section_AfterEntering_Pincode(iTestCaseRow);
		Thread.sleep(1000);
		 String pickupMessage=ProductDetails_Page.pickup_Message().getAttribute("innerText");
			if(!pickupMessage.equals("Free pickup available at below stores."))
			{
				throw new Exception("Express store free pickup message is not displayed");
			}
			Utils.CheckEnability(ProductDetails_Page.pincodePlaceholder());
	
		if(ProductDetails_Page.store_Info_Container().isDisplayed())
		{
		Utils.jsClick(ProductDetails_Page.show_StoreDetailsBtn());
		Log.info("show details button is clicked");
		 
		 String storeDetails=ProductDetails_Page.store_Details().getAttribute("innerText");
		 Log.info(storeDetails);
		 Thread.sleep(2000);	
		 //Utils.jsClick(ProductDetails_Page.hide_StoreDetailsBtn());
		 Utils.jsClick(ProductDetails_Page.show_StoreDetailsBtn());
		 Log.info("once again clicked show details button to hide details");
		 Thread.sleep(1000);
		 ProductDetails_Page.directions_Link().click();
		String url="https://www.google.com/maps/dir/";
			Utils.NewWindowActionURLValidate(url);
			Thread.sleep(2000);
			if((Constant.URL!="https://www.shoppersstop.com/")&&(Constant.URL!="https://uat.shopper-stop.in/")){
		 if(ProductDetails_Page.viewMore_Link().isDisplayed())
		 {
			 ProductDetails_Page.viewMore_Link().click();
			 Log.info("View more link is clicked");
			 if(ProductDetails_Page.stores_Popup().isDisplayed())
			 {
				 Log.info("More Available stores displayed in the popup");
				 ///
				 ProductDetails_Page.closeStores_Popup().click();
				 Log.info("close popup clicked");
				 Thread.sleep(2000);
				 //
			 }
			 else
			 {
				 Log.error("No stores displayed in the popup opened");
			 }
		 }
			}else{
			 Log.error("View more link is not available for this product with selected pincode"); 
		 }
		}
		else {
			Log.error("Storedetails not displayed for this product");
		}
		}

	catch(Exception e){
		Log.error("Navigation Till PDP Page failed");
		throw new Exception("Navigation till PDP Page Failed || Method HappyPathFlowTillPDPPage || Class Utils");
	}
}	
	
public static void verify_ProductDetailsAndCare_StyleNotes_BrandInfo_ReturnandExchange() throws Exception
{
	try {
	Utils.scrollingToPageElementByelement(ProductDetails_Page.product_DetailsAndCare());
	Utils.verifyElement(ProductDetails_Page.product_DetailsAndCare());
	Utils.verifyElement(ProductDetails_Page.product_Code());
	Utils.jsClick(ProductDetails_Page.style_Notes());
	Utils.verifyElement(ProductDetails_Page.style_Notes_Description());
	Utils.jsClick(ProductDetails_Page.brand_Info());
	Utils.verifyElement(ProductDetails_Page.brand_Info_Description());
	Utils.scrollingToPageElementByelement(ProductDetails_Page.return_And_Exchange());
	Utils.jsClick(ProductDetails_Page.return_And_Exchange());
	Utils.verifyElement(ProductDetails_Page.easy_Returns());
	Utils.verifyElement(ProductDetails_Page.easy_Exchange());
	Utils.verifyElement(ProductDetails_Page.delivery());
	}
	catch(Exception e)
	{
		Log.error("verification of ProductDetailsAndCare_StyleNotes_BrandInfo_ReturnandExchange failed");
		Log.error("Exception in Class PDP_Action | Method verify_ProductDetailsAndCare_StyleNotes_BrandInfo_ReturnandExchange");
		throw e;
	}
}

public static void verify_Reviews_And_Ratings() throws Exception
{
	try {
		Utils.scrollingToPageElementByelement(ProductDetails_Page.reviewsAndRatings());
		Utils.verifyElement(ProductDetails_Page.reviewsAndRatings());
		Utils.jsClick(ProductDetails_Page.yes_Button());
		Thread.sleep(3000);
		Utils.jsClick(ProductDetails_Page.no_Button());
		Thread.sleep(1000);
		ProductDetails_Page.rate_This_Product_Button().click();
		Thread.sleep(1000);
		Utils.verifyElement(ProductDetails_Page.write_A_Review());
		ProductDetails_Page.cancel_Button().click();
		
	}
	catch(Exception e)
	{
		Log.error("verification of Reviews And Ratings failed");
		Log.error("Exception in Class PDP_Action | Method verify_Reviews_And_Ratings");
		throw e;
	}
}

}
