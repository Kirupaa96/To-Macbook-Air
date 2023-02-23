package Day3;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;


public class logging {

	
	@Test
	public void logs()
	{
		
		given()
		
		.when()
		   .get("https://www.facebook.com/")
		
		.then()
		  // .log().body()     // it will print oly response body 
		  // .log().cookies()  // it will print oly cookies
		  // .log().headers()  // it will print oly headers
		     .log().all();     // it will print everything
	}
}
