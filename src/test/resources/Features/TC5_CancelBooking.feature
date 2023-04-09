@Cancel
Feature: Verifing Adactin cancel booking page

  Scenario Outline: Verifying Adactin cancel booking page by entering generated order id once the complete booking proccess is done
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
      | 1234567890123458 | Master Card      | July     |    2024 | 789 |
    Then User should verify the success message after book a hotel "Booking Confirmation"
    And User should cancel booked hotel with the generated order id
    Then User should verify the success message after cancel booking "The booking has been cancelled."

    Examples: 
      | userName  | password  | location | hotels      | roomType | noOfRooms | checkIn    | checkOut   | aduldPerRoom | childPerRoom | firstName | lastName   | address |
      | tomriddle | tomriddle | Sydney   | Hotel Creek | Standard | 1 - One   | 03/09/2022 | 04/09/2022 | 1 - One      | 0 - None     | Greens    | technology | Omr     |

  Scenario Outline: Verifying Adactin cancel booking page by entering existing order id after successful login
    Given User is on the Adactin login page
    When User should perform login "<userName>","<password>"
    Then User should verify success message after login "Hello tomriddle!"
    And User should cancel booked hotel with existing order id "<orderId>"
    Then User should verify the success message after cancel booking "The booking has been cancelled."

    Examples: 
      | userName  | password  | orderId    |
      | tomriddle | tomriddle | Y9924Z1X70 |
