package Day_017_Advanced_Xpaths;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class T08_Preceding_Xpath {
	static WebDriver driver;
  @Test
  public void Xpath2() throws Exception{
	  
	  
driver = TestBrowser.OpenChromeBrowser();
	  
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	  
	  
	
	//*[@id="btnLogin"]-----preceeding of 
	  
	 // <input type="submit" name="Submit" class="button" id="btnLogin" value="LOGIN">
	  //input[@id = 'btnLogin']
	  
	
	  
	  driver.findElement(By.xpath("//input[@id = 'btnLogin']//preceding::input[2]")).sendKeys("Admin");
	  driver.findElement(By.xpath("//input[@id = 'btnLogin']//preceding::input[1]")).sendKeys("admin123");
	  driver.findElement(By.xpath("//input[@id = 'btnLogin']")).click();
	  
	  driver.findElement(By.xpath("//*[text() = 'Admin']"));
	  driver.findElement(By.xpath("//*[text() = 'Admin']//following::b[1]")).click();
	  driver.findElement(By.xpath("//*[text() = 'Employee List']")).click();
	
	 
	  
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