package com.APB.Appium.setUp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

import java.util.Properties;


import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.APB.Appium.TestUtils.DriverFactory;

import com.APB.Appium.TestUtils.ExcelReader;
import com.APB.Appium.TestUtils.ExtentManager;
import com.APB.Appium.TestUtils.SendEmail;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;





public class TestSetUp {
	
	//public static AndroidDriver driver;
	
	public static Properties configProperty;	
	public static Properties ORProperty;
	
	public static ExtentReports extent;
    public static ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
    public static ThreadLocal<ExtentTest> testCaseLogger = new ThreadLocal<ExtentTest>();
	
	public ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\testData\\TestData.xlsx");
	
	@BeforeSuite
	public void beforeSuite()
	{
		//excelreader class instantiation
		//property file  instantiation
		//extent report ---> object
		
		
		
		try {
			FileInputStream fi = new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\propertyFiles\\config.properties"));
			
			configProperty = new Properties();
			
			try {
				configProperty.load(fi);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		AndroidDriver driver=null;
		
		if(driver==null)
		{
			new DriverFactory().createDriverInstance(configProperty.getProperty("browser"));	
		}
		
		
		extent = ExtentManager.GetExtent();
		
		
	}
	
	@BeforeTest
	public void beforeTest()
	{
		
	}
	
	@BeforeClass
	public void beforeClass()
	{
		//extent reporting
		ExtentTest parent = extent.createTest(getClass().getSimpleName());
        parentTest.set(parent);
	}
	
	@BeforeMethod
	public void beforeMethod(Method method)
	{
		
		
		System.out.println("Starting execution of TestCase--"+method.getName());	
		
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result)
	{
		
				
		extent.flush();
		
		//driver.quit();
		
		//DriverManager.getDriver().close();
		
	}
	
	@AfterClass
	public void afterClass()
	{
		
	}
	
	@AfterTest
	public void afterTest()
	{
		
	}
	
	
	@AfterSuite
	public void afterSuite()
	{
		
		SendEmail.sendReportInEmail("a_GurenderKumar.Kush@airtel.com", "", "a_GurenderKumar.Kush@airtel.com", "Automation Test Report", "PFA");
		
	}
	
	
	public void assignAuthor(String authorName)
	{
		testCaseLogger.get().assignAuthor(authorName);
	}
	
	public void assignCategory(String category)
	{
		testCaseLogger.get().assignCategory(category);
	}
	


}
