package com.automationpractice.www.testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationpractice.www.pages.Account_creation;

import utils.Generic_methods;

public class Test_scenario_2 extends Base{

	@Test
	 public void scenario2() throws IOException
 {
   Account_creation obj2 =new Account_creation(driver);
  
		
	String[][] data=Generic_methods.getData("G:\\D backup\\Software testing\\Course\\Selenium\\Kirupaa_projects\\Shopping_data.xlsx","Invalid_country");
	
	for (int i=1;i<data.length;i++)
	{
		obj2.persnl_info(data[i][0],data[i][2],data[i][3],data[i][4],data[i][5],data[i][6],data[i][7],data[i][10],data[i][11]);
		obj2.code_country(data[i][8],data[i][9]);
		String expctd_msg =data[i][12];
		String actual_msg= obj2.err_msg();
		Assert.assertEquals(actual_msg,expctd_msg);
	}
 }
	
	@Test
	public void scenario2_1() throws IOException
 {
   Account_creation obj2_1 =new Account_creation(driver);
   String[][] data=Generic_methods.getData("G:\\D backup\\Software testing\\Course\\Selenium\\Kirupaa_projects\\Shopping_data.xlsx","Invalid_zipcode");
			
   for (int i=1;i<data.length;i++)
    {
	  obj2_1.persnl_info(data[i][0],data[i][2],data[i][3],data[i][4],data[i][5],data[i][6],data[i][7],data[i][10],data[i][11]);
	  obj2_1.code_country(data[i][8],data[i][9]);
	  String expctd_msg =data[i][12];
	  String actual_msg= obj2_1.err_msg1();
	  Assert.assertEquals(actual_msg,expctd_msg);
	}
  }
	
}
