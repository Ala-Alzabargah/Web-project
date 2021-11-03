@ShahidLogin
Feature: Login

  #@VerifyLoginpage
  #Scenario: Verify Login page
    #Given I want to Verify Login page

  @VerifyLoginPasswordpage
  Scenario: Verify Login password page
  Given I want to Verify login password page

  @VerifyValidScenarios
  Scenario Outline: Valid Login
    Given I want to login using valid data <value>

    Examples: 
      | value  |
      | Email  |
      | Mobile |
      
  
  @VerifyValidScenarios
  Scenario: Valid Facebook Login
    Given I want to login Via Facebook using valid data


  @VerifyValidScenarios
  Scenario Outline: Invalid Login
    Given I want to Login using Invalid <value>

    Examples: 
      | value  |
      | Email  |
      | Mobile |

  @VerifyInvalidScenarios
  Scenario: Invalid Password Login
    Given I want to login using Invalid Password

  @ForgetPassword
  Scenario: Forget password
    Given Forget password
    
    @VerifyLoginpage
  Scenario Outline: Verify Login from SVOD Player
    Given I want to Verify Login from SVOD Player <value>
	  
	     Examples: 
      |    value     |
      |  Subscribed  |
      |  Registered  |
      
      
