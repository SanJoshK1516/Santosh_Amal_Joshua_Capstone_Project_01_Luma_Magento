package com.Magento.Pages;

import com.Magento.Browser.ProjectBrowser;
import com.Magento.Locators.SignOutObjects;
import com.Magento.Screenshot.ScreenshotCapture;
import com.aventstack.extentreports.Status;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SignOutMethods extends ProjectBrowser {

	static SignOutObjects obj;

//	Method to click the Dropdown Button beside the Username 
	public static void dropDownClick() {
		obj = new SignOutObjects();
		try {
			wait.until(ExpectedConditions.visibilityOf(obj.dropDownElement));
			wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			js.executeScript("arguments[0].click()", obj.dropDownElement);
		} catch (Exception e) {
			System.out.println("Dropdown Click Exception: " + e);
		}
	}

//	Method to click on Sign Out Button 
	public static void clickToSignOut() {
		obj = new SignOutObjects();
//		latest comment object initialization 21_03_2025 (Recovered)
		try {
			wait.until(ExpectedConditions.visibilityOf(obj.signOutElement));
			wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			js.executeScript("arguments[0].click()", obj.signOutElement);
		} catch (Exception e) {
			System.out.println("Sign Out click Exception: " + e);
		}
	}

//	Method to verify whether the Sign Out message is displayed and log it to the Extent Report
	public static String signOutText() {
		obj = new SignOutObjects();
//		latest comment object initialization 21_03_2025 (Recovered)
		String text = null;
		logger1 = extent.createTest("Signout Message Verification");
		logger1.log(Status.INFO, "Verifying the Signout Message Parameters");
		try {
			wait.until(ExpectedConditions.visibilityOf(obj.signOutMessageElement));
			obj.signOutMessageElement.getText();
			Assert.assertEquals(obj.signOutMessageElement.getText(), "You are signed out");
			logger1.log(Status.PASS, "Expected and Actual parameters Match for Signout Message");
			logger1.addScreenCaptureFromPath(ScreenshotCapture.takeScreenShot("SignOutMessage"));
		} catch (Exception e) {
			System.out.println("Sign out Message Method Exception: " + e);
			logger1.log(Status.FAIL, "Error Message not shown, exception thrown");
		}
		return text;
	}

}
