#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.

@FontendTest
Feature: Frontend Automation 

  @frontend
  Scenario: Age Validation
    Given I launch the application as "url"
    When I click on Jetzt Beitrag berechnen
    And I select Angestellt
    And I enter an income as "income"
    And I click on Weiter
    And I select Vollversicherung and enter date as "startDate"
    And I click on Weiter
    Then I validate the age with birthdate
    And I validate the future birth date


