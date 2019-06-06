package com.APB.Appium.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CongratulationPage extends BasePage {
	
	public CongratulationPage open()
	{
		return (CongratulationPage) openPage(CongratulationPage.class);
	}

	@Override
	public ExpectedCondition getPageLoadCondition()
	{
		return ExpectedConditions.visibilityOf(continue_btn);
	}
	
	@FindBy(id="com.apbl.merchant.debug:id/btnContinue")
	public WebElement continue_btn;
	
	public void merchantCreation(String detail)
	{
		click(continue_btn, "Merchant onboarding successfully");
	}

}
