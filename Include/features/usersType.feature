
Feature: users type 
  
 @Verify
	 Scenario Outline: verify Account Settings Elements
	 Given I want to Verify AccountSettings For Users <value>
	  
	     Examples: 
      |    value     |
      |  Subscribed  |
      |  Registered  |
      | sportsubscribed |
      |  MobileOnly  |
      
       @Verify
	 Scenario Outline: verify Not Matched Password
	 Given I want to verify entering not matched password at NewPassword confirmNewPassword fields <value>
	  
	     Examples: 
      |    value     |
      |  Subscribed  |
      |  Registered  |
      
     
      
        @Verify
	 Scenario Outline: verify Wrong Current Password
	 Given I want to verify enter wrong Password at current password field <value>
	  
	     Examples: 
      |    value     |
      |  Subscribed  |
      |  Registered  |
      
           @Verify
	 Scenario Outline: verify Personal Info
	 Given I want to Verify Personal Info Screen For Users <value>
	  
	     Examples: 
      |    value     |
      |  Subscribed  |
      |  Registered  |
      
      
       @Verify
	 Scenario Outline: verify Devices Management Elements
	 Given I want to Verify Devices Management Screen For Users <value>
	  
	     Examples: 
      |    value     |
      |  Subscribed  |
      |  Registered  |

    
       @Verify
	 Scenario Outline: verify Parental Control
	 Given I want to Verify Parental control interface For Users <value>
	  
	     Examples: 
      |    value     |
      |  Subscribed  |
      |  Registered  |
 
      
            
       @Verify
	 Scenario Outline: verify Special Features
	 Given I want to verify Special Features Section For Users <value>
	  
	     Examples: 
      |    value     |
    |  Subscribed  |
      |  Registered  |



   
       @Verify
	 Scenario Outline: verify View Previous Operations
	 Given I want to Verify View previous operations Screen <value>
	  
	     Examples: 
      |    value     |
      |  Registered  |

      
      @Verify
	 Scenario Outline: verify VIP tag
	 Given I want to Check if user is VIP <value>
	  
	     Examples: 
      |    value     |
      |  Subscribed  |
      |  Registered  |
      
      
      
        @Verify
	 Scenario Outline: verify Empty Favorite Page
	 Given I want to Verify Empty Favorite Page <value>
	  
	     Examples: 
      |    value     |
      |  Subscribed  |
      |  Registered  |
      
      
             @Verfiy
  Scenario Outline: Verfiy add
    Given I want to Add <asset> To Favorite from Movie and Show Pages for <user>
    
     Examples: 
    | asset   |    user     | 
    |  shows  | Subscribed  | 
    |  movies | Registered  |
    |  movies |  Anonymous  |
    
    @Verify
	 Scenario Outline: verify Home Page Elements
	 Given I want to verify Shahid Home Page Elements for <value>
	  
	   Examples: 
   |  value   |
   | Subscribed |
   | Registered |
   | Anonymous |
   | sportsubscribed |
     
      @Verify
	 Scenario Outline: verify Home Page Elements Clickable
	 Given I want to Check Shahid Home Page Elements Clickable <value>
	  
	     Examples: 
      |    value     |
      |  Subscribed  |
      |  Registered  |
      |  Anonymous  |
       | sportsubscribed |
       
       
       
 
  @Verfiy
  Scenario Outline: Verfiy Live streaming
    Given I want to Verfiy Live streaming for <user> with <profile>
    
     Examples: 
      |    user     | profile |
      | Subscribed  |  Adult  |
      | Registered  |   Kid   |
      
      
      
      @Verify
	 Scenario Outline: verify Five Minutes Label
	 Given I want to check five minutes label for <value>
	  
	     Examples: 
      |    value     |
      |  Subscribed  |
      |  Registered  |
      |  Anonymous  |
      
      
      @VerifyLoginpage
  Scenario Outline: Verify Login from SVOD Player
    Given I want to Verify Login from SVOD Player <value>
	  
	     Examples: 
      |    value     |
      |  Subscribed  |
      |  Registered  |
      
      
       @Verify
	 Scenario Outline: Verify clickable elements in movie player
	  Given I want to verify clickable elements in movie player for <value>
	    
	      Examples: 
      |    value     |
      |  Anonymous   |
      |  Subscribed  |
      |  Registered  |
       | sportsubscribed |
       | MobileOnly | 
       
        @Verify
  Scenario Outline: Verify clickable elements in show player
    Given I want to verify clickable elements in show player for <value>
    
         Examples: 
      |    value     |
      |  Anonymous   |
      |  Subscribed  |
      |  Registered  |
      | sportsubscribed |
       | MobileOnly | 
       
       @VerifyUserProfilePage
  Scenario Outline: Verfiy User Profile Pages
    Given I want to Verfiy User Profiles as <value>
  
        Examples: 
      |    value     |
      |  Subscribed  |
     |  Registered  |