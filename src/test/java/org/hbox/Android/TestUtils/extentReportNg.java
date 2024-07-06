package org.hbox.Android.TestUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReportNg {
	 static ExtentSparkReporter report;
	 static ExtentReports extent;
	 public static ExtentReports getReporterObject() {
		 String path = System.getProperty("user.dir")+"\\reports\\index.html";
		 report = new  ExtentSparkReporter(path);
		 report.config().setDocumentTitle("generalstore");
		 report.config().setReportName("Mobile Automation");
		 
		 extent = new  ExtentReports();
		 extent.attachReporter(report);
		 extent.setSystemInfo("QA Engineer", "Rangam Kumar Singh");
		 return extent;
		
	 }

}
