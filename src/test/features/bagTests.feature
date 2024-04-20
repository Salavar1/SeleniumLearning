Feature: As a user
  I should be able to add/edit/delete products from bag

  Background: Bag

    Given I am on home page "https://www.saucedemo.com"
    When I do Login with username "standard_user" and password "secret_sauce"
    And I choose a product "Sauce Labs Backpack"
    And I click Add to cart button with badge "1"

  @smoke @bag @regression
  Scenario: Verify add a product to bag

    And I click bag icon
    Then I should see product "Sauce Labs Backpack" in the bag

  @bag @regression
  Scenario: Verify remove product from bag

    And I click bag icon
    And I click remove button in the bag
    Then the product "Sauce Labs Backpack" should be removed

  @bag @regression
  Scenario: Verify add more products to bag

    And I click back button
    And I choose a product "Sauce Labs Bike Light"
    And I click Add to cart button with badge "2"
    And I click bag icon
    Then I should see products "Sauce Labs Backpack" and "Sauce Labs Bike Light" in the bag