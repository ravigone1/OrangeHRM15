package Day_015_JavaScriptExecutor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SendKeys_4 {
	
	static WebDriver driver;
	
  @Test
  public void Test_1() throws Exception{
	  
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  
	  driver.get(" https://opensource-demo.orangehrmlive.com/");
	  
	  
	  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	  
	    WebElement UserName=findElement(By.name("txtUsername"));
		WebElement Password =findElement(By.name("txtPassword"));
		WebElement BtnLogin =findElement(By.name("Submit"));
		
		
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value','Admin')",UserName);
		js.executeScript("arguments[0].setAttribute('value','admin123')",Password);
		js.executeScript("arguments[0].click()",BtnLogin);
	  
		
		
		
		WebElement part1 = findElement(By.linkText("Performance")); 
		WebElement part2 = findElement(By.linkText("Employee Trackers"));
		
		
		js.executeScript("arguments[0].click()",part1);
		js.executeScript("arguments[0].click()",part2);
		
		
	  
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
