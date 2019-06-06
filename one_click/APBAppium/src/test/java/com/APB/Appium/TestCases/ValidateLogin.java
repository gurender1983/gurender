package com.APB.Appium.TestCases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.APB.Appium.PageObjects.LandingPage;
import com.APB.Appium.PageObjects.VerifyOTPPage;
import com.APB.Appium.TestUtils.TestUtil;
import com.APB.Appium.setUp.TestSetUp;

public class ValidateLogin extends TestSetUp {
	
	
	@Test(dataProviderClass = TestUtil.class, dataProvider="dp")
	public void merchantLogin(Hashtable<String,String>data)
	{
		
		assignAuthor("Gurender");
		assignCategory("Functional Test Case");
		//driver info
		LandingPage landingPage = new LandingPage().open();
		
		VerifyOTPPage OTPPage = landingPage.doLogin(data.get("MerchantMobileNumber"));
		//navigate
		//enter mobile number
		//click on continue button
	}

}
