package functional.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public abstract class AbstractNewCardDialog {

	public AbstractNewCardDialog(AppiumDriver<WebElement> driver) {
		PageFactory.initElements(driver, this);
	}

	final static String DISCUSSIONWINDOW_CONTAINER_CSS = ".x-navigationview ";

	@FindBy(css = DISCUSSIONWINDOW_CONTAINER_CSS + ".x-list-item-first")
	private WebElement classes;

	@FindBy(css = DISCUSSIONWINDOW_CONTAINER_CSS + ".x-list-item-last")
	private WebElement communities;

	public void chooseClasses() {
		classes.click();
	}

	public void chooseCommunities() {
		communities.click();
	}

}
