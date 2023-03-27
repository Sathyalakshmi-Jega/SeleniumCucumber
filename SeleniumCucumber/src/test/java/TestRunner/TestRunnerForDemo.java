package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C://Users//Jega//eclipse-workspace//SeleniumCucumber//Feature//Customer.feature",
                  glue = "StepDefinition",
                  dryRun = false,
                  monochrome=true,
                  plugin = {"pretty","html:target/cucumber-reports.html"}

// group scenarios as sanity or regression in feature file before adding tags in test runner file
                //  tags = {"@sanity, @Regression"}  This to run scenarios which is fall under either one of sanity or regression
                 //tags = {"@sanity", "@Regression"}  this to run scenarios which fall under both sanity and regression 
                  )
//The above monochrome plugin is for removing unwanted characters 
//dry run is for running the 
public class TestRunnerForDemo {

}




