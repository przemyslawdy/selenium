Feature: Adding product to cart feature
  Verify if product title is proper and subtotal price in cart is correct

  Scenario: Add product to cart
    Given User is on amazon homepage
    When User chooses category "Electronics, Computers & Office" -> "Camera, Photo & Video" -> "Digital Cameras"
    And User selects item no 5 from Best Sellers
    And User selects 8 pieces and adds product to cart
    And User goes to cart page
    Then Product title is proper and subtotal price in cart is correct

  Scenario: Add product from different category to cart
    Given User is on amazon homepage
    When User chooses category "Electronics, Computers & Office" -> "Software" -> "Operating Systems"
    And User selects item no 1 from Best Sellers
    And User selects 30 pieces and adds product to cart
    And User goes to cart page
    Then Product title is proper and subtotal price in cart is correct
