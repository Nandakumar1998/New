package com.stepdefinition;

import java.awt.AWTException;
import java.io.IOException;

import org.junit.Assert;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
/**
 * 
 * @author Nanda
 * @date 10-09-2022
 * @description Used define the steps to be scenarios to be performed in LoginStep (TC_1 Step)
 *
 */
public class TC1_LoginStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

@Given("User is on the Adactin login page")
public void user_is_on_the_adactin_login_page() throws IOException {
	/*getDriver(getPropertyFileValue("browserType"));
	enterUrl(getPropertyFileValue("url"));
	impliciteWait();
	maximizeWindow();
*/	
}

@When("User should perform login {string},{string}")
public void user_should_perform_login(String username, String password) {
	pom.getLoginPage().login(username, password);
}


@When("User should perform login {string},{string} with enter keys")
public void user_should_perform_login_with_enter_keys(String username, String password) throws AWTException {
	pom.getLoginPage().loginByEnterKey(username, password);
}

@Then("User should verify after login error contains {string}")
public void user_should_verify_after_login_error_contains(String errTextLogin) {
	//Assert.assertTrue("verify the login error message" , getText(pom.getLoginPage().getTextErrorLoginPage()).contains(errTextLogin));
	Assert.assertTrue("verify login invalid err message",getText(pom.getLoginPage().getTextErrorLoginPage()).contains(errTextLogin));
	
}

}
