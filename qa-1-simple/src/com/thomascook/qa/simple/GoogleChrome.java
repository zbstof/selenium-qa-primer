package com.thomascook.qa.simple;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class GoogleChrome {

    private static final int HALF_SECOND = 500;

    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "lib/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://www.google.com");
        WebElement queryElement = driver.findElement(By.name("q"));
        queryElement.sendKeys("webrio thomas cook");
        queryElement.sendKeys(Keys.ENTER);

        // have to wait for page to load dynamically
        do {
            Thread.sleep(HALF_SECOND);
        } while (!driver.getTitle().contains("webrio"));

        List<WebElement> resultElements = driver.findElements(By.cssSelector(".rc"));

        // have to have -ea or -enableassertions
        assert resultElements.size() == 10;

        resultElements.forEach(e -> System.out.println(e.getText()));

        driver.quit();

        System.out.println("Done");
    }
}
