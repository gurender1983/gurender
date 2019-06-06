package com.APB.Appium.TestCases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.APB.Appium.PageObjects.MyProfilePage;
import com.APB.Appium.PageObjects.mPINPage;
import com.APB.Appium.TestUtils.TestUtil;
import com.APB.Appium.setUp.TestSetUp;

public class mPin_Enter extends TestSetUp{
	
	@Test(dataProviderClass = TestUtil.class, dataProvider="dp")
	public void enter_mpin(Hashtable<String, String> data)
	{
		assignAuthor("Gurender Kumar");
		assignCategory("Functional Test Case");
		
		mPINPage mpinpage = new mPINPage().open();
		
		MyProfilePage myprofile =mpinpage.pin_enter(data.get("mPin"));
	}

}
