Feature: Checking User Registration

Scenario Outline: To register a User with invalid Data Handling

Given User opens the Browser
And User navigates to the "https://magento.softwaretestingboard.com/" Webpage
When User clicks Create an Account button
And User enters the valid '<FirstName>' in Firstname Textbox
And User enters the valid '<LastName>' in Lastname Textbox
And User enters the invalid '<InvalidEmail>' in Email Textbox
And User enters the valid '<Password>' in Password Textbox
And User enters the valid '<ConfirmPassword>' in ConfirmPassword Textbox
And User clicks the Create an Account button
Then User verifies the '<Error>' message displayed under Email Textbox
When User re-enters the Email with valid data '<ValidEmail>' in Email Textbox
And User clicks the Create an Account button
Then User verifies Registration '<Message>' in the next page
Examples:
|FirstName|LastName|InvalidEmail|Password|ConfirmPassword|Error|ValidEmail|Message|
|Santosh|Amal Joshua|josh456|SantoshAmal123456|SantoshAmal123456|Please enter a valid email address (Ex: johndoe@domain.com).|santoshAmal123@gmail.com|Thank you for registering with Main Website Store.|
