Feature: To check HomePage user experience

Background: 
Given User is at Home page 

Scenario:
Navigation bar should be available and should have the following items
Then user should see the following navigation bar item
|About|
|Contact|
|View Products|
|Sign Up|
|Login|

Scenario:
Page should have the main header for easy access
Then user should see the following header for easy access of purchase
|Most Viewed Medicines|
|Most Purchased Medicines|

Scenario:
Should be able to direct to About Page
And user click on About button
Then user should be directed to About Page


Scenario:
Should be able to direct to Contact Page
And user click on Contact button
Then user should be directed to Contact Page

Scenario:
Should be able to direct to View Products Page
And user click on View Products button
Then user should be directed to View Products Page

Scenario:
Should be able to direct to Sign Up Page
And user click on Sign Up button
Then user should be directed to Sign Up Page

Scenario:
Should be able to direct to Login Page
And user click on Login button
Then user should be directed to Login Page

Scenario:
Should be able to go back to Home Page
And user click on Login button
Then user should be directed to Login Page
And user click on Home Page button
Then user should be directed to Home Page

