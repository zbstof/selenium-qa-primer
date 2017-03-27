import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import net.masterthought.cucumber.Configuration
import net.masterthought.cucumber.ReportBuilder
import org.junit.AfterClass
import org.junit.runner.RunWith

@RunWith(Cucumber)
@CucumberOptions(
        // glue and features are not pulled from target
        glue = "src/test/resources/glue",
        features = "src/test/resources/features/",
        plugin = ["pretty", "json:target/cucumber.json"],
        tags = "~@Ignore")
class TestRunner {

    @AfterClass
    static void reports() {
        addShutdownHook {
            String currentInstant = new Date().getTime() as String
            File reportOutputDirectory = new File("target", currentInstant)
            Configuration configuration = new Configuration(reportOutputDirectory, "qa-4-maven")
            ReportBuilder reportBuilder = new ReportBuilder(Arrays.asList("target/cucumber.json"), configuration)
            reportBuilder.generateReports()
        }
    }
}
