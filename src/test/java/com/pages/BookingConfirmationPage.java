package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
/**
 * 
 * @author Nanda
 * @date 10-09-2022
 * @description Used to maintain all the locators for indirect use and it is called as POJO class for Booking confirmation page
 *
 */
public class BookingConfirmationPage extends BaseClass {
	public BookingConfirmationPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="order_no")
	private WebElement orderNUmber;

	@FindBy(className = "login_title")//"//td[@class='login_title']"
	private WebElement txtBookingConfirmation;


	public WebElement getTxtBookingConfirmation() {
		return txtBookingConfirmation;
	}


	public WebElement getOrderNUmber() {
		return orderNUmber;
	}

	public String getBookedOrderId() {
		String value = getValue(getOrderNUmber());
		return value;

	}


}
