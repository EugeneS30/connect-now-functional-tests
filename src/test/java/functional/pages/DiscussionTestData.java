package functional.pages;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DiscussionTestData implements Discussion {

	private String title;
	private String message;
	private String author;
	private boolean isShown;
	
	
	@Override
	public CardType getCardType() {
		return CardType.DISCUSSION;
	}

}
