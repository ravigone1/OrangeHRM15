package Day_011_ParallelMethods_LAB3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class All_Tests {
	 
	
	
	@Test
	  public void Nationality() throws Exception {
		
		WebDriver driver;
		
	  
			System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
			driver =new ChromeDriver();
			driver.manage().window().maximize() ;
		
		    
			driver.get("https://opensource-demo.orangehrmlive.com/");	
		
		
		
			driver.findElement(By.id("txtUsername")).sendKeys("Admin");
			driver.findElement(By.id("txtPassword")).sendKeys("admin123");
			driver.findElement(By.id("btnLogin")).click();	
		
		
		
		
			driver.findElement(By.id("menu_admin_viewAdminModule")).click();
			driver.findElement(By.id("menu_admin_nationality")).click();
			driver.findElement(By.id("btnAdd")).click();
			driver.findElement(By.id("nationality_name")).sendKeys("Indian65");
			driver.findElement(By.id("btnSave")).click();	
		
		
			driver.quit();
		
	}
		
		
		@Test
		  public void Skill_test() throws Exception{
		  
			WebDriver driver;
		
			System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
			driver =new ChromeDriver();
			driver.manage().window().maximize() ;
			
		
			driver.get("https://opensource-demo.orangehrmlive.com/");	
		
		
			driver.findElement(By.id("txtUsername")).sendKeys("Admin");
			driver.findElement(By.id("txtPassword")).sendKeys("admin123");
			driver.findElement(By.id("btnLogin")).click();	
		
		  
				driver.findElement(By.id("menu_admin_viewAdminModule")).click();
				driver.findElement(By.id("menu_admin_Qualifications")).click();
				driver.findElement(By.id("menu_admin_viewSkills")).click();
				driver.findElement(By.id("btnAdd")).click();
				driver.findElement(By.id("skill_name")).sendKeys("java05");
				driver.findElement(By.id("skill_description")).sendKeys("java05_desription");
				driver.findElement(By.id("btnSave")).click();
				
				
				driver.quit();
			
			
		}
}