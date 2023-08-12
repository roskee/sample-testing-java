Feature: Add to cart

  Scenario: Successful add to cart
    Given I am logged in
    When I click add to cart on the item "sauce-labs-backpack"
    Then the add to cart button should change to "Remove"
    And the cart icon should have a badge "1"
    And the cart page should have the item "Sauce Labs Backpack"
    And the price of the item should be "$29.99"