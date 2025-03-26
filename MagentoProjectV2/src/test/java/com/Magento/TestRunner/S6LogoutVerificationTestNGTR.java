package com.Magento.TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src\\test\\resources\\Features\\S6LogOutVerification.feature", 
glue = {"com.Magento.StepDefinitions", "com.Magento.Hooks"},
plugin = {"pretty", "html:target/com.Magento.CucumberReport/Cucumber_S6LogOutVerification_Report.html"})

//S1Registration.feature
//S2LoginProductSearch.feature
//S3CheckoutPayment.feature
//S4LoginValidInvalid.feature
//S5LoginMultipleProducts.feature
//S6LogOutVerification.feature

public class S6LogoutVerificationTestNGTR extends AbstractTestNGCucumberTests {

}
