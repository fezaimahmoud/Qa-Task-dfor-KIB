Feature: Product management

  Background: 
    Given I am on kibe-commerce website

  Scenario Outline: Add new product
    When User click on add button
    And User fill in required fields "<title>", "<description>", and "<price>"
    And User click on create button
    Then User checks the availability of the product with his "<title>"

    Examples: 
      | title         | description                                    | price |
      | iphone 15 pro | it is the expensive apple device in the market |  2700 |

  Scenario Outline: search and edit 
    When User search for product with its "<name>"
    And User click on edit product name with "<newName>"and save
    Then User checks  "<newName>" is saved successfully

    Examples: 
      | name          | newName           |
      | iphone 15 pro | iphone 15 pro max |
Scenario Outline: search and delete product 
    When User search for product with its "<name>"
    And User click on delete button
    Then User checks  product with "<name>" is saved successfully

    Examples: 
      | name          | 
      | iphone 15 pro | 
      
      Scenario Outline: search multiple product 
    When User search for product with its "<name>"
    Then User checks search result contains "<name>"

    Examples: 
      | name          | 
      | 360 |
      
       Scenario Outline: search non existing product 
    When User search for product with its "<name>"
    Then User checks that search tresult contains is empty

    Examples: 
      | name          | 
      | 12345 |