package Day_018_ExcelUtility_Test;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFRow;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.hssf.usermodel.HSSFCell;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;
import ExcelUtil.ExcelApiTest4;

public class Test_4_JobTitles_PutData_xls {
	
	public HSSFWorkbook workbook = null;
	public HSSFSheet sheet = null;
	public HSSFRow row = null;
	public HSSFCell cell = null;
	
	public FileOutputStream fout=null;
    public FileInputStream fis = null;
	
	static WebDriver driver;

	

	String UserName,Password;
	String JobTitle,JobDescr,JobNote; 
	
	@Test
	public void loginTest() throws Exception//Step3
	{
		
		
		Test_4_JobTitles_PutData_xls T1 = new Test_4_JobTitles_PutData_xls();
		
		
		T1.putCellData("C://HTML Report//OrangeHRM6//JobTitles_Putdata1.xls","Sheet1",1,0,"Admin");
		T1.putCellData("C://HTML Report//OrangeHRM6//JobTitles_Putdata1.xls","Sheet1",1,1,"admin123");
		T1.putCellData("C://HTML Report//OrangeHRM6//JobTitles_Putdata1.xls","Sheet1",1,2,"Python");
		T1.putCellData("C://HTML Report//OrangeHRM6//JobTitles_Putdata1.xls","Sheet1",1,3,"Python12");
		T1.putCellData("C://HTML Report//OrangeHRM6//JobTitles_Putdata1.xls","Sheet1",1,4,"PythonDesr");
		
	  
		
	}
		
	public void putCellData(String xlFilePath,String SheetName,int rowNum,int column,String Text) throws Exception{
		
		fis = new FileInputStream(xlFilePath);
        workbook = new HSSFWorkbook(fis);
    	sheet = workbook.getSheet(SheetName);
    	
    	if(sheet.getRow(rowNum)==null)
    	{
    		row=sheet.createRow(rowNum);
    	}
    	else
    	{
    		row=sheet.getRow(rowNum);
    	}
    	
    	
    	if(row.getCell(column)==null)
    	{
    		cell=row.createCell(column);
    	}
    	else
    	{
    		cell=row.getCell(column);
    	}
 
    	
    	
    	cell = sheet.getRow(rowNum).getCell(column);  
    	cell.setCellValue(Text);
    	
    	cell.setCellValue(Text);
    	
    	fout= new FileOutputStream(xlFilePath);
    	workbook.write(fout);
     
        fout.flush();
        fout.close();
        workbook.close();
        fis.close();
    	

	}
	
}
