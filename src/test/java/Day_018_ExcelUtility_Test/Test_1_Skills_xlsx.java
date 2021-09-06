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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;
import ExcelUtil.ExcelApiTest4;

public class Test_1_Skills_xlsx {
	
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet = null;
	public XSSFRow row = null;
	public XSSFCell cell = null;
	
	public FileOutputStream fout=null;
    public FileInputStream fis = null;
	
	static WebDriver driver;
	

	String TestURL;
	String UserName,Password;
	String SkillName,SkillDescr; 
	
	@Test
	public void loginTest() throws Exception//Step3
	{
		
		
		Test_1_Skills_xlsx T1 = new Test_1_Skills_xlsx();
		
		
		TestURL = T1.getCellData("C://HTML Report//OrangeHRM6//TC01_Skills.xlsx","Sheet1",1,0);
		UserName = T1.getCellData("C://HTML Report//OrangeHRM6//TC01_Skills.xlsx","Sheet1",1,1);
		Password = T1.getCellData("C://HTML Report//OrangeHRM6//TC01_Skills.xlsx","Sheet1",1,2);
		SkillName = T1.getCellData("C://HTML Report//OrangeHRM6//TC01_Skills.xlsx","Sheet1",1,3);
		SkillDescr = T1.getCellData("C://HTML Report//OrangeHRM6//TC01_Skills.xlsx","Sheet1",1,4);
		
		
		 System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	     driver =new ChromeDriver();
		 driver.manage().window().maximize() ;	
		 driver.get(TestURL);
		
		T1.Login(UserName,Password);
		T1.AddSkills(SkillName,SkillDescr);
		T1.CloseBrowser();
	}
	
	
	

	public void Login(String UserName,String Password) throws Exception
	{
		
		findElement(By.id("txtUsername")).sendKeys(UserName);
		findElement(By.id("txtPassword")).sendKeys(Password);
		findElement(By.id("btnLogin")).click();
	}
	

	public void AddSkills(String SkillName,String SkillDescr) throws Exception
	{
		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.linkText("Qualifications")).click();
		findElement(By.linkText("Skills")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("skill_name")).sendKeys(SkillName);
		findElement(By.id("skill_description")).sendKeys(SkillDescr);
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
