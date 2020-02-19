Feature: To generate Authorization Token
  Scenario Outline: Check is user is able to generate the Auth Token with valid credentials
    Given User hit the given URI
    When user login with <username> and <password>
    Then Status code should be 200
    And Authorization token should be generated
    Examples:
      |username | password |
      |testf1.testl1  |     Welldone@123      |
