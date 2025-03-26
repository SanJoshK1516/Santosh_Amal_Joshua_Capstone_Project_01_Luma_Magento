package com.Magento.Hooks;

import com.Magento.Browser.ProjectBrowser;

import io.cucumber.java.*;

public class ProjectHooks extends ProjectBrowser {

//	Method to create ExtentReport 
	@BeforeAll
	public static void initializingExtentReport() {
		ProjectBrowser.init("ExtentReportPrototype");
	}

//	Method to create a Logger in order to log details of Scnearios
	@Before
	public static void creatingExtentTest(Scenario scenario) {
		logger1 = extent.createTest(scenario.getName());
	}

//	Calling the Method to close the browser once all the Scenario tests are done and saving the Extent Report
	@After
	public void closeApplication() {
		ProjectBrowser.closeBrowser();
		extent.flush();
	}

}
