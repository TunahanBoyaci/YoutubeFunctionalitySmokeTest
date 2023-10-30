package Runners;

import Utilities.ParameterDriver;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

@CucumberOptions (
        features = "src/test/java/FutureFiles/YoutubeFunctionality.feature",
        glue = "StepDefinitions"
)

public class YoutubeFunctionalityRunner extends AbstractTestNGCucumberTests {
//    @BeforeClass
//    @Parameters(value = "browser")
//    public void beforeClass(String browserName){
//        ParameterDriver.setThreadDriverName(browserName);
//    }


}
