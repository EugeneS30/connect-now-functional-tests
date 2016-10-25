package functional.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

import io.appium.java_client.AppiumDriver;

@Component
public class StreamActionToolbarImpl implements StreamActionToolbar {

	private ActionMenu actionMenu;

	public StreamActionToolbarImpl(AppiumDriver<WebElement> driver) {
		PageFactory.initElements(driver, this);
		actionMenu = new ActionMenuImpl(driver);
	}
	final static String ACTIONTOOLBAR_CONTAINER_CSS = ".x-panel .x-docked-bottom ";

	@FindBy(css = ACTIONTOOLBAR_CONTAINER_CSS + ".x-button")
	private WebElement addActionButton;
	
//	c-options-list

	@Override
	public NewNoticeDialog addNotice() {
		addActionButton.click();
		return actionMenu.addNotice();
	}

	@Override
	public NewDiscussionDialog addDiscussion() {
		addActionButton.click();
		return actionMenu.addDiscussion();

	}

}
