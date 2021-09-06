package Day_002_Parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Non_Static_Method {
	
	WebDriver driver;
	
	public  WebElement findElement(By by) throws Exception 
	{

		WebElement elem = driver.findElement(by);  
		
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		return elem;
	
		}
	
	
	public void openchromeBrowser() throws Exception
	{
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
	}
	
	
	
	public void openorangeHRM() throws Exception
	{
		driver.get("https://opensource-demo.orangehrmlive.com/");	
	}
	
	
	
	public void Login() throws Exception
	{
		findElement(By.id("txtUsername")).sendKeys("Admin");
		findElement(By.id("txtPassword")).sendKeys("admin123");
		findElement(By.id("btnLogin")).click();	
	}
	
	
	
	public void Add_jobs() throws Exception
	{
		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_Job")).click();
		findElement(By.id("menu_admin_viewJobTitleList")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("jobTitle_jobTitle")).sendKeys("Admin101");
		findElement(By.id("jobTitle_jobDescription")).sendKeys("Admin101");
		findElement(By.id("jobTitle_note")).sendKeys("Admin101");
		findElement(By.id("btnSave")).click();
	}
	
	
	
	public void close_Browser() throws Exception
	{
	driver.quit();	
	}
	
	
  @Test
  public void Job_details() throws Exception {
	  
	  Non_Static_Method	T12=new Non_Static_Method();
	  T12.openchromeBrowser();
	  T12.openorangeHRM();
	  T12.Login();
	  T12.Add_jobs();
	  T12.close_Browser();
	  
	  
  }
}
