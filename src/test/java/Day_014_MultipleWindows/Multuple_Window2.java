package Day_014_MultipleWindows;

import CommonUtil.*;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Multuple_Window2 {
	
	static WebDriver driver;
	
  @Test
  public void Test1() throws Exception{
	  
	  
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;
		driver.get("https://opensource-demo.orangehrmlive.com/");
	
	     
	  
		((JavascriptExecutor)driver).executeScript("window.open()");
		((JavascriptExecutor)driver).executeScript("window.open()");
		
		
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		
		//Switch to New tab
		driver.switchTo().window(tabs.get(1));
		driver.get("https://www.freejobalert.com/");
		
		driver.switchTo().window(tabs.get(2));
		driver.get("https://www.naukri.com/mnjuser/homepage");

		
		//back to MainWindow
		driver.switchTo().window(tabs.get(0));

		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
	    
	    driver.close();
	    driver.quit();
}
}