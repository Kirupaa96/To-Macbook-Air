package Day1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

/*
 given()
     content type, headers, set cookies, add auth ,add param ,info etc.. 
   
 when()
     get,put,post,delete
     
 then()
     validate status code, extract response , extract headers & cookies & response bodies,        
         
  */

public class httpReq {

	int ID;
	
	
	
	@Test (priority =1)
	public void getUsers()
	{
		when()
		  .get("https://reqres.in/api/users?page=2")
		  
	    .then()
	      .statusCode(200) // status code validation 
	      .body("page",equalTo(2)) // validates the response body 
		  .log().all();  // this will print entire response in console window 
		
	}

	@Test (priority =2)
	public void createUser()
	{
		  HashMap data = new HashMap();
		  
		  data.put("Name","Kirupaa");
		  data.put("Job", "Test Engineer");
		  
		  
		ID= given()  
		  .contentType("application/json") // mention wat format of data u r sending
		  .body(data)
		
		
		.when()
		  .post("https://reqres.in/api/users")
		  .jsonPath().getInt("id"); // so we are capturing the id value from the data that is generated 
		
		// so now when we run it it will store the value of id in ID variable and we can use it for updating or deleting data
		
		System.out.println("The id that is being updated is : "+ID);
	 }
	
	
	@Test(priority =3, dependsOnMethods= "createUser")//If createuser method is passed updateuser will run orelse it will be skiped
	public void updateUser()
	{
		
		 HashMap data1 = new HashMap();
		  
		  data1.put("Name","Deepak");
		  data1.put("Job", "IT Engineer");
		  
		  
		given()
		   .contentType("application/json")
		   .body(data1)
		
		.when()
		  .put("https://reqres.in/api/users/"+ID) // i am passing the value of id stored in ID here inorder to update data 
		
		.then()
		  .statusCode(200)
		  .log().all();
	}
	
	
	@Test(priority =4)
	public void deleteUser()
	{
		
		when()
		  .delete("https://reqres.in/api/users/"+ID) //we are deleting the content we created and updated 
		
		.then()
		 .statusCode(204)
		 .log().all();
		
	}
	
	
   
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
