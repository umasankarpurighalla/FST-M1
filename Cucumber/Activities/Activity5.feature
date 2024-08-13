@activity5
Feature: Data driven test with Example

  Scenario Outline: Testing with Data from Scenario
    Given User is on Login Test page
    When User enters "<Usernames>" and "<Passwords>" in Login
    Then Read the page title and confirmation message in Login
    And Close the Opened Browser

    Examples:
      | Usernames | Passwords |
      | admin     | password  |
      | adminUser | Password  |