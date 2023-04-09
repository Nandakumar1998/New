package com.stepdefinition;

import java.io.IOException;

import com.base.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
/**
 * 
 * @author Nanda
 * @date 10-09-2022
 * @description Used to maintain the before and after methods
 *
 */
public class HookClass extends BaseClass {
	@Before
	public void beforeSenario() throws IOException {
		getDriver(getPropertyFileValue("browserType"));
		enterUrl(getPropertyFileValue("url"));
		impliciteWait();
		maximizeWindow();
	}
    @After
    public void afterSenario(Scenario scenario) {
    	if (scenario.isFailed()) {
			scenario.attach(screenShot(), "image/png", "screenShot after scenario");
		}
    	toQuitTheBrowser();
    }
    
 	   
}

