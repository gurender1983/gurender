package com.APB.Appium.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignUpPage extends BasePage {
	
	public SignUpPage open()
	{
		return (SignUpPage) openPage(SignUpPage.class);
	}

	@Override
	public ExpectedCondition getPageLoadCondition()
	{
		return ExpectedConditions.visibilityOf(allow_mer_location);
		//return null;
	}
	
	@FindBy(id="com.android.packageinstaller:id/permission_allow_button")
	public WebElement allow_mer_location;
	
	@FindBy(id="com.apbl.merchant.debug:id/etFirstName")
	public WebElement First_Name;
	
	@FindBy(id="com.apbl.merchant.debug:id/etLastName")
	public WebElement Last_Name;
	
	@FindBy(id="com.apbl.merchant.debug:id/etShopName")
	public WebElement Shop_Name;
	
	@FindBy(id="com.apbl.merchant.debug:id/etShopCategory")
	public WebElement Shop_Category;
	
	@FindBy(id="com.apbl.merchant.debug:id/btnContinue")
	
	public WebElement Contiue_btn;
	
	@FindBy(name="Healthcare")
	public WebElement Category;
	
	@FindBy(name="Pharmacy")
	public WebElement Category_Value;
	
	
	
	public SignUpPage2  signUp(String fName, String lName, String shopName, String shopCategory)
	{
		click(allow_mer_location, "Click on Allow Merchant Location");
		
		type(First_Name, fName, "Enter "+ fName+ " Merchant Fisrt Name");
		
		type(Last_Name, lName, "Enter "+lName+ " Mercant Last Name");	
		
		type(Shop_Name, shopName, "Enter "+shopName+" shop name");
		
		swipeTouch();
		
		click(Shop_Category, "Click to select Shop Category");
		
		click(Category, "Select Category");
		
		click(Category_Value, "Click oto Select Category Value");
		
		click(Contiue_btn, "Click on Continue link");
		
		return (SignUpPage2) openPage(SignUpPage2.class);
	}

}
