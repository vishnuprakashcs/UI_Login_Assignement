Feature: Login and Logout
Scenario: Login and Logout Functionality
Given user navigates to the website https://wave-trial.getbynder.com/login
And there user logs in through Login Window by using Username as "vishnuprakashcs" and Password as "testBynder123"
Then login must be successful by displaying the DashBoardPage
And user clicks on logout button under profile link
Then logout must be successful by displaying the login page