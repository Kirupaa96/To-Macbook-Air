package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_code {
	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public Excel_code(String Excelpath, String Sheetname) //so when this class is called,the user will be asked to give excelpath & sheetname.
	{
		try
		{
	    workbook =new XSSFWorkbook(Excelpath); // will store the excel file in that location 
	    sheet = workbook.getSheet(Sheetname); // will get the sheet of that excel file 
		}
		catch (Exception ex)
		{
		 System.out.println(ex.getMessage());
		 System.out.println(ex.getCause());
         ex.printStackTrace();		
		}  
	}
	
	public static int get_row_count()  // This method will give u the no of rows 
    {
	   int row_count =0;
	   row_count = sheet.getPhysicalNumberOfRows();// will give you the no.of rows 
	   System.out.println("No of rows is " +row_count);
	   return row_count;
	}
	
	public static int get_col_count()  // This method will give u the no of rows 
	{
	   int col_count =0;	
	   col_count = sheet.getRow(0).getPhysicalNumberOfCells();// will give you the no.of rows 
	   System.out.println("No of cols is " +col_count);
	   return col_count;
	}
	
	public static Object get_cell_data(int RowNo, int ColNo)  // This method will give u the cell data 
	{
	   DataFormatter formatter =new DataFormatter();
	   Object value= formatter.formatCellValue(sheet.getRow(RowNo).getCell(ColNo)); // this will get value of any datatype
	   //System.out.println(value);
	   return value;
	}
		
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

