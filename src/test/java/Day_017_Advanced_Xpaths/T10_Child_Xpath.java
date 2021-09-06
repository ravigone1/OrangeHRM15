package Day_017_Advanced_Xpaths;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class T10_Child_Xpath {
	static WebDriver driver;
  @Test
  public void Xpath2() throws Exception{
	  
	  
driver = TestBrowser.OpenChromeBrowser();
	  
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	  
	  
	//*[@id="txtUsername"] //webElement of ChildXpath
	   
	//for Parent WebELment
	  
	//*[@id="txtUsername"]//parent::div
	//*[@id="txtUsername"]//parent::div
	  
	//*[@id="txtPassword"]
	//*[@id="txtPassword"]//parent::div
	  
	//*[@id="btnLogin"]
	//*[@id="btnLogin"]//parent::div
    	
	 // <input name="txtPassword" id="txtPassword" autocomplete="off" type="password">
	  //input[@id = 'txtPassword'] 
	 
	  
	  findElement(By.xpath("//*[@id='txtUsername']//parent::div[1]"));
	  Thread.sleep(1000);
	  findElement(By.xpath("//*[@id='txtUsername']")).sendKeys("Admin"); // username
	  
	  
	
	 
	  
	  findElement(By.xpath("//input[@id = 'txtPassword']//parent::div[1]"));
	  Thread.sleep(1000);
	  findElement(By.xpath("//*[@id='txtPassword']")).sendKeys("admin123");;
	  
	  
	 	  
	  
	  
	  findElement(By.xpath("//*[@id='btnLogin']//parent::div[1]"));
	  Thread.sleep(1000);
	  findElement(By.xpath("//*[@id='btnLogin']")).click();
	  
	  
	  
	 
	  
	  
	  findElement(By.xpath("//*[text() = 'Admin']"));
	  findElement(By.xpath("//*[text() = 'Admin']//following::b[1]")).click();
	  findElement(By.xpath("//*[text() = 'Employee List']")).click();
	
	  
	  
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