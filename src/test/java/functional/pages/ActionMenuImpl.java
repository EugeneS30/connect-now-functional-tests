package functional.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class ActionMenuImpl implements ActionMenu {

	NewDiscussionDialog newDiscussionDialog;
	NewNoticeDialog newNoticeDialog;

	public ActionMenuImpl(AppiumDriver<WebElement> driver) {
		PageFactory.initElements(driver, this);
		newDiscussionDialog = new NewDiscussionDialog(driver);
		newNoticeDialog = new NewNoticeDialog(driver);
	}

	final static String ACTIONMENU_CONTAINER_CSS = ".c-options-list ";

	@FindBy(css = ACTIONMENU_CONTAINER_CSS + ".x-button-no-icon")
	private List<WebElement> menuItems;

	@Override
	public NewNoticeDialog addNotice() {
		WebElementSupport.getElementFromList("add notice", menuItems).click();
		return newNoticeDialog;
	}

	@Override
	public NewDiscussionDialog addDiscussion() {
		WebElementSupport.getElementFromList("add discussion", menuItems).click();
		return newDiscussionDialog;
	}

}
