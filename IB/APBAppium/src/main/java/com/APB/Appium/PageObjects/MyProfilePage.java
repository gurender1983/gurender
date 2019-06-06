package com.APB.Appium.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyProfilePage extends BasePage{
	
	public MyProfilePage open()
	{
		return (MyProfilePage) openPage(MyProfilePage.class);
	}

	@Override
	public ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(my_profile);
	}
	
	@FindBy(name="My Profile")
	public WebElement my_profile;
	
	@FindBy(className = "android.widget.ImageButton")
	public WebElement back_btn;
	
	public ReceivePaymentPage my_profile(String profile)
	{
		click(back_btn, "back button");
		return (ReceivePaymentPage) openPage(ReceivePaymentPage.class);
	}

}
