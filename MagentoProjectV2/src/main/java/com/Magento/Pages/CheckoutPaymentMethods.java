package com.Magento.Pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.Magento.Browser.ProjectBrowser;
import com.Magento.Locators.CheckoutPaymentObjects;
import com.Magento.Screenshot.ScreenshotCapture;
import com.aventstack.extentreports.Status;

public class CheckoutPaymentMethods extends ProjectBrowser {
	static CheckoutPaymentObjects obj;
	
//	Method for clicking Shopping Cart button
	public static void clickShoppingCart() {
		obj = new CheckoutPaymentObjects();

		try {
			wait.until(ExpectedConditions.visibilityOf(obj.showCartButtonElement));
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			Thread.sleep(2000);
			obj.showCartButtonElement.click();
//			js.executeScript("arguments[0].click();", obj.showCartButtonElement);
		} catch (Exception e) {
			System.out.println("Click Shopping Cart method Exception: " + e);
		}
	}

//	Method for clicking Proceed to Checkout button
	public static void clickCheckoutButton() {
		try {
			wait.until(ExpectedConditions.visibilityOf(obj.checkOutButtonElement));
//			obj.checkOutButtonElement.click();
			js.executeScript("arguments[0].click();", obj.checkOutButtonElement);
		} catch (Exception e) {
			System.out.println("Click Checkout method Exception: " + e);
		}
	}

//	Method to verify Shipping Address Title 
	public static void shippingAddressTitleVerification() {
		try {
			wait.until(ExpectedConditions.visibilityOf(obj.shippingAddressTitleElement));
		} catch (Exception e) {
			System.out.println("Shipping Address Title method Exception: " + e);
		}
	}
	
	
//	Method to enter Company details
	public static void company(String str) {
		try {
			wait.until(ExpectedConditions.visibilityOf(obj.companyElement));
			obj.companyElement.sendKeys(str);
		} catch (Exception e) {
			System.out.println("Company method Exception: " + e);
		}
	}
	
//	Method to enter Address details 1
	public static void address1(String str) {
		try {
			wait.until(ExpectedConditions.visibilityOf(obj.address1Element));
			obj.address1Element.sendKeys(str);
		} catch (Exception e) {
			System.out.println("Address 1 method Exception: " + e);
		}
	}

//	Method to enter Address details 2
	public static void address2(String str) {
		try {
			wait.until(ExpectedConditions.visibilityOf(obj.address2Element));
			obj.address2Element.sendKeys(str);
		} catch (Exception e) {
			System.out.println("Address 2 method Exception: " + e);
		}
	}

//	Method to enter Address details 3
	public static void address3(String str) {
		try {
			wait.until(ExpectedConditions.visibilityOf(obj.address3Element));
			obj.address3Element.sendKeys(str);
		} catch (Exception e) {
			System.out.println("Address 3 method Exception: " + e);
		}
	}

//	Method to enter City details
	public static void city(String str) {
		try {
			wait.until(ExpectedConditions.visibilityOf(obj.cityElement));
			obj.cityElement.sendKeys(str);
		} catch (Exception e) {
			System.out.println("City method Exception: " + e);
		}
	}
	
//	Method to enter Postal Code details (Incorrect)
	public static void incorrectPostalCode(String str) {
		try {
			wait.until(ExpectedConditions.visibilityOf(obj.postalCodeElement));
			obj.postalCodeElement.sendKeys(str);
		} catch (Exception e) {
			System.out.println("Incorrect Postal Code method Exception: " + e);
		}
	}
	
	
//	Method to select Country from the Dropdown	
	public static void country(String str) {
		try {
			wait.until(ExpectedConditions.visibilityOf(obj.countryBoxElement));
			obj.countryBoxElement.click();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfAllElements(obj.countryListElement));
			for (WebElement country : obj.countryListElement) {
				if (country.getText().equalsIgnoreCase(str)) {
					country.click();
					break;
				}

			}
		} catch (Exception e) {
			System.out.println("Country method Exception: " + e);
		}
	}

//	Method to select Region from the Dropdown
	public static void region(String str) {
		try {
			wait.until(ExpectedConditions.visibilityOf(obj.regionBoxElement));
			obj.regionBoxElement.click();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfAllElements(obj.regionListElement));
			for (WebElement region : obj.regionListElement) {
				if (region.getText().equalsIgnoreCase(str)) {
					region.click();
					break;
				}

			}
		} catch (Exception e) {
			System.out.println("Region method Exception: " + e);
		}
	}
	
	
