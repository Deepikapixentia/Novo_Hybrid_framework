package regression;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.GAdmin_HomePage;
import pages.LoginPage;


public class GAdmin_HomewithPOM extends BaseTest  {
	
	@Test
	public void homePageRedirectionsvalidation() {
		
		LoginPage lg=new LoginPage();
		lg.usernamefield("bdatla@pixentia.com");
		lg.passwordfield("Test123$");
		lg.loginbutton();
		
		GAdmin_HomePage gadminhomepage=	new GAdmin_HomePage();
		gadminhomepage.usersView();
		gadminhomepage.clicOnHomeTab();
		gadminhomepage.learningJourneyTabView();
		gadminhomepage.clicOnHomeTab();
		gadminhomepage.gamificationTabView();
		gadminhomepage.clicOnHomeTab();
		gadminhomepage.assessmentsTabView();
		gadminhomepage.clicOnHomeTab();
		gadminhomepage.getTotalUsersInApplication();
		gadminhomepage.getTotalOrgsInApplication();
		gadminhomepage.getTotalLearnJourneysInApplication();
	}

}
