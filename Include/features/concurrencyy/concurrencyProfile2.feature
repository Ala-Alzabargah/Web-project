@concurrentmanagement
Feature: concurrency management

   @verifiy
  Scenario Outline: concurrency management
    Given i want to watch from more than three users profile2 <value>

    Examples: 
      |    value     |
      |  Subscribed  |