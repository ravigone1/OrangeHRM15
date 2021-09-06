package Day_020_PageObject_Model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Skills_Page {
	static WebDriver driver;
	
	
	public void Add_Skills(WebDriver driver) {
		this.driver = driver;
	}
	
  @Test
  public void Skills() throws Exception {
	  
	  findElement(By.id("menu_admin_viewAdminModule")).click();
	  findElement(By.id("menu_admin_Qualifications")).click();
	  findElement(By.id("menu_admin_viewSkills")).click();
	  findElement(By.id("btnAdd")).click();
	  findElement(By.id("skill_name")).sendKeys("Java");
	  findElement(By.id("skill_description")).sendKeys("JavaDesr");
	  
	  
	  
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
