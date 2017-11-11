@SFFlow
Feature: Create a Developer Account inn Sand box
Scenario: Create an account with fake Email
	 Given The user Opened the AUT.
	 And The user Opened the "Guerrilla Mail" .
	 Then the user clicks on "Scramble Address" from "Browser 2" checkbox.
	 Then the user extracts "e-Mail" from "Browser 2".
	 Then user enters "E-mail for Registration" from "temp data" in "Browser 1".
	 Then the user enters "First Name" in "Browser 1".
	 Then the user enters "Last Name" in "Browser 1".
	 Then the user enters "Company" in "Browser 1".
	 Then the user enters "Postal Code" in "Browser 1".
	 Then user enters "Username for Registration" from "temp data" in "Browser 1".
	 Then the user waits for the page to load.
	 Then the user waits for the page to load.	 
	 Then the user clicks on "Eula" from "Browser 1" checkbox.
	 Then the user waits for the page to load.
	 Then the user clicks on "Submit" Button in "Browser 1".
	 Then the user waits for the page to load.
	 Then the user waits for the page to load.
	 Then the user waits for the page to load.	 
	 Then the user waits for the page to load.	
	 Then the user waits for the page to load.	 
	 Then the user waits for the page to load.
	 Then the user clicks on "Welcome to Salesforce: Verify your account" link by searching for "Browser 2".	 
	 Then the user waits for the page to load.	 
	 Then the user clicks on "Verify Account" link in "Browser 2".
	 Then the user waits for the page to load.
	 Then the user switches from "Browser 2" to "Browser 3".
	 Then the user enters "New Password" in "Browser 3".
	 Then the user enters "Confirm New Password" in "Browser 3".
	 Then the user enters "Security Answer" in "Browser 3".
	 Then the user clicks on "Change Password" Button in "Browser 3".	 
	 Then the user waits for the page to load.