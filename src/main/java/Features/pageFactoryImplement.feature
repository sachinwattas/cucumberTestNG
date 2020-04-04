Feature: Mail Login feature with page factory
  @PageFactory
  Scenario Outline: login test scenario with Page factory concept
    Given User is already on Home page
    When User click on login button
    Then User enters another "<Username>" and "<Password>"
    And User submit on login button
    Examples:
      | Username | Password |
      |TestWithCucumber|test123|
    |Test2           |   test345    |
