package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	//page factory OR
	
	@FindBy(name="uid")
	WebElement uid;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="btnLogin")
	WebElement LoginBtn;
	
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validatePageTitle()
	{
		return driver.getTitle();
	}
	
	public HomePage login(String username,String pasd)
	{
		uid.sendKeys(username);
		password.sendKeys(pasd);
		LoginBtn.click();
		
		return new HomePage();
	}
}