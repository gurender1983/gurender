package com.APB.Appium.PageObjects;

import org.openqa.selenium.Dimension;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.APB.Appium.TestUtils.DriverManager;
import com.APB.Appium.setUp.TestSetUp;
import com.aventstack.extentreports.Status;


import io.appium.java_client.TouchAction;


public abstract class BasePage<T> extends TestSetUp{
	
	//AndroidDriver driver;
	
	public int driverTimeOut = 20;
	public T openPage(Class<T> clazz)
	{
		T page =null;
		page = PageFactory.initElements(DriverManager.getDriver(), clazz);
		
		
		ExpectedCondition pageLoadCondition = ((BasePage) page).getPageLoadCondition();
		
		waitForPageLoad(pageLoadCondition); 
		
		return page;  
	}
	 
	public abstract ExpectedCondition getPageLoadCondition();
	
	public void waitForPageLoad(ExpectedCondition pageLoadCondition)
	{
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), driverTimeOut);
		
		wait.until(pageLoadCondition);
	}
	
	public void click(WebElement element, String elementName)
	{
		element.click();
		
		testCaseLogger.get().log(Status.INFO, "Clicked on "+ elementName);
		
	}
	
	public void type(WebElement element, String text, String elementName)
	{
		
		element.sendKeys(text);
		
		testCaseLogger.get().log(Status.INFO, "Entered "+"<b>"+ text + "</b>" + "as"+ elementName);	
		
	}
	
	public void select()
	{
		
	}
	
	
	
	public void swipeTouch()
	{
		
		TouchAction tAction = new TouchAction(DriverManager.getDriver());
		
		//tAction.press(200, 500).moveTo(500, 500).release().perform();
		
		Dimension size = DriverManager.getDriver().manage().window().getSize();
		
		System.out.println(size);
		
		int starty = (int)(size.height*0.40);
		
		int endy = (int) (size.height*0.20);
		
		int startx = size.width/2;
		
		System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);
		
		//DriverManager.getDriver().swipe(startx, endy, startx, starty, 3000);
		
		tAction.press(startx, starty).waitAction().moveTo(startx, endy).release().perform();
		
	}
	
	
}
