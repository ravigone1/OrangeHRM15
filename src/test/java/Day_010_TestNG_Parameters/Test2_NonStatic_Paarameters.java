package Day_010_TestNG_Parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;
import ExcelUtil.ExcelApiTest4;

//import ExcelUtil.ExcelApiTest4;


public class Test2_NonStatic_Paarameters {
	
	
	static WebDriver driver;
	
	
 
	@Parameters({"Browser","UserName","Password","JobTitle","JobDesr","JobNote"})
	@Test
	public void Login_Test(String Browser1,String UserName1,String Password1,String JobTitle,String JobDesr,String JobNote ) throws Exception{
		
	
	if(Browser1.equalsIgnoreCase("Chrome"))
	{
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	 	driver =new ChromeDriver();
 	 	driver.manage().window().maximize() ;	
    }

	if(Browser1.equalsIgnoreCase("FireFox"))
	{
			driver = TestBrowser.OpenFirefoxBrowser();
	}		Thread.sleep(1000);
	
	
	Test2_NonStatic_Paarameters T1 = new Test2_NonStatic_Paarameters();
	T1.OpenChromeBrowser();
	T1.OpenOrangeHRM();
	T1.Login(UserName1,Password1);
	T1.JobTitles(JobTitle);
	T1.JobDescription(JobDesr);
	T1.JobNote(JobNote);
	T1.CloseBrowser();
		
	}
	
	public static  WebElement findElement(By by) throws Exception 
	{
				
		 WebElement elem = driver.findElement(by);    	    
		
		 
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		
		return elem;
	}
 
	
	
	
	public  void OpenChromeBrowser() throws Exception
	{
	System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
	
	}
	
	
	public  void OpenOrangeHRM() throws Exception
	{
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	
	
	
	public void Login(String UserName1,String Password1) throws Exception
	{
		
		findElement(By.name("txtUsername")).sendKeys(UserName1);
		findElement(By.name("txtPassword")).sendKeys(Password1);
		findElement(By.id("btnLogin")).click();
		
		
		
	}
	
	
		
		 public void JobTitles(String JobTitle) throws Exception {
			  
			    driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']/b")).click();
			    driver.findElement(By.id("menu_admin_Job")).click();
			    driver.findElement(By.id("menu_admin_viewJobTitleList")).click();
			    driver.findElement(By.id("btnAdd")).click();
			    driver.findElement(By.id("jobTitle_jobTitle")).click();
			    driver.findElement(By.id("jobTitle_jobTitle")).clear();
			    driver.findElement(By.id("jobTitle_jobTitle")).sendKeys(JobTitle);
		  }
		  
		  
		  
		  public void JobDescription(String JobDesr) throws Exception {
			  
			  driver.findElement(By.id("jobTitle_jobDescription")).click();
			    driver.findElement(By.id("jobTitle_jobDescription")).clear();
			    driver.findElement(By.id("jobTitle_jobDescription")).sendKeys(JobDesr);
		  }
			  
		  
			  public void JobNote(String JobNote) throws Exception {
				  
				  
				    driver.findElement(By.id("jobTitle_note")).click();
				    driver.findElement(By.id("jobTitle_note")).clear();
				    driver.findElement(By.id("jobTitle_note")).sendKeys(JobNote);
				   
				    driver.findElement(By.id("btnSave")).click();
				    
			  }
			  
		
		public void CloseBrowser()throws Exception{
		driver.quit();
	}
	
	
}	
	
	
	


