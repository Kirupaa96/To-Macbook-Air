package com.facebook.testcases;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseclass {

	public static WebDriver driver;
	public ExtentReports extent;
	public ExtentSparkReporter spark;
	
	@BeforeClass
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	    extent = new ExtentReports();
		spark = new ExtentSparkReporter("target/Spark.html");
		
        spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("MyReport");
		spark.config().setReportName("Facebook Report");
	    spark.config().getTimeStampFormat();
	    
	    extent.attachReporter(spark);
	   
		
	}
	
	
	@AfterClass
	public void teardown()
	{
		//driver.quit();
		extent.flush();
	}
	
	
	
}
