package  Day_009_Custimize_EmailableReport_Lab1;
import CommonUtil.*;
import Day_009_Custimize_EmailableReport_Lab1.Reporter1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.*;

public class Test2_Skills
{
	
	static WebDriver driver;
	
	Reporter1 R1;
	
	
	
	@Test
	public void Custamize_Report_2() throws Exception {
		
		Test2_Skills T1 = new Test2_Skills();
		T1.OpenBrowser();
		T1.Login();
		T1.AddSkills();
	//	T1.CloseBrowser();
		
		
	}
		
		public void OpenBrowser() throws Exception {
			
			System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
			driver =new ChromeDriver();
			driver.manage().window().maximize() ;
			
			
			
			String str= "Custamize Emailable Report_2";
			R1= new Reporter1(driver,str);	
			
			String TestURL = "https://opensource-demo.orangehrmlive.com/";
			
			driver.get(TestURL);
			R1.TakeScreenShotAuto(driver,"Opened Orange HRM","Pass");
			
			
		}
		
		public void Login() throws Exception {
			
			findElement(By.id("txtUsername")).sendKeys("Admin");
			R1.TakeScreenShotAuto(driver,"Username Entered","Pass");
			

			findElement(By.id("txtPassword")).sendKeys("admin123");	
			R1.TakeScreenShotAuto(driver,"Password Entered","Pass");
			
			
			findElement(By.name("Submit")).click();
			R1.TakeScreenShotAuto(driver,"Clicked on Signin","pass");
			driver.close();
			
		}
		
	   public void AddSkills()throws Exception{
		   
		   WebElement Admin=findElement(By.id("menu_admin_viewAdminModule"));
		   JavascriptExecutor js = (JavascriptExecutor)driver;
		   
		   js.executeScript("arguments[0].click()",Admin);
		   
		  // findElement(By.id("menu_admin_viewAdminModule")).click();
			R1.TakeScreenShotAuto(driver,"Click Admin","Pass");
			
			findElement(By.id("menu_admin_Qualifications")).click();	
			R1.TakeScreenShotAuto(driver,"Qualificationclick","Pass");
			
			findElement(By.id("menu_admin_viewSkills")).click();	
			R1.TakeScreenShotAuto(driver,"Skills click","Pass");
			
			findElement(By.id("btnAdd")).click();	
			R1.TakeScreenShotAuto(driver,"AddSkills click","Pass");
			
			findElement(By.id("skill_name")).sendKeys("java7");	
			R1.TakeScreenShotAuto(driver,"Skillname ","Pass");
			
			findElement(By.id("skill_description")).sendKeys("java7Desr");	
			R1.TakeScreenShotAuto(driver,"SkillDesr ","Pass");
			
			
			
			findElement(By.id("btnSave")).click();	
			R1.TakeScreenShotAuto(driver,"btnsave click","Pass");
		   
	   }
	   
	  // public void CloseBrowser()throws Exception{
		   
		//   driver.quit();
	//   }
		 
	   
	
	// Draws a red border around the found element. Does not set it back anyhow.
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












