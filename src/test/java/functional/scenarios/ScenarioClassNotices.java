package functional.scenarios;

import java.util.UUID;

import javax.inject.Inject;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import functional.context.ScenarioContext;
import functional.pages.Card;
import functional.pages.Notice;
import functional.pages.NoticeTestData;
import functional.pages.Stream;
import functional.pages.StreamType;
import lombok.Setter;

@Component
public class ScenarioClassNotices {

	@Inject
	private Stream stream;
	
	@Inject
	private ScenarioContext context;
	
	@Inject
	private ApplicationContext ctx;

	public void addNoticeToClass(final String className) {
		
		String randomString = "AT-" + UUID.randomUUID().toString();
		
		NoticeTestData testNotice = NoticeTestData.builder()
				.title(randomString)
				.message(randomString)
				.isShown(true)
				.build();

		stream.addNotice(StreamType.CLASS, className, testNotice);
		context.setNotice(testNotice);
	}

	public void reportNotice() {

	}

	public void hideComment() {

	}

	public void follow() {

	}

	public void unfollow() {

	}

	/**
	 * returns true if a specified notice exists in the stream feed. The
	 * assumption here is that we do not need to refresh the screen (reveal more
	 * stream cards) and the notice is available on the first screen.
	 */
	public boolean noticeExistsinStreamFeed() {
		return stream.noticeExists(context.getNotice());
	}
}
