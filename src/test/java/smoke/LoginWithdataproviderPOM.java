package smoke;

import java.util.HashMap;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import utils.UtilKitSetUP;


public class LoginWithdataproviderPOM extends BaseTest {

    @Test(dataProvider = "getlogintestdata")
    public void login(HashMap<String, String> logindata) {
        
        // No need for PageFactory here, the BasePage constructor handles it.
        LoginPage loginpage = new LoginPage();
        
        String testCaseID = logindata.get("TestCaseID");
        String username = logindata.get("UserName");
        String password = logindata.get("Password");

        //  Perform Actions ---
        loginpage.usernamefield(username);
        loginpage.passwordfield(password);

        //  Conditional Logic and Verification ---
   

        // Scenario: Test for empty username/password fields (button should be disabled)
        if (testCaseID.equals("TC_login-005")) {
            // In this case, we DO NOT click the login button.
            // We verify that the required field error messages appear.
        	loginpage.usernamefield(username);
            loginpage.invalidusernameerrormessage(logindata.get("ExpectedUserNameErrorMessage"));
            loginpage.invalidpassworderrormessage(logindata.get("ExpectedPasswordErrorMessage"));
           

        // Scenario: Test for successful login
        } else if (testCaseID.equals("TC_login-001")) {
            loginpage.loginbutton();
            
            // This is a positive test, so we expect to be on the HomePage.
            HomePage homepage = new HomePage();
            homepage.titleValidate(logindata.get("Expected Title"));
            homepage.VerifyUseremail(logindata.get("UserName"));

        // Scenario: All other tests are for failed logins (incorrect credentials)
        } else {
            loginpage.loginbutton();
            
            // This is a negative test, so we expect to stay on the LoginPage.
            loginpage.invalidloginerrormessage(logindata.get("ExpectedErrorMessage"));
        }
    }

    @DataProvider
    public Object[][] getlogintestdata() {
        List<HashMap<String, String>> testdata = UtilKitSetUP.getTestDataFromExcel("login");
        Object[][] obj = new Object[testdata.size()][1];
        for (int i = 0; i < testdata.size(); i++) {
            obj[i][0] = testdata.get(i);
        }
        return obj;
    }
}
