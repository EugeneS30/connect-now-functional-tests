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

public class ClassNoticesSteps {

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

	@Given("^I have added a new Notice to class: \"([^\"]*)\"$")
	@When("^I add a new Notice to class: \"([^\"]*)\"$")
	public void i_add_new_notice_to_class(final String className) {
		notices.addNoticeToClass(className);
		context.setClassName(className);
	}

//	@When("^the Notice is in the Stream feed$")
//	@Then("^Then I (shall|shall not) see the Notice in the Stream feed$")
//	public void notice_maybe(final String maybe) {
//
//		boolean expected = "shall".equals(maybe);
//
//		Notice notice = context.getNotice();
//
//		assertThat(stream.noticeExists(notice)).isEqualTo(expected);
//
//	}

}
