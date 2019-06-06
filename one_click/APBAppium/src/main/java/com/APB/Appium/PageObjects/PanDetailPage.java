package com.APB.Appium.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PanDetailPage extends BasePage{
	
	public PanDetailPage open() 
	{
		return (PanDetailPage) openPage(PanDetailPage.class);
	}	

	@Override
	public ExpectedCondition getPageLoadCondition() 
	{
		
		return ExpectedConditions.visibilityOf(PAN_Holder_Name);
	}
	
	@FindBy(id="com.apbl.merchant.debug:id/etPanHolderName")
	public WebElement PAN_Holder_Name;
	
	@FindBy(id="com.apbl.merchant.debug:id/etPanNumber")
	public WebElement PAN_Number;
	
	@FindBy(id="com.apbl.merchant.debug:id/btnDone")
	public WebElement Submit_btn;
	
	public FinalSignUpPage signUp3(String panHolderName, String panNumber)
	{
		type(PAN_Holder_Name, panHolderName, "Enter " +panHolderName+ " Name on PAN Card");
		type(PAN_Number, panNumber, "Enter " +panNumber+ "PAN Card Number");
		click(Submit_btn, "Click on Continue link");
		return (FinalSignUpPage) openPage(FinalSignUpPage.class);
	}

}
