package com.redbus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class MyTest {
    WebDriver driver;
    @Test
    public void sampleTest(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.redbus.in/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getPageSource());
        driver.close();
    }
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
