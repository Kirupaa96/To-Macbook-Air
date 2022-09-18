package com.automationpractice.www.testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationpractice.www.pages.Placing_order;
import com.automationpractice.www.pages.Sign_in;

import utils.Generic_methods;

public class Test_scenario_8 extends Base {

	@Test
	public void scenario8() throws IOException
	{
		Sign_in object1 =new Sign_in(driver);
		Placing_order object2 =new Placing_order(driver);
		
		String[][] data=Generic_methods.getData("G:\\D backup\\Software testing\\Course\\Selenium\\Kirupaa_projects\\Shopping_data.xlsx","Placing_order");
		
		for(int i=1;i<data.length;i++)
		{
			object1.signin(data[i][0], data[i][1]);
			object2.purchase_prod(driver);
			String act= object2.order_conf();
			String exp=data[i][2];
			Assert.assertEquals(act,exp);
		}
		
		
	}
}
