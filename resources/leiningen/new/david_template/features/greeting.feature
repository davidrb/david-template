Feature: Greeting
  Scenario: User enters name and is greeted
    When The user enters 'World' into the name field
    Then The greeting should be 'Hello, World!'
