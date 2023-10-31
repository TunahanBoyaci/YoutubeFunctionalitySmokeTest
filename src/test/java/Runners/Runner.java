package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (
        features = "src/test/java/FutureFiles",
        glue = "StepDefinitions",
        plugin = {"pretty", "html:target/site/cucmber-pretty", "json:target/cucumber/cucumber.json"}
)

public class Runner extends AbstractTestNGCucumberTests {
//    @BeforeClass
//    @Parameters(value = "browser")
//    public void beforeClass(String browserName){
//        ParameterDriver.setThreadDriverName(browserName);
//    }


}
