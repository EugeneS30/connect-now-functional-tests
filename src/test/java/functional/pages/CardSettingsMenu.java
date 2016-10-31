package functional.pages;

import java.util.List;

import javax.inject.Inject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

import io.appium.java_client.AppiumDriver;

@Component
public class CardSettingsMenu implements CardSettings {

	public CardSettingsMenu(AppiumDriver<WebElement> driver) {
		PageFactory.initElements(driver, this);
	}
	
	@Inject
	private ConfirmationDialog confirmationDialog;

	final static String CARD_MENU_CONTAINER = ".c-options-list ";

	@FindBy(css = CARD_MENU_CONTAINER + "")
	private List<WebElement> menuButtons;

	private WebElement getButton(final String btnName) {
		return menuButtons.stream().filter(button -> button.getText().toLowerCase().contains(btnName.toLowerCase()))
				.findFirst().get();
	}

	@Override
	public void edit() {
		getButton("edit").click();

	}

	@Override
	public void unfollow() {
		getButton("unfollow").click();

	}

	@Override
	public void hide() {
		getButton("hide").click();
		confirmationDialog.accept();
	}

	@Override
	public void report() {
		getButton("report").click();

	}

}
