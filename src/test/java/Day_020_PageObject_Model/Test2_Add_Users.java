package Day_020_PageObject_Model;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import CommonUtil.*;
public class Test2_Add_Users {
	
	static WebDriver driver;
	
	
	@BeforeTest
	
	public void Browser()throws Exception{
		driver =TestBrowser.OpenChromeBrowser();
		String TestURL = "https://opensource-demo.orangehrmlive.com/";
		driver.get(TestURL);
	}
	
	
	
  @Test
  public void AddUsers() throws Exception{
	  
	  
		 
		  
		  Login_Page L1 = new Login_Page();
		  L1.LoginPage(driver);
		  L1.Login();
		  
		  UsersPage U1 =new UsersPage();
		  U1.Users(driver);
		  U1.AddUsers();
		  
		 
		  Home_Page H1 = new  Home_Page();
		  H1.HomePage(driver);
		  H1.LogOut();
	  }
		  
	 
  
  //public void CloseBrowser() throws Exception{
	 // driver.quit();
  //}
  
 
  
  
  
}
