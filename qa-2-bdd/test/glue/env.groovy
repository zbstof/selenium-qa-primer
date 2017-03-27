package glue

import cucumber.api.groovy.Hooks
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

class SearchWorld {
    private static final WebDriver d
    static {
        System.setProperty("webdriver.chrome.driver", "bin/chromedriver")
        d = new ChromeDriver()
        addShutdownHook {
            d.quit()
        }
    }

    String searchTerm
    WebDriver driver

    SearchWorld() {
        driver = d
    }
}

Hooks.World {
    new SearchWorld()
}