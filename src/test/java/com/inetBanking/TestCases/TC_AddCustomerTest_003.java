package com.inetBanking.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.inetBanking.PageObjects.AddCustomerPage;
import com.inetBanking.PageObjects.LoginPage;
import com.inetBanking.Utilities.BaseClass;

public class TC_AddCustomerTest_003 extends BaseClass
{
	@Test
	public void addNewCustomer() throws Throwable
	{
		LoginPage login = new LoginPage(driver);
		login.setUserName(USERID);
		logger.info("Username is provided");
		login.setPassword(PASSWORD);
		logger.info("Password is provided");
		login.clickSubmit();
		
		Thread.sleep(3000);
		logger.info("Validation is started");
		
		AddCustomerPage cust = new AddCustomerPage(driver);
		logger.info("Providing the Customer details");
		cust.clickNewCust();
		cust.setCustName("Abiansh Das");
		cust.setCustGender("male");
		cust.setCustDOb("9", "10", "1996");
		cust.setAddress("patrapada");
		cust.setCustCity("BBSR");
		cust.setCustState("Odisha");
		cust.setCustPinno(751019);
		cust.setCustPhno("8956234565");
		
		//Passing random string fromt our user-defined method
		String email = randomString()+"@gmail.com";
		cust.setCustEmail(email);
		
		cust.setCustPass(PASSWORD);
		cust.clickSubmit();
		
		Thread.sleep(3000);
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!"); 
		if (res=true)
		{
			logger.info("AddCustomer Testcase is Passed");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("Addcustomer TestCases is failed");
			captureScreenShot(driver, "addNewCustomer");
			Assert.assertFalse(false);
		}
		
	}
	

}
