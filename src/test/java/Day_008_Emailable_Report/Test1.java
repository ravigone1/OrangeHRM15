package Day_008_Emailable_Report;

import CommonUtil.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Test1 {
	
	static WebDriver driver;
	
	  
	  public void OpenBrowser() throws Exception{
		  
		    driver = TestBrowser.OpenChromeBrowser();			
			String TestURL = "https://opensource-demo.orangehrmlive.com/";
			driver.get(TestURL);
			  Reporter.log("OpenOrangeHRM");  
	  }
	  
	  
      public void Login() throws Exception{

	  driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	  Reporter.log("Pass Admin");
	  
	  driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	  Reporter.log("Pass Password");
	  
	  driver.findElement(By.name("Submit")).click();
	  Reporter.log("Pass Submit Button");  
	  }
	  

      public void AddNationaliy() throws Exception{
	 
	  driver.findElement(By.id("menu_admin_viewAdminModule")).click();
	  Reporter.log("Pass Admin");
	  
	  driver.findElement(By.id("menu_admin_nationality")).click();
	  Reporter.log("Pass Nationality");
	  
	  driver.findElement(By.id("btnAdd")).click();
	  Reporter.log("Pass AddBtn");
	  
	  
	  driver.findElement(By.id("nationality_name")).sendKeys("indian");
	  Reporter.log("Pass nationality Name");
	  
	  driver.findElement(By.id("btnSave")).click();
	  Reporter.log("Pass Save");
	  
	  driver.quit();
	   
}




  @Test
  public void Email_1() throws Exception
  {
	 
	  
	  Test1 T1 = new Test1();
	  T1.OpenBrowser();
	  T1.Login();
	  T1.AddNationaliy();
	  
  }
} 
