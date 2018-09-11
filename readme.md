# Selenium project for Amazon website
## How to execute tests

1. Install Java IDE - preferably IntelliJ IDEA and Firefox web browser.
2. Checkout a repository from GitHub and create a new project based on it (maven project).
3. All dependencies should be resolved automatically.
4. Run cucumber test runner class (src/tests/runner/runner.java).
5. Test results should be visible immediately in IDE. Additionally html report will be saved to '/target/html/' path.

## What is going to happen


1. New Firefox window with Amazon main page will be opened.
2. The category for product will be chosen (Departments -> Main category -> Detailed category).
3. Best Sellers page for chosen category will be opened.
4. The most detailed category will be chosen.
5. Product page for specified product will be opened.
6. Item will be added to the cart.
7. Product name and subtotal price in cart will be verified.
8. Feature file for cucumber can be easily modified by changing product category, item number on best sellers page and number of items being added to the cart.

----
## created by
` Przemysław Dyrda`
