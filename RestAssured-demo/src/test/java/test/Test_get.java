package test;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.* ;
import static org.hamcrest.Matchers.*;

public class Test_get {

	@Test
	public void test_1()
	{
		given().
		  get("https://reqres.in/api/users?page=2").
		then().
		  statusCode(200).
		  body("data[0].id",equalTo(7)). // verify the id of one user like assertions 
		  body("data[0].email",equalTo("michael.lawson@reqres.in")). // verifying email 
		  body("data[0].first_name",equalTo("Michael")).
		  body("data[0].last_name",equalTo("Lawson")).
		  log().all(); // gives the entire header, body 
	}
	
	@Test
	public void test_2()
	{
		given().
		  get("https://reqres.in/api/users?page=2").
		then().
		  statusCode(200).
		  body("data.first_name",hasItems("Michael","Lindsay","Tobias")). // verifies all the firstnames in the data 
		  log().all(); // gives the entire header, body 
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
