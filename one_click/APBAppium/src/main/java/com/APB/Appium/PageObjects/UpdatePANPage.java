package com.APB.Appium.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.Status;

public class UpdatePANPage extends BasePage {
	
	public UpdatePANPage open()
	{
		return (UpdatePANPage) openPage(UpdatePANPage.class);
	}

	@Override
	public ExpectedCondition getPageLoadCondition()
	{
		return ExpectedConditions.visibilityOf(btn_update);
	}
	
	
	@FindBy(id="com.apbl.merchant.debug:id/etPanHolderName")
	public WebElement name_Crad_Holder;
	
	@FindBy(id="com.apbl.merchant.debug:id/etPanNumber")
	public WebElement PAN_Number;
	
	@FindBy(id="com.apbl.merchant.debug:id/etMpin")
	public WebElement m_PIN;
	
	@FindBy(id="com.apbl.merchant.debug:id/btnUpdate")
	public WebElement btn_update;
	
	
	public void updatePanDetail(String name, String pannumber, String mPin)
	{
		
		type(name_Crad_Holder, name, "Merchant Name");
		type(PAN_Number, pannumber, "PAN number of Merchant");
		type(m_PIN, mPin, "PIN number of Merchant");
		click(btn_update, "Update Button");
		/*name_Crad_Holder.sendKeys(name);
		testCaseLogger.get().log(Status.INFO, "Enter "+name+" of Merchant");
		PAN_Number.sendKeys(pannumber);
		testCaseLogger.get().log(Status.INFO, "Enter "+pannumber+"  PAN Number of Merchant");
		m_PIN.sendKeys(mPin);
		testCaseLogger.get().log(Status.INFO, "Enter "+mPin+"  Merchant MPIN");
		btn_update.click();*/
	}
	
	

}
