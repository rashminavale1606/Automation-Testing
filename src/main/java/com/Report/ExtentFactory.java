package com.Report;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.Driver.DriverFactory;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import lombok.Getter;

public class ExtentFactory {

	ThreadLocal<ExtentTest> extent = new ThreadLocal<ExtentTest>();

	private ExtentFactory() {

	}

	private static ExtentFactory instance = new ExtentFactory();

	public static ExtentFactory getInstance() {
		return instance;
	}

	public void setExtent(ExtentTest obj) {
		extent.set(obj);

	}

	public ExtentTest getExtentTest() {

		return extent.get();
	}

	public void removeTest() {
		extent.remove();
	}

	public static String CaptureApplicationScreenshot() {

		TakesScreenshot screenshot = (TakesScreenshot) DriverFactory.getInstance().getDriver();

		File file = screenshot.getScreenshotAs(OutputType.FILE);

		byte[] fileContent = null;

		try {
			fileContent = FileUtils.readFileToByteArray(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Base64.getEncoder().encodeToString(fileContent);

	}
	
	public static void clickPass(String btnName) {
		
		getInstance().getExtentTest().pass(btnName + "  button is clicked!");
	}
	
	public static void clickFail(String btnName) {
		getInstance().getExtentTest().fail("Error occured while clicking on "+btnName);
	}
	
	public static void sendKeysPass(String value, String elementName) {
		
		getInstance().getExtentTest().pass(value+" is enterd in "+elementName);
		
	}
	
	public static void sendKeysFail(String value, String elementName) {
		
		getInstance().getExtentTest().fail("Error occured "
				+ "while entering value "+value+" in text box "+elementName);
	}
	
	public static void passTest(String message) {
		
		getInstance().getExtentTest().log(Status.PASS,
				MarkupHelper.createLabel(message, ExtentColor.GREEN));
	}
	
	public static void failTest(String message) {
		
		getInstance().getExtentTest().fail(message, 
				MediaEntityBuilder.createScreenCaptureFromBase64String(CaptureApplicationScreenshot()).build());
				
		
	}
}
