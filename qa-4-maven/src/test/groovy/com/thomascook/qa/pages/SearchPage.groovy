package com.thomascook.qa.pages

import geb.Page
import org.openqa.selenium.Keys

class SearchPage extends Page {

    static at = {
        title == "Google"
    }

    static url = "http://www.google.com"

    static content = {
        searchField { $(name: "q") }
    }

    // actions
    void searchFor(String queryString) {
        searchField.value(queryString)
        interact { sendKeys(Keys.ENTER) }
    }
}

