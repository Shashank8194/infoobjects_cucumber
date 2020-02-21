package cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/resources/cucumber/runtime/testng",
                    glue ="cucumber.stepdefinition")
public class RunApiATSuite extends AbstractTestNGCucumberTests {
}
