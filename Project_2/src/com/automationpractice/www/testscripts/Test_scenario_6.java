package com.automationpractice.www.testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationpractice.www.pages.Reviews;
import com.automationpractice.www.pages.Sign_in;

import utils.Generic_methods;

public class Test_scenario_6 extends Base{

	@Test
	public void scenario6() throws IOException
	{
		Sign_in obj6 =new Sign_in(driver);
		Reviews obj7=new Reviews(driver);
		String[][] data=Generic_methods.getData("G:\\D backup\\Software testing\\Course\\Selenium\\Kirupaa_projects\\Shopping_data.xlsx","Review");		
		
		for(int i=1;i<data.length;i++)
		{
			obj6.signin(data[i][0], data[i][1]);
			obj7.pro_review(data[i][2], data[i][3], driver);
			
			String expected_msg = data[i][4];
			String actual_msg = obj7.conf_msg();
			Assert.assertEquals(actual_msg,expected_msg);
		}
		
	}
	
}
