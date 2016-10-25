package functional.pages;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
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


}
