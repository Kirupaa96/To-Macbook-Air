package utils;

public class Excel_test {

	public static void main(String[] args) 
	{
	  String Excelpath ="./Data/Test_data.xlsx";
	  String Sheetname ="Sheet1";
	
	  Excel_code obj =new Excel_code(Excelpath, Sheetname);
	  
	  obj.get_row_count();
	  
	  for (int i=1; i<4; i++)
	  {
	   for (int j=0; j<3; j++)
	   {
		  obj.get_cell_data(i, j); 
	   }  
	  }
	 
	  
	
	}	
}
