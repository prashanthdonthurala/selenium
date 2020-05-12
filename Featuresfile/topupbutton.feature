Feature: topupbutton
Scenario: whether topup button is working or not

Given users with url
When enters the details to login
Then click on the topup
Then enter amount and click on topup buttom
And closing the browser
