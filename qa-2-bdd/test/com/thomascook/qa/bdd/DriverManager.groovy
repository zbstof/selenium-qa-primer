package com.thomascook.qa.bdd

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

class DriverManager {
    static final WebDriver driver
    static {
        System.setProperty("webdriver.chrome.driver", "lib/chromedriver")
        driver = new ChromeDriver()
        addShutdownHook {
            driver.quit()
        }
    }
}
