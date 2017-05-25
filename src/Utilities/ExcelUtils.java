package Utilities;
 
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils 
{
	private static XSSFSheet Excel_Sheet;
	private static XSSFWorkbook Excel_Book;
	private static XSSFCell Cell;
	private static XSSFRow Row;

//This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method
public static void setExcelFile(String sPath,String sSheetName) throws Exception 
{
	try 
	{
		// Open the Excel file
		FileInputStream ExcelFile = new FileInputStream(sPath);
		// Access the required test data sheet
		Excel_Book = new XSSFWorkbook(ExcelFile);
		Excel_Sheet = Excel_Book.getSheet(sSheetName);
	}
	catch (Exception e)
	{
		throw (e);
	}
}

//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num
public static String getCellData(int Row_Num, int Col_Num) throws Exception
{
	try
	{
		Cell = Excel_Sheet.getRow(Row_Num).getCell(Col_Num);
		String CellData = Cell.getStringCellValue();
		return CellData;
	}
	catch (Exception e)
	{
		return"";
	}
}

//This method is to write in the Excel cell, Row num and Col num are the parameters
public static void setCellData(String sResult,  int Row_Num, int Col_Num) throws Exception	
{
	try
	{
		Row  = Excel_Sheet.getRow(Row_Num);
		Cell = Row.getCell(Col_Num, Row.RETURN_BLANK_AS_NULL);
		if (Cell == null) 
		{
			Cell = Row.createCell(Col_Num);
			Cell.setCellValue(sResult);
		} 
		else 
		{
			Cell.setCellValue(sResult);
		}
		// Constant variables Test Data path and Test Data file name
		FileOutputStream fileOut = new FileOutputStream(Constants.Path_TestData + Constants.File_TestData);
		Excel_Book.write(fileOut);
		fileOut.flush();
		fileOut.close();
	}
	catch(Exception e)
	{
		throw (e);
	}
}
public static int getRowContains(String sTestCaseName, int colNum) throws Exception
{
	int i;
    try 
    {
	    int rowCount = Excel_Sheet.getLastRowNum();
        for ( i=0 ; i<rowCount; i++)
        {
	        if  (ExcelUtils.getCellData(i,colNum).equalsIgnoreCase(sTestCaseName))
	        {
	            break;
	        }
        }
        return i;
    }
    catch (Exception e)
    {
	    Log.error("Class ExcelUtil | Method getRowContains | Exception desc : " + e.getMessage());
        throw(e);
    }
}
}