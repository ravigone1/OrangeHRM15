package Day_003_Locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC08_TagName_Nonstatic {
	
	static  WebDriver driver;
	
	public void openBrowser()throws Exception
	{
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;
	}
	
	
	
public void openorangeHRM()throws Exception
{
	String TestURL = "https://opensource-demo.orangehrmlive.com/";
	driver.get(TestURL);
		
	}



public void Tag_Names()throws Exception
{

	driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	driver.findElement(By.id("btnLogin")).click();
	driver.findElement(By.id("menu_admin_viewAdminModule")).click();
	driver.findElement(By.id("menu_admin_UserManagement")).click();

}


  @Test
 public void test_tagname()throws Exception {
	  
	  TC08_TagName_Nonstatic t1=new TC08_TagName_Nonstatic();
		t1.openBrowser();
		t1.openorangeHRM();
		t1.Tag_Names();

	
		List<WebElement> links=  driver.findElements(By.tagName("a"));	
		int links_count= links.size();
		System.out.println("Number of hyperlinks "+links_count);
		
		
	}
		
  }

