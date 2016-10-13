package pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import interfaces.SlowLoading;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSFindBy;

public class WelcomePage implements SlowLoading{
	
	private AppiumDriver<WebElement> driver;
	
	public WelcomePage(AppiumDriver<WebElement> driver) {		
		this.driver = driver;
	}
	
	@iOSFindBy(className = "UIAButton")
	public List<WebElement> uiButtons;

	public void skip() {
		for (WebElement el : uiButtons) {
			System.out.println(el.getText());
		}
		WebElementSupport.clickOnElementWithText(driver, "UIAButton", "Close the tutorial");
	}


	@Override
	public boolean hasLoaded() {
		return true;
	}
	
	

}
