Feature: example test
  Background: before test
    Given test options
  Scenario: go to amazon and add the product to cart
    Given go to amazon
    And searches for a product on the homepage
    Then selects a product in the search results and navigates to the product page
    And adds the product to the cart
    Then checks the product by going to the cart page