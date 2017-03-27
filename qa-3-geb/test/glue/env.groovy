package glue

import cucumber.api.groovy.Hooks
import geb.Browser
import geb.binding.BindingUpdater

class SearchWorld {
    String searchTerm
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
}


