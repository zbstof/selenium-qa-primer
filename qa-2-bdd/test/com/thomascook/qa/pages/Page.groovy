package com.thomascook.qa.pages

import org.openqa.selenium.WebDriver

abstract class Page {
    protected WebDriver driver

    Page(WebDriver driver) {
        this.driver = driver
    }

    abstract void at()

    void to() {
        throw new IllegalStateException("Must be overridden to use")
    }
}


