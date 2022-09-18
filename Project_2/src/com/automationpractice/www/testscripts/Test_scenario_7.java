package com.automationpractice.www.testscripts;

import java.io.IOException;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationpractice.www.pages.Reviews;
import com.automationpractice.www.pages.Sign_in;

import utils.Generic_methods;

public class Test_scenario_7 extends Base{

	@Test
	public void scenario7() throws IOException
	{
		Sign_in obj8 =new Sign_in(driver);
		Reviews obj9=new Reviews(driver);
		String[][] data=Generic_methods.getData("G:\\D backup\\Software testing\\Course\\Selenium\\Kirupaa_projects\\Shopping_data.xlsx","Review");
		
		for(int i=1;i<data.length;i++)
		{
		  obj8.signin(data[i][0],data[i][1]);
		  obj9.fb_share(driver);
		 
		 // Switching to m/p windows  
		  Set<String> windows= driver.getWindowHandles();
		  Object[] convert_to_array = windows.toArray();
		  driver.switchTo().window(convert_to_array[1].toString());
		  
		  boolean fb= obj9.isFBPageOpen();
		  Assert.assertTrue(fb);
		  driver.close();
		  
		  driver.switchTo().window(convert_to_array[0].toString());
		  
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
