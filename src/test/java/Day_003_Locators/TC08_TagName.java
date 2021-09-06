package Day_003_Locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC08_TagName {
	
	static  WebDriver driver;
	
	
  @Test
 public void test_tagname()throws Exception {
	  
	  
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;
		
		String TestURL = "https://opensource-demo.orangehrmlive.com/";
		driver.get(TestURL);
		
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
		//List<WebElement> links=  driver.findElements(By.tagName("a"));	
		//int links_count= links.size();
		//System.out.println("Number of hyperlinks "+links_count);
		
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
	
		driver.findElement(By.id("menu_admin_UserManagement"));

		List<WebElement> links=  driver.findElements(By.tagName("a"));	
		int links_count= links.size();
		System.out.println("Number of hyperlinks "+links_count);
		
	
	
		
		
	}
		
  }

