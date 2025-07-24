Feature: User Experience - Search Routes
  Scenario: Verify search page features
    Given Launch the "chrome" browser
    And Navigate to "BASE_URL"
    When User click on the "From" location input box
    And Enter "Mumbai"
    And Wait for the auto-suggestions to appear
    And Select "Mumbai" from the suggestions
    When User click on the "To" location input box
    And Enter "Pune"
    And Wait for the auto-suggestions to appear
    And Select "Pune" from the suggestions
    And Click on the search buses button
#    And Enable the "Primo" filter option
#    And Enable the "Evening" filter option
#    Then User should see the search result page
#    And User should be able to scroll down until the "End of list" message appears