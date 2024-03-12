package com.Waits;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Constants.Constants;
import com.Driver.DriverFactory;
import com.Report.ExtentFactory;

public class ExplicitWaitActions {

	private Logger logger = LogManager.getLogger(ExplicitWaitActions.class);
	
	public void waitForElementToBePresent(
			WebElement element, String elementName) {
		try {
			
			WebDriverWait wait = new WebDriverWait(
					DriverFactory.getInstance().getDriver(), 
					Duration.ofSeconds(Constants.EXPLICIT_WAIT_TIME));
			
			wait.until(ExpectedConditions.visibilityOf(element));
			
			logger.info(elementName+" is available on screen");
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Exception occure while waiting for element to be visible"+e.getMessage());
			
			ExtentFactory.getInstance().clickFail("Exception occure while waiting for "
					+ "element to be visible");
		}
		
	}
	
	//
	
	public void waitForElementToBeClickable(
			WebElement element, String elementName) {
		try {
			
			WebDriverWait wait = new WebDriverWait(
					DriverFactory.getInstance().getDriver(), 
					Duration.ofSeconds(Constants.EXPLICIT_WAIT_TIME));
			
			wait.until(ExpectedConditions.elementToBeClickable(element));
			
			logger.info(elementName+" is clickable  on screen");
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Exception occure while waiting for element to be clickable"+e.getMessage());
			
			ExtentFactory.getInstance().clickFail("Exception occure while waiting for "
					+ "element to be clickable");
		}
		
	}
}
