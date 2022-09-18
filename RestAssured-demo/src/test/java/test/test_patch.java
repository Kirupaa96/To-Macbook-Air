package test;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class test_patch {

		@Test
		public void Test_patch()
		{
			Map<String,Object> obj =new HashMap<String,Object>();
			obj.put("name", "kirupaa shankar A.J -updated patch");
			obj.put("job", "QA");
			
			// Use jsonobject class to convert the above map values into json format by adding json.simple dependency 
			JSONObject request =new JSONObject(obj); 
			
			given().
			  header("Content-Type","application/json"). // even if they dont mention header,this header types are basic
			  header("Accept","application/json").
			  body(request.toJSONString()).
			when().
			  patch("https://reqres.in/api/users/2").
			then().
			  statusCode(200).
			  log().all();
			
			  
		
			
			  
		}
	
}












	
	

