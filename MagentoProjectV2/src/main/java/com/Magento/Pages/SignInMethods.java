package com.Magento.Pages;

import org.openqa.selenium.support.ui.ExpectedConditions;

import com.Magento.Browser.ProjectBrowser;
import com.Magento.Locators.SignInObjects;

public class SignInMethods extends ProjectBrowser {

	static SignInObjects obj;

//	Method to enter Email details for Sign In
	public static void signInEmail(String str) {
		obj = new SignInObjects();
		try {
			wait.until(ExpectedConditions.visibilityOf(obj.emailElement));
			obj.emailElement.clear();
			obj.emailElement.sendKeys(str);
		} catch (Exception e) {
			System.out.println("Enter Email method Exception: " + e);
		}
	}

//	Method to enter Password details for Sign In
	public static void signInPassword(String str) {
		obj = new SignInObjects();
//		latest comment object initialization 21_03_2025 (Recovered)
		try {
			wait.until(ExpectedConditions.visibilityOf(obj.passwordElement));
			obj.passwordElement.clear();
			obj.passwordElement.sendKeys(str);
		} catch (Exception e) {
			System.out.println("Enter Password method Exception: " + e);
		}
	}

//	Method to click the Sign In Button
	public static void clickToSignIn() {
		obj = new SignInObjects();
//		latest comment object initialization 21_03_2025 (Recovered)
		try {
			wait.until(ExpectedConditions.visibilityOf(obj.signInElement));
			js.executeScript("arguments[0].click()", obj.signInElement);
		} catch (Exception e) {
			System.out.println("Click Sign In method Exception: " + e);
		}
	}
	
//	Method to verify whether the Sign In Error Message is displayed
	public static String signInErrorMessage() {
		String text = null;
		try {
			wait.until(ExpectedConditions.visibilityOf(obj.errorElement));
			text = obj.errorElement.getText();
		} catch (Exception e) {
			System.out.println("Sign In Error Message Exception: " + e);
		}
		return text;
	}

}
