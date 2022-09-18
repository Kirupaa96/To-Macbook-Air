package ca.amazon.www.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class A_home {
	
	@FindBy(id="twotabsearchtextbox")
	private WebElement searchbox;
	
	@FindBy(id="nav-search-submit-button")
	private WebElement searchbtn;
	
	public A_home(WebDriver driver) //constructor 
	{
		PageFactory.initElements(driver,this); 
	}
	
	public void homemethod(String prod_id)
	{
		searchbox.sendKeys(prod_id);
		searchbtn.click();
	}
	
	
	
	
	
	

}
