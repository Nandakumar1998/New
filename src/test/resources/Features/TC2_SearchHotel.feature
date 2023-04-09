@Search
Feature: Verifing Adactin search hotel page details

  Scenario Outline: Verifying Adactin search hotels page by selecting all fields
    Given User is on the Adactin login page
    When User should perform login "<userName>","<password>"
    Then User should verify success message after login "Hello tomriddle!"
    And User should search hotel by entering all fields "<location>","<hotels>","<roomType>","<noOfRooms>","<checkIn>","<checkOut>","<aduldPerRoom>" and "<childPerRoom>"
    Then User should verify the success message after search hotel "Select Hotel"

    Examples: 
      | userName  | password  | location | hotels      | roomType | noOfRooms | checkIn    | checkOut   | aduldPerRoom | childPerRoom |
      | tomriddle | tomriddle | Sydney   | Hotel Creek | Standard | 2 - Two   | 09/09/2022 | 10/09/2022 | 2 - Two      | 2 - Two      |

  Scenario Outline: Verifying Adactin search hotels page by selecting mandatory fields
    Given User is on the Adactin login page
    When User should perform login "<userName>","<password>"
    Then User should verify success message after login "Hello tomriddle!"
    And User should search hotel by entering only mandatory fields "<location>","<hotels>","<roomType>","<checkIn>" and "<checkOut>"
    Then User should verify the success message after search hotel "Select Hotel"

    Examples: 
      | userName  | password  | location | hotels      | roomType | checkIn    | checkOut   |
      | tomriddle | tomriddle | Sydney   | Hotel Creek | Standard | 09/09/2022 | 10/09/2022 |

  Scenario Outline: Verifying Adactin search hotels page by entering invalid check in date
    Given User is on the Adactin login page
    When User should perform login "<userName>","<password>"
    Then User should verify success message after login "Hello tomriddle!"
    And User should search hotel by entering all fields "<location>","<hotels>","<roomType>","<noOfRooms>","<checkIn>","<checkOut>","<aduldPerRoom>" and "<childPerRoom>"
    Then User should verify the error message "Check-In Date shall be before than Check-Out Date" and "Check-Out Date shall be after than Check-In Date"

    Examples: 
      | userName  | password  | location | hotels      | roomType | noOfRooms | checkIn    | checkOut   | aduldPerRoom | childPerRoom |
      | tomriddle | tomriddle | Sydney   | Hotel Creek | Standard | 2 - Two   | 09/09/2023 | 15/09/2022 | 2 - Two      | 2 - Two      |

  Scenario Outline: Verifying Adactin search hotels page by without selecting any input fields
    Given User is on the Adactin login page
    When User should perform login "<userName>","<password>"
    Then User should verify success message after login "Hello tomriddle!"
    And User should click on the search button without entering any fields
    Then User should verify the error message "Please Select a Location"

    Examples: 
      | userName  | password  |
      | tomriddle | tomriddle |
