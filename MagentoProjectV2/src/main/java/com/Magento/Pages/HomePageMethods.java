package com.Magento.Pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.Magento.Browser.ProjectBrowser;
import com.Magento.Locators.HomePageObjects;
import com.aventstack.extentreports.Status;

public class HomePageMethods extends ProjectBrowser{

	static HomePageObjects obj;
	
	
//	Method to click on Create New Account Button
	public static void clickCreatenewAccount() {
		obj = new HomePageObjects();
		try {
			wait.until(ExpectedConditions.visibilityOf(obj.createNewAccountLinkElement));
			obj.createNewAccountLinkElement.click();
		} catch (Exception e) {
			System.out.println("Create new Account Method Exception: " + e);
		}
	}
	
	
//	Method to click on Sign In Button 
	public static void clickSignIn() {
		obj = new HomePageObjects();
//		latest comment object initialization 21_03_2025 (Recovered)
		try {
			wait.until(ExpectedConditions.visibilityOf(obj.signInLinkElement));
			obj.signInLinkElement.click();
		}  catch (Exception e) {
			System.out.println("Sign In Method Exception: " + e);
		}
	}
	
//	Method to verify whether Home Page Text is displayed
	public static String homePageText() {
		obj = new HomePageObjects();
//		latest comment object initialization 21_03_2025 (Recovered)
		String text = null;
		logger1 = extent.createTest("Display Home Page Text");
		logger1.log(Status.INFO, "To check whether Home Page Text is displayed");
		
		try {
			wait.until(ExpectedConditions.visibilityOf(obj.homePageTextElement));
			obj.homePageTextElement.getText();
			Assert.assertEquals(obj.homePageTextElement.getText(), "Home Page");
			logger1.log(Status.PASS, "Homepage displayed Successfully");
		}catch (Exception e) {
			System.out.println("Homepage Text Exception: " + e);
			logger1.log(Status.FAIL, "Homepage is not displayed");
		}
		return text;
	}
	
}
