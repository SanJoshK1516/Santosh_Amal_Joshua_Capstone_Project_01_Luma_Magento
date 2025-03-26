package com.Magento.Locators;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Magento.Browser.ProjectBrowser;

public class HomePageObjects extends ProjectBrowser {
//	Constructor for PageFactory Object Initialization
	public HomePageObjects() {
		PageFactory.initElements(driver, this);
	}

//	Locators for Home Page

	@FindBy(xpath = "//div[@class='panel wrapper'] //ul[@class='header links']/li[2]/a")
	public WebElement signInLinkElement;

	@FindBy(xpath = "//div[@class='panel wrapper'] //ul[@class='header links']/li[3]/a")
	public WebElement createNewAccountLinkElement;

	@FindBy(xpath = "//span[text()='Home Page']")
	public WebElement homePageTextElement;

}
