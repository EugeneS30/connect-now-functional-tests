package functional.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class StreamImpl implements Stream {

	private StreamToolbar toolbar;
	private StreamActionToolbar actionToolbar;
	private NewNoticeDialog newNoticeDialog;
	private NewDiscussionDialog newDiscussionDialog;
	private List<Card> cards;

	public StreamImpl(AppiumDriver<WebElement> driver) {
		PageFactory.initElements(driver, this);
		toolbar = new StreamToolbar(driver);
		actionToolbar = new StreamActionToolbarImpl(driver);
	}

	final static String STREAM_CONTAINER_CSS = ".x-panel .x-dock-body ";

	final static String STREAMTOOLBAR_CONTAINER_CSS = ".x-panel .x-docked-top";

	@FindBy(css = STREAM_CONTAINER_CSS + ".c-stream__item")
	private List<WebElement> itemsList;

	// private void scanCardsInFeed() {
	// for (WebElement card : itemsList) {
	// cards.add(new CardImpl(card., cardLabel, teacherName, timeCreated,
	// cardTitle, cardContent, comments, subscription, bookmark, settings))
	// }
	// }

	@Override
	public void addNotice(final StreamType where, final String id, NoticeTestData data) {

		newNoticeDialog = actionToolbar.addNotice();

		switch (where) {
		case CLASS:
			newNoticeDialog.chooseClass(id);
			break;
		case COMMUNITY:
			newNoticeDialog.chooseCommunity(id);
			break;
		}

		newNoticeDialog.populateNewNoticeDialogFields(data);
		newNoticeDialog.publish();
	}

	@Override
	public void addDiscussion(final StreamType where, final String id, final TestData testDataObject) {

		newDiscussionDialog = actionToolbar.addDiscussion();

		switch (where) {
		case CLASS:
			newDiscussionDialog.chooseClass(id);
			break;
		case COMMUNITY:
			newDiscussionDialog.chooseCommunity(id);
			break;
		}

	}

	@Override
	public void filterBy(FilterCriteria criteria) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean cardExists(TestData data) {
		return false;
		// return itemsList.stream().filter(item -> item.getText())
	}

	
}
