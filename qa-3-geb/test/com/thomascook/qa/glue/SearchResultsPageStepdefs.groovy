package com.thomascook.qa.glue

import com.thomascook.qa.Util
import com.thomascook.qa.pages.ResultsPage
import groovy.transform.Field

import static cucumber.api.groovy.EN.And
import static cucumber.api.groovy.EN.Then


@Lazy
@Field
ResultsPage page = page as ResultsPage

Then(~/^I am on the (first|second) search results page$/) { String pageNumMarker ->
    at ResultsPage
    page.assertPageIsCorrect(Util.parse(pageNumMarker))
    page.assertTitleIsCorrect(searchTerm)
}
And(~/^I should see (\d+) search results$/) { int results ->
    page.assertNumberOfResults(results)
}
And(~/^Navigation bar shows more than (\d+) 'o's$/) { int minOs ->
    page.assertNavSize(minOs)
}
And(~/^I click on (second) 'o'$/) { String pageNumMarker ->
    page.clickOnNav(Util.parse(pageNumMarker))
}
And(~/^Results are preceded by words '(.*)\.\.\.'$/) { String text ->
    page.assertStatText(text)
}