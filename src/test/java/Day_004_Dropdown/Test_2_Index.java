package Day_004_Dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Test_2_Index {
	
	static WebDriver driver;
	
  @Test
  public void Drop_down() throws Exception {
	 	
	System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	driver =new ChromeDriver();
	driver.manage().window().maximize() ;
	String TestURL = "https://opensource-demo.orangehrmlive.com/";
	driver.get(TestURL);
	
	 
    		
  		  findElement(By.id("txtUsername")).sendKeys("Admin");
  			findElement(By.id("txtPassword")).sendKeys("admin123");
  			findElement(By.id("btnLogin")).click();  
  	


     
    	 findElement(By.linkText("Admin")).click();
 		findElement(By.linkText("Organization")).click();
 		findElement(By.linkText("Locations")).click();
 		
 		findElement(By.id("searchLocation_name")).sendKeys("NEWYork");
 		findElement(By.id("searchLocation_city")).sendKeys("New Castle");
 		
 		driver.findElement(By.id("btnAdd")).click(); 
		driver.quit();  
	  
	  	
		
		
		Select dropdown = new Select(driver.findElement(By.id("location_country")));
		
		dropdown.selectByIndex(07);
		
	
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
