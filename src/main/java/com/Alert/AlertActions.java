package com.Alert;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;

import com.Driver.DriverFactory;
import com.Report.ExtentFactory;

public class AlertActions {
	
	private Logger logger = LogManager.getLogger();
	
	private Alert alert;
	
	public void switchToAlert() {
		
		try {
			
			alert = DriverFactory.getInstance().getDriver().switchTo().alert();
			logger.info("Switch to Alert");
			ExtentFactory.getInstance().passTest("Switch  to Alert");
			
		} catch (NoAlertPresentException e) {
			// TODO: handle exception
			
			logger.error("Exception occur while switching to alert");
			ExtentFactory.getInstance().failTest("Exception occur while switching to alert");
			
		}
		
	}
	
	//accept alert
	
	public void acceptAlert() {
		
		try {
			this.alert.accept();
			
			logger.info("Clicked on Ok button");
			ExtentFactory.getInstance().passTest("Clicked on Ok button");
			
		} catch (Exception e) {
			// TODO: handle exception
			
			logger.info("Exception occured while clicking on OK button");
			ExtentFactory.getInstance().failTest("Exception occured while clicking on OK button");
		}
	}
		
//cancel alert
	public void cancelAlert() {
		
		try {
			
			this.alert.dismiss();
			
			logger.info("Clicked on CANCEL button");
			
			ExtentFactory.getInstance().passTest("Clicked on CANCEL button");
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Exception occured while clicking on CANCEL button");
			ExtentFactory.getInstance().failTest("Exception occured while clicking on CANCEL button");
		}
	}
}
