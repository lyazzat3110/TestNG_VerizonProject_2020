package com.qa.verizon.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.qa.verizon.base.BasePage;
import com.qa.verizon.util.ElementUtil;

public class MainPage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;
	Actions actions;

	public MainPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil();
	}

	public String getMainPageTitle()  {
		System.out.println(driver.getTitle());
        return driver.getTitle();
		
	}

	public SmartPhonesPage clickSmartPhones()  {

		WebElement phoneMenu = driver.findElement(By.xpath
				("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/button[2]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(phoneMenu).build().perform();
		By smartPhone = By.xpath
				("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/ul[1]/li[1]/a[2]");
		WebElement locator = driver.findElement(smartPhone);
		locator.click();

		return new SmartPhonesPage(driver);

	}

}