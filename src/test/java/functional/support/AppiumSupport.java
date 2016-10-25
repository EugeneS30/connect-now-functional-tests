package functional.support;

import java.util.HashMap;
import java.util.Set;

import javax.inject.Inject;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import io.appium.java_client.AppiumDriver;

@Component
public final class AppiumSupport {

	@Inject
	private AppiumDriver<WebElement> driver;

	// Swipe from the middle of the screen down. Used to refresh Connect Now
	// content.
	public void swipeDown() {

		switchToView("NATIVE");

		Dimension screenSize = driver.manage().window().getSize();
		int width = screenSize.getWidth();
		int height = screenSize.getHeight();
		int widthCenter = width / 2;
		int heightCenter = height / 2;

		try {
			driver.swipe(widthCenter, heightCenter, widthCenter, heightCenter + heightCenter/2 , 1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			switchToView("WEB");
		}

	}

	@Deprecated
	public void scrollDown() {

		switchToView("NATIVE");

		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			HashMap<String, String> scrollObject = new HashMap<String, String>();
			scrollObject.put("direction", "down");
			js.executeScript("mobile: scroll", scrollObject);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			switchToView("WEB");
		}

	}

	private void switchToView(String view) {

		Set<String> contextNames = driver.getContextHandles();

		for (String contextName : contextNames) {
			if (contextName.contains(view)) {
				driver.context(contextName);
			}
		}
	}

}
