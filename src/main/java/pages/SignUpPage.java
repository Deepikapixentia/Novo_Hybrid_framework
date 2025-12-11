package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage {
	
	public SignUpPage() {
		super();
	}
	

	
	@FindBy(xpath = "//input[@formcontrolname='firstName']")
	WebElement firstname;
	
	@FindBy(xpath = "//input[@formcontrolname='lastName']")
	WebElement lastname;
	
	@FindBy(xpath = "//input[@formcontrolname='email']")
	WebElement email;
	
	@FindBy(xpath = "//input[@formcontrolname='address1']")
	WebElement address1;
	
	@FindBy(xpath = "//input[@formcontrolname='address2']")
	WebElement address2;
	
	@FindBy(xpath = "//input[@formcontrolname='city']")
	WebElement city;
	
	@FindBy(xpath = "//input[@formcontrolname='state']")
	WebElement state;
	
	@FindBy(xpath = "//input[@formcontrolname='country']")
	WebElement country;
	
	@FindBy(xpath = "//input[@formcontrolname='zip']")
	WebElement zip;
	
	@FindBy(xpath = "//input[@formcontrolname='password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@formcontrolname='confirmPassword']")
	WebElement confpassword;
	
	@FindBy(xpath = "//button[text()='Sign up']")
	WebElement signup_submitbutton;
	
	@FindBy(xpath = "//div[@id=\"toast-container\"]")
	WebElement emailexisterrormessagefield;
	
	
	@FindBy(xpath = "//a[text()='Login here!']")
	WebElement signup_loginbutton;
	
	
 	
	public void EnterSignUPFormData(String fname,String lname,String Email, String addr1, String addr2, String City,
			String State, String cntry, String zipcode, String pass, String cpass) {
		type(firstname, fname);	
		type(lastname, lname);	
		type(email, Email);
		type(address1, addr1);	
		type(address2, addr2);	
		type(city, City);
		type(state, State);
		type(country, cntry);	
		type(zip, zipcode);	
		type(password, pass);	
		type(confpassword, cpass);
	}	
		
		public void signUPButton() {
		click(signup_submitbutton);	
		}
		public void loginReditection() {
		click(signup_loginbutton);		
	}
		
		

	
	
	

}
