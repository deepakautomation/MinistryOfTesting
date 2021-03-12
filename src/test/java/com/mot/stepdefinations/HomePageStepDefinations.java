package com.mot.stepdefinations;

import com.mot.helper.CommonFunctions;
import com.mot.pageobjects.HomePage;
import com.mot.pageobjects.LoginPage;
import com.mot.testbase.TestBase;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageStepDefinations extends TestBase{
	
	HomePage homePage = new HomePage(driver);
	CommonFunctions waitHelper = new CommonFunctions(driver);

	@When("^click on discussion link$")
	public void click_on_discussion_link() throws Throwable {
		homePage.clickDiscussionLink();
	}
	
	@Then("^I enter \"([^\"]*)\" as search Input$")
	public void i_enter_searchInput_as(String arg1) throws Throwable {
		homePage.enterSearchItem(arg1);
	}
	

	@Then("^I click on search Icon$")
	public void click_on_login_button() throws Throwable {
		homePage.clickSearchIcon();
	}
	
	@Then("^search results values should be displayed as \"([^\"]*)\" as per Search Input$")
	public void verify_Search_Results(String arg1) throws Throwable {
		System.out.println("**************************************");
		homePage.verifySearchResult(arg1);
	}
}
