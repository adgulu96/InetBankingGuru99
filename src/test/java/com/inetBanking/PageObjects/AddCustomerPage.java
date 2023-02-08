package com.inetBanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage 
{
	WebDriver ldriver;
	
	//Constructor
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//Webelements
	@FindBy (xpath="//a[.='New Customer']")
	WebElement linkNewCustomer;
	
	@FindBy(name="name")
	WebElement txtCustName;
	
	@FindBy (name="rad1")
	WebElement radGender;
	
	@FindBy (id="dob")
	WebElement txtDob;
	
	@FindBy (name="addr")
	WebElement txfAddress;
	
	@FindBy (name="city")
	WebElement txtCity;
	
	@FindBy (name = "state")
	WebElement txtState;
	
	@FindBy (name = "pinno")
	WebElement txtPinno;

	@FindBy (name="telephoneno")
	WebElement txtPhno;
	
	@FindBy (name = "emailid")
	WebElement txtEmailid;
	
	@FindBy (name = "password")
	WebElement txtPassword;
	
	@FindBy (name = "sub")
	WebElement btnSubmit;
	
	@FindBy (name = "res")
	WebElement btnReset;
	
	//Business logic / action methods
	public void clickNewCust()
	{
		linkNewCustomer.click();
	}
	public void setCustName(String cname)
	{
		txtCustName.sendKeys(cname);
	}
	public void setCustGender(String cgender)
	{
		radGender.click();
	}
	public void setCustDOb(String mm, String dd, String yy)
	{
		txtDob.sendKeys(mm);
		txtDob.sendKeys(dd);
		txtDob.sendKeys(yy);
	}
	public void setAddress(String caddress)
	{
		txfAddress.sendKeys(caddress);
	}
	public void setCustCity(String ccity)
	{
		txtCity.sendKeys(ccity);
	}
	public void setCustState(String cstate)
	{
		txtState.sendKeys(cstate);
	}
	public void setCustPinno(int cpin)
	{
		txtPinno.sendKeys(String.valueOf(cpin));
	}
	public void setCustPhno(String phno)
	{
		txtPhno.sendKeys(phno);
	}
	public void setCustEmail(String cemailid)
	{
		txtEmailid.sendKeys(cemailid);
	}
	public void setCustPass(String pass)
	{
		txtPassword.sendKeys(pass);
	}
	public void clickSubmit()
	{
		btnSubmit.click();
	}
	public void clickReset()
	{
		btnReset.click();
	}
	
	
	
}
