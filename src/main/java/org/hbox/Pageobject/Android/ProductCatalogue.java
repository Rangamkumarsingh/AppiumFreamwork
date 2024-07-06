package org.hbox.Pageobject.Android;

import java.util.List;

import org.hbox.Pageobject.utils.AndroidAction;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductCatalogue extends AndroidAction {
	AndroidDriver driver;
	
	public ProductCatalogue(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text=\"ADD TO CART\"]")
	private List<WebElement> addToCart;
	
	@AndroidFindBy(id ="com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement cart;
	

	public void addItemToCartByIndex(int Index) {
		addToCart.get(Index).click();
	}
	
	public void goToCartPage() {
		cart.click();
	}
}
