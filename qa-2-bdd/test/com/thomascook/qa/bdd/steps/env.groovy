package com.thomascook.qa.bdd.steps

import cucumber.api.groovy.Hooks

class SearchWorld {
    String searchTerm
}

Hooks.World {
    new SearchWorld()
}