@activity2
Feature: Login Test

  Scenario: Testing Login
    Given User is on Test Login page
    When User enters username and password in Login Form Page
    Then Read the page title and confirmation message in Login Form Page
    And Close the Login Browser