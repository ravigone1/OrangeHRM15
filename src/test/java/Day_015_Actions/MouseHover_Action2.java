package Day_015_Actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;



public class MouseHover_Action2 {
	
	static WebDriver driver;
	
	
  @Test 
  public void Mouse_Action() throws Exception{
  
  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	driver =new ChromeDriver();
	driver.manage().window().maximize() ;	
	driver.get("https://opensource-demo.orangehrmlive.com/");
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	
	
	findElement(By.name("txtUsername")).sendKeys("Admin");
	findElement(By.name("txtPassword")).sendKeys("admin123");
	findElement(By.id("btnLogin")).click();
	
	
	
	WebElement Time = findElement(By.linkText("Time"));
	WebElement Report = findElement(By.linkText("Reports"));
	WebElement Project = findElement(By.linkText("Project Reports"));
	
	
	Actions actions = new Actions(driver);
	actions.moveToElement(Time).
	moveToElement(Report).
	moveToElement(Project).click().build().perform();
	
  }
  
  
  
  public  WebElement findElement(By by) throws Exception 
	{

		WebElement elem = driver.findElement(by);  
		
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		return elem;
	}

  
  
  
}
  

