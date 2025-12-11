package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import exceptions.InValidBrowserException;
import utils.ExtentManager;

public class BaseTest {

	public static FileInputStream fis;
	public static Properties conprop;
	public static WebDriver driver;
	public static ExtentReports reports;
	public static ExtentTest test;

	@BeforeTest
	public void fileConfiuration() {

		try {
			fis = new FileInputStream(
"C:\\Users\\dlakkamraju\\eclipse-workspace\\Novo_Hybrid_FrameWork\\Properties\\configurationfiles\\configuration.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		conprop = new Properties();
		try {
			conprop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		reports=ExtentManager.getreports();// get reports is method name of extent reports class
	}

	@BeforeMethod
	public void browserSetup(Method methodname) {
		
	   test=reports.createTest(methodname.getName());

		switch (conprop.getProperty("browser")) {
		case "chrome":
			driver = new ChromeDriver();
			test.log(Status.INFO, conprop.getProperty("browser") +" browser is selected");
			break;
		case "firefox":
			driver = new FirefoxDriver();
			test.log(Status.INFO, conprop.getProperty("browser") +" browser is selected");
			break;
		case "edge":
			driver = new EdgeDriver();
			test.log(Status.INFO, conprop.getProperty("browser") +" browser is selected");
			break;

		default:
			throw new InValidBrowserException();			
		}

		driver.get(conprop.getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@AfterTest
	public void reportsFlush() {
		reports.flush();
	}
}
