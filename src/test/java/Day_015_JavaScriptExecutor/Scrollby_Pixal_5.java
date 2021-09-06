package Day_015_JavaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Scrollby_Pixal_5 {
	
	static WebDriver driver;
	
  @Test
  public void Pixal() throws Exception{
	  
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  
	  driver.get(" https://www.amazon.in/");
	  
	  
	  
	  
	  JavascriptExecutor js = (JavascriptExecutor)driver;		
     
	  
      js.executeScript("window.scrollBy(100,1000);");	  
      
	  
	  
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
