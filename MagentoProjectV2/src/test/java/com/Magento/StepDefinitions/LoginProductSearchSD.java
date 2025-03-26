package com.Magento.StepDefinitions;

import java.util.*;

//import org.testng.Assert;

import com.Magento.Excel.DataFromExcel;
import com.Magento.Pages.HomePageMethods;
import com.Magento.Pages.ProductSearchMethods;
import com.Magento.Pages.ProductSearchResultMethods;
import com.Magento.Pages.SignInMethods;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class LoginProductSearchSD {

	@When("User clicks Sign In button")
	public void user_clicks_sign_in_button() {
		HomePageMethods.clickSignIn();
	}

	@And("User enters the Login Credentials")
	public void user_enters_the_login_credentials(DataTable dataTable) {
		List<List<String>> credentials = DataFromExcel
				.dataFromExcel(System.getProperty("user.dir") 
				+ "\\src\\test\\resources\\ProjectExcelData.xlsx", 0);
		dataTable = DataTable.create(credentials);

		SignInMethods.signInEmail(dataTable.cell(1, 0));
		SignInMethods.signInPassword(dataTable.cell(1, 1));

	}

	@And("User clicks on the Sign In button")
	public void user_clicks_on_the_sign_in_button() {
		SignInMethods.clickToSignIn();
		HomePageMethods.homePageText();
	}

	@And("User enter the data {string} in the Search Textbox")
	public void user_enter_the_data_in_the_search_textbox(String str) {
		ProductSearchMethods.searchProduct(str);
	}

	@And("User selects the from the Auto-Suggestion {string}")
	public void user_selects_the_from_the_auto_suggestion(String str) {
		ProductSearchMethods.selectProductAutoSuggestion(str);
	}

	@And("User clicks on the {string} from the Search results")
	public void user_clicks_on_the_from_the_search_results(String str) {
		ProductSearchResultMethods.clickProductName(str);
	}

	@And("User selects the Size, Colour and Quantity")
	public void user_selects_the_size_colour_and_quantity(DataTable dataTable) throws Exception {
		
		List<List<String>> credentials = DataFromExcel
				.dataFromExcel(System.getProperty("user.dir")
				+ "\\src\\test\\resources\\ProjectExcelData.xlsx", 1);
		dataTable = DataTable.create(credentials);

		ProductSearchResultMethods.selectSize(dataTable.cell(1, 0));
		ProductSearchResultMethods.selectColor(dataTable.cell(1, 1));
		ProductSearchResultMethods.selectQuantity(dataTable.cell(1, 2));

	}

	@And("User clicks Add to Cart button")
	public void user_clicks_add_to_cart_button() {
		ProductSearchResultMethods.clickAddToCart();
	}

	@Then("verify whether the Product is added to the cart and {string} is displayed")
	public void verify_whether_the_product_is_added_to_the_cart_and_is_displayed(String str) {
		ProductSearchResultMethods.verifyAddedToCartMessage(str);
	}

}
