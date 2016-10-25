package functional.pages;

import java.util.List;

import javax.inject.Inject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

import functional.support.AppiumSupport;
import io.appium.java_client.AppiumDriver;

@Component
public class StreamImpl implements Stream {

	public StreamImpl(AppiumDriver<WebElement> driver) {
		PageFactory.initElements(driver, this);
	}

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
		return this;
	}

}
