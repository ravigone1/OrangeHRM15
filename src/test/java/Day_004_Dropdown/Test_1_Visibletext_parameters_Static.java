package Day_004_Dropdown;

import CommonUtil.*;
import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Test_1_Visibletext_parameters_Static {
	
	static WebDriver driver;
	
	static String UserName="Admin";

	static String Password="admin123";
	static String Test_URL="https://opensource-demo.orangehrmlive.com/";
	static String Name ="Ravinder";
	static String State ="Telanga";
	static String Country ="India";
  @Test
  public static void Drop_down() throws Exception
  {
	  
	  
	  Test_1_Visibletext_parameters_Static.OpenChromeBroswer();
	  Test_1_Visibletext_parameters_Static.OpenorangeHRM(Test_URL);
	  Test_1_Visibletext_parameters_Static.login(UserName,Password);
	  Test_1_Visibletext_parameters_Static.Admin();
	  Test_1_Visibletext_parameters_Static.Details(Name,State);
	  Test_1_Visibletext_parameters_Static.Country(Country);
  }
	  public static  void OpenChromeBroswer() throws Exception
	  {
		  driver = TestBrowser.OpenChromeBrowser();
	  }
	  
	  
	  public static void OpenorangeHRM(String Test_URL1) throws Exception
	  {
		  
			driver.get(Test_URL1);  
	  }
	  
	  
	  public static void login(String UserName1,String Password1) throws Exception
	  {
		  findElement(By.id("txtUsername")).sendKeys(UserName1);
			findElement(By.id("txtPassword")).sendKeys(Password1);
			findElement(By.id("btnLogin")).click(); 
	  }

  
		public static void Admin()throws Exception{
			
			findElement(By.linkText("Admin")).click();
			findElement(By.linkText("Organization")).click();
			findElement(By.linkText("Locations")).click();
			
			
			driver.findElement(By.id("btnAdd")).click();
		}
		
		
		
		public static void Details(String Name1,String State1 ) throws Exception
		{
			findElement(By.id("location_name")).sendKeys(Name1);
			findElement(By.id("location_province")).sendKeys(State1);
		}
		
		public static void Country(String Name1)throws Exception
		{
			Select dropdown = new Select(driver.findElement(By.id("location_country")));
			
			dropdown.selectByVisibleText("India");
			
			findElement(By.id("btnSave")).click();
		}
				
		
  
		public static  WebElement findElement(By by) throws Exception 
		{

			WebElement elem = driver.findElement(by);  
			
			if (driver instanceof JavascriptExecutor) 
			{
			 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
		 
			}
			return elem;
  
  }
  
}
