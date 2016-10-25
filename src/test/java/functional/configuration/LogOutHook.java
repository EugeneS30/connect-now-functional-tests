package functional.configuration;

import javax.inject.Inject;

import cucumber.api.java.After;
import functional.pages.StreamToolbar;

public class LogOutHook {
	
	@Inject
	private StreamToolbar toolbar;
	
	@After
	public void logOut() {
		toolbar.logOut();
	}

}
