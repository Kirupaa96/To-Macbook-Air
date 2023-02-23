package Day2;

/*
  
Different ways to create a Request body

1. POST req body using Hashmap
2. POST req body using Org.json
3. POST req body using POJO class 
4. POST req body using external file data.

 */

import org.testng.annotations.Test;
import org.json.JSONObject;
import org.json.JSONTokener;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;




public class Ways_to_create_reqBody {

	
	
//1. POST req body using HashMap 
	
    @Test(priority=0)
	public void method1()
	{
		HashMap hm = new HashMap();
		
		hm.put("id", 4);
		hm.put("name", "saranya");
		hm.put("location", "switzerland");
		hm.put("phone", "12345432");
		
		// since courses field has m/p values , we store it in array and pass it 
		
		String courseArr[] = {"c","c++"}; 
		hm.put("courses", courseArr); 
		
		given()
		   .contentType("application/json")
		   .body(hm)
		
		.when()
		   .post("http://localhost:3000/students") 
		
		.then()
		    .statusCode(201)
		    .body("name", equalTo("saranya"))             //Response body validations
		    .body("location", equalTo("switzerland"))
		    .body("phone", equalTo("12345432"))
		    .body("courses[0]",equalTo("c"))
		    .body("courses[1]",equalTo("c++"))
		    //.header("Content-Type","application/json ;charset=utf-8")   //Header validation
		    .log().all();
		 
	 }
	
	
	@Test(priority=1)
	public void deleteRecord() 
	{
	   
		 when()
		  .delete("http://localhost:3000/students/4")
		  
		 .then()
		   .statusCode(200);
	}
	
	
//2. POST req body using Org.json // we need to have org.json dependency
	
    @Test
	public void method2()
	{
		
		JSONObject data = new JSONObject();
		data.put("id", 5);
		data.put("name", "saranya");
		data.put("location", "switzerland");
		data.put("phone", "12345432");
		
		String coursesArr[] = {"sql","JavaScript"};
		data.put("courses",coursesArr);
		
		
		given()
		   .contentType("application/json")
		   .body(data.toString())  //we need to convert data into string format then it will be converted to json format auto
		   
		.when()
		   .post("http://localhost:3000/students") 
		
		.then()
		    .statusCode(201)
		    .body("name", equalTo("saranya"))             //Response body validations
		    .body("location", equalTo("switzerland"))
		    .body("phone", equalTo("12345432"))
		    .body("courses[0]",equalTo("sql"))
		    .body("courses[1]",equalTo("JavaScript"))
		    //.header("Content-Type","application/json ;charset=utf-8")   //Header validation
		    .log().all();
	}
	

//3.  POST req body using POJO class. create a seperate pojo class and give the data there 
    
    @Test
   	public void method3()
   	{
    	POJO_postReq data = new POJO_postReq();
    	
    	data.setName("Aishwarya");
    	data.setLocation("America");
    	data.setPhone("7299612300");
    	
    	String coursesArr[] = {"Java","Python"};
    	data.setCourses(coursesArr);
   		
   		
   		given()
   		   .contentType("application/json")
   		   .body(data)  
   		   
   		.when()
   		   .post("http://localhost:3000/students") 
   		
   		.then()
   		    .statusCode(201)
   		    .body("name", equalTo("Aishwarya"))          
   		    .body("location", equalTo("America"))
   		    .body("phone", equalTo("7299612300"))
   		    .body("courses[0]",equalTo("Java"))
   		    .body("courses[1]",equalTo("Python"))
   		    //.header("Content-Type","application/json ;charset=utf-8")   
   		    .log().all();
   	}
    
	
//4.  POST req body using External Json file (body.json)	
	
    @Test
   	public void method4() throws FileNotFoundException
   	{
    	File f = new File("/Users/kirupaashankar/eclipse-workspace/Restassured_Pavan/src/test/java/Day2/body.json");
   		FileReader fr = new FileReader(f);
   		JSONTokener jt =new JSONTokener(fr);
   	    JSONObject data = new JSONObject(jt);
    	
    	
  
   		given()
   		   .contentType("application/json")
   		   .body(data.toString())  
   		   
   		.when()
   		   .post("http://localhost:3000/students") 
   		
   		.then()
   		    .statusCode(201)
   		    .body("name", equalTo("Hari"))          
   		    .body("location", equalTo("india"))
   		    .body("phone", equalTo("4372545452"))
   		    .body("courses[0]",equalTo("c#"))
   		    .body("courses[1]",equalTo("JS"))
   		    //.header("Content-Type","application/json ;charset=utf-8")   
   		    .log().all();
   	}
	
	
	
	
	
	
	
	
	
	

    
    
    
    
    
    
    
    
    
	
}






