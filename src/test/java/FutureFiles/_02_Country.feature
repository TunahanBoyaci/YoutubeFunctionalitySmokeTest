Feature: Country Functionality
  As a user, I want to be able to create and update countries
  so that I can update the country list

  Background:
    Given Navigate to Campus
    And Enter username and password
    And Click on login Button
    And Navigate to Country page

  @Smoke
  Scenario: Create a new country
    When Create a new country
    Then Success message should be displayed
