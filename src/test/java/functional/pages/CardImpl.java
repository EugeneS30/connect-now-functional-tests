package functional.pages;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.NoSuchElementException;

import javax.inject.Inject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cucumber.api.PendingException;
import functional.support.WebElementSupport;
import io.appium.java_client.AppiumDriver;
import lombok.extern.slf4j.Slf4j;

@Component("Card")
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Slf4j
public class CardImpl implements Card {

	// @ParentRef
	private final WebElement parent;

	String identifier; // Class/Community
	String cardLabel; // id
	String cardType; // Notice/Discussion
	String teacherName;
	String timeCreated;
	String cardTitle; //
	String cardContent; // c-card__content , main text
	WebElement comments; // c-feature--type-comments
	WebElement subscription; // c-feature--type-subscription
	WebElement bookmark; // c-feature--type-bookmark
	WebElement settings; // c-feature--type-settings

	public CardImpl(AppiumDriver<WebElement> driver, WebElement cardElement) {

		this.parent = cardElement;

		PageFactory.initElements(driver, this);

		identifier = cardElement.findElement(By.cssSelector(".c-card__identifier")).getText();
		cardLabel = cardElement.findElement(By.cssSelector(".c-card__label")).getText();
		cardType = cardElement.findElement(By.cssSelector(".c-card__type")).getText();
		teacherName = cardElement.findElement(By.cssSelector(".c-media__title")).getText();
		timeCreated = cardElement.findElement(By.cssSelector(".c-media__metadata")).getText();
		cardTitle = cardElement.findElement(By.cssSelector(".c-card__title")).getText();
		cardContent = cardElement.findElement(By.cssSelector(".c-card__content")).getText();
		comments = cardElement.findElement(By.cssSelector(".c-card__footer"));
		subscription = cardElement.findElement(By.cssSelector(".c-feature--type-subscription"));
		bookmark = cardElement.findElement(By.cssSelector(".c-feature--type-bookmark"));
		settings = cardElement.findElement(By.cssSelector(".c-feature--type-settings"));

	}

	// // @ParentElement(field = "parent")
	// @FindBy(css = ".c-card__identifier")
	// private WebElement identifier;
	//
	// // @ParentElement(field = "parent")
	// @FindBy(css = ".c-card__label")
	// private WebElement cardLabel;
	//
	// // @ParentElement(field = "parent")
	// @FindBy(css = ".c-card__type")
	// private WebElement cardType;
	//
	// // @ParentElement(field = "parent")
	// @FindBy(css = ".c-media__title")
	// private WebElement teacherName;
	//
	// // @ParentElement(field = "parent")
	// @FindBy(css = ".c-media__title")
	// private WebElement timeCreated;
	//
	// // @ParentElement(field = "parent")
	// @FindBy(css = ".c-media__title")
	// private WebElement cardTitle;
	//
	// // @ParentElement(field = "parent")
	// @FindBy(css = ".c-media__title")
	// private WebElement cardContent;
	//
	// // @ParentElement(field = "parent")
	// @FindBy(css = ".c-media__title")
	// private WebElement comments;
	//
	// // @ParentElement(field = "parent")
	// @FindBy(css = ".c-media__title")
	// private WebElement subscription;
	//
	// // @ParentElement(field = "parent")
	// @FindBy(css = ".c-media__title")
	// private WebElement bookmark;
	//
	// // @ParentElement(field = "parent")
	// @FindBy(css = ".c-media__title")
	// private WebElement settings;

	// @Inject
	// private CardSettingsMenu settingMenu;
	//
	// @Inject
	// private ConfirmationDialog dialog;
	
	@Inject
	private AppiumDriver<WebElement> driver;

	@Override
	public CardType getCardType() {
		if (cardType.contains("Notice")) {
			return CardType.NOTICE;
		} else if (cardType.contains("Discussion")) {
			return CardType.DISCUSSION;
		} else {
			return null;
		}

	}

	final static String CARD_MENU_CONTAINER = ".c-options-list ";

	@FindBy(css = CARD_MENU_CONTAINER + "")
	private List<WebElement> menuButtons;

	@FindBy(css = ".c-message-box .x-button")
	private List<WebElement> dialogBtns;

	@FindBy(css = ".c-message-box")
	private WebElement okBtn;

	private WebElement getButton(final String btnName) {
		return menuButtons.stream().filter(button -> button.getText().toLowerCase().contains(btnName.toLowerCase()))
				.findFirst().get();
	}

	// TODO This should be rewritten to use CardSettingsMenu class but that
	// requires for CardImpl to be a Spring bean. Currently this is impossible
	// as there are multiple Card instances required.
	private void getCardMenu() {
		settings.click();
	}

	public void acceptDialog() {
		getDialogBtn("ok").click();
	}

	public void closeDialog() {
		getDialogBtn("cancel");
	}

	private WebElement getDialogBtn(final String btnName) {
		return dialogBtns.stream().filter(button -> button.getText().toLowerCase().contains(btnName.toLowerCase()))
				.findFirst().get();
	}

	@Override
	public void unfollow() {

		getCardMenu();
		getButton("unfollow");

	}

	@Override
	public void hide() {

		// Activate menu
		getCardMenu();
		// Find and click hide button
		getButton("hide").click();
		// dialog.accept();

		// wait until dialog appears
		WebElementSupport.waitUntilElementAppears(okBtn);

		acceptDialog();
		// okBtn.click();

	}

	@Override
	public void report() {

		getButton("report").click();

	}

	@Override
	public void edit(Card notice) {

		getButton("edit").click();

	}

	@Override
	public void bookmark() {
		bookmark.click();
		assertThat(isBookmarked()).isTrue();
	}

	@Override
	public boolean isBookmarked() {
		
		bookmark = driver.findElement(By.cssSelector(".c-feature--type-bookmark"));

		// we have to search for bookmark element again as it has been changed
		// by clicking on it
//		WebElement bookmarkNew = parent.findElement(By.cssSelector(".c-feature--type-bookmark"));

		try {
			bookmark.findElement(By.cssSelector(".c-icon--bookmark-hollow"));
			log.info("HOLLOW FOUND --> NOT BOOKMARKED");
			return false;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			bookmark.findElement(By.cssSelector(".c-icon--bookmark-full"));
			log.info("FULL FOUND --> BOOKMARKED");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		throw new NoSuchElementException();
		
//		if (bookmark.findElement(By.cssSelector(".c-icon--bookmark-hollow")).isDisplayed()) {
//			return false;
//		} else if (bookmark.findElement(By.cssSelector(".c-icon--bookmark-full")).isDisplayed()) {
//			return true;
//		} else {
//			throw new NoSuchElementException("bookmark problem");
//		}
	}

	@Override
	public boolean isVisible() {
		return false;
	}

	@Override
	public Card view() {
		throw new PendingException();
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

}
