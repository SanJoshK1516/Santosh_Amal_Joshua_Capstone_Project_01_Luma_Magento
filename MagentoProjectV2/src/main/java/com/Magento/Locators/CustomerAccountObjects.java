package com.Magento.Locators;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Magento.Browser.ProjectBrowser;

public class CustomerAccountObjects extends ProjectBrowser {

//	Constructor for PageFactory Object Initialization
	public CustomerAccountObjects() {
		PageFactory.initElements(driver, this);
	}
	
//	Locators for Customer Account
	
	@FindBy(xpath = "//input[@id = 'firstname']")
	public WebElement firstNameElement;
	
	@FindBy(xpath = "//input[@id = 'lastname']")
	public WebElement lastNameElement;
	
	@FindBy(xpath = "//input[@id = 'email_address']")
	public WebElement emailElement;
	
	@FindBy(xpath = "//input[@id = 'password']")
	public WebElement passwordElement;
	
	@FindBy(xpath = "//input[@id = 'password-confirmation']")
	public WebElement confirmPasswordElement;
	
	@FindBy(xpath = "//button[@title='Create an Account']")
	public WebElement createAccountElement;
	
	@FindBy(xpath = "//div[@id='email_address-error']")
	public WebElement errorElement;
	

}
