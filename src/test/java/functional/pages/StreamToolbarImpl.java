package functional.pages;

import javax.inject.Inject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

import io.appium.java_client.AppiumDriver;

@Component
public class StreamToolbarImpl implements StreamToolbar {

	public StreamToolbarImpl(AppiumDriver<WebElement> driver) {
		PageFactory.initElements(driver, this);
		// filterResultMenu = new FilterResultsMenu(driver);
	}

	@Inject
	private Stream stream;

	@Inject
	private MainMenu mainMenu;

	@Inject
	private FilterResultsMenu filterResultMenu;
	
	@Inject
	private Settings settings;

	final static String STREAM_TOOLBAR_CSS = "#streamToolBar ";

	@FindBy(css = STREAM_TOOLBAR_CSS + ".x-button-action")
	private WebElement mainMenuBtn;

	@FindBy(css = STREAM_TOOLBAR_CSS + ".c-button--channel-filter")
	private WebElement filterResultsBtn;

	@FindBy(css = STREAM_TOOLBAR_CSS + ".c-button--notification")
	private WebElement notificationsBtn;

	public void filterBy(final String filterBy) {
		filterResultsBtn.click();
		filterResultMenu.selectItem(filterBy);
	}

	@Override
	public Stream viewStream() {
		mainMenuBtn.click();
		mainMenu.viewStream();
		return stream;
	}

	@Override
	public void logOut() {
		mainMenuBtn.click();
		settings = mainMenu.viewSettings();
		settings.signOut();
	}

}
