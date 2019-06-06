package com.APB.Appium.TestUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.annotations.DataProvider;

import com.APB.Appium.setUp.TestSetUp;
import com.aventstack.extentreports.utils.FileUtil;

public class TestUtil extends TestSetUp {
	
	public static String screenshotPath;
	
	public static String screenshotName;
	
	@DataProvider(name = "dp")
	public Object[][] getData(Method method)
	{
		
		String sheetName = method.getName();		
		int rowCount = excel.getRowCount(sheetName);
		
		//System.out.println(sheetName);	
		//System.out.println(rowCount);	
		
		int columnCount = excel.getColumnCount(sheetName);
		
		//System.out.println(columnCount);
		
		Object[][] data = new Object[rowCount-1][1];
		
		Hashtable<String, String> table = null;
		
		for(int rowNum =2; rowNum<=rowCount; rowNum++)
		{
			table = new Hashtable<String, String>();
			for(int cellNum =0; cellNum<columnCount; cellNum++)
			{
				table.put(excel.getCellData(sheetName, cellNum, 1), excel.getCellData(sheetName, cellNum, rowNum));
				data[rowNum-2][0]= table; 
				
				System.out.println(data[rowNum-2][0]);
			}
		}	
		
		//System.out.println(data);
		
		return data;
		
	}
	
	
	public static void captureScreenshot() throws IOException
	{
		screenshotPath = "./Screenshots/";
		
		File scrFile = DriverManager.getDriver().getScreenshotAs(OutputType.FILE);
		
		Date d = new Date();
		
		screenshotName = d.toString().replace(":", "_").replace(" ", "_")+ ".png";
		
		FileUtils.copyFile(scrFile, new File(screenshotPath+screenshotName) );

	}
}
