Feature:  Checking Logout functionality 

Scenario Outline: To check Logout Functionality using valid credentials

Given User opens the Browser
And User navigates to the "https://magento.softwaretestingboard.com/" Webpage
When User clicks Sign In button
And User enters the valid '<ValidEmail>' in Email Textbox and valid '<ValidPassword>' in Password Textbox
And User clicks SignIn actual button
And User clicks the Dropdown and clicks Sign Out button beside the Username
Then User verifies Sign out '<Message>'
And User verifies the  "Home Page"

Examples:
|ValidEmail|ValidPassword|Message|
|jeyajosh1234@gmail.com|JeyaJosh123456| You have signed out and will go to our homepage in 5 seconds.|

