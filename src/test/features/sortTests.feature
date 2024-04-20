Feature: As a user
  I should sort the products accordingly

  Background: Sort

    Given I am on home page "https://www.saucedemo.com"
    When I do Login with username "standard_user" and password "secret_sauce"

  @sort
  Scenario: Verify sort options exist

    When I click sort dropdown
    Then I should see options "Name (A to Z)", "Name (Z to A)", "Price (low to high)", "Price (high to low)"

  @sort
  Scenario: Verify sort option Name (A to Z)

    When I choose option "Name (A to Z)"
    Then I expect products to be sorted in ascending order

  @sort
  Scenario: Verify sort option Name (Z to A)

    When I choose option "Name (Z to A)"
    Then I expect products to be sorted in descending order

  @sort
  Scenario: Verify sort option Price (low to high)

    When I choose option "Price (low to high)"
    Then I expect products to be sorted in price ascending order

  @sort
  Scenario: Verify sort option Price (low to high)

    When I choose option "Price (high to low)"
    Then I expect products to be sorted in price descending order

