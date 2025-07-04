package testscripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class TestBase {
//	protected DashboardPage dashboardPage;
	
	@BeforeMethod
	public void setup() {
		System.out.println("PREREQUISITE - Login Entrata using valid credentials and user is on dashboard page.");
//		ControlActions.start();
//		LoginPage page = new LoginPage();
//		dashboardPage = page.login("mauliknov24@gmail.com", "Pass@123");
//		dashboardPage.waitForPageLoad();
	}
	
	@AfterMethod
	public void tearDown() {
//		if(result.getStatus() == 2) {
////			ControlActions.takeScreenshot(result.getName()+"_"+ DateTimeUtil.getTimeStamp());
//		}
		System.out.println("CLEAN UP - Close browser");
		//ControlActions.closeBrowser();
	}
}
