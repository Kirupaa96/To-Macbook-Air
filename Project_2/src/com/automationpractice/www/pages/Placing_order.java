package com.automationpractice.www.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Placing_order {

	@FindBy(css="#block_top_menu > ul > li:nth-child(2) > a")
	private WebElement dresses;
	
	@FindBy(css="#block_top_menu > ul > li:nth-child(2) > ul > li:nth-child(1) > a")
	private WebElement casual;
	
	@FindBy(css="#block_top_menu > ul > li:nth-child(2) > ul > li:nth-child(2) > a")
	private WebElement evening;
	
	@FindBy(css="#block_top_menu > ul > li:nth-child(2) > ul > li:nth-child(3) > a")
	private WebElement summer;
	
	@FindBy(css="#center_column > ul > li > div > div.right-block > div.button-container > a.button.ajax_add_to_cart_button.btn.btn-default > span")
	private WebElement cart1;
	
	@FindBy(css="#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > span > span")
	private WebElement ctn1;
	
	@FindBy(css="#center_column > ul > li > div > div.right-block > div.button-container > a.button.ajax_add_to_cart_button.btn.btn-default > span")
	private WebElement cart2;
	
	@FindBy(css="#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > span > span")
	private WebElement ctn2;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/ul/li[2]/div/div[2]/div[2]/a[1]/span")
	private WebElement cart3;
	
	@FindBy(css="#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a > span")
	private WebElement chkout;
	
	@FindBy(css="#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium > span")
	private WebElement chk_ctn;
	
	@FindBy(css="#center_column > form > p > button > span")
	private WebElement chk_ctn1;
	
	@FindBy(id="cgv")
	private WebElement chk_box;
	
	@FindBy(css="#form > p > button > span")
	private WebElement chk_ctn2;                       
	
	@FindBy(xpath="//a[contains(@class,'bankwire')]")
	private WebElement pay;       
	
	@FindBy(css="#cart_navigation > button > span")
	private WebElement confirm;
	
	@FindBy(css="#center_column > div > p > strong")
	private WebElement complete;
	
	public Placing_order(WebDriver driver) //constructor 
	{
		PageFactory.initElements(driver,this); 
	}
	
	@FindBy(xpath="(//img[contains(@class,'replace-2x img-responsive')])[2]")  
	private WebElement image1;
	
	@FindBy(xpath="(//img[contains(@class,'replace-2x img-responsive')])[2]")
	private WebElement image2;
	
	@FindBy(xpath="(//img[contains(@class,'replace-2x img-responsive')])[3]")
	private WebElement image3;
	
	
	public void purchase_prod(WebDriver driver)
	{
	  Actions m_hover =new Actions(driver);
	  m_hover.moveToElement(dresses).perform();
	  casual.click();
	  
	  JavascriptExecutor js =(JavascriptExecutor)driver;
	  js.executeScript("arguments[0].scrollIntoview();",image1);
	  m_hover.moveToElement(image1).perform();
	  cart1.click();
	  ctn1.click();
	  
	  m_hover.moveToElement(dresses).perform();
	  evening.click();
	  
	  js.executeScript("arguments[0].scrollIntoview();",image2);
	  m_hover.moveToElement(image2).perform();
	  cart2.click();	
	  ctn2.click();	
		
	  m_hover.moveToElement(dresses).perform();	
	  summer.click();
	  
	  js.executeScript("arguments[0].scrollIntoview();",image3);
	  m_hover.moveToElement(image3).perform();
	  cart3.click();
	  chkout.click();
	  
	  chk_ctn.click();
	  chk_ctn1.click();
	  
	  boolean box= chk_box.isSelected();
	  if(box==false)
	  {
		chk_box.click();
	  }
	  chk_ctn2.click();
	  pay.click();
	  confirm.click();
	}
	
	public String order_conf()
	{
	  String actual= complete.getText();
	  return actual;
	}	











}

