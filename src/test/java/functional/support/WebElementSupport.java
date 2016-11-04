package functional.support;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class WebElementSupport {

	public static WebElement getElementFromList(String elementName, List<WebElement> elements) {
		log.info("Looking for element in list: {}", elementName);

		for (WebElement element : elements) {
			log.debug("Current element: {}", element.getText());
			if (element.getText().toLowerCase().contains(elementName.toLowerCase())) {
				return element;
			}
		}
		throw new NoSuchElementException("");
	}

	public static void clickOnElementWithText(AppiumDriver<WebElement> driver, String type, String name) {
		getElementFromList(name, driver.findElementsByClassName(type)).click();
	}

	public static void sendTextToElement(AppiumDriver<WebElement> driver, String type, String name, String text) {
		WebElement element = getElementFromList(name, driver.findElementsByClassName(type));
		element.click();
		element.sendKeys(text);
	}

	public static void waitFor(final long milliSeconds) {
		try {
			log.debug("Sleeping for: {} ms", milliSeconds);
			Thread.sleep(milliSeconds);
		} catch (InterruptedException e) {
			log.error("Sleep was interrupted!");
		}
	}

	public static void waitUntilElementAppears(WebElement element) {
		log.info("Wait for element to appear: {}", element.getText());
		int attempts = 5;
		int currentAttempt = 0;
		long waitTime = 1000;

		while (currentAttempt < attempts) {
			try {
				log.info("Attempt: {}", currentAttempt);
				element.isDisplayed();
				return;
			} catch (WebDriverException e) {
				attempts++;
				log.error("The elemen was not found! {}", e.getMessage());
				log.info("Sleeping {} ms", waitTime);
				waitFor(waitTime);
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
