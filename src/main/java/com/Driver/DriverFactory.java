package com.Driver;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

	//supports parallel execution
	//ThreadSafe object create
	
	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>(); 
	
	// it will create obj of thread local class that will conntain webdriver driver obj
	
	//creating constructor so that you cant create obj for it and use it for some other classes
	private DriverFactory() {
		
	}
	
	private static DriverFactory instance = new DriverFactory();
	
	//here instance obj created for class, cant access the obj outside class
	
	public static DriverFactory getInstance() {
		
		return instance;
	}
	
	//we need to write the obj in threadlocal for tht use  setDriver
	
	public void setDriver(WebDriver webDriver) {
		
		driver.set(webDriver);
		
	}
	
	public WebDriver getDriver() {
		return driver.get();
	}
}
