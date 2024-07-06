package org.hbox.Android.TestUtils;

import java.io.IOException;


import org.hbox.Pageobject.utils.AndroidAction;
import org.hbox.Pageobject.utils.AppiumUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Listeners extends AppiumUtils implements ITestListener{
	
	AndroidDriver driver;
	ExtentTest test;
	ExtentReports extent= extentReportNg.getReporterObject();
	 @Override
	    public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
	        
	    }
	    @Override
	    public void onTestSuccess(ITestResult result) {
	    	test.log(Status.PASS, "Test Pass");
	      
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	       test.fail(result.getThrowable());
	       try {
			driver = (AndroidDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
	       
	       try {
			test.addScreenCaptureFromPath(getScreenshotPath(result.getMethod().getMethodName() , driver),result.getMethod().getMethodName());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        
	    }

	    @Override
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	        
	    }

	    @Override
	    public void onStart(ITestContext context) {
	       
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	    	extent.flush();
	    }

}
