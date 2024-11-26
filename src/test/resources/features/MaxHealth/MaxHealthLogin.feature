@Max_Login

Feature:  Login to Max Healthcare Authentication Page
Scenario Outline: Successful login with valid credentials

Given user launches the HIS URL
When user enters the "<username>" , "<password>" and enters the "<location>" and "<station>"
And user clicks on login button
And user launches the nursing URL
Then user gets redirected to the nursing dashboard where entered username appears on the top
And user clicks on select station section and search for the location
And user select one patient from that station
And user redirects on patient overeview page with the details of the patient
And user clicks on orders section
And user clicks on investigations tab
And user clicks on New button
And user clicks on All dropdown and selects pathalogy
And user search for CBC and clicks on it
And user clicks on performance doctor list and select a doctor
And user clicks on save button and user enters an electronic sign and clicks on save button
Then added investigation should appears with status tag "PENDING"

Examples:
|username | password | location | station    |
|Muzaffar | abc123   |  Delhi   |BLK Hospital|
