package com.facebook.testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dropdown {

	public static WebDriver driver;
	
	@BeforeMethod
	public void start()
	  {
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  }
	
	@Test
	public void run()
	{
		
		driver.findElement(By.linkText("Create new account")).click();
		
		
		WebElement yeardd= driver.findElement(By.name("birthday_year"));
		Select ydd = new Select(yeardd);
		List <WebElement> options= ydd.getOptions();
		
		for (WebElement totalyrs : options)
		{
			System.out.println(totalyrs.getText());
		}
		
	    WebElement namedd=	driver.findElement(By.name("birthday_day"));
	    Select ndd = new Select(namedd);
	    List<WebElement> days = ndd.getOptions();
		
	    for (WebElement totaldays : days)
		{
			System.out.println(totaldays.getText());
		}
		
		
		
	}
	
	
	
}
