package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.base.TestBase;

public class DashboardPage extends TestBase {

	//OR
	@FindBy(xpath="//img[@id='imgLogo']")
	WebElement Logo;
	
	public DashboardPage() throws IOException{
		PageFactory.initElements(driver, this);
	}
	
	
	//methods
	public String dashboardPageTitle()
	{
		return driver.getTitle();
	}
	
	public void logoTest()
	{
		Assert.assertTrue(Logo.isDisplayed());
	}
	
	
	
	
	
	
}
