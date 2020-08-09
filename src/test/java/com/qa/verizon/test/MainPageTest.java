package com.qa.verizon.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.qa.verizon.base.BasePage;
import com.qa.verizon.page.MainPage;
import com.qa.verizon.util.AppConstant;

public class MainPageTest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	MainPage mainPage;

	@BeforeTest
	public void setUp() throws InterruptedException   {
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		mainPage = new MainPage(driver);
     Thread.sleep(3000);
	}

	@Test(priority = 1)
	public void verifyPageTitleTest()  {
		
		 String title = mainPage.getMainPageTitle();
    	 System.out.println("main page title is" + title);
    	 Assert.assertEquals(title,AppConstant.MAIN_PAGE_TITLE);

	}

	@Test(priority = 2)

	public void TestClickSmartphones()  {
	
		mainPage.clickSmartPhones();
	}

	@AfterTest
	public void tearDown()  {
		
		driver.quit();

	}
}
