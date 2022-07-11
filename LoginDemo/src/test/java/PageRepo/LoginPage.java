package PageRepo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage
{
	WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(name="username")
	private WebElement userNameTxtBox;
	
	@FindBy(name="password")
	private WebElement passwordTxtBox;
	
	@FindBy(xpath="//button[@type=\"submit\"]")
	private WebElement loginBtn;
	
	@FindBy(xpath="//p[@class=\"cbox_messagebox\"]")
	private WebElement messageBox;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		PageFactory.initElements(driver, this);
	}
	
	public void GoTo(String loginPageUrl)
	{
		this.driver.get(loginPageUrl);
		this.wait.until(ExpectedConditions.visibilityOf(this.userNameTxtBox));
	}
	
	public void EnterUserCredentials(String userName, String password) throws InterruptedException
	{
		Thread.sleep(500);
		this.userNameTxtBox.sendKeys(userName);
		Thread.sleep(500);
		this.passwordTxtBox.sendKeys(password);
		Thread.sleep(500);
	}
	
	public String getMessageBoxValue()
	{
		return this.messageBox.getText();
	}
	
	public void ClickLoginButton() throws InterruptedException
	{
		Thread.sleep(500);
		this.loginBtn.click();
	}
	
	public boolean VerifyLoginPageVisible()
	{
		this.wait.until(ExpectedConditions.visibilityOf(this.userNameTxtBox));
		if(this.userNameTxtBox.isEnabled())
		{
			return true;
		}
		
		return false;
	}
}
