package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import base.BaseTest;

public class BasePage extends BaseTest {
	public WebDriverWait wait;

	// Add a constructor to initialize the WebDriverWait object and page factory
	public BasePage() {
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(conprop.getProperty("explicitwait"))));
	}

	public void type(WebElement element, String text) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(text);
		test.log(Status.INFO, "entered the data "+text);
	}

	public void click(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		test.log(Status.INFO, "clicked on the element");
	}

	public void clickwithJSExecutor(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

	public void scrollToElementUsingJS(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollInToView({block:'center'})", element);
	}

	public void select(WebElement element, String option) {
		wait.until(ExpectedConditions.visibilityOf(element));
		new Select(element).selectByVisibleText(option);
	}

	public String getTitle() {
		// wait.until(ExpectedConditions.titleContains(conprop.getProperty("title")));
		return driver.getTitle();
	}

	public String titleValidate(String expectedTitle) {
		wait.until(ExpectedConditions.titleIs(expectedTitle));
		Assert.assertEquals(getTitle(), expectedTitle);
		test.log(Status.PASS, "actual title is matched with expected title");
		return expectedTitle;
	}

	public String textValidation(WebElement element, String text) {
		wait.until(ExpectedConditions.visibilityOf(element));
		Assert.assertTrue(element.getText().contains(text));
		return text;
	}

	public String attributeValueValidation(WebElement element, String text) {
		wait.until(ExpectedConditions.visibilityOf(element));
		Assert.assertTrue(element.getAttribute("value").contains(text));
		return text;
	}

	public String getInputValueUsingJS(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// 'arguments[0].value' returns the actual text inside the input box
		String text = (String) js.executeScript("return arguments[0].value;", element);
		return text;
	}

	public String validateInputTextUsingJS(WebElement element, String expectedText) {
		String actualText = getInputValueUsingJS(element);
		System.out.println("Actual Value from JS: " + actualText);
		System.out.println("Expected Value from Excel: " + expectedText);
		Assert.assertTrue(actualText.equals(expectedText),
				"Mismatch! Screen has: '" + actualText + "' but Excel has: '" + expectedText + "'");
		return actualText;
	}
	
	public void getText(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	/*
	 * public void waitForElementPresence() {
	 *  wait=new WebDriverWait(driver,
	 *           Duration.ofSeconds(Long.parseLong(conprop.getProperty("explicitwait"))));
	 * 
	 * }
	 */
}
