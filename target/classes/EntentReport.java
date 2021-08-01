package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class EntentReport 
{
	public static ExtentReports extent;
	public static ExtentSparkReporter reporter;
	
	public static ExtentReports extentReportConfig()
	{
		//ExtentsReport   //ExtentSparkReporter
		
		
		String path= ".//Reports//index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("ExtentReport_E2E");
		reporter.config().setReportName("inetBankingRoutine_Report");
		reporter.config().setTheme(Theme.DARK);
		
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		return extent;
	}

}
