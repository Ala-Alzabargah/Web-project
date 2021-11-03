@ForgetPassword 
Feature: ForgetPassword Feature

  @Valid
  Scenario Outline: Valid Forget Password
    Given I Navigate To Shahid.net
    When I Click On Shahid SignIn
    Then I Click Forget Password Link
    Then I Enter Username <Username> & <Captcha>
    Then I Click on Forget Password Submit 

  Examples: 
      |Username|Captcha|
      |automationtest2@mbc.net|Valid|
      
      
  @Valid
  Scenario: Click Back Link at Forget Passwoed Page
    Given I Navigate To Shahid.net
    When I Click On Shahid SignIn
    Then I Click Forget Password Link
    Then I Click Back Link at Forget Passwoed Page
            
   @Verfiy
  Scenario: Verify Forget Password wedgit Text
    Given I Navigate To Shahid.net
    When I Click On Shahid SignIn 
    Then I Click Forget Password Link
    Then I Verfiy Forget Password wedgit Text
    
   #@Verfiy
  #Scenario Outline: Verfiy Success Forget Passwoed Page
    #Given I Navigate to Shahid.net
    #When I Click on Shahid SignIn
    #Then I Click Forget Password Link
    #Then I Click on Forget Password Submit 
    #Then I Enter Username <Username> & <Captcha>
    #Then I Click on Forget Password Submit 
    #Then I Verfiy Success Forget Passwoed Page
#
  #Examples: 
      #|Username|Captcha|
      #|automationtest2@mbc.net|Valid|
      
      
  
    