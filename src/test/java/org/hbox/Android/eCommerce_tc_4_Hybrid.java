package org.hbox.Android;

import org.hbox.Android.TestUtils.AndroidBaseTest;
import org.hbox.Pageobject.Android.CartPage;
import org.hbox.Pageobject.Android.FormPage;
import org.hbox.Pageobject.Android.ProductCatalogue;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class eCommerce_tc_4_Hybrid extends AndroidBaseTest{

	@Test(dataProvider="getData" , groups = {"Smoke"})
	public void AppiumTest(HashMap<String , String>  input) throws MalformedURLException, URISyntaxException, InterruptedException  {
	
		FormPage formPage = new FormPage(driver);
	
		formPage.setCountryName(input.get("country"));
		formPage.setNameField(input.get("name"));
		formPage.setGender(input.get("gender"));
		formPage.submitFrom();
		
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		productCatalogue.addItemToCartByIndex(0);
		productCatalogue.addItemToCartByIndex(0);
		productCatalogue.goToCartPage();
		
		CartPage cartPage = new CartPage(driver);
		cartPage.cartCheckbox();
		cartPage.visitWebsite();
			
				Set<String> contexts = driver.getContextHandles();
				for(String contextname : contexts) {
					System.out.println(contextname);
				}
				
				driver.context("WEBVIEW_com.androidsample.generalstore");
				driver.findElement(By.name("q")).sendKeys("Jai Shree Ram");
				driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
				driver.pressKey(new KeyEvent(AndroidKey.BACK));
				driver.context("NATIVE_APP");

				// Press Home button
				//driver.pressKey(new KeyEvent(AndroidKey.HOME));

	}
	@BeforeMethod(alwaysRun=true)
	public void preSetup() {
		FormPage formPage = new FormPage(driver);
		formPage.setActivity();
	}
	@DataProvider
	
	public Object[][] getData() throws IOException {
		
		 List<HashMap<String, String>> data = getJsonData("C:\\Users\\ranga\\Desktop\\seli\\AppiumFrameworkDesign\\src\\test\\java\\org\\hbox\\Android\\testData\\eCommerce.json");
		//return new Object[][] {{"India","Rangam","female"},{"Argentina","Rangam Singh","male"}};
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
		
	}

	

	

