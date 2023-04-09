package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
/**
 * 
 * @author Nanda
 * @date 10-09-2022
 * @description Used to maintain all the locators for indirect use and it is called as POJO class for Login page
 *
 */
public class LoginPage extends BaseClass {
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="username")
	private WebElement txtUserName;

	@FindBy(id="password")
	private WebElement txtPassword;

	@FindBy(id="login")
	private WebElement btnLogin;
	
	@FindBy(xpath = "//b[contains(text(),'Invalid ')]")
	private WebElement textErrorLoginPage;
	
	public WebElement getTextErrorLoginPage() {
		return textErrorLoginPage;
	}

	//get the getters only
	public WebElement getTxtUserName() {
		return txtUserName;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}
	//creating
	public void login(String username, String password) {
		elementsendKeys(getTxtUserName(), username);
		elementsendKeys(getTxtPassword(), password);
		btnClick(getBtnLogin());		

	}
	public void loginByEnterKey(String username, String password) throws AWTException {
		elementsendKeys(getTxtUserName(), username);
		elementsendKeys(getTxtPassword(), password);

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}
}
