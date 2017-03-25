# selenium-qa-primer
Selenium, Groovy, Cucumber, Geb, Maven, junit, reporting stack

- Create empty folder qa-1-command-line
- create folder structure
- download Selenium server: http://www.seleniumhq.org/download/  (or selenium-api + selenium-chrome-driver jars)
into `lib` folder
- chrome driver and unpack the binary: https://chromedriver.storage.googleapis.com/index.html
- Selenium java bindings: http://selenium-release.storage.googleapis.com/3.3/selenium-java-3.3.1.zip
- Cucumber jvm: https://cucumber.io/docs/reference/jvm
- http://repo1.maven.org/maven2/info/cukes/cucumber-core/1.2.4/
- java -classpath "./out/test/qa-1-command-line/:./lib/*:/Users/zbstof/groovy-2.4.8/lib/*" cucumber.api.cli.Main --glue ./src/com/thomascook/qa/steps ./src/cucumber/google.feature
- java -classpath "./out/test/qa-1-command-line/:./lib/*:/Users/zbstof/groovy-2.4.8/lib/*" cucumber.api.cli.Main --glue ./src/com/thomascook/qa/bdd/steps ./src/com/thomascook/qa/bdd/cucumber/google.feature
