Feature: Mail Login feature
  Scenario Outline: Mail login test scenario with exmple
    Given User is already on login page
    When Title of login page is All in one
    Then user go to login page
    Then User enter another "<username>" and "<password>"
    And User clicks on login button
    Examples:
      |username |password|
      |testdata|test234|
      |anotherData|test345|

@RegressionTest
  Scenario: Login without example keyword
    Given User is already on login page
    When Title of login page is All in one
    Then user go to login page
    Then User enter "Sachin" and "test123"
    And User clicks on login button

@SmokeTest
  Scenario: Mail login test scenario with datatable
    Given User is already on login page
    When Title of login page is All in one
    Then user go to login page
    Then User enters username and password with data table
      |tom123|test78755|
    And User clicks on login button

@RegressionTest @SmokeTest
  Scenario: Mail login test scenario with data map
    Given User is already on login page
    When Title of login page is All in one
    Then user go to login page
    Then User enters username and password with data driven
      |Usernames|pwd|
      |Driven|dataDriven|
      | DrivenAnother|Set|
    And User clicks on login button