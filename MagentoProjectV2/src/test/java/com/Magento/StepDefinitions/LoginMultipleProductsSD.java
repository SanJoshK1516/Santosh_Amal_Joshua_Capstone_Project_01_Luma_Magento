package com.Magento.StepDefinitions;

import java.util.*;

import com.Magento.Excel.DataFromExcel;
import com.Magento.Pages.ProductSearchMethods;
import com.Magento.Pages.ProductSearchResultMethods;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class LoginMultipleProductsSD {

	@And("User enters the first data {string} in the Search Textbox")
	public void user_enters_the_first_data_in_the_search_textbox(String str) {
		ProductSearchMethods.searchProduct(str);
	}

	@And("User selects the first data from the Auto-Suggestion {string}")
	public void user_selects_the_first_data_from_the_auto_suggestion(String str) {
		ProductSearchMethods.selectProductAutoSuggestion(str);
	}

	@And("User clicks on the first data {string} from the Search results")
	public void user_clicks_on_the_first_data_from_the_search_results(String str) {
		ProductSearchResultMethods.clickProductName(str);
	}

	@And("User enters the second data {string} in the Search Textbox")
	public void user_enters_the_second_data_in_the_search_textbox(String str) {
		ProductSearchMethods.searchProduct(str);
	}

	@And("User selects the second data from the Auto-Suggestion {string}")
	public void user_selects_the_second_data_from_the_auto_suggestion(String str) {
		ProductSearchMethods.selectProductAutoSuggestion(str);
	}

	@And("User clicks on the second data {string} from the Search results")
	public void user_clicks_on_the_second_data_from_the_search_results(String str) {
		ProductSearchResultMethods.clickProductName(str);
	}

	@And("User selects the Quantity")
	public void user_selects_the_quantity(DataTable dataTable) {
		List<List<String>> credentials = DataFromExcel
				.dataFromExcel(System.getProperty("user.dir")
				+ "\\src\\test\\resources\\ProjectExcelData.xlsx", 2);
		dataTable = DataTable.create(credentials);
		
		ProductSearchResultMethods.selectQuantity(dataTable.cell(1, 0));
	}

	@And("User clicks the Shopping Cart button to view Products")
	public void user_clicks_the_shopping_cart_button_to_view_products() {
		ProductSearchResultMethods.clickToViewShoppingCart();
		
	}

	@Then("verify the correct Products and total price are displayed")
	public void verify_the_correct_products_and_total_price_are_displayed() {
		ProductSearchResultMethods.verifyProductsDisplayed();
	}

}
