@Booking
Feature: Verifing Adactin book a hotel page details

  Scenario Outline: Verifying Adactin book hotel page by entering all fields
    Given User is on the Adactin login page
    When User should perform login "<userName>","<password>"
    Then User should verify success message after login "Hello tomriddle!"
    And User should search hotel by entering all fields "<location>","<hotels>","<roomType>","<noOfRooms>","<checkIn>","<checkOut>","<aduldPerRoom>" and "<childPerRoom>"
    Then User should verify the success message after search hotel "Select Hotel"
    And User should select hotel name and click continue
    Then User should verify the success message after selecting a hotel name "Book A Hotel"
    And User should book a hotel by entering all the required fields "<firstName>","<lastName>" and "<address>"
      | cardNo           | cardType         | expMonth | expYear | cvv |
      | 1234567890123456 | VISA             | May      |    2022 | 123 |
      | 1234567890123457 | American Express | June     |    2023 | 456 |
      | 1234567890123458 | VISA             | July     |    2024 | 789 |
    Then User should verify the success message after book a hotel "Booking Confirmation"

    Examples: 
      | userName  | password  | location | hotels      | roomType | noOfRooms | checkIn    | checkOut   | aduldPerRoom | childPerRoom | firstName | lastName   | address |
      | tomriddle | tomriddle | Sydney   | Hotel Creek | Standard | 1 - One   | 03/09/2022 | 04/09/2022 | 1 - One      | 0 - None     | Greens    | technology | Omr     |

  Scenario Outline: Verifying Adactin book hotel page without entering any fields
    Given User is on the Adactin login page
    When User should perform login "<userName>","<password>"
    Then User should verify success message after login "Hello tomriddle!"
    And User should search hotel by entering all fields "<location>","<hotels>","<roomType>","<noOfRooms>","<checkIn>","<checkOut>","<aduldPerRoom>" and "<childPerRoom>"
    Then User should verify the success message after search hotel "Select Hotel"
    And User should select hotel name and click continue
    Then User should verify the success message after selecting a hotel name "Book A Hotel"
    And User should click on book now without entering any fields
    Then User should verify the error message "Please Enter your First Name","Please Enter you Last Name","Please Enter your Address","Please Enter your 16 Digit Credit Card Number","Please Select your Credit Card Type","Please Select your Credit Card Expiry Month" and "Please Enter your Credit Card CVV Number"

    Examples: 
      | userName  | password  | location | hotels      | roomType | noOfRooms | checkIn    | checkOut   | aduldPerRoom | childPerRoom |
      | tomriddle | tomriddle | Sydney   | Hotel Creek | Standard | 1 - One   | 03/09/2022 | 04/09/2022 | 1 - One      | 0 - None     |
