package test;

import org.testng.Assert;
import org.testng.annotations.Test;
// import io.restassured.RestAssured;
import static io.restassured.RestAssured.* ;
import io.restassured.response.Response;

public class example {

	
	@Test                              // Java code 
	public void test1()
	{
	   // Response obj= RestAssured.get("https://restful-booker.herokuapp.com/booking"); 
	   
	   Response obj= get("https://restful-booker.herokuapp.com/booking");
	   System.out.println("Status code is "+ obj.getStatusCode());  //returns the status code
	   System.out.println("Response body received is "+ obj.getBody().asString()); // returns the body as string type- u can use pretty string  
	   System.out.println("Headers are "+ obj.headers()); // returns all headers 
	   System.out.println("Content type is "+ obj.getHeader("content-type")); // returns the content type  header 
	   System.out.println("Response time is "+ obj.getTime());
	   
	   int statuscode = obj.getStatusCode();
	   Assert.assertEquals(statuscode, 200);
	  }
	
	
	 @Test                                //BDD code 
	 public void test2()
	 {
		 baseURI="https://restful-booker.herokuapp.com";
		 given().
		   get("/booking").
		 then().
		   statusCode(200);
		   
	 }
	
	
	
	
	
	
	
	 
	 
	 
	 
	 
	 
	 
	 
}



