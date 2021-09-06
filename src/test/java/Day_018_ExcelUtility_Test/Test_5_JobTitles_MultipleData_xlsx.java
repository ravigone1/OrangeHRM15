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

public class Test_5_JobTitles_MultipleData_xlsx {
	
	
	
	static WebDriver driver;
	
   
	String TestURL;
	String UserName,Password;
	String JobTitle,JobDescr,JobNote; 
	
	@Test
	public void loginTest() throws Exception//Step3
	{
		
		
		ExcelApiTest4 T1 = new ExcelApiTest4();
		
		int Rowcount = T1.getRowCount("C://HTML Report//OrangeHRM6//JobTitles1.xlsx","Sheet1");
		
		System.out.println("Row Count : "+Rowcount);
		Rowcount = Rowcount-1;
		
		
		 for (int i=1; i<=Rowcount; i++) 
		 {
		
		TestURL = T1.getCellData("C://HTML Report//OrangeHRM6//JobTitles1.xlsx","Sheet1",i,0);
		UserName = T1.getCellData("C://HTML Report//OrangeHRM6//JobTitles1.xlsx","Sheet1",i,1);
		Password = T1.getCellData("C://HTML Report//OrangeHRM6//JobTitles1.xlsx","Sheet1",i,2);
		JobTitle = T1.getCellData("C://HTML Report//OrangeHRM6//JobTitles1.xlsx","Sheet1",i,3);
		JobDescr = T1.getCellData("C://HTML Report//OrangeHRM6//JobTitles1.xlsx","Sheet1",i,4);
		JobNote =  T1.getCellData("C://HTML Report//OrangeHRM6//JobTitles1.xlsx","Sheet1",i,5);
		
		
		
		 System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	     driver =new ChromeDriver();
		 driver.manage().window().maximize() ;	
		 driver.get(TestURL);
		 
		 
		 Test_5_JobTitles_MultipleData_xlsx T2= new Test_5_JobTitles_MultipleData_xlsx();
		  
				 T2.Login(UserName,Password);
		 T2.Addjobs(JobTitle,JobDescr,JobNote);
		 T2.CloseBrowser();
	}
	
	
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
