Feature: ordering a product
Scenario: product is ordering or not
Given user browser and url
When login
Then go to men and click on personalcare
Then add item to bag
Then goto bag
Then click on place order button
Then enter cvv and click paynow
Then shut the browser1