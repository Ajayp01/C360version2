package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;

public class AdminDashboardPage extends TestBase {

	//OR
	
	@FindBy(xpath="//div[@id='userInfo']/button/span")
	WebElement LoggedUser;
	
	
	public AdminDashboardPage() throws IOException{
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoggedUserName()
	{
		return LoggedUser.getText();
	}
	
	public DashboardPage Impersonate() throws IOException
	{
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.titleContains("Collateral360"));
		
		String link="https://preuat.collateral360.com/impersonate.php?aid=";
		link+=prop.getProperty("id");
		driver.navigate().to(link);
		return new DashboardPage();
	}
	
	
	
	
	
	
}
