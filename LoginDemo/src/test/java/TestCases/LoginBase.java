package TestCases;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import GeneralUtilities.ExcelUtility;

public class LoginBase
{
	@BeforeClass
	public void SetUp() throws Exception
	{
		System.out.print("Base");
	}
}
