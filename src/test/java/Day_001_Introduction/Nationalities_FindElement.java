package Day_001_Introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Nationalities_FindElement {
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
	

	public void orangeHRM() throws Exception
	{
		driver.get("https://opensource-demo.orangehrmlive.com/");	
	}
	
	public void Login_details() throws Exception
	{
		findElement(By.id("txtUsername")).sendKeys("Admin");
		findElement(By.id("txtPassword")).sendKeys("admin123");
		findElement(By.id("btnLogin")).click();	
	}
	
	
	public void Nationals() throws Exception
	{
		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_nationality")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("nationality_name")).sendKeys("java9");
		findElement(By.id("btnSave")).click();	
	}
	
	
	public void CloseBrowser() throws Exception
	{
		driver.quit();
	}
	
	
	
  @Test
  public void Nationality() throws Exception {
	  
	  	
	  Nationalities_FindElement T16 =new Nationalities_FindElement();
	  T16.openchromeBrowser();
	  T16.orangeHRM();
	  T16.Login_details();
	  T16.Nationals();
	  T16.CloseBrowser();
		
		
	  
  }
}
