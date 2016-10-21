package functional.dev;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "classpath:connect_now_features" }, glue = { "functional.steps", "functional.dev",
		"functional.configuration" })
public class Runner {

}
