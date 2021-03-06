package RunnerClass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/resources/FeatureFiles" },
				glue = {"StepDefinition", "Utility" },
				plugin = { "pretty", "html:target/Reports",
						"json:target/cucumber-report-composite.json",
						"json:target/cucumber.json" ,
						},
				monochrome = true,
				tags = { "@FontendTest or @BackendTest" }
				)

public class Runner {
	
}
