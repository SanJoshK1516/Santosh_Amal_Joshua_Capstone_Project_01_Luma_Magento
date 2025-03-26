package com.Magento.Pages;

import org.openqa.selenium.support.ui.ExpectedConditions;

import com.Magento.Browser.ProjectBrowser;
import com.Magento.Locators.MyAccountObjects;
import com.Magento.Screenshot.ScreenshotCapture;
import com.aventstack.extentreports.Status;

public class MyAccountMethods extends ProjectBrowser {
	
	static MyAccountObjects obj;
	
//	Method to verify whether User Successfully Registered message displays
	public static String registrationText() {
		String text = null;
		obj = new MyAccountObjects();
		logger1 = extent.createTest("Verifying Successful Registration Message during Create Account");
		logger1.log(Status.INFO, "Verifying Successful Registration Message");
		try {
			wait.until(ExpectedConditions.visibilityOf(obj.registrationTextElement));
			text = obj.registrationTextElement.getText();
			logger1.log(Status.PASS, "Expected and Actual parameters Match for Registration Message");
			logger1.addScreenCaptureFromPath(ScreenshotCapture.takeScreenShot("SuccessRegistrationMessage"));
		} catch (Exception e) {
			System.out.println("My Account Text Exception: " + e);
			logger1.log(Status.FAIL, "Expected and Actual parameters did not Match");
		}
		return text;
	}
	

}
