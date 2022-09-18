package ca.amazon.www.testscripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import ca.amazon.www.pages.A_home;
import ca.amazon.www.pages.B_results;
import ca.amazon.www.pages.C_price;
import utils.GenericMethods;

public class price_verification extends Base{


	@Test
	 public void verifyprodprice() throws Exception 
	 {
		A_home obj1 =new A_home(driver);
		B_results obj2 =new B_results(driver);
		C_price obj3 =new C_price(driver);
		
		GenericMethods obj4 =new GenericMethods();
		String filePath ="G:\\\\D backup\\\\Software testing\\\\Course\\\\Selenium\\\\Kirupaa_projects\\\\Amazon_data.xlsx";
		String sheetName ="Sheet1";
		
		
		 String[][] data =GenericMethods.getData(filePath,sheetName);
		 System.out.println(data.length);
		 for (int i=1;i<data.length;i++)
		 {
			System.out.println("=====================");
			System.out.println(data[i][1]);
			obj1.homemethod(data[i][1]);
			obj2.resultsmethod();
			
		    String amazon_price = obj3.pricemethod();
		    obj4.writeToExcel(filePath, sheetName, i, 3, amazon_price );
		    String excel_price = data[i][2];
		
		    if(amazon_price.equals(excel_price))
		     {
			   obj4.writeToExcel(filePath, sheetName, i, 4, "PASS");
		     }
		    else 
		     {
			   obj4.writeToExcel(filePath, sheetName, i, 4, "FAIL");
		     }
		    
		    driver.findElement(By.id("nav-logo-sprites")).click();
		    
		   }
		
		 }
       }
  