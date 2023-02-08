package com.inetBanking.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.inetBanking.PageObjects.LoginPage;
import com.inetBanking.Utilities.BaseClass;


public class TC_LoginTest_001 extends BaseClass
{
	@Test
	public void loginTest() throws Throwable
	{
		logger.info("Url is opened and APP is launched");
		
		LoginPage login = new LoginPage(driver);
		login.setUserName(USERID);
		
		logger.info("Entered username");
		
		login.setPassword(PASSWORD);
		
		logger.info("Entered password");
		
		login.clickSubmit();
		
		//Validate the homepage title
		if (driver.getTitle().equals("Guru995 Bank Manager Homepage"))
		{
			Assert.assertTrue(true);
			logger.info("Login test is passed"); 
		}
		else
		{
			captureScreenShot(driver, "LoginTest");
			Assert.assertFalse(false);
			logger.info("Login test failed");
		}
	}
	
}
