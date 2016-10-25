package functional.pages;

import javax.inject.Inject;

import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

import io.appium.java_client.AppiumDriver;

@Component
public class MainMenuImpl implements MainMenu {	
	
	public MainMenuImpl(AppiumDriver<WebElement> driver) {
		PageFactory.initElements(driver, this);
		
	}

	@Inject
	private Stream stream;

	@Inject
	private Settings settings;

	final static String MENU_CONTAINER_CSS = ".c-main-menu ";

	@FindBy(css = MENU_CONTAINER_CSS + ".c-icon--home")
	private WebElement streamBtn;

	@FindBy(css = MENU_CONTAINER_CSS + ".c-button--icon")
	private WebElement settingsBtn;

	@Override
	public Settings viewSettings() {
		settingsBtn.click();
		return settings;
	}

	@Override
	public Stream viewStream() {
		streamBtn.click();
		return stream;
	}

	@Override
	public Help viewHelp() {
		throw new NotImplementedException("This method has not been implemented yet");
	}

}
