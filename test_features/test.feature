Feature: Checkout

  Scenario: Checkout bananas
    Given the price of a "banana" is 40c
    When I checkout <count> "banana"
    Then the total price should be <total>c