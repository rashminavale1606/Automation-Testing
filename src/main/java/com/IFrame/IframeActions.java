package com.IFrame;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Constants.Constants;
import com.Driver.DriverFactory;
import com.Report.ExtentFactory;

public class IframeActions {

	private Logger logger = LogManager.getFormatterLogger(IframeActions.class);

	public void waitForIframeAndSwitch(String idOrName) {

		try {

			WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(),
					Duration.ofSeconds(Constants.EXPLICIT_WAIT_TIME));

			// condition

			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(idOrName));

			logger.info("Switch to iframe");
			ExtentFactory.getInstance().passTest("Switch to iframe");

		} catch (Exception e) {
			// TODO: handle exception

			logger.info("Error Occured while switching to iframe");

			ExtentFactory.getInstance().failTest("Error Occured while switching to iframe");
		}

	}

	public void waitForIframeAndSwitch(int index) {

		try {

			WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(),
					Duration.ofSeconds(Constants.EXPLICIT_WAIT_TIME));

			// condition

			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));

			logger.info("Switch to iframe");
			ExtentFactory.getInstance().passTest("Switch to iframe");

		} catch (Exception e) {
			// TODO: handle exception

			logger.info("Error Occured while switching to iframe");

			ExtentFactory.getInstance().failTest("Error Occured while switching to iframe");
		}

	}

	public void switchBackToDefaultContent() {

		try {

			DriverFactory.getInstance().getDriver().switchTo().defaultContent();

			logger.info("Switched to Default content");

			ExtentFactory.getInstance().passTest("Switched to Default content");

		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Error Occured while switching to default content");

			ExtentFactory.getInstance().failTest("Error Occured while switching to default content");
		}
	}
}
