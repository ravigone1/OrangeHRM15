package Day_017_Advanced_Xpaths;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class T04_Text_Xpath {
	
	static WebDriver driver;
  @Test
  public void Xpath2() throws Exception{
	  
	  
driver = TestBrowser.OpenChromeBrowser();
	  
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	  
	  
	
	 
	  //*[@id="menu_admin_viewAdminModule"]/b
	  //<a href="/index.php/admin/viewAdminModule" id="menu_admin_viewAdminModule" class="firstLevelMenu"><b>Admin</b></a>
	  
	  //*[@id="menu_admin_nationality"]
	  //<a href="/index.php/admin/nationality" id="menu_admin_nationality">Nationalities</a>
	  
	  
	  //Admin:    //b[text() = 'Admin'] (or)  //*[text() = 'Admin']
	  //Nationality: //*[@id ='menu_admin_nationality'] (or) //a[text() ='Nationalities']
	  
	  driver.findElement(By.xpath("//input[@name ='txtUsername' or @id = 'txtUsername']")).sendKeys("Admin");
	  driver.findElement(By.xpath("//input[@name = 'txtPassword' and @id = 'txtPassword']")).sendKeys("admin123");
	  driver.findElement(By.xpath("//input[@name = 'Submit' and @type = 'submit']")).click();
	  driver.findElement(By.xpath("//b[text() = 'Admin']")).click();
	  driver.findElement(By.xpath("//a[text() ='Nationalities]")).click();
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