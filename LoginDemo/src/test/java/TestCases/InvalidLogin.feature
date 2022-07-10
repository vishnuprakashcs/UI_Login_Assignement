Feature: Invalid login 
Scenario: Invalid Login Functionality
Given user navigates to the website https://wave-trial.getbynder.com/login
And there user logs in through Login Window by using invalid Username as "random_sd" and Password as "dfddf"
Then login must be unsuccessful by displaying the error message
Then Dashboard page not displayed