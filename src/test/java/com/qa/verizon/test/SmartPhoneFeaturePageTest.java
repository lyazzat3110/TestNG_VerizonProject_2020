package com.qa.verizon.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.page.MainPage;
import com.qa.verizon.page.SmartPhoneFeaturePage;
import com.qa.verizon.page.SmartPhonesPage;
import com.qa.verizon.util.AppConstant;

public class SmartPhoneFeaturePageTest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	MainPage mainPage;
	SmartPhonesPage smartphonesPage;
	SmartPhoneFeaturePage smartPhoneFeatures;

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
	    //smartPhoneFeatures = new SmartPhoneFeaturePage(driver);
		Thread.sleep(5000);

	}

	@Test(priority = 1)
	
	public void verifyPageTitleTest() {
		
		String title = smartPhoneFeatures.getSmartPhoneFeaturePageTitle();
		System.out.println("Smartphone feature page title is" + title);
		Assert.assertEquals(title, AppConstant.SMARTPHONEFEATURE_PAGE_TITLE);

	}

	@Test(priority = 2)
	public void makeItWork() throws InterruptedException  {
		
		smartPhoneFeatures.doClick();
	}

	@AfterTest
	public void tearDown() {

		
		driver.quit();
	}

}
