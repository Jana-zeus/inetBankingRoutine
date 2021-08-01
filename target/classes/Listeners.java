package resources;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import testCases.BaseClass;

public class Listeners implements ITestListener 
{
	public static Logger log=LogManager.getLogger(BaseClass.class);
	ExtentReports extent= EntentReport.extentReportConfig();
	ExtentTest extest;
	
	@Override
	public void onTestStart(ITestResult result) 
	{
		System.out.println("Listener onTestStart");
		extest= extent.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result)
	{	  
		extest.log(Status.PASS, "Test PASSED");
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		extest.log(Status.FAIL, "Test FAILED");
		extest.fail(result.getThrowable());
		
		String Screnshotpath= System.getProperty("user.dir")+"\\Screenshot\\"+result.getName()+".png";
		
				//C:\Users\JANA\eclipse-workspace\inetBanking\Screenshots\login.png
		File f=new File(Screnshotpath);
		if(f.exists())
		{
	     log.error("Screenshot is captured for failed scenario :"+result.getName());
		 extest.fail("Please find attached Screenshot" +extest.addScreenCaptureFromPath(Screnshotpath));
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result)
	{
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
	
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result)
	{
		
	}

	@Override
	public void onStart(ITestContext context) 
	{
		
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		extent.flush();
	}

}
