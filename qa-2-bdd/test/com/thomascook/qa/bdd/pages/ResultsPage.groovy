package com.thomascook.qa.bdd.pages

import com.thomascook.qa.bdd.Util
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

class ResultsPage extends Page {

    private int pageNum
    private String searchTerm

    ResultsPage(Integer pageNum, String searchTerm) {
        assert pageNum >= 1
        this.pageNum = pageNum
        this.searchTerm = searchTerm
    }

    void at() {
        while (!driver.getTitle().contains(searchTerm)) {
            Thread.sleep(Util.HALF_SECOND)
        }
        while (!getNavigation().get(pageNum - 1).getAttribute("class").contains("cur")) {
            Thread.sleep(Util.HALF_SECOND)
        }
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

    // actions
    void clickOnNav(Integer navPage) {
        getNavigation().get(navPage - 1).click()
    }

    // assertions
    void assertStatText(String text) {
        assert getStats().getText().startsWith(text)
    }

    void assertNavSize(Integer minPages) {
        assert getNavigation().size() > minPages
    }

    void assertNumberOfResults(Integer resultsNum) {
        assert getResults().size() == resultsNum
    }
}