package fitflop;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
//        glue = "com.easyjet",
        features = "src/test/resources/features",
//        tags = {"@me"},
        // tags = {"~@manual", "~@defect", "~@sprint-32"},
        plugin = {"pretty", "html:target/cucumber-html-report/RegressionTest"})
public class DefinitionTestSuite {}


