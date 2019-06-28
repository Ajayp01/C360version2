package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;

public class LoginPage extends TestBase{

	//Page Factory - OR - Object Repository
	@FindBy(xpath="//a[@ng-click='openSigninPopup()']")
	WebElement SignInButton;
	
	@FindBy(xpath="//input[@name='username']")
	WebElement Username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement Password;
	
	@FindBy(xpath="//div[@id='loginbtns']/button[@type='submit']")
	WebElement EnterButton;
	
	//Now initialize page objects
	public LoginPage(){
		PageFactory.initElements(driver, this); //Initialize all the current class objects i.e Signbutton,username,pwd with the driver
	}
	
	//Define Actions that user can perform that means different features available on Login page
	
	public String validateLoginPageTitle()
	{		  
		return driver.getTitle();
	}
	
	public AdminDashboardPage SignIn(String uname,String pwd) throws IOException, InterruptedException
	{
		 WebDriverWait wait = new WebDriverWait(driver, 25);
		 wait.until(ExpectedConditions.titleContains("Collateral360"));
		  
		SignInButton.click();
		//Username.clear();
		Username.sendKeys(uname);
		//Password.clear();
		Password.sendKeys(pwd);
		Thread.sleep(2000);
		EnterButton.click();
		Thread.sleep(4000);
		return new AdminDashboardPage();//This method will return the Landing page Objects. landing page of the LoginPage is AdminDashboardPage
	}
	
	

}
