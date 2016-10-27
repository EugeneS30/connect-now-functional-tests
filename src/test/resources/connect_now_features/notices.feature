@Notices @Classes
Feature: Notices

  Background: Teacher has logged in
    Given I have skipped the welcome page
	And I have logged in as "e2023069" 

  Scenario: A teacher can add a new Notice 
    Given I have added a new Notice to class: "ConnectNowTestClass"
	And I have refreshed the Stream screen
	Then I shall see the Notice in the Stream feed

  @ignore
  Scenario: A teacher can hide a Notice 
    Given I have added a new Notice to class: "ConnectNowTestClass"
	And I have refreshed the Stream screen
	When I bookmark the notice
	And filter the Stream by "Read Later"
	Then I shall see the Notice in the filtered Stream feed
	
  @ignore
  Scenario: A teacher can edit a Notice
    Given I have added a new Notice to class: "ConnectNowTestClass"
	And I have refreshed the Stream screen
	And I shall see the Notice in the Stream feed
	When I edit the Notice
	And I refresh the Stream
	And I shall see the Notice in the Stream feed