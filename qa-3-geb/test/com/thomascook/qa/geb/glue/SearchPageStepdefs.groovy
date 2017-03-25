package com.thomascook.qa.geb.glue

import com.thomascook.qa.geb.pages.SearchPage
import groovy.transform.Field

import static cucumber.api.groovy.EN.Given
import static cucumber.api.groovy.EN.When

@Lazy
@Field
SearchPage page = page as SearchPage

Given(~/^I go to google website$/) { ->
    to SearchPage
}
When(~/^I search for '(.*)'$/) { String searchText ->
    searchTerm = searchText
    page.searchFor(searchText)
}