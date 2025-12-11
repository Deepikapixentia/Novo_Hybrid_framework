package smoke;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;

public class LoginWithPOM extends BaseTest{
	
	@Test
	public void login() {
		//page initialization
		LoginPage loginpage=PageFactory.initElements(driver, LoginPage.class);
		loginpage.usernamefield("bdatla@pixentia.com");
		loginpage.passwordfield("Test123$");
		loginpage.loginbutton();
		
		HomePage homepage=PageFactory.initElements(driver, HomePage.class);
		homepage.titleValidate("Home");
		homepage.VerifyUseremail("bdatla@pixentia.com");
		
		
	
	}

}
