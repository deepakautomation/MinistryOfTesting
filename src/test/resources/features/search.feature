@prod
Feature: Search Functionality
  In order to perform sucessful search test
  As a user
  I want to data in searchbox and make a search corresponding to that

Scenario Outline: Verify that user is able to search the item
  	Given I am on the Login page URL "https://www.ministryoftesting.com/signin?return_to_referer=yes"
    When I enter username as "qecandidate"
    And I enter password as "MUCT-air0tuss3sars"
    And click on login button
		When click on discussion link
    Then I click on search Icon
    Then I enter "<searchInput>" as search Input
    Then search results values should be displayed as "<DisplayedData>" as per Search Input
Examples:
    |searchInput   |DisplayedData          |
    |mabl          |mabl                   |
