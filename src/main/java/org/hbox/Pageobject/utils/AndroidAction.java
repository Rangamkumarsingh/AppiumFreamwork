package org.hbox.Pageobject.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AndroidAction extends AppiumUtils{
AndroidDriver driver;
	
public void longPressButton(WebElement ele) {
    ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", 
        ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "duration", 2000));
}

public void scrollToCountry(String text) {
	
	 driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\""+text+"\"))"));
	    
	}

public void swipeGesture(WebElement ele, String direction) {
	  ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", 
		        ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "direction", "left" , "percent" , 0.75));
}



  public  List<HashMap<String, String>>getJsonData (String jsonFilePath) throws IOException {
    	//System.getProperty("user.dir")+"C:\\Users\\ranga\\Desktop\\seli\\AppiumFrameworkDesign\\src\\test\\java\\org\\hbox\\Android\\testData\\eCommerce.json"
    	String jsonContent = FileUtils.readFileToString(new File(jsonFilePath), StandardCharsets.UTF_8);
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){});
        return data;
    }
    
	
	

	public void dragDrop(WebElement ele) {
		// Java
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
		    "elementId", ((RemoteWebElement) ele).getId(),
		    "endX", 100,
		    "endY", 100
		));
	}
	
	
//	public Double getFormattedAmount(String string) {
//	Double price = Double.parseDouble(amount.subString(1));
//		return price;
//	}

}
