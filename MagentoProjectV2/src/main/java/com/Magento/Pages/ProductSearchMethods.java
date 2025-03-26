package com.Magento.Pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.*;
import com.Magento.Browser.ProjectBrowser;
import com.Magento.Locators.ProductSearchObjects;

public class ProductSearchMethods extends ProjectBrowser {

	static ProductSearchObjects obj;
	
	
//	Method to Search a Product 
	public static void searchProduct(String str) {
		obj = new ProductSearchObjects();
		try {
			wait.until(ExpectedConditions.visibilityOf(obj.clickSearchElement));
			obj.clickSearchElement.click();
			wait.until(ExpectedConditions.visibilityOf(obj.searchElement));
			obj.searchElement.clear();
			obj.searchElement.sendKeys(str);

		} catch (Exception e) {
			System.out.println("Search Product Exception: " + e);
		}
	}

//	Method to select a Product by Auto Suggestion
	public static void selectProductAutoSuggestion(String str) {
		try {
			for (WebElement suggest : obj.searchAutoSuggestElement) {
				if (suggest.getText().equalsIgnoreCase(str)) {
					suggest.click();
					return;
				}
			}
			throw new Exception("Suggested item " + str + " not found");
		} catch (Exception e) {
			System.out.println("Selecting Product Auto Suggestion: " + e);
		}
	}

}
