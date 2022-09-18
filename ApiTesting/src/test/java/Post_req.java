import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Post_req {

	@Test
	public void Registration()
	{
		// specify baseuri
	    RestAssured.baseURI ="http://restapi.demoqa.com/customer";
				
	    //Request object
		RequestSpecification httpRequest = RestAssured.given();
				
		//Request payload sending along with the post req
		JSONObject reqparams =new JSONObject();
		reqparams.put("FirstName", "Kirupaa");
		reqparams.put("LastName", "Shankar");
		reqparams.put("UserId", "krishxyz");
		reqparams.put("Password", "krishXYZ");
		reqparams.put("Email", "kirupaa96@gmail.com");
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(reqparams.toJSONString()); //will attach above data to the req 
		
		//Response object 
		Response res_obj = httpRequest.request(Method.POST,"/register");
		
		
		// res_obj has so many stuffs, u need oly body and change from json to string format 
		String res_body= res_obj.getBody().asString();
		System.out.println("Response body is "+res_body);
				
		//Status code validation 
		int statuscode = res_obj.getStatusCode();
		System.out.println("Status code is "+statuscode);
		Assert.assertEquals(statuscode, 201);
		
		//To verify Success code from the response body and it is in json format 
		String success_code = res_obj.jsonPath().get("SuccessCode"); 
		Assert.assertEquals(success_code, "OPERATION_SUCCESS");		
			
	}
}
