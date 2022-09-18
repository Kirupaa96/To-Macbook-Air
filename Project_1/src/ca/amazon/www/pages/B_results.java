package ca.amazon.www.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class B_results {
	
    @FindBy(xpath="(//img[contains(@class,'s-image')])[1]")
    private WebElement prod;
    
    @FindBy(xpath="(//img[contains(@class,'s-image')])[1]")
    private WebElement prod2;
    
    @FindBy(xpath="(//img[contains(@class,'s-image')])[1]")
    private WebElement prod3;
    
    @FindBy(xpath="(//img[contains(@class,'s-image')])[1]")
    private WebElement prod4;
    
    @FindBy(xpath="(//img[contains(@class,'s-image')])[1]")
    private WebElement prod5;
//    
    public B_results(WebDriver driver) //constructor 
	{
		PageFactory.initElements(driver,this); 
	}
    
    public void resultsmethod()
	{
    	
      prod.click();
      
	}
}

