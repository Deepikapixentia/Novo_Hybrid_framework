package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	// user name
	@FindBy(xpath = "//input[@formcontrolname='username']")
	WebElement usernamefield;

	@FindBy(xpath = "//input[@formcontrolname='password']")
	WebElement passwordfield;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginbutton;

	@FindBy(xpath = "//div[@class='alert alert-danger']")
	WebElement invalidloginerrormessage;

	@FindBy(xpath = "//span[@class='text-danger' and text()=' Username is required ']")
	WebElement invalidusernameerrormessage;

	@FindBy(xpath = "//span[@class='text-danger' and text()=' Password is required ']")
	WebElement invalidpassworderrormessage;

	@FindBy(xpath = "//a[@class='signup-link']")
	WebElement signuplink;

// instead of writing multiple send keys, click, common methods we create new class base page and use keywords

	public void usernamefield(String text) {
		type(usernamefield, text);
	}

	public void passwordfield(String text) {
		type(passwordfield, text);
	}

	public void loginbutton() {
		click(loginbutton);
	}

	public void invalidloginerrormessage(String text) {
		textValidation(invalidloginerrormessage, text);
	}

	public void invalidusernameerrormessage(String text) {
		textValidation(invalidusernameerrormessage, text);
	}

	public void invalidpassworderrormessage(String text) {
		textValidation(invalidpassworderrormessage, text);
	}

	public void SignupLink() {
		click(signuplink);
	}

}
