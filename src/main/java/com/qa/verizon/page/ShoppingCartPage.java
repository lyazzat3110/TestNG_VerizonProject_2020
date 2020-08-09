package com.qa.verizon.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.qa.verizon.util.ElementUtil;

public class ShoppingCartPage {

	WebDriver driver;
	ElementUtil elementUtil;
	By verifySmartPhone = By.xpath("//span[text()='iPhone® 11 Pro']");

	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil();
	}

	public String getShoppingCartPageTitle() {

		return driver.getTitle();
	}

	public String verifySmartPhone() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,400)");
		WebElement verifySmartPhone = driver.findElement
				(By.xpath("//span[text()='iPhone® 11 Pro']"));
		String name = verifySmartPhone.getText();

		return name;

	}

}