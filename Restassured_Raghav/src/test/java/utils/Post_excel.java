package utils;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

public class Post_excel {

	 @Test
	  public void postdata()
		{
		   String Excelpath ="./Data/Test_data.xlsx";
		   String Sheetname ="Sheet1";
		   Excel_code obj =new Excel_code(Excelpath, Sheetname);		 
 		 
	       JSONObject request = new JSONObject();
			
	       for (int i=1; i<4; i++)
	       {
			   request.put("firstName", obj.get_cell_data(i, 0));
			   request.put("lastName",  obj.get_cell_data(i, 1));
			   request.put("subjectId", obj.get_cell_data(i, 2));
	       
	        baseURI = "http://localhost:3000/";
			
			given().
			  header("Content-Type","application/json").
			  contentType(ContentType.JSON). //what am passing is of json type
			  accept(ContentType.JSON).     //what am accepting is also json type 
			  body(request.toJSONString()).  // it converts into json string 
			when().
			  post("/users").
			then().
			  statusCode(201).
			  log().all();
	       }
		}
	 
	 
	 @Test
		public void deletedata()
		{
		    int[] id = new int[3];
		    id[0]=8;
		    id[1]=9;
		    
		    for (int i=0; i<2;i++)
		    {
		    when().   
			   delete("http://localhost:3000/users/"+id[i]).
			then().
			   log().all();
			   //statusCode(204);	
		    }
		
		}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}

    