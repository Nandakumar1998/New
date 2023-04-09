@Select
Feature: Verifing Adactin select hotel page details

  Scenario Outline: Verifying Adactin select hotel page by selecting a hotel name
    Given User is on the Adactin login page
    When User should perform login "<userName>","<password>"
    Then User should verify success message after login "Hello tomriddle!"
    And User should search hotel by entering all fields "<location>","<hotels>","<roomType>","<noOfRooms>","<checkIn>","<checkOut>","<aduldPerRoom>" and "<childPerRoom>"
    Then User should verify the success message after search hotel "Select Hotel"
    And User should select hotel name and click continue
    Then User should verify the success message after selecting a hotel name "Book A Hotel"

    Examples: 
      | userName  | password  | location | hotels      | roomType | noOfRooms | checkIn    | checkOut   | aduldPerRoom | childPerRoom |
      | tomriddle | tomriddle | Sydney   | Hotel Creek | Standard | 1 - One   | 03/09/2022 | 04/09/2022 | 1 - One      | 0 - None     |

  Scenario Outline: Verifying Adactin select hotel page without selecting any hotel
    Given User is on the Adactin login page
    When User should perform login "<userName>","<password>"
    Then User should verify success message after login "Hello tomriddle!"
    And User should search hotel by entering all fields "<location>","<hotels>","<roomType>","<noOfRooms>","<checkIn>","<checkOut>","<aduldPerRoom>" and "<childPerRoom>"
    Then User should verify the success message after search hotel "Select Hotel"
    And User should click continue without selecting any hotel name
    Then User should verify the error messages "Please Select a Hotel"

    Examples: 
      | userName  | password  | location | hotels      | roomType | noOfRooms | checkIn    | checkOut   | aduldPerRoom | childPerRoom |
      | tomriddle | tomriddle | Sydney   | Hotel Creek | Standard | 1 - One   | 03/09/2022 | 04/09/2022 | 1 - One      | 0 - None     |
