Feature: As a user i would like to be able signup to an new account
  Scenario: Navigate to the login page
    Given I am on the homepage
    When I click on the signup_login button
    Then I will be directed to the login page

    Scenario: Navigate to the signup page
      Given I am on the login page
      When  I enter a name
      And email address
      And click signup
      Then I am directed to the signup page
      And The name filed contain the name entered
      And The email field contain the email entered

      Scenario: Creating a new account
        Given I am on the signup page
        When I select my title
        And enter a password
        And select my date of birth
        And enter my first name
        And enter my last name
        And enter my address
        And select my country
        And enter my state
        And enter my city
        And enter my zip code
        And enter my phone number
        And click create account
        Then I will be  redirected to a page account created



