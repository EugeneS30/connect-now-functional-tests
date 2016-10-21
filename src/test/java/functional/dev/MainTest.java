package functional.dev;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

import cucumber.api.java.Before;
import functional.pages.LoginPage;
import functional.pages.NoticeTestData;
import functional.pages.StreamImpl;
import functional.pages.StreamToolbar;
import functional.pages.StreamType;
import functional.pages.WelcomePage;
import io.appium.java_client.AppiumDriver;

@ComponentScan(basePackages = "")
@Configuration
@ContextConfiguration("classpath:/cucumber.xml")
public class MainTest {

	private AppiumDriver<WebElement> driver;
	WelcomePage welcomePage;// = new WelcomePage(driver);
	LoginPage loginPage;// = new LoginPage(driver);
	StreamImpl mainArea;// = new StreamImpl(driver);
	StreamToolbar streamToolbar;// = new StreamToolbar(driver);
	
	@Before
	public void setUp() throws MalformedURLException {

		// DesiredCapabilities capabilities = new DesiredCapabilities();
		// capabilities.setCapability("autoAcceptAlerts", "true");
		// capabilities.setCapability("appium-version", "1.0");
		// capabilities.setCapability("platformName", "iOS");
		// capabilities.setCapability("platformVersion", "9.1");
		// capabilities.setCapability("deviceName", "iPhone 6s Plus");
		// capabilities.setCapability("nativeWebTap", true);
		// capabilities.setCapability("app", "/Users/eschooling/Desktop/Connect
		// Now.app");
		// URL URLString = new URL("http://127.0.0.1:4723/wd/hub");
		// driver = new IOSDriver<WebElement>(URLString, capabilities);
		// driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//
		// Set<String> contextNames = driver.getContextHandles();
		// for (String contextName : contextNames) {
		// if (contextName.contains("WEB")) {
		// driver.context(contextName);
		// }
		// }
		//
		// welcomePage = new WelcomePage(driver);
		// loginPage = new LoginPage(driver);
		// mainArea = new StreamImpl(driver);
		// streamToolbar = new StreamToolbar(driver);
		//
		// welcomePage.skip();
		// loginPage.login("e2023069", "789Learn");
	}

	@Test
	public void create_new_class_notice() {

		// TestData discussionTest = DiscussionTestData.create()
		// .className("ConnectNowTestClass")
		// .discussionGroupName("discussionGroup")
		// .title("title")
		// .message("message")
		// .isShown(true);

		NoticeTestData discussionTest = NoticeTestData.create().className("ConnectNowTestClass").title("title")
				.message("message").isShown(true);

		mainArea.addNotice(StreamType.CLASS, "ConnectNowTestClass", discussionTest);
		assertTrue(mainArea.cardExists(discussionTest));

	}

	// @Test
	// public void create_new_class_discussion() {
	//
	// TestData discussionTest = DiscussionTestData.create()
	// .className("ConnectNowTestClass")
	// .discussionGroupName("discussionGroup")
	// .title("title")
	// .message("message")
	// .isShown(true);
	//
	//
	// mainArea.addDiscussion(StreamType.CLASS, discussionTest);
	// assertTrue(mainArea.cardExists(discussionTest));
	//
	// }

	@After
	public void tearDown() {
		// driver.close();
		driver.quit();
	}
}
