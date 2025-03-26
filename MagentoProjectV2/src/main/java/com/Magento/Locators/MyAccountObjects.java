package com.Magento.Locators;
import org.openqa.selenium.*;
import java.util.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Magento.Browser.ProjectBrowser;

public class MyAccountObjects extends ProjectBrowser{
//	Constructor for PageFactory Object Initialization
	public MyAccountObjects() {
		PageFactory.initElements(driver, this);
	}
	
//	Locators for My Account
	
	@FindBy(xpath = "//span[@data-ui-id='page-title-wrapper']")
	public WebElement myAccountTextElement;
	
	@FindBy(xpath = "//input[@id='search']")
	public WebElement searchBoxElement;
	
	@FindBy(xpath = "//ul[@role='listbox']/li")
	public List <WebElement> searchList;
	
	@FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	public WebElement registrationTextElement;

}
