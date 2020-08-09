package com.qa.verizon.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.qa.verizon.util.ElementUtil;

public class SmartPhoneFeaturePage {

	WebDriver driver;
	ElementUtil elementUtil;
	
	
	public SmartPhoneFeaturePage(WebDriver driver){
		this.driver=driver;
		elementUtil = new ElementUtil();
	}

	public String getSmartPhoneFeaturePageTitle() {
		System.out.println(driver.getTitle());
        return driver.getTitle();
	}
	public ShoppingCartPage doClick() throws InterruptedException {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,250)");
		
		WebElement color = driver.findElement
				(By.xpath("//label[@for='#d7d7d7']"));
		color.click();
		WebElement size = driver.findElement
				(By.xpath("//p[text()='64GB']"));
		size.click();
		WebElement price = driver.findElement
				(By.xpath("//span[text()='$999.99']"));
		price.click();
		WebElement button = driver.findElement(By.id("ATC-Btn"));
		button.click();
		WebElement zipCode = driver.findElement(By.id("zipcode"));
	    zipCode.sendKeys("07057");
	    WebElement confirmButton = driver.findElement
	    		(By.xpath("//button[text()='Confirm Location']"));
	    confirmButton.click();
	    WebElement newCustomer = driver.findElement
	    		(By.xpath("//button[text()='New Customer']"));
	    newCustomer.click();
	    WebElement shoppingCart = driver.findElement(By.xpath
	    		("//div[contains(@class,'gnav20-row-two')]//button[contains(@class,'gnav20-cart')]"));
	    shoppingCart.click();
	    WebElement confirm = driver.findElement
	    		(By.xpath(" //*[@id='gnav20-my-side-nav']/div/div[1]/div/div/a"));
	    confirm.click();
	    

		
		
	return new ShoppingCartPage(driver);

}
}