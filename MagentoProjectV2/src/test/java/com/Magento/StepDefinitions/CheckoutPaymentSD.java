package com.Magento.StepDefinitions;

import java.util.List;

import com.Magento.Excel.DataFromExcel;
import com.Magento.Pages.CheckoutPaymentMethods;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class CheckoutPaymentSD {

	@And("User clicks the Cart icon on the Homepage")
	public void user_clicks_the_cart_icon_on_the_homepage() {
		CheckoutPaymentMethods.clickShoppingCart();
	}

	@And("User clicks Proceed to Checkout button")
	public void user_clicks_proceed_to_checkout_button() {
		CheckoutPaymentMethods.clickCheckoutButton();
	}

	@And("User enters valid shipping address with valid data except for Zip\\/Postal Code textbox")
	public void user_enters_valid_shipping_address_with_valid_data_except_for_zip_postal_code_textbox(
			DataTable dataTable) {
		
		CheckoutPaymentMethods.shippingAddressTitleVerification();
		
		List<List<String>> credentials = DataFromExcel
				.dataFromExcel(System.getProperty("user.dir") + "\\src\\test\\resources\\ProjectExcelData.xlsx", 3);
		dataTable = DataTable.create(credentials);

		CheckoutPaymentMethods.company(dataTable.cell(0, 1));
		CheckoutPaymentMethods.address1(dataTable.cell(1, 1));
		CheckoutPaymentMethods.address2(dataTable.cell(2, 1));
		CheckoutPaymentMethods.address3(dataTable.cell(3, 1));
		CheckoutPaymentMethods.city(dataTable.cell(4, 1));
		CheckoutPaymentMethods.incorrectPostalCode(dataTable.cell(6, 1));
		CheckoutPaymentMethods.country(dataTable.cell(7, 1));
		CheckoutPaymentMethods.region(dataTable.cell(5, 1));
		CheckoutPaymentMethods.phone(dataTable.cell(8, 1));

	}

	@Then("User verifies the {string} message displayed under Zip\\/Postal Code textbox")
	public void user_verifies_the_message_displayed_under_zip_postal_code_textbox(String str) {
		CheckoutPaymentMethods.errorMsgVerification(str);
	}

	@When("User re-enters the valid data in Zip\\/Postal Code textbox")
	public void user_re_enters_the_valid_data_in_zip_postal_code_textbox(DataTable dataTable) {
		List<List<String>> credentials = DataFromExcel
				.dataFromExcel(System.getProperty("user.dir") + "\\src\\test\\resources\\ProjectExcelData.xlsx", 3);
		dataTable = DataTable.create(credentials);
		
		CheckoutPaymentMethods.correctPostalCode(dataTable.cell(9, 1));
		CheckoutPaymentMethods.shippingIndiaRadioButton();
		
	}

	@And("User clicks the Next button")
	public void user_clicks_the_next_button() {
		CheckoutPaymentMethods.clickNextButton();
	}

	@And("User clicks Place Order button")
	public void user_clicks_place_order_button() {
		CheckoutPaymentMethods.clickPlaceOrder();
	}

	@Then("User verifies the Order Placed {string}")
	public void user_verifies_the_order_placed(String str) {
		CheckoutPaymentMethods.confirmOrderPlacedMsgVerification(str);
	}

}
