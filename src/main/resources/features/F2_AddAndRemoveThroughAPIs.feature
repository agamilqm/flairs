@api @allTask
Feature: adding candidate and remove candidate using APIs
  Background: starting session with required url
#    Given User is navigating "https://opensource-demo.orangehrmlive.com/"
    And Base url "https://opensource-demo.orangehrmlive.com/web/index.php/api/v2" set it up
  Scenario: Adding new candidate using API
    Given User Got all Data using "/recruitment/candidates"
    |cookie|orangehrm=771d9ccdc2bcc5eb60bbf0799b0347c6		|
    When User Adding new candidates using "/recruitment/candidates"
    Then Assert User Added Successfully using "/recruitment/candidates"
#  Scenario: Removing candidate using API
#    Given User Got all Data using "/recruitment/candidates"
#    When User Delete candidate using
#    Then Assert User Removed Successfully using "/recruitment/candidates"