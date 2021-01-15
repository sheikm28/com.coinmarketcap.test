
@Test
Feature: Coin Market Cap UI Test
 Want to verify that the user can view 100 records on the website at once

  Scenario: View 100 records
    Given The user navigates to https://coinmarketcap.com/
    When I select show 100 records
    Then The page displays 100 records successfully


