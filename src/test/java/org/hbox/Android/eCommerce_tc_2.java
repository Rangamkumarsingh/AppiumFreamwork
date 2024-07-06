package org.hbox.Android;

import org.hbox.Android.TestUtils.AndroidBaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.Activity;

public class eCommerce_tc_2 extends AndroidBaseTest{

	
	@BeforeMethod
	public void preSetup() {
		Activity activity = new Activity("com.androidsample.generalstore" , "com.androidsample.generalstore.MainActivity");
		//driver.startActivity(activity);
		((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of(
                "appPackage", "com.androidsample.generalstore",
                "appActivity", "com.androidsample.generalstore.MainActivity"
            ));
	}
	@Test
	public void FiilFrom_ErrorValidation() {
		
		//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Rangam Singh");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@resource-id=\"com.androidsample.generalstore:id/radioFemale\"]")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Argentina\"))"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		Assert.assertEquals(toastMessage,"Please enter your name");
	}
	
	@Test

public void FiilFrom_PositiveFlow() {
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Rangam Singh");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@resource-id=\"com.androidsample.generalstore:id/radioFemale\"]")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Argentina\"))"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		Assert.assertEquals(toastMessage,"Please enter your name");
	}
}
