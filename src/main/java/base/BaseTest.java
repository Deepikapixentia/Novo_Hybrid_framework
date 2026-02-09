package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import driverfactory.DriverFactory;
import utils.ExtentManager;
import utils.ExtentTestManager;

public class BaseTest {

	public static FileInputStream fis;
	public static Properties conprop;

	public static ExtentReports reports;

	@BeforeTest
	public void fileConfiuration() {

		try {

			String projectPath = System.getProperty("user.dir");
			fis = new FileInputStream(projectPath + "\\Properties\\configurationfiles\\configuration.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		conprop = new Properties();
		try {
			conprop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		reports = ExtentManager.getreports();// get reports is method name of extent reports class
	}

	@BeforeMethod
	public void browserSetup(Method methodname) {

		ExtentTestManager.setTest(reports.createTest(methodname.getName()));

		String browser = conprop.getProperty("browser");
		boolean headless = Boolean.parseBoolean(conprop.getProperty("headless", "false"));

		DriverFactory.initDriver(browser, headless);
		DriverFactory.getDriver().get(conprop.getProperty("URL"));
		DriverFactory.getDriver().manage().window().maximize();

	}

	@AfterMethod
	public void tearDown() {
		// It is safer to check if driver is null before quitting
		if (DriverFactory.getDriver() != null) {
			DriverFactory.getDriver().quit();
		}
		ExtentTestManager.unload();
	}

	@AfterTest
	public void reportsFlush() {
		reports.flush();

	}
}
