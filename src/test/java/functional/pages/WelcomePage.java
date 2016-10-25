package functional.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

import functional.interfaces.SlowLoading;
import io.appium.java_client.AppiumDriver;

@Component
public class WelcomePage implements SlowLoading {

	public WelcomePage(AppiumDriver<WebElement> driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".x-button")
	private WebElement skipButton;
	
	public void skip() {
		skipButton.click();
	}

	@Override
	public boolean hasLoaded() {
		return true;
	}

}
