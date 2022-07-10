package TestCases;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import GeneralUtilities.ExcelUtility;
import PageRepo.DashBoardPage;
import PageRepo.LoginPage;

public class LoginAndLogoutTest extends LoginBase
{
	public RemoteWebDriver driver = null;
	
	@BeforeClass
	public void SetUp() throws Exception
	{
		FirefoxOptions options = new FirefoxOptions();
		URL url = new URL("http://localhost:4444/wd/hub");
		driver = new RemoteWebDriver(url, options);
		driver.manage().window().maximize();
		ArrayList<String> datas = ExcelUtility.getData("LoginPageUrl", "WebUrls");
		driver.get(datas.get(1).toString());
	}
	
	@Test
	public void LoginAndLogout() throws Exception
	{
		System.out.println("Valid login attempt test started.");
		// Ensure login with valid credentials.
		LoginPage loginPage = new LoginPage(driver);
		Assert.assertTrue(loginPage.VerifyLoginPageVisible(), "Failure reason: LoginPage is not yet displayed.");
		ArrayList<String> datas = ExcelUtility.getData("ValidCredentials", "LoginCredentials");
		Thread.sleep(500);
		loginPage.EnterUserCredentials(datas.get(1).toString(), datas.get(2).toString());
		loginPage.ClickLoginButton();
		
		Thread.sleep(500);
		DashBoardPage dashBoardPage = new DashBoardPage(driver);
		Assert.assertTrue(dashBoardPage.VerifyDashBoardPageVisible(), "Failure reason: DashBoardPage is not yet displayed.");
		System.out.println("Login successfull...");
		dashBoardPage.ClickOnLogOutButton();
		Thread.sleep(500);
		Assert.assertTrue(loginPage.VerifyLoginPageVisible(), "Failure reason: LoginPage is not yet displayed.");
		System.out.println("Logout successfull...");
	}
}
