package com.APB.Appium.TestUtils;

import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;

public class DriverManager {
	
	public static ThreadLocal<AndroidDriver> driver = new ThreadLocal<AndroidDriver>();

	public static AndroidDriver getDriver() {
		return DriverManager.driver.get();
	}

	public static void setDriver(AndroidDriver driver) {
		DriverManager.driver.set(driver);
	}
	
	public static void setImplicitWait(AndroidDriver driver)
	{
		DriverManager.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

}
