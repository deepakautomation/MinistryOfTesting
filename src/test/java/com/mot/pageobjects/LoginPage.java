package com.mot.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mot.helper.CommonFunctions;



public class LoginPage extends CommonFunctions{
	
	private WebDriver driver;
	
	@FindBy(xpath="//input[@id='user_login']")
	public WebElement userName;
	
	@FindBy(xpath="//input[@id='user_password']")
	public WebElement password;
	
	@FindBy(xpath="//input[@name='commit']")
	WebElement loginButton;
	
	
	public LoginPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage enterUserName(String userName){
		type(this.userName, userName);
		return this;
	}
	
	public LoginPage enterPassword(String password){
		type(this.password, password);
		return this;
	}
	
	public HomePage clickLoginButton(){
		clickElement(this.loginButton);
		return new HomePage(driver);
	}
	
	public LoginPage userLoggedOut(String text) throws Exception{
		if(text.equalsIgnoreCase("shouldnot")){
			return this;
		}
		
		throw new Exception("Wrong user entered the application");
	}
	
	
}
