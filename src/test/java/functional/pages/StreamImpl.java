package functional.pages;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import functional.support.AppiumSupport;
import functional.support.WebElementSupport;
import io.appium.java_client.AppiumDriver;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class StreamImpl implements Stream {

	public StreamImpl(AppiumDriver<WebElement> driver) {
		PageFactory.initElements(driver, this);
	}

	@Inject
	private AppiumDriver<WebElement> driver;

	@Inject
	private StreamToolbar toolbar;

	@Inject
	private StreamActionToolbar actionToolbar;

	@Inject
	private AppiumSupport support;

	@Inject
	private NewNoticeDialog newNoticeDialog;

	@Inject
	private NewDiscussionDialog newDiscussionDialog;

	@Inject
	private StreamCardsList streamCards;

	final static String STREAM_CONTAINER_CSS = ".x-panel .x-dock-body ";

	final static String STREAMTOOLBAR_CONTAINER_CSS = ".x-panel .x-docked-top";

	@FindBy(css = STREAM_CONTAINER_CSS + ".c-stream__item")
	private List<WebElement> itemsList;

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
	public boolean noticeExists(Notice notice) {

		return false;

	}

	@Override
	public boolean discussionExists(Discussion discussion) {

		return false;
	}

	// navigate to the main screen using main menu action
	@Override
	public Stream view() {
		toolbar.viewStream();
		return this;
	}

	// refresh screen by swiping down
	@Override
	public Stream refresh() {
		support.swipeDown();
		WebElementSupport.waitFor(1000);
		return this;
	}

	@Override
	public boolean isClean() {
		int items = itemsList.size();
		log.debug("Items list: {}", items);
		log.debug("Returning isClean = {}", items == 0);
		return items == 0; //return false is the items is not 0
	}

	// While deleting cards is planned but has not been implemented yet,
	// currently all the cards are just hidden.
	@Override
	public void clean() {
		while (!isClean()) {
			StreamCardsList cards = getAvailableStreamCards();
			log.info("Currently counted : {} cards", cards.getCards().size());
			cards.getCards().get(0).hide();
			refresh();
		}
	}

	private StreamCardsList getAvailableStreamCards() {

		List<Card> cards = new ArrayList<Card>();

		for (WebElement cardElement : itemsList) {
			cards.add(new CardImpl(cardElement, driver));
		}

		streamCards.setCards(cards);

		return streamCards;

	}

}
