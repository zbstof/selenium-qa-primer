package com.thomascook.qa.glue

import com.thomascook.qa.pages.SearchPage

import static cucumber.api.groovy.EN.Given
import static cucumber.api.groovy.EN.When

SearchPage page

Given(~/^I go to google website$/) { ->
    page = new SearchPage(driver)
    page.to()
}
When(~/^I search for '(.*)'$/) { String searchText ->
    searchTerm = searchText
    page.searchFor(searchText)
}