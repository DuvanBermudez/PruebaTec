Feature: User registration in demoblaze

  Scenario: A user wants to register on demoblaze
    Given i want to register in "https://www.demoblaze.com/"
    When assing my user data
      | username | Duvan |
      | password | 12345 |
    Then I verify that the register is successful see "Sign up successful."