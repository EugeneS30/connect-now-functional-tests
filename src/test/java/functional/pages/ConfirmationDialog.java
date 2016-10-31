package functional.pages;

import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import io.appium.java_client.AppiumDriver;

@Component
public class ConfirmationDialog extends AbstractMesageDialog {

	public ConfirmationDialog(AppiumDriver<WebElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
