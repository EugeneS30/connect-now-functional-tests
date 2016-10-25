package functional.steps;

import javax.inject.Inject;

import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import functional.pages.LoginPage;
import functional.pages.WelcomePage;
import io.appium.java_client.AppiumDriver;

public class LoginSteps {
	
	@Inject
	private WelcomePage welcomePage;
	
	@Inject
	private LoginPage loginPage;
	
	@Given("^I have skipped the welcome page$")
	public void i_skip_welcome_page() {
		welcomePage.skip();
	}

	@Given("^I have logged in as \"([^\"]*)\"$")
	public void i_log_in(final String user) {		
		loginPage.login(user, "789Learn");
	}

}
