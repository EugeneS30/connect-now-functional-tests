package functional.context;

import org.springframework.stereotype.Component;

import functional.pages.Discussion;
import functional.pages.Notice;
import lombok.Getter;
import lombok.Setter;

@Component
public class ScenarioContext {
	
	@Setter
	@Getter
	private Notice notice;
	
	@Setter
	@Getter
	private Discussion discussion;
	
	@Setter
	@Getter
	private String className;

}
