package com.facebook.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class signupPage {

	
	@FindBy(name="firstname")
	private WebElement FN;
	
	@FindBy(name="lastname")
	private WebElement LN;
	
	@FindBy(name="reg_email__")
	private WebElement mob;
	
	@FindBy(name="reg_passwd__")
	private WebElement pwd;
	
	@FindBy(name="birthday_month")
	private WebElement month;
	
	@FindBy(name="birthday_day")
	private WebElement day;
	
	@FindBy(name="birthday_year")
	private WebElement year;
	
	@FindBy(xpath="//input[@value='1']")
	private WebElement genderfemale;
	
	@FindBy(xpath="(//input[@type='radio'])[2]")   
	private WebElement gendermale;
	
	@FindBy(name="websubmit")
	private WebElement signup;
	
	
	
	public signupPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}


	public void SignUp()
	{
		FN.sendKeys("Raz");
		LN.sendKeys("SUBH");
		
		mob.sendKeys("9876543210");
		pwd.sendKeys("krazz");
        
		Select monthdd = new Select(month);
		monthdd.selectByValue("5");
		
		Select daydd = new Select(day);
		daydd.selectByValue("19");
		
		Select yeardd = new Select(year);
		yeardd.selectByValue("1996");
		
		gendermale.click();
		
		//signup.click();
		
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
