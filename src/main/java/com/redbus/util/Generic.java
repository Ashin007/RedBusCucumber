package com.redbus.util;

import com.redbus.base.Base;
import com.redbus.pageobject.SearchResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Generic extends Base {

    public void click(WebElement webElement){
        System.out.println("Click");
        WebDriverWait wait;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(webElement));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }
    public SearchResultPage clickAndRedirect(WebElement webElement){
        System.out.println("Click");
        WebDriverWait wait;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(webElement));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
        return new SearchResultPage(driver);
    }
    public void sendKeys(WebElement byElement,String textToBeEntered){
        System.out.println("SendKeys");
        WebDriverWait wait;
        try {
            Thread.sleep(2000);
            wait = new WebDriverWait(driver,Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(byElement));
            byElement.sendKeys(textToBeEntered);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    public void getActiveElementAndEnterText(By webElement,String textToBeEntered) {
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(webElement));
            WebElement activeElement = driver.switchTo().activeElement();

            activeElement.sendKeys(textToBeEntered);
    }

    public void verifyAutoSuggestionAppeared(By locator){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement autoSuggestion = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        System.out.println("AutoSuggestion displayed: "+autoSuggestion.isDisplayed());
    }

    public void verifyAutoSuggestionResult(By suggestion,String fromLocation){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        List<WebElement> listOfSuggestions  = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(suggestion,1));
        for(WebElement element:listOfSuggestions){
            System.out.println(element.getAttribute("class"));
        }
        if(listOfSuggestions.size()>1){
            listOfSuggestions.get(1).findElement(By.xpath("//div[text()='"+fromLocation+"']")).click();
        }
    }

    public void verifyElement(By locator){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        System.out.println("WebElement displayed: "+element.isDisplayed());
        System.out.println(element.getText());
        Assert.assertTrue(element.isDisplayed());
    }
}
