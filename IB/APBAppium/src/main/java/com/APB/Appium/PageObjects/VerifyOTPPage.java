package com.APB.Appium.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.Status;

public class VerifyOTPPage extends BasePage {
	
	public VerifyOTPPage open() 
	{
		
		return (VerifyOTPPage) openPage(VerifyOTPPage.class);
	}

	@Override
	public ExpectedCondition getPageLoadCondition() 
	{
		return ExpectedConditions.visibilityOf(btn_continue);
		
		//return null;
		
	}
	
	@FindBy(id="edit_launcher_otp")
	public WebElement otp_number;
	
	@FindBy(id="btn_launcher_ok")
	public WebElement btn_continue;
	
	
	
	public UpdateKYCPage verifyOTP(String otp)
	{
		type(otp_number, otp, "OTP");
		click(btn_continue, "Contiue Button");
		/*otp_number.sendKeys(otp);
		testCaseLogger.get().log(Status.INFO, "Enter "+otp+" asone time password");
		btn_continue.click();*/
		//return (SignUpPage) openPage(SignUpPage.class);
		
	/*--------------Direct Click on update Button---------------*/
		return (UpdateKYCPage) openPage(UpdateKYCPage.class);
		
		
	}

}
