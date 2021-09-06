package Day_010_Katalon_Recorder;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class Test0 {
	
	static WebDriver driver;
	
  @Test
  public void Katalon() throws Exception{
	  
	  
			  
	    driver = TestBrowser.OpenChromeBrowser();
		 
			  
	    driver.get("https://opensource-demo.orangehrmlive.com/");
	    
	    
	    findElement(By.id("txtUsername")).click(); 
	    findElement(By.id("txtUsername")).clear();
	    findElement(By.id("txtUsername")).sendKeys("Admin");
	    findElement(By.id("txtPassword")).click();
	    findElement(By.id("txtPassword")).clear();
	    findElement(By.id("txtPassword")).sendKeys("admin123");
	    findElement(By.id("btnLogin")).click();
	    
	    
	    findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']/b")).click();
	    findElement(By.id("menu_admin_nationality")).click();
	    findElement(By.id("btnAdd")).click();
	    
	    findElement(By.id("nationality_name")).click();
	    findElement(By.id("nationality_name")).clear();
	    findElement(By.id("nationality_name")).sendKeys("Indian367");
	    findElement(By.id("btnSave")).click();
	    
	    findElement(By.id("welcome")).click();
	    findElement(By.linkText("Logout")).click();
	   
	    
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