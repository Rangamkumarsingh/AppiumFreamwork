package org.hbox.Android.TestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.hbox.Pageobject.utils.AppiumUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;


public class AndroidBaseTest extends AppiumUtils{

	

	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	public WebDriverWait wait;
	@BeforeClass(alwaysRun=true)
	public void ConfigureAppium() throws URISyntaxException, InterruptedException, IOException {
		FileInputStream file= new FileInputStream("C:\\Users\\ranga\\Desktop\\seli\\AppiumFrameworkDesign\\src\\main\\java\\org\\hbox\\Pageobject\\Android\\resources\\data.properties");
		Properties prop = new Properties();
	    prop.load(file);
	    String ipAddress= System.getProperty("ipAddress")!=null ? System.getProperty("ipAddress"):prop.getProperty("ipAddress");
	   // String ipAddress =prop.getProperty("ipAddress");
	    String port =prop.getProperty("port");
	service = startAppiumServer(ipAddress , Integer.parseInt(port));
	
	UiAutomator2Options options = new UiAutomator2Options();
	options.setDeviceName("OnePluse CHP2569");//sdk gphone64_x86_64 emulator-5554
	options.setChromedriverExecutable("C:\\Users\\ranga\\Desktop\\seli\\Appium\\Driver\\chromedriver.exe");
	//options.setApp("C:\\Users\\ranga\\Desktop\\seli\\Appium\\src\\test\\java\\resoures\\ApiDemos-debug.apk");
	options.setApp("C:\\Users\\ranga\\Desktop\\seli\\AppiumFrameworkDesign\\src\\test\\java\\resoures\\General-Store.apk");
	//options.setApp("C:\\Users\\ranga\\Desktop\\seli\\Appium\\src\\test\\java\\resoures\\WhatsApp.apk");
	 //Thread.sleep(2000);

	 driver = new AndroidDriver(service.getUrl(), options);
		 wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		
		
}
	
	@AfterClass(alwaysRun=true)
	public void tesrdown() {
	 driver.quit();
	 service.stop();
	}
}
