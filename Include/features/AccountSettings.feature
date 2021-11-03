@AccountSettings
Feature: AccountSettings Feature
#
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
   Scenario: verify Subscriptions Management
   Given I want to Verify Subscriptions Management Screen For Active Subscribed User
   

   
   
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
   Scenario Outline: verify Add Communication Email
   Given I want to Verify Add communication Email <value>
	  
	     Examples: 
      |  value  |
      |  Invalid|
      |  Used  |
   
 
    
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


      
    #not checked yet      
   #	 @Verify
#	 Scenario Outline: verify Change Password
#	 Given I want to verify Change Password Screen For Users <value>
#	  
#	     Examples: 
      #|    value     |
      #|  Subscribed  |
      #|  Registered  |
