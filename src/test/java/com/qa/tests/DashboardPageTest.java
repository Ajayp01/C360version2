package com.qa.tests;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;

import com.qa.base.TestBase;
import com.qa.pages.AdminDashboardPage;
import com.qa.pages.DashboardPage;
import com.qa.pages.LoginPage;

public class DashboardPageTest extends TestBase {

	
	LoginPage loginPageObject;
	AdminDashboardPage AdminDashboardPageObj;
	DashboardPage dashboardPageObj;
	
	public DashboardPageTest() {
		super();
	}

	@BeforeMethod
	public void setupt() throws IOException, InterruptedException
	{
		initialization();
		AdminDashboardPageObj=loginPageObject.SignIn(prop.getProperty("username"), prop.getProperty("password"));
		dashboardPageObj=AdminDashboardPageObj.Impersonate();
	}
	
	@Test
	public void dashboardPageTitleTest()
	{
		String currentTitle=dashboardPageObj.dashboardPageTitle();
		Assert.assertEquals(currentTitle, "Collateral360");
	}
	
	@Test
	public void logoTest()
	{
		Assert.assertTrue(dashboardPageObj.logoTest);
	}
	
	
	@Test
	public void clickOnCreateRequestButtonTest()
	{
	
	}

	@AfterMethod
	public void teardown()
	{
		driver.quit();	
	}

}
