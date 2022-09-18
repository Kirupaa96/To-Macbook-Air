package com.automationpractice.www.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.automationpractice.www.pages.Sign_in;

import utils.Generic_methods;

public class Test_scenario_5 extends Base{

	@Test
	public void scenario5() throws IOException
{
 Sign_in obj5=new Sign_in(driver);
		
 String[][] data=Generic_methods.getData("G:\\D backup\\Software testing\\Course\\Selenium\\Kirupaa_projects\\Shopping_data.xlsx","Log_off");
		
 for (int i=1;i<data.length;i++)
 {
   obj5.signin(data[i][0],data[i][1]);
   obj5.signout();
   
 }		
}
}
