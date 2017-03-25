package com.thomascook.qa.bdd.pages

import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement

class SearchPage extends Page {

    void at() {
        assert driver.getTitle() == "Google"
    }

    void to() {
        driver.navigate().to("http://www.google.com")
    }

    // page content
    private WebElement searchField() {
        WebElement queryElement = driver.findElement(By.name("q"))
        return queryElement
    }

    // actions
    void searchFor(String queryString) {
        WebElement queryElement = searchField()
        queryElement.sendKeys(queryString)
        queryElement.sendKeys(Keys.ENTER)
    }
}

