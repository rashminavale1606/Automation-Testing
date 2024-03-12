package com.Javascript;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.Driver.DriverFactory;
import com.Report.ExtentFactory;

public class JavaScriptActions {

	private Logger logger = LogManager.getLogger(JavaScriptActions.class);

	public void click(WebElement element) {

		try {

			JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getInstance().getDriver();

			js.executeScript("arguments[0].click()", element);

			logger.info("Element is Clicked using js");
			ExtentFactory.getInstance().passTest("Element  is Clicked using js");
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Exception occured while clicking on element using js " + e.getMessage());
			ExtentFactory.getInstance().failTest("Exception occured while clicking on element using js");
		}
	}

	//

	public void sendKeys(WebElement element, String value) {

		try {

			JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getInstance().getDriver();

			js.executeScript("arguments[0].value = " + "'" +value+ "'", element);

			logger.info(value+" is Entered");
			ExtentFactory.getInstance().passTest(value+" is entered");
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Exception occured while entering value using js " + e.getMessage());
			ExtentFactory.getInstance().failTest("Exception occured while entering value element using js");
		}
	}
	
	//a
	public void scrollPageToViewElement(WebElement element) {

		try {

			JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getInstance().getDriver();

			js.executeScript("arguments[0].scrollIntoView(true)",element);

			logger.info("Element is visible on screen");
			ExtentFactory.getInstance().passTest("Element is visible on screen");
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Exception occured while scrolling down page " + e.getMessage());
			ExtentFactory.getInstance().failTest("Exception occured while scrolling down page");
		}
	}
	//b
	public void scrollTillEndOfPage() {

		try {

			JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getInstance().getDriver();

			js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

			logger.info("Page is scrolled till end");
			ExtentFactory.getInstance().passTest("Page is scrolled till end");
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Exception occured while scrolling the page till end " + e.getMessage());
			ExtentFactory.getInstance().failTest("Exception occured while scrolling the page till end");
		}
	}
	
}
