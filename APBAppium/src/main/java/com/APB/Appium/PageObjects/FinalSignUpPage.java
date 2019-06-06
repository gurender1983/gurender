package com.APB.Appium.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FinalSignUpPage extends BasePage{
	
	public FinalSignUpPage open()
	{
		return (FinalSignUpPage) openPage(FinalSignUpPage.class);
	}

	@Override
	public ExpectedCondition getPageLoadCondition()
	{
		return ExpectedConditions.visibilityOf(Submit_btn);
	}
	
	@FindBy(id="com.apbl.merchant.debug:id/btnDone")
	public WebElement Submit_btn;
	
	public CongratulationPage finalSubmit(String detail)
	{
		click(Submit_btn, "Click on Continue link");
		return (CongratulationPage) openPage(CongratulationPage.class);
		
	}

}
