package testrunner;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/Feature"
		,glue= {"stepdefinition","hooks"}
		//,dryRun = true
		,monochrome=true
		//,tags= {"~@Ignore"},
		//,tags= {"@bulkaction"}
		,plugin={"pretty","html:target/sprint-pretty"}
		)
public class Testrunner {

}
