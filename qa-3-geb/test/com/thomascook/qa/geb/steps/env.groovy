package com.thomascook.qa.geb.steps

import cucumber.api.groovy.Hooks
import geb.Browser
import geb.binding.BindingUpdater

class SearchWorld {
    String searchTerm
    Integer currentPage
}

Hooks.World {
    new SearchWorld()
}

def bindingUpdater
def theBrowser

Hooks.Before { scenario ->
    if (!binding.hasVariable('browser')) {
        theBrowser = new Browser()
        bindingUpdater = new BindingUpdater(binding, theBrowser)
        bindingUpdater.initialize()
    }
}

Hooks.After { scenario ->
    bindingUpdater?.remove()
}


