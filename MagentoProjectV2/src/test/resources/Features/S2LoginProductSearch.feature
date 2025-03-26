Feature: Checking Login, Product Search and Adding Product to cart

Scenario Outline: To Check Login, Search Product using Auto-suggest feature and Adding Product to Cart

Given User opens the Browser
And User navigates to the "https://magento.softwaretestingboard.com/" Webpage
When User clicks Sign In button
And User enters the Login Credentials
|ProjectExcelData.xlsx|
And User clicks on the Sign In button
And User enter the data "Men" in the Search Textbox
And User selects the from the Auto-Suggestion '<Options>'
And User clicks on the '<Hoodie>' from the Search results
And User selects the Size, Colour and Quantity
|ProjectExcelData.xlsx|
And User clicks Add to Cart button
Then verify whether the Product is added to the cart and '<Message>' is displayed

Examples:
|Options|Hoodie|Message|
| men hoodie|Marco Lightweight Active Hoodie|You added Marco Lightweight Active Hoodie to your shopping cart.|