Feature: As a user
  I should only be able to do login with valid username and password

  Background: Login

    Given I am on home page "https://www.saucedemo.com"

  @login
  Scenario: Verify valid login

    When I do Login with username "standard_user" and password "secret_sauce"
    Then I should land on the Products page

  @login
  Scenario: Verify invalid login

    When I do Login with an invalid username "standard_userinv" and password "secret_sauceinv"
    Then I should see an error with message "Epic sadface: Username and password do not match any user in this service"

  @login
  Scenario: Verify no data login

    When I do Login without entering a username and password
    Then I should see an error with message "Epic sadface: Username is required"