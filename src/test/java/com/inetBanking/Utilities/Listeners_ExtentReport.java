package com.inetBanking.Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

//Listeners class used to generate the Extent Reports

public class Listeners_ExtentReport extends TestListenerAdapter
{
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	public void onStart(ITestContext testcontext)
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); //TIME STAMP
		String repName = "Test-Report-"+timeStamp+".html";
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/ExtentReports/"+repName);//SPECIFY LOCATION
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		
		extent  = new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environment", "QA_Testing");
		extent.setSystemInfo("User", "Abinash Das");
		
		htmlReporter.config().setDocumentTitle("InetBanking Test Project"); //Title of the report
		htmlReporter.config().setReportName("Functional Test Automation Report"); //Name of the Report
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);//Location of the chart
		htmlReporter.config().setTheme(Theme.DARK);
	}

	@Override
	public void onTestSuccess(ITestResult tr) 
	{
		logger = extent.createTest(tr.getName()); //Create new entry in the report
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));//Send the pass information
	}

	@Override
	public void onTestFailure(ITestResult tr) 
	{
		logger = extent.createTest(tr.getName());//Create new entry in the report
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		
		String ScreenShotPath = System.getProperty("user.dir")+"\\ScreenShots\\"+tr.getName()+".png";
		
		File fis = new File(ScreenShotPath);
		
		if (fis.exists())
		{
			try 
			{
				logger.fail("ScreenShot is below"+logger.addScreenCaptureFromPath(ScreenShotPath));
				
			} catch (Exception e) 
			{	
				e.printStackTrace();
			}
		}
	}

	@Override
	public void onTestSkipped(ITestResult tr)
	{
		logger = extent.createTest(tr.getName());
		logger.log(Status.SKIP , MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}

	@Override
	public void onFinish(ITestContext testContext) 
	{
		extent.flush();
	}
}
