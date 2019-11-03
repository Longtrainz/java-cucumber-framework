package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/features"},
        glue = {"steps"},
        monochrome = true,
        tags = {},
        plugin = {"pretty", " ","json:target/cucumber.json", "com.cucumber.listener.ExtentCucumberFormatter: target/report.html"}
)
public class MainRunner {


}
