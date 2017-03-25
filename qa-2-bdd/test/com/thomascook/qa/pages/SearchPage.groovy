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

