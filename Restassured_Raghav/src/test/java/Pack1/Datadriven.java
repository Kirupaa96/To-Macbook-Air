package Pack1;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

public class Datadriven extends Test_Data{

	@Test(dataProvider= "Post_data")
	public void post(String FN, String LN, int Sub_id)
	{
        JSONObject request = new JSONObject();
		
		request.put("firstName", FN);
		request.put("lastName",  LN);
		request.put("subjectId", Sub_id);
		
		
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
	
	 
		  
    @Test(dataProvider ="Delete_data")
	public void delete_data(int id)
	{
	   baseURI = "http://localhost:3000";
				
	   when().   
		 delete("/users/"+id).
	   then().
		 statusCode(200). 
		 log().all();
	}     
		 
	  
		  
		  
	 

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
