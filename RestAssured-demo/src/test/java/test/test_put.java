package test;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class test_put {

		@Test
		public void Test_put()
		{
			Map<String,Object> obj =new HashMap<String,Object>();
			obj.put("name", "kirupaa shankar -updated");
			obj.put("job", "QA");
			
			// Use jsonobject class to convert the above map values into json format by adding json.simple dependency 
			JSONObject request =new JSONObject(obj); 
			
			given().
			  header("Content-Type","application/json"). // even if they dont mention header,this header types are basic
			  header("Accept","application/json").
			  body(request.toJSONString()).
			when().
			  put("https://reqres.in/api/users/2").
			then().
			  statusCode(200).
			  log().all();
			
			  
		
			
			  
		}
	}













	
	

