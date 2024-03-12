package com.Report;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.*;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

@Listeners
public class ExtentReportListener implements ITestListener{

	//interface log4j
	private static Logger logger = LogManager.getLogger(ExtentReportListener.class);
	private ExtentReports extentReports;
	private ExtentTest extentTest;
	
	@Override
	public void onTestStart(ITestResult result) {
		
		this.extentTest = extentReports.createTest(result.getName());
		
		ExtentFactory.getInstance().setExtent(extentTest);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentFactory.getInstance().passTest(result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		ExtentFactory.getInstance().getExtentTest().fail("Exception details "+
		result.getThrowable().getMessage());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		ExtentFactory.getInstance().getExtentTest().log(Status.SKIP,
				"test case "+result.getName()+" is skipped");
		
		logger.info("Test is added in pool");
	}

	@Override
	public void onStart(ITestContext context) {
		
		this.extentReports = ExtentReportManager.setUpExtentReports();
	}

	@Override
	public void onFinish(ITestContext context) {
		
		this.extentReports.flush();
	}
	
	

}
