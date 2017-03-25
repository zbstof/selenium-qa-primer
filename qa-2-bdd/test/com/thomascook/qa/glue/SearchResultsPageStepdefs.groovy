package com.thomascook.qa.glue

import com.thomascook.qa.Util
import com.thomascook.qa.pages.ResultsPage

import static cucumber.api.groovy.EN.And
import static cucumber.api.groovy.EN.Then

ResultsPage page

Then(~/^I am on the (first|second) search results page$/) { String pageNumMarker->
    page = new ResultsPage(driver)
    page.at()
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