package com.Magento.Browser;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ProjectBrowser {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static JavascriptExecutor js;
	public static Actions act;

	public static ExtentReports extent;
	public static ExtentTest logger1;
	public static ExtentSparkReporter reporter;
	
//	Method to initialize Extent Report

	public static void init(String reportName) {
		extent = new ExtentReports();
		reporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "//target//com.Magento.ExtentReports//" + reportName + ".html");
		extent.attachReporter(reporter);
	}
	
//	Method to open Browser
	public static void openBrowser(String browser) {
		logger1 = extent.createTest("Open Browser Initialization");
		
		logger1.log(Status.INFO, "Opening the Browser");
		try {
//			String choice = ProjectUtility.properties("browser");
			if (browser.equalsIgnoreCase("Chrome")) {
				driver = new ChromeDriver();
				logger1.log(Status.PASS, "Chrome Browser opened Successfully");
			} else if (browser.equalsIgnoreCase("Edge")) {
				driver = new EdgeDriver();
				logger1.log(Status.PASS, "Edge Browser opened Successfully");
			} else if (browser.equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver();
				logger1.log(Status.PASS, "Firefox Browser opened Successfully");
			} else {
				throw new Exception("Invalid Browser");
			}

		} catch (Exception e) {
//			 e.printStackTrace();
			System.out.println("Open Browser Exception: " + e);
			logger1.log(Status.FAIL, "Failed, Browser did not open");
			System.exit(0);
		}

//		extent.flush();
	}

//	Method to navigate to the URL
	public static void navigateToUrl(String url) {
//		extent.attachReporter(reporter);
		logger1 = extent.createTest("Navigating URL");
		logger1.log(Status.INFO, "The URL will be Navigated");
		try {

			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			js = (JavascriptExecutor) driver;
			act = new Actions(driver);
			logger1.log(Status.PASS, "The URL has been navigated Successfully");
		} catch (Exception e) {
			System.out.println("Navigate to URL Exception: " + e);
			logger1.log(Status.FAIL, "The URL is not navigated.");
			System.exit(0);
		}

//		extent.flush();
	}
	
//	Method to close the Browser
	public static void closeBrowser() {
//		extent.attachReporter(reporter);
		logger1 = extent.createTest("Closing the Browser");
		logger1.log(Status.INFO, "The Browser will be closed");

		try {
			driver.quit();
			logger1.log(Status.PASS, "The Browser has been closed Successfully");
		} catch (Exception e) {
			System.out.println("Close Browser Exception: " + e);
			logger1.log(Status.FAIL, "The Browser is not Closed.");
			System.exit(0);
		}

//		extent.flush();
	}

}
