@TestDemoWithOutline
Feature: Landing Page Test.
Scenario Outline: Test Scenario Example.
	Given The user Opened the AUT.
	And The user hovers on "Banking Link" to go to "Checking for Commercial Banking".
	#Then The user scrolls to "Banking Link".
	#Then the user clicks on "Checking" link.
	And The user will reach to "Select Your Region" Page.
	And The user selects "<State Name>" value from "State" drop down.
	And The user selects "<City Name>" value from "City" drop down.
	Then The user clicks on "Go" Button.	
	And The user will reach to "Commercial Checking Account" Page.
	Then The user clicks on "Get Started Button" Button.	
	And The user will reach to "Request a call from a Business Banking Specialist" Page.
	Then The user inputs "Contact name" as "<Contact name>".
	Then The user inputs "Phone Number" as "<Phone Number>".
	And The user selects "<State Short Name>" value from "State" drop down.	
	Then The user inputs "E-mail" as "<E-mail>".
	Then The user inputs "Business name" as "<Business name>".
	Then The user inputs "Year established" as "<Year established>".
	And The user selects "<Contact time>" value from "Contact time" drop down.	
	Then The user clicks on "Are you a current TD Bank customer?: Yes" Radio Button.	
	Then The user clicks on "Business Loan or Line of Credit" Radio Button.	
	Then The user scrolls to "Additional Details".
	Then The user inputs "Additional Details" as "nothing to say".
	Then The user clicks on "Send Request Now" Button.	
	And The user will reach to "Contact a Business Lending Officer - Thank you" Page.
Examples:
| State Name | City Name     | Contact name | Phone Number |State Short Name | E-mail       |Business name  |Year established|Contact time|
| New York   | New York City |  abcd        |  2126965263  |       NY        | ab@gmail.com |   Business1   |     2017       |   Morning  |
| New York   | New York City |  abcde        |  2126965263  |       NY        | ab@gmail.com |   Business1   |     2017       |   Morning  |