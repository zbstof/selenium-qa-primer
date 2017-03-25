package com.thomascook.qa.bdd.steps

import com.thomascook.qa.bdd.Util
import com.thomascook.qa.bdd.pages.ResultsPage
import cucumber.api.groovy.EN

this.metaClass.mixin(EN)

ResultsPage page

Then(~/^I am on the (first|second) search results page$/) { String pageNumMarker->
    page = new ResultsPage(Util.parse(pageNumMarker), searchTerm)
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