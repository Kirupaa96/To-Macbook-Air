package Page_class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

	@FindBy(linkText="BRANDS")
	private WebElement a1;
	
	@FindBy(xpath="//div[contains(@class,'active-filters eneTitle')]")
	private WebElement a2;
	
	public Homepage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void Firstpage()
	{
		a1.click();
		a2.isDisplayed();
	}
	
	
	
	
	
	
	
	
	
	
}
