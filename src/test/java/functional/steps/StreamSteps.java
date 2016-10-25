package functional.steps;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.*;

import org.springframework.stereotype.Component;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import functional.context.ScenarioContext;
import functional.pages.Notice;
import functional.pages.NoticeTestData;
import functional.pages.Stream;
import functional.scenarios.ScenarioClassNotices;

public class StreamSteps {

	@Inject
	private ScenarioClassNotices notices;
	
	@Inject
	private Stream stream;
	
	@Inject
	private ScenarioContext context;

	// @When("^I add a new Notice$")
	// @Given("^I have added a new Notice$")
	// public void i_add_new_notice() {
	// notices.addNoticeToClass();
	// }

	@When("^I have refreshed the Stream screen$")
	public void i_refresh_the_screen() {
		stream.refresh();
	}

	@Then("^Then I (shall|shall not) see the Notice in the Stream feed$")
	public void notice_maybe_appears_in_stream(final String maybe) {

		boolean expected = "shall".equals(maybe);
		
		Notice notice = context.getNotice();
		
		assertThat(stream.noticeExists(notice)).isEqualTo(expected);

	}

}
