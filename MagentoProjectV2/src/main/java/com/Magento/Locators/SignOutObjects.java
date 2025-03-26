package com.Magento.Locators;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Magento.Browser.ProjectBrowser;

public class SignOutObjects extends ProjectBrowser {
	
//	Constructor for PageFactory Object Initialization
	public SignOutObjects() {
		PageFactory.initElements(driver, this);
	}
	

//	Locators for Sign out
	
	@FindBy(xpath = "//button[@class='action switch']")
	public WebElement dropDownElement;
	
	@FindBy(xpath = "//li[@class = 'authorization-link']/a")
	public WebElement signOutElement;
	
	@FindBy(xpath = "//span[text()='You are signed out']")
	public WebElement signOutMessageElement;
}
