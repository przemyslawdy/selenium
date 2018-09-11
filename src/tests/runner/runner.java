package tests.runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty", "html:target/html/"},
        features = "src/tests/Features"
        ,glue= {"components", "pages", "tests"}
)

public class runner {

}
