package com.Magento.Locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.Magento.Browser.ProjectBrowser;

public class CheckoutPaymentObjects extends ProjectBrowser {
	
//	Constructor for PageFactory Object Initialization
	public CheckoutPaymentObjects() {
		PageFactory.initElements(driver, this);
	}
	
//	Locators for Checkout and Payment
	
//	@FindBy(xpath = "//span[text()='My Account']")
//	public WebElement myAccountTextElement;

	@FindBy(xpath = "//a[@class='action showcart']")
	public WebElement showCartButtonElement;

	@FindBy(xpath = "//button[@id='top-cart-btn-checkout']")
	public WebElement checkOutButtonElement;
	
	@FindBy(xpath = "//div[text() = 'Shipping Address']")
	public WebElement shippingAddressTitleElement;

//	CHECKOUT DETAILS 
	@FindBy(xpath = "//input[@name='company']")
	public WebElement companyElement;

	@FindBy(xpath = "//input[@name='street[0]']")
	public WebElement address1Element;

	@FindBy(xpath = "//input[@name='street[1]']")
	public WebElement address2Element;

	@FindBy(xpath = "//input[@name='street[2]']")
	public WebElement address3Element;

	@FindBy(xpath = "//input[@name='city']")
	public WebElement cityElement;

	@FindBy(xpath = "//select[@name='region_id']")
	public WebElement regionBoxElement;
	
	@FindBy(xpath = "//select[@name='region_id']/option")
	public List<WebElement> regionListElement;
	
	@FindBy(xpath = "//div[@class = 'message warning']/span")
	public WebElement errorMessage;
	
	@FindBy(xpath = "//input[@name='postcode']")
	public WebElement postalCodeElement;

	@FindBy(xpath = "//select[@name='country_id']")
	public WebElement countryBoxElement;
	
	@FindBy(xpath = "//select[@name='country_id']/option")
	public List<WebElement> countryListElement;

	@FindBy(xpath = "//input[@name='telephone']")
	public WebElement phoneElement;

	@FindBy(xpath = "//input[@name='ko_unique_1']")
	public WebElement shipMethod1RBElement;

	@FindBy(xpath = "//input[@name='ko_unique_2']")
	public WebElement shipMethod2RBElement;

	@FindBy(xpath = "//input[@name='ko_unique_5']")
	public WebElement shipMethodIndiaRBElement;

	@FindBy(xpath = "//button[@class='button action continue primary']")
	public WebElement nextButtonElement;

//	PLACE ORDER PAGE
	@FindBy(xpath = "//div[text()='Payment Method']")
	public WebElement paymentMethodTitleElement;

//	@FindBy(xpath = "//button[@title='Place Order']")
	@FindBy(xpath = "//button/span[text() = 'Place Order']")
	public WebElement placeOrderButtonElement;
	
	@FindBy(xpath = "//span[text()='Thank you for your purchase!']")
	public WebElement confirmOrderPlacedMessage;

}
