package com.mystore.Page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.mystore.Base_package.Base_class;

public class _2_Loginpage extends Base_class{

	@FindBy(id="email")
	private WebElement emailaddress;
	
	@FindBy(id="passwd")
	private WebElement password;
	
	@FindBy(id="SubmitLogin")
	private WebElement signin;
	
	
	@FindBy(id="email_create")
	private WebElement create_acc_email;
	
	@FindBy(id="SubmitCreate")
	private WebElement create_btn;
	
	public _2_Loginpage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void user_login(String uname, String pwd)
	{
		emailaddress.sendKeys(uname);
		password.sendKeys(pwd);
		signin.click();
	}
	
	
	public void create_account(String email)
	{
		create_acc_email.sendKeys(email);
		create_btn.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
