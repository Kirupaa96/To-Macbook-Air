package test;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

public class test_delete {

		@Test
		public void Test_delete()
		{
			String url ="https://reqres.in";
			given().
			  header("Content-Type","application/json"). // even if they dont mention header,this header types are basic
			  header("Accept","application/json").
		   when().
			  delete(url+"/api/users/2").
			then().
			  statusCode(204).
			  log().all();
			
			  
		
			
			  
		}
	}













	
	

