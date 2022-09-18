import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get_req {

	@Test
	public void get_weather_details()
	{
		// specify baseuri
		RestAssured.baseURI ="http://restapi.demoqa.com/utilities/weather/city";
		
		//Request object is used to send a req to the server 
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response object 
		Response res_obj = httpRequest.request(Method.GET,"/Hyderabad");
		
	    // res_obj has so many stuffs, u need oly body and change from json to string format 
		String res_body= res_obj.getBody().asString();
		System.out.println("Response body is "+res_body);
		
		//Status code validation 
		int statuscode = res_obj.getStatusCode();
		System.out.println("Status code is "+statuscode);
		Assert.assertEquals(statuscode, 200);
		
		//Status line verification 
		String statusline = res_obj.getStatusLine();
		System.out.println("Status line is "+statusline);
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
