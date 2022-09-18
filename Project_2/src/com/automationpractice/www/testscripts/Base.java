package com.automationpractice.www.testscripts;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



public class Base {

	WebDriver driver;
	
	@BeforeClass
	@Parameters("browser")
	
	 public void openApplication(String browser)
	 {
		if(browser.equals("chrome"))
		{
		   System.setProperty("WebDriver.Chrome.driver","chromedriver.exe");
	       driver =new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			System.setProperty("WebDriver.gecko.driver","geckodriver.exe");
		    driver =new FirefoxDriver();
		}
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.get("http://automationpractice.com/index.php?");
	 }
	
	
	
	@AfterClass
	public void cloaseApplication()
	{
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
