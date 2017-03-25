package com.thomascook.qa.glue

import cucumber.api.groovy.Hooks
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

class SearchWorld {
    String searchTerm
    WebDriver driver

    SearchWorld() {
        System.setProperty("webdriver.chrome.driver", "bin/chromedriver")
        driver = new ChromeDriver()
        addShutdownHook {
            driver.quit()
        }
    }
}

Hooks.World {
    new SearchWorld()
}