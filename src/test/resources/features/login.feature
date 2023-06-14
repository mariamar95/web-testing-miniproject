Feature: As a user, I want to be able to login so that I can access my account
  Scenario: Entering valid credentials
    Given I am on the login page
    And I enter my valid email address
    And the correct password
    Then I can see that I am logged in

  Scenario: Incorrect password
    Given I am on the login page
    And I enter my valid email address
    And an incorrect password
    And click login
    Then I will see the error message - your email or password is incorrect

