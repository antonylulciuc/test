@Feature
Feature: Log into Mercury

	Background:
		Given Open landing page
		Given I am at the landing of Mercury

	@smoke
	Scenario: Can we even login
		When I login with "bobert" and password "bobbert"
		Then I should be at the find flights page
		
	@regression
	Scenario Outline:
		When I login with "<username>" and "<password>"
		Then I arrive at the findFlights page
		
		Examples:
			| username  | password  |
			| bobbert   | bobbert   |
			| tropicana | tropicana |
			 