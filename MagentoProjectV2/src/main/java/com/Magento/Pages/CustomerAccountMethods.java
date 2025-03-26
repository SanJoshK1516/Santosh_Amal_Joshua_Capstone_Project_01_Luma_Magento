package com.Magento.Pages;

import org.openqa.selenium.support.ui.ExpectedConditions;

import com.Magento.Browser.ProjectBrowser;
import com.Magento.Locators.CustomerAccountObjects;
import com.Magento.Screenshot.ScreenshotCapture;
import com.aventstack.extentreports.Status;

public class CustomerAccountMethods extends ProjectBrowser {
	static CustomerAccountObjects obj;
	
//	Method to enter First Name
	public static void enterFirstName(String str) {
		obj = new CustomerAccountObjects();
		try {
			wait.until(ExpectedConditions.visibilityOf(obj.firstNameElement));
			obj.firstNameElement.sendKeys(str);
		} catch (Exception e) {
			System.out.println("Enter Firstname method Exception: " + e);
		}
	}

//	Method to enter Last Name
	public static void enterLastName(String str) {
		try {
			wait.until(ExpectedConditions.visibilityOf(obj.lastNameElement));
			obj.lastNameElement.sendKeys(str);
		} catch (Exception e) {
			System.out.println("Enter Lastname method Exception: " + e);
		}
	}
	
//	Method to enter Email
	public static void enterEmail(String str) {
		obj = new CustomerAccountObjects();
//		latest comment object initialization 21_03_2025 (Recovered)
		try {
			wait.until(ExpectedConditions.visibilityOf(obj.emailElement));
			obj.emailElement.clear();
			obj.emailElement.sendKeys(str);
		} catch (Exception e) {
			System.out.println("Enter Email method Exception: " + e);
		}
	}

//	Method to enter Password
	public static void enterPassword(String str) {
		try {
			wait.until(ExpectedConditions.visibilityOf(obj.passwordElement));
//			obj.passwordElement.sendKeys(str);
			js.executeScript("arguments[0].setAttribute('value',arguments[1]);", obj.passwordElement, str);
		} catch (Exception e) {
			System.out.println("Enter Password method Exception: " + e);
		}
	}
	
	
//	Method to enter Confirm Password
	public static void enterConfirmPassword(String str) {
		try {
			wait.until(ExpectedConditions.visibilityOf(obj.confirmPasswordElement));
//			obj.confirmPasswordElement.sendKeys(str);
			js.executeScript("arguments[0].setAttribute('value',arguments[1]);", obj.confirmPasswordElement, str);
		} catch (Exception e) {
			System.out.println("Enter Confirm Password method Exception: " + e);
		}
	}

//	Method to click Create Account
	public static void clickCreateAccount() {
		try {
			wait.until(ExpectedConditions.visibilityOf(obj.createAccountElement));
			js.executeScript("arguments[0].click()", obj.createAccountElement);
		} catch (Exception e) {
			System.out.println("Click Create Account method Exception: " + e);
		}
	}

//	Method to throw Error Message when an invalid Data is given
	public static String errorMessage() {
		String text = null;
		
		logger1 = extent.createTest("Throwing Error Message during Create Account");
		logger1.log(Status.INFO, "Verifying the Error Message Thrown");
		try {
			wait.until(ExpectedConditions.visibilityOf(obj.errorElement));
			text = obj.errorElement.getText();
			logger1.log(Status.PASS, "Expected and Actual parameters Match for Error Message");
			logger1.addScreenCaptureFromPath(ScreenshotCapture.takeScreenShot("CreateAccountErrorMessage"));
		} catch (Exception e) {
			System.out.println("Error Message Exception: " + e);
			logger1.log(Status.FAIL, "Expected and Actual parameters did not Match");
		}
		return text;
	}
	
	

}
