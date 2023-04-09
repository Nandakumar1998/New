package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
/**
 * 
 * @author Nanda
 * @date 10-09-2022
 * @description Used to maintain all the locators for indirect use and it is called as POJO class for Search hotel page
 *
 */
public class SearchHotelPage extends BaseClass {
	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "username_show")
	private WebElement txtHelloSuccesMsg;
	
	@FindBy(id="location")
	private WebElement dDnLocation;

	@FindBy(id="hotels")
	private WebElement dDnHotels;

	@FindBy(id= "room_type")
	private WebElement dDnRoomType;

	@FindBy(id = "room_nos")
	private WebElement dDnRoomNom;

	@FindBy(id="datepick_in")
	private WebElement txtCheckIn;

	@FindBy(id="datepick_out")
	private WebElement txtCheckOut;

	@FindBy(id="adult_room")
	private WebElement dDnAdultRoom;

	@FindBy(id="child_room")
	private WebElement dDnChildRoom;

	@FindBy(id="Submit")
	private WebElement btnSearch;
	
	
	@FindBy(id = "location_span")
	private WebElement enterLocationError;
	
	@FindBy(id = "checkin_span")
	private WebElement checkInSpan;
	
	@FindBy(id = "checkout_span")
	private WebElement checkOutSpan;
	
	public WebElement getEnterLocationError() {
		return enterLocationError;
	}

	public WebElement getCheckInSpan() {
		return checkInSpan;
	}

	public WebElement getCheckOutSpan() {
		return checkOutSpan;
	}

	public WebElement getdDnLocation() {
		return dDnLocation;
	}

	public WebElement getdDnHotels() {
		return dDnHotels;
	}

	public WebElement getdDnRoomType() {
		return dDnRoomType;
	}

	public WebElement getdDnRoomNom() {
		return dDnRoomNom;
	}

	public WebElement getTxtCheckIn() {
		return txtCheckIn;
	}

	public WebElement getTxtCheckOut() {
		return txtCheckOut;
	}

	public WebElement getdDnAdultRoom() {
		return dDnAdultRoom;
	}

	public WebElement getdDnChildRoom() {
		return dDnChildRoom;
	}

	public WebElement getBtnSearch() {
		return btnSearch;
	}
	public WebElement getTxtHelloSuccesMsg() {
		return txtHelloSuccesMsg;
	}
	//1-Verifying Adactin search hotels page by selecting all fields
	//3-Verifying Adactin search hotels page by entering invalid check in date
	public void search(String location, String hotel, String roomType, String noOfRoom, String checkIn, String checkOut, String adult, String child) {
		dropDown(dDnLocation, location);
		dropDown(dDnHotels, hotel);
		dropDown(dDnRoomType, roomType);
		dropDown(dDnRoomNom, noOfRoom);
		txtCheckIn.clear();
		elementsendKeys(txtCheckIn, checkIn);
		txtCheckOut.clear();
		elementsendKeys(txtCheckOut, checkOut);
		dropDown(dDnAdultRoom, adult);
		dropDown(dDnChildRoom, child);
		btnClick(btnSearch);
	}
	//2-Verifying Adactin search hotels page by selecting mandatory fields 
	public void search(String location, String hotel, String roomType, String checkIn, String checkOut ) {
		dropDown(dDnLocation, location);
		dropDown(dDnHotels, hotel);
		dropDown(dDnRoomType, roomType);
		elementsendKeys(txtCheckIn, checkIn);
		elementsendKeys(txtCheckOut, checkOut);
		btnClick(btnSearch);

	}
	//4-Verifying Adactin search hotels page by without selecting any input fields
	public void search() {
		btnClick(btnSearch);

	}

}
