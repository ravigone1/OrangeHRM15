package Day_013_Waits;

import CommonUtil.*;
import Day_010_TestNG_Paraneters1.Reporter1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Test04_Thread_Sleep {
	
	
	static WebDriver driver;
	static Reporter1 R1;
	
  @Test
  public static void Implicit() throws Exception {

	  
	  
	  
	  Test04_Thread_Sleep.openBrowser();
	  Test04_Thread_Sleep.openOrangeHRM();
	  Test04_Thread_Sleep.Login();
	  Test04_Thread_Sleep.AddLocations();
	  Test04_Thread_Sleep.Logout();
	  Test04_Thread_Sleep.CloseBrowser();
	  
	  
  }
	  
	  public static void openBrowser() throws Exception {
		  
		  driver= TestBrowser.OpenChromeBrowser();
		  
		  
		  //driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		  String str = "TC01_Implicit_Wait";
		  R1 = new Reporter1(driver,str);
		  
		 
	  }
	  
	  
	  public static void openOrangeHRM() throws Exception{
		  
		  String TestURL = "https://opensource-demo.orangehrmlive.com/";
			driver.get(TestURL);
			 R1.TakeScreenShotAuto(driver,"Open OrangeHRM","Pass");
	  }
	  
	  
	  public static void Login() throws Exception {
		  
		  findElement(By.id("txtUsername")).sendKeys("Admin");
		  findElement(By.id("txtPassword")).sendKeys("admin123");
		  findElement(By.id("btnLogin")).click();
		  R1.TakeScreenShotAuto(driver,"Pass LoginDetails","Pass");
		  
	  }
	  
	  public static void AddLocations() throws Exception {
		  
		  findElement(By.linkText("Admin")).click();
		  findElement(By.linkText("Organization")).click();
		  findElement(By.linkText("Locations")).click();
		  findElement(By.id("searchLocation_name")).sendKeys("Warangal");
		  findElement(By.id("searchLocation_city")).sendKeys("Paravathagir");
		  
		  Select dropdown = new Select(driver.findElement(By.id("searchLocation_country")));
			
			dropdown.selectByVisibleText("India");
			
			findElement(By.id("btnAdd")).click();
			 R1.TakeScreenShotAuto(driver,"AddLoctions","Pass");
			
		  
	  }
	  
	  public static void Logout() throws Exception {
		  
		  findElement(By.id("welcome"));
		  R1.TakeScreenShotAuto(driver,"Welcome Clicked","Pass");
		  findElement(By.id("welcome")).click();
		  
		  Thread.sleep(1000);                                  // 1Sec is 1000 milli seconds//
		  
		  findElement(By.linkText("Logout")).click();
			 R1.TakeScreenShotAuto(driver,"Logout","Pass");
		  
	  }
	  
	  public static void CloseBrowser() throws Exception {
		  
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

