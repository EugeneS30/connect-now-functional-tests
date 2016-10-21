package functional.pages;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class StreamItemSettingsMenuImpl implements StreamItemSettingsMenu {

	public StreamItemSettingsMenuImpl(AppiumDriver<WebElement> driver) {
		PageFactory.initElements(driver, this);
	}

	final static String MENU_CONTAINER_CSS = ".c-options-list ";

	@FindBy(css = ".x-button-no-icon")
	private List<WebElement> menuItems;

	private WebElement getMenuItem(final String menuItemName) {
		return menuItems.stream()
				.filter(element -> element.getText().toLowerCase().contains(menuItemName.toLowerCase())).findFirst()
				.orElseThrow(() -> new NoSuchElementException("No such element found in menu: " + menuItemName));
	}

	@Override
	public void edit() {
		getMenuItem("edit").click();
	}

	@Override
	public void unfollow() {
		getMenuItem("unfollow").click();
	}

	@Override
	public void hide() {
		getMenuItem("hide").click();
	}

	@Override
	public void report() {
		getMenuItem("report").click();
	}

	@Override
	public void cancel() {
		getMenuItem("cancel").click();
	}

}
