package com.thomascook.qa.pages

import geb.Page

class ResultsPage extends Page {
    static at = {
        waitFor { results.size() > 0 }
    }

    static content = {
        stats { $("#resultStats") }
        navigations { $("table#nav td:not(.b)") }
        currentNavigation { $("table#nav td.cur") }
        results { $(".rc") }
    }

    // actions
    void clickOnNav(Integer navPage) {
        navigations[navPage - 1].click()
    }

    // assertions
    void assertStatText(String text) {
        assert stats.text().startsWith(text)
    }

    void assertNavSize(Integer minPages) {
        assert navigations.size() > minPages
    }

    void assertNumberOfResults(Integer resultsNum) {
        assert results.size() == resultsNum
    }

    void assertPageAttributes(Integer pageNum, String searchTerm) {
        waitFor { title.contains(searchTerm) && navigations[pageNum - 1] == currentNavigation }
    }
}