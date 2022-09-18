package com.mystore.Page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mystore.Base_package.Base_class;

public class _3_Homepage extends Base_class{

	@FindBy(xpath="//span[contains(@class,'navigation_page')]")
	private WebElement Myaccount;
	
	public _3_Homepage()
	{
		PageFactory.initElements(driver, this);
	}
		
	
	public void Homepage_verification()
	{
		boolean b= Myaccount.isDisplayed();
		Assert.assertTrue(b, "Home page is not Displayed");
	}
	
	
	
	
	
}
