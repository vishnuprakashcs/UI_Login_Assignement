package PageRepo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashBoardPage
{
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath="//input[@id=\"focus-new\"]")
	private WebElement searchTxtBox;
	
	@FindBy(xpath="//a[@class=\"admin-dropdown profile\"]")
	private WebElement profileDropDownLink;
	
	@FindBy(xpath="//button[@type=\"button\"]")
	private WebElement logoutBtn;
	
	public DashBoardPage(WebDriver driver)
	{
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		PageFactory.initElements(driver, this);
	}
	
	public boolean VerifyDashBoardPageVisible()
	{
		this.wait.until(ExpectedConditions.visibilityOf(this.searchTxtBox));
		if(this.searchTxtBox.isDisplayed())
		{
			return true;
		}
		
		return false;
	}
	
	public boolean VerifyDashBoardPageNotVisible()
	{
		if(!this.searchTxtBox.isDisplayed())
		{
			return true;
		}
		
		return false;
	}
	
	public void ClickOnLogOutButton()
	{
		this.profileDropDownLink.click();
		this.logoutBtn.click();
	}
	
	
}
