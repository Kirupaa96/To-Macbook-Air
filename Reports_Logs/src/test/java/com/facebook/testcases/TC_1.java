package com.facebook.testcases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.facebook.pageObjects.loginPage;
import com.facebook.pageObjects.signupPage;

public class TC_1 extends baseclass{

	
	@Test
	public void newacc()
	{
		loginPage lp = new loginPage(driver);
		signupPage sp = new signupPage(driver);
		
		
		lp.clickCreateACC();
		sp.SignUp();
		
		ExtentTest test =  extent.createTest("Create userAcc"); // create test node in the report 
		test.pass("User Acc Created Successfully");
		
		
		
	}
	
	
	
}
