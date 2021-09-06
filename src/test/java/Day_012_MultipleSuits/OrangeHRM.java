package Day_012_MultipleSuits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class OrangeHRM {
	
	WebDriver driver;
	
  @Test
  public void Browser() throws Exception {
	  
	    driver = TestBrowser.OpenChromeBrowser();
	  
	    driver.get("https://opensource-demo.orangehrmlive.com/");
	  
	    driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
	 
  }
}
