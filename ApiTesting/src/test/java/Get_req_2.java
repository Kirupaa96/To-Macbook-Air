import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get_req_2 {

	@Test
	public void google_maps()
	{
		// specify baseuri
		RestAssured.baseURI ="https://maps.googleapis.com";
		
		//Request object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response object 
		Response res_obj = httpRequest.request(Method.GET,"/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");
		
	    // res_obj has so many stuffs, u need oly body and change from json to string format 
		String res_body= res_obj.getBody().asString();
		System.out.println("Response body is "+res_body);
		
		
		//validating headers
	    String contentType= res_obj.header("Content-Type");// capture details of Content-Type header
		System.out.println("Content Type is:"+contentType);
		Assert.assertEquals(contentType, "application/xml; charset=UTF-8");
		  
		String contentEncoding= res_obj.header("Content-Encoding");// capture details of Content-Encoding  header
		System.out.println("Content Encoding is:"+contentEncoding);
		Assert.assertEquals(contentEncoding, "gzip");
	}
}
