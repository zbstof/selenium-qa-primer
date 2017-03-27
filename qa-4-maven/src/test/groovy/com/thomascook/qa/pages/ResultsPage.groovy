package com.thomascook.qa.pages

import geb.Page

class ResultsPage extends Page {
    static at = {
        waitFor { results.size() > 0 }
    }

    static content = {
        stats { $("#resultStats") }
        navigation { $("table#nav td:not(.b)") }
        results { $(".rc") }
        currentNav { $("table#nav td.cur") }
    }

    // actions
    void clickOnNav(Integer navPage) {
        navigation[navPage - 1].click()
    }

    // assertions
    void assertStatText(String text) {
        assert stats.text().startsWith(text)
    }

    void assertNavSize(Integer minPages) {
        assert navigation.size() > minPages
    }

    void assertNumberOfResults(Integer resultsNum) {
        assert results.size() == resultsNum
    }

    void assertPageIsCorrect(Integer pageNum) {
        waitFor { navigation[pageNum - 1] == currentNav }
    }

    void assertTitleIsCorrect(String searchTerm) {
        waitFor { driver.title.contains(searchTerm) }
    }
}