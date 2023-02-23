package Day3;

import org.testng.annotations.Test;
import io.restassured.http.Header;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;



public class headers {

	
	@Test
	public void Headers()  //Mostly Headers value will be constant 
	{
		
		given()
	    
		.when()
		  .get("https://www.google.com/")
		  
		.then()
		  .header("Content-Type", "text/html; charset=ISO-8859-1")
		  .header("Content-Encoding", "gzip")
		  .header("Server","gws");
	}
	
	@Test
	public void getHeaderInfo()   
	{
		
		Response res = given()
	    
		
		.when()
		  .get("https://www.google.com/");
		  
		
// To get single header info 
		//System.out.println(res.getHeader("Content-Type"));
		
//It will give all headers info
		
		io.restassured.http.Headers myheaders = res.getHeaders();
		
		for(Header hd :myheaders) //hd represents single header in the list of headers so its type is header
		{
			System.out.println(hd.getName()+":      "+hd.getValue());
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
