package Day_003_Locators;

import CommonUtil.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC01_Id {
	
	static WebDriver driver;
  @Test
  public void Test_id() throws Exception
  {

	  
	  driver = TestBrowser.OpenChromeBrowser();
	  
	 // System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		//driver =new ChromeDriver();
		//driver.manage().window().maximize() ;	
		
		
		String Test_URL="https://opensource-demo.orangehrmlive.com/";
		driver.get(Test_URL);
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
		
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
