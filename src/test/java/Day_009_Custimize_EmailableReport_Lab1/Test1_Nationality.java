package Day_009_Custimize_EmailableReport_Lab1;
import CommonUtil.*;
import Day_009_Custimize_EmailableReport_Lab1.Reporter1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Test1_Nationality {
	
	static WebDriver driver;
	Reporter1 R1;
  @Test
  public void Custamize_Report() throws Exception {
	  
	  Test1_Nationality T1 = new Test1_Nationality();
	  T1.OpenBrowser();
	  T1.login();
	  T1.Nationality();
	    
  }
	  
  
  public void OpenBrowser() throws Exception {
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;
		
		
		String str = "Custamize_Report_1";
		R1 = new Reporter1(driver,str);
		
       String TestURL = "https://opensource-demo.orangehrmlive.com/";
		
		driver.get(TestURL);
		R1.TakeScreenShotAuto(driver,"Opened Orange HRM","Pass"); //step4
	    
  }
  
  
  public void login() throws Exception {
	  findElement(By.id("txtUsername")).sendKeys("Admin");
		R1.TakeScreenShotAuto(driver,"Username Entered","Pass");
		
		findElement(By.id("txtPassword")).sendKeys("admin123");
		R1.TakeScreenShotAuto(driver,"Password Enterwd","Pass");
		  
		  driver.findElement(By.name("Submit")).click();
		  R1.TakeScreenShotAuto(driver,"Btnlogin","Pass");  
	    
  }
  
  
  public void Nationality() throws Exception {
	  driver.findElement(By.id("menu_admin_viewAdminModule")).click();
	  R1.TakeScreenShotAuto(driver,"Pass Admin","Pass");
	  
	  driver.findElement(By.id("menu_admin_nationality")).click();
	  R1.TakeScreenShotAuto(driver,"Pass Nationality","pass");
	  
	  driver.findElement(By.id("btnAdd")).click();
	  R1.TakeScreenShotAuto(driver,"Pass AddBtn","pass");
	  
	  
	  driver.findElement(By.id("nationality_name")).sendKeys("indian69");
	  R1.TakeScreenShotAuto(driver,"Pass nationality Name","pass");
	  
	  driver.findElement(By.id("btnSave")).click();
	  R1.TakeScreenShotAuto(driver,"Pass Save","pass");
	    
  }
	  
	  
		public  WebElement findElement(By by) throws Exception 
		{
					
			 WebElement elem = driver.findElement(by);    	    
			// draw a border around the found element
			 
			if (driver instanceof JavascriptExecutor) 
			{
			 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
		 
			}
			
			return elem;
		}
		
	
}
