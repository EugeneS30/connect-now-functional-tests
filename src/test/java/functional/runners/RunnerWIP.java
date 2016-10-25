package functional.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "classpath:connect_now_features" }, glue = { "functional.steps", "functional.dev",
		"functional.configuration" }, tags = {"@wip"})
public class RunnerWIP {

}
