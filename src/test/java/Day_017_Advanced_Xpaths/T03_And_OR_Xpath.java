package Day_017_Advanced_Xpaths;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class T03_And_OR_Xpath {
	
	static WebDriver driver;
  @Test
  public void Xpath2() throws Exception{
	  
	  
driver = TestBrowser.OpenChromeBrowser();
	  
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	  
	  
	 // <input name="txtUsername" id="txtUsername" type="text">   Copy Element
	 // for taking Id(or)name --> //input[@name = 'txtUsername']
	                              //input[@id = 'txtUsername'] any one can be taken
	  
	 // <input name="txtPassword" id="txtPassword" autocomplete="off" type="password">
	  //<input type="submit" name="Submit" class="button" id="btnLogin" value="LOGIN"> 
	 
	  
	  
	  
	  //UserName: //input[@name ='txtUsername' or @id = 'txtUsername']     //Most of Using "And" operation only not using the "Or" operation 
	  //Password: //input[@name = 'txtPassword' and @id = 'txtPassword']
	  //btnLogin: //input[@name = 'Submit' and @type = 'submit']
	  
	  driver.findElement(By.xpath("//input[@name ='txtUsername' or @id = 'txtUsername']")).sendKeys("Admin");
	  driver.findElement(By.xpath("//input[@name = 'txtPassword' and @id = 'txtPassword']")).sendKeys("admin123");
	  driver.findElement(By.xpath("//input[@name = 'Submit' and @type = 'submit']")).click();
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