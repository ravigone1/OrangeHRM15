package Day_003_Locators;

import CommonUtil.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.*;

import CommonUtil.TestBrowser;

public class TC05_LinkText {
	
	
	static WebDriver driver;
	
	public static String  UserName="txtUsername";
	public static String  Password="admin123";

	 
  @Test
  public  void Test_xpath() throws Exception {
		
	  TC05_LinkText T1 = new TC05_LinkText();
	  T1.OpenChromeBrowser();
	  T1.OpenOrangeHRM();
	  T1.Login(UserName,Password);
	  T1.Admin();
	  T1.close_Browser();
  }
  
      public  void OpenChromeBrowser() throws Exception {
	 
	  driver = TestBrowser.OpenChromeBrowser();
  }
  
  
     public  void OpenOrangeHRM() throws Exception {
	
	 String Test_URL="https://opensource-demo.orangehrmlive.com/";
		driver.get(Test_URL);
	  
  }
  
  
     public  void Login(String UserName1,String Password1) throws Exception {
	 findElement(By.id("txtUsername")).sendKeys("Admin");
	 findElement(By.id("txtPassword")).sendKeys("admin123");
	 findElement(By.name("Submit")).click();
  
}
  

     public  void Admin() throws Exception {
    
 	 findElement(By.linkText("Admin")).click();
	 findElement(By.partialLinkText("Organiz")).click(); 
	 
	 
 }
  

     public void close_Browser() throws Exception
{
driver.quit();	
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