//	Method to enter Phone Number details
	public static void phone(String str) {
		try {
			wait.until(ExpectedConditions.visibilityOf(obj.phoneElement));
			obj.phoneElement.sendKeys(str);
		} catch (Exception e) {
			System.out.println("Phone Number method Exception: " + e);
		}
	}

//	Method to display Error Message while giving incorrect Postal Code
	public static void errorMsgVerification(String str) {
		logger1 = extent.createTest("Zip/Postal Code Error Message");
		logger1.log(Status.INFO, "To check whether Zip/Postal Code Error Message is displayed");
		try {
			wait.until(ExpectedConditions.visibilityOf(obj.errorMessage));
			String errorMsg = obj.errorMessage.getText();
//			Assert.assertEquals(cartMsgConfirm, cartMsgConfirm.contains(str));
			Assert.assertTrue(errorMsg.contains(str), errorMsg);
			logger1.log(Status.PASS, "Zip/Postal Code Error Message is displayed Successfully");
		} catch (Exception e) {
			System.out.println("Error Message method Exception: " + e);
			logger1.log(Status.FAIL, "Zip/Postal Code Error Message is not displayed, exception thrown");
		}
	}

//	Method to enter Postal Code details (Corrected)
	public static void correctPostalCode(String str) {
		try {
			wait.until(ExpectedConditions.visibilityOf(obj.postalCodeElement));
			obj.postalCodeElement.clear();
			obj.postalCodeElement.sendKeys(str);
		} catch (Exception e) {
			System.out.println("Correct Postal Code method Exception: " + e);
		}
	}
	
	
//	Method to click on the Shipping Radio Button when Country India is selected
	public static void shippingIndiaRadioButton() {
		try {
			wait.until(ExpectedConditions.visibilityOf(obj.shipMethodIndiaRBElement));
			obj.shipMethodIndiaRBElement.clear();
			js.executeScript("arguments[0].click();", obj.shipMethodIndiaRBElement);
		} catch (Exception e) {
			System.out.println("Shipping (India) Radio Button method Exception: " + e);
		}
	}
	
//	Method to click on the Next Button
	public static void clickNextButton() {
		try {
			wait.until(ExpectedConditions.visibilityOf(obj.nextButtonElement));
//			obj.nextButtonElement.click();
			js.executeScript("arguments[0].click();", obj.nextButtonElement);
		} catch (Exception e) {
			System.out.println("Click Next Button method Exception: " + e);
		}
	}

//	PROCEED TO PAYMENT PAGE 

//	Method to click on the Place Order Button
	public static void clickPlaceOrder() {
		try {
			wait.until(ExpectedConditions.visibilityOf(obj.paymentMethodTitleElement));
			js.executeScript("arguments[0].scrollIntoView(true);", obj.placeOrderButtonElement);
			wait.until(ExpectedConditions.visibilityOf(obj.placeOrderButtonElement));
			js.executeScript("arguments[0].click();", obj.placeOrderButtonElement);
//			obj.placeOrderButtonElement.click();
		} catch (Exception e) {
			System.out.println("Click Place Order Button method Exception: " + e);
		}
	}

//	Method to verify that Confirm Order placed message is displayed	
	public static void confirmOrderPlacedMsgVerification(String str) {
		logger1 = extent.createTest("Checkout and Order Placed Test");
		logger1.log(Status.INFO, "To check whether Checkout is done and Order is placed");
		try {
			wait.until(ExpectedConditions.visibilityOf(obj.confirmOrderPlacedMessage));
			String confirmMsg = obj.confirmOrderPlacedMessage.getText();
//			Assert.assertEquals(cartMsgConfirm, cartMsgConfirm.contains(str));
			Assert.assertTrue(confirmMsg.contains(str), confirmMsg);
			logger1.log(Status.PASS, "Checkout is done and Order placed Successfully");
			logger1.addScreenCaptureFromPath(ScreenshotCapture.takeScreenShot("CheckoutOrderPlaced"));
		} catch (Exception e) {
			System.out.println("Confirm Order Placed Message method Exception: " + e);
			logger1.log(Status.FAIL, "Checkout is not done, exception thrown");
		}
	}

}
