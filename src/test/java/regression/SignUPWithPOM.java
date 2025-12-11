package regression;

import java.util.HashMap;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.LoginPage;
import pages.SignUpPage;
import utils.UtilKitSetUP;

public class SignUPWithPOM extends BaseTest{
	
	
	@Test(dataProvider = "getSignUPdata")
	public void SignUPValidation(HashMap <String, String> signupdata) {
		
	//	SignUpPage sp=PageFactory.initElements(driver, SignUpPage.class);
	//	sp.signUPButton();
		LoginPage loginpage= new LoginPage();
		loginpage.SignupLink();
		
		SignUpPage signuppage= new SignUpPage();
		signuppage.EnterSignUPFormData(
				signupdata.get("FirstName"),
				signupdata.get("LastName"),
				signupdata.get("Email"),
				signupdata.get("Address1"),
				signupdata.get("Address2"),
				signupdata.get("City"),
				signupdata.get("State"),
				signupdata.get("Country"),
				signupdata.get("Zip"),
				signupdata.get("Password"),
				signupdata.get("ConfPassword")
		);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		signuppage.signUPButton();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
				
	}
	
	@DataProvider
	public Object[][] getSignUPdata(){

    List <HashMap <String, String>> signupdata=UtilKitSetUP.getTestDataFromExcel("signup");
   Object[][] obj= new Object[signupdata.size()][1];
   for(int i=0; i< signupdata.size(); i++) {
	   obj[i][0]=signupdata.get(i);
   }
		
		return obj;		
	}

}
