package com.crm.qa.testdata;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase
{
	
LoginPage loginpage;	
HomePage homepage;


	public LoginPageTest()
	{
		super();
	}
	
@BeforeMethod
public void setup()
{
	initialization();
	loginpage=new LoginPage();
}


@Test(priority=1)
public void loginPageTitleTest()
{
	
	String title=loginpage.validatePageTitle();
	Assert.assertEquals(title, "Guru99 Bank Home Page");
}


@Test(priority=2)
public void LoginTest()
{
	homepage=loginpage.login(prop.getProperty("userid"), prop.getProperty("password"));
}


@AfterMethod
public void teardown()
{
	driver.quit();
}
}
