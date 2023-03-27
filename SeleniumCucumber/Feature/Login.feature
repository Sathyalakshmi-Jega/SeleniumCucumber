#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Login

   Scenario: Successful login with valid credentials
   Given Launch the browser
   When User launches the URL "http://admin-demo.nopcommerce.com/login"
   And User enter username as "admin@yourstore.com" and password as "admin"
   And clicks Login button
   Then Page Title should be "Dashboard/ nopcommerce administration"
   When User clicks logout link
   Then Page Title should be "Your store. Login "
   And close browser
   
   Scenario Outline: Successful login with valid credentials
   Given Launch the browser
   When User launches the URL "http://admin-demo.nopcommerce.com/login"
   And User enter username as "<email_id>" and password as "<Password>"
   And clicks Login button
   Then Page Title should be "Dashboard/ nopcommerce administration"
   When User clicks logout link
   Then Page Title should be "Your store. Login "
   And close browser
 
   Examples:
      |email_id | Password|
      |admin@yourstore.com| admin|
      |admin@yourstore.com| admin1234|