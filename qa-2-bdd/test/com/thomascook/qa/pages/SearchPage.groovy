package com.thomascook.qa.pages

import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

class SearchPage extends Page {

    SearchPage(WebDriver driver) {
        super(driver)
    }

    void at() {
        assert driver.title == "Google"
    }

    void to() {
        driver.navigate().to("http://www.google.com")
    }

    // page content
    private WebElement getSearchField() {
        return driver.findElement(By.name("q"))
    }

    // actions
    void searchFor(String queryString) {
        searchField.sendKeys(queryString)
        searchField.sendKeys(Keys.ENTER)
    }
}

