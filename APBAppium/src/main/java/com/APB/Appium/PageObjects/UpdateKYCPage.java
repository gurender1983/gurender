package com.APB.Appium.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UpdateKYCPage extends BasePage {
	
	public  UpdateKYCPage open()
	{
		return (UpdateKYCPage) openPage(UpdateKYCPage.class);
			
	}

	@Override
	public ExpectedCondition getPageLoadCondition() 
	{
		
		return ExpectedConditions.visibilityOf(update_btn);
	}
	
	@FindBy(id="com.apbl.merchant.debug:id/btnLeft")
	public WebElement update_btn;
	
	public mPINPage KYCUpdate(String KYC)
	{
		click(update_btn, "Click on Update Button");
		return (mPINPage) openPage(mPINPage.class);
	}
	
	

}
