package com.Magento.StepDefinitions;

import org.testng.Assert;

import com.Magento.Pages.HomePageMethods;
import com.Magento.Pages.SignInMethods;
import com.Magento.Screenshot.ScreenshotCapture;
import com.aventstack.extentreports.Status;
import com.Magento.Browser.ProjectBrowser;

import io.cucumber.java.en.*;

public class LoginValidInvalidSD extends ProjectBrowser {
	@And("User enters invalid {string} in the Email Textbox")
	public void user_enters_invalid_in_the_email_textbox(String str) {
		SignInMethods.signInEmail(str);
	}

	@And("User enters invalid {string} in the Password Textbox")
	public void user_enters_invalid_in_the_password_textbox(String str) {
		SignInMethods.signInPassword(str);
	}

	@Then("User verifies the {string} message displayed after clicking Sign In Button")
	public void user_verifies_the_message_displayed_after_clicking_sign_in_button(String str) {
		try {
			logger1 = extent.createTest("Display Error Message after clicking Sign In button");
			logger1.log(Status.INFO, "To check whether an Error Message is displayed after clicking Sign In button");
			
			Assert.assertEquals(SignInMethods.signInErrorMessage(), str);
			logger1.log(Status.PASS, "Expected and Actual parameters Match for Error Message");
			logger1.addScreenCaptureFromPath(ScreenshotCapture.takeScreenShot("ErrorMsgForInvalidCredentials"));
		} catch (Exception e) {
			System.out.println("Error message exception: " + e);
			logger1.log(Status.FAIL, "Error Message not shown, exception thrown");
		}
	}

	@And("User clicks SignIn actual button")
	public void user_clicks_sign_in_actual_button() {
		SignInMethods.clickToSignIn();

	}

	@When("User re-enters the valid {string} in Email Textbox")
	public void user_re_enters_the_valid_in_email_textbox(String valid) {
		SignInMethods.signInEmail(valid);
	}

	@And("User re-enters the valid {string} in Password Textbox")
	public void user_re_enters_the_valid_in_password_textbox(String valid) {
		SignInMethods.signInPassword(valid);
	}

	@Then("User verifies Home Page is displayed after clicking Sign In button")
	public void user_verifies_home_page_is_displayed_after_clicking_sign_in_button() {
		HomePageMethods.homePageText();
		System.out.println("Navigated to the Home Page");
	}

}
