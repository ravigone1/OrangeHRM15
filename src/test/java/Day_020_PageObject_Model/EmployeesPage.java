package Day_020_PageObject_Model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class EmployeesPage {
	
	static WebDriver driver;
	
	
	public void  Add_Employe(WebDriver driver)
    
	{
	 
		this.driver = driver;
	}
 
    public void Add_Employee()throws Exception{
	  
	  findElement(By.id("menu_pim_viewPimModule")).click();
	  findElement(By.id("menu_pim_addEmployee")).click();
	  findElement(By.id("firstName")).sendKeys("Gone");
	  findElement(By.id("middleName")).sendKeys("Null");
	  findElement(By.id("lastName")).sendKeys("Ravinder");
	  
	  
	   String Photo = "C:\\Users\\HP\\Desktop\\1";
	   WebElement Upload =findElement(By.xpath("//*[@id=\"photofile\"]"));
	   Upload.sendKeys(Photo);
	   
	   findElement(By.id("chkLogin")).click();
	   findElement(By.id("btnSave")).click();
	   
	  
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
