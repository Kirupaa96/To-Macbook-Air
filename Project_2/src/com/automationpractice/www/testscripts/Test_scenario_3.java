package com.automationpractice.www.testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationpractice.www.pages.Account_creation;
import com.automationpractice.www.pages.Sign_in;

import utils.Generic_methods;

public class Test_scenario_3 extends Base {

	@Test
	public void scenario_3() throws IOException
	{
		Account_creation obj3 =new Account_creation(driver);
		Sign_in obj3_1 =new Sign_in(driver);
		
		
		String[][] data=Generic_methods.getData("G:\\D backup\\Software testing\\Course\\Selenium\\Kirupaa_projects\\Shopping_data.xlsx","Valid_login");
		
		for (int i=1;i<data.length;i++)
		{
			obj3.persnl_info(data[i][0],data[i][2],data[i][3],data[i][4],data[i][5],data[i][6],data[i][7],data[i][10],data[i][11]);
			obj3.code_country(data[i][8],data[i][9]);
			obj3_1.signout();
			
			obj3_1.signin(data[i][0],data[i][4]);
			Assert.assertTrue(obj3_1.chklog_off());
		}
	}
	
}
