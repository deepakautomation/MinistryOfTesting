package com.mot.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mot.helper.CommonFunctions;

public class HomePage extends CommonFunctions{

	private WebDriver driver;
	
	@FindBy(xpath="//a[contains(text(),'Discussions')]")
	public WebElement discussionLink;
	
	@FindBy(xpath="//a[@id='search-button']")
	public WebElement searchIcon;
	
	@FindBy(xpath="//input[@id='search-term']")
	public WebElement searchInput;
	
	@FindBy(xpath="//div[contains(@class,'fps-result')]//div[contains(@class,'blurb container')]//span[contains(text(),'mabl') or contains(text(),'Mabl') or contains(text(),'MABL')]")
	public List<WebElement> searchResult;
	
	public HomePage(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public HomePage userLoggedIn(String text) throws Exception{
		if(text.equalsIgnoreCase("should")){
			return new HomePage(driver);
		}
		throw new Exception("Correct user unable to enter the application");
	}
	
	public HomePage clickDiscussionLink(){
		clickElement(this.discussionLink);
		return this;
	}
	
		
	public HomePage clickSearchIcon(){
		searchIcon.click();
		return this;
	}
	
	public HomePage enterSearchItem(String searchText) throws InterruptedException{
		type(this.searchInput, searchText);
		pressEnter(this.searchInput);
		return this;
	}
	
	public HomePage verifySearchResult(String text){
		for(WebElement item: searchResult){
			assert verifyText(item, text);
		}
		return this;
	}
}
