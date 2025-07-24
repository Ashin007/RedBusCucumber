package com.redbus.pageobject;

import com.redbus.base.Base;
import com.redbus.util.Generic;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Generic {

    @FindBy(xpath = "(//div[(contains(@class,'srcDest'))])[1]")
    private WebElement fromWebElement;

    @FindBy(xpath = "(//div[(contains(@class,'srcDest'))])[3]")
    private WebElement toWebElement;

    @FindBy(xpath="//div[contains(@class,'searchSuggestion')]")
    private WebElement suggestionsBox;

    @FindBy(xpath="//button[contains(@class,'primaryButton')]")
    private WebElement searchButton;

    By suggestion = By.xpath("//div[contains(@class,'searchSuggestion')]");
    By category = By.xpath("//div[contains(@class,'searchCategory')]");

    By busFoundTextLocator = By.xpath("//div[contains(@class,'busesFoundText')]");

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }

    public void clickOnEditBox(String toOrFrom){
        if(toOrFrom.equalsIgnoreCase("To")){
            click(toWebElement);
        }
        else{
            click(fromWebElement);
        }
    }

    public void enterFromText(String data){
        getActiveElementAndEnterText(suggestion,data);
    }

    public void verifyAutoSuggestions(){
        verifyAutoSuggestionAppeared(suggestion);
    }
    public void selectFromSuggestions(String fromLocation){
        verifyAutoSuggestionResult(category,fromLocation);
    }

    public SearchResultPage clickOnSearchButton(){
        SearchResultPage searchResultPage = clickAndRedirect(searchButton);
        verifyElement(busFoundTextLocator);
        return searchResultPage;
    }


}
