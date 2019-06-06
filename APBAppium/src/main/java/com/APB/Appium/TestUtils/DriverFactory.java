package com.APB.Appium.TestUtils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.APB.Appium.setUp.TestSetUp;

import android.content.Context;
import android.os.Build;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import android.provider.Settings.Secure;

public class DriverFactory  {
	
	public static String chromeExeFilePath;

	public static String getChromeExeFilePath() {
		return chromeExeFilePath;
	}

	public static void setChromeExeFilePath(String chromeExeFilePath) {
		DriverFactory.chromeExeFilePath = chromeExeFilePath;
	}
	
	
	public  void createDriverInstance(String browserName)
	{
		AndroidDriver driver =null;
		
		if(browserName.equalsIgnoreCase("firefox"))
		{
			
		}else if(browserName.equalsIgnoreCase("chrome"))
		{
			
		}else if(browserName.equalsIgnoreCase("ie"))
		{
			
		}else if(browserName.equalsIgnoreCase("Android"))
		{
			DesiredCapabilities cap = new DesiredCapabilities();
						
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, DeviceDetail.getDeviceId());
			
			//cap.setCapability(MobileCapabilityType.DEVICE_NAME,new DeviceDetail().getUUID(this));
			
			//cap.setCapability(MobileCapabilityType.UDID, Secure.getString(this.getContentResolver(),Secure.ANDROID_ID));
							
			cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0.1");
			
			cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "90000");
			
			cap.setCapability(MobileCapabilityType.APP, TestSetUp.configProperty.getProperty("app_path"));
			
			cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.apbl.merchant.debug");
			
			cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.apbl.merchant.activity.SplashActivity");
			
			try {
				driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);	
				
				DriverManager.setDriver(driver);
				
				driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
								
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			
		}
		
	}
	
	public static void destory()
	{
		
		DriverManager.getDriver().quit();
		
	}

	
}
