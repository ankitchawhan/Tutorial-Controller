Feature: Tutorial feature
  Background: Creating a user
    Given user details

  Scenario: Verify that user resource can be created
    When creating a user
    Then user must be created

  Scenario: Verify that user updated successfully
    When creating a user
    And updating user
    Then user got updated

  Scenario: Verify that user deleted successfully
    When creating a user
    Then user got deleted

  Scenario: Verify that user description gets updated
    When creating a user
    Then user description gets updated

  Scenario: Verify that title field is required
    Given user details
    When creating without title
    Then error shown

  Scenario: Verify that title should only be test
    Given user details
    When creating with title
    Then title should be test

  Scenario: Verify error is thrown when title is given in alphanumeric characters
    Given details
    When modifying details
    Then error thrown

  Scenario: Verify the description getting updated
    Given details
    When creating description
    Then description gets updated

  Scenario: Verify the id should not accept alphanumeric characters
    Given test details
    When creating id with alphanumeric char
    Then error is shown



