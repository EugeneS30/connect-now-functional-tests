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

	@Override
	public void edit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unfollow() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void report() {
		// TODO Auto-generated method stub
		
	}

}
