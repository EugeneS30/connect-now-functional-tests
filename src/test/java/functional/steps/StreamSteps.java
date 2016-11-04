package functional.steps;

import static org.assertj.core.api.Assertions.assertThat;

import javax.inject.Inject;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import functional.context.ScenarioContext;
import functional.pages.Card;
import functional.pages.CardImpl;
import functional.pages.Notice;
import functional.pages.Stream;
import functional.scenarios.ScenarioClassNotices;

public class StreamSteps {

	@Inject
	private ScenarioClassNotices notices;
	
	@Inject
	private Stream stream;
	
	@Inject
	private ScenarioContext context;
	
//	@Inject
//	private CardImpl card;

	@When("^I bookmark the notice$")
	public void i_bookmark_the_notice() {
		
		Notice notice = context.getNotice();
		stream.getCard(notice).bookmark();
		
//		notice.bookmark();
		
	}
	
	@When("^I filter the Stream by $")
	public void i_filter_stream_by(final String filter) {
		
	}
	@Then("^I (shall|shall not) see the Notice in the filtered Stream feed$")
	public void notice_maybe_appears_in_filtered_stream(final String maybe) {

		boolean expected = "shall".equals(maybe);
		Notice notice = context.getNotice();
		
//		assertThat(stream.noticeExists(notice)).isEqualTo(expected);
	}
	

	@When("^I have refreshed the Stream screen$")
	public void i_refresh_the_screen() {
		stream.refresh();
	}

	@Then("^I (shall|shall not) see the Notice in the Stream feed$")
	public void notice_maybe_appears_in_stream(final String maybe) {

		boolean expected = "shall".equals(maybe);
		Notice notice = context.getNotice();
		
		assertThat(stream.noticeExists(notice)).isEqualTo(expected);
	}
	
	@Given("^the stream is clean$")
	public void the_stream_is_clean() {
		
		if (!stream.isClean()) {
			stream.clean();
		}
		
		assertThat(stream.isClean()).isTrue();
		
	}
	

}
