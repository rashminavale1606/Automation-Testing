package com.Waits;

import java.security.KeyStore.PrivateKeyEntry;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.Constants.Constants;
import com.Driver.DriverFactory;

public class ImplicitWaitActions {

	private Logger logger = LogManager.getLogger(ImplicitWaitActions.class);
	
	public void setImplicitWait() {
		
		
		try {
			
			
			DriverFactory.getInstance().getDriver().manage().timeouts()
			.implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT_TIME));
		
		logger.info("Implicit wait time is set to "+Constants.IMPLICIT_WAIT_TIME);
		
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Error occured while setting implicit wait "+e.getMessage());
		}
		
	}
}
