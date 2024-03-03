package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "C:/Users/Mahmoud Fezai//eclipse-workspace/KIBQATask/src/test/java/features",
    glue= {"stepDefinitions"},
	plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json",
			"junit:target/cucumber-reports/Cucumber.xml",
			"html:target/cucumber-reports"},
	monochrome = true
)
public class TestRunner {
}
