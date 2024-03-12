package com.Base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.Driver.BrowserFactory;
import com.Driver.DriverFactory;
import com.Properties.ConfigLoader;
import com.Properties.TestDataLoader;

public class BaseTestClass {

	@BeforeSuite
	public void setUP() {
		
		 WebDriver driver = BrowserFactory.createBrowserInstance
				 (ConfigLoader.getInsatnce().getPropertyValue("browser"));
		 
		 DriverFactory.getInstance().setDriver(driver);
		 DriverFactory.getInstance().getDriver().get(TestDataLoader.getInstance().getAppUrl());
	}
	
	@AfterSuite
	public void tearDown() {
		DriverFactory.getInstance().getDriver().quit();
	}
}
