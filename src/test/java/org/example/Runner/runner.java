package org.example.Runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/resources/features" ,
        glue = "org.example.Steps" ,
        plugin = { "pretty","json:target/cucumber.json"},
        tags = "@api"

)
public class runner extends AbstractTestNGCucumberTests {

}
