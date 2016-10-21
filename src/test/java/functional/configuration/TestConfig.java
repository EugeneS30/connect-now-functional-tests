package functional.configuration;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;

@ContextConfiguration("classpath:/cucumber.xml")
@Configuration
@ComponentScan()
public class TestConfig {

	@Autowired
	public AppiumDriver<WebElement> getDriver() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("autoAcceptAlerts", "true");
		capabilities.setCapability("appium-version", "1.0");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "9.1");
		capabilities.setCapability("deviceName", "iPhone 6s Plus");
		capabilities.setCapability("nativeWebTap", true);
		capabilities.setCapability("app", "/Users/eschooling/Desktop/ConnectNow.app");
		URL URLString = new URL("http://127.0.0.1:4723/wd/hub");
		AppiumDriver<WebElement> driver = new IOSDriver<WebElement>(URLString, capabilities);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		Set<String> contextNames = driver.getContextHandles();
		for (String contextName : contextNames) {
			if (contextName.contains("WEB")) {
				driver.context(contextName);
			}
		}
		
		return driver;
	}

}
