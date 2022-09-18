package test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.* ;


import java.util.HashMap;
import java.util.Map;

public class test_post {

	@Test
	public void Test_post()
	{
		Map<String,Object> obj =new HashMap<String,Object>();
		obj.put("name", "kirupaa");
		obj.put("job", "QA");
		
		// Use jsonobject class to convert the above map values into json format by adding json.simple dependency 
		JSONObject request =new JSONObject(obj); 
		System.out.println("Map values are "+request);
		System.out.println("Map values are "+request.toJSONString()); // to print into json format 
		
		given().
		  header("Content-Type","application/json"). // even if they dont mention header,this header types are basic
		  header("Accept","application/json").
		  body(request.toJSONString()).
		when().
		  post("https://reqres.in/api/users").
		then().
		  statusCode(201).
		  log().all();
		
		  
		
		  
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
