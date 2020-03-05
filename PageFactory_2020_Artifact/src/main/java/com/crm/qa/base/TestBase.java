package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.crm.qa.util.testUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase()
	{
		try 
		{
			prop=new Properties();
			FileInputStream fi=new FileInputStream("D:\\252805\\_2020_Artifact\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(fi);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

	public static void initialization()
	{
		
		String browsername=prop.getProperty("browser");
		
		if(browsername.equals("ie"))
		{
			String path = System.getProperty("user.dir");
			System.setProperty("webdriver.ie.driver", path+"\\iedriver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		else if(browsername.equals("ChromeBrowser"))
		{
			//String path = System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", "./chromedriver/chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(testUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(testUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
	
	
	
}
