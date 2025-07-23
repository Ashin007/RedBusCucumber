package com.redbus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class MyTest {
    @Test
    public void sampleTest(){

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.redbus.in/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getPageSource());
        driver.close();
        driver.quit();
    }
}
