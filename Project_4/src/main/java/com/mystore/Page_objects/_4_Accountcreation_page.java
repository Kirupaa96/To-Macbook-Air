package com.mystore.Page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mystore.Base_package.Base_class;

public class _4_Accountcreation_page extends Base_class{

	
	@FindBy(xpath="//h1[contains(@class,'page-heading')]")
	private WebElement createacc;
	
	public _4_Accountcreation_page()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void validate_accCreate_page()
	{
		boolean c= createacc.isDisplayed();
		Assert.assertTrue(c, "Account creation page is not displayed");
	}
	
	
	
	
	
}
