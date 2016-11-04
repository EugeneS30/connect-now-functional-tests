package functional.context;

import javax.inject.Inject;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import functional.pages.Card;
import functional.pages.Discussion;
import functional.pages.Notice;
import functional.pages.Stream;
import lombok.Getter;
import lombok.Setter;

@Component
public class ScenarioContext {
	
	@Inject
	private Stream stream;
	
	@Inject
	private ApplicationContext ctx;
	
	@Getter
	@Setter
	private Card card;
	
	@Setter
	@Getter
	private Notice notice;
	
	@Setter
	@Getter
	private Discussion discussion;
	
	@Setter
	@Getter
	private String className;
	
	public void clean() {
		stream.clean();
		setClassName(null);
		setDiscussion(null);
		setNotice(null);
	}

}
