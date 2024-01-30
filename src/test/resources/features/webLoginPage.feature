#Author : Asri Maspupah
#Title  : Functionality testing for Login Feature
#Date   : 30 January 2024
#Software Under Test  : Swag Lab in the https://www.saucedemo.com/

Feature: Test Automation Web Login Page

  @web
  Scenario: Test web login normal
    Given user go to Swag Lab page "https://www.saucedemo.com/"
    When user input username "standard_user"
    And user input password "secret_sauce"
    And user click button login
    Then User should be able to login successfully and new page open

  @web
  Scenario Outline: Test web login invalid credentials
    Given user go to Swag Lab page "https://www.saucedemo.com/"
    When user input username "<username>"
    And user input password "<password>"
    And user click button login
    Then User should be able able to see a error message "<errorMessage>" in Login Page

    Examples:
      | username 		| password  	| errorMessage        										  | test case					|
      | standard_user   | secret12$$ 	| Username and password do not match any user in this service | wrong password				|
      | standard_$$		| secret_sauce  | Username and password do not match any user in this service | wrong username				|
      | abc123  		| xyz$$     	| Username and password do not match any user in this service | wrong username and password	|

  @web
  Scenario: Test web login with blank username
    Given user go to Swag Lab page "https://www.saucedemo.com/"
    When user input password "secret_sauce"
    And user click button login
    Then User should be able able to see a error message "Username is required" in Login Page

  @web
  Scenario: Test web login with blank password
    Given user go to Swag Lab page "https://www.saucedemo.com/"
    When user input username "standard_user"
    And user click button login
    Then User should be able able to see a error message "Password is required" in Login Page

  @web
  Scenario: Test web login with blank username and password
    Given user go to Swag Lab page "https://www.saucedemo.com/"
    When user click button login
    Then User should be able able to see a error message "Username and Password is required" in Login Page

