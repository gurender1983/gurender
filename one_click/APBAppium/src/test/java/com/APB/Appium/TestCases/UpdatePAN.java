package com.APB.Appium.TestCases;

import java.util.Hashtable;

import org.testng.Assert;
//import org.springframework.util.Assert;
import org.testng.annotations.Test;

import com.APB.Appium.PageObjects.UpdatePANPage;
import com.APB.Appium.TestUtils.TestUtil;
import com.APB.Appium.setUp.TestSetUp;

public class UpdatePAN extends TestSetUp {
	
	
	@Test(dataProviderClass = TestUtil.class, dataProvider="dp")
	public void panDetail(Hashtable<String, String>data)
	{
		assignAuthor("Gaurav Kumar");
		assignCategory("Functional Test Case");
		
		UpdatePANPage updatepan = new UpdatePANPage().open();
		updatepan.updatePanDetail(data.get("Name"), data.get("PANNumber"), data.get("MPin"));
		
		//Assert.fail();
	}

}
