package com.qa.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.AdminDashboardPage;
import com.qa.pages.DashboardPage;
import com.qa.pages.LoginPage;

public class AdminDashboardPageTest extends TestBase{

	 AdminDashboardPage adminDashboardPageObj;
	 DashboardPage dashboardPageObj;
	 LoginPage loginPageObj;
	
	public AdminDashboardPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException
	{
		initialization();
		loginPageObj=new LoginPage();
	    adminDashboardPageObj=loginPageObj.SignIn(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void loggedUserNameTest()
	{
		String UserName=adminDashboardPageObj.validateLoggedUserName();
		Assert.assertEquals(UserName, "AJAY", "User name did not match");
	}
	
	@Test(priority=2)
	public void impersonateTest() throws IOException, InterruptedException
	{
		dashboardPageObj=adminDashboardPageObj.Impersonate();
	} 
	
	@AfterMethod
	public void teardown(ITestResult result)
	{
		System.out.println("Passed  " + result.getMethod().getMethodName());
		driver.quit();
	}
	
	
	
	
	
	
	
}
