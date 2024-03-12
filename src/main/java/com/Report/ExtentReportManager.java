package com.Report;

import com.Constants.Constants;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
	
	public static ExtentReports setUpExtentReports() {
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(Constants.EXECUTION_REPORT_PATH);
		
		ExtentReports extent = new ExtentReports();
		
		extent.attachReporter(reporter);
		
		return extent;
	}
	
	

}
