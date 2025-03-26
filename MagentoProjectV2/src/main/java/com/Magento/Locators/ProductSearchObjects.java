package com.Magento.Locators;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import com.Magento.Browser.ProjectBrowser;
import java.util.*;

import org.openqa.selenium.support.PageFactory;

public class ProductSearchObjects extends ProjectBrowser {
	
//	Constructor for PageFactory Object Initialization
	public ProductSearchObjects() {
		PageFactory.initElements(driver, this);
	}
	
	
//	Locators for Product Search
	
	@FindBy(xpath = "//form[@class='form minisearch']")
	public WebElement clickSearchElement;
	
	@FindBy(xpath = "//input[@id = 'search']")
	public WebElement searchElement;
	
	@FindBy (xpath = "//ul[@role='listbox']/li/span")
	public List<WebElement> searchAutoSuggestElement;

}
