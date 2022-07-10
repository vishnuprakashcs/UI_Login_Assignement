package TestCases;

import java.net.URL;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import GeneralUtilities.ExcelUtility;
import PageRepo.DashBoardPage;
import PageRepo.LoginPage;

public class InvalidLoginAttemptTest extends LoginBase
{
	public RemoteWebDriver driver = null;
	
	@BeforeClass
	public void SetUp() throws Exception
	{
		ChromeOptions options = new ChromeOptions();
		URL url = new URL("http://localhost:4444/wd/hub");
		driver = new RemoteWebDriver(url, options);
		driver.manage().window().maximize();
		ArrayList<String> datas = ExcelUtility.getData("LoginPageUrl", "WebUrls");
		driver.get(datas.get(1).toString());
	}
	
	@Test
	public void LoginWithInValidCredentials() throws Exception
	{
		// try to login with invalid username and password.
		LoginPage loginPage = new LoginPage(driver);
		Assert.assertTrue(loginPage.VerifyLoginPageVisible(), "Failure reason: LoginPage is not yet displayed.");
		ArrayList<String> datas = ExcelUtility.getData("InvalidCredentials", "LoginCredentials");
		System.out.println("Invalid login attempt test started.");
		Thread.sleep(500);
		loginPage.EnterUserCredentials(datas.get(1).toString(), datas.get(2).toString());
		loginPage.ClickLoginButton();
		Thread.sleep(500);
		Assert.assertTrue(loginPage.getMessageBoxValue().equals(datas.get(3).toString()), "Failure reason: Expected message not displayed.");
		
		// Verify the dash page is not shown on invalid login process.
		DashBoardPage dashBoardPage = new DashBoardPage(driver);
		Thread.sleep(500);
		Assert.assertTrue(dashBoardPage.VerifyDashBoardPageNotVisible(), "Failure reason: DashBoardPage is displayed.");
		System.out.println("Invalid login attempt test completed.");
	}
}
