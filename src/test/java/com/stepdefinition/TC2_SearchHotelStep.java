package com.stepdefinition;

import org.junit.Assert;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;

/**
 * 
 * @author Nanda
 * @date 10-09-2022
 * @description Used define the steps to be scenarios to be performed in Search Hotel Step (TC_2 Step)
 *
 */
public class TC2_SearchHotelStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

@Then("User should search hotel by entering all fields {string},{string},{string},{string},{string},{string},{string} and {string}")
public void user_should_search_hotel_by_entering_all_fields_and(String location, String hotels, String roomType, String noOfRooms, String checkIn, String checkOut, String aduldPerRoom, String childPerRoom) {
	pom.getSearchHotelPage().search(location, hotels, roomType, noOfRooms, checkIn, checkOut, aduldPerRoom, childPerRoom);
}

@Then("User should verify the success message after search hotel {string}")
public void user_should_verify_the_success_message_after_search_hotel(String sucessMessage) {
	Assert.assertEquals("Verifiyin success msg after search hotel page", pom.getSelectHotelPage().getBookHotelSearchMsg().getText(), sucessMessage);
}

@Then("User should search hotel by entering only mandatory fields {string},{string},{string},{string} and {string}")
public void user_should_search_hotel_by_entering_only_mandatory_fields_and(String location, String hotels, String roomType, String checkIn, String checkOut) {
	pom.getSearchHotelPage().search(location, hotels, roomType, checkIn, checkOut);
}

@Then("User should verify the error message {string} and {string}")
public void user_should_verify_the_error_message_and(String errCheckIn, String errCheckOut) {
	Assert.assertEquals("Verify checkIn err message", pom.getSearchHotelPage().getCheckInSpan().getText(), errCheckIn);
	Assert.assertEquals("Verify checkOut err message", pom.getSearchHotelPage().getCheckOutSpan().getText(), errCheckOut);
}

@Then("User should click on the search button without entering any fields")
public void user_should_click_on_the_search_button_without_entering_any_fields() {
	pom.getSearchHotelPage().search();
}

@Then("User should verify the error message {string}")
public void user_should_verify_the_error_message(String errLocation) {
	Assert.assertEquals("Verify location error message", pom.getSearchHotelPage().getEnterLocationError().getText(), errLocation);
	
}

}
