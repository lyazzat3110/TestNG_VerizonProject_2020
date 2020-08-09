package com.qa.verizon.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.page.ShoppingCartPage;
import com.qa.verizon.page.MainPage;
import com.qa.verizon.page.SmartPhoneFeaturePage;
import com.qa.verizon.page.SmartPhonesPage;
import com.qa.verizon.util.AppConstant;

public class ShoppingCartPageTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	MainPage mainPage;
	SmartPhonesPage smartphonesPage;
	SmartPhoneFeaturePage  smartPhoneFeatures;
	ShoppingCartPage cartPage;

@BeforeTest
public void setUp() throws InterruptedException {
	basePage = new BasePage();
	prop = basePage.init_properties();
	String browserName = prop.getProperty("browser");
	driver = basePage.init_driver(browserName);
	driver.get(prop.getProperty("url"));
	mainPage = new MainPage(driver);
	smartphonesPage = mainPage.clickSmartPhones();
	smartPhoneFeatures = smartphonesPage.switchToSmartphoneFeature();
	cartPage = smartPhoneFeatures.doClick();
	cartPage = new ShoppingCartPage(driver);
	Thread.sleep(5000);


}
@Test (priority=1)
public void verifyPageTitleTest()   {

	 String title =  cartPage.getShoppingCartPageTitle();
	 System.out.println("Shopping cart page title is" + title);
     Assert.assertEquals(title,AppConstant.BAG_PAGE_TITLE);
 
}
@Test (priority=2)
public void verifySmartPhone() {
	String name = cartPage.verifySmartPhone();
	System.out.println("Phone name is:"+name);
	Assert.assertEquals(name, "iPhone® 11 Pro");
}


@AfterTest
public void tearDown(){
	 driver.quit();
}
	
}
