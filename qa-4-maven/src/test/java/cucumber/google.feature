Feature: As a Webrio user, I want to look up my project on google, so that I can feel important

  Scenario: I look up webrio on google
    Given I go to google website
    When I search for 'webrio thomas cook'
    Then I am on the first search results page
    And I should see 10 search results

  Scenario: I should be able to successfully navigate to second page
    Given I go to google website
    When I search for 'webrio thomas cook'
    Then I am on the first search results page
    And Navigation bar shows more than 2 'o's
    And I click on second 'o'
    And I am on the second search results page
    And Results are preceded by words 'Сторінка 2...'