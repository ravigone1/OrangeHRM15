package Day_017_Advanced_Xpaths;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class T07_Fallowing_Xpath2 {
	static WebDriver driver;
  @Test
  public void Xpath2() throws Exception{
	  
	  
driver = TestBrowser.OpenChromeBrowser();
	  
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	  
	  
	 // <input name="txtUsername" id="txtUsername" type="text">   Copy Element	  
	 // <input name="txtPassword" id="txtPassword" autocomplete="off" type="password">
	  //<input type="submit" name="Submit" class="button" id="btnLogin" value="LOGIN">
	  
	//*[@id="txtUsername"]
	//*[@id="txtUsername"]//following::input   1 of 2 are following
	// For Password://*[@id=\"txtUsername\"]//following::input[1]
	// For LOgin: //*[@id=\"txtUsername\"]//following::input[2] 
	  
	  
	//*[@id="menu_admin_viewAdminModule"]/b
	//*[text() = 'Admin']//following::b  1 of 10 are following
	  
	  driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
	  driver.findElement(By.xpath("//*[@id=\"txtUsername\"]//following::input[1]")).sendKeys("admin123");
	  driver.findElement(By.xpath("//*[@id=\"txtUsername\"]//following::input[2]")).click();
	  
	  driver.findElement(By.xpath("//*[text() = 'Admin']"));
	  driver.findElement(By.xpath("//*[text() = 'Admin']//following::b[1]")).click();
	  driver.findElement(By.xpath("//*[text() = 'Employee List']")).click();
	//*[@id="menu_pim_viewEmployeeList"]
	 
	  
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