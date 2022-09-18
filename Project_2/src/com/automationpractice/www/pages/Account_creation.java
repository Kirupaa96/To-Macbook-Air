package com.automationpractice.www.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Account_creation {
	
	@FindBy(linkText="Sign in")
	private WebElement a;

	@FindBy(id="email_create")
	private WebElement b;
	
	@FindBy(css="#SubmitCreate > span")
	private WebElement b1;
	
	@FindBy(id="id_gender1")
	private WebElement c;
	
	@FindBy(id="customer_firstname")
	private WebElement d;
	
	@FindBy(id="customer_lastname")
	private WebElement e;
	
	//@FindBy(id="email")
	//private WebElement f;
	
	@FindBy(id="passwd")
	private WebElement g;
	
	@FindBy(id="firstname")
	private WebElement h;
	
	@FindBy(id="lastname")
	private WebElement i;
	
	@FindBy(id="address1")
	private WebElement j;
	
	@FindBy(id="city")
	private WebElement k;
	
	@FindBy(id="id_state")
	private WebElement l;
	
	@FindBy(id="postcode")
	private WebElement m;
	
	@FindBy(id="id_country")
	private WebElement n;
	
	@FindBy(id="phone_mobile")
	private WebElement o;
	
	@FindBy(id="alias")
	private WebElement p;
	
	@FindBy(css="#submitAccount > span")    
	private WebElement q;
	
	@FindBy(css="#center_column > p")
	private WebElement r;
	
	@FindBy(css="#center_column > div > ol > li:nth-child(3)")
	private WebElement err;
	
	@FindBy(css="#center_column > div > ol > li:nth-child(1)")
	private WebElement err1;
	
	
	public Account_creation(WebDriver driver) //constructor 
	{
		PageFactory.initElements(driver,this); 
	}
	
	
	public void persnl_info(String email_id, String f_name, String l_name, String pswd, 
			            String address, String city, String state,
			            String phno, String alt_id)
	{
		
		//JavascriptExecutor js =(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].scrollIntoview();",g);
		
		a.click();
		b.sendKeys(email_id);
		b1.click();
		c.click();
		d.sendKeys(f_name);
		e.sendKeys(l_name);
		g.sendKeys(pswd);
		h.sendKeys(f_name);
		i.sendKeys(l_name);
		j.sendKeys(address);
		k.sendKeys(city);
		Select obj_s =new Select(l);
		obj_s.selectByVisibleText(state);
		o.sendKeys(phno);
		p.sendKeys(alt_id);
	}
	
	public void code_country(String code,String country)
	{
		
		m.sendKeys(code);
		
		Select obj_c =new Select(n);
		obj_c.selectByVisibleText(country);
		
		q.click();
		
	}
	
	public String conf_msg()
	  {
		String msg =r.getText();
		return msg;
	  }
	
	public String err_msg()
	{
		String msg1=err.getText();
		return msg1;
	}
	
	public String err_msg1()
	{
		String msg2=err1.getText();
		return msg2;		
	}
	
	
	
	
	
	
}
