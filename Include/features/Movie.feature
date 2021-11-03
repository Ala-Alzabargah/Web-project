@MovieScreen
Feature: Movie
	
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
  
 