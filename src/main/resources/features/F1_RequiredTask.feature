@allTask @web
Feature: Login to opensource-demo then add new data and assert it is added , delete new user and assert it is deleted
  Background: Login to Admin page
    Given User is navigating "https://opensource-demo.orangehrmlive.com/"
    When User enter username "Admin" and password "admin123"
    Then User goes to admin tab
  Scenario: adding new data and verifying that it is added
    Given The number of records found
    When User Navigating to Add new user Page
    And Adding new user
    |ESS|
    |Ranga  Akunuri|
    |Enabled |
    |new user|
    |password1234|
    Then Assert success message
    And verify number of records increased by 1
  Scenario: Searching for new username and delete the new user then verify that it is deleted
    Given the username "new user" search for it
    When User is deleting username "new user" and resetting search
    Then Verify number of records decreased by 1