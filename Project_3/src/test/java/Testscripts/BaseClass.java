package Testscripts;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	WebDriver driver;	
	
	@BeforeTest
	public void openApplication()
	{
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.barenecessities.com/");
	}
	
	@AfterTest
	public void closeApplication()
	{
		driver.quit();
		
	}
	
	
}
