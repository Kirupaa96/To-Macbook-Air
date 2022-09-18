package ca.amazon.www.testscripts;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Base {
	
	WebDriver driver;
	
	@BeforeClass
	public void OpenApplication()
	{
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get("https://www.amazon.ca/");
	}
	
	
	
	@AfterClass
	public void CloseApplication()
	{
		driver.close();
	}

}
