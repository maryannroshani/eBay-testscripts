Feature: Search function of eBay

  Background:
    Given I should be signed in eBay account Home

  @login
  Scenario: Search an item with valid characters
    And Navigate to me search bar
    When I search an item with valid data
    Then Display search results
    And I click the first search suggestion

  @login
  Scenario: Search a recent item from search bar
    And Navigate to me search bar
    When I click the recent in searches
    Then Display recent search list

  @login
  Scenario: Search a saved item from search bar
    And Navigate to me search bar
    When I click the saved in searches
    Then Display saved search list
