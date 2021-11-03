@SignUpPage
Feature: SignUp

  #@Verifycreateaccountpage
  #Scenario: Verify create account page
    #Given I want to Verify create account page
    #Then I want to Verify create account page form Try ShahidVIP Button
    #Then I want to Verify create account page form Player
#
  #@VerifySignUPSteps
  #Scenario: Verify SignUP Steps
  #Given I want to Verify SignUP Steps
  #Then I want to Verify SignUP Steps form Try ShahidVIP Button

  
  
  @VerifyInvalidScenarios
  Scenario Outline: Invalid Username Signup
    Given I want to Signup using Invalid <value>

    Examples: 
      | value  |
      | Email  |
      | Mobile |
  