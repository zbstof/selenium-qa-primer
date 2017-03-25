package com.thomascook.qa.maven.pages

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
    void clickOnNav(int navPage) {
        navigations[navPage - 1].click()
    }

    // assertions
    void assertStatText(String text) {
        assert stats.text().startsWith(text)
    }

    void assertNavSize(int minPages) {
        assert navigations.size() > minPages
    }

    void assertNumberOfResults(int resultsNum) {
        assert results.size() == resultsNum
    }

    void assertPageAttributes(int pageNum, String searchTerm) {
        waitFor { title.contains(searchTerm) && navigations[pageNum - 1] == currentNavigation }
    }
}