package regression;

import java.util.HashMap;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.LoginPage;
import pages.StepperPage;
import utils.UtilKitSetUP;

public class StepperPOM extends BaseTest {

	@Test(dataProvider = "getTestDataFromExcel")
	public void stepperpagetest(HashMap<String, String> gettestdata) {
		
		 LoginPage lp=new LoginPage();
		 lp.usernamefield(gettestdata.get("Username"));
		 lp.passwordfield(gettestdata.get("Password"));
		lp.loginbutton();
		
		StepperPage sp = new StepperPage();
		try {
			Thread.sleep(8000); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sp.getFirstNameTexts(gettestdata.get("FirstName"));
		sp.getLastNameTexts(gettestdata.get("LastName"));
	//	sp.getCurrentJobTitle(gettestdata.get("JobCategory"));
		sp.selectJobCategoryFromDropdown(gettestdata.get("JobCategory"));
		sp.clickOnDetailsNextButton();
		sp.clickOnInterestField();
		sp.selectInterestFromDropdown(gettestdata.get("InterestData"));
		sp.clickInterestAddButton();
		sp.clickInterestNextButton();
//		sp.clickInterestSkipButton();
	//	sp.clickInterestBackButton();	
		sp.clickOnSkillsField();
		sp.selectSkillFromDropdown(gettestdata.get("SkillName"));	
		sp.selectSkillLevelFromDropdown(gettestdata.get("SkillLevel"));
		sp.clickOnSkillAddButton();
//		sp.clickOnSkillbackButton();
		sp.clickOnSkillNextButton();
	//	sp.clickOnGetStartedButton();
		

	}

	@DataProvider
	public Object[][] getTestDataFromExcel() {

		List<HashMap<String, String>> stepperdata = UtilKitSetUP.getTestDataFromExcel("StepperPage");
		Object[][] obj = new Object[stepperdata.size()][1];
		for (int i = 0; i < stepperdata.size(); i++) {
			obj[i][0] = stepperdata.get(i);
		}
		return obj;

	}

}
