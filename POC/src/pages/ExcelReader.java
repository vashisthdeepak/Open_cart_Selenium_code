package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//import com.utility.ConfigReader;

public class ExcelReader 
{
	XSSFWorkbook wb;
	XSSFSheet sheet;
	
	
	public ExcelReader()
	{
	
	ConfigReader path =new ConfigReader();
	
	try {
		File src = new File(path.getexcelsheet());
		FileInputStream fis = new FileInputStream(src);
		wb= new XSSFWorkbook(fis);
	    } 
	 catch (Exception e)
	   {
		e.printStackTrace();
    	} 
	
	}	
	
	public String getsheetnumber(int sheetnumber , int row ,int column)
	{
		sheet=wb.getSheetAt(sheetnumber);
		String data=sheet.getRow(row).getCell(column).getStringCellValue();
		//System.out.println(data);
		return data;
	}	
	
	public int getsheetnumber1(int sheetnumber , int row ,int column)
	{
		sheet=wb.getSheetAt(sheetnumber);
		int data1=(int)sheet.getRow(row).getCell(column).getNumericCellValue();
		//System.out.println(data1);
		
		return data1;
	}

	public long getsheetnumber2(int sheetnumber , int row ,int column)
	{
		sheet=wb.getSheetAt(sheetnumber);
		long data2=(long)sheet.getRow(row).getCell(column).getNumericCellValue();
	    //System.out.println(data2);
		
		return data2;
	}	
	
	public int getrowcount(int index)
	{
		int rowcount=wb.getSheetAt(index).getLastRowNum();
		//System.out.println(rowcount);
		rowcount=rowcount+1;
		return rowcount;		
				
	}

}
