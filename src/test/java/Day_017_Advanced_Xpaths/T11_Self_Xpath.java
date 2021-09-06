package Day_017_Advanced_Xpaths;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class T11_Self_Xpath {
	static WebDriver driver;
  @Test
  public void Xpath2() throws Exception{
	  
	  
driver = TestBrowser.OpenChromeBrowser();
	  
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	  
	  
	//Actually wont use self keyword//
	 
	  
	 
	  findElement(By.xpath("//input[@id='txtUsername']//self::input")).sendKeys("Admin"); // username
	  
	  findElement(By.xpath("//input[@id='txtPassword']//self::input")).sendKeys("admin123");//Password
	  
	  findElement(By.xpath("//input[@id='btnLogin']//self::input")).click();
	  
	  
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