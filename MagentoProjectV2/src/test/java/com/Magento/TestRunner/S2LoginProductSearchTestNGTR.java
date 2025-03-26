package com.Magento.TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src\\test\\resources\\Features\\S2LoginProductSearch.feature", 
glue = {"com.Magento.StepDefinitions", "com.Magento.Hooks"},
plugin = {"pretty", "html:target/com.Magento.CucumberReport/Cucumber_S2LoginProductSearch_Report.html"})

//S1Registration.feature
//S2LoginProductSearch.feature
//S3CheckoutPayment.feature
//S4LoginValidInvalid.feature
//S5LoginMultipleProducts.feature
//S6LogOutVerification.feature

public class S2LoginProductSearchTestNGTR extends AbstractTestNGCucumberTests {

}
