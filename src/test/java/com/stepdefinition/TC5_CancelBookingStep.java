package com.stepdefinition;

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
 * @description Used define the steps to be scenarios to be performed in Cancel booking Step (TC_5 Step)
 *
 */
public class TC5_CancelBookingStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

@Then("User should cancel booked hotel with the generated order id")
public void user_should_cancel_booked_hotel_with_the_generated_order_id() {
	String orderIdToget = getValue(pom.getBookingConfirmationPage().getOrderNUmber());
    pom.getCancelBookingPage().cancelBooking(orderIdToget);
}

@Then("User should verify the success message after cancel booking {string}")
public void user_should_verify_the_success_message_after_cancel_booking(String bookingCancelledBooking) {
	Assert.assertEquals("verify sucess msg after cancelbooking", pom.getCancelBookingPage().getTxtBookkingCancelled().getText(), bookingCancelledBooking);
}

@Then("User should cancel booked hotel with existing order id {string}")
public void user_should_cancel_booked_hotel_with_existing_order_id(String existingOrderId) {
	pom.getCancelBookingPage().cancelBooking(existingOrderId);
}

}
