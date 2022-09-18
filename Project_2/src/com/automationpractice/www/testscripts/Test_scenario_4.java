package com.automationpractice.www.testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationpractice.www.pages.Sign_in;

import utils.Generic_methods;

public class Test_scenario_4 extends Base{

	@Test
	public void scenario_4() throws IOException
	{
		
	Sign_in obj4 =new Sign_in(driver);
		
	String[][] data=Generic_methods.getData("G:\\D backup\\Software testing\\Course\\Selenium\\Kirupaa_projects\\Shopping_data.xlsx","Invalid_login");
		
	for (int i=1;i<data.length;i++)	
	{
		obj4.signin(data[i][0],data[i][1]);
		String expected_msg = data[i][2];
		String actual_msg = obj4.wrong_cred();
		Assert.assertEquals(expected_msg,actual_msg);
	}
		
	}
	
}
