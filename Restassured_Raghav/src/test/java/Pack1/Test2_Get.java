package Pack1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Test2_Get {

	@Test
	public void test1()
	{
		given().
		   get("https://reqres.in/api/users?page=2").
		then().
		   statusCode(200).
		   body("data.first_name[5]", equalTo("Rachel")).
		   body("data.last_name", hasItems("Lawson","Ferguson")).
		   log().all(); // prints all the data 
	}
}
