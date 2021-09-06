package Day_010_Katalon_Recorder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class Test2 {
	
	static WebDriver driver;
	
	
	@BeforeTest
	 public void OpenChromeBrowser() throws Exception
	 {
		  
		driver = TestBrowser.OpenChromeBrowser();
	  }
	 
	  
	  
	  public void OpenOrangeHRM() throws Exception {
		  
		  driver.get("https://opensource-demo.orangehrmlive.com/");
	  }
	
	
	
	
  @Test
  public void Katalon() throws Exception { 
	  
	  Test2 T1 = new Test2();
	  T1.OpenChromeBrowser();
	  T1.OpenOrangeHRM();
	  T1.Login();
	  T1.JobTitles();
	  T1.JobDescription();
	  T1.JobNote();
	 // T1.CloseBrowser();
	 
	  
  }
     
	  public void Login ()throws Exception {
		  
		    driver.findElement(By.id("txtUsername")).click();
		    driver.findElement(By.id("txtUsername")).clear();
		    driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		    Reporter.log("Pass Admin");
		    driver.findElement(By.id("txtPassword")).click();
		    driver.findElement(By.id("txtPassword")).clear();
		    driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		    Reporter.log("Pass Pswd");
		    driver.findElement(By.id("btnLogin")).click();
		  
		    
	  }
	  
	  public void JobTitles() throws Exception {
		  
		    driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']/b")).click();
		    driver.findElement(By.id("menu_admin_Job")).click();
		    driver.findElement(By.id("menu_admin_viewJobTitleList")).click();
		    driver.findElement(By.id("btnAdd")).click();
		    driver.findElement(By.id("jobTitle_jobTitle")).click();
		    driver.findElement(By.id("jobTitle_jobTitle")).clear();
		    driver.findElement(By.id("jobTitle_jobTitle")).sendKeys("Python");
		    Reporter.log("Pass JobTitle");
	  }
	  
	  
	  
	  public void JobDescription() throws Exception {
		  
		  driver.findElement(By.id("jobTitle_jobDescription")).click();
		    driver.findElement(By.id("jobTitle_jobDescription")).clear();
		    driver.findElement(By.id("jobTitle_jobDescription")).sendKeys("Python Description");
		    Reporter.log("Pass Job Desr");
	  }
		  
	  
		  public void JobNote() throws Exception {
			  
			  
			    driver.findElement(By.id("jobTitle_note")).click();
			    driver.findElement(By.id("jobTitle_note")).clear();
			    driver.findElement(By.id("jobTitle_note")).sendKeys("Python note");
			    Reporter.log("Pass Job Note");
			    
			    driver.findElement(By.id("btnSave")).click();
			    
		  }
		  
	  @AfterTest
	  
	  public void CloseBrowser() throws Exception {
		  
		  
		  driver.quit();
	  }
}
