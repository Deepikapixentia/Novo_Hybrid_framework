package driverfactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import exceptions.InValidBrowserException;

public class DriverFactory {

	private static ThreadLocal<WebDriver> tdriver = new ThreadLocal<>();

	public static WebDriver getDriver() {
		return tdriver.get();

	}

	private static void setDriver(WebDriver driver) {
		tdriver.set(driver);
	}

	public static void initDriver(String browser, boolean headless) {
		WebDriver driver;

		switch (browser.toLowerCase()) {

		case "chrome":

			ChromeOptions chromeoptions = new ChromeOptions();
			chromeoptions.addArguments("--remote-allow-origins=*");
			chromeoptions.addArguments("--window-size=1920,1080");

			if (headless) {
				chromeoptions.addArguments("--headless=new");
				chromeoptions.addArguments("--no-sandbox");
				chromeoptions.addArguments("--disable-dev-shm-usage");
			}

			driver = new ChromeDriver(chromeoptions);
			break;

		case "edge":
			EdgeOptions edgeoptions = new EdgeOptions();
			edgeoptions.addArguments("--window-size=1920,1080");

			if (headless) {
				edgeoptions.addArguments("--headless=new");
				edgeoptions.addArguments("--no-sandbox");
				edgeoptions.addArguments("--disable-dev-shm-usage");
			}
			driver = new EdgeDriver(edgeoptions);
			break;

		case "firefox":
			FirefoxOptions firefoxoptions = new FirefoxOptions();
			if(headless) {
			firefoxoptions.addArguments("-headless");
			}

			driver = new FirefoxDriver(firefoxoptions);
			break;

		default:
			throw new InValidBrowserException();

		}
		setDriver(driver);
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

}
