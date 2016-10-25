@Notices @Classes
Feature: Notices

  Background: Teacher has logged in
    Given I have skipped the welcome page
	And I have logged in as "e2023069" 

  Scenario: A teacher can add a new Notice 
    When I add a new Notice to the class: "ConnectNowTestClass"
	And I have refreshed the Stream screen
	Then the Notice should appear in Stream