package com.automationpractice.www.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Reviews {

	@FindBy(linkText="T-SHIRTS")
	private WebElement r1;
	
	@FindBy(css="#center_column > ul > li > div > div.left-block > div > a.product_img_link > img")
	private WebElement r2;
	
	@FindBy(css="#product_comments_block_extra > ul > li")
	private WebElement r3;
	
	@FindBy(id="comment_title")
	private WebElement r4;
	
	@FindBy(id="content")
	private WebElement r5;
	
	@FindBy(css="#submitNewMessage > span")
	private WebElement r6;
	
	@FindBy(css="#product > div.fancybox-wrap.fancybox-desktop.fancybox-type-html.fancybox-opened > div > div > div > p:nth-child(2)")
	private WebElement r7;
	
	@FindBy(css="#product > div.fancybox-wrap.fancybox-desktop.fancybox-type-html.fancybox-opened > div > div > div > p.submit > button > span")
	private WebElement r8;
	
	@FindBy(css="#center_column > ul > li > div > div.right-block > div.button-container > a.button.lnk_view.btn.btn-default > span")
	private WebElement more;
	
	@FindBy(xpath="(//button[contains(@type,'button')])[2]")
	private WebElement fshare;
	
	@FindBy(css="#center_column > div > div > div.pb-center-column.col-xs-12.col-sm-4 > h1") //faded tshirts
	private WebElement r9;  
	
	@FindBy(css="#homelink") //fbpage
	private WebElement fbPage;
	
	public Reviews(WebDriver driver) //constructor 
	{
		PageFactory.initElements(driver,this); 
	}
	
	
	public void pro_review(String title, String comment,WebDriver driver)
	{
		r1.click();
		//r2.click();
		
		Actions hover =new Actions(driver);
		hover.moveToElement(r2).perform();
		
		more.click();
		r3.click();
		r4.sendKeys(title);
		r5.sendKeys(comment);
		r6.click();
	}	
	
	public String conf_msg()
	  {
	    String msg4= r7.getText();
	    r8.click();
		return msg4;
	  }
	
	public void fb_share(WebDriver driver)
	{
		r1.click();
		Actions hover =new Actions(driver);
		hover.moveToElement(r2).perform();
		more.click();
		fshare.click();
	}
	
	
	public boolean isFBPageOpen()
	{
		return fbPage.isDisplayed();
	}
	
	
	
	
	
	
	
	
}
