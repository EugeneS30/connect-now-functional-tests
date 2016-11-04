@Notices @Classes
Feature: Notices

  Background: Teacher has logged in
    Given I have skipped the welcome page
	And I have logged in as "e2023069" 

  Scenario: A teacher can add a new Notice
    Given the stream is clean
	And I have refreshed the Stream screen