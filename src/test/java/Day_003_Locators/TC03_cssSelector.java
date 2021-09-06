package Day_003_Locators;
import CommonUtil.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC03_cssSelector {
	
	static WebDriver driver;
  @Test
  public void Test_selector()throws Exception{
	  
	 System.setProperty("Webdriver.chrome.driver","C:\\Chromedriver_win32\\chromedriver.exe");
	  driver =new ChromeDriver();
	  driver.manage().window().maximize();
	 
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	  
	    findElement(By.cssSelector("input#txtUsername")).sendKeys("Admin");
		findElement(By.cssSelector("input#txtPassword")).sendKeys("admin123");
		findElement(By.cssSelector("input#txtLoginbutton")).click();
    
  	    
    
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
