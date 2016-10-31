package functional.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import functional.support.WebElementSupport;
import io.appium.java_client.AppiumDriver;

//@Component
//@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//@Named("Card")
public class CardImpl implements Card {

	String identifier; // Class/Community
	String cardLabel; // id
	String teacherName;
	String timeCreated;
	String cardTitle; //
	String cardContent; // c-card__content , main text
	WebElement comments; // c-feature--type-comments
	WebElement subscription; // c-feature--type-subscription
	WebElement bookmark; // c-feature--type-bookmark
	WebElement settings; // c-feature--type-settings

	public CardImpl(WebElement cardElement, AppiumDriver<WebElement> driver) {

		PageFactory.initElements(driver, this);

		identifier = cardElement.findElement(By.cssSelector(".c-card__identifier")).getText();
		cardLabel = cardElement.findElement(By.cssSelector(".c-card__label")).getText();
		teacherName = cardElement.findElement(By.cssSelector(".c-media__title")).getText();
		timeCreated = cardElement.findElement(By.cssSelector(".c-media__metadata")).getText();
		cardTitle = cardElement.findElement(By.cssSelector(".c-card__title")).getText();
		cardContent = cardElement.findElement(By.cssSelector(".c-card__content")).getText();
		comments = cardElement.findElement(By.cssSelector(".c-card__footer"));
		subscription = cardElement.findElement(By.cssSelector(".c-feature--type-subscription"));
		bookmark = cardElement.findElement(By.cssSelector(".c-feature--type-bookmark"));
		settings = cardElement.findElement(By.cssSelector(".c-feature--type-settings"));

	}

	// @Inject
	// private CardSettingsMenu settingMenu;
	//
	// @Inject
	// private ConfirmationDialog dialog;

	@Override
	public CardType getCardType() {
		if (cardLabel.contains("Notice")) {
			return CardType.NOTICE;
		} else if (cardLabel.contains("Discussion")) {
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
	public void edit() {

		getButton("edit").click();

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

		//wait until dialog appears
		WebElementSupport.waitUntilElementAppears(okBtn);
		
		acceptDialog();
//		okBtn.click();

	}

	@Override
	public void report() {

		getButton("report").click();

	}

}
