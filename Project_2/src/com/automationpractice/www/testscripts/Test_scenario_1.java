package com.automationpractice.www.testscripts;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationpractice.www.pages.Account_creation;

import utils.Generic_methods;

public class Test_scenario_1 extends Base{

	@Test
	 public void scenario1() throws IOException
  {
    Account_creation obj1 =new Account_creation(driver);
   
		
	String[][] data=Generic_methods.getData("G:\\D backup\\Software testing\\Course\\Selenium\\Kirupaa_projects\\Shopping_data.xlsx","Account_creation");
	
	for (int i=1;i<data.length;i++)
	{
		obj1.persnl_info(data[i][0],data[i][2],data[i][3],data[i][4],data[i][5],data[i][6],data[i][7],data[i][10],data[i][11]);
		obj1.code_country(data[i][8],data[i][9]);
		String expctd_msg =data[i][12];
		String actual_msg= obj1.conf_msg();
		Assert.assertEquals(actual_msg,expctd_msg);
	}
		
		
	  
 }
	
}
