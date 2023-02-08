package com.inetBanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver ldriver;
	
	//Constructor
	public LoginPage(WebDriver rdriver)
	{	
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//Web Elements
	@FindBy (name="uid")
	WebElement txtUserName;
	
	@FindBy (name="password")
	WebElement txtPassword;
	
	@FindBy (name="btnLogin")
	WebElement btnLogin;
	
	@FindBy (xpath="//a[.='Log out']")
	WebElement linkLogout;
	
	//Actions methods
	public void setUserName(String uname)
	{
		txtUserName.sendKeys(uname);
	}
	public void setPassword(String pass)
	{
		txtPassword.sendKeys(pass);
	}
	public void clickSubmit()
	{
		btnLogin.click();
	}
	public void clickLogout()
	{
		linkLogout.click();
	}
	
	
}
