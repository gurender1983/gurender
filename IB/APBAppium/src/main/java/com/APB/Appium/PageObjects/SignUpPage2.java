package com.APB.Appium.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignUpPage2 extends BasePage {
	
	public SignUpPage2 open()
	{
		return (SignUpPage2) openPage(SignUpPage2.class);
	}

	@Override
	public ExpectedCondition getPageLoadCondition()
	{
		return ExpectedConditions.visibilityOf(Account_Number);
		//return null;
	}
	
	@FindBy(id="com.apbl.merchant.debug:id/etBankAcctNumber")
	public WebElement Account_Number;
	
	@FindBy(id="com.apbl.merchant.debug:id/etBankAcctName")
	public WebElement Account_Holder_Name;
	
	@FindBy(id="com.apbl.merchant.debug:id/etIfscCode")
	public WebElement IFSC_Code;
	
	@FindBy(id="com.apbl.merchant.debug:id/btnDone")
	public WebElement Submit_btn;
	
	@FindBy(id="com.apbl.merchant.debug:id/etPanHolderName")
	public WebElement PAN_Holder_Name;
	
	@FindBy(id="com.apbl.merchant.debug:id/etPanNumber")
	public WebElement PAN_Number;
	
	public PanDetailPage signUp2(String accountNumber, String accountHolderName, String IFSCCode)
	{
		type(Account_Number, accountNumber, "Enter " +accountNumber+ " Merchant Account Number");
		
		type(Account_Holder_Name, accountHolderName, "Enter " + accountHolderName + " Merchant Bank Name");
		
		type(IFSC_Code, IFSCCode, "Enter " +IFSCCode+ "Bank IFSC Code");
		
		click(Submit_btn, "Click on Continue link");
		
		return (PanDetailPage) openPage(PanDetailPage.class);
	}
	
	

}
