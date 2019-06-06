package com.APB.Appium.TestCases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.APB.Appium.PageObjects.FinalSignUpPage;
import com.APB.Appium.PageObjects.PanDetailPage;
import com.APB.Appium.TestUtils.TestUtil;
import com.APB.Appium.setUp.TestSetUp;

public class PanDetails extends TestSetUp{
	
	@Test(dataProviderClass = TestUtil.class, dataProvider="dp")
	public void panDetails(Hashtable<String, String>data)
	{
		assignAuthor("Gurender Kumar Kush");
		assignCategory("Functioanl /Regression");
		
		PanDetailPage pan_deta = new PanDetailPage().open();
		
		FinalSignUpPage finalSubmit = pan_deta.signUp3(data.get("PANHolderName"), data.get("PANNumber"));
			
	}

}
