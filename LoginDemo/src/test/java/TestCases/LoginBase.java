package TestCases;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import GeneralUtilities.GridUtility;

public class LoginBase
{
	protected WebDriver driver;
	
	@BeforeTest
	public void SetUpDriver(ITestContext testContext) throws MalformedURLException
	{
		String host = "localhost";
		MutableCapabilities mc;
		 
	    if(System.getProperty("BROWSER") != null &&
	            System.getProperty("BROWSER").equalsIgnoreCase("firefox"))
	    {
	    	mc = new FirefoxOptions();
	    }
	    else
	    {
	    	mc = new ChromeOptions();
	    }
	 
	    if(System.getProperty("HUB_HOST") != null)
	    {
	        host = System.getProperty("HUB_HOST");
	    }
	    
	    String testName = testContext.getCurrentXmlTest().getName();
	    
	    String completeUrl = "http://" + host + ":4444/wd/hub";
	    mc.setCapability("name", testName);
	    this.driver = new RemoteWebDriver(new URL(completeUrl), mc);
	}
	
	@AfterTest
	public void QuitDriver()
	{
		this.driver.quit();
	}
	
	@BeforeSuite
	public void SetUpGrid() throws IOException, InterruptedException
	{
		GridUtility.StartDockerGrid();
	}
	
	@AfterSuite
	public void RemoveGrid() throws IOException, InterruptedException
	{
		GridUtility.StopDockerGrid();
	}
}
