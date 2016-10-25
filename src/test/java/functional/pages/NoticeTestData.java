package functional.pages;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class NoticeTestData implements Notice {

	private String title;
	private String message;
	private boolean isShown;

	@Override
	public CardType getCardType() {
		return CardType.NOTICE;
	}

}
