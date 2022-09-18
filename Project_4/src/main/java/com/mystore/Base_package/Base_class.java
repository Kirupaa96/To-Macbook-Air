package com.mystore.Base_package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_class {
	
public static  Properties prop;
public static WebDriver driver;
	
	public void loadconfig()
	{
		try 
		{
		   prop =new Properties();
		   FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\Configuration\\config.properties");
		   prop.load(ip);
		} 
		catch (FileNotFoundException e) 
		{
		   e.printStackTrace();
		}
		catch (IOException e) 
		{
		   e.printStackTrace();
		}
	}
	
	public static void launchapp()
	{
	   String browsername= prop.getProperty("browser");
	   if(browsername.equalsIgnoreCase("chrome"))
	   {
		   WebDriverManager.chromedriver().setup();
		   driver =new ChromeDriver();
	   }
	   else if(browsername.equalsIgnoreCase("firefox"))
	   {
		   WebDriverManager.firefoxdriver().setup();
		   driver =new FirefoxDriver();
	   }
	   else if(browsername.equalsIgnoreCase("edge"))
	   {
		   WebDriverManager.edgedriver().setup();
		   driver = new EdgeDriver();
	   }
		
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   driver.get(prop.getProperty("url"));
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
