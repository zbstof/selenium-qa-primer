package com.thomascook.qa.maven.glue

import cucumber.api.groovy.Hooks
import geb.Browser
import geb.binding.BindingUpdater
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.openqa.selenium.WebDriverException

class SearchWorld {
    String searchTerm
    Integer currentPage
}

Hooks.World {
    new SearchWorld()
}

BindingUpdater bindingUpdater
Browser theBrowser

Hooks.Before { scenario ->
    if (!binding.hasVariable('browser')) {
        theBrowser = new Browser()
        bindingUpdater = new BindingUpdater(binding, theBrowser)
        bindingUpdater.initialize()
    }
}

Hooks.After { scenario ->
    bindingUpdater?.remove()

    if (scenario.isFailed()) {
        try {
            byte[] screenshot = (theBrowser.driver as TakesScreenshot).getScreenshotAs(OutputType.BYTES)
            scenario.embed(screenshot, "image/png")
        } catch (WebDriverException | ClassCastException e) {
            println e
        }
    }
}


