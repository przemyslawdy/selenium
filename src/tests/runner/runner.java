package tests.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty", "html:target/html/"},
        features = "src/tests/Features"
        ,glue= {"components", "pages", "tests"}
)

public class runner {


}
