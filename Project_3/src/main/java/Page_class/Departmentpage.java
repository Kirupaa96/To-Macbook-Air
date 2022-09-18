package Page_class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Departmentpage {

	@FindBy(xpath="(//a[contains(@class,'filter-group-button')])[1]")
	private WebElement b1;
	
	@FindBy(xpath="(//a[contains(@class,'filter_anchor reviews')])[20]")
	private WebElement b2;
	
	
	public Departmentpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void secondpage()
	{
		b1.click();
		b2.click();
		
	}
	
	
	
	
	
	
}
