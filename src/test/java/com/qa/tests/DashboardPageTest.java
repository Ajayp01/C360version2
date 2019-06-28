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

public class DashboardPageTest extends TestBase {

	
	 LoginPage loginPageObj;
	 AdminDashboardPage adminDashboardPageObj;
	 DashboardPage dashboardPageObj;
	
	public DashboardPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws IOException, InterruptedException
	{
		initialization();
		loginPageObj=new LoginPage();
		adminDashboardPageObj=loginPageObj.SignIn(prop.getProperty("username"), prop.getProperty("password"));
		dashboardPageObj=adminDashboardPageObj.Impersonate();
	}
	
	@Test(priority=1)
	public void dashboardPageTitleTest()
	{
		String currentTitle=dashboardPageObj.dashboardPageTitle();
		Assert.assertEquals(currentTitle, "Collateral360");
	}
	
	@Test(priority=2)
	public void logoTest() throws InterruptedException
	{
		boolean currentLogo=dashboardPageObj.logo();
		Assert.assertTrue(currentLogo, "Logo not displayed");
	}
	
	
	@Test(priority=3)
	public void clickOnCreateRequestButtonTest()
	{
		boolean IsButtonAvailable=dashboardPageObj.clickOnCreateRequestButton();
		Assert.assertTrue(IsButtonAvailable, "Create Request Button is not available");
	}

	@AfterMethod
	public void teardown(ITestResult result)
	{
		System.out.println("Passed  " + result.getMethod().getMethodName());
		driver.quit();
	}
}
