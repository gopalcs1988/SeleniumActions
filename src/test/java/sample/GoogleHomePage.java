package sample;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GoogleHomePage {
	private WebDriver driver;

	@Parameters("browser")
	@BeforeClass
	public void setUp(String browser) throws MalformedURLException {
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), new ChromeOptions());
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), new FirefoxOptions());
		}
	}

	@Test
	public void testGoogleSearch() {
		// Open Google
		driver.get("https://www.google.com");

		// Verify title
		assert driver.getTitle().contains("Google");
	}

	@AfterClass
	public void tearDown() {
		// Close the browser
		if (driver != null) {
			driver.quit();
		}
	}
}
