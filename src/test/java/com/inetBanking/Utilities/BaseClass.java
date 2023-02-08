package com.inetBanking.Utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class BaseClass 
{
	ReadConfig config = new ReadConfig();
	
	public String BASEURL = config.getApplicationURL();
	public String USERID = config.getUserName();
	public String PASSWORD = config.getPassword();
	public static WebDriver driver;
	
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver" , config.getChromePath());
			driver = new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver" , config.getFirefoxPath());
			driver= new FirefoxDriver();
		}
		else if(br.equals("edge"))
		{
			System.setProperty("webdriver.msedge.driver" , config.getIEedgePath());
			driver= new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get(BASEURL);
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	public void captureScreenShot(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File(System.getProperty("user.dir")+"/ScreenShots/"+tname+".png");
		FileUtils.copyFile(srcFile, destFile);
		System.out.println("Screen Shot is Taken of Failed TestCase");
	}
	public String randomString()
	{
		String generatedString =RandomStringUtils.randomAlphabetic(8);
		return (generatedString);
	}
	public static String randomNumber()
	{
		String generatedNum = RandomStringUtils.randomNumeric(4);
		return generatedNum;
	}
}
