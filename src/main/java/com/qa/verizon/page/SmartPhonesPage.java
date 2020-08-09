package com.qa.verizon.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.util.ElementUtil;
import com.qa.verizon.util.JavascriptUtil;

public class SmartPhonesPage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;
	JavascriptUtil javascriptUtil;
	

	public SmartPhonesPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil();
	}

	public String getSmartPhonePageTitle() {
         System.out.println(driver.getTitle());
         return driver.getTitle();
	}
	

	public SmartPhoneFeaturePage switchToSmartphoneFeature()  {
	
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,900)");
		WebElement phone = driver.findElement(By.xpath
				("//a[@aria-label='Apple iPhone 11 Pro']"));
		phone.click();
		return new SmartPhoneFeaturePage(driver);

	}

}
