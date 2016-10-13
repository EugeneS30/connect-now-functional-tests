package pages;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;

public class MainArea {
	private AppiumDriver<WebElement> driver;

	public MainArea(AppiumDriver<WebElement> driver) {
		this.driver = driver;
	}

	public void clickMainMenu() {
		WebElementSupport.clickOnElementWithText(driver, "UIAButton", "Main menu");
	}

	public void clickFilter() {
		WebElementSupport.clickOnElementWithText(driver, "UIAButton", "Filter results");
	}
	

	public void clickNotifications() {
		WebElementSupport.clickOnElementWithText(driver, "UIAButton", "Notifications");
	}
	
	public void bookMarkFirstItemInStream() {
		WebElementSupport.clickOnElementWithText(driver, "UIAButton", "Save for later");
	}
	
	public void filter(final String section) {
		
		clickFilter();
		WebElementSupport.clickOnElementWithText(driver, "UIAStaticText", section.toString());
		WebElementSupport.waitForElementToAppearAndClick(driver, "UIAButton", "Save for later");
	}
	
//    private boole
	
	
}
