package dev;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import configuration.TestConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import pages.FilterSections;
import pages.LoginPage;
import pages.MainArea;
import pages.WelcomePage;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes=TestConfig.class)
public class MainTest {

	private AppiumDriver<WebElement> driver;

	@Before
	public void setUp() throws MalformedURLException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("autoAcceptAlerts", "true");
		capabilities.setCapability("appium-version", "1.0");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "9.1");
		capabilities.setCapability("deviceName", "iPhone 6s Plus");
		capabilities.setCapability("app", "/Users/eschooling/Desktop/Connect Now.app");
		URL URLString = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new IOSDriver<WebElement>(URLString, capabilities);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@Test
	public void test() {
		WelcomePage welcomePage = new WelcomePage(driver);
		LoginPage loginPage = new LoginPage(driver);
		MainArea mainArea = new MainArea(driver);
		
		welcomePage.skip();
		loginPage.login("e4015322", "789Learn");
		
		mainArea.bookMarkFirstItemInStream();
		mainArea.filter("Read later");
		
	}

	@After
	public void tearDown() {
		// driver.close();
		driver.quit();
	}
}
