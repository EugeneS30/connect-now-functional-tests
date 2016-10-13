package pages;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class LoginPage {
	
	private AppiumDriver<WebElement> driver;
	
	public LoginPage(AppiumDriver<WebElement> driver) {
		
		this.driver = driver;
		
	}
	
	
	public void login(String username, String password) {
		
//		List<WebElement> el = driver.findElementsby(By.className(".x-form-label"));
		WebElement el = driver.findElement(MobileBy.className("UIA.x-form-label"));
		System.out.println(el);
		
		WebElementSupport.sendTextToElement(driver, "UIATextField", "Username", username);
		WebElementSupport.sendTextToElement(driver, "UIASecureTextField", "Password", password);
		WebElementSupport.clickOnElementWithText(driver, "UIAStaticText", "Log in");
		WebElementSupport.waitForElementToAppearAndClick(driver, "UIAStaticText", "OK");
		
	}
	
	

}
