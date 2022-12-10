Feature: User creates account, navigates to watch page and returns to home, finally logs out.

  Scenario: Create a new account
    Given user is on "https://www.espnqa.com/?src=com&_adblock=true&espn=cloud"
    When user clicks on login button
    Then the login iframe opens

    When user clicks on sign up button
    Then a new frame is displayed

    When user enters the new account information: "Jaime" and "Sarmiento" and "je.sarmiento+580@globant.com" and "N0seasap0"
    And clicks on sign up
    Then user is logged in

  Scenario: User navigates to watch page
    Given user is on "https://www.espnqa.com/?src=com&_adblock=true&espn=cloud"
    And user logs in with email "je.sarmiento+580@globant.com" and password "N0seasap0"
    When user clicks on Watch button
    Then the watch page is opened

    When user clicks on the second element of the first carousel
    Then a lightbox is displayed and has a close button

    When user closes the lightbox
    Then user goes back to homepage

  Scenario: User logs out
    Given user is on "https://www.espnqa.com/?src=com&_adblock=true&espn=cloud"
    And user logs in with email "je.sarmiento+560@globant.com" and password "N0seasap0"
    Then his name: "Jaime" is displayed

    When user clicks on log out button
    Then user is logged out