Feature: Checking Login, Product Search and Adding Multiple Products to Cart

Scenario Outline: To Check Login, Search Products using Auto-suggest feature and Adding Multiple Products to Cart

Given User opens the Browser
And User navigates to the "https://magento.softwaretestingboard.com/" Webpage
When User clicks Sign In button
And User enters the Login Credentials
|ProjectExcelData.xlsx|
And User clicks on the Sign In button

# Selecting the First Product
And User enters the first data "Shirts" in the Search Textbox
And User selects the first data from the Auto-Suggestion '<Option1>'
And User clicks on the first data '<Shirt>' from the Search results
And User selects the Size, Colour and Quantity
|ProjectExcelData.xlsx|
And User clicks Add to Cart button
Then verify whether the Product is added to the cart and '<Message1>' is displayed

# Selecting second product
And User enters the second data "Watches" in the Search Textbox
And User selects the second data from the Auto-Suggestion '<Option2>'
And User clicks on the second data '<Watch>' from the Search results
And User selects the Quantity
|ProjectExcelData.xlsx|
And User clicks Add to Cart button
Then verify whether the Product is added to the cart and '<Message2>' is displayed
And User clicks the Shopping Cart button to view Products
Then verify the correct Products and total price are displayed

Examples:
|Option1|Shirt|Message1|Option2|Watch|Message2|
| shirts for men|Jupiter All-Weather Trainer|You added Jupiter All-Weather Trainer to your shopping cart.| watches for men|Bolo Sport Watch|You added Bolo Sport Watch to your shopping cart.|
