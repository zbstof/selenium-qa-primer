package com.thomascook.qa.simple;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class GoogleHtmlUnit {

    private static final WebDriver driver = new HtmlUnitDriver();

    public static void main(String[] args) {
        driver.navigate().to("http://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("webrio thomas cook");
        element.sendKeys(Keys.ENTER);
        System.out.println("Page title is: " + driver.getTitle());
        driver.quit();
        System.out.println("Done");
    }
}
