Feature: Forgotten password functionality

  Scenario: Forgotten password with valid email
    Given User open the login page
    When User clicks on ForgottenPassword button
    And User enters email "sofiliooo@gmail.com" into email field
    And User clicks on Continue button of forgot your password page
    Then User should get successfully message of confirmation link