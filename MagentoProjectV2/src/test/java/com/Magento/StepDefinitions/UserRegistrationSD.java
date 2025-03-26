package com.Magento.StepDefinitions;

import org.testng.Assert;

import com.Magento.Browser.ProjectBrowser;
import com.Magento.Browser.ProjectUtility;
import com.Magento.Pages.CustomerAccountMethods;
import com.Magento.Pages.HomePageMethods;
import com.Magento.Pages.MyAccountMethods;
import com.aventstack.extentreports.Status;

import io.cucumber.java.en.*;

public class UserRegistrationSD extends ProjectBrowser {

	@Given("User opens the Browser")
	public void user_opens_the_browser() throws Exception {
		ProjectBrowser.openBrowser(ProjectUtility.properties("browser"));
	}

	@And("User navigates to the {string} Webpage")
	public void user_navigates_to_the_webpage(String str) {
		ProjectBrowser.navigateToUrl(str);
	}

	@When("User clicks Create an Account button")
	public void user_clicks_create_an_account_button() {
		HomePageMethods.clickCreatenewAccount();
	}

	@And("User enters the valid {string} in Firstname Textbox")
	public void user_enters_the_valid_in_firstname_textbox(String str) {
		CustomerAccountMethods.enterFirstName(str);
	}

	@And("User enters the valid {string} in Lastname Textbox")
	public void user_enters_the_valid_in_lastname_textbox(String str) {
		CustomerAccountMethods.enterLastName(str);
	}

	@And("User enters the invalid {string} in Email Textbox")
	public void user_enters_the_invalid_in_email_textbox(String str) {
		CustomerAccountMethods.enterEmail(str);
	}

	@And("User enters the valid {string} in Password Textbox")
	public void user_enters_the_valid_in_password_textbox(String str) {
		CustomerAccountMethods.enterPassword(str);

	}

	@And("User enters the valid {string} in ConfirmPassword Textbox")
	public void user_enters_the_valid_in_confirm_password_textbox(String str) {
		CustomerAccountMethods.enterConfirmPassword(str);
	}

	@And("User clicks the Create an Account button")
	public void user_clicks_the_create_an_account_button() {
		CustomerAccountMethods.clickCreateAccount();
	}

	@Then("User verifies the {string} message displayed under Email Textbox")
	public void user_verifies_the_message_displayed_under_email_textbox(String str) {
		try {
			Assert.assertEquals(CustomerAccountMethods.errorMessage(), str);
			
		} catch (Exception e) {
			System.out.println(e);
			
		}
	}

	@When("User re-enters the Email with valid data {string} in Email Textbox")
	public void user_re_enters_the_email_with_valid_data_in_email_textbox(String str) {
		CustomerAccountMethods.enterEmail(str);
	}

	@Then("User verifies Registration {string} in the next page")
	public void user_verifies_registration_in_the_next_page(String str) {
		try {
			Assert.assertEquals(MyAccountMethods.registrationText(), str);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
