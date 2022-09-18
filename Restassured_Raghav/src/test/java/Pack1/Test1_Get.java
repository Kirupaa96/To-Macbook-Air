package Pack1;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*; // using static imports u can directly use the methods without creating objects
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class Test1_Get {

	@Test
	public void method1()
	{
		// Response res_obj= RestAssured.get("https://reqres.in/api/users?page=2"); //without static imports 
		
		Response res_obj= get("https://reqres.in/api/users?page=2");
		
		System.out.println(res_obj.asString());
		System.out.println(res_obj.getBody().asPrettyString()); // u have to view it as string 
		System.out.println(res_obj.getStatusCode());
		System.out.println(res_obj.getStatusLine());
		System.out.println(res_obj.getHeader("content-type"));
		System.out.println(res_obj.getTime());
		
		int statuscode = res_obj.getStatusCode();   
		Assert.assertEquals(statuscode, 200);
		
	}
	
	 @Test
	 public void method2()
	 {
		 given()
		    .get("https://reqres.in/api/users?page=2")
		 .then()
		    .statusCode(200)
		    .body("data.id[0]",equalTo(7)); // u need hamcrest matchers import stmt.
	 }
	
	
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
