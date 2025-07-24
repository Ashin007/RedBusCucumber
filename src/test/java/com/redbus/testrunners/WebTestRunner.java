package com.redbus.testrunners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "features",
        plugin = {"pretty"},
        glue = {"com.redbus.stepdefinitions"})
    // This is important for parallel execution in TestNG
public class WebTestRunner extends AbstractTestNGCucumberTests{


}
