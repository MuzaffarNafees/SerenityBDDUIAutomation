Feature: Login to OrangeHRM Demo
@orange_HRMLogin

  Scenario: User logs in with valid credentials
    Given the user is on the OrangeHRM login page
    When the user enters username "Admin" and password "admin123"
    And clicks on the login button
    Then the user should be redirected to the dashboard
