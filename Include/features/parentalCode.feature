
@tag
Feature: Parental Control


@Verify
	 Scenario Outline: verify Parental Control
	 Given I want to Verify Parental control interface For Users <value>
	  
	     Examples: 
      |    value     |
      |  Subscribed  |
      |  Registered  |