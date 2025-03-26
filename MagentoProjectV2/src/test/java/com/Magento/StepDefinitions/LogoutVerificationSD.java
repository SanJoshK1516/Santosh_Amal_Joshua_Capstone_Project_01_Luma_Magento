package com.Magento.StepDefinitions;

//import org.testng.Assert;

import com.Magento.Pages.HomePageMethods;
import com.Magento.Pages.SignInMethods;
import com.Magento.Pages.SignOutMethods;

import io.cucumber.java.en.*;

public class LogoutVerificationSD {
	
	@When("User enters the valid {string} in Email Textbox and valid {string} in Password Textbox")
	public void user_enters_the_valid_in_email_textbox_and_valid_in_password_textbox(String string, String string2) {
		SignInMethods.signInEmail(string);
		SignInMethods.signInPassword(string2);
	}
	

	@When("User clicks the Dropdown and clicks Sign Out button beside the Username")
	public void user_clicks_the_dropdown_and_clicks_sign_out_button_beside_the_username() {
	    SignOutMethods.dropDownClick();
	    SignOutMethods.clickToSignOut();
	}

	@Then("User verifies Sign out {string}")
	public void user_verifies_sign_out(String string) {
		SignOutMethods.signOutText();
	    System.out.println("User verifies Signout");
	}

	@Then("User verifies the  {string}")
	public void user_verifies_the(String string) {
		HomePageMethods.homePageText();
		System.out.println("User verifies Homepage Message");
	}
	

}
