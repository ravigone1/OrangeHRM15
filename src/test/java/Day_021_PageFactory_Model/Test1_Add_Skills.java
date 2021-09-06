package Day_021_PageFactory_Model;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import CommonUtil.*;
public class Test1_Add_Skills {
	
	static WebDriver driver;
	
	
	@BeforeTest
	
	public void Browser()throws Exception{
		driver =TestBrowser.OpenChromeBrowser();
		String TestURL = "https://opensource-demo.orangehrmlive.com/";
		driver.get(TestURL);
	}
	
	
	
  @Test
  public void Add_Skills() throws Exception{
	  
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  
	  LoginPage L1 = new LoginPage();
	  L1.LoginPage(driver);
	  L1.LoginPage();
	  
	  SkillsPage S1 =new SkillsPage();
	  S1.Skills(driver);
	  S1.Skills();
	  
	  HomePage H1 = new  HomePage();
	  H1.Logout(driver);
	  H1.Logout();

	  
	  
  }
  
  public void CloseBrowser() throws Exception{
	  driver.quit();
  }
  
 
  
  
  
}
