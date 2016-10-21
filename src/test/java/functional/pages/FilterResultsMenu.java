package functional.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class FilterResultsMenu {

	public FilterResultsMenu(AppiumDriver<WebElement> driver) {
		PageFactory.initElements(driver, this);
	}

	final static String MENU_CONTAINER_CSS = ".c-channel-list ";

	@FindBy(css = MENU_CONTAINER_CSS + ".x-list-item")
	private List<WebElement> menuItemsList;

	public void selectItem(final String itemName) {
		System.out.println(menuItemsList);
		for (WebElement element : menuItemsList) {
			System.out.println(element.getText());
		}
		menuItemsList.stream().filter(item -> item.getText().contains(itemName)).findFirst().get().click();

	}

}
