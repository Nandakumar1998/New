@login
Feature: Verifing Adactin login hotel details

  Scenario Outline: Verifying Adactin login with valid credential
    Given User is on the Adactin login page
    When User should perform login "<userName>","<password>"
    Then User should verify success message after login "Hello tomriddle!"

    Examples: 
      | userName  | password  |
      | tomriddle | tomriddle |

  Scenario Outline: Verifying Adactin login with valid credential with Enterkey
    Given User is on the Adactin login page
    When User should perform login "<userName>","<password>" with enter keys
    Then User should verify success message after login "Hello tomriddle!"

    Examples: 
      | userName  | password  |
      | tomriddle | tomriddle |

  @Login
  Scenario Outline: Verifying Adactin login with Invalid credential
    Given User is on the Adactin login page
    When User should perform login "<userName>","<password>"
    Then User should verify after login error contains "Invalid Login details or Your Password might have expired. "

    Examples: 
      | userName      | password       |
      | tomriddle1234 | tomriddlejjxhh |
