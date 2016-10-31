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
