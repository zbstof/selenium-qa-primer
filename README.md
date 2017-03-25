# selenium-qa-primer
Selenium, Groovy, Cucumber, Geb, Maven, junit, reporting stack

## java class with main method - htmlunit

- Download dependencies for selenium: 
[selenium-server-standalone](http://www.seleniumhq.org/download/), [direct link](http://selenium-release.storage.googleapis.com/3.3/selenium-server-standalone-3.3.1.jar)
- Download sources for easy documentation:
    * [selenium-api](http://central.maven.org/maven2/org/seleniumhq/selenium/selenium-api/3.3.1/),  
    * [selenium-chrome-driver](http://central.maven.org/maven2/org/seleniumhq/selenium/selenium-chrome-driver/3.3.1/),
    * [selenium-remote-driver](http://central.maven.org/maven2/org/seleniumhq/selenium/selenium-remote-driver/)
- Put jars into `lib` folder, it should be on the classpath during compile- and run-time
- Create java class with main method. Create HtmlUnit driver inside. 
    * Open google search page
    * Search for `webrio thomas cook`
    * print page title
- compile and run (TODO: command-line to do that)

Hint: By.name("q") - query

## java class with main method - chrome 
- Download chrome driver and unpack the [binary](https://chromedriver.storage.googleapis.com/index.html)
Put binary into `bin` directory
- set system property `webdriver.chrome.driver` to point at the binary
- add waits on navigation, so that AJAX navigation has time to work
- add `assert`-tions, add `-enableassertions` to command-line, so those would work
- compile and run

Hint: By.cssSelector(".rc") - results

## java class with main method with navigation

- wrap everything in try-finally, so browser will be closed even if exception occurs
- use `while` waiter to ease transition to groovy
- assert number of navs >=2
- add click on second navigational 'o', and check for page to load
- validate text on top of the page

Hint: "table#nav td:not(.b)" - navs
Hint: class="cur" - current nav
Hint: By.cssSelector("#resultStats") - text on top

## Groovy class with main method

- add groovy [lib with sources](http://central.maven.org/maven2/org/codehaus/groovy/groovy-all/)
- migrate to groovy
- show PowerAssert enhanced reporting

## Separate Page files

- point out how messy the code became
- create abstract class Page with to() and at() methods
- 2 concrete implementations: ResultsPage, SearchPage
    * constructor accepts WebDriver
    * content section
    * action section
    * asserts section
- write waitFor implementation that accepts Closure<Boolean>, 
it should ignore exceptions on call()

Hint: separate content for current navigator and all navigators
Hint: ResultsPage at checker should only check for results presence,
correct page should be validated (and wait for) separately

## BDD: Cucumber

- Download dependencies and sources:
    * [cucumber-core](http://repo1.maven.org/maven2/info/cukes/cucumber-core/)
    * [cucumber-jvm-deps](http://repo1.maven.org/maven2/info/cukes/cucumber-jvm-deps/)
    * [cucumber-groovy](http://repo1.maven.org/maven2/info/cukes/cucumber-groovy/)
    * [gherkin](http://central.maven.org/maven2/info/cukes/gherkin/)
- Write out scenarios in .feature file
- Auto-generate stepdefs from missing steps
- Explain about stepdef parameters, capture groups /-slashes, $,^-boundaries, case sensitivity
- Add glue: env.groovy with World Hook with `driver`, `searchTerm`
- explain how this allows to share data between different steps
- Introduce Util class: parse number from string, waitFor method
- use property-style accessors in groovy for content
- separations of concerns 
    * front-end data on cucumber
    * shared data in world + stepdefs
    * page data on page object
- run .feature file directly from IDEA
- run all features from command-line:
`java -ea -classpath "./out/test/qa-2-bdd/:./lib/*" cucumber.api.cli.Main --glue qa-2-bdd/test/com/thomascook/qa/glue qa-2-bdd/test/cucumber/`


Docs: Cucumber jvm - https://cucumber.io/docs/reference/jvm

## Geb - groovy automation

- Download dependencies and sources as needed:
    * [geb-core](http://central.maven.org/maven2/org/gebish/geb-core/geb-core/) - get sources for this
    * [geb-ast](http://central.maven.org/maven2/org/gebish/geb-core/geb-ast/)
    * [geb-core](http://central.maven.org/maven2/org/gebish/geb-core/geb-core/)
    * [geb-exceptions](http://central.maven.org/maven2/org/gebish/geb-core/geb-exceptions/)
    * [geb-waiting](http://central.maven.org/maven2/org/gebish/geb-core/geb-waiting/)
- Replace at, content with static blocks
- Add GebConfig.groovy at top context, initialize driver
- Add bindingUpdater initialization/removal to Before/After hooks in env.groovy 
- Remove waitFor, parent Page class
- add @lazy @field for syntax highlighting
- replace access by index to array-like accessor on Navigator object
- Run feature directly from IDEA
- Run from command-line:
`java -ea -classpath "./out/test/qa-3-geb/:./lib/*" cucumber.api.cli.Main --glue qa-3-geb/test/com/thomascook/qa/glue qa-3-geb/test/cucumber/`

## Maven - dependency management

## Reporting

- Add screenshot taking to After hook