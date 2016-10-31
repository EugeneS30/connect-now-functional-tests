package functional.pages;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
public class StreamCardsList {
	
	@Setter
	@Getter
	public List<Card> cards;

}
