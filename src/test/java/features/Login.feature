#Feature: Login into account
#  Existing user should be able to login to account using correct credentials
#
#  Scenario: Login into account with correct credentials
#    Given User navigates to stackoverflow website
#    And User clicks on the login button on homepage
#    And User enters a valid username
#    And User enters a valid password
#    When User clicks on the login button
#    Then User should be taken to the successful login page

Feature: Login into user account using login portal

  Background:
    Given User access webdriveruniversity website
    When User clicks on Login Portal link
    And User enters a username

  Scenario: Login to account with a valid password
    And User enters a "valid" password
    When User clicks on the Login button
    Then User should be presented with a successful validation alert

  Scenario: Login to account with a invalid password
    And User enters a "invalid" password
    When User clicks on the Login button
    Then User should be presented with an unsuccessful validation alert