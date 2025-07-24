package com.redbus.stepdefinitions;

import com.redbus.base.Base;
import com.redbus.pageobject.HomePage;
import com.redbus.pageobject.SearchResultPage;
import com.redbus.util.Generic;
import com.redbus.util.ReadConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Search extends Generic {
    WebDriver driver;
    ReadConfig readConfig;
    HomePage homePage;
    SearchResultPage searchResultPage;
    @Given("Launch the {string} browser")
    public void launch_the_browser(String string) {
        driver = launchBrowser(string);
    }
    @Given("Navigate to {string}")
    public void navigate_to(String baseUrl) {
        readConfig = new ReadConfig();
        driver.get(readConfig.getBaseUrl(baseUrl));
    }
    @When("User click on the {string} location input box")
    public void user_click_on_the_location_input_box(String string) {
        homePage = new HomePage(driver);
        homePage.clickOnEditBox(string);
    }
    @When("Enter {string}")
    public void enter(String string) {
        homePage.enterFromText(string);
    }
    @When("Wait for the auto-suggestions to appear")
    public void wait_for_the_auto_suggestions_to_appear() {
        homePage.verifyAutoSuggestions();
    }
    @When("Select {string} from the suggestions")
    public void select_from_the_suggestions(String string) {
        homePage.selectFromSuggestions(string);
    }
    @When("Click on the search buses button")
    public void click_on_the_search_buses_button() {
        searchResultPage = homePage.clickOnSearchButton();
    }
    @When("Enable the {string} filter option")
    public void enable_the_filter_option(String string) {

    }
    @Then("User should see the search result page")
    public void user_should_see_the_search_result_page() {

    }
    @Then("User should be able to scroll down until the {string} message appears")
    public void user_should_be_able_to_scroll_down_until_the_message_appears(String string) {

    }
}
