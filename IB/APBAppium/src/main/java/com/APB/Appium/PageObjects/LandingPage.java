package com.APB.Appium.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.Status;

import android.graphics.YuvImage;
import io.appium.java_client.android.AndroidDriver;

public class LandingPage extends BasePage {
	
	public LandingPage open()
	{
		return (LandingPage) openPage(LandingPage.class); 
	}
	
	@Override
	public ExpectedCondition getPageLoadCondition() 
	{
		return ExpectedConditions.visibilityOf(btn_continue);
	}
	
		
	@FindBy(id="edit_launcher_mobilenumber")
	public WebElement mobile_number;
	
	@FindBy(id="btn_launcher_ok")
	public WebElement btn_continue;
	
	@FindBy(id="com.android.packageinstaller:id/permission_allow_button")
	public WebElement allow_merchant_sms;
	
	public VerifyOTPPage doLogin(String userName)
	{
		type(mobile_number, userName, "Merchant");
		click(btn_continue, "Continue Button");
		click(allow_merchant_sms, "Allow SMS");
		
		
		
		/*mobile_number.sendKeys(userName);
		testCaseLogger.get().log(Status.INFO, "Enter "+userName+" as Merchant Mobile Number");
		
		btn_continue.click();
		
		allow_merchant_sms.click();*/
		
		//testCaseLogger.get().log(Status., t)
		return (VerifyOTPPage) openPage(VerifyOTPPage.class);
		
	}
	
	/*public VerifyOTPPage doLoginWithInvalidMobile(String userName)
	{
		mobile_number.sendKeys(userName);
		
		btn_continue.click();
		
		return this;
		
	}*/

	

}
