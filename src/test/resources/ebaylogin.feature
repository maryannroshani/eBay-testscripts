Feature: Login page of eBay

  Background:
    Given I should be at the sign in page

  Scenario: Login with valid username and passsword
    And I enter valid username and passsword
    When I click the Sign in button
    And I click deny link accounts
    Then I Successfully Logged into eBay home page

  Scenario: Login with Invalid username and passsword
    And I enter Invalid username and passsword
    When I click the Sign in button
    Then I should get the error message