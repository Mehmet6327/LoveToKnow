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

