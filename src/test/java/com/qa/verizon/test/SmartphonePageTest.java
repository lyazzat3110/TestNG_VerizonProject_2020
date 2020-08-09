package com.qa.verizon.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.qa.verizon.base.BasePage;
import com.qa.verizon.page.MainPage;
import com.qa.verizon.page.SmartPhonesPage;
import com.qa.verizon.util.AppConstant;

public class SmartphonePageTest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	MainPage mainPage;
	SmartPhonesPage smartphonesPage;

	@BeforeTest
	public void setUp() throws InterruptedException {
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		mainPage = new MainPage(driver);
		smartphonesPage = mainPage.clickSmartPhones();
		

		Thread.sleep(5000);

	}

	@Test(priority = 1)
	public void verifyPageTitleTest()  {
		
		 String title = smartphonesPage.getSmartPhonePageTitle();
    	 System.out.println("smartphone page title is:" + title);
    	 Assert.assertEquals(title,AppConstant.SMARTPHONES_PAGE_TITLE);


	}

	@Test(priority = 2)
	public void SwitchToSmartphonePage()   {
		
		smartphonesPage.switchToSmartphoneFeature();
	}

	@AfterTest
	public void tearDown() throws InterruptedException  {
		Thread.sleep(3000);
	driver.quit();
	}
}
