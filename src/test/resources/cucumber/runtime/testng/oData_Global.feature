Feature: To fetch all the records from Global API
  Scenario: Read all data of global Api
    Given User hit the global URI
    When User login with valid username and password
    Then Status code should be 200 for global API
    And  Response should have all the related information