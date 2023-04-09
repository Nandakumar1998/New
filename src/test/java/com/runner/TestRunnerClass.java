package com.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import com.reports.Reporting;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
/**
 * 
 * @author Nanda
 * description Run all the feature file from here
 * date 10-09-2022
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty","json:target\\output.json"},stepNotifications = true, snippets = SnippetType.CAMELCASE, publish = true, dryRun = false, monochrome = true, features = "src\\test\\resources\\Features", glue = "com.stepdefinition")
public class TestRunnerClass {
      @AfterClass
      public static void afterclass() {
    	  Reporting.generateJvmReport("C:\\Users\\lenovo\\eclipse-workspace\\OmrBranchAdactinHotelAutomation\\target\\output.json");
      }
}   
