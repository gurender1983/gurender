package com.APB.Appium.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ReceivePaymentPage extends BasePage {
	
	public ReceivePaymentPage open()
	{
		return (ReceivePaymentPage) openPage(ReceivePaymentPage.class);
	}

	@Override
	public ExpectedCondition getPageLoadCondition()
	{
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(submit_btn);
	}
	
	@FindBy(id="com.apbl.merchant.debug:id/btn_mip_otp_generate")
	public WebElement submit_btn;
	
	@FindBy(id="com.apbl.merchant.debug:id/et_mip_number")
	public WebElement cust_mob_number;
	
	@FindBy(id="com.apbl.merchant.debug:id/et_mip_amount")
	public WebElement amount_;
	
	@FindBy(id="android:id/button1")
	public WebElement ok_btn;
	
	@FindBy(xpath="//android.widget.RelativeLayout[@index='2']/TextInputLayout[@index='0']/android.widget.EditText[@index='0']")
	public WebElement otp_number;
	
	@FindBy(id="com.apbl.merchant.debug:id/btn_mip_complete_tx")
	public WebElement verify_btn;
	
	public void received_Payment(String mobNumber, String amount, String otp)
	{
		type(cust_mob_number, mobNumber, "Customer Mobile Number");
		type(amount_, amount, "amount");
		click(submit_btn, "submit button");
		click(ok_btn, "ok button");
		type(otp_number, otp, "OTP");
		click(verify_btn, " verify button");
	}
}