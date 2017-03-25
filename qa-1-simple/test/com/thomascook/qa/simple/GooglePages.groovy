package com.thomascook.qa.simple

import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver

class GooglePages {

    static final int HALF_SECOND = 500
    static WebDriver driver

    static void main(String[] args) throws Exception {

        System.setProperty("webdriver.chrome.driver", "lib/chromedriver")
        driver = new ChromeDriver()
        try {
            new GooglePages().run()
        } finally {
            driver.quit()
        }
        System.out.println("Done")
    }

    void run() {
        SearchPage searchPage = new SearchPage(driver)
        searchPage.to()
        searchPage.at()
        searchPage.searchFor("webrio thomas cook")

        ResultsPage resultsPage = new ResultsPage(driver, 1)
        resultsPage.at()
        resultsPage.assertNumberOfResults(10)
        resultsPage.assertNavSize(2)
        resultsPage.clickOnNav(2)

        ResultsPage resultsPage2 = new ResultsPage(driver, 2)
        resultsPage2.at()
        resultsPage2.assertStatText("Сторінка 2")
    }
}

abstract class Page {
    abstract void at()

    void to() {
        throw new IllegalStateException("Must be overridden to use")
    }
}

class SearchPage extends Page {

    private WebDriver driver

    SearchPage(WebDriver driver) {
        this.driver = driver
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

class ResultsPage extends Page {

    private WebDriver driver
    private int pageNum

    ResultsPage(WebDriver driver, Integer pageNum) {
        assert pageNum >= 1
        this.pageNum = pageNum
        this.driver = driver
    }

    void at() {
        while (!driver.getTitle().contains("webrio")) {
            Thread.sleep(GooglePages.HALF_SECOND)
        }
        while (!getNavigation().get(pageNum - 1).getAttribute("class").contains("cur")) {
            Thread.sleep(GooglePages.HALF_SECOND)
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