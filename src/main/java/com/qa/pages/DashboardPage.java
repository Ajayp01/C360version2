package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qa.base.TestBase;

public class DashboardPage extends TestBase {

	//OR
	@FindBy(xpath="//img[@id='imgLogo']")
	WebElement logo;
	//By logo=By.xpath("//img[@id='imgLogo']");
	@FindBy(xpath="//a[@data-title='Create New Request']")
	WebElement createRequestButton;
	
	
	
	public DashboardPage() throws IOException{
		PageFactory.initElements(driver, this);
	}
	
	
	//methods
	public String dashboardPageTitle()
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
	    wait.until(ExpectedConditions.titleContains("Collateral360"));
		return driver.getTitle();
	}
	
	public boolean logo() throws InterruptedException
	{
		/*WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.presenceOfElementLocated(logo));*/
		Thread.sleep(10000);
		return logo.isDisplayed();
	}
	
	public boolean clickOnCreateRequestButton()
	{
		return createRequestButton.isDisplayed();
	}
	
	
	
	
	
}
