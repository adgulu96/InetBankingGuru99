package com.inetBanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig
{
	Properties pro;
//Constructor
	public ReadConfig() 
	{	
		File src = new File("./Configuration/config.properties");
		
		try
		{
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}
		catch (Exception e) 
		{
			System.out.println("Exception is :: "+e.getMessage());
		}
	}
	public String getApplicationURL()
	{
		String URL = pro.getProperty("BASE_URL");
		return URL;
	}
	public String getUserName()
	{
		String USERNAME = pro.getProperty("USER_ID");
		return USERNAME;
	}
	public String getPassword()
	{
		String pass = pro.getProperty("PASSWORD");
		return pass;
	}
	public String getChromePath()
	{
		String chromepath = pro.getProperty("CHROME_PATH");
		return chromepath;
	}
	public String getIEedgePath()
	{
		String iepath = pro.getProperty("IEEDGE_PATH");
		return iepath;
	}
	public String getFirefoxPath()
	{
		String firefox = pro.getProperty("FIREFOX_PATH");
		return firefox;
	}
}
