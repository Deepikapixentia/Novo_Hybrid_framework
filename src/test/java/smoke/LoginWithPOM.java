package smoke;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import base.BaseTest;
import driverfactory.DriverFactory;
import pages.HomePage;
import pages.LoginPage;

public class LoginWithPOM extends BaseTest{
	
	@Test
	public void login() {
		//page initialization
		LoginPage loginpage=PageFactory.initElements(DriverFactory.getDriver(), LoginPage.class);
		loginpage.usernamefield("bdatla@pixentia.com");
		loginpage.passwordfield("Test123$");
		loginpage.loginbutton();
		
		HomePage homepage=PageFactory.initElements(DriverFactory.getDriver(), HomePage.class);
		homepage.titleValidate("Home");
		homepage.VerifyUseremail("bdatla@pixentia.com");
		
		
	
	}

}
