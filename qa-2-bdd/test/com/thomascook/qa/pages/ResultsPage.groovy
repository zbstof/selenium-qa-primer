package com.thomascook.qa.pages

import com.thomascook.qa.Util
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

class ResultsPage extends Page {

    ResultsPage(WebDriver driver) {
        super(driver)
    }

    void at() {
        Util.waitFor { results.size() > 0 }
    }

    // page content
    private WebElement getStats() {
        return driver.findElement(By.cssSelector("#resultStats"))
    }

    private List<WebElement> getNavigation() {
        return driver.findElements(By.cssSelector("table#nav td:not(.b)"))
    }

    private List<WebElement> getResults() {
        return driver.findElements(By.cssSelector(".rc"))
    }

    private WebElement getCurrentNav() {
        return driver.findElement(By.cssSelector("table#nav td.cur"))
    }

    // actions
    void clickOnNav(Integer navPage) {
        navigation.get(navPage - 1).click()
    }

    // assertions
    void assertStatText(String text) {
        assert stats.text.startsWith(text)
    }

    void assertNavSize(Integer minPages) {
        assert navigation.size() > minPages
    }

    void assertNumberOfResults(Integer resultsNum) {
        assert results.size() == resultsNum
    }

    void assertPageIsCorrect(Integer pageNum) {
        Util.waitFor { navigation.get(pageNum - 1) == currentNav }
    }

    void assertTitleIsCorrect(String searchTerm) {
        Util.waitFor { driver.title.contains(searchTerm) }
    }
}