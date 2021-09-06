package Day_003_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class TC06_Partial_Linktest {
	
static WebDriver driver;	

  @Test
  public void Partial_LinkTest_Test() throws Exception {
	  
	 
			 
			driver = TestBrowser.OpenChromeBrowser();
				
		    driver.get("https://opensource-demo.orangehrmlive.com/");

		    findElement(By.id("txtUsername")).sendKeys("Admin");
		    findElement(By.id("txtPassword")).sendKeys("admin123");
		    findElement(By.id("btnLogin")).click();
		    findElement(By.linkText("Admin")).click();
		    findElement(By.partialLinkText("Nationaliti")).click();
		    
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
		
		
	

