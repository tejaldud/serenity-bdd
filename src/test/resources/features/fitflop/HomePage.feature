Feature: Checkout Journey

  @login_web @viewcategories
  Scenario: verify all categories on home page
    Given I request to access home page
    And I verify the categories displayed on page
      | UMA THURMAN |
      | NEW IN      |
      | WOMENS      |
      | MENS        |
      | SALE        |
      | OUTLET      |
      | OUR SCIENCE |


  @login_web @checkout
  Scenario: Select product and checkout
    Given I request to access home page
    And I verify the categories displayed on page
      | UMA THURMAN |
      | NEW IN      |
      | WOMENS      |
      | MENS        |
      | SALE        |
      | OUTLET      |
      | NEW IN      |
      | OUR SCIENCE |
    And I select 'UMA THURMAN' category
    And I want to buy shoes of sub category 'Sneakers'
    And I select product to view
    And I select color "Fire Red" and size as "3" and add product to cart
    And I go to cart
    And I click on checkout
    And I select guest checkout
    And I enter my details and click on continue


