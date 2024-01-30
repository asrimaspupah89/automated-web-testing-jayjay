#Author : Asri Maspupah
#Title  : Functionality testing for Dashboard Feature
#Date   : 30 January 2024
#Software Under Test  : Swag Lab in the https://www.saucedemo.com/

Feature: Test Automation Web Login Page

  @web
  Scenario: Test web add item to cart
    Given a user has been logged in
    When  user add item to cart
    Then verify number of cart item is match with "1"

  @web
  Scenario: Test web remove item from cart
    Given a user has been logged in
    And  user add item to cart
    And  user add item to cart
    And  user add item to cart
    When user remove item from cart
    Then verify number of cart item is match with "2"