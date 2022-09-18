package Testscripts;

import org.testng.annotations.Test;

import Page_class.Departmentpage;
import Page_class.Homepage;

public class Smoke_test extends BaseClass{

	
	@Test
	public void TC1()
	{
		Homepage obj1 =new Homepage(driver);
		obj1.Firstpage();
	}
	
	@Test
	public void TC2()
	{
		Departmentpage obj2 =new Departmentpage(driver);
		obj2.secondpage();
	}
	
	
}
