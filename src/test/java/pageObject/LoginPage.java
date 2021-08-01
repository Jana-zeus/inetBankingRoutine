package pageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testCases.BaseClass;


public class LoginPage
{
     WebDriver driver;
     public static Logger log=LogManager.getLogger(BaseClass.class);
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (name = "uid") WebElement uname;
	@FindBy (name = "password") WebElement pwd;
	@FindBy (name = "btnLogin") WebElement loginButton;
	
	
	public void set_username(String luname)
	{
	   log.debug("Login page username entered");
	   uname.sendKeys(luname);
	}
	
	public void set_password(String lpwd)
	{
		log.debug("Login page password entered");
		pwd.sendKeys(lpwd);
	}
	
	public void click_LoginButton()
	{
		log.debug("Login page Login Button clicked");
		loginButton.click();
	}
}
