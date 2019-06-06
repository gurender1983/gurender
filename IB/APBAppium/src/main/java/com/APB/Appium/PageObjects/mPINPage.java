package com.APB.Appium.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class mPINPage extends BasePage{
	
	public mPINPage open()
	{
		return (mPINPage) openPage(mPINPage.class);
	}

	@Override
	public ExpectedCondition getPageLoadCondition()
	{
		
		return ExpectedConditions.visibilityOf(forget_mpin);
	}
	
	@FindBy(id="com.apbl.merchant.debug:id/tv_mpin_forgot")
	public WebElement forget_mpin;
	
	@FindBy(id="com.apbl.merchant.debug:id/tv_dialpad_0")
	public WebElement dial_Number0;
	@FindBy(id="com.apbl.merchant.debug:id/tv_dialpad_1")
	public WebElement dial_Number1;
	@FindBy(id="com.apbl.merchant.debug:id/tv_dialpad_2")
	public WebElement dial_Number2;
	@FindBy(id="com.apbl.merchant.debug:id/tv_dialpad_3")
	public WebElement dial_Number3;
	@FindBy(id="com.apbl.merchant.debug:id/tv_dialpad_4")
	public WebElement dial_Number4;
	@FindBy(id="com.apbl.merchant.debug:id/tv_dialpad_5")
	public WebElement dial_Number5;
	@FindBy(id="com.apbl.merchant.debug:id/tv_dialpad_6")
	public WebElement dial_Number6;
	@FindBy(id="com.apbl.merchant.debug:id/tv_dialpad_7")
	public WebElement dial_Number7;
	@FindBy(id="com.apbl.merchant.debug:id/tv_dialpad_8")
	public WebElement dial_Number8;
	@FindBy(id="com.apbl.merchant.debug:id/tv_dialpad_9")
	public WebElement dial_Number9;
	
	@FindBy(id="com.apbl.merchant.debug:id/cb_ok")
	public WebElement ok_btn;
	
	public MyProfilePage pin_enter(String mPin)
	{
		for(int i=0; i<mPin.length(); i++)
		{
			
			char pin= mPin.charAt(i);
            
            String str= Character.toString(pin);
            
            System.out.println("values are :"+str);
            
            switch(str)
            {
            case "0": click(dial_Number0, "Enter " +mPin+ " value");
            break;
            
            case "1": click(dial_Number1, "Enter " +mPin+ " value");
            break;
            
            case "2": click(dial_Number2, "Enter " +mPin+ " value");
            break;
            
            case "3": click(dial_Number3, "Enter " +mPin+ " value");
            break;
            
            case "4": click(dial_Number4, "Enter " +mPin+ " value");
            break;
            
            case "5": click(dial_Number5, "Enter " +mPin+ " value");
            break;
            
            case "6": click(dial_Number6, "Enter " +mPin+ " value");
            break;
            
            case "7": click(dial_Number7, "Enter " +mPin+ " value");
            break;
            
            case "8": click(dial_Number8, "Enter " +mPin+ " value");
            break;
            
            case "9": click(dial_Number9, "Enter " +mPin+ " value");
            break;            
            }         
		}
		
		click(ok_btn, "OK button.");
		return (MyProfilePage) openPage(MyProfilePage.class);
	}
	
	

}
