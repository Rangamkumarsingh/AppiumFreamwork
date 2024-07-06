package org.hbox.Pageobject.Android;

import java.util.List;

import org.hbox.Pageobject.utils.AndroidAction;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage extends AndroidAction{
	
AndroidDriver driver;
	
	public CartPage(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id ="com.androidsample.generalstore:id/productPrice")
	private List<WebElement> productList;
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/totalAmountLbl\"]")
	private WebElement totalAmount;
	
	@AndroidFindBy(xpath ="//android.widget.CheckBox[@text=\"Send me e-mails on discounts related to selected products in future\"]")
	private WebElement checkBox;
	
	@AndroidFindBy(xpath ="//android.widget.Button[@resource-id=\"com.androidsample.generalstore:id/btnProceed\"]")
	private WebElement visit;

public List<WebElement> getProductList() {
	return productList;
}
 public double getProductsSum() {
	 int count = productList.size();
	 double totalSum = 0;
	 for(int i=0 ; i < count; i++) {
		 String amountString = productList.get(i).getText();
		 Double price = getFormattedAmount(amountString);
		 totalSum = totalSum + price;
	 }
	 return totalSum;
 }

 public Double getFormattedAmount(String amountString) {
	// TODO Auto-generated method stub
	return null;
}
public Double getTotalAmountDisplay() {
	 return getFormattedAmount(totalAmount.getText());
 }
 
 public void cartCheckbox() {
	 checkBox.click();
 }
 
 public void visitWebsite() {
	 visit.click();
 }

}
