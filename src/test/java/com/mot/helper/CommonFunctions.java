package com.mot.helper;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CommonFunctions {
	int shortTime = 30;

	Logger logger = LoggerHelper.getLogger(CommonFunctions.class);
	
	private WebDriver driver;
	
	public CommonFunctions(WebDriver driver){
		this.driver = driver;
	}
	
	public void waitForElement(WebElement element,long timeOutInSeconds){
		logger.info("waiting for element visibilityOf "+ element);
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
		logger.info("element is visible..");
	}
	
	public void type(WebElement element, String text){
		logger.info("enter "+text+" in element "+element);
		waitForElement(element, shortTime);
		element.sendKeys(text);
		logger.info("text is entered in "+element);
	}
	
	public void clickElement(WebElement element){
		logger.info("click "+element);
		waitForElement(element, shortTime);
		element.click();
		logger.info(element+ " is clicked");
	}
	
	public void pressEnter(WebElement element) throws InterruptedException{
		waitForElement(element, shortTime);
		element.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
	}
	
	
	public boolean verifyText(WebElement element, String text){
		waitForElement(element, shortTime);
		logger.info("verify element "+element);
		waitForElement(element, shortTime);
		logger.info("matching element "+element);
		return element.getText().toLowerCase().contains(text.toLowerCase());
	}
	
}
