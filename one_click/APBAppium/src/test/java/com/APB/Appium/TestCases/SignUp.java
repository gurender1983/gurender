package com.APB.Appium.TestCases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.APB.Appium.PageObjects.SignUpPage;
import com.APB.Appium.PageObjects.SignUpPage2;
import com.APB.Appium.TestUtils.TestUtil;
import com.APB.Appium.setUp.TestSetUp;

public class SignUp extends TestSetUp{
	
	@Test(dataProviderClass = TestUtil.class, dataProvider="dp")
	public void personalDetails(Hashtable<String,String>data)
	{
		
		assignAuthor("Gurender Kumar Kush");
		assignCategory("Functioanl /Regression");
		
		SignUpPage signup = new SignUpPage().open();
		
		SignUpPage2 signuppage2 = signup.signUp(data.get("FirstName"), data.get("LastName"), data.get("ShopName"), data.get("ShopCategory"));
		
	}

}
