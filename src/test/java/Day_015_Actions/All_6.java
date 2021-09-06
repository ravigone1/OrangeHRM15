package Day_015_Actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class All_6 {
	
	static WebDriver driver;
  @Test
  public void Drop() throws Exception{
	  
	  
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
		driver.get("http://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		
		WebElement DoubleClick = findElement(By.xpath("//*[@id=\"HTML10\"]/div[1]/button"));
		Actions actions = new Actions(driver);
		actions.doubleClick(DoubleClick).perform();
		
		
		WebElement Element1 = findElement(By.xpath("//*[@id=\"HTML2\"]/h2"));
		JavascriptExecutor js = (JavascriptExecutor)driver;		
	     
	    js.executeScript("arguments[0].scrollIntoView();", Element1);
	      
		
	    
		WebElement Dragging = findElement(By.xpath("//*[@id=\"draggable\"]/p"));
		WebElement Dropping = findElement(By.xpath("//*[@id=\"droppable\"]"));
		
		Actions actions1 = new Actions(driver);
		actions1.dragAndDrop(Dragging,Dropping).perform();
		
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
