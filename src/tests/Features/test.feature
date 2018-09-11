Feature: Adding product to cart feature
  Verify if product title is proper and subtotal price in cart is correct

  Scenario: Add product to cart
    Given User is on amazon homepage
    When User chooses category
    And User selects item from Best Sellers
    And User selects quantity and adds product to cart
    And User goes to cart page
    Then Product title is proper and subtotal price in cart is correct
