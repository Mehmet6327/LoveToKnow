Feature:

  @wip1
  Scenario: Corresponding term present and visible
    Given the user is in the main page
    When the user searches for "congratulations"
    Then the page title should contains "congratulations"
    Then the "congratulations" should be visible on the page

  @wip2
  Scenario: Validating the title and the table have same number
    Given the user is in the main page
    When the user searches for "apple"
    Then the number of words in the title and in the table should be equal

  @wip3
  Scenario: Find the word with the LEAST points
    Given the user is in the given page
    When the user sorts all words
    Then the user should see the word with the LEAST points

  @wip4
  Scenario:Sorting result by "A-Z"
    Given the user is in the given page
    When the user sorts all words
    And the user sort result by "A-Z"
    Then the user should see the sorted result

  Scenario: Sorting result by "Z-A"
    Given the user is in the given page
    When the user sorts all words
    And the user sort results by "Z-A"
    Then the user should see the sorted results

  @wip5
  Scenario: Back to top button
    Given the user is in the main page
    When the user scroll down to the bottom
    Then “back to top”button is not shown in the browser


