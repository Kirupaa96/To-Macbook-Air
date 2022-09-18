package com.mystore.Page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mystore.Base_package.Base_class;

public class _1_Indexpage extends Base_class {

	@FindBy(xpath="//a[contains(@class,'login')]")
	private WebElement signinbtn;
	
	@FindBy(xpath="//img[contains(@class,'logo img-responsive')]")
	private WebElement logo;
	
	@FindBy(id="search_query_top")
	private WebElement searchbox;
	
	@FindBy(name="submit_search")
	private WebElement searchbtn;
	
	public _1_Indexpage()  // To initialize all the objects 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void click_on_signin()
	{
		signinbtn.click();
	}
	
	public void  validate_logo()
	{
	  boolean a = logo.isDisplayed();
	  Assert.assertTrue(a, "Logo is absent");
	}
	
	public String get_Title()
	{
		String Title =driver.getTitle();
		return Title;
	}
	
	public void search_item(String product)
	{
		searchbox.sendKeys(product);
		searchbtn.click();
	}
	
	
}
