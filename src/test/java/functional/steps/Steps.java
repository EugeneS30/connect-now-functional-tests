package functional.steps;

import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import cucumber.api.java.en.Given;
import io.appium.java_client.AppiumDriver;

public class Steps {
	
	@Autowired
	private AppiumDriver<WebElement> driver;
	
	
	
	@Given("^I have logged in$")
	public void i_log_in() {
		
		driver.close();
		System.out.println("logging in!");
	}

}
