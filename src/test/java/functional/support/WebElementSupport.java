package functional.support;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;

public final class WebElementSupport {

	public static WebElement getElementFromList(String elementName, List<WebElement> elements) {
		System.out.println("Looking for element: " + elementName);

		for (WebElement element : elements) {
			System.out.println(element.getText());
			// if (elementName.equals(element.getText())) {
			if (element.getText().toLowerCase().contains(elementName.toLowerCase())) {

				return element;
			}
		}

		throw new NoSuchElementException("");

	}

	public static void clickOnElementWithText(AppiumDriver<WebElement> driver, String type, String name) {
		// List<WebElement> elements = driver.findElements(By.className(type));
		getElementFromList(name, driver.findElementsByClassName(type)).click();
	}

	public static void sendTextToElement(AppiumDriver<WebElement> driver, String type, String name, String text) {

		WebElement element = getElementFromList(name, driver.findElementsByClassName(type));
		element.click();

		// driver.getKeyboard();

		// IOSElement el = (IOSElement)element;
		// el.click();
		// el.setValue(text);
		// el.click();
		element.sendKeys(text);
	}

	public static void waitFor(final long milliSeconds) {
		try {
			Thread.sleep(milliSeconds);
		} catch (InterruptedException e) {

			// TODO: handle exception
		}
	}

	public static void waitUntilElementAppears(WebElement element) {
		System.out.println("Wait for element to appear: " + element);
		int attempts = 3;
		int currentAttempt = 0;

		while (currentAttempt < attempts) {
			try {
				element.isDisplayed();
				return;
			} catch (WebDriverException e) {
				attempts++;
				System.out.println("Button was not found");
				System.out.println(e.getMessage());
				waitFor(1000);
			}
		}
	}

	public static void waitForElementToAppearAndClick(AppiumDriver<WebElement> driver, String type, String name) {
		System.out.println("wait for element TYPE: " + type);
		int attempts = 3;
		int currentAttempt = 0;

		while (currentAttempt < attempts) {
			System.out.println(attempts);
			System.out.println(currentAttempt);
			try {
				WebElement element = getElementFromList(name, driver.findElementsByClassName(type));
				element.click();
				return;
			} catch (Exception e) {
				currentAttempt++;
			}
		}
	}

	// public static

}
