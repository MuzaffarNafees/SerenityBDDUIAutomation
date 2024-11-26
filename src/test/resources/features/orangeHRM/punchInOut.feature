@punchInOut
Feature: Punch In/Out Automation

  Scenario: User can punch in and out successfully
    Given User launches the OrangeHRM web application
    When User enters valid username
    And User enters valid password and logs into the application
    And User clicks on the "Time" section
    And User clicks on the "Attendance" dropdown button
    And User selects "Punch In/Out" from the dropdown
    And User clicks on "Punch In"
    Then After a short time, User clicks on "Punch Out"
    And User clicks on the "Profile" section
    Then User logs out of the application
