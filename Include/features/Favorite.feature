@FavoriteScreen
Feature: Favorite Screen

    @Verify
	 Scenario Outline: verify Empty Favorite Page
	 Given I want to Verify Empty Favorite Page <value>
	  
	     Examples: 
      |    value     |
      |  Subscribed  |
      |  Registered  |
      
#scenario not working 
    #@Verify
#	 Scenario Outline: verify Add Asset To Favorite From Hero Home Page
#	 Given I want to Add Asset To Favorite from Home Page <value>
#	  
#	     Examples: 
      #|    value     |
      #|  Subscribed  |
      #|  Registered  |


        @Verfiy
  Scenario Outline: Verfiy add
    Given I want to Add <asset> To Favorite from Movie and Show Pages for <user>
    
     Examples: 
    | asset   |    user     | 
    |  shows  | Subscribed  | 
    |  movies | Registered  |
    |  movies |  Anonymous  |
      
  #scenario not working because of my list button 
#	  @Verfiy
  #Scenario Outline: Verfiy Empty Favorite Page in Kids Profile
    #Given Verify Empty Favorite Page in Kids Profile <user>
    #
     #Examples: 
    #|   user      |
    #|  Subscribed |
    #| Registered  |