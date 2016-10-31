package functional.pages;

import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import io.appium.java_client.AppiumDriver;

@Component
public class ErrorDialog extends AbstractMesageDialog {

	public ErrorDialog(AppiumDriver<WebElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
