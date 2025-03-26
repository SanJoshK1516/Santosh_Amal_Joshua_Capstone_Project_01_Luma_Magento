Feature: Checking valid Login and invalid Login 

Scenario Outline: To check Login with valid and invalid Credentials

Given User opens the Browser
And User navigates to the "https://magento.softwaretestingboard.com/" Webpage
When User clicks Sign In button
And User enters invalid '<InvalidEmail>' in the Email Textbox
And User enters invalid '<InvalidPassword>' in the Password Textbox
And User clicks SignIn actual button
Then User verifies the '<Error>' message displayed after clicking Sign In Button
When User re-enters the valid '<ValidEmail>' in Email Textbox
And User re-enters the valid '<ValidPassword>' in Password Textbox
And User clicks SignIn actual button
Then User verifies Home Page is displayed after clicking Sign In button

Examples:
|InvalidEmail|InvalidPassword|Error|ValidEmail|ValidPassword|
|jo@gmail.com|Ji123|The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.|jeyajosh1234@gmail.com|JeyaJosh123456| 