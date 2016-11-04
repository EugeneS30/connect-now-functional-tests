package functional.pages;

import org.springframework.context.ApplicationContext;

import lombok.Builder;
import lombok.Data;
import lombok.Delegate;
import lombok.Setter;

@Builder
@Data
public class NoticeTestData implements Notice {

	private String title;
	private String message;
	private boolean isShown;
	
	@Setter
	private ApplicationContext ctx;

	@Override
	public String getMessage() {
		return this.message;
	}

	@Override
	public String getTitle() {
		return this.title;
	}

	@Override
	public boolean isShown() {
		return this.isShown;
	}

	@Override
	public String getIdentifier() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCardLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTeacherName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTimeCreated() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCardTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCardContent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CardType getCardType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void edit(Card card) {
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

	@Override
	public void bookmark() {
//		Card card = ctx.

	}

	@Override
	public boolean isBookmarked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Card view() {
		// TODO Auto-generated method stub
		return null;
	}

}
