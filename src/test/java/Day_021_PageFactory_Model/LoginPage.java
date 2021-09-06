package Day_021_PageFactory_Model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginPage {
	
	static WebDriver driver;
	
	public void LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		  
	  }
	
	@FindBy(id ="txtUsername")
	WebElement txtUsername1;
	
	@FindBy(id = "txtPassword")
	WebElement txtPassword1;
	
	@FindBy(id = "btnLogin")
	WebElement btnLogin1;

	
	
  public void LoginPage() {
	  
	  txtUsername1.sendKeys("Admin");
	  txtPassword1.sendKeys("admin123");
	  btnLogin1.click();
	  
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


