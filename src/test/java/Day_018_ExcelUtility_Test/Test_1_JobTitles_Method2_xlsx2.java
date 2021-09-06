package Day_018_ExcelUtility_Test;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;
//import ExcelUtil.ExcelApiTest4;

public class Test_1_JobTitles_Method2_xlsx2 {
	
	static WebDriver driver;
	
	@Test
	public void loginTest() throws Exception
	{
		
		
		FileInputStream file =new FileInputStream("C:\\HTML Report\\OrangeHRM15\\Job.xlsx");		
		XSSFWorkbook wb =new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheet("Sheet2");
		
		int rowcount = sheet.getLastRowNum();
		 for(int i =1; i<= rowcount; i++);
		 {
			 
			XSSFRow row = sheet.getRow(rowcount);
			
		  
		String TestURL = row.getCell(0).getStringCellValue();		
		String UserName = row.getCell(1).getStringCellValue();
		String Password = row.getCell(2).getStringCellValue();
		String JobTitle = row.getCell(3).getStringCellValue();
		String JobDescr =row.getCell(4).getStringCellValue();
		String Photopath =row.getCell(5).getStringCellValue();
		String JobNote =  row.getCell(6).getStringCellValue();
		
		
		
		 System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	     driver =new ChromeDriver();
		 driver.manage().window().maximize() ;	
		 driver.get(TestURL);
		 
		 
		
		driver.findElement(By.id("txtUsername")).sendKeys(UserName);
		driver.findElement(By.id("txtPassword")).sendKeys(Password);
		driver.findElement(By.id("btnLogin")).click();
	
	
		driver.findElement(By.linkText("Admin")).click();
		driver.findElement(By.id("menu_admin_Job")).click();
		driver.findElement(By.id("menu_admin_viewJobTitleList")).click();
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("jobTitle_jobTitle")).sendKeys(JobTitle);
		driver.findElement(By.id("jobTitle_jobDescription")).sendKeys(JobDescr);
		
		//String JobTitlPhoto = "C:\\Users\\HP\\Desktop\\1\\five.jpg";
		WebElement upload = driver.findElement(By.xpath("//*[@id=\"jobTitle_jobSpec\"]"));
		upload.sendKeys(Photopath);
		Thread.sleep(1000);
		driver.findElement(By.id("jobTitle_note")).sendKeys(JobNote);
		
		driver.findElement(By.id("btnSave")).click();
    
		//driver.quit();
	
	
		 }
	}	

}
