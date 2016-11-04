package functional.configuration;

import javax.inject.Inject;

import cucumber.api.java.After;
import functional.context.ScenarioContext;
import functional.pages.StreamToolbar;

public class AfterHooks {
	
	@Inject
	private StreamToolbar toolbar;
	
	@Inject
	private ScenarioContext context;
	

	@After
	public void cleanUp() {
		context.clean();
	}
	//higher number run first. default is 10000	
	@After(order = 1)
	public void logOut() {
		toolbar.logOut();
	}

}
