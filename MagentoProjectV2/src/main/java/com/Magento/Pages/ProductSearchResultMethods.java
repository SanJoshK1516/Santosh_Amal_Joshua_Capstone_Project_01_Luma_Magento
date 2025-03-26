package com.Magento.Pages;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.Magento.Browser.ProjectBrowser;
import com.Magento.Locators.ProductSearchResultObjects;
import com.Magento.Screenshot.ScreenshotCapture;
import com.aventstack.extentreports.Status;

public class ProductSearchResultMethods extends ProjectBrowser {
	static ProductSearchResultObjects obj;

//	Method to select a Product
	public static void clickProductName(String product) {
		obj = new ProductSearchResultObjects();
		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(obj.productsElement));
			for (WebElement prodName : obj.productsElement) {
//				product.getText().contains("Jupiter All-Weather Trainer")
				if (prodName.getText().contains(product)) {
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", prodName);
					prodName.click();
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("Selecting Product method Exception: " + e);
		}
	}

//	Method to select Size of the Product
	public static void selectSize(String str) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfAllElements(obj.sizeOptionsElement));
			for (WebElement size : obj.sizeOptionsElement) {
				if (size.getText().trim().equalsIgnoreCase(str)) {
					size.click();
					break;
				}
			}

		} catch (Exception e) {
			System.out.println("Select Size method Exception: " + e);
		}
	}

//	Method to select Color of the Product
	public static void selectColor(String str) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfAllElements(obj.colorOptionsElement));
			for (WebElement color : obj.colorOptionsElement) {
				if (color.getDomAttribute("option-label").equalsIgnoreCase(str)) {
					color.click();
					break;
				}

			}
		} catch (Exception e) {
			System.out.println("Select Color method Exception: " + e);
		}
	}

//	Method to select Quantity of the Product
	public static void selectQuantity(String str) {
		try {
			wait.until(ExpectedConditions.visibilityOf(obj.quantityBoxElement));
			obj.quantityBoxElement.clear();
			obj.quantityBoxElement.sendKeys(str);
			ScreenshotCapture.takeScreenShot("Product_Selected_Copy");

		} catch (Exception e) {
			System.out.println("Select Quantity method Exception: " + e);
		}

	}

//	Method to click Add to Cart Button
	public static void clickAddToCart() {
		try {
			wait.until(ExpectedConditions.visibilityOf(obj.addToCartButtonElement));
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", obj.addToCartButtonElement);
			obj.addToCartButtonElement.click();
		} catch (Exception e) {
			System.out.println("Click Add to Cart method Exception: " + e);
		}
	}

//	Method to verify whether the Product is added to Cart
	public static void verifyAddedToCartMessage(String str) {
		logger1 = extent.createTest("Single Product Add Test");
		logger1.log(Status.INFO, "To check whether a Single Product is added to the Cart");
		try {
			wait.until(ExpectedConditions.visibilityOf(obj.cartMessageElement));
			String cartMsgConfirm = obj.cartMessageElement.getText();
//			Assert.assertEquals(cartMsgConfirm, cartMsgConfirm.contains(str));
			Assert.assertTrue(cartMsgConfirm.contains(str), cartMsgConfirm);
			logger1.log(Status.PASS, "Product added to Cart Successfully");
			logger1.addScreenCaptureFromPath(ScreenshotCapture.takeScreenShot("CartMessageScrnsht1"));
		} catch (Exception e) {
			System.out.println("Verify Added to Cart method Exception: " + e);
			logger1.log(Status.FAIL, "Product not added, exception thrown");
		}

	}

//	METHODS FOR MULTIPLE PRODUCTS

//	Method for clicking and Viewing Shopping Cart
	public static void clickToViewShoppingCart() {
		try {
			wait.until(ExpectedConditions.visibilityOf(obj.shoppingCartButtonElement));
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});",
					obj.shoppingCartButtonElement);
			obj.shoppingCartButtonElement.click();
			
			
			
		} catch (Exception e) {
			System.out.println("Click to view Shopping cart method Exception: " + e);
		}
	}
	
//	Method to verify Product(s) are Displayed
	public static void verifyProductsDisplayed() {
		logger1 = extent.createTest("Multiple Products Add Test");
		logger1.log(Status.INFO, "To check whether Multiple Products are added to the Cart");
		try {
			wait.until(ExpectedConditions.visibilityOf(obj.shoppingCartTitleElement));
			System.out.println("Shopping Cart Page is visible");
			wait.until(ExpectedConditions.visibilityOfAllElements(obj.selectedProductNamesElement));
			for(WebElement name : obj.selectedProductNamesElement) {
				System.out.println(name.getText());
			}
			wait.until(ExpectedConditions.visibilityOf(obj.orderTotalCostElement));
			System.out.println("Total Cost is visible");
			logger1.log(Status.PASS, "Multiple Products added to Cart Successfully");
			logger1.addScreenCaptureFromPath(ScreenshotCapture.takeScreenShot("MultipleProductsViewCart"));
			
		} catch (Exception e) {
			System.out.println("Verify Products displayed method Exception: " + e);
			logger1.log(Status.FAIL, "Multiple Products not added, exception thrown");
		}
	}

}
