package functional.pages;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CardImpl {

	String identifier; // Class/Community
	String cardLabel; // id
	String teacherName;
	String timeCreated;
	String cardTitle; //
	String cardContent; // c-card__content , main text
	String comments; // c-feature--type-comments
	String subscription; // c-feature--type-subscription
	String bookmark; // c-feature--type-bookmark
	String settings; // c-feature--type-settings

//	public CardImpl(String identifier, String cardLabel, String teacherName, String timeCreated, String cardTitle,
//			String cardContent, String comments, String subscription, String bookmark, String settings) {
//		super();
//		this.identifier = identifier;
//		this.cardLabel = cardLabel;
//		this.teacherName = teacherName;
//		this.timeCreated = timeCreated;
//		this.cardTitle = cardTitle;
//		this.cardContent = cardContent;
//		this.comments = comments;
//		this.subscription = subscription;
//		this.bookmark = bookmark;
//		this.settings = settings;
//	}
//
//	public String getIdentifier() {
//		return identifier;
//	}
//
//	public void setIdentifier(String identifier) {
//		this.identifier = identifier;
//	}
//
//	public String getCardLabel() {
//		return cardLabel;
//	}
//
//	public void setCardLabel(String cardLabel) {
//		this.cardLabel = cardLabel;
//	}
//
//	public String getTeacherName() {
//		return teacherName;
//	}
//
//	public void setTeacherName(String teacherName) {
//		this.teacherName = teacherName;
//	}
//
//	public String getTimeCreated() {
//		return timeCreated;
//	}
//
//	public void setTimeCreated(String timeCreated) {
//		this.timeCreated = timeCreated;
//	}
//
//	public String getCardTitle() {
//		return cardTitle;
//	}
//
//	public void setCardTitle(String cardTitle) {
//		this.cardTitle = cardTitle;
//	}
//
//	public String getCardContent() {
//		return cardContent;
//	}
//
//	public void setCardContent(String cardContent) {
//		this.cardContent = cardContent;
//	}
//
//	public String getComments() {
//		return comments;
//	}
//
//	public void setComments(String comments) {
//		this.comments = comments;
//	}
//
//	public String getSubscription() {
//		return subscription;
//	}
//
//	public void setSubscription(String subscription) {
//		this.subscription = subscription;
//	}
//
//	public String getBookmark() {
//		return bookmark;
//	}
//
//	public void setBookmark(String bookmark) {
//		this.bookmark = bookmark;
//	}
//
//	public String getSettings() {
//		return settings;
//	}
//
//	public void setSettings(String settings) {
//		this.settings = settings;
//	}

}
