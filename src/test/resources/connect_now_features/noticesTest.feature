@Notices @Classes
Feature: Notices

  Background: Teacher has logged in
    Given I have skipped the welcome page
	And I have logged in as "e2023069"
	And the stream is clean
	And I have added a new Notice to class: "ConnectNowTestClass"
	And I have refreshed the Stream screen 

  Scenario: A teacher can add a new Notice 
	Then I shall see the Notice in the Stream feed

  @wip
  Scenario: A teacher can bookmark a Notice
	When I bookmark the notice
	And filter the Stream by "Read Later"
	Then I shall see the Notice in the filtered Stream feed
	
  @ignore
  Scenario: A teacher can edit a Notice
	When I edit the Notice
	And I refresh the Stream
	And I shall see the Notice in the Stream feed
	
  @ignore
  Scenario: A teacher can hide a Notice
    When I hide a Notice
    Then I shall not see the Notice in the filtered Stream feed
	
  @Native
  Scenario: A teacher can follow a Notice
    When I follow a Notice
    And I refresh the Stream
    Then something should happen