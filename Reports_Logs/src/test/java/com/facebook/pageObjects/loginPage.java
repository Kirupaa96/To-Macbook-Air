package com.facebook.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {

	
	
	@FindBy(linkText="Create new account")
	private WebElement crAcc;
	
	
	public loginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}


	public void clickCreateACC()
	{
		crAcc.click();
	}
	
	
	
	
	
	
	
	
	
	
	
}
