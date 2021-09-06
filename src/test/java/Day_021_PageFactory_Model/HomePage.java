package Day_021_PageFactory_Model;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class HomePage {
	static WebDriver driver;
	
	public void Logout(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy (id = "welcome")
	WebElement welcome1;
	
	@FindBy (linkText = "Logout")
	WebElement Logout1;
	
	

  public void Logout() {
	  
	  welcome1.click();
	 // driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  Logout1.click();
	  
  }
  
   public   WebElement findElement(By by) throws Exception 
	{

		WebElement elem = driver.findElement(by);  
		
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		return elem;
	}
  
  
  
  
  
  
}
