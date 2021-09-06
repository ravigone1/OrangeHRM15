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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;
import ExcelUtil.ExcelApiTest4;

public class Test_1_JobTitles_xlsx {
	
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet = null;
	public XSSFRow row = null;
	public XSSFCell cell = null;
	
	public FileOutputStream fout=null;
    public FileInputStream fis = null;
	
	static WebDriver driver;
	
    String Browser;
	String TestURL;
	String UserName,Password;
	String JobTitle,JobDescr,JobNote; 
	
	@Test
	public void loginTest() throws Exception//Step3
	{
		
		
		Test_1_JobTitles_xlsx T1 = new Test_1_JobTitles_xlsx();
		
		
		TestURL = T1.getCellData("C://HTML Report//OrangeHRM6//JobTitles1.xlsx","Sheet1",1,0);
		UserName = T1.getCellData("C://HTML Report//OrangeHRM6//JobTitles1.xlsx","Sheet1",1,1);
		Password = T1.getCellData("C://HTML Report//OrangeHRM6//JobTitles1.xlsx","Sheet1",1,2);
		JobTitle = T1.getCellData("C://HTML Report//OrangeHRM6//JobTitles1.xlsx","Sheet1",1,3);
		JobDescr = T1.getCellData("C://HTML Report//OrangeHRM6//JobTitles1.xlsx","Sheet1",1,3);
		JobNote =  T1.getCellData("C://HTML Report//OrangeHRM6//JobTitles1.xlsx","Sheet1",1,5);
		
		
		
		 System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	     driver =new ChromeDriver();
		 driver.manage().window().maximize() ;	
		 driver.get(TestURL);
		 
		 
		
		  
		T1.Login(UserName,Password);
		T1.Addjobs(JobTitle,JobDescr,JobNote);
		T1.CloseBrowser();
	}
	
	
	

	public void Login(String UserName,String Password) throws Exception
	{
		
		findElement(By.id("txtUsername")).sendKeys(UserName);
		findElement(By.id("txtPassword")).sendKeys(Password);
		findElement(By.id("btnLogin")).click();
	}
	

	public void Addjobs(String JobTitle,String JobDescr,String JobNote) throws Exception
	{
		findElement(By.linkText("Admin")).click();
		findElement(By.id("menu_admin_Job")).click();
		findElement(By.id("menu_admin_viewJobTitleList")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("jobTitle_jobTitle")).sendKeys(JobTitle);
		findElement(By.id("jobTitle_jobDescription")).sendKeys(JobDescr);
		
		String JobTitlPhoto = "C:\\Users\\HP\\Desktop\\1\\five.jpg";
		WebElement upload = findElement(By.xpath("//*[@id=\"jobTitle_jobSpec\"]"));
		upload.sendKeys(JobTitlPhoto);
		Thread.sleep(1000);
		findElement(By.id("jobTitle_note")).sendKeys(JobNote);
		
		findElement(By.id("btnSave")).click();
	}
	
	public void CloseBrowser() throws Exception
	{
		driver.quit();
	}
	
	public String getCellData(String xlFilePath,String SheetName,int rowNum,int column) throws Exception{
		
		fis = new FileInputStream(xlFilePath);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(SheetName);
        row = sheet.getRow(rowNum);
        cell = row.getCell(column);
        
        if(cell.getCellTypeEnum() == CellType.STRING)
        {	
        	String str6=cell.getStringCellValue();
        	workbook.close();
        	fis.close();
            return str6;
        }
	
	else if(cell.getCellTypeEnum() == CellType.NUMERIC)
	{
		 int i = (int)cell.getNumericCellValue(); 
     	String str6 = String.valueOf(i); 
     	workbook.close();
     	fis.close();
         return str6;
	}
	
	else
	{
		String str6 = cell.getStringCellValue();
		workbook.close();
		fis.close();
		return str6;
	}
}

	
	public  WebElement findElement(By by) throws Exception 
	{

		WebElement elem = driver.findElement(by);  
		
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		return elem;
	}

	

}
