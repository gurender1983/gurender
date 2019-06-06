package com.APB.Appium.TestCases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.APB.Appium.PageObjects.CongratulationPage;
import com.APB.Appium.TestUtils.TestUtil;
import com.APB.Appium.setUp.TestSetUp;

public class CongratulationScreen extends TestSetUp {
	
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void congratulation_Onboarding(Hashtable<String, String>data) 
	{
		assignAuthor("Gurender Kumar Kush");
		assignCategory("Functioanl /Regression");
		
		CongratulationPage cp = new CongratulationPage().open();
		
		cp.merchantCreation(data.get(""));
	}

}
