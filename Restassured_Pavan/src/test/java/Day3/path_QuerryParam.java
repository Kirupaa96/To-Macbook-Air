package Day3;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;



public class path_QuerryParam {

//	https://reqres.in/api/users?page=2&id=5
	
	@Test
	public void Path_Querry_Param()
	{
		given()
		  .pathParam("mypath", "users") // path parameter given as key_value pair
		  .queryParam("page", 2) // querry parameter key name should be same as url 
		  .queryParam("id", 5)
		
		.when()
		  .get("https://reqres.in/api/{mypath}") 
		
		.then()
		  .statusCode(200)
		  .log().all();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
