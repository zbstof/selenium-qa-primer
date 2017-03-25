package com.thomascook.qa.simple

import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver

class GoogleGroovyNavigation {

    private static final int HALF_SECOND = 500

    static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "bin/chromedriver")
        WebDriver driver = new ChromeDriver()
        // have to close browser even if exception occurs
        try {
            driver.navigate().to("http://www.google.com")
            WebElement queryElement = driver.findElement(By.name("q"))
            queryElement.sendKeys("webrio thomas cook")
            queryElement.sendKeys(Keys.ENTER)

            while (!driver.getTitle().contains("webrio")) {
                Thread.sleep(HALF_SECOND)
            }

            List<WebElement> resultElements = driver.findElements(By.cssSelector(".rc"))

            // have to have -ea or -enableassertions
            assert resultElements.size() == 10

            List<WebElement> navs = driver.findElements(By.cssSelector("table#nav td:not(.b)"))

            assert navs.size() > 2

            // Have to click on second element
            WebElement nav = navs.get(1)
            nav.click()

            while (!driver.findElements(By.cssSelector("table#nav td:not(.b)")).get(1).getAttribute("class").contains("cur")) {
                Thread.sleep(HALF_SECOND)
            }

            // have to refresh stats
            WebElement stats = driver.findElement(By.cssSelector("#resultStats"))
            assert stats.getText().startsWith("Сторінка 2")

        } finally {
            driver.quit()
        }
        System.out.println("Done")
    }
}
