package Day_019_Export_WebTable_Elements;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
  
import CommonUtil.*;
import ExcelUtil.ExcelApiTest3;

import java.awt.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import java.util.*;
public class Test2_Locations {
	
	static WebDriver driver;
	
  @Test
  public void Locations_List() throws Exception {
	  
	  
	  
	  Test2_Locations T1 = new Test2_Locations();
	  
	  T1.Browser();
	  T1.Login();
	  T1.Locations();
	  
  
	  
  }
  
  public void Browser() throws Exception {
	  
	driver = TestBrowser.OpenChromeBrowser(); 
	driver.get("https://opensource-demo.orangehrmlive.com/");
	  
	  
  }
  
  
  
  public void Login() throws Exception {
	  
	  findElement(By.id("txtUsername")).sendKeys("Admin");
	  findElement(By.id("txtPassword")).sendKeys("admin123");
	  findElement(By.id("btnLogin")).click();	  
	  
  }
  
  
  
  public void Locations() throws Exception {
	  
	  Actions actions = new Actions(driver);
	  WebElement ele=findElement(By.id("menu_admin_viewAdminModule"));
      actions.moveToElement(ele).click().perform();
      
	  driver.findElement(By.id("menu_admin_Organization")).click();
	  driver.findElement(By.id("menu_admin_viewLocations")).click();
	  
	  
	  String LocatiionColmns = "//*[@id=\"resultTable\"]/thead/tr/th";
	  List<WebElement> Coloumns =  driver.findElement(By.xpath(LocatiionColmns));
	
	  
	  
	  String LocationRows = "//*[@id=\"resultTable\"]/tbody/tr/td[2]";
	  List<WebElement> Rows = driver.findElement(By.xpath(LocationRows));
	  
	  
	  FileInputStream file =new FileInputStream("C:\\HTML Report\\OrangeHRM15\\Locations List.xlsx");		
		XSSFWorkbook wb =new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheet("Sheet1");
	  
	  int rowsize = sheet.getLastRowNum();
		 for(int i =1; i<= rowsize; i++)
		 {
			 
			XSSFRow row = sheet.getRow(rowsize);
	 
		   for(int j = 2, k=0; j<= Coloumns.size(); j++,k++)
		   
		   {
			   String str = "//*[@id='resultTable']/tbody/tr["  + i +  "]"  + "/td" + "[" + j +"]";
		   
		   
		   
		   WebElement Ele = findElement(By.xpath(str));
		   
		   String WebElementText = Ele.getText();
		   
		   FileOutputStream fos = new FileOutputStream("C:\\\\HTML Report\\\\OrangeHRM15\\\\Locations List.xlsx");
		   //workbook.write(fos);
		   fos.close();
		   System.out.println("END OF WRITING DATA IN EXCEL");
		   
		   
		  // if(WebElementText != null)
			  // PutCellData("\"C://HTML Report//OrangeHRM15//Employes List.xls","Sheet1",i,k,WebElementText);
		  // else
			//   T1.PutCellData("\"C://HTML Report//OrangeHRM15//Employes List.xls","Sheet1",i,k,"BlankData");
		   
		   }
		   
		   
	     }  
			   
 }		   
			   
		 		   
	 
		// Draws a red border around the found element. Does not set it back anyhow.
			public WebElement findElement(By by)throws Exception {
			    WebElement elem = driver.findElement(by);
			 
			    // draw a border around the found element
			    if (driver instanceof JavascriptExecutor) {
			        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
			    } 
			    Thread.sleep(10);
			    
			    return elem;
			}
	 
	  
  }
  
  
  
  
  
  
  
  
  
  
  

