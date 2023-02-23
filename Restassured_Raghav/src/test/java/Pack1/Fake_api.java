package Pack1;

import org.testng.annotations.Test;    
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import io.restassured.http.ContentType;

public class Fake_api {

	@Test
	public void get_data()
	{
		baseURI = "http://localhost:3000";
		
		given().
		   param("id", 1).  //like a query parameter
	       get("/users").
		then().
		  statusCode(200).
		  log().all();
	}
	
	@Test
	public void post_data()
	{
		JSONObject request = new JSONObject();
		
		request.put("firstName", "Steven");
		request.put("lastName",  "Spielberg");
		request.put("subjectId", 2);
		request.put("id", 4);
		
		baseURI = "http://localhost:3000/";
		
		given().
		  header("Content-Type","application/json").
		  contentType(ContentType.JSON). //what am passing is of json type
		  accept(ContentType.JSON).     //what am accepting is also json type 
		  body(request.toJSONString()).  // it converts into json string 
		when().
		  post("/users").
		then().
		  statusCode(201).
		  log().all();
     }
	
	@Test
	public void patch_data()
	{
		JSONObject request = new JSONObject();
		
		request.put("lastName",  "Kandhasamy");
		
		baseURI = "http://localhost:3000/";
		
		given().
		  header("Content-Type","application/json").
		  contentType(ContentType.JSON). //what am passing is of json type
		  accept(ContentType.JSON).     //what am accepting is also json type 
		  body(request.toJSONString()).  // it converts into json string 
		when().
		  patch("/users/4").
		then().
		  statusCode(200).
		  log().all();
     }
	
	@Test
	public void Put_data()
	{
		JSONObject request = new JSONObject();
		
		request.put("firstName", "george");
		request.put("lastName",  "pillai");
		request.put("subjectId", 2);
		request.put("id", 4);
		
		baseURI = "http://localhost:3000/";
		
		given().
		  header("Content-Type","application/json").
		  contentType(ContentType.JSON). //what am passing is of json type
		  accept(ContentType.JSON).     //what am accepting is also json type 
		  body(request.toJSONString()).  // it converts into json string 
		when().
		  put("/users/4").
		then().
		  statusCode(200).
		  log().all();
     }
	
	@Test
	public void delete_data()
	{
		baseURI = "http://localhost:3000";
		
		when().   
		   delete("/users/4").
		then().
		   statusCode(200). 
		   log().all();
	 }
	
	
	
	
	
	
	
	
	
	
}
