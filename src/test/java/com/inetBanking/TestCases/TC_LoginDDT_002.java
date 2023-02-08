package com.inetBanking.TestCases;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.inetBanking.PageObjects.LoginPage;
import com.inetBanking.Utilities.BaseClass;
import com.inetBanking.Utilities.Excel_Utility;

public class TC_LoginDDT_002 extends BaseClass
{
	@Test (dataProvider = "LoginData")
	public void loginDDT(String user, String pass) throws Throwable
	{
		LoginPage login = new LoginPage(driver);
		login.setUserName(user);
		logger.info("Username is provided");
		login.setPassword(pass);
		logger.info("Password is provided");
		login.clickSubmit();
		
		Thread.sleep(3000);
		
		if (isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login passed");
			login.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept(); //close the logout alert
			driver.switchTo().defaultContent();
			
		}
		
	}
	public boolean isAlertPresent() //User-defined method created to check whether the alert is present or not
	{
		try 
		{
			driver.switchTo().alert();
			return true;
		}
		catch (NoAlertPresentException e) 
		{
			return false;
		}
	}
	
	@DataProvider(name = "LoginData")
	public String[][] getData() throws Throwable
	{
		String path = System.getProperty("user.dir")+"/src/test/java/com/inetBanking/TestData/LoginData.xlsx";
		
		int rownum = Excel_Utility.getRowCount(path, "Sheet1");
		int colcount = Excel_Utility.getCellCount(path, "Sheet1", 1);
		
		String logindata[][] = new String[rownum][colcount];
		
		for (int i=1; i<=rownum; i++)
		{
			for (int j=0; j<colcount; j++)
			{
				logindata[i-1][j]=Excel_Utility.getCellData(path, "Sheet1", i, j);// 1 0
			}
		}
		return logindata;
	}
}
