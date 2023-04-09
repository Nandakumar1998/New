package com.stepdefinition;



import org.junit.Assert;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;
/**
 * 
 * @author Nanda
 * @date 10-09-2022
 * @description Used to maintain only the common steps in all step definition file
 *
 */
public class CommonStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

@Then("User should verify success message after login {string}")
public void user_should_verify_success_message_after_login(String expWelcomeMsg) {
	Assert.assertEquals("verify adactin login", expWelcomeMsg, getValue(pom.getSearchHotelPage().getTxtHelloSuccesMsg()));
	
}
}
