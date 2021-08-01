package testCases;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseClass 
{
	public static WebDriver driver;
	public static Properties prop;
	
	public static Logger log=LogManager.getLogger(BaseClass.class);

	@BeforeClass
	public void setup() throws Exception
	{
		prop=new Properties();
		FileInputStream fis=new FileInputStream(".\\src\\test\\java\\resources\\data.properties");
		prop.load(fis);
		
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(prop.getProperty("url"));
		log.info("Test Started");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}
	
	@AfterClass
	public void teardown() throws Exception
	{
		Thread.sleep(2000);
		log.info("Test Completed");
		log.info("*************************************");
		driver.quit();	
	}
	
	public static void captureScreenshot(WebDriver driver, String tname ) throws Exception
	{
		
		TakesScreenshot ts= (TakesScreenshot)driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		File targer= new File(System.getProperty("user.dir")+"//Screenshot//"+tname+".png");
		FileUtils.copyFile(src, targer);
		
	}
}
