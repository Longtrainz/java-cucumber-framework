Feature: Login to account

  Scenario Outline: Login to account with credentials
    Given  User navigates to "<url>"
    When  User clicks on login-portal link
    And  User enters the "<username>" username
    And  User enters the "<password>" password
    When Click on the login button
    Then  User should be presented with the following alert "<message>"
    Examples:
      | url | username | password | message |


