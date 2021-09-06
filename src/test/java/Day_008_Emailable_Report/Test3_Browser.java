package Day_008_Emailable_Report;

import CommonUtil.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test3_Browser {
	
	static WebDriver driver;
	
	@Parameters({"Browser"})
	@BeforeTest
  public void OpenBrowser(String Browser) throws Exception{
		

		if(Browser.equalsIgnoreCase("Chrome"))
		{
			driver = TestBrowser.OpenChromeBrowser();
	    }
		 
		 
		 if(Browser.equalsIgnoreCase("Firefox"))
		 {
			 driver = TestBrowser.OpenFirefoxBrowser();
		 } 
	}
  @Test
  public void Login() throws Exception{
	  
	  
	  String TestURL = "https://opensource-demo.orangehrmlive.com/";
		driver.get(TestURL);
	    Reporter.log("Pass- open Orangehrm");

	  driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	  Reporter.log("Pass Admin");
	  
	  driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	  Reporter.log("Pass Password");
	  
	  driver.findElement(By.name("Submit")).click();
	  Reporter.log("Pass Submit Button");  
	  
	  
	  Test3_Browser T1 = new Test3_Browser();
	  T1.AddNationaliy();
	  
	  }
	  

      public void AddNationaliy() throws Exception{
	 
	  driver.findElement(By.id("menu_admin_viewAdminModule")).click();
	  Reporter.log("Pass Admin");
	  
	  driver.findElement(By.id("menu_admin_nationality")).click();
	  Reporter.log("Pass Nationality");
	  
	  driver.findElement(By.id("btnAdd")).click();
	  Reporter.log("Pass AddBtn");
	  
	  
	  driver.findElement(By.id("nationality_name")).sendKeys("indian12");
	  Reporter.log("Pass nationality Name");
	  
	  driver.findElement(By.id("btnSave")).click();
	  Reporter.log("Pass Save");
	  
      }
      
      @AfterTest
      public void closeBrowser ()throws Exception
      {
      driver.close();
      }
      
	
      
} 

