package Day_017_Advanced_Xpaths;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class T12_desendant_Xpath {
	static WebDriver driver;
  @Test
  public void Xpath2() throws Exception{
	  
	  
driver = TestBrowser.OpenChromeBrowser();
	  
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	  
	  
	
	//*[@id="divUsername"]
	//*[@id="divUsername"]//child::input[]
	//*[@id="divUsername"]//child::input[1]
	//*[@id="divUsername"]//child::span[1] 
	  
	  
	//*[@id="divPassword"]
	//*[@id="divPassword"]//child::input[1]
	  
	//*[@id="divLoginButton"]                                    //desendant is Synonym of Desendant//
	
	  
	  findElement(By.xpath("//*[@id='divUsername']"));
	 // findElement(By.xpath("//*[@id='divUsername']//desendant::input[1]"));
	  Thread.sleep(1000);
	  findElement(By.xpath("//*[@id='divUsername']//descendant::input[1]")).sendKeys("Admin");
	  
	  
	  findElement(By.xpath("//*[@id='divPassword']"));
	 // findElement(By.xpath("//*[@id='divPassword']//desendant::input[1]"));
	  Thread.sleep(1000);
	  findElement(By.xpath("//*[@id='divPassword']//descendant::input[1]")).sendKeys("admin123");
	  
	  
	  findElement(By.xpath("//*[@id='divLoginButton']"));
	  Thread.sleep(1000);
	  findElement(By.xpath("//*[@id='divLoginButton']//descendant::input[1]")).click();
	 
	 
	  
	  
	  findElement(By.xpath("//*[text() = 'Admin']"));
	  findElement(By.xpath("//*[text() = 'Admin']//following::b[1]")).click();
	  findElement(By.xpath("//*[text() = 'Employee List']")).click();
	
	  
	  
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