package com.stepdefinition;

import org.junit.Assert;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;
/**
 * 
 * @author Nanda
 * @date 10-09-2022
 * @description Used define the steps to be scenarios to be performed in Select Hotel Step (TC_3 Step)
 *
 */
public class TC3_SelectHotelStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	@Then("User should select hotel name and click continue")
	public void user_should_select_hotel_name_and_click_continue() {
		pom.getSelectHotelPage().next();
	}

	@Then("User should verify the success message after selecting a hotel name {string}")
	public void user_should_verify_the_success_message_after_selecting_a_hotel_name(String txtBookAHotel) {
		Assert.assertEquals("Verify success message book a hotel ",pom.getBookHotelPage().getTxtBookAHotel().getText(), txtBookAHotel);
	}

	@Then("User should click continue without selecting any hotel name")
	public void user_should_click_continue_without_selecting_any_hotel_name() {
		pom.getSelectHotelPage().next1();
	}

	@Then("User should verify the error messages {string}")
	public void user_should_verify_the_error_messages(String errSelectHotel) {
		Assert.assertEquals("Verify error msg select a hotel", pom.getSelectHotelPage().getTxtRadioSpan().getText(), errSelectHotel);
	}

}
