@task
Feature: Login to opensource-demo then add new data and assert it is added , delete new user and assert it is deleted
  Background: Login to Admin page
    Given User is navigating "https://opensource-demo.orangehrmlive.com/"
    When User enter username "Admin" and password "admin123"
    Then User goes to admin tab
  Scenario: adding new data and verifying that it is added
    Given The number of records found
    When User Navigating to Add new user Page
    And User is adding new data with username "new user"
    Then verify number of records increased by 1
#  Scenario: Searching for new username and delete the new user then verify that it is deleted
#    Given the username "new user"
#    When User is deleting the new user
#    Then verify number of records decreased by 1
