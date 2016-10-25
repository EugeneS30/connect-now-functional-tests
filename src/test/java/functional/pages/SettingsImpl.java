package functional.pages;

import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

import io.appium.java_client.AppiumDriver;

@Component
public class SettingsImpl implements Settings {
	
	public SettingsImpl(AppiumDriver<WebElement> driver) {
		PageFactory.initElements(driver, this);
	}

	final static String SETTINGS_CONTAINER_CSS = ".c-settings ";

	@FindBy(css = SETTINGS_CONTAINER_CSS + ".c-button--sign-out")
	private WebElement signOutBtn;

	@Override
	public WelcomePage playTour() {
		throw new NotImplementedException("has not been implemented yet");
	}

	@Override
	public void signOut() {
		signOutBtn.click();
	}

	@Override
	public NotificationSettings viewNotificationsSettings() {
		throw new NotImplementedException("has not been implemented yet");
	}

}
