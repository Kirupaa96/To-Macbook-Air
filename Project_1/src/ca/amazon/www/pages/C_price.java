package ca.amazon.www.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class C_price {

	@FindBy(id="price")
	private WebElement price1;
	
	@FindBy(id="price")
	private WebElement price2;
    
	@FindBy(id="price")
	private WebElement price3;
	
	@FindBy(id="price")
	private WebElement price4;
    
	@FindBy(id="price")
	private WebElement price5;
    
    public C_price(WebDriver driver) //constructor 
	{
		PageFactory.initElements(driver,this); 
	}
    
    public String pricemethod()
	{
       String pricefromweb = price1.getText();
	   return pricefromweb;    
    }

}


