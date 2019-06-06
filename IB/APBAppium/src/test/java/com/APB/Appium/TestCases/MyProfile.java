package com.APB.Appium.TestCases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.APB.Appium.PageObjects.MyProfilePage;
import com.APB.Appium.PageObjects.ReceivePaymentPage;
import com.APB.Appium.TestUtils.TestUtil;
import com.APB.Appium.setUp.TestSetUp;

public class MyProfile extends TestSetUp {
	
	@Test(dataProviderClass=TestUtil.class, dataProvider="dp")
	public void myProfile(Hashtable<String, String>data)
	{
		assignAuthor("Gurender Kumar");
		assignCategory("Functional Test Case");
		
		MyProfilePage myprofilepage = new MyProfilePage().open();
		
		ReceivePaymentPage RPP = myprofilepage.my_profile(data.get(""));
	}

}
