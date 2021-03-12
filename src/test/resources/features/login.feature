Feature: Login Functinality
In order to perform sucessful login
As a user
I want to enter correct username and password
and for invalid credentials user should not be allowed to login


    
Scenario Outline: Verify the login functionality with valid and invalid credentials
  	Given I am on the Login page URL "https://www.ministryoftesting.com/signin?return_to_referer=yes"
    When I enter username as "<username>"
    And I enter password as "<password>"
    And click on login button
    Then user "<Logintype>" sucessfully logged in
Examples:
    |username   |password          |Logintype |
    |qecandidate|MUCT-air0tuss3sars|should    |
    |invalid    |MUCT-air0tuss3sars|shouldnot |
    |qecandidate|invalid           |shouldnot |
    |invalid    |invalid           |shouldnot |
    |           |                  |shouldnot |
    
    

    