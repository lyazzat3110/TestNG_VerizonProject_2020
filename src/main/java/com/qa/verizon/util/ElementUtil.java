package com.qa.verizon.util;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.verizon.base.BasePage;


public class ElementUtil extends BasePage{
	 WebDriver driver;
	    WebDriverWait wait;
	    Properties prop;
	    public void moveToElement(By locator,WebElement elementClicked) {
	    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Actions action = new Actions(driver);
			WebElement mouseOverAction = driver.findElement(locator);
			action.moveToElement(mouseOverAction).build().perform();	
		}
		/**
		 *  title wait method
		 * @param title
		 * @return
		 */
		public boolean waitForTitlePresent(String title){
		wait.until(ExpectedConditions.titleIs(title));
		return true;
		}
		/**
		 * wait element
		 * @param locator
		 * @return
		 */
		public boolean waitForElementPresent(By locator){
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			return true;
		}
		
		public boolean waitForElementVisible(By locator){
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			return true;
		}
		/**
		 * Get title method
		 */
		public String doGetPageTitle() {
			
			try {
				return driver.getTitle();
			} catch (Exception e) {
				System.out.println("some exception got occured while getting the title...");
			}
			return null;
		}
		
		/**
		 *Get Elemenet
		 * @param locator
		 * @return
		 */
		public WebElement getElement(By locator) {
			
			WebElement element = null;
			
			try {
				element = driver.findElement(locator);
				
				}
			 
		   catch (Exception e) {
				System.out.println("some exception got occured while creating the web element");
			}
			return element;
		}
		
		/**
		 * Click On Method
		 * @param locator
		 */
		public void doClick(By locator) {
			getElement(locator).click();
//			try {
//				getElement(locator).click();
//			} catch (Exception e) {
//				System.out.println("some exception got occured while clicking the web element");
//			}
		}
		
		/**
		 * SendKey
		 * @param locator
		 * @param value
		 */
		public void doSendKeys(By locator, String value) {
			
			try {
				WebElement element = getElement(locator);
				element.clear();
				element.sendKeys(value);
			} catch (Exception e) {
				System.out.println("some exception got occured while entering values in a field");
			}
		}
		
		/**
		 * isDisplayed
		 * @param locator
		 * @return
		 */
		public boolean doIsDisplayed(By locator) {
			
			try {
				return getElement(locator).isDisplayed();
			} catch (Exception e) {
				System.out.println("some exception got occured isDisplayed method");
			}
			return false;
		}
		
		/**
		 * isEnabled
		 * @param locator
		 * @return
		 */
		public boolean doIsEnabled(By locator) {
			
			try {
				return getElement(locator).isEnabled();
			} catch (Exception e) {
				System.out.println("some exception got occured isEnabled method");
			}
			return false;
		}
		
		/**
		 * isSelected
		 * @param locator
		 * @return
		 */
		public boolean doIsSelected(By locator) {
			
			try {
				return getElement(locator).isSelected();
			} catch (Exception e) {
				System.out.println("some exception got occured isSelected method");
			}
			return false;
		}
		
		
		/**
		 * GetText()
		 * @param locator
		 * @return
		 */
		public String doGetText(By locator) {
			
			try {
				return getElement(locator).getText();
			} catch (Exception e) {
				System.out.println("some exception got occured while getting text...");
			}
			return null;
		}
}
