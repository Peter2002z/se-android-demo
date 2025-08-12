Feature: Login functionality

  Scenario: Login with valid credentials
    Given I am on the login screen
    When I enter username "standard_user"
    And I enter password "secret_sauce"
    And I tap login
    Then I should see the products page
