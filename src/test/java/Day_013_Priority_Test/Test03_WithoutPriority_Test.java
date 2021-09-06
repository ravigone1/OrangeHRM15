package Day_013_Priority_Test;

import CommonUtil.*;
import Day_010_TestNG_Paraneters1.Reporter1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Test03_WithoutPriority_Test {
	
	
	static WebDriver driver;
	static Reporter1 R1;
	
	//Call by Alphabatical Order Without giving Priority 
	
	  @Test
	  public void Test1_openBrowser() throws Exception {        
		  
		  driver= TestBrowser.OpenChromeBrowser();
		  
		  String str = "TC01_Implicit_Wait";
		  R1 = new Reporter1(driver,str);
		 // driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		  
		 
	  }
	  
	  @Test 
	  public  void Test2_openOrangeHRM() throws Exception{
		  
		  String TestURL = "https://opensource-demo.orangehrmlive.com/";
			driver.get(TestURL);
			 R1.TakeScreenShotAuto(driver,"Open OrangeHRM","Pass");
	  }
	  
	  
	  @Test
	  public  void Test3_Login() throws Exception {
		  
		  findElement(By.id("txtUsername")).sendKeys("Admin");
		  findElement(By.id("txtPassword")).sendKeys("admin123");
		  findElement(By.id("btnLogin")).click();
		  R1.TakeScreenShotAuto(driver,"Pass LoginDetails","Pass");
		  
	  }
	  
	  @Test
	  public  void Test4_AddLocations() throws Exception {
		  
		  findElement(By.linkText("Admin")).click();
		  findElement(By.linkText("Organization")).click();
		  findElement(By.linkText("Locations")).click();
		  findElement(By.id("searchLocation_name")).sendKeys("Warangal1");
		  findElement(By.id("searchLocation_city")).sendKeys("Paravathagir1");
		  
		  Select dropdown = new Select(driver.findElement(By.id("searchLocation_country")));
			
			dropdown.selectByVisibleText("India");
			
			findElement(By.id("btnAdd")).click();
			 R1.TakeScreenShotAuto(driver,"AddLoctions","Pass");
			
		  
	  }
	  
	  
	  @Test
	  public  void Test5_Logout() throws Exception {
		  
		  findElement(By.id("welcome"));
		  findElement(By.id("welcome")).click();
		  
		  Thread.sleep(1000);
		  
		  findElement(By.linkText("Logout")).click();
			 R1.TakeScreenShotAuto(driver,"Logout","Pass");
		  
	  }
	  
	  @Test
	  public  void Test6_CloseBrowser() throws Exception {
		  
		  driver.quit();
		  
	  }
	  
	  public static  WebElement findElement(By by) throws Exception 
		{
					
			 WebElement elem = driver.findElement(by);    	    
			// draw a border around the found element
			 
			if (driver instanceof JavascriptExecutor) 
			{
			 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
		 
			}
			
			return elem;
		}
	  
	 
  }

