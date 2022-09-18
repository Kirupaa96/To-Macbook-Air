package Pack1;

import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

public class Post_put_patch_delete {

	@Test
	public void test1_Post()
	{
		/* Map<String, Object> map =new HashMap<String, Object>();
		
		map.put("name", "morpheus");
		map.put("job", "leader");
		System.out.println(map); */
		
		// To get the response body in json format u need to add json.simple dependency 
		JSONObject request =new JSONObject();
		
		request.put("name", "morpheus");
		request.put("job", "leader");
		System.out.println(request.toJSONString()); // to print in a json format
		
		given().
		   header("Content-Type","application/json").
		   accept(ContentType.JSON).
		   body(request.toJSONString()).
		when().   
		   post("https://reqres.in/api/users").
		then().
		   statusCode(201);	
	 }
	
	@Test
	public void test2_Put()
	{
		JSONObject request =new JSONObject();
		
		request.put("name", "morpheus");
		request.put("job", "zion resident");
		System.out.println(request.toJSONString()); // to print in a json format
		
		given().
		   header("Content-Type","application/json").
		   accept(ContentType.JSON).
		   body(request.toJSONString()).
		when().   
		   put("https://reqres.in/api/users/2").
		then().
		   log().all().
		   statusCode(200);	
	 }
	
	@Test
	public void test3_Patch()
	{
		JSONObject request =new JSONObject();
		
		request.put("name", "morpheus");
		request.put("job", "Professor");
		System.out.println(request.toJSONString()); // to print in a json format
		
		given().
		   header("Content-Type","application/json").
		   accept(ContentType.JSON).
		   body(request.toJSONString()).
		when().   
		   patch("https://reqres.in/api/users/2").
		then().
		   log().all().
		   statusCode(200);	
	 }
	
	@Test
	public void test4_Delete()
	{
		when().   
		   delete("https://reqres.in/api/users/2").
		then().
		   log().all().
		   statusCode(204);	
	 }
	
	
	
	
	
	
}
