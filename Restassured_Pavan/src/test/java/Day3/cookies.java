package Day3;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.Map;


public class cookies {
	
	@Test
	public void testCookies()
	{
	    when()
		  .get("https://www.google.com/")
		
	   .then()  // ur cookies should not match, hence we will know new cookies are created
		  .cookie("AEC","ARSKqsImVWx5fml2KEczzGzhKnA68Qh1i3Q7u3v2U4HRIgpmzUSdIIkp8A") // cookie validation
		  .log().all();
	}
	
	
	@Test
	public void getCookiesInfo()
	{
		Response res=given()
				
	    .when()
		  .get("https://www.google.com/");
		
//To get the value of single cookie (AEC)
		//String Cookie_value =res.getCookie("AEC");
		//System.out.println(Cookie_value);
		
		
//To get the value of ALL cookies .Use Hashmap to get cookies in key_value pair
	    Map<String,String> cookies = res.getCookies();
		
	   // cookies.keySet() this will print all the keys in the cookies 
	    
	    for( String k:cookies.keySet())
	    {
	    	System.out.println(k+":  "+cookies.get(k));
	    }
	    
	   
	}

	
	
	
	
	
	
	
	

	
	
}
