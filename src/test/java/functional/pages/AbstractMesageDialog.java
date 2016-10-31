package functional.pages;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public abstract class AbstractMesageDialog {

	public AbstractMesageDialog(AppiumDriver<WebElement> driver) {
		PageFactory.initElements(driver, this);
	}

	final static String DIALOG_CONTAINER = ".c-message-box ";
	
	@FindBy(css = DIALOG_CONTAINER)
	private WebElement dialogContainer;

	@FindBy(css = DIALOG_CONTAINER + ".x-button")
	private List<WebElement> buttons;

	public void accept() {
		getButton("ok").click();
	}
	
	public void cancel() {
		getButton("cancel").click();
	}

	private WebElement getButton(final String btnName) {
		return buttons.stream().filter(button -> button.getText().toLowerCase().contains(btnName.toLowerCase()))
				.findFirst().orElseThrow(() -> new NoSuchElementException("Button was not found: " + btnName));
	}
	
	public boolean isVisible() {
		if (dialogContainer.isDisplayed()) {
			return true;
		}
		
		return false;
	}

}
