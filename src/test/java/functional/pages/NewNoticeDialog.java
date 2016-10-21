package functional.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

/**
 * 
 * @author eugene.shragovich This class encapsulates
 *
 */
public class NewNoticeDialog implements NewCardDialog {

	public NewNoticeDialog(AppiumDriver<WebElement> driver) {
		PageFactory.initElements(driver, this);
	}

	final static String DISCUSSIONWINDOW_CONTAINER_CSS = ".x-navigationview ";

	@FindBy(css = DISCUSSIONWINDOW_CONTAINER_CSS + ".x-toolbar")
	private WebElement header;

	@FindBy(css = DISCUSSIONWINDOW_CONTAINER_CSS + ".x-dock-body")
	private WebElement body;

	@FindBy(css = DISCUSSIONWINDOW_CONTAINER_CSS + ".x-list-item-first")
	private WebElement classes;

	@FindBy(css = DISCUSSIONWINDOW_CONTAINER_CSS + ".x-list-item-last")
	private WebElement communities;

	@FindBy(css = DISCUSSIONWINDOW_CONTAINER_CSS + ".x-scroll-scroller .x-list-item")
	private List<WebElement> items;
	
	@FindBy(css = DISCUSSIONWINDOW_CONTAINER_CSS + ".c-toolbar--actions .c-button--linear-gradient-light-green")
	private WebElement publishBtn;
	
	@FindBy(css = DISCUSSIONWINDOW_CONTAINER_CSS + ".x-field-input .x-input-text")
	private WebElement title;
	
	@FindBy(css = DISCUSSIONWINDOW_CONTAINER_CSS + "textarea.x-input-el")
	private WebElement message;

	// x-scroll-scroller
	
	private void chooseItem(final String id) {
		WebElementSupport.getElementFromList(id, items).click();
	}

	@Override
	public void chooseClass(final String className) {
		classes.click();
		chooseItem(className);
	}

	@Override
	public void chooseCommunity(final String communityName) {
		communities.click();
		chooseItem(communityName);

	}
	
	public void populateNewNoticeDialogFields(NoticeTestData data) {
		title.sendKeys(data.getTitle());
		message.sendKeys(data.getMessage());
		
	}
	
	public void publish() {
		publishBtn.click();
	}

	

	@Override
	public void cancel() {
		// TODO Auto-generated method stub

	}

}
