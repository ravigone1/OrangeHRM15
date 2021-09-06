package Day_001_Introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Add_Skills_FindElement {
	
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
		findElement(By.id("txtUsername")).sendKeys("admin");
		findElement(By.id("txtPassword")).sendKeys("admin123");
		findElement(By.id("btnLogin")).click();	
	}
	
	public void Add_skill() throws Exception
	{
		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_Qualifications")).click();
		findElement(By.id("menu_admin_viewSkills")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("skill_name")).sendKeys("java04");
		findElement(By.id("skill_description")).sendKeys("java04_desription");
		findElement(By.id("btnSave")).click();
		
		
	}
	
	
	public void closebBrowser() throws Exception
	{
		driver.quit();
	}
  @Test
  public void Skill_test() throws Exception{
  
	  	
	  Add_Skills_FindElement T13=new Add_Skills_FindElement();
	  T13.openchromeBrowser();  
	  T13.openorangeHRM();
	  T13.Login_details();
	  T13.Add_skill();
	  T13.closebBrowser();
		
  }
}
