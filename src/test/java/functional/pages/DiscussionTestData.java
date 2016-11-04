package functional.pages;

import lombok.Builder;
import lombok.Data;
import lombok.Delegate;

@Builder
@Data
public class DiscussionTestData implements Discussion {

	private String title;
	private String message;
	private String author;
	private boolean isShown;
	
	@Delegate(types = {CardImpl.class})
	private CardImpl card;
	
//	public CardType getCardType() {
//		return CardType.DISCUSSION;
//	}
//
//	@Override
//	public void edit(Notice notice) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void unfollow() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void hide() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void report() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void bookmark() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public boolean isBookmarked() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean isVisible() {
//		// TODO Auto-generated method stub
//		return false;
//	}

}
