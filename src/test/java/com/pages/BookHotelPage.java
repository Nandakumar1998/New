package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
/**
 * 
 * @author Nanda
 * @date 10-09-2022
 * @description Used to maintain all the locators for indirect use and it is called as POJO class for BookHotelpage
 *
 */
public class BookHotelPage extends BaseClass {
	public BookHotelPage() {
		 PageFactory.initElements(driver, this);
	}
	@FindBy(id="first_name")
	private WebElement txtFname;
	
	@FindBy(id="last_name")
	private WebElement txtLname;
	
	@FindBy(id="address")
	private WebElement txtAdress;
	
	@FindBy(id="cc_num")
	private WebElement CreditCardnum;
	
	@FindBy(id="cc_type")
	private WebElement dDnCardType;
	
	@FindBy(id="cc_exp_month")
	private WebElement dDnCardExpMonth;
	
	@FindBy(id="cc_exp_year")
	private WebElement dDnCardExpYear;
	
	@FindBy(id="cc_cvv")
	private WebElement dDnCardCVV;
	
	@FindBy(id="book_now")
	private WebElement btnBookNow;
	
	@FindBy(xpath= "(//td[@class='login_title'])[2]")
	private WebElement txtBookAHotel;
	
	@FindBy(id= "first_name_span")
	private WebElement txtFnameSpan;
	
	@FindBy(id = "last_name_span")
	private WebElement txtLnameSpan;
	
	@FindBy(id = "address_span")
	private WebElement txtAddressSpan;
	
	@FindBy(id = "cc_num_span")
	private WebElement txtCCnumSpan;
	
	@FindBy(id = "cc_type_span")
	private WebElement txtCCtypeSpan;
	
	@FindBy(id = "cc_expiry_span")
	private WebElement txtCCexpAndMonthSpan;
	
	@FindBy(id = "cc_cvv_span")
	private WebElement txtCVVspan;

	public WebElement getTxtFnameSpan() {
		return txtFnameSpan;
	}

	public WebElement getTxtLnameSpan() {
		return txtLnameSpan;
	}

	public WebElement getTxtAddressSpan() {
		return txtAddressSpan;
	}

	public WebElement getTxtCCnumSpan() {
		return txtCCnumSpan;
	}

	public WebElement getTxtCCtypeSpan() {
		return txtCCtypeSpan;
	}

	public WebElement getTxtCCexpAndMonthSpan() {
		return txtCCexpAndMonthSpan;
	}

	public WebElement getTxtCVVspan() {
		return txtCVVspan;
	}

	public WebElement getTxtBookAHotel() {
		return txtBookAHotel;
	}

	public WebElement getTxtFname() {
		return txtFname;
	}

	public WebElement getTxtLname() {
		return txtLname;
	}

	public WebElement getTxtAdress() {
		return txtAdress;
	}

	public WebElement getCreditCardnum() {
		return CreditCardnum;
	}

	public WebElement getdDnCardType() {
		return dDnCardType;
	}

	public WebElement getdDnCardExpMonth() {
		return dDnCardExpMonth;
	}

	public WebElement getdDnCardExpYear() {
		return dDnCardExpYear;
	}

	public WebElement getdDnCardCVV() {
		return dDnCardCVV;
	}

	public WebElement getBtnBookNow() {
		return btnBookNow;
	}
     //1-Verifying Adactin book hotel page by entering all fields
	public void bookNow(String Fname, String Lname, String BliingAddress, String CCNum, String CCType, String CCExpMonth, String CCExpYear, String CCCvv ) throws InterruptedException {
		elementsendKeys(getTxtFname(), Fname);
		elementsendKeys(getTxtLname(), Lname);
		elementsendKeys(getTxtAdress(), BliingAddress);
		elementsendKeys(getCreditCardnum(), CCNum);
		elementsendKeys(getdDnCardType(), CCType);
		elementsendKeys(getdDnCardExpMonth(), CCExpMonth);
		elementsendKeys(getdDnCardExpYear(), CCExpYear);
		elementsendKeys(getdDnCardCVV(), CCCvv);
		//btnClick(getBtnBookNow());
		getBtnBookNow().click();
	}
	//2-Verifying Adactin book hotel page without entering any fields

	public void bookNow() {
		btnClick(getBtnBookNow());
	}
}
