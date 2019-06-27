package com.qa.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.AdminDashboardPage;
import com.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPageObj;
	AdminDashboardPage AdmindashboardPageObj;		
			
			
	public LoginPageTest() throws IOException {
		super();//call to TestBase class constructor to initialize properties variable
	}
	
	
	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
		loginPageObj=new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String currentTitle=loginPageObj.validateLoginPageTitle();
		Assert.assertEquals(currentTitle, "Collateral360");
	}
	
	@Test(priority=2)
	public void signTest() throws IOException, InterruptedException
	{
		AdmindashboardPageObj=loginPageObj.SignIn(prop.getProperty("username"), prop.getProperty("password"));//SignIn method will return DashboardPage object
 	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
		
	}
	

}
