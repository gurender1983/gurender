package com.APB.Appium.TestCases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.APB.Appium.PageObjects.PanDetailPage;
import com.APB.Appium.PageObjects.SignUpPage2;
import com.APB.Appium.TestUtils.TestUtil;
import com.APB.Appium.setUp.TestSetUp;

public class BankDetail extends TestSetUp {
	
	@Test(dataProviderClass =TestUtil.class, dataProvider="dp")
	public void bankDetails(Hashtable<String, String> data)
	{
		assignAuthor("Gurender Kumar Kush");
		assignCategory("Functioanl /Regression");
		
		SignUpPage2 signuppage2 = new SignUpPage2().open();
		
		PanDetailPage panpage = signuppage2.signUp2(data.get("BankAccountNumber"), data.get("BankAccountHolderName"), data.get("IFSCCode"));		
	}
	


}
