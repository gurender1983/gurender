package com.APB.Appium.TestCases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.APB.Appium.PageObjects.CongratulationPage;
import com.APB.Appium.PageObjects.FinalSignUpPage;
import com.APB.Appium.TestUtils.TestUtil;
import com.APB.Appium.setUp.TestSetUp;

public class FinalSignUp extends TestSetUp{
	
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void fSignUp(Hashtable<String, String>data)
	{
		assignAuthor("Gurender Kumar Kush");
		assignCategory("Functioanl /Regression");
		
		FinalSignUpPage finalSignUpPage = new FinalSignUpPage().open();
		
		CongratulationPage finalSubmit = finalSignUpPage.finalSubmit(data.get(""));
		
	}

}
