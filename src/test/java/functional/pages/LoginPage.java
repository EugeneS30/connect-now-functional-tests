package functional.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

import functional.support.WebElementSupport;
import io.appium.java_client.AppiumDriver;

@Component
public class LoginPage {

	public LoginPage(AppiumDriver<WebElement> driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".x-input-text")
	private WebElement usernameField;

	@FindBy(css = ".x-input-password")
	private WebElement passwordField;

	@FindBy(css = ".c-login__button")
	private WebElement loginBtn;

	@FindBy(css = ".c-message-box .x-button")
	private WebElement okBtn;

	public void login(String username, String password) {

		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginBtn.click();

		WebElementSupport.waitUntilElementAppears(okBtn);
		okBtn.click();

	}

}
