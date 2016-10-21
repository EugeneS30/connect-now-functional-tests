package functional.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class StreamToolbar {
	
	FilterResultsMenu filterResultMenu;

	public StreamToolbar(AppiumDriver<WebElement> driver) {
		PageFactory.initElements(driver, this);
		filterResultMenu = new FilterResultsMenu(driver);
	}

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
	
	

}
