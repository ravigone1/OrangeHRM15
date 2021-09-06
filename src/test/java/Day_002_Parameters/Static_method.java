package Day_002_Parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Static_method {
	
	static WebDriver driver;
	
	public  WebElement findElement(By by) throws Exception 
	{

		WebElement elem = driver.findElement(by);  
		
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		return elem;
	
		}
	
	
	public static void openchromeBrowser() throws Exception
	{
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
	}
	
	
	
	public static void openorangeHRM() throws Exception
	{
		driver.get("https://opensource-demo.orangehrmlive.com/");	
	}
	
	
	
	public static void Login() throws Exception
	{
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();	
	}
	
	
	
	public static void Add_jobs() throws Exception
	{
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		driver.findElement(By.id("menu_admin_Job")).click();
		driver.findElement(By.id("menu_admin_viewJobTitleList")).click();
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("jobTitle_jobTitle")).sendKeys("java_core");
		driver.findElement(By.id("jobTitle_jobDescription")).sendKeys("java_core_desr");
		driver.findElement(By.id("jobTitle_note")).sendKeys("javanote");
		driver.findElement(By.id("btnSave")).click();
	}
	
	
	
	public static void close_Browser() throws Exception
	{
	driver.quit();	
	}
	
	
  @Test
  public void Job_details() throws Exception {
	  

	  Static_method.openchromeBrowser();
	  Static_method.openorangeHRM();
	  Static_method.Login();
	  Static_method.Add_jobs();
	  Static_method.close_Browser();
	  
	  
  }
}
