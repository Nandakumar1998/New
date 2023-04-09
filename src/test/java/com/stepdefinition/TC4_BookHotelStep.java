package com.stepdefinition;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;
/**
 * 
 * @author Nanda
 * @date 10-09-2022
 * @description Used define the steps to be scenarios to be performed in Book Hotel Step (TC_4 Step)
 *
 */
public class TC4_BookHotelStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

@Then("User should book a hotel by entering all the required fields {string},{string} and {string}")
public void user_should_book_a_hotel_by_entering_all_the_required_fields_and(String fName, String lName, String address, io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
	            List<Map<String, String>> asMaps = dataTable.asMaps();
	            Map<String, String> map = asMaps.get(1);
	            String ccNo = map.get("cardNo");
	            String ccType = map.get("cardType");
	            String ccExpM = map.get("expMonth");
	            String ccExpY = map.get("expYear");
	            String ccCvv = map.get("cvv");
	            	            
	pom.getBookHotelPage().bookNow(fName, lName, address, ccNo, ccType, ccExpM, ccExpY, ccCvv);
}

@Then("User should verify the success message after book a hotel {string}")
public void user_should_verify_the_success_message_after_book_a_hotel(String txtSucessBookinConfirm) throws InterruptedException {
	Thread.sleep(10000);
	Assert.assertEquals("Verify the booking confirmation message ", pom.getBookingConfirmationPage().getTxtBookingConfirmation().getText(),txtSucessBookinConfirm);
   
}

@Then("User should click on book now without entering any fields")
public void user_should_click_on_book_now_without_entering_any_fields() {
	pom.getBookHotelPage().bookNow();
}

@Then("User should verify the error message {string},{string},{string},{string},{string},{string} and {string}")
public void user_should_verify_the_error_message_and(String sFname, String sLname, String sAddress, String sCCNum, String sCCType, String sCCMonthandYear, String sCVV) {
	Assert.assertEquals("Verifing first name error msg ", pom.getBookHotelPage().getTxtFnameSpan().getText(), sFname);
	Assert.assertEquals("Verifing last name error msg ", pom.getBookHotelPage().getTxtLnameSpan().getText(), sLname);
	Assert.assertEquals("Verifing address  error msg ", pom.getBookHotelPage().getTxtAddressSpan().getText(), sAddress);
	Assert.assertEquals("Verifing card num  error msg ", pom.getBookHotelPage().getTxtCCnumSpan().getText(), sCCNum);
	Assert.assertEquals("Verifing card type error msg ", pom.getBookHotelPage().getTxtCCtypeSpan().getText(), sCCType);
	Assert.assertEquals("Verifing exp month and year error msg ", pom.getBookHotelPage().getTxtCCexpAndMonthSpan().getText(), sCCMonthandYear);
	Assert.assertEquals("Verifing cvv error msg ", pom.getBookHotelPage().getTxtCVVspan().getText(), sCVV);
}


}
