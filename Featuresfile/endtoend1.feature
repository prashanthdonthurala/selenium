Feature: myntra credit balance
Scenario: adding myntra credit balance
Given user url and browser
When goto login page
Then go to myntra credit page and click on topup
Then select amount and click on topup button
Then enter cvv for saved card and click on paynow
And shut browser
