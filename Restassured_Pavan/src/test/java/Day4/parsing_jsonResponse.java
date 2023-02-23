package Day4;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


import org.json.JSONObject;


public class parsing_jsonResponse {

	
	
	@Test
	public void JsonResponse1()
	{   
		//Aproach 1 for response body validation
		
	    given()
	     .contentType(ContentType.JSON)
	    
	    .when()
	      .get("http://localhost:3000/store")
	    
	    .then()
	      .statusCode(200)
	      .header("Content-Type","application/json; charset=utf-8") //header validation
	      .body("book[0].title", equalTo("Sayings of the century")) //res body validation(use jsonpathfinder to find json path)
	      .log().all();
	 }
	
	
	@Test
	public void JsonResponse2()
	{   
		//Aproach 2 for response body validation
		
	   Response res = given()
	     .contentType(ContentType.JSON)
	    
	    .when()
	      .get("http://localhost:3000/store");
	    
	    Assert.assertEquals(res.getStatusCode(),200);
	    Assert.assertEquals(res.header("Content-Type"), "application/json; charset=utf-8");
	    
	    String Actualvalue =res.jsonPath().get("book[0].title").toString();
	    Assert.assertEquals(Actualvalue, "Sayings of the century");
	 
	 }
	
	
	@Test
	public void JsonResponse3()
	{   
		//Aproach 3 for response body validation
		//we are trying to read all the titles in book array 
		
	   Response res = given()
	     .contentType(ContentType.JSON)
	    
	    .when()
	      .get("http://localhost:3000/store");
	    
	  JSONObject jo = new JSONObject(res.asString()); //converting res to json object type 
	   
	  
//1.Validation for presence of book title 
	    
	    boolean status =false;
	    for(int i=0; i<jo.getJSONArray("book").length(); i++) //jo represents entire json response
	    {
	    	String bookTitle= jo.getJSONArray("book").getJSONObject(i).get("title").toString();
	    	//System.out.println(bookTitle);
	    	
	    	if(bookTitle.equals("Sayings of the century"))
	    	{
	    		status= true;
	    		break;
	    	}
	    }
	    Assert.assertEquals(status, true); 
	   

//2.Validation for comparing total price of all books with expected price 
	      
	    
	    double totalPrice =0;
	    for(int i=0; i<jo.getJSONArray("book").length(); i++) //jo represents entire json response
	    {
	    	String price= jo.getJSONArray("book").getJSONObject(i).get("price").toString();
	        totalPrice =totalPrice + Double.parseDouble(price); 
	    }
	      
	    Assert.assertEquals(526,totalPrice); 
	      
	      
	  }
	
	     

	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
}
