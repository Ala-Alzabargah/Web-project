@UserProfile
Feature: UserProfile

  @VerifyUserProfilePage
  Scenario Outline: Verfiy User Profile Pages
    Given I want to Verfiy User Profiles as <value>
  
        Examples: 
      |    value     |
      |  Subscribed  |
     |  Registered  |
 
  @VerifyUserProfilePage
  Scenario: Verfiy User Profile Page For New User
    Given I want to Check Number of User Profile For New User

  @VerifyAdultUserProfile
  Scenario: Verify Add Adult User Profile
    Given I want to Add New Adult User Profile
    
    
  @VerifyAdultUserProfile
  Scenario: Verify Update Adult User Profile
   Given I want to Update Adult User Profile

  @VerifyAdultUserProfile
  Scenario: Verify change Adult User Profile
    Given I want to change Adult User Profile to Kids User Profile
   

  @VerifyKidsUserProfile
  Scenario: Verify Delete Kids User Profile
    Given I want to Delete Kids User Profile

  @VerifyKidsUserProfile
  Scenario: Verify Kids User Profile
    Given I want to Active the Kids interface

  @VerifyKidsUserProfile
  Scenario: Verify Add Kids User Profile
    Given I want to Add New Kids User Profile

  @VerifyKidsUserProfile
  Scenario: Verify Update Kids User Profile
    Given I want to Update Kids User Profile

  @VerifyKidsUserProfile
  Scenario: Verify change Kids User Profile
    Given I want to change Kid User Profile to Adult User Profile
    

  @VerifyAdultUserProfile
  Scenario: Verify Delete Adult User Profile
    Given I want to Delete Adult User Profile

  @EnableKidsMode
  Scenario: Enable Kids Mode
    Given I want to Enable Kids Mode
