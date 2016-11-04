package functional.pages;

public interface Card {
	
	String getIdentifier(); // Class/Community
	
	String getCardLabel(); // id
	
	String getTeacherName();
	
	String getTimeCreated();
	
	String getCardTitle(); //
	
	String getCardContent(); // c-card__content , main text
	
	CardType getCardType();
	
	void edit(Card card);
	
	void unfollow();
	
	void hide();
	
	void report();
	
	void bookmark();
	
	boolean isBookmarked();
	
	boolean isVisible();
	
	Card view();

}
