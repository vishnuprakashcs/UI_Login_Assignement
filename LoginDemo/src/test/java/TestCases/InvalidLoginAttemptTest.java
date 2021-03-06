package TestCases;

import java.util.ArrayList;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import GeneralUtilities.ExcelUtility;
import PageRepo.DashBoardPage;
import PageRepo.LoginPage;

public class InvalidLoginAttemptTest extends LoginBase
{
	String loginUrl = "";
	@BeforeClass
	public void SetUp() throws Exception
	{
		ArrayList<String> datas = ExcelUtility.getData("LoginPageUrl", "WebUrls");
		loginUrl = datas.get(1).toString();
		driver.get(loginUrl);
	}
	
	@Test
	public void LoginWithInValidCredentials() throws Exception
	{
		// try to login with invalid username and password.
		Reporter.log("Invalid login attempt test started.");
		LoginPage loginPage = new LoginPage(driver);
		Assert.assertTrue(loginPage.VerifyLoginPageVisible(), "Failure reason: LoginPage is not yet displayed.");
		ArrayList<String> datas = ExcelUtility.getData("InvalidCredentials", "LoginCredentials");
		System.out.println("Invalid login attempt test started.");
		loginPage.EnterUserCredentials(datas.get(1).toString(), datas.get(2).toString());
		loginPage.ClickLoginButton();
		//Assert.assertTrue(loginPage.getMessageBoxValue().equals(datas.get(3).toString()), "Failure reason: Expected message not displayed.");
		Assert.assertTrue((!this.driver.getCurrentUrl().equals("https://wave-trial.getbynder.com/account/dashboard/")), "Failure reason: Dashboard page displayed.");
		System.out.println("Invalid login attempt test completed.");
		Reporter.log("Invalid login attempt test completed.");
	}
}
