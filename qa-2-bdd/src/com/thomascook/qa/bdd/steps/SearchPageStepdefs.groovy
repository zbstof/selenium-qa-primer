package com.thomascook.qa.bdd.steps

import com.thomascook.qa.bdd.pages.SearchPage

import static cucumber.api.groovy.EN.Given
import static cucumber.api.groovy.EN.When

def page

Given(~/^I go to google website$/) { ->
    page = new SearchPage()
    page.to()
}
When(~/^I search for '(.*)'$/) { String searchText ->
    searchTerm = searchText
    page.searchFor(searchText)
}