Feature: Greeting
  Scenario: User has not entered name
    Given The name field is empty
    Then The greeting should be 'Hello!'

  Scenario: User enters name and is greeted
    When The user enters 'World' into the name field
    Then The greeting should be 'Hello, World!'
