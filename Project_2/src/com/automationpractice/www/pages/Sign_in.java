package com.automationpractice.www.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Sign_in {
	
	@FindBy(linkText="Sign in")
    private WebElement s1;
	
	@FindBy(id="email")
	private WebElement a1;
	
	@FindBy(id="passwd")
	private WebElement a2;
	
	@FindBy(css="#SubmitLogin > span")
	private WebElement a3;
	
	@FindBy(linkText="Sign out")
	private WebElement a4;
	
	@FindBy(css="#center_column > div.alert.alert-danger > ol > li")
	private WebElement a5;
	
	
	public Sign_in(WebDriver driver) //constructor 
	{
		PageFactory.initElements(driver,this); 
	}
	
	public void signin(String id, String pwd)
	{
		s1.click();
		a1.sendKeys(id);
		a2.sendKeys(pwd);
		a3.click();
	}
	
	public void signout()
	{
		a4.click();
	}
	
	public boolean chklog_off()
	{
		return a4.isDisplayed();
	}
	
	public String wrong_cred()
	{
	   String msg3= a5.getText();
	   return msg3;	
	}
	
}
