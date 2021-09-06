package Day_020_PageObject_Model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Home_Page {
	
	static WebDriver driver;
	
	public void HomePage(WebDriver driver) {
	
		this.driver = driver;
		
	}
 
  public void LogOut() throws Exception{
	  
	  findElement(By.id("welcome")).click();
	  Thread.sleep(1000);
	  findElement(By.linkText("Logout")).click();
	   	  
  }
  
  public   WebElement findElement(By by) throws Exception 
 	{

 		WebElement elem = driver.findElement(by);  
 		
 		if (driver instanceof JavascriptExecutor) 
 		{
 		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
 	 
 		}
 		return elem;
 	}
  
  
  
}
