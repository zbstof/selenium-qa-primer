package com.thomascook.qa.bdd.pages

import com.thomascook.qa.bdd.DriverManager
import org.openqa.selenium.WebDriver

abstract class Page {
    protected WebDriver driver

    Page() {
        this.driver = DriverManager.driver
    }

    abstract void at()

    void to() {
        throw new IllegalStateException("Must be overridden to use")
    }
}


