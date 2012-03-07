Feature: Search for things using the google homepage
  
  Scenario: Searching for cats
    Given I have manually accessed the google homepage
    When I manually search for cats
    Then I can manually check that the results are all about cats
    
  Scenario: Searching for dogs
    Given I have accessed the google homepage
    When I search for dogs
    Then I can manually check that the results are all about dogs