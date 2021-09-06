package Day_020_PageObject_Model;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import CommonUtil.*;
public class Test1_Add_Employes {
	
	static WebDriver driver;
	
	
	@BeforeTest
	
	public void Browser()throws Exception{
		driver =TestBrowser.OpenChromeBrowser();
		String TestURL = "https://opensource-demo.orangehrmlive.com/";
		driver.get(TestURL);
	}
	
	
	
  @Test
  public void AddEmployes() throws Exception{
	  
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  
	  Login_Page L1 = new Login_Page();
	  L1.LoginPage(driver);
	  L1.Login();
	  
	  EmployeesPage E1 =new EmployeesPage();
	  E1.Add_Employe(driver);
	  E1.Add_Employee();
	  
	  Home_Page H1 = new  Home_Page();
	  H1.HomePage(driver);
	  H1.LogOut();

	  
	  
  }
  
  public void CloseBrowser() throws Exception{
	  driver.quit();
  }
  
 
  
  
  
}
