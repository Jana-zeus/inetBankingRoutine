package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.LoginPage;

public class TC_Login_001 extends BaseClass 
{
	@Test
	public void loginTest() throws Exception
	{
		LoginPage lp=new LoginPage(driver);
		lp.set_username(prop.getProperty("userId"));
		lp.set_password(prop.getProperty("password"));
		lp.click_LoginButton();
		String pageTitle=driver.getTitle();
		
		if(pageTitle.equalsIgnoreCase(prop.getProperty("homePageTitle")))
		{
			log.info("loginTest - PASSED");
			Assert.assertTrue(true);
		}
		else
		{
			log.info("loginTest - FAILED");
			captureScreenshot(driver, "loginTest");
			Assert.assertTrue(false);
		}
		
	}

}
