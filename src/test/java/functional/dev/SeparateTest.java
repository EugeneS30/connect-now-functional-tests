package functional.dev;

import org.junit.Test;
import org.openqa.selenium.WebElement;

import functional.pages.LoginPage;
import functional.pages.StreamImpl;
import functional.pages.StreamToolbar;
import functional.pages.WelcomePage;
import io.appium.java_client.AppiumDriver;

public class SeparateTest {
	
	private AppiumDriver<WebElement> driver;
	
	public SeparateTest(AppiumDriver<WebElement> driver) {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void test() {
		WelcomePage welcomePage = new WelcomePage(driver);
		LoginPage loginPage = new LoginPage(driver);
		StreamImpl mainArea = new StreamImpl(driver);
		StreamToolbar streamToolbar = new StreamToolbar(driver);
		
		welcomePage.skip();
		loginPage.login("e4015322", "789Learn");
		
//		mainArea.addDiscussion("classes");

		streamToolbar.filterBy("Read later");
	}

}
