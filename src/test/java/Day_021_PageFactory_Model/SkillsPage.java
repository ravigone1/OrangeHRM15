package Day_021_PageFactory_Model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SkillsPage {
	static WebDriver driver;
	
	
	public void Skills(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(id ="menu_admin_viewAdminModule")
	WebElement menu_admin_viewAdminModule1;
	
	@FindBy(id ="menu_admin_Qualifications")
	WebElement menu_admin_Qualifications1;
	
	@FindBy(id ="menu_admin_viewSkills")
	WebElement menu_admin_viewSkills1;
	
	@FindBy(id ="btnAdd")
	WebElement btnAdd1;
	
	@FindBy(id ="skill_name")
	WebElement skill_name1;
	
	
	@FindBy(id ="skill_description")
	WebElement skill_description1;
	
	@FindBy(id ="btnSave")
	WebElement btnSave1;
	
	
	

  public void Skills() {
	  
	  menu_admin_viewAdminModule1.click(); 
	  menu_admin_Qualifications1.click();
	  menu_admin_viewSkills1.click();
	  btnAdd1.click();
	  skill_name1.sendKeys("Tutor1");
	  skill_description1.sendKeys("Tutor1Desr");
	  btnSave1.click();
	  
	  
	  
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
