package Day_015_JavaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Scrolling_2 {
	
	static WebDriver driver;
	
  @Test
  public void Test_1() throws Exception{
	  
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  
	  driver.get(" https://www.amazon.in/");
	  
	  
	 
	  
	  WebElement Element1 = findElement(By.linkText("Sell on Amazon"));	  
	  WebElement Element2 = findElement(By.xpath("//*[@id=\"navFooter\"]/div[1]/div/div[3]/ul/li[1]/a"));
	  
	  
	  
	  JavascriptExecutor js = (JavascriptExecutor)driver;		
     
	  
      js.executeScript("arguments[0].scrollIntoView();", Element1);	  
      js.executeScript("arguments[0].scrollIntoView();", Element2);
	  
	  
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
