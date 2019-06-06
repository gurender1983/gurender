package com.APB.Appium.TestCases;

import java.util.Hashtable;

//import org.testng.Assert;
import org.testng.annotations.Test;

import com.APB.Appium.PageObjects.SignUpPage;
import com.APB.Appium.PageObjects.UpdateKYCPage;
import com.APB.Appium.PageObjects.UpdatePANPage;
import com.APB.Appium.PageObjects.VerifyOTPPage;
import com.APB.Appium.TestUtils.TestUtil;
import com.APB.Appium.setUp.TestSetUp;

public class VerifyOTP extends TestSetUp {
	
	
	@Test(dataProviderClass = TestUtil.class, dataProvider="dp", dependsOnMethods = {"com.APB.Appium.TestCases.ValidateLogin.merchantLogin"})
	public void enterOTP(Hashtable<String,String>data)
	{
		assignAuthor("Gurender Kumar");
		assignCategory("Functional Test Case");
		
		
		VerifyOTPPage verifyOTP = new VerifyOTPPage().open();
		//SignUpPage SignUpPage = verifyOTP.verifyOTP(data.get("OTP"));
		UpdateKYCPage updateKYCPage = verifyOTP.verifyOTP(data.get("OTP"));
		
		//Assert.fail();
	}

}
