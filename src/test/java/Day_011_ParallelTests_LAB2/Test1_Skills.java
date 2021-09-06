package Day_011_ParallelTests_LAB2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Test1_Skills {
	
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
	
	public void Login_details() throws Exception
	{
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();	
	}
	
	public void Add_skill() throws Exception
	{
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		driver.findElement(By.id("menu_admin_Qualifications")).click();
		driver.findElement(By.id("menu_admin_viewSkills")).click();
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("skill_name")).sendKeys("java05");
		driver.findElement(By.id("skill_description")).sendKeys("java05_desription");
		driver.findElement(By.id("btnSave")).click();
		
		
	}
	
	
	public void closebBrowser() throws Exception
	{
		driver.quit();
	}
  @Test
  public void Skill_test() throws Exception{
  
	  	
	  Test1_Skills T13=new Test1_Skills();
	  T13.openchromeBrowser();  
	  T13.openorangeHRM();
	  T13.Login_details();
	  T13.Add_skill();
	  T13.closebBrowser();
		
  }
}
