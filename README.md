# selenium-qa-primer
Selenium, Groovy, Cucumber, Geb, Maven, junit, reporting stack

## java class with main method - htmlunit

- Download dependencies for selenium: 
[selenium-server-standalone](http://www.seleniumhq.org/download/), [direct link](http://selenium-release.storage.googleapis.com/3.3/selenium-server-standalone-3.3.1.jar)
- Download sources for easy documentation:
[selenium-api](http://central.maven.org/maven2/org/seleniumhq/selenium/selenium-api/3.3.1/),  
[selenium-chrome-driver](http://central.maven.org/maven2/org/seleniumhq/selenium/selenium-chrome-driver/3.3.1/),
[selenium-remote-driver](http://central.maven.org/maven2/org/seleniumhq/selenium/selenium-remote-driver/)
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

- Write out scenarios in .feature file
- Auto-generate stepdefs from missing steps
- Explain about stepdef parameters, capture groups /-slashes, $,^-boundaries
- Add glue: env.groovy with World Hook with `driver`, `searchTerm`
- explain how this allows to share data between different steps
- Introduce Util class: parse number from string, waitFor method
- use property-style accessors in groovy for content



- Cucumber jvm: https://cucumber.io/docs/reference/jvm
- http://repo1.maven.org/maven2/info/cukes/cucumber-core/1.2.4/
- java -classpath "./out/test/qa-1-command-line/:./lib/*:/Users/zbstof/groovy-2.4.8/lib/*" cucumber.api.cli.Main --glue ./src/com/thomascook/qa/steps ./src/cucumber/google.feature
- java -classpath "./out/test/qa-1-command-line/:./lib/*:/Users/zbstof/groovy-2.4.8/lib/*" cucumber.api.cli.Main --glue ./src/com/thomascook/qa/bdd/steps ./src/com/thomascook/qa/bdd/cucumber/google.feature
