package Day_014_Frames;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Switch_by_FrameName_1 {
	
	
	static WebDriver driver;
  @Test
  public void Frames_Name() throws Exception {
	  
	  Switch_by_FrameName_1.Browser();
	  Switch_by_FrameName_1.GoogleFrame();
	  Switch_by_FrameName_1.AmazonFrame();	  
	  Switch_by_FrameName_1.GoogleFrame1();
	  Switch_by_FrameName_1.Close();
  }
	  
	  
	  public static void Browser() throws Exception {
		  
		  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
			driver =new ChromeDriver();
			driver.manage().window().maximize() ;
			driver.get("http://www.bhavasri.com/Frames/AllContacts.html");  
		  
	  }
	  
	  
	  public static void GoogleFrame() throws Exception {
		  
		  driver.switchTo().frame("Google_ContactForm");
		  
		  driver.findElement(By.name("firstname")).sendKeys("Ravi1");
		  driver.findElement(By.name("lastname")).sendKeys("Gone1");
		  driver.findElement(By.name("subject1")).sendKeys("Student1");
		  
		  driver.switchTo().defaultContent();
		  
	  }
	  
	  
	  public static void AmazonFrame() throws Exception {
		  
		  driver.switchTo().frame("Amazon_ContactForm");
		  driver.findElement(By.name("firstname")).sendKeys("Ramu1");
		  driver.findElement(By.name("lastname")).sendKeys("Gone1");
		  driver.findElement(By.name("subject")).sendKeys("Student1");
		  
		  driver.switchTo().defaultContent();
		  
		  
		  
	  }
	  
          public static void GoogleFrame1() throws Exception {
		  
		  driver.switchTo().frame("Google_ContactForm");
		  
		  driver.findElement(By.name("firstname")).clear();
		  driver.findElement(By.name("firstname")).sendKeys("Ravinder");
		  
		  driver.findElement(By.name("lastname")).clear();
		  driver.findElement(By.name("lastname")).sendKeys("Gone25");
		  
		  driver.findElement(By.name("subject1")).clear();
		  driver.findElement(By.name("subject1")).sendKeys("Student16");
		  
		  driver.switchTo().defaultContent();
     }
	  
	      public static void Close() throws Exception{
		
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

