@ShowScreen
Feature: Show

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