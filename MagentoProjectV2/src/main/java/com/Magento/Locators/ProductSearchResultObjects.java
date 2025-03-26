package com.Magento.Locators;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import com.Magento.Browser.ProjectBrowser;
import java.util.*;

import org.openqa.selenium.support.PageFactory;

public class ProductSearchResultObjects extends ProjectBrowser {
	
//	Constructor for PageFactory Object Initialization
	public ProductSearchResultObjects() {
		PageFactory.initElements(driver, this);
	}

//	Locators for Product Search Result 
	
	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[2]/ol/li")
	public List<WebElement> productsElement;

	@FindBy(xpath = "//div[@attribute-code='size']/div/div")
	public List<WebElement> sizeOptionsElement;

	@FindBy(xpath = "//div[contains(@class, 'swatch-option color')]")
	public List<WebElement> colorOptionsElement;

	@FindBy(xpath = "//input[@name='qty']")
	public WebElement quantityBoxElement;

	@FindBy(xpath = "//button[@id='product-addtocart-button']")
	public WebElement addToCartButtonElement;


	@FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	public WebElement cartMessageElement;
	
	
//	WEB ELEMENTS FOR MULTIPLE PRODUCTS 
	
	@FindBy(xpath = "//a[text()='shopping cart']")
	public WebElement shoppingCartButtonElement;
	
	@FindBy(xpath = "//span[text()='Shopping Cart']")
	public WebElement shoppingCartTitleElement;
	
	@FindBy(xpath = "//table[@id='shopping-cart-table']/tbody/tr/td/div/strong/a")
	public List<WebElement> selectedProductNamesElement;
	
	@FindBy(xpath = "//td[@data-th='Order Total']/strong/span")
	public WebElement orderTotalCostElement;

}
