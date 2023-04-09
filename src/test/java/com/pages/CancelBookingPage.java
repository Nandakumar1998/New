package com.pages;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	import com.base.BaseClass;
	/**
	 * 
	 * @author Nanda
	 * @date 10-09-2022
	 * @description Used to maintain all the locators for indirect use and it is called as POJO class for Cancel booking page
	 *
	 */
	public class CancelBookingPage extends BaseClass {

		
		public CancelBookingPage() {
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(id="my_itinerary")
		private WebElement btnItinerary;
				
		@FindBy(id="order_id_text")               //search box
		private WebElement txtOrderId;
		
		@FindBy(id="search_hotel_id")            //click go
		private WebElement btnSearchHotel;
		
		@FindBy(name="ids[]")
		private WebElement btnSelect;
		
		@FindBy(xpath = "(//input[@style = 'width:150px;'])[1]")
		private WebElement btncancel;
		
		@FindBy(id ="search_result_error")
		private WebElement txtBookkingCancelled;
		
		@FindBy(xpath= "//a[contains(text(),'Booked Itinerary')]")
		private WebElement btnBookedItineary;
		
	

		public WebElement getBtnBookedItineary() {
			return btnBookedItineary;
		}

		public WebElement getBtnItinerary() {
			return btnItinerary;
		}
		
		public WebElement getTxtOrderId() {
			return txtOrderId;
		}

		public WebElement getBtnSearchHotel() {
			return btnSearchHotel;
		}

		public WebElement getBtnSelect() {
			return btnSelect;
		}

		public WebElement getBtncancel() {
			return btncancel;
		}
		


		public void cancelBooking(String orderId) {
			btnClick(btnBookedItineary);
			
			elementsendKeys(getTxtOrderId(),orderId);
			btnClick(btnSearchHotel);
			btnClick(btnSelect);
			btnClick(btncancel);
			//btnClick(btnBookedItineary);
			alertBox();
			System.out.println("Cancelled order id: "+orderId);
	
		
		
}

		public WebElement getTxtBookkingCancelled() {
			return txtBookkingCancelled;
		}
	}
