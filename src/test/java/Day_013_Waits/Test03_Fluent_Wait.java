package Day_013_Waits;

import CommonUtil.*;
import Day_010_TestNG_Paraneters1.Reporter1;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.common.base.Function;

public class Test03_Fluent_Wait {
	
	
	static WebDriver driver;
	static Reporter1 R1;
	
  @Test
  public static void Implicit() throws Exception {

	  
	  
	  
	  Test03_Fluent_Wait.openBrowser();
	  Test03_Fluent_Wait.openOrangeHRM();
	  Test03_Fluent_Wait.Login();
	  Test03_Fluent_Wait.AddLocations();
	  Test03_Fluent_Wait.Logout();
	  Test03_Fluent_Wait.CloseBrowser();
	  
	  
  }
	  
	  public static void openBrowser() throws Exception {
		  
		  driver= TestBrowser.OpenChromeBrowser();
		  
		  
		 // driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		  String str = "TC03_Fluent_Wait";
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
		  
		  
		  findElement(By.id("welcome")).click();
		  
		  
		  Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	      .withTimeout(120,TimeUnit.SECONDS)
		  .pollingEvery(40,TimeUnit.SECONDS)
		  .ignoring(NoSuchElementException.class);
		 
		WebElement logout1 = wait.until(new Function<WebDriver,WebElement>(){
			
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//*[@id=\"welcome-menu\"]/ul/li[3]/a"));
			}
		});
		  
		 
		  findElement(By.xpath("//*[@id=\"welcome-menu\"]/ul/li[3]/a"));
			 R1.TakeScreenShotAuto(driver,"Clicked on Logout","Pass");
			 logout1.click();
		  
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

