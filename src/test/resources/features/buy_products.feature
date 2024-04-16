Feature: User buy in demoblaze

  Scenario Outline: A user wants to buy on demoblaze
    Given i want to buy product in "https://www.demoblaze.com/"
    When select category and product
      | category | <category> |
      | product  | <product>  |
    And go to cart and pay
    Then verify that shop are successfully with message "Thank you for your purchase!"
    Examples:
      | category | product           |
      | Phones   | Samsung galaxy s6 |
      | Laptops  | Sony vaio i5      |
      | Monitors | Apple monitor 24  |