package org.hbox.Pageobject.Android;

import org.hbox.Pageobject.utils.AndroidAction;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class FormPage extends AndroidAction{
	AndroidDriver driver;
	
	public FormPage(AndroidDriver driver) {
		super();
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(xpath ="//android.widget.EditText[@resource-id=\"com.androidsample.generalstore:id/nameField\"]")
	private WebElement nameField;
	
	@AndroidFindBy(xpath ="//android.widget.RadioButton[@resource-id=\"com.androidsample.generalstore:id/radioFemale\"]")
	private WebElement femaleOption;
	
	@AndroidFindBy(xpath ="//android.widget.RadioButton[@resource-id=\"com.androidsample.generalstore:id/radioMale\"]")
	private WebElement maleOption;
	

	@AndroidFindBy(id ="com.androidsample.generalstore:id/spinnerCountry")
	private WebElement countryName;
	
	@AndroidFindBy(xpath ="//android.widget.Button[@resource-id=\"com.androidsample.generalstore:id/btnLetsShop\"]")
	private WebElement letsShop;
	
	public void setNameField(String name) {
		nameField.sendKeys(name);
		driver.hideKeyboard();
	}
//	Activity activity = new Activity("com.androidsample.generalstore" , "com.androidsample.generalstore.MainActivity");
//	driver.startActivity(activity);
	public void setActivity() {

		((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of(
                "appPackage","com.androidsample.generalstore",
                "appActivity","com.androidsample.generalstore.MainActivity"
            ));
		
	}
	
	
	public void setGender(String gender) {
		if(gender.contains("Female"))
			femaleOption.click();
		else
			maleOption.click();
		
	}
	
	public void setCountryName(String country) {
		countryName.click();
		scrollToCountry(country);
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+country+"']")).click();
	}
	
	public void submitFrom() {
		letsShop.click();
	}
	}



