package Day_014_Frames;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Switch_by_Index_4 {
	
	
	static WebDriver driver;
  @Test
  public void Frames_Name() throws Exception {
	  
	 
		  
		  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
			driver =new ChromeDriver();
			driver.manage().window().maximize() ;
			driver.get("http://www.bhavasri.com/Frames/AllContacts.html");  
			
			List<WebElement> frames = driver.findElements(By.tagName("iFrame"));
			System.out.println("No.of Frames:" +frames.size());
			
			
		  driver.switchTo().frame(frames.get(0));			
		  driver.findElement(By.name("firstname")).sendKeys("Ravi1");
		  driver.findElement(By.name("lastname")).sendKeys("Gone1");
		  driver.findElement(By.name("subject1")).sendKeys("Student1");
		  
		  driver.switchTo().defaultContent();
		  
		  
		  
		  driver.switchTo().frame(frames.get(1));		  
		  driver.findElement(By.name("firstname")).sendKeys("Ramu1");
		  driver.findElement(By.name("lastname")).sendKeys("Gone1");
		  driver.findElement(By.name("subject")).sendKeys("Student1");
		  
		  driver.switchTo().defaultContent();
		  
		 
		  driver.switchTo().frame(frames.get(0));		 
		  driver.findElement(By.name("firstname")).clear();
		  driver.findElement(By.name("firstname")).sendKeys("Ravinder");
		  
		  driver.findElement(By.name("lastname")).clear();
		  driver.findElement(By.name("lastname")).sendKeys("Gone25");
		  
		  driver.findElement(By.name("subject1")).clear();
		  driver.findElement(By.name("subject1")).sendKeys("Student16");
		  
		  driver.switchTo().defaultContent();
     
 
		  driver.quit();
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

