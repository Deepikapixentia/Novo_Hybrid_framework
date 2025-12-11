package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	@FindBy(xpath = "//span[@class='user-email']")
	WebElement useremail;
	
	public void VerifyUseremail(String text) {
	textValidation(useremail, text);
		
	}

}
