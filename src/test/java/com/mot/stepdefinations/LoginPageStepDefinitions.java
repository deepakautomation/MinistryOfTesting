package com.mot.stepdefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.mot.helper.CommonFunctions;
import com.mot.pageobjects.HomePage;
import com.mot.pageobjects.LoginPage;
import com.mot.testbase.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class LoginPageStepDefinitions extends TestBase {

	LoginPage loginPage = new LoginPage(driver);
	HomePage homePage = new HomePage(driver);
	CommonFunctions waitHelper = new CommonFunctions(driver);
	
	@Given("^I am on the Login page URL \"([^\"]*)\"$")
	public void i_am_on_the_Login_page_URL(String arg1) throws Throwable {
		driver.get(arg1);
	}


	@When("^I enter username as \"([^\"]*)\"$")
	public void i_enter_username_as(String arg1) throws Throwable {
		loginPage.enterUserName(arg1);
	}


	@When("^I enter password as \"([^\"]*)\"$")
	public void i_enter_password_as(String arg1) throws Throwable {
		loginPage.enterPassword(arg1);
	}

	@When("^click on login button$")
	public void click_on_login_button() throws Throwable {
		loginPage.clickLoginButton();
	}
	
	@When("^user \"([^\"]*)\" sucessfully logged in$")
	public void verify_user_credentials(String arg1) throws Throwable {
		if(arg1.equalsIgnoreCase("should")){
			homePage.userLoggedIn(arg1);
		}else{
			loginPage.userLoggedOut(arg1);
		}
	}
	

	
}