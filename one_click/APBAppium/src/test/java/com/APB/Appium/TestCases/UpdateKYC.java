package com.APB.Appium.TestCases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.APB.Appium.PageObjects.UpdateKYCPage;
import com.APB.Appium.PageObjects.mPINPage;
import com.APB.Appium.TestUtils.TestUtil;
import com.APB.Appium.setUp.TestSetUp;

public class UpdateKYC extends TestSetUp {
	
	@Test(dataProviderClass = TestUtil.class, dataProvider="dp")
	public void kycUpdate(Hashtable<String, String> data)
	{
		
		assignAuthor("Gurender Kumar");
		assignCategory("Functional Test Case");
		
		UpdateKYCPage kycPage = new UpdateKYCPage().open();
		mPINPage mpage =kycPage.KYCUpdate(data.get(""));
		
	}

}
