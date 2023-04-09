package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
/**
 * 
 * @author Nanda
 * @date 10-09-2022
 * @description Used to maintain all the locators for indirect use and it is called as POJO class for Select hotel page
 *
 */
public class SelectHotelPage extends BaseClass {
	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="radiobutton_0")
	private WebElement btnRadio;

	@FindBy(id="continue")
	private WebElement btnContinue;
	
	@FindBy(className = "login_title")
    private WebElement bookHotelSearchMsg;
	
	@FindBy(id = "radiobutton_span")
	private WebElement txtRadioSpan;
	

	public WebElement getTxtRadioSpan() {
		return txtRadioSpan;
	}

	public WebElement getBookHotelSearchMsg() {
		return bookHotelSearchMsg;
	}

	public WebElement getBtnRadio() {
		return btnRadio;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}
	//1-Verifying Adactin select hotel page by selecting a hotel name
	public void next() {
		btnClick(getBtnRadio());
		btnClick(getBtnContinue());
	}
	//2-Verifying Adactin select hotel page without selecting any hotel
	public void next1() {
		btnClick(getBtnContinue());
	}
}
