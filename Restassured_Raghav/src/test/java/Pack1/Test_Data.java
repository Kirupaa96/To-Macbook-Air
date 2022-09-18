package Pack1;

import org.testng.annotations.DataProvider;

public class Test_Data {

	 @DataProvider(name ="Delete_data")
	   public Object[] data_for_delete()
	   {
		   return new Object[]
		    {5} ; // deletes the data of id 5  
	   }
	
	 @DataProvider(name = "Post_data")
	  public Object[][] data_for_post()
	  {
		 /* 
		  Object[][] data =new Object[2][3];
		  
		  data[0][0] = "Mani";
		  data[0][1] = "Ratnam";
		  data[0][2] = "2";
		  
		  data[1][0] = "Albert";
		  data[1][1] = "Einstein";
		  data[1][2] = "1";
		  
		  return data; //This shit throws data provider mismatch error, use below method to declare values
		 */
		  
		  return new Object[][] 
		  {
			  {"Asault","sedhu",2},
			  {"Newton","Ganesan",1}
		  };
	  } 
	
}
