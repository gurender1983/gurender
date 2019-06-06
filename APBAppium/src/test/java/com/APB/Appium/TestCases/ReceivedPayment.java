package com.APB.Appium.TestCases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.APB.Appium.PageObjects.ReceivePaymentPage;
import com.APB.Appium.TestUtils.TestUtil;
import com.APB.Appium.setUp.TestSetUp;

public class ReceivedPayment extends TestSetUp {
	
	@Test(dataProviderClass=TestUtil.class, dataProvider="dp")
	public void received_Payment(Hashtable<String, String>data)
	{
		assignAuthor("Gurender Kumar");
		assignCategory("Functional Test Case");
		
		ReceivePaymentPage rec_Pay_Page = new ReceivePaymentPage().open();
		
		rec_Pay_Page.received_Payment(data.get("CustomerMobileNumber"), data.get("Amount"), data.get("OTP"));
	}

}




