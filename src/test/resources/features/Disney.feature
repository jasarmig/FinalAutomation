Feature: User navigates to map and checks options

  Scenario: Category list test
    Given user is in the dashboard
    Then map button is available

    When user taps on map option
    Then map view is shown

    When user taps on category list
    Then categories are listed and hotel option is available

  Scenario: Privacy and legal
    Given user is in the dashboard
    And user taps on menu button
    Then a menu is displayed and

    When user taps on Privacy and Legal
    Then privacy and legal screen is displayed

    When user can see a list of options
    Then the screen displays 6 options

  Scenario: Add plans option
    Given user is in the dashboard
    When user taps on plans options
    Then reserve dining option is in the list
