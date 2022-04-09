Feature: To test account creation functionality

Background:
Given User navigate to Sign Up page

#Positive scenarios
Scenario Outline:
User should be able to create account with valid details
And Account does not exist "<Valid email>"
And User enter First_Name as "<First Name>"
And User enter Last_Name as "<Last Name>"
And User enter Email as "<Valid email>"
And User enter Contact Number as "<Contact Number>"
And User enter Password as "<Password>"
And User enter Confirm Password as "<Confirm Password>"
And User select Role as "<Role>"
Then User click on Next - Billing button
And User enter Address one as "<Address Line One>"
And User enter Address two as "<Address Line Two>"
And User enter City as "<City>"
And User enter Postal Code as "<Postal Code>"
And User enter State as "<State>"
And User enter Country as "<Country>"
And User click on Next-Confirm button
And User click on Confirm button
Then Account should be created "<Valid email>"

Examples:
|First Name|Last Name|Valid email|Contact Number|Password|Confirm Password|Role|Address Line One|Address Line Two|City|Postal Code|State|Country|
|Pika|Pikachu|pikachu@pokemon.com|11111111|pikapika|pikapika|User|Route 17|Route 17|Pallet Town|11111|Pallet Town|Pallet Town|
|valid_firstname|valid_lastname|valid@email.com|22222222|validpassword|validpassword|Supplier|valid_add1|valid_add2|valid_city|22222|valid_state|valid_country|


#Negative scenarios
Scenario Outline:
User should NOT be able to create account if Confirm Password is different from password
And User enter First_Name as "<First Name>"
And User enter Last_Name as "<Last Name>"
And User enter Email as "<Valid email>"
And User enter Contact Number as "<Contact Number>"
And User enter Password as "<Password>"
And User enter Confirm Password as "<Confirm Password>"
And User select Role as "<Role>"
Then User click on Next - Billing button
Then confirm password field should prompt "<message>"

Examples:
|First Name|Last Name|Valid email|Contact Number|Password|Confirm Password|Role|message|
|myfirstname|mylastname|myemail@email.com|33333333|mypass|yourpass|User|Password does not match confirm password!|

Scenario Outline:
User should NOT be able to proceed if the email have been used
And User enter First_Name as "<First Name>"
And User enter Last_Name as "<Last Name>"
And User enter Email as "<Valid email>" but the email have been used
And User enter Contact Number as "<Contact Number>"
And User enter Password as "<Password>"
And User enter Confirm Password as "<Confirm Password>"
And User select Role as "<Role>"
Then User click on Next - Billing button
Then email field should prompt "<message>"

Examples:
|First Name|Last Name|Valid email|Contact Number|Password|Confirm Password|Role|message|
|hey|heyhey|hey@hey.com|8888888|superlongpassword|superlongpassword|Supplier|Email address is already taken!|

#BUG
#Clicking on Back - Personal did not go back to page 1 of sign up page(Personal) IF page 2 field is not filled in.
#User should be allowed to go back to page 1 even if page 2 detail is not filled in

Scenario Outline:
User should be able to click on Back - Personal button and it should direct back to the page 1 of sign up page(Personal)
And User enter First_Name as "<First Name>"
And User enter Last_Name as "<Last Name>"
And User enter Email as "<Valid email>"
And User enter Contact Number as "<Contact Number>"
And User enter Password as "<Password>"
And User enter Confirm Password as "<Confirm Password>"
And User select Role as "<Role>"
Then User click on Next - Billing button
But User click on Back - Personal button 
Then It should bring user back to Sign Up - Personal page


Examples:
|First Name|Last Name|Valid email|Contact Number|Password|Confirm Password|Role|
|T-wolf|kru|kru@heymail.com|12348888|superlongpassword|superlongpassword|Supplier|

Scenario Outline:
User did not click on Confirm button at page 3 of account creation
And User enter First_Name as "<First Name>"
And User enter Last_Name as "<Last Name>"
And User enter Email as "<Valid email>"
And User enter Contact Number as "<Contact Number>"
And User enter Password as "<Password>"
And User enter Confirm Password as "<Confirm Password>"
And User select Role as "<Role>"
Then User click on Next - Billing button
And User enter Address one as "<Address Line One>"
And User enter Address two as "<Address Line Two>"
And User enter City as "<City>"
And User enter Postal Code as "<Postal Code>"
And User enter State as "<State>"
And User enter Country as "<Country>"
And User click on Next-Confirm button
And User did NOT click on Confirm button
Then Account should not be created "<Valid email>"

Examples:
|First Name|Last Name|Valid email|Contact Number|Password|Confirm Password|Role|Address Line One|Address Line Two|City|Postal Code|State|Country|
|shouldnotcreated|shouldnotcreated|shouldnotcreated@not.com|12345678|shouldnotcreated|shouldnotcreated|Supplier|add1|add2|ccc|pc12345|state12345|country12345|


#Did not further test on Negative scenario as this sign up function have several issues and improvement to be done.
#Issue 1: Should not allow invalid email, such as no "@". 
#Issue 2: Contact Number should only allow numeric characters. Should not allow user to type in non-numeric OR should not allow to  proceed if contact number is invalid.
#Issue/Improvement 3: Should not allow weak password. Should enforce password to be
#1. Certain length(more than 8 characters)
#2. Mix of letters,numbers and symbols
   


