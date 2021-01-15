package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/VerifyRecords.feature"}
        , glue = {"src/test/java/coinmarket/verifyRecords"}
        ,tags = { "@Test" }
)

public class TestRunner {



}
