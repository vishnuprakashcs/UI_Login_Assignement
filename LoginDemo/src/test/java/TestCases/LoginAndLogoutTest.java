package TestCases;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import GeneralUtilities.ExcelUtility;
import PageRepo.DashBoardPage;
import PageRepo.LoginPage;

public class LoginAndLogoutTest extends LoginBase
{
	@BeforeClass
	public void SetUp() throws Exception
	{
		ArrayList<String> datas = ExcelUtility.getData("LoginPageUrl", "WebUrls");
		String loginUrl = datas.get(1).toString();
		driver.get(loginUrl);
		Reporter.log("Entering in to login page..");
	}
	
	@Test
	public void LoginAndLogout() throws Exception
	{
		
		System.out.println("Valid login attempt test started.");
		// Ensure login with valid credentials.
		LoginPage loginPage = new LoginPage(driver);
		Assert.assertTrue(loginPage.VerifyLoginPageVisible(), "Failure reason: LoginPage is not yet displayed.");
		Reporter.log("Entered in to login page..");
		ArrayList<String> datas = ExcelUtility.getData("ValidCredentials", "LoginCredentials");
		Thread.sleep(500);
		Reporter.log("Start inputing the username and password..");
		loginPage.EnterUserCredentials(datas.get(1).toString(), datas.get(2).toString());
		loginPage.ClickLoginButton();
		Reporter.log("Clicked the login button..");
		
		Thread.sleep(500);
		DashBoardPage dashBoardPage = new DashBoardPage(driver);
		Assert.assertTrue(dashBoardPage.VerifyDashBoardPageVisible(), "Failure reason: DashBoardPage is not yet displayed.");
		System.out.println("Login successfull...");
		Reporter.log("Login successfull and trying to logout..");
		dashBoardPage.ClickOnLogOutButton();
		Thread.sleep(500);
		Assert.assertTrue(loginPage.VerifyLoginPageVisible(), "Failure reason: LoginPage is not yet displayed.");
		System.out.println("Logout successfull...");
		Reporter.log("Logout completed and successfull...");
	}
}
