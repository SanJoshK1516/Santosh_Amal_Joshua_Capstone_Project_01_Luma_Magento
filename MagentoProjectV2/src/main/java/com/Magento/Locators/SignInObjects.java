package com.Magento.Locators;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Magento.Browser.ProjectBrowser;

public class SignInObjects extends ProjectBrowser {
	
//	Constructor for PageFactory Object Initialization
	public SignInObjects() {
		PageFactory.initElements(driver, this);
	}
	
//	Locators for Sign In
	
	@FindBy(xpath = "//input[@id = 'email']")
	public WebElement emailElement;
	
	@FindBy(xpath = "//input[@id = 'pass']")
	public WebElement passwordElement;
	
	@FindBy(xpath = "//button[@class = 'action login primary']")
	public WebElement signInElement;
	
	@FindBy(xpath = "//div[@data-bind = 'html: $parent.prepareMessageForHtml(message.text)']")
	public WebElement errorElement;
	
}
