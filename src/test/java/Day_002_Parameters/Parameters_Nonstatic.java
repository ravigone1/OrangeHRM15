package Day_002_Parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Parameters_Nonstatic {
	
	static WebDriver driver;
	
	//Global variables
	
	String UserName="Admin",Password="admin123";
	String Qualification_text="student1";
	String Test_URL="https://opensource-demo.orangehrmlive.com/";
 
	
  @Test
 public void NonStatic_Paramaters_test() throws Exception
  {
	  Parameters_Nonstatic T13= new Parameters_Nonstatic();
	  T13.OpenChromeBroswer();
	  T13.OpenorangeHRM(Test_URL);
	  T13.login(UserName,Password);//step2
	  T13.Qualifications(Qualification_text);//step2
	  T13.closeBrowser();
	  
  }
	  
	  
	  public  void OpenChromeBroswer() throws Exception
	  {
		  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
			driver =new ChromeDriver();
			driver.manage().window().maximize() ;  
	  }
	  
	  
	  public  void OpenorangeHRM(String Test_URL1) throws Exception
	  {
		  driver.get(Test_URL1);  
	  }
	  
	  
	  public  void login(String UserName1,String Password1 ) throws Exception//step3
	  {
		  findElement(By.id("txtUsername")).sendKeys(UserName1);
			findElement(By.id("txtPassword")).sendKeys(Password1);
			findElement(By.id("btnLogin")).click();	  
	  }
	  
	  
	  public  void Qualifications (String Qualification_text1 ) throws Exception
	  {
		  findElement(By.id("menu_admin_viewAdminModule")).click();
			findElement(By.id("menu_admin_Qualifications")).click();
			findElement(By.id("menu_admin_viewEducation")).click();
			findElement(By.id("btnAdd")).click();
			findElement(By.id("education_name")).sendKeys(Qualification_text1);//step4
			findElement(By.id("btnSave")).click();  
	  }
	  
	  
	  public  void closeBrowser() throws Exception
	  {
		driver.quit();  
	  }
	  	
	  public static WebElement findElement(By by) throws Exception 
		{

			WebElement elem = driver.findElement(by);  
			
			if (driver instanceof JavascriptExecutor) 
			{
			 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
		 
			}
			return elem;
		}
		
		
  }

