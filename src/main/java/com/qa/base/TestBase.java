package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.util.TestUtil;

public class TestBase {
	
	//defining static variables so that u no need to create object to access it in child classes
	public static WebDriver driver;
	public static Properties prop;
	
	//constructor to configure properties files
	public TestBase() {
		
		InputStream is = null;
		
		try {
			
			prop = new Properties();
			is = new FileInputStream(new File("src\\main\\java\\com\\qa\\config\\config.properties"));
			prop.load(is);
			}catch (FileNotFoundException e) {
				e.printStackTrace();			
			}catch(IOException e) {
				e.printStackTrace();}
		}
	
	public static void initialization() throws InterruptedException 
	{
		String BrowserName=prop.getProperty("browser");
		
		if(BrowserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","src\\test\\resources\\drivers\\chromedriver.exe");	
			driver=new ChromeDriver();
		}
		else if(BrowserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else
		{
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		Thread.sleep(4000);
		
	}
	
	

}
